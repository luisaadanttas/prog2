package biblioteca;
/**
 * Classe que testa TransformaTexto
 * 
 * @author Maria Luisa Dantas
 * */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransformaTextoTest {
	
	private TransformaTexto transformaTextoBase;
	
	/**
	 * Testa o construtor e adiciona operações de transformação.
	 * */
	@Before
	public void transformaBase() {
		this.transformaTextoBase = new TransformaTexto();
		this.transformaTextoBase.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		this.transformaTextoBase.transforma("clean", "oi, como vc vai?");
		this.transformaTextoBase.transforma("InterrogaPraPontos", "oi, como vc vai?");
		
	}
	
	/**
	 * Testa todos os tipos de tranformações já registrados.
	 * */
	@Test
	public void testTransforma() {
		assertEquals(this.transformaTextoBase.transforma("CaMeLcAsEfY", "oi, como vc vai?"),"Oi, CoMo vC VaI?");
		assertEquals(this.transformaTextoBase.transforma("clean", "oi, como vc vai?"),"oi como vc vai");
		assertEquals(this.transformaTextoBase.transforma("upperCase", "oi, como vc vai?"),"OI, COMO VC VAI?");
		assertEquals(this.transformaTextoBase.transforma("cleanSpaces", "oi, como vc vai?"),"oi,comovcvai?");
		assertEquals(this.transformaTextoBase.transforma("InterrogaPraPontos", "oi, como vc vai?"),"oi, como vc vai.");
		assertEquals(this.transformaTextoBase.transforma("lowerCase", "UPPer CASE"),"upper case");
		
	}
	
	/**
	 * Testa o método que conta quantas transformações já foram realizadas.
	 * */
	@Test
	public void testContaTransformacao() {
		assertEquals(this.transformaTextoBase.contaTransformacao(), 3);
	}
	
	/**
	 * Testa o método que apresenta o histórico registrado em determinada posicao.
	 * */
	@Test
	public void testHistorico() {
		assertEquals(this.transformaTextoBase.historico(0),"oi, como vc vai? CaMeLcAsEfY -> Oi, CoMo vC VaI?");
	}
	
	/**
	 * Testa a listagem de Strings originais (antes de qualquer transformação.
	 * */
	@Test
	public void testListarOriginais() {
		assertEquals(this.transformaTextoBase.listarOriginais(),"oi, como vc vai?\n");
	}
	
	/**
	 * Testa a listagem de informações já cadastradas como padrão no sistema.
	 * */
	@Test
	public void testListarTransformacoes() {
		assertEquals(this.transformaTextoBase.listarTransformacoes(),"CaMeLcAsEfY\nclean\nInterrogaPraPontos\n");
	}
	
	/**
	 * Testa o cadastro de novas transformações.
	 * */
	@Test
	public void testCadastro() {
		AlgoritmoTransformacao novo = new addONoInicio();
		this.transformaTextoBase.cadastra("addONoInicio", novo);
	}
	

}
