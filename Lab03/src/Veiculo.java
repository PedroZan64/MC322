//Declarações da Classe Veiculo
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;

//Construtor de Instâncias para a Classe Veiculo
public Veiculo(String placa, String marca, String modelo){ 
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
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

}
