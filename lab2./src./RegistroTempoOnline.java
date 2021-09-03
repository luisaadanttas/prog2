package lab2;


/**
 * Registra o tempo online utilizado por um estudante para o estudo de determinada disciplina e define 
 * se esse tempo atingiu ou não uma meta previamente definida.
 *  
 *  @author Maria Luisa Dantas.
 */
public class RegistroTempoOnline {
	
	/**
	 * Nome da disciplina.
	 */
	private String nome;
	
	/**
	 * Tempo esperado de estudo dessa disciplina. 
	 */
	private int tempoOnlineEsperado;
	
	/**
	 * Tempo que o aluno realmente dedicou-se ao estudo da disciplina.
	 */
	private int tempoTotal;
	
	
	/**
	 * Construtor que determina o nome da disciplina, 
	 * o tempo esperado de estudo dedicado a disciplina em horas (sendo 120 o padrão)
	 * e o tempo total (também em horas) que indica quanto tempo o aluno dedicou-se à disciplina.
	 * 
	 * @param nomeDisciplina nome da disciplina.
	 */
	public RegistroTempoOnline (String nomeDisciplina){
		this.nome = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
		this.tempoTotal = 0;
	}
	
	/**
	 * Construtor que determina o tempo de estudo esperado para a disciplina recebida como parametro.
	 * 
	 * @param nomeDisciplina nome da disciplina em questão.
	 * @param tempoOnlineEsperado tempo de estudo esperado para essa a disciplina.
	 * */
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
		this.nome = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Método responsável por adicionar o tempo que o aluno dedicou-se ao estudo da disciplina
	 * à variável tempoTotal.
	 * 
	 * @param tempo tempo em horas que o aluno dedicou-se ao estudo da disciplina.
	 * */
	public void adicionaTempoOnline(int tempo) {
		tempoTotal += tempo;
	}
	
	/**
	 * Método responsável por determinar se o aluno atingiu ou não a
	 * meta de horas de estudo esperada para a disciplina.
	 * 
	 * @return boolean que será verdadeiro apenas se o aluno tiver atingido a meta e falso caso contrário.
	 * */
	public boolean atingiuMetaTempoOnline() {
		if (tempoTotal >= tempoOnlineEsperado) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Cria uma string que retornará o nome da disciplina, o tempo que o aluno dedicou ao estudo dessa disciplina,
	 * e o tempo de estudo que era esperado.
	 * 
	 * @return String no formato "nome tempoTotal/tempoOnlineEsperado" sendo "nome" o nome da disciplina,
	 * "tempo total" o tempo que o aluno dedicou-se ao estudo dessa disciplina e "tempoOnlineEsperado"
	 *  o tempo de estudo que era esperado.
	 * */
	public String toString() {
		return this.nome + ' ' + this.tempoTotal + '/' + this.tempoOnlineEsperado;
	}
	


}
