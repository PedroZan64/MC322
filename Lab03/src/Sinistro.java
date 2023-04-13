//Declarações da Classe Sinistro
public class Sinistro {
	private String data;
	private String endereco;
	private int id;
	private static int Sinistros = 0;

//Construtor de Instâncias para a Classe Sinistro
public Sinistro(String data, String endereco){ 
	this.data = data;
	this.endereco = endereco;
	this.id = Sinistros;
	Sinistros = Sinistros + 1;
}

//Getters da Classe Sinistro (Retornam as informações sobre o sinistro)
public String getData() {
	return data;
}
public String getEndereco() {
	return endereco;
}
public int getId() {
	return id;
}

//Setters da Classe Sinistro (Modificam os valores das informações sobre o sinistro)
public void setData(String data) {
	this.data = data;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public void setId(int id) {
	this.id = id;
}

}
