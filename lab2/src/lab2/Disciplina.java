package lab2;
import java.util.Arrays;

/**
 * Resgistra as notas de um aluno em determinada disciplina, bem como a quantidade de horas
 * que o aluno dedicou ao estudo dessa disciplina, e também se ele foi aprovado ou não.
 * 
 * @author Maria Luisa Moraes Monteiro Dantas
 * */

public class Disciplina {
	
	/**
	 * Nome da disciplina.
	 * */
	private String nome;
	
	/**
	 * Quantidade de horas de estudo dedicadas à disciplina em questão.
	 * */
	private int horasEstudo;
	
	/**
	 * Nota média do aluno nesta disciplina.
	 * */
	private double media;
	
	/**
	 * Array determinando as quatro notas possíveis, sendo todas inicialmente zero pois caso
	 * não ocorra o cadastro de determinada nota, deve ser considerado que o aluno recebeu 0.
	 * */
	private double[] notas = {0,0,0,0};
	
	
	/**
	 * Construtor que determina a inicialização de uma disciplina.
	 * 
	 * @param nomeDisciplina nome dessa disciplina inicializada.
	 * */
	public Disciplina(String nomeDisciplina){
		this.nome = nomeDisciplina;
	}
	
	/**
	 * Método que define a quantidade de horas dedicadas ao estudo dessa disciplina.
	 * 
	 * @param horas tempo em horas que o aluno dedicou ao estudo dessa disciplina.
	 * */
	public void cadastraHoras(int horas) {
		this.horasEstudo = horas;
	}
	
	/**
	 * Método que cadastra uma nota, substituindo o valor presente na posição indicada (de acordo com o valor 
	 * de "nota") pelo valor que foi recebido como parametro.
	 * 
	 * @param nota posição da nota a ser cadastrada no array notas.
	 * @param valorNota valor dessa nota que deve ser cadastrado.
	 * */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota-1] = valorNota;
	}
	
	/**
	 * Método responsável por determinar se o aluno foi aprovado ou não nessa disciplina
	 * através da média obtida pela soma cumulativa do array de notas dividido por 4, que
	 * é o total de notas possíveis.
	 * 
	 *  @return retorna true se o aluno foi aprovado (obteve média maior ou igual a 7.0) e false caso contrário.
	 * */
	public boolean aprovado() {
		double soma = 0;
		
		for (double i:notas) {
			soma += i;
		}
		this.media = soma/4;
		if (media >= 7.0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Cria uma String indicando a discipina em questão, quanto tempo (em horas) o aluno dedicou-se ao estudo da
	 * mesma, sua nota média nessa disciplinas e suas quatro notas finais (que foram transformadas para String).
	 * 
	 * @return retorna uma String no formato "nome horasEstudo media notasFinais".
	 * */
	public String toString() {
		String notasFinais = Arrays.toString(notas);
		return this.nome + ' ' + this.horasEstudo + ' ' + this.media + ' '+ notasFinais;
	}
	
}