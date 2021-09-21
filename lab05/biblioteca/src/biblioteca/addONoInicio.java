package biblioteca;

/**
 * Classe que transforma uma String inicial, adicionando a letra o no inicio da string original.
 * Classe feita para testar o metodo de cadastro de nova classes em TransformaTexto
 * @author Maria Luisa Dantas
 * 
 * */
public class addONoInicio implements AlgoritmoTransformacao{
	
	/**
	 * Transforma uma String adicionando a letra o no inicio da string original.
	 * 
	 * @param original String a ser transformada
	 * @return String após a transformação
	 * */
	@Override
	public String transforma(String original) {
		String nova = "o" +original;
		return nova;
	}
	

	/**
	 * Retorna o nome do tipo de transformação
	 * 
	 * @return o nome do tipo de transformação
	 * */
	@Override
	public String getNome() {
		return "addONoInicio";
	}

}
