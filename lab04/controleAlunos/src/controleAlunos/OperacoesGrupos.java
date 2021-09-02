package controleAlunos;

/**
 * Classe responsável por realizar operações relacionadas aos grupos.
 * */
import java.util.HashMap;

public class OperacoesGrupos {
	
	/**
	 * Mapa que armazena os grupos, sendo as chaves o nome do grupo e o valor um objeto do tipo grupo.
	 * */
	private HashMap<String, Grupo> mapaGrupos = new HashMap<>();
	
	/**
	 * Construtor que inicializa todos os atributos da classe.
	 * */
	public OperacoesGrupos() {
		this.mapaGrupos = new HashMap<>();
	}

	/**
	 * Método que verifica se já existe algum grupo com determinado nome.
	 * 
	 * @param nome Nome do grupo
	 * @return retorna true se já existe um grupo cadastrado com esse nome e false caso contrario.
	 * */
	public boolean jaExiste(String nome) {
		if (this.mapaGrupos.containsKey(nome)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Método que cadastra um grupo no sistema.
	 * 
	 * @param nome Nome do grupo a ser cadastrado.
	 * @return saida Retorna uma String que representa se o cadastro foi realizado com sucesso ou não.
	 * */
	public String cadastraGrupo(String nome) {
		String saida = "";
		nome = nome.toLowerCase();
		if (jaExiste(nome)) {
			saida += "GRUPO JÁ CADASTRADO!\n";
		}
		else {
			Grupo grupo = new Grupo(nome);
			this.mapaGrupos.put(nome,grupo);
			saida += "CADASTRO REALIZADO!\n";
		}
		return saida;
	}
	
	/**
	 * Método que cadastra um grupo que tem restrição de quantidade de membros.
	 * 
	 * @param nome Nome do grupo a ser cadastrado.
	 * @param tamanho Tamanho do grupo.
	 * @return saida Retorna uma String que representa se o cadastro foi realizado com sucesso ou não.
	 * */
	public String cadastraGrupoTam(String nome, int tamanho) {
		String saida = "";
		nome = nome.toLowerCase();
		if (jaExiste(nome)) {
			saida += "GRUPO JÁ CADASTRADO!\n";
		}
		else {
			Grupo grupo = new Grupo(nome, tamanho);
			this.mapaGrupos.put(nome,grupo);
			saida += "CADASTRO REALIZADO!\n";
		}
		return saida;
	}
	
	
	/**
	 * Método que retorna um grupo
	 * 
	 * @param nomeGrupo Nome do grupo.
	 * @return retorna um Objeto do tipo Grupo.
	 * */
	public Grupo getGrupo(String nomeGrupo) {
		return this.mapaGrupos.get(nomeGrupo);
	}
	
	
	/**
	 * Método que adiciona um aluno a determinado grupo.
	 * 
	 * @param operacoesAlunos Classe responsável por operações relacionadas aos alunos.
	 * @param matricula Matricula do aluno.
	 * @param nomeGupo Nome do grupo.
	 * @return saida String que representa se a alocação foi realizada com sucesso ou não.
	 * */
	public String alocaAluno(OperacoesAlunos operacoesAlunos,String matricula, String nomeGrupo) {
		String saida = "";
		if (operacoesAlunos.alunoJaCadastrado(matricula)) {
			if (jaExiste(nomeGrupo)) {
				Grupo grupo = getGrupo(nomeGrupo);
				if (grupo.jaEhMembro(matricula)) {
					saida = "ALUNO ALOCADO";
				}
				else {
					if (grupo.temVaga()) {
						grupo.alocaAluno(matricula);
						Aluno aluno = operacoesAlunos.getAluno(matricula);
						aluno.addGrupo(nomeGrupo);
						saida = "ALUNO ALOCADO";
					}
					else {
						saida = "GRUPO CHEIO";
						}
				}
			}else {
				saida = "Grupo não cadastrado.";
			}
		}
		else{
			saida = "Aluno não cadastrado";
		}
		return saida;
			
		}
	
	
	/**
	 * Método que verifica se um aluno pertece ou não a determinado grupo.
	 * 
	 * @param matricula Matricula do aluno.
	 * @param nomeGrupo Nome do grupo.
	 * @return saida String que representa se o aluno pertece ou não a determinado grupo, ou uma mensagem
	 * caso os dados inseridos não sejam válidos.
	 * */
	public String alunoNoGrupo(String matricula, String nomeGrupo) {
		String saida = "";
		if (jaExiste(nomeGrupo)) {
			Grupo grupo = getGrupo(nomeGrupo);
			if (grupo.jaEhMembro(matricula)) {
				saida = "ALUNO PERTENCE AO GRUPO\n";
			}
			else {
				saida = "ALUNO NÃO PERTENCE AO GRUPO\n";
			}
		}
		else {
			saida = "GRUPO NÃO CADASTRADO";
		}
		return saida;
	}

	
}
