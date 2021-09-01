package lab2;

/**
 * Registra e acompanha a rotina de descanso de um aluno.
 * 
 * @author Maria Luisa Dantas.
 */
public class Descanso {
	
	/**
	 * Quantidade de horas de descanso do aluno.
	 */
	private int horasDescanco;
	
	/**
	 * Número da semana.
	 */
	private int numeroSemana;
	
	/**
	 * Status do aluno, que será cansado ou descansado.
	 */
	private String status;
	
	/**
	 * Define se já houve registro de horas de descanso ou do numero de semanas.
	 */
	private boolean houveRegistro = false;
	
	/**
	 * Construtor que define o status inicial do aluno como "cansado".
	 */
	public Descanso(){
		this.status = "cansado";
	}
	
	
	/**
	 * Método que define a quantidade de horas de descanso do aluno e se houve registro de horas de descanso.
	 *  
	 * @param valor quantas horas de descanso o aulo teve. 
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanco = valor;
		this.houveRegistro = true;
	}
	
	
	/**
	 * Método que define o número da semana e se houve registro do número da semana.
	 * 
	 * @param valor numero de semanas.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemana = valor;
		this.houveRegistro = true;
	}
	
	
	/**
	 * Verifica se o aluno obteve uma quantidade de horas de descanso maior ou igual a 26 horas por semana,
	 * se sim e se já tiver ocorrido o registro de horas de descanso ou do numero de semanas,
	 * seu status é definido como descansado, se não, o status é definido como cansado. 
	 * 
	 * @return status do aluno que será descansado ou cansado.
	 */
	public String getStatusGeral() {
		if (horasDescanco >= 26*numeroSemana && houveRegistro) {
			status = "descansado";
		}
		else {
			status = "cansado";
		}
		return status;
	}
}




