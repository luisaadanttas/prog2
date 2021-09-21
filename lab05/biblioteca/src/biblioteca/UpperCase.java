package biblioteca;

/**
 * Classe que transforma uma String a partir da capitalização de todas as letras.
 * 
 * @author Maria Luisa Dantas.
 * */
public class UpperCase implements AlgoritmoTransformacao{
	
	/**
	 * Transforma todas as letras da String para sua forma maíuscula caso essa esteja minúscula.
	 * 
	 * @param original String a ser transformada
	 * @return String após a transformação
	 * */
	@Override
	public String transforma(String original) {
		String nova = original.toUpperCase();
		return nova;
	}
	

	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return o nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "upperCase";
	}

}
