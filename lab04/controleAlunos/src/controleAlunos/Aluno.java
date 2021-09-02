package controleAlunos;

/**
 * Classe que possui as informações do aluno.
 * */
import java.util.ArrayList;

public class Aluno {
	
	/**
	 * Numero da matricula do aluno.
	 * */
	private String matricula;
	
	/**
	 * Nome do aluno.
	 * */
	private String nome;
	
	/**
	 * Curso do aluno.
	 * */
	private String curso;
	
	/**
	 * Grupos em que o aluno faz parte.
	 * */
	private ArrayList<String>grupos = new ArrayList<String>();
	
	/**
	 * Construtor que inicializa todos os parâmetros da classe Aluno.
	 * 
	 * @param matricula Matricula do aluno
	 * @param nome Nome do aluno
	 * @param curso Curso do aluno
	 * */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.grupos = new ArrayList<String>();
	}
	
	/**
	 * Método que retorna o nome do aluno
	 * 
	 * @return retorna o nome do aluno.
	 * */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método que retorna o curso do aluno.
	 * 
	 * @return retorna o curso do aluno.
	 * */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * Método que retorna a matricula do aluno
	 * 
	 * @return retorna a matricula do aluno
	 * */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Método que adiciona um grupo em que o aluno faz parte a sua lista de grupos.
	 * */
	public void addGrupo(String nomeGrupo) {
		grupos.add(nomeGrupo);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getGrupos(){
		return (ArrayList<String>) grupos.clone();
	}
	
	/**
	 * Retorna o identificador unico do aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara dois objetos Aluno, dois alunos são iguais apenas se tiverem a mesma matricula.
	 */
	@Override
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno a = (Aluno) o;
        if(matricula.equals(a.matricula)){
        	return true;
        }
        return false;
    }

}
