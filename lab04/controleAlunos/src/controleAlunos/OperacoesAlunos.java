package controleAlunos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe responsável por operações relacionadas aos alunos.
 * 
 * @author Maria Luisa Moraes Monteiro Dantas.
 * */

public class OperacoesAlunos {
	
	/**
	 * Mapa que armazena os alunos(valores) de acordo com suas matriculas(keys).
	 * */
	private HashMap<String, Aluno> mapaMatriculaAlunos = new HashMap<>();
	
	/**
	 * HashSet/conjunto que armazena todas as matriculas no sistema. 
	 * */
	private HashSet<String> matriculas = new HashSet<>();
	
	/**
	 * ArrayList que armazena todos os alunos que responderam questões no quadro.
	 * */
	private ArrayList<Aluno> respondemQuestoes = new ArrayList<>();
	
	/**
	 * Construtor responsável por inicializar os atributos da classe.
	 * */
	public OperacoesAlunos() {
		this.mapaMatriculaAlunos = new HashMap<>();
		this.matriculas = new HashSet<>();
		this.respondemQuestoes = new ArrayList<>();
	}

	/**
	 * Cadastra aluno no sistema.
	 * 
	 * @param matricula numero da matricula do aluno.
	 * @param nome nome do aluno.
	 * @param curso curso do aluno.
	 * */
	public void cadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(matricula, nome, curso);
		this.mapaMatriculaAlunos.put(matricula, aluno);
		this.matriculas.add(matricula);
	}
	
	/**
	 * Verifica se o aluno ja está cadastrado no sistema a partir da matricula fornecida.
	 * 
	 * @param matricula matricula do aluno.
	 * @return retorna True se o aluno ja está cadastrado e False caso contrário.
	 * */
	public boolean alunoJaCadastrado(String matricula) {
		if (this.matriculas.contains(matricula)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Retorna um aluno a partir de uma matricula.
	 * 
	 * @param matricula matricula do aluno.
	 * @return retorna um aluno do tipo Aluno.
	 * */
	public Aluno getAluno(String matricula) {
		return this.mapaMatriculaAlunos.get(matricula);
	}
	
	
	/**
	 * Método que exibe um aluno a partir de uma matricula.
	 * 
	 * @param matricula matricula do aluno.
	 * @return saida String que mostrará o aluno e seus dados, ou uma mensagem caso o aluno ainda não tenha sido
	 * cadastrado com a matricula indicada.
	 * */
	public String exibeAluno(String matricula) {
		String saida = "";
		
		if (alunoJaCadastrado(matricula)) {
			Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
			saida += "\nAluno: " + matricula + " - " + aluno.getNome() + " - " + aluno.getCurso();
		}
		else {
			saida += "Matrícula: " + matricula;
			saida += "\nAluno não cadastrado.";
		}
		return saida;
		
	}
	
	
	/**
	 * Método que registra que um aluno respondeu questões no quadro.
	 * 
	 * @param matricula matricula do aluno.
	 * @return saida String que apresentará uma mensagem de confirmação de registro ou uma mensagem
	 * de erro caso a matricula não exista no sistema.
	 * */
	public String alunoRespondeu(String matricula) {
		String saida = "";
		if (alunoJaCadastrado(matricula)) {
			Aluno aluno = getAluno(matricula);
			this.respondemQuestoes.add(aluno);
			saida = "ALUNO REGISTRADO!\n";
		}
		else {
			saida = "Aluno não cadastrado\n";
		}
		return saida;
	}
	
	
	/**
	 * Método que apresenta a lista de alunos que responderam questões no quadro.
	 * 
	 * @reuturn saida String que representa a lista de alunos que responderam questões no quadro.
	 * */
	public String listaResponderam() {
		String saida = "";
		for (int i = 0; i < respondemQuestoes.size(); i++) {
			String posicao = Integer.toString(i+1);
			Aluno aluno = respondemQuestoes.get(i);
			saida += posicao  + ". " + aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso() + "\n";
		}
		return saida;
	}
	
	/**
	 * Método que lista os grupos em que determinado aluno faz parte.
	 * 
	 * @param matricula matricula do aluno.
	 * @return saida String que representa a lista de grupos que esse aluno faz parte.
	 * */
	public String listaGrupos(String matricula) {
		String saida = "\nGrupos:";
		Aluno aluno = getAluno(matricula);
		ArrayList<String> grupos = aluno.getGrupos();
		if (!grupos.isEmpty()) {
			for (String nome:grupos) {
				saida += "\n- " + nome;
			}
		}
		return saida;
	}
}