import java.util.*;  

public class Main {

	public static void main(String[] args) {
		//Declaração das instâncias e variáveis utilizadas
		String input;
		Cliente cliente;
		Sinistro sinistro;
		Seguradora seguradora;
		Veiculo veiculo;

		//Mensagem inicial
		System.out.println("Ola, insira um comando para iniciar uma das ações, envie 'ajuda' para descobrir os comandos disponíveis\n");

		//Declaração do Scanner
		Scanner scan = new Scanner(System.in);

		//Ciclo para funcionamento
		while(true){

			//Recepção do input do usuário
			input = scan.nextLine();

			//Ifs para saber qual função executar de acordo com os comandos disponíveis

			//Função que lista os comandos disponíveis
			if(input.equals("ajuda")){
				System.out.println("\nOs seguintes comandos estão disponíveis:\n'registrar cliente': como o nome sugere, inicia o registro de um novo cliente\n'registrar veiculo': como o nome sugere, inicia o registro de um novo veiculo\n'registrar seguradora': como o nome sugere, inicia o registro de uma nova seguradora\n'registrar sinistro': como o nome sugere, inicia o registro de um novo sinistro\n'finalizar': encerra as operações desse programa\n");
			}
			
			//Função para registrar o cliente
			else if(input.equals("registrar cliente")){
				System.out.println("\nVocê selecionou a opção 'registrar cliente'\n");
				System.out.println("Insira respectivamente o nome, a data de nascimento, o endereço, o cpf e a idade do cliente que deseja cadastrar\n");
				cliente = new Cliente(scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextInt());
				System.out.println(cliente.toString());

				//Validação do CPF
				if(cliente.validarCPF(cliente.getCpf())){
					System.out.println("O CPF inserido para esse cliente é válido\n");
				}
				else{
					System.out.println("O CPF inserido para esse cliente é inválido\n");
				}
			}

			//Função para registrar o veiculo
			else if(input.equals("registrar veiculo")){
				System.out.println("\nVocê selecionou a opção 'registrar veiculo'\n");
				System.out.println("Insira respectivamente a placa, a marca e o modelo para o veículo que deseja cadastrar\n");
				veiculo = new Veiculo(scan.nextLine(),scan.nextLine(),scan.nextLine());
				System.out.println("\nAs informações inseridas para o veículo foram as seguintes:\nPlaca: "+veiculo.getPlaca()+"\nMarca: "+veiculo.getMarca()+"\nModelo: "+veiculo.getModelo());
			}

			//Função para registrar a seguradora
			else if(input.equals("registrar seguradora")){
				System.out.println("\nVocê selecionou a opção 'registrar seguradora'\n");
				System.out.println("Insira respectivamente o nome, o telefone, o e-mail e o endereço da seguradora que deseja cadastrar\n");
				seguradora = new Seguradora(scan.nextLine(),scan.nextLine(),scan.nextLine(),scan.nextLine());
				System.out.println("\nAs informações inseridas para a seguradora foram as seguintes:\nNome: "+seguradora.getNome()+"\nTelefone: "+seguradora.getTelefone()+"\nE-mail: "+seguradora.getEmail()+"\nEndereço: "+seguradora.getEndereco());
			}

			//Função para registrar o sinistro
			else if(input.equals("registrar sinistro")){
				System.out.println("\nVocê selecionou a opção 'registrar sinistro'\n");
				System.out.println("Insira respectivamente a data de acontecimento e o endereço do sinistro que deseja cadastrar\n");
				sinistro = new Sinistro(scan.nextLine(),scan.nextLine());
				System.out.println("\nAs informações inseridas para o sinistro foram as seguintes:\nData de acontecimento: "+sinistro.getData()+"\nEndereço: "+sinistro.getEndereco()+"\nID gerado: "+sinistro.getId());
			}

			//Função para finalizar a execução do programa
			else if(input.equals("finalizar")){
				System.out.println("\nVocê selecionou a opção 'finalizar'\n");
				break;
			}
		}

		
	}
	
}
