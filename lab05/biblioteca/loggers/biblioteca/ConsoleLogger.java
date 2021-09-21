package biblioteca;

/**
 * Classe responsável por logar uma mensagem.
 * 
 * @author Maria Luisa Dantas.
 * */
public class ConsoleLogger implements Logadora {
	
	/**
	 * Apresenta o nome do método e seu tipo de operação se houver.
	 * 
	 * @param nomeMetodo nome do metodo.
	 * @param tipoOp tipo de operação.
	 * */
	@Override
	public void log(String nomeMetodo, String tipoOp) {
		if (tipoOp!=null) {
			System.out.print("["+nomeMetodo+"] "+ tipoOp);		
		}
		else {
			System.out.print("["+nomeMetodo+"] ");
		}
	}
}
