import java.util.ArrayList;

//Declarações da Classe Cliente
public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> veiculos;

//Construtor de Instâncias para a Classe Cliente
public Cliente(String nome, String endereco) {
	this.nome = nome;
	this.endereco = endereco;
	this.veiculos = new ArrayList<Veiculo>();
}

//Getters da Classe Cliente (Retornam as informações sobre o cliente)
public String getNome() {
	return nome;
}
public String getEndereco() {
	return endereco;
}
public ArrayList<Veiculo> getVeiculos() {
	return veiculos;
}


//Setters da Classe Cliente (Modificam os valores das informações sobre o cliente)
public void setNome(String nome) {
	this.nome = nome;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public void setVeiculos(ArrayList<Veiculo> veiculos) {
	this.veiculos = veiculos;
}

//Metodos do Cliente
public boolean cadastrarVeiculo(Veiculo veiculo){
	this.veiculos.add(veiculo);
	return true;
}

public String toString(){
	return "Nome: "+this.getNome()+"\nEndereco: "+this.getEndereco()+"\n";
}
}


