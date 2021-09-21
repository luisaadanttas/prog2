package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleanSpacesTest {

	private AlgoritmoTransformacao transformacao;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new CleanSpaces();
	}
	
	@Test
	public void transformacaoTest() {
		assertEquals(this.transformacao.transforma("oi tudo bem"),"oitudobem");
	}
	
	@Test
	public void getNomeTest() {
		assertEquals(this.transformacao.getNome(),"cleanSpaces");
	}
	

}
