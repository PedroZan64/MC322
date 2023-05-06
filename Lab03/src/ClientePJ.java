import java.util.Arrays;
import java.util.Date;

//Declarações da Classe Filha ClientePJ
public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;

	//Construtor de Instâncias para a Classe ClientePJ
    public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;

    }

	//Getters da Classe ClientePJ (Retornam as informações sobre o cliente)
    public String getCNPJ() {
        return cnpj;
    }
	public Date getDataFundacao() {
        return dataFundacao;
    }

	//Setters da Classe ClientePJ (Modificam os valores das informações sobre o cliente)
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

	//Função de validação do CNPJ
	public boolean validarCNPJ(String cnpj) {

	//Retirada dos caracteres não numéricos do CNPJ
	String cnpjNum = cnpj.replaceAll("\\D","");

	//Declaração de array de inteiros para usar o CNPJ efetivamente
	int[] cnpjInt = new int[14];

	if(cnpjNum.length()!=14){
        return false;
    }

	//Conversão do CNPJ String para Array de inteiros
	cnpjInt = Arrays.stream(cnpjNum.split("")).mapToInt(Integer::parseInt).toArray();
	
	//Checagem da igualdade entre todos os valores do CNPJ
	if((cnpjInt[0]==cnpjInt[1])&&(cnpjInt[1]==cnpjInt[2])&&(cnpjInt[2]==cnpjInt[3])&&(cnpjInt[3]==cnpjInt[4])&&(cnpjInt[4]==cnpjInt[5])&&(cnpjInt[5]==cnpjInt[6])&&(cnpjInt[6]==cnpjInt[7])&&(cnpjInt[7]==cnpjInt[8])&&(cnpjInt[8]==cnpjInt[9])&&(cnpjInt[9]==cnpjInt[10])){
		return false;
	}

	//Validação do primeiro dígito verificador do CNPJ
	int resto1 = (5*cnpjInt[0]+4*cnpjInt[1]+3*cnpjInt[2]+2*cnpjInt[3]+9*cnpjInt[4]+8*cnpjInt[5]+7*cnpjInt[6]+6*cnpjInt[7]+5*cnpjInt[8]+4*cnpjInt[9]+3*cnpjInt[10]+2*cnpjInt[11])%11;
	if((resto1<2)&&(cnpjInt[12]!=0)){
		return false;
	}
	if((resto1>=2)&&(cnpjInt[12]!=11-resto1)){
		return false;
	}

	//Validação do segundo dígito verificador do CNPJ
	int resto2 = (6*cnpjInt[0]+5*cnpjInt[1]+4*cnpjInt[2]+3*cnpjInt[3]+2*cnpjInt[4]+9*cnpjInt[5]+8*cnpjInt[6]+7*cnpjInt[7]+6*cnpjInt[8]+5*cnpjInt[9]+4*cnpjInt[10]+3*cnpjInt[11]+2*cnpjInt[12])%11;
	if((resto2<2)&&(cnpjInt[13]!=0)){
		return false;
	}
	if((resto2>=2)&&(cnpjInt[13]!=11-resto2)){
		return false;
	}
	return true;
}

//Função que informa todas as informações públicas sobre o ClientePJ
public String toString(){ 
    return "Nome: "+this.getNome()+"\nEndereco: "+this.getEndereco()+"\nCNPJ: "+this.getCNPJ()+"Data de Fundacao: "+this.getDataFundacao()+"\n";
}
}
