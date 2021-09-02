package agenda;

/**
 * Classe com todos os dados de um contato.
 * 
 * @author Maria Luisa Moraes Monteiro Dantas. -120210152.
 * 
 * */
public class Contato {
	
	/**
	 * Posicao do contato
	 * */
	private int posicao;
	/**
	 * Nome do contato.
	 * */
	private String nome;
	/**
	 * Sobrenome do contato.
	 * */
	private String sobrenome;
	/**
	 * Telefone do contato.
	 * */
	private String telefone;
	/**
	 * Nome completo do contato.
	 * */
	private String nomeCompleto;
	/**
	 * Se o contato está favoritado ou não.
	 * */
	private boolean ehFavorito = false;
	/**
	 * Tags associadas ao contato.
	 * */
	private String[] tags = new String[6];
	/**
	 * Se o contato tem alguma tag associada ou não.
	 * */
	private boolean temTag = false;
	
	/**
	 * Construtor inicializando o objeto com sua posicao, nome, sobrenome e telefone.
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * */
	public Contato(int posicao, String nome, String sobrenome, String telefone) {
		this.setPosicao(posicao);
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setTelefone(telefone);
	}
	
	
	/**
	 * Retorna a posicção do contato.
	 * 
	 * @return posição do contato.
	 * */
	public int getPosicao() {
		return posicao;
	}
	
	/**
	 * Associa a posição do contato
	 * 
	 * @param posicao Posição do contato.
	 * */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Retorna o nome do contato.
	 * 
	 * @return nome do contato
	 * */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Associa o nome do contato
	 * 
	 * @param nome Nome do contato
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * 
	 * @return sobrenome do contato.
	 * */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Associa o sobrenome do contato ao parametro.
	 * 
	 * @param sobrenome Sobrenome do contato.
	 * */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * Retorna o nome completo do contato.
	 * 
	 * @return nome completo do contato.
	 * */
	public String nomeCompleto() {
		this.nomeCompleto = this.getNome() +" "+ this.getSobrenome();
		return this.nomeCompleto;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * 
	 * @return telefone do contato.
	 * */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Associa o telefone do contato.
	 * 
	 * @param telefone Telefone do contato.
	 * */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Determina que o contato é favoritado.
	 * */
	public void setFavorito() {
		this.ehFavorito = true;
	}
	
	/**
	 * Determina que o contato não é favoritado.
	 * */
	public void setNotFavorito() {
		this.ehFavorito = false;
	}
	
	/**
	 * Retorna se o contato é favoritado ou não.
	 * 
	 * @return true se o contato for favorito e false caso contrário.
	 * */
	public boolean getFavorito() {
		return this.ehFavorito;
	}
	
	/**
	 * Determina que o contato tem tag associada.
	 * */
	public void setTemTag() {
		this.temTag = true;
	}
	
	/**
	 * Retorna se o contato tem tag associada ou não.
	 * 
	 * @return retorna true se o contato tiver tag associada e false caso contrário.
	 * */
	public boolean getTemTag() {
		return this.temTag;
	}
	
	/**
	 * Associa uma tag à determinada posição do array de tags.
	 *
	 *@param tagNome Nome da tag.
	 *@param posicaoTag Posicao da tag no array de tags.
	 * */
	public void setTag(String tagNome, int posicaoTag) {
		this.tags[posicaoTag] = tagNome;
	}
	
	/**
	 * Retorna o array atual de tags.
	 * 
	 * @return array de tags.
	 * */
	public String[] getTags() {
		return this.tags.clone();
	}
	
}