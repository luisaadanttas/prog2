package biblioteca;

/**
 * Classe que transforma uma String substituindo sinais de interrogação por pontos.
 * 
 * @author Maria Luisa Dantas.
 * */
public class InterrogaPraPontos implements AlgoritmoTransformacao{
	
	/**
	 * Transforma uma string substituindo os sinais de interrogação por pontos.
	 * 
	 * @param original String a ser transformada.
	 * @return String após a transformação.
	 * */
	@Override
	public String transforma(String original) {
		String saida = "";
		for (int i = 0; i < original.length(); i++) {
			char letra = original.charAt(i);
			if (letra == '?') {
				saida += '.';
			}
			else {
				saida += letra;
			}
		}
		return saida;
	}
	

	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return o nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "InterrogaPraPontos";
	}


}
