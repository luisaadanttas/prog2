package biblioteca;

/**
 * Classe responsável por logar uma mensagem.
 * 
 * @author Maria Luisa Dantas.
 * */
import java.util.HashMap;

public class ContagemLogger implements Logadora{
	
	/**
	 * Armazena os metodos já existentes como chave e a quantidade de vezes que eles foram
	 * invocados chamadas como valor.
	 * */
	HashMap<String, Integer> metodos = new HashMap<String, Integer>();
	
	/**
	 * inicializa o valor de cada método como zero.
	 * */
	public ContagemLogger() {
		this.metodos.put("transforma", 0);
		this.metodos.put("contaTransformacao", 0);
		this.metodos.put("historico", 0);
		this.metodos.put("listarOriginais", 0);
		
	}
	
	/**
	 * incrementa 1 toda vez que o método for invocado.
	 * 
	 * @param nomeMetodo nome do metodo.
	 * @param tipoOp tipo de operação.
	 * */
	@Override
	public void log(String nomeMetodo, String tipoOp) {
		metodos.get(nomeMetodo+=1);
	}
	
	/**
	 * retorna os métodos que foram invocados ao menos uma vez e quantas vezes ele foi invocado.
	 * */
	public String toString() {
		String saida ="";
		 for (String metodo : this.metodos.keySet()) {
			 int quantidade = this.metodos.get(metodo);
			 if (quantidade > 0) {
				 saida += metodo+" - "+quantidade+"\n";
			 }
			 
		 }
		 return saida;
		
	}

}
