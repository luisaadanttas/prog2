package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterrogaPraPontosTest {

	private AlgoritmoTransformacao transformacao;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new InterrogaPraPontos();
	}
	
	@Test
	public void transformacaoTest() {
		assertEquals(this.transformacao.transforma("oi? alou?? alo!"),"oi. alou.. alo!");
	}
	
	@Test
	public void getNomeTest() {
		assertEquals(this.transformacao.getNome(),"InterrogaPraPontos");
	}

}
