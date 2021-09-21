package biblioteca;

/**
 * Classe que transforma uma String removendo todos os espaços.
 * 
 * @author Maria Luisa Dantas
 * */
public class CleanSpaces implements AlgoritmoTransformacao {
	
	/**
	 * Transforma uma string removendo todos os espaços
	 * 
	 * @param original String a ser transformada
	 * @return retorna a String após todos os espaços terem sido removidos
	 * */
	@Override
	public String transforma(String original) {
		String nova = "";
		for (int i = 0; i < original.length(); i++) {
			char letra = original.charAt(i);
			if (letra != ' ') {
				nova+=letra;
			}
		}
		return nova;
	}
	
	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return o nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "cleanSpaces";
	}

}
