package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleanTest {
	
	private AlgoritmoTransformacao transformacao;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new Clean();
	}
	
	
	@Test
	public void testTransformacao() {
		assertEquals(this.transformacao.transforma("oi, como voce ta?!"),"oi como voce ta");
	}
	
	@Test
	public void testGetNome() {
		assertEquals(this.transformacao.getNome(), "clean");
	}

}
