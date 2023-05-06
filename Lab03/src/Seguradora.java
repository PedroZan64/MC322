import java.util.*;
import java.util.Date;
import java.util.Calendar;  

//Declarações da Classe Seguradora
public class Seguradora{
	private String nome;
	private String telefone;
	private String email;
	private String endereco;

	private ArrayList<Cliente> listaClientes;
	private ArrayList<Sinistro> listaSinistros;

//Construtor de Instâncias para a Classe Seguradora
public Seguradora(String nome, String telefone, String email, String endereco){
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
	this.listaClientes = new ArrayList<Cliente>();
	this.listaSinistros = new ArrayList<Sinistro>();
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

public ArrayList<Cliente> getListaClientes(){
return listaClientes;
}
public void setListaClientes(ArrayList<Cliente> listaClientes){
this.listaClientes = listaClientes;
}

public ArrayList<Sinistro> getListaSinistros(){
return listaSinistros;
}
public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
this.listaSinistros = listaSinistros;
}

//Metodos da Seguradora
public boolean cadastrarCliente(Cliente cliente){
	this.listaClientes.add(cliente);
	return true;
}

public boolean removerCliente(String cliente){
	for(int i = 0; i < this.listaClientes.size(); i++){
		if(this.listaClientes.get(i).getNome().equals(cliente)){
			this.listaClientes.remove(i);
			return true;
		}
	}
	return false;
}

public void listarClientes(){
	System.out.println("Os Clientes cadastrados sao:\n");
	for(int i = 0; i < this.listaClientes.size(); i++){
		System.out.println(this.listaClientes.get(i).getNome());
	}
}

public boolean gerarSinistro(){
	System.out.println("Insira respectivamente a data (primeiro o dia, depois o mes e depois o ano do ocorrido), endereco, nome do cliente e placa do veiculo envolvidos nesse sinistro\n");
	Scanner scan = new Scanner(System.in);

	int dia = Integer.parseInt(scan.nextLine());
	int mes = Integer.parseInt(scan.nextLine());
	int ano = Integer.parseInt(scan.nextLine());
	Calendar tempo = Calendar.getInstance();
	tempo.set(ano, mes, dia);
	Date data = tempo.getTime();

	String endereco1 = scan.nextLine();

	String nomeEntrada = scan.nextLine();
	Cliente cliente = null;
	for(int i = 0; i < this.listaClientes.size(); i++){
		if(nomeEntrada.equals(this.listaClientes.get(i).getNome())){
			cliente = this.listaClientes.get(i);
			break;
		}
	}
	if(cliente==null){
		return false;
	}

	String placaEntrada = scan.nextLine();
	Veiculo veiculo = null;
	for(int i = 0; i < cliente.getVeiculos().size(); i++){
		if(cliente.getVeiculos().get(i).getPlaca().equals(placaEntrada)){
			veiculo = cliente.getVeiculos().get(i);
			break;
		}
	}
	if(veiculo==null){
		return false;
	}
	this.listaSinistros.add(new Sinistro(data, endereco1, this, veiculo, cliente));
	return true;
}

public void listarSinistros(){
	System.out.println("Lista de Sinistros:\n");
	int j = 0;
	for(int i = 0; i < this.listaSinistros.size(); i++){
		if(this.listaSinistros.get(i)!=null){
			j++;
			System.out.println("Sinistro numero "+String.valueOf(j)+": ocorrido na data "+this.listaSinistros.get(i).getData()+", no endereco "+this.listaSinistros.get(i).getEndereco()+", com o carro de placa "+this.listaSinistros.get(i).getVeiculo().getPlaca()+", envolvendo o cliente "+this.listaSinistros.get(i).getCliente().getNome()+"\n");
		}
	}
}

public boolean visualizarSinistro(String cliente){
	boolean aux = false;
	for(int i = 0; i < this.listaSinistros.size(); i++){
		if(this.listaSinistros.get(i)!=null && this.listaSinistros.get(i).getCliente().getNome().equals(cliente)){
			aux = true;
			System.out.println("Sinistro ocorrido na data "+this.listaSinistros.get(i).getData()+", no endereco "+this.listaSinistros.get(i).getEndereco()+", com o carro de placa "+this.listaSinistros.get(i).getVeiculo().getPlaca()+"\n");
		}
	}
	if(aux){
		return true;
	}
	else{
		return false;
	}
}

public boolean cadastrarVeiculo(Veiculo veiculo, String cliente){
	System.out.println(String.valueOf(this.listaClientes.size()));
	for(int i = 0; i < this.listaClientes.size(); i++){
		System.out.println(String.valueOf(this.listaClientes.get(i).cadastrarVeiculo(veiculo)));
		if(this.listaClientes.get(i).getNome().equals(cliente) && this.listaClientes.get(i).cadastrarVeiculo(veiculo)){
			return true;
		}
	}
	return false;
}

public String toString(){
	return "Nome: "+this.getNome()+"\nTelefone: "+this.getTelefone()+"\nEmail: "+this.getEmail()+"\nEndereco: "+this.getEndereco()+"\n";
}
}