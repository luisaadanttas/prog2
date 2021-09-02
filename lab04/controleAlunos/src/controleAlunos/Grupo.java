package controleAlunos;

import java.util.ArrayList;

/**
 * Classe que possui dados dos grupos.
 * */

public class Grupo {
	
	/**
	 * Nome do grupo.
	 * */
	private String nome;
	
	/**
	 * Tamanho do grupo.
	 * */
	private int tamanho;
	
	/**
	 * Se o grupo tem limite de membros ou não.
	 * */
	private boolean temLimite = false;
	
	/**
	 * Membros do grupo.
	 * */
	private ArrayList<String> membros = new ArrayList<>();
	
	
	/**
	 * Construtor que inicializa os atributos de um grupo que tem limite de membros. 
	 * */
	Grupo(String nome, int tamanho){
		this.nome = nome;
		this.tamanho = tamanho;
		this.temLimite = true;
	}
	
	/**
	 * Construtor que inicializa os atributos de um grupo sem limite de membros.
	 * */
	Grupo(String nome){
		this.nome = nome;
		this.temLimite = false;
	}
	
	/**
	 * Método que verifica se o grupo tem vaga para mais membros.
	 * 
	 * @return retorna true se tiver vaga e falso caso contrário.
	 * */
	public boolean temVaga() {
		if (this.temLimite && membros.size() >= tamanho) {
			return false;
		}
		return true;
	}
	
	/**
	 * Método que verifica se um aluno já é membro do grupo.
	 * 
	 * @param matricula Matricula do aluno.
	 * @return retorna true se o aluno já fizer parte do grupo e false caso contrário.
	 * */
	public boolean jaEhMembro(String matricula){
		boolean jaEh = false;
		for (String i:membros) {
			if (matricula.equals(i)) {
				jaEh = true;
			}
		}
		return jaEh;
	}
	
	/**
	 * Método que adiciona um aluno ao grupo.
	 * 
	 * @param matricula Matricula do aluno.
	 * */
	public void alocaAluno(String matricula) {
		this.membros.add(matricula);
	}
	
	/**
	 * Retorna o identificador unico do grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Compara dois objetos Grupo.Dois grupos são iguais apenas se tiverem o mesmo nome.
	 */
	@Override
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Grupo)) {
            return false;
        }
        Grupo g = (Grupo) o;
        if(nome.equals(g.nome)){
        	return true;
        }
        return false;
    }
	
	
	
		
	
}
