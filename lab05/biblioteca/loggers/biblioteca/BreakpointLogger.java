package biblioteca;
/**
 * Classe reponsável por logar uma mensagem em relação à métodos.
 * 
 * @author Maria Luisa Dantas
 * */
public class BreakpointLogger implements Logadora {
	
	private String metodo;
	
	/**
	 * Construtor para quando a classe for criada sem parametros.
	 * */
	public BreakpointLogger() {
		this.metodo = null;
		
	}
	
	/**
	 * Construtor para quando a classe for criada com parametro.
	 * */
	public BreakpointLogger(String metodo) {
		this.metodo = metodo;
	}
	
	/**
	 * Mensagem que aparecerá sempre que determinado método for invocado.
	 * 
	 * @param nomeMetodo nome do metodo.
	 * @param tipoOp tipo de operação.
	 * */
	@Override
	public void log(String nomeMetodo, String tipoOp) {
		if (nomeMetodo.equals(metodo)) {
			System.out.print("[INVOCADO - "+nomeMetodo+"]");
		}
	}

}
