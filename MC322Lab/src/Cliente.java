import java.util.Arrays;

//Declarações da Classe Cliente
public class Cliente {
	private String nome;
	private String data;
	private String endereco;
	private String cpf;
	private int idade;

//Construtor de Instâncias para a Classe Cliente
public Cliente(String nome, String data, String endereco, String cpf, int idade) {
	this.nome = nome;
	this.data = data;
	this.endereco = endereco;
	this.idade = idade;
	this.cpf = cpf;
}

//Getters da Classe Cliente (Retornam as informações sobre o cliente)
public String getNome() {
	return nome;
}
public String getData() {
	return data;
}
public String getEndereco() {
	return endereco;
}
public String getCpf() {
	return cpf;
}
public int getIdade() {
	return idade;
}

//Setters da Classe Cliente (Modificam os valores das informações sobre o cliente)
public void setNome(String nome) {
	this.nome = nome;
}
public void setData(String data) {
	this.data = data;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public void setIdade(int idade) {
	this.idade = idade;
}
//Função de validação do CPF
public boolean validarCPF(String cpf) {

	//Retirada dos caracteres não numéricos do CPF
	String cpfNum = cpf.replaceAll("[.-]","");

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

//Função que informa todas as informações públicas sobre o Cliente
public String toString(){ 
	return "\nAs informações inseridas para o cliente foram as seguintes:\nNome: "+this.getNome()+"\nData de nascimento: "+this.getData()+"\nEndereço: "+this.getEndereco()+"\nCPF: "+this.getCpf()+"\nIdade: "+this.getIdade();
}
	
}


