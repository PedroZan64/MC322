//Declarações da Classe Veiculo
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;

//Construtor de Instâncias para a Classe Veiculo
public Veiculo(String placa, String marca, String modelo, int anoFabricacao){ 
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
	this.anoFabricacao = anoFabricacao;
}

//Getters da Classe Veiculo (Retornam as informações sobre o veiculo)
public String getPlaca() {
	return placa;
}
public String getMarca() {
	return marca;
}
public String getModelo() {
	return modelo;
}
public int getAnoFabricacao() {
	return anoFabricacao;
}

//Setters da Classe Veiculo (Modificam os valores das informações sobre o veiculo)
public void setPlaca(String placa) {
	this.placa = placa;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public void setAnoFabricacao(int anoFabricacao) {
	this.anoFabricacao = anoFabricacao;
}

//Função que informa todas as informações públicas sobre o Veiculo
public String toString(){ 
	return "Placa :"+this.getPlaca()+"\nMarca: "+this.getMarca()+"\nModelo: "+this.getModelo()+"\nAno de Fabricacao: "+String.valueOf(this.getAnoFabricacao())+"\n";
}
}
