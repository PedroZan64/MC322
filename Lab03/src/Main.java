import java.util.*;  

public class Main {

	public static void main(String[] args) {
		//Declaração das instâncias e variáveis utilizadas
		String input;
		Cliente cliente;
		Veiculo veiculo;
		Date dataaux = null;
		ClientePF clienteaux1 = new ClientePF("", "", "", "", "", "", dataaux, dataaux);
		ClientePJ clienteaux2 = new ClientePJ("", "", "", dataaux);
		Seguradora seguradora;

		//Declaração do Scanner
		Scanner scan = new Scanner(System.in);
		
		//Iniciando a seguradora
		System.out.println("Ola, vamos iniciar cadastrando a sua seguradora! Digite e dê enter nos nomes das respectivas informações de sua seguradora: Nome, telefone, email e endereço.\n");
		seguradora = new Seguradora(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
		
		//Inicio dos comandos
		System.out.println("Agora insira um comando para iniciar uma das ações, envie 'ajuda' para descobrir os comandos disponíveis\n");
		
		//Ciclo para funcionamento
		while(true){
			//Recepção do input do usuário
			input = scan.nextLine();

			//Ifs para saber qual função executar de acordo com os comandos disponíveis
			if(input.equals("ajuda")){
				System.out.println("\nOs seguintes comandos estão disponíveis:\n'cadastrar cliente': como o nome sugere, inicia o cadastro de um novo cliente\n'cadastrar veiculo': como o nome sugere, inicia o cadastro de um veiculo para um cliente\n'remover cliente': como o nome sugere, remove o cadastro de um cliente\n'listar clientes': como o nome sugere, entrega a lista de clientes\n'gerar sinistro': como o nome sugere, inicia o registro de um novo sinistro\n'listar sinistros': como o nome sugere, entrega a lista de sinistros\n'visualizar sinistro': retorna as informacoes sobre sinistro de dado cliente\n'finalizar': encerra as operações desse programa\n");
			}
			else if(input.equals("cadastrar veiculo")){
				System.out.println("Insira as respectivas informacoes do veiculo: placa, marca, modelo e ano de fabricacao\n");
				veiculo = new Veiculo(scan.nextLine(), scan.nextLine(), scan.nextLine(), Integer.parseInt(scan.nextLine()));
				System.out.println("Agora envie o nome do cliente para quem deseja cadastrar o veiculo\n");
				if(seguradora.cadastrarVeiculo(veiculo, scan.nextLine())){
					System.out.println("Cadastro de veiculo feito com sucesso\n");
				}
				else{
					System.out.println("Nao foi possivel cadastrar o veiculo\n");
				}

			}
			else if(input.equals("cadastrar cliente")){
				boolean i;
				System.out.println("Digite e dê enter em 1 se o cliente for uma pessoa física e 2 se o cliente for uma pessoa jurídica\n");
				input = scan.nextLine();
				if(input.equals("1")){
					System.out.println("Insira e dê enter nas respectivas informações do cliente: data de licenca, data de nascimento (ambas enviando o dia, mes e ano respectivamente e dando enter entre cada numero), cpf, nome, endereco, genero, educacao e classe economica\n");
					
					Calendar tempo = Calendar.getInstance();
					int dia = Integer.parseInt(scan.nextLine());
					int mes = Integer.parseInt(scan.nextLine());
					int ano = Integer.parseInt(scan.nextLine());
					tempo.set(ano, mes, dia);
					Date dataLicenca = tempo.getTime();
					dia = Integer.parseInt(scan.nextLine());
					mes = Integer.parseInt(scan.nextLine());
					ano = Integer.parseInt(scan.nextLine());
					tempo.set(ano, mes, dia);
					Date dataNascimento = tempo.getTime();

					String cpf = scan.nextLine();
					while(clienteaux1.validarCPF(cpf)==false){
						System.out.println("CNPJ invalido, insira um CNPJ valido para continuar\n");
						cpf = scan.nextLine();
					}


					cliente = new ClientePF(scan.nextLine(), scan.nextLine(), cpf, scan.nextLine(), scan.nextLine(), scan.nextLine(), dataLicenca, dataNascimento);

					i = seguradora.cadastrarCliente(cliente);
					if(i){
						System.out.println("Cliente cadastrado com sucesso\n");
					}
					else{
						System.out.println("Nao foi possivel cadastrar o cliente\n");
					}
				}
				else if(input.equals("2")){
					System.out.println("Insira e dê enter nas respectivas informações do cliente: data de Fundacao(insira o dia, mes e ano respectivamente e dê enter entre cada numero), cnpj, nome e endereco\n");

					Calendar tempo = Calendar.getInstance();
					int dia = Integer.parseInt(scan.nextLine());
					int mes = Integer.parseInt(scan.nextLine());
					int ano = Integer.parseInt(scan.nextLine());
					tempo.set(ano, mes, dia);
					Date dataFundacao = tempo.getTime();

					String cnpj = scan.nextLine();
					while(clienteaux2.validarCNPJ(cnpj)==false){
						System.out.println("CNPJ invalido, insira um CNPJ valido para continuar\n");
						cnpj = scan.nextLine();
					}

					cliente = new ClientePJ(scan.nextLine(), scan.nextLine(), cnpj, dataFundacao);
					i = seguradora.cadastrarCliente(cliente);
					if(i){
						System.out.println("Cliente cadastrado com sucesso\n");
					}
					else{
						System.out.println("Nao foi possivel cadastrar o cliente\n");
					}
				}
				else{
					System.out.println("Entrada inválida, insira um novo comando\n");
				}
			}

			else if(input.equals("remover cliente")){
				System.out.println("Insira o nome do cliente que deseja remover\n");

				if(seguradora.removerCliente(scan.nextLine())){
					System.out.println("O cliente foi encontrado e removido\n");
				}
				else{
					System.out.println("O cliente nao foi encontrado\n");
				}
			}

			else if(input.equals("gerar sinistro")){
				boolean i = seguradora.gerarSinistro();
				if(i){
					System.out.println("Sinistro gerado com sucesso\n");
				}
				else{
					System.out.println("Nao foi possivel gerar o sinistro\n");
				}
			}

			else if(input.equals("visualizar sinistro")){
				boolean i;
				System.out.println("Insira o nome do cliente para visualizar seus sinistros\n");
				i = seguradora.visualizarSinistro(scan.nextLine());
				if(i==false){
					System.out.println("Nao foi possivel encontrar sinistros que envolvam esse cliente\n");
				}
			}

			else if(input.equals("listar sinistros")){
				seguradora.listarSinistros();
			}

			else if(input.equals("listar clientes")){
				seguradora.listarClientes();
			}

			//Elsif para finalizar a execução do programa
			else if(input.equals("finalizar")){
				System.out.println("\nVocê selecionou a opção 'finalizar'\n");
				break;
			}

			//Else para entradas inválidas
			else{
				System.out.println("Entrada inválida\n");
			}
		}
		scan.close();
	}
}
