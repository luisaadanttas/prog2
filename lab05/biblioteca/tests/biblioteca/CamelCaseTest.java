package biblioteca;

/**
 * Testa a transformação do tipo CamelCase.
 * 
 * @author Maria Luisa Dantas.
 * */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseTest {
	
	private AlgoritmoTransformacao transformacao;
	private CamelCase camelOnly;
	
	@Before
	public void transformacaoBase() {
		this.transformacao = new CamelCase();
		this.camelOnly = new CamelCase();
	}
	
	
	@Test
	public void testTransformacao() {
		assertEquals(this.transformacao.transforma("teste, oi"), "TeStE, oI");
		assertEquals(this.transformacao.transforma("oi, como vc vai?"),"Oi, CoMo vC VaI?");
	}
	
	@Test
	public void testGetNome() {
		assertEquals(this.transformacao.getNome(), "CaMeLcAsEfY");
	}
	
	@Test
	public void testIsChar() {
		assertEquals(this.camelOnly.ehLetra('1'), false);
	}
	
	

}
