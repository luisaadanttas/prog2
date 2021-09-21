package biblioteca;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Classe responsável pelo gerenciamento de transformações.
 * 
 * @author Maria Luisa Dantas
 * */
public class TransformaTexto{
	
	/**
	 * armazena a quantidade de transformacoes realizadas
	 * */
	private int qtdTransformacoes;
	
	/**
	 * armazena o historico de transformações
	 * */
	private ArrayList<String> historico = new ArrayList<String>();
	
	/**
	 * armazena as Strings antes de sofrerem alguma modificação.
	 * */
	private HashSet<String> listaOriginais = new HashSet<String>();
	
	/**
	 * armazena as transformações realizadas com o nome em letras minúsculas e seu nome original
	 * a partir do método getNome.
	 * */
	private HashMap<String, String> listaTransformacoes = new HashMap<String, String>();
	
	
	/**
	 * armazena todas as transformacoes cadastradas.
	 * */
	private HashSet<AlgoritmoTransformacao> novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
	
	/**
	 * determina a existencia e tipo de log se tiver.
	 * */
	private Logadora logger;
	
	
	/**
	 * Construtor que inicializa as coleções como atributos e determina que não haverá log
	 * quando a classe TransformaTexto for inicializada sem parametros.
	 * */
	public TransformaTexto() {
		this.historico = new ArrayList<String>();
		this.listaOriginais = new HashSet<String>();
		this.listaTransformacoes = new HashMap<String, String>();
		this.novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
		this.logger = null;
	}
	
	/**
	 * Construtor que inicializa todos os atributos e logger com o tipo que foi passado como parametro.
	 * 
	 * @param consoleLogger classe ConsoleLogger relacionada ao logger.
	 * */
	public TransformaTexto(ConsoleLogger consoleLogger) {
		this.historico = new ArrayList<String>();
		this.listaOriginais = new HashSet<String>();
		this.listaTransformacoes = new HashMap<String, String>();
		this.novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
		this.logger = new ConsoleLogger();
	}
	
	/**
	 * Construtor que inicializa todos os atributos e o logger com o tipo que foi passado como parametro.
	 * 
	 * @param consoleLogger classe ConsoleLogger relacionada ao logger.
	 * */
	public TransformaTexto(ContagemLogger contagemLogger) {
		this.historico = new ArrayList<String>();
		this.listaOriginais = new HashSet<String>();
		this.listaTransformacoes = new HashMap<String, String>();
		this.novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
		this.logger = new ContagemLogger();
	}
	
	/**
	 * Construtor que inicializa todos os atributos e o logger com o tipo que foi passado como parametro.
	 * 
	 * @param timeLogger classe TimeLogger relacionada ao logger.
	 * */
	public TransformaTexto(TimeConsoleLogger timeLogger) {
		this.historico = new ArrayList<String>();
		this.listaOriginais = new HashSet<String>();
		this.listaTransformacoes = new HashMap<String, String>();
		this.novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
		this.logger = new TimeConsoleLogger();
	}
	
	/**
	 * Construtor que inicializa todos os atributos e o logger com o tipo que foi passado como parametro.
	 * 
	 * @param breakpointLogger classe BreakpointLogger relacionada ao logger.
	 * */
	public TransformaTexto(BreakpointLogger breakLogger) {
		this.historico = new ArrayList<String>();
		this.listaOriginais = new HashSet<String>();
		this.listaTransformacoes = new HashMap<String, String>();
		this.novasTransformacoes = new HashSet<AlgoritmoTransformacao>();
		this.logger = new BreakpointLogger();
	}
	
	
	
	/**
	 * Realiza a transformação de acordo com o tipo passado como parametro e
	 * faz armazena os dados relacionados as transformacoes.
	 * 
	 * @param tipoOp tipo de transformação a ser realizada.
	 * @return retorna a String após a transformação realizada.
	 * */
	public String transforma(String tipoOp, String original) {
		AlgoritmoTransformacao operacao = new UpperCase();
		
		if (tipoOp.equals("upperCase")) {
			operacao = new UpperCase();
		}
		if (tipoOp.equals("cleanSpaces")) {
			operacao = new CleanSpaces();
		}
		if (tipoOp.equals("InterrogaPraPontos")) {
			operacao = new InterrogaPraPontos();
		}
		if (tipoOp.equals("clean")) {
			operacao = new Clean();
		}
		if (tipoOp.equals("CaMeLcAsEfY")) {
			operacao = new CamelCase();
		}
		if (tipoOp.equals("lowerCase")) {
			operacao = new LowerCase();
		}
		
		String modificada = operacao.transforma(original);
		String nome = operacao.getNome();
		
		this.qtdTransformacoes+=1;
		String registroHistorico = original+" "+ tipoOp+" -> "+modificada;
		
		historico.add(registroHistorico);
		listaOriginais.add(original);
		listaTransformacoes.put(nome.toLowerCase(),nome);
		novasTransformacoes.add(operacao);
		
		if(logger!=null) {
			this.logger.log(nome, tipoOp);
		}
		return modificada;
		
	}
	
	
	/**
	 * Gerencia a quantidade de transformações realizadas.
	 * 
	 * @return int quantiade de transformações até o momento.
	 * */
	public int contaTransformacao() {
		if(logger!=null) {
			this.logger.log("contaTransformacoes", null);
		}
		return this.qtdTransformacoes;
		
	}
	
	
	/**
	 * Exibe o histórico armazenado em determinada posição.
	 * 
	 * @param posicao posicção do histórico
	 * @return String retorna o histórico detalhado dessa posição.
	 * */
	public String historico(int posicao) {
		if(logger!=null) {
			String posicao2 = Integer.toString(posicao);
			this.logger.log("historico", posicao2);
		}
		return historico.get(posicao);
	}
	
	
	/**
	 * Cadastra um novo tipo de transformação criado pelo usuário.
	 * */
	public void cadastra(String tipoOp, AlgoritmoTransformacao novo) {
			this.novasTransformacoes.add(novo);
	}

	
	/**
	 * Exibe a listagem das Strings originais (antes de sofrerem transformações)
	 * 
	 * @return String lista das strings originais.
	 * */
	public String listarOriginais() {
		String saida = "";
		if(logger!=null) {
			this.logger.log("listarOriginais", null);
		}
		for (String original:listaOriginais) {
			saida += original + "\n";
		}
		return saida;
	}
	
	
	/**
	 * Exibe, em ordem alfabética, a lista dos tipos de transformações realizadas.
	 * 
	 * @return String lista dos tipos transformações realizadas.
	 * */
	public String listarTransformacoes() {
		String saida="";
		TreeMap<String, String> treeMap = new TreeMap<String, String>(listaTransformacoes);
		 for (String transformacao : treeMap.keySet()) {
			saida += treeMap.get(transformacao) + "\n";
		}
		if(logger!=null) {
			this.logger.log("listarTransformacoes", null);
		}
		return saida;
	}
	
	
	
	
	
	
}
