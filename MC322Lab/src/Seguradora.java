//Declarações da Classe Seguradora
public class Seguradora{
	private String nome;
	private String telefone;
	private String email;
	private String endereco;

//Construtor de Instâncias para a Classe Seguradora
public Seguradora(String nome, String telefone, String email, String endereco){
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
}

//Getters e Setters da Classe Seguradora (Getters retornam as informações sobre a seguradora e Setters modificam os valores das informações sobre a seguradora)
public String getNome(){
return nome;
}
public void setNome(String nome){
this.nome = nome;
}
public String getTelefone(){
return telefone;
}
public void setTelefone(String telefone){
this.telefone = telefone;
}
public String getEmail(){
return email;
}
public void setEmail(String email){
this.email = email;
}
public String getEndereco(){
return endereco;
}
public void setEndereco(String endereco){
this.endereco = endereco;
}

}