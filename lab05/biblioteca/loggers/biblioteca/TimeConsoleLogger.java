package biblioteca;

/**
 * Classe reponsável por logar uma mensagem.
 * 
 * @author Maria Luisa Dantas
 * */
public class TimeConsoleLogger implements Logadora{
	
	private int startTime;
	
	/**
	 * inicializa o tempo inicial assim que um objeto for criado.
	 * */
	public TimeConsoleLogger() {
		this.startTime = (int) System.currentTimeMillis();
	}
	
	/**
	 * Apresenta o nome do método e seu tipo de operação se houver, bem como o tempo que ele foi invocado
	 * desde que o objeto foi criado.
	 * 
	 * @param nomeMetodo nome do metodo.
	 * @param tipoOp tipo de operação.
	 * */
	@Override
	public void log(String nomeMetodo, String tipoOp) {
		int tempoAtual = (int) System.currentTimeMillis();
		String tempoDelta = Integer.toString(startTime-tempoAtual);
		if (tipoOp!=null) {
			System.out.println("["+nomeMetodo+" - "+tempoDelta+"ms]" +tipoOp);
		}
		else {
			System.out.println("["+nomeMetodo+" - "+tempoDelta+"ms]");
		}
		
	}

}
