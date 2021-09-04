package lab2;
import java.util.ArrayList;

/**
 * Registra e controla os gastos de um estudante que possui diferentes fontes de renda.
 * 
 * @author Maria Luisa Dantas.
 * */

public class RegistroFinancas {
	
	/**
	 * Armazena o total de ganhos recebidos pelo estudante.
	 * */
	private int totalRecebido;
	
	/**
	 * Armazena o total de despesas que o estudante teve.
	 * */
	private int totalDespesas;
	
	/**
	 * Armazena o saldo disponível do estudante no momento da consulta.
	 * */
	private int totalDisponivel;
	
	/**
	 * ArrayList contendo os ganhos do estudante em cada uma de suas fontes de renda.
	 * */
	private ArrayList<Integer> ganhos = new ArrayList<Integer>();
	
	/**
	 * Construtor que determina o total disponível inicialmente, bem como a quantidade de fontes de renda
	 * que o estudante tem, inicializando cada uma delas com o valor 0.
	 * 
	 * @param ganhosIniciais valor inicial do total disponível e total recebido.
	 * @param totalDeGanhos quantidade de fontes de renda que o aluno tem.
	 * */
	public RegistroFinancas(int ganhosIniciais, int totalDeGanhos){
		this.totalDisponivel = ganhosIniciais;
		this.totalRecebido += ganhosIniciais;
		for (int i =0; i < totalDeGanhos; i++) {
			ganhos.add(0);
		}
		
	}
	
	/**
	 * Método que adiciona ou substitui o valor ganho em determinada fonte de renda.
	 * 
	 * @param valorCentavos valor a ser definido como o ganho de determinada fonte de renda.
	 * @param posicaoGanho indíce que indica a fonte de renda que terá o valor de ganho alterado.
	 * */
	public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
		totalRecebido -= ganhos.get(posicaoGanho-1);
		ganhos.set(posicaoGanho-1,valorCentavos);
		totalRecebido += valorCentavos;
		
		
	}
	
	/**
	 * Método que adiciona uma despesa ao valor total gasto em despesas.
	 * 
	 * @param valorCentavos valor da despesa.
	 * */
	public void pagaDespesa(int valorCentavos) {
		totalDespesas += valorCentavos;
	}
	
	/**
	 * Cria uma String responsável por representar o valor de ganhos de cada fonte de renda.
	 * 
	 * @return retorna uma String contendo em cada linha o
	 * número que indica a fonte de renda e seu respectivo valor.
	 * */
	public String exibeGanhos( ) {
		String str = "";
		for (int i = 0; i < ganhos.size()-1; i++) {
			String ganhoDaVez = Integer.toString(i+1);
			str += ganhoDaVez +  " - " + ganhos.get(i);
			str += '\n';
		}
		String ultimoGanhoValor = Integer.toString(ganhos.size());
		str += ultimoGanhoValor + " - " + ganhos.get(ganhos.size()-1);
		return str;
	}
	
	/**
	 * Tansforma cada valor inteiro (totalRecebido, totalDisponivel e totalDespesas) em Strings
	 * e retorna tudo junto.
	 * 
	 * @return retorna a String que contém, no momento da consulta, o total de ganhos recebidos,
	 * as despesas totais e o total disponível do estudante.
	 * */
	public String toString() {
		totalDisponivel = totalRecebido-totalDespesas;
		String s1 = Integer.toString(totalDisponivel);
		String s2 = Integer.toString(totalRecebido);
		String s3 = Integer.toString(totalDespesas);
		
		return "Total recebidos: "+s2+", Despesas totais: "+s3+", Total disponível: "+s1;

	}


}

