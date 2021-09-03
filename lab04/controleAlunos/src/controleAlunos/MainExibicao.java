package controleAlunos;
import java.util.Scanner;
/**
 * Classe responsável pela interação com o usuário.
 * 
 * @author Maria Luisa Dantas
 *
 */

public class MainExibicao{
	public static void main(String[] args) {
		
		OperacoesAlunos operacoesAlunos = new OperacoesAlunos();
		OperacoesGrupos operacoesGrupos = new OperacoesGrupos();
		
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha,operacoesAlunos,operacoesGrupos,scanner);
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
				"\n(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)lhaí quais Grupos o Aluno Tá.\n"
				+ "(S)im, quero fechar o programa!\n"
				+ "\n"
				+ "Opção>" );
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 * @param operacoesGrupos A classe que realiza operações relacionadas aos grupos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, OperacoesAlunos operacoesAlunos, OperacoesGrupos operacoesGrupos,Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(operacoesAlunos, scanner);
			break;
		case "E":
			exibeAluno(operacoesAlunos, scanner);
			break;
		case "N":
			cadastraGrupo(operacoesGrupos, scanner);
			break;
		case "A":
			alocaAluno(operacoesAlunos,operacoesGrupos, scanner);
			break;
		case "P":
			alunoNoGrupo(operacoesGrupos, scanner);
			break;
		case "R":
			alunoRespondeu(operacoesAlunos, scanner);
			break;
		case "I":
			listaResponderam(operacoesAlunos);
			break;
		case "O":
			listaGrupos(operacoesAlunos, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * sai da aplicação.
	 * */
	private static void sai() {
		System.exit(0);
	}
	
	/**
	 * Lista os grupos em que determinado aluno faz parte.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 *@param scanner Objeto scanner.
	 * */
	private static void listaGrupos(OperacoesAlunos operacoesAlunos, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.next();
		System.out.print(operacoesAlunos.listaGrupos(matricula));
	}

	/**
	 * Lista os alunos que responderam questoes no quadro.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 * */
	private static void listaResponderam(OperacoesAlunos operacoesAlunos) {
		System.out.print(operacoesAlunos.listaResponderam());
	}
	
	/**
	 * Registra que o aluno respondeu questões no quadro.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 *@param scanner Objeto scanner.
	 * */
	private static void alunoRespondeu(OperacoesAlunos operacoesAlunos, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.next();
		System.out.print(operacoesAlunos.alunoRespondeu(matricula));
		
	}
	
	/**
	 * Apresenta se um aluno pertence ou não a determinado grupo.
	 * 
	 * @param operacoesGrupos A classe que realiza operações relacionadas aos grupos.
	 * @param scanner Objeto scanner.
	 * */
	private static void alunoNoGrupo(OperacoesGrupos operacoesGrupos,
			Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nome = scanner.next();
		System.out.print("\nAluno: ");
		String matricula = scanner.next();
		System.out.print(operacoesGrupos.alunoNoGrupo(matricula, nome));
		
	}
	
	/**
	 * Cadastra um aluno no sistema.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 *@param scanner Objeto scanner.
	 * */
	private static void cadastraAluno(OperacoesAlunos operacoesAlunos, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.next();
		System.out.print("\nNome: ");
		String nome = scanner.next();
		System.out.print("\nCurso: ");
		String curso = scanner.next();
		
		if (operacoesAlunos.alunoJaCadastrado(matricula)) {
			System.out.print("\nMATRÍCULA JÁ CADASTRADA!");
		}
		else {
			operacoesAlunos.cadastraAluno(matricula, nome, curso);
			System.out.print("\nCADASTRO REALIZADO!");
		}
		return;
	}
	
	/**
	 * Exibe um aluno de acordo com a matrícula indicada.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 *@param scanner Objeto scanner.
	 * */
	private static void exibeAluno(OperacoesAlunos operacoesAlunos, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.next();
		System.out.print(operacoesAlunos.exibeAluno(matricula));
		return;
	}
	
	/**
	 * Cadastra um grupo no sistema.
	 * 
	 *@param operacoesGrupos A classe que realiza operações relacionadas aos grupos.
	 *@param scanner Objeto scanner.
	 * */
	private static void cadastraGrupo(OperacoesGrupos operacoesGrupos, Scanner scanner) {
		System.out.print("\nNome: ");
		String nome = scanner.next();
		System.out.print("\nTamanho: ");
		String numero = scanner.next();
		if (!numero.equals("-")) {
			int tamanho = Integer.parseInt(numero); 
			System.out.print(operacoesGrupos.cadastraGrupoTam(nome, tamanho));
			
		}
		else {
			System.out.print(operacoesGrupos.cadastraGrupo(nome));
		}
		return;
	}
	
	
	/**
	 * Aloca um aluno em determinado grupo.
	 * 
	 *@param operacoesAlunos A classe que realiza operações relacionadas aos alunos.
	 *@param operacoesGrupos A classe que realiza operações relacionadas aos grupos.
	 *@param scanner Objeto scanner.
	 * */
	private static void alocaAluno(OperacoesAlunos operacoesAlunos,OperacoesGrupos operacoesGrupos, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.next();
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.next();
		System.out.print(operacoesGrupos.alocaAluno(operacoesAlunos, matricula, nomeGrupo));
		
	}
	
	
}
