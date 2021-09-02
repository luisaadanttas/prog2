package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Maria Luisa Moraes Monteiro Dantas- 120210152
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n"+
						"(A)dicionar Favorito\n"+
						"(S)air\n" + 
						"(T)ags\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			exibeFavoritos(agenda);
			break;
		case "A":
			favoritaContato(agenda, scanner);
			break;
		case "T":
			cadastraTag(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}


	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		} 
	}
	
	
	/**
	 * Exibe os contatos que foram favoritados.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * */
	private static void exibeFavoritos(Agenda agenda) {
		Contato[] favoritos = agenda.getFavoritos();
		for(Contato contato:favoritos) {
			if(contato != null) {
				System.out.println(contato.getPosicao() + " - " + contato.getNome() + " " + contato.getSobrenome());
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		
		if (agenda.getContato(posicao)==null) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}
		else {
			System.out.println(agenda.exibeContato(posicao));
		}
	}
	
	/**
	 * Favorita um contato.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para capturar qual contato deve ser favoritado.
	 * */
	private static void favoritaContato(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nContato> ");
		int contatoPosicao = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int favoritoPosicao = scanner.nextInt();
		
		if (agenda.adicionaFavorito(contatoPosicao, favoritoPosicao)) {
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO "+ favoritoPosicao+"!");
			return;
		}
		
	}
	
	
	/**
	 * Cadastra tag relacionada à um ou mais contatos.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para capturar os contatos que serão manipulados e as tags que serão associadas.
	 * */
	private static void cadastraTag(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nContato(s)> ");
		scanner.nextLine();
		String numeros = scanner.nextLine();
		String contatos[] = numeros.split(" ");
		
		
		System.out.print("\nTag> ");
		String tagNome = scanner.next();
		
		System.out.print("\nPosicao Tag> ");
		int posicaoTag = scanner.nextInt();
		
		agenda.cadastraTag(contatos, tagNome, posicaoTag);

	}
	

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		
		
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();	
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.next();
		System.out.print("\nTelefone> ");
		String telefone = scanner.next();
		
		if (posicao > 100 || posicao < 1) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}
		else {
			
			if (agenda.jaExiste(nome, sobrenome)) {
				System.out.println("CONTATO JA CADASTRADO");
				return;
			}
			if (nome == null || telefone == null) {
				System.out.println("CONTATO INVALIDO");
				return;
			}
			else {
				agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				System.out.println("CADASTRO REALIZADO");
				return;

			}
			
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
