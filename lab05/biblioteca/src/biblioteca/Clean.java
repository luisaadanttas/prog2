package biblioteca;

/**
 * Classe que transforma uma String removendo os sinais de pontuação.
 * 
 * @author Maria Luisa Dantas.
 * */
public class Clean implements AlgoritmoTransformacao{
	
	/**
	 * Verifica se um character é ou não um sinal de pontuação.
	 * 
	 * @param x charater analizado.
	 * @return retorna true se for um sinal e false caso contrário.
	 * */
	public boolean ehSinal(char x) {
		String sinais = "`~!@#$%^&*()_+{}|:\"<>?-=[]\\;\\'.\\/,";
		for (int i = 0; i < sinais.length(); i++) {
			if (x == sinais.charAt(i)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Remove todos os sinais de pontuação de uma String
	 * 
	 * @param original String a ser transformada
	 * @return retorna a String após a transformação
	 * */
	@Override
	public String transforma(String original) {
		String saida = "";
		for (int i = 0; i < original.length(); i++) {
			if(!ehSinal(original.charAt(i))) {
				saida+=original.charAt(i);
			}
		}
		return saida;
	}
	
	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @returno nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "clean";
	}

}
