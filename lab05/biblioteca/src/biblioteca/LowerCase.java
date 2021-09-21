package biblioteca;

/**
 * Classe que transforma uma String para que todas as letras fiquem minúsculas.
 * 
 * @author Maria Luisa Dantas.
 * */
public class LowerCase implements AlgoritmoTransformacao{
	
	/**
	 * Transforma todas as letras da String para sua forma minuscula caso essa esteja maiuscula.
	 * 
	 * @param original String a ser transformada
	 * @return String após a transformação
	 * */
	@Override
	public String transforma(String original) {
		String nova = original.toLowerCase();
		return nova;
	}
	

	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return o nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "lowerCase";
	}

}
