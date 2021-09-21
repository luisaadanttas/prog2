package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LowerCaseTest {

private AlgoritmoTransformacao transformacao;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new LowerCase();
	}
	
	@Test
	public void testTransormacao() {
		assertEquals(this.transformacao.transforma("oLa TudO Bem"),"ola tudo bem");
	}
	
	@Test
	public void testGetNome() {
		assertEquals(this.transformacao.getNome(), "lowerCase");
	}

}
