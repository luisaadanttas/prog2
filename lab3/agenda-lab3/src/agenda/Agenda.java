package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Maria Luisa Dantas
 *
 */
public class Agenda {
	
	/**
	 * define o tamanho do array que armazena os contatos
	 * */
	private static final int TAMANHO_AGENDA = 101;
	
	/**
	 * array que armazena os contatos.
	 * */
	private String[] contatos;
	
	/**
	 * array que armazena objetos do tipo Contato que possuem todas as informações de um contato.
	 * */
	private Contato[] contatosInfos;
	
	/**
	 * array que armazena os contatos favoritados.
	 * */
	private Contato[] favoritos;


	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new String[TAMANHO_AGENDA];
		this.contatosInfos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_AGENDA];
	}
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa a lista de favoritos mantida.
	 * @return o array de contatos favoritados.
	 * */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		return contatos[posicao];
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > 0 && posicao < 100) {
			this.contatos[posicao] = nome;
			Contato contatoAtual = new Contato(posicao, nome, sobrenome, telefone);
			contatosInfos[posicao] = contatoAtual;
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se um contato ja existe na lista de contatos.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @return retorna true se o contato já existe ou falso se ainda não existe.
	 * */
	public boolean jaExiste(String nome, String sobrenome) {
		for (Contato i : contatosInfos) {
			if (i!= null && i.getNome().equals(nome) && i.getSobrenome().equals(sobrenome)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Verifica se os dados fornecidos sobre o contato são válidos.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return retorna true se está tudo ok ou false se tiver algum dado inválido.
	 * 
	 * */
	public boolean validaCadastro(int posicao, String nome, String sobrenome, String telefone) {
		if (jaExiste(nome, sobrenome) || (posicao < 1 || posicao > 100) || (nome == null) || (telefone == null)) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Exibe o nome do contato e seu telefone.
	 * Verifica se o contato é favorito e se possui Tags, em caso afirmativo, também exibe esses dados.
	 * @return retorna o nome do contato, um simbolo de coração caso esteja favoritado e suas possíveis tags.
	 * */
	public String exibeContato(int posicao) {
		String saida = "";
		Contato contato = contatosInfos[posicao];
		if (posicao > 0 && posicao < 101 && getContato(posicao)!=null) {
			
			if (contato.getFavorito()) {
				saida += "\n" + "❤️ " + contato.getNome()+ " " + contato.getSobrenome()
				+ "\n" +contato.getTelefone();
			}
			if (!contato.getFavorito()) {
				saida += "\n" + contato.getNome()+ " " + contato.getSobrenome();
				saida += "\n" + contato.getTelefone();
			}
			if (contato.getTemTag()) {
				String[] tags = contato.getTags();
				for (String tag:tags) {
					if (tag!=null) {
						saida += "\n" + tag; 
					}
				}
			}
		}
		return saida;
	}
	
	
	/**
	 * Adiciona um contato no array de favoritos, caso ele ainda não exista nesse array.
	 * @param posicaoContato posição do contato a ser favoritado.
	 * @param posicaoFavorito posição do contato na lista de favoritos.
	 * @return retorna true se o contato tiver sido favoritado, e false caso contrário.
	 * */
	public boolean adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		Contato contato = contatosInfos[posicaoContato];
		boolean jaExiste = false;
		for (Contato i:favoritos) {
			if (contato.equals(i)) {
				jaExiste = true;
			}
		}
		if (!jaExiste) {
			if (favoritos[posicaoFavorito] != null) {
				favoritos[posicaoFavorito].setNotFavorito();
			}
			contato.setFavorito();
			favoritos[posicaoFavorito] = contato;
			return true;
		}
		return false;
	}
	
	
	/**
	 * Cadastra uma tag para um ou mais contatos.
	 * @param contatosPosicoes posicoes dos contatos que a tag estará associada.
	 * @param tagNome nome da tag.
	 * @param tagPosicao posicao da tag no array de tags do contato.
	 * */
	public void cadastraTag(String[] contatosPosicoes, String tagNome, int tagPosicao) {
		for (String i:contatosPosicoes) {
			int indice = Integer.parseInt(i);
			Contato contato = contatosInfos[indice];
			contato.setTemTag();
			contato.setTag(tagNome, tagPosicao);
		}
	}
	
	/**
	 * Retorna uma lista dos contatos e suas informações.
	 * 
	 * @return contatos e suas informações.
	 * */
	public String toString() {
		String saida = "";
		for (Contato i : contatosInfos) {
			saida = i.getPosicao() +" - "+ i.getNome() + " " + i.getSobrenome() + "\n";
		}
		return saida;
	}
	

	
	
	
	
	
	

}
