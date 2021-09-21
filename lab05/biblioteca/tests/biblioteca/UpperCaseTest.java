package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UpperCaseTest {
	
	private AlgoritmoTransformacao transformacao;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new UpperCase();
	}
	
	@Test
	public void testTransormacao() {
		assertEquals(this.transformacao.transforma("oLa TudO Bem"),"OLA TUDO BEM");
	}
	
	@Test
	public void testGetNome() {
		assertEquals(this.transformacao.getNome(), "upperCase");
	}

}
