package biblioteca;

/**
 * Classe que transforma uma String para o formato CamelCase.
 * 
 * @author Maria Luisa Dantas.
 * */
public class CamelCase implements AlgoritmoTransformacao{
	
	/**
	 * Retorna se uma caracter é ou não uma letra
	 * 
	 * @param x letra a ser analizada
	 * @return retorna true se for letra, false caso contrario.
	 * */
	public boolean ehLetra(char x) {
		if (Character.isLetter(x)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a String apos a transformação para o formato CamelCase
	 * 
	 * @param original String a ser transformada
	 * @return saida String após a transformação
	 * */
	@Override
	public String transforma(String original) {
		String saida = "";
		for (int i = 0; i < original.length(); i++) {
			if (ehLetra(original.charAt(i))) {
				if (i%2==0) {
					saida += Character.toUpperCase(original.charAt(i));
				}
				else {
					saida += Character.toLowerCase(original.charAt(i));
				}
			}
			else {
				saida+= original.charAt(i);
			}
		}
		return saida;
	}
	
	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return retorna o nome do tipo de trasformação
	 * */
	@Override
	public String getNome() {
		return "CaMeLcAsEfY";
	}

	
	

}
