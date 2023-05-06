import java.util.Arrays;
import java.util.Date;

//Declarações da Classe Filha ClientePF
public class ClientePF extends Cliente {
    private final String cpf;
    private String genero;
    private String educacao;
    private String classeEconomica;
    private Date dataLicenca;
    private Date dataNascimento;

    //Construtor de Instâncias para a Classe ClientePF
    public ClientePF(String nome, String endereco, String cpf, String genero, String educacao, String classeEconomica, Date dataLicenca, Date dataNascimento) {
        
        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.dataLicenca = dataLicenca;
        this.dataNascimento = dataNascimento;

    }

    //Getters da Classe ClientePF (Retornam as informações sobre o cliente)
    public String getCpf() {
        return cpf;
    }
    public String getGenero() {
        return genero;
    }
    public String getEducacao() {
        return educacao;
    }
    public String getClasseEconomica() {
        return classeEconomica;
    }
    public Date getDataLicenca() {
        return dataLicenca;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }

    //Setters da Classe ClientePF (Modificam os valores das informações sobre o cliente)
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

//Função de validação do CPF
public boolean validarCPF(String cpf) {

	//Retirada dos caracteres não numéricos do CPF
	String cpfNum = cpf.replaceAll("[.-]","");

    if(cpfNum.length()!=11){
        return false;
    }

	//Declaração de array de inteiros para usar o CPF efetivamente
	int[] cpfInt = new int[11];

	//Conversão do CPF String para Array de inteiros
	cpfInt = Arrays.stream(cpfNum.split("")).mapToInt(Integer::parseInt).toArray();
	
	//Checagem da igualdade entre todos os valores do CPF
	if((cpfInt[0]==cpfInt[1])&&(cpfInt[1]==cpfInt[2])&&(cpfInt[2]==cpfInt[3])&&(cpfInt[3]==cpfInt[4])&&(cpfInt[4]==cpfInt[5])&&(cpfInt[5]==cpfInt[6])&&(cpfInt[6]==cpfInt[7])&&(cpfInt[7]==cpfInt[8])&&(cpfInt[8]==cpfInt[9])&&(cpfInt[9]==cpfInt[10])){
		return false;
	}

	//Validação do primeiro dígito verificador do CPF
	int resto1 = (10*cpfInt[0]+9*cpfInt[1]+8*cpfInt[2]+7*cpfInt[3]+6*cpfInt[4]+5*cpfInt[5]+4*cpfInt[6]+3*cpfInt[7]+2*cpfInt[8])%11;
	if((resto1<2)&&(cpfInt[9]!=0)){
		return false;
	}
	if((resto1>=2)&&(cpfInt[9]!=11-resto1)){
		return false;
	}

	//Validação do segundo dígito verificador do CPF
	int resto2 = (11*cpfInt[0]+10*cpfInt[1]+9*cpfInt[2]+8*cpfInt[3]+7*cpfInt[4]+6*cpfInt[5]+5*cpfInt[6]+4*cpfInt[7]+3*cpfInt[8]+2*cpfInt[9])%11;
	if((resto2<2)&&(cpfInt[10]!=0)){
		return false;
	}
	if((resto2>=2)&&(cpfInt[10]!=11-resto2)){
		return false;
	}
	return true;
}

//Função que informa todas as informações públicas sobre o ClientePF
public String toString(){ 
    return "Nome: "+this.getNome()+"\nEndereco: "+this.getEndereco()+"\nCPF: "+this.getCpf()+"\nGenero: "+this.getGenero()+"\nEducacao: "+this.getEducacao()+"\nClasse Economica: "+this.getClasseEconomica()+"\nData da Licenca: "+this.getDataLicenca()+"\nData de Nascimento: "+this.getDataNascimento()+"\n";
}
}