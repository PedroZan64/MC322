import java.util.Date;

//Declarações da Classe Sinistro
public class Sinistro {
	private Date data;
	private String endereco;
	private final int id;
	private static int sinistros = 0;

	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

//Construtor de Instâncias para a Classe Sinistro
public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){ 
	this.data = data;
	this.endereco = endereco;
	this.id = sinistros;
	this.seguradora = seguradora;
	this.veiculo = veiculo;
	this.cliente = cliente;
	sinistros = sinistros + 1;
}

//Getters da Classe Sinistro (Retornam as informações sobre o sinistro)
public Date getData() {
	return data;
}
public String getEndereco() {
	return endereco;
}
public Seguradora getSeguradora() {
	return seguradora;
}
public Veiculo getVeiculo() {
	return veiculo;
}
public Cliente getCliente() {
	return cliente;
}
public int getId() {
	return id;
}

//Setters da Classe Sinistro (Modificam os valores das informações sobre o sinistro)
public void setData(Date data) {
	this.data = data;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public void setSeguradora(Seguradora seguradora) {
	this.seguradora = seguradora;
}
public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

//Função que informa todas as informações públicas sobre o Sinistro
public String toString(){ 
	return "\nSeguradora: "+this.getSeguradora().getNome()+"\nPlaca do Veiculo: "+this.getVeiculo().getPlaca()+"\nCliente: "+this.getCliente().getNome()+"\nData: "+this.getData()+"\nEndereco: "+this.getEndereco()+"\n";
}
}
