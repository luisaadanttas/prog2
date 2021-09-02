package agenda;
/**
 * Testa a classe Contato.
 * 
 * @author Maria Luisa Moraes Monteiro Dantas -120210152.
 * */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContatoTest {

	@Test
	void testConstrutor() {
		new Contato(1,"Maria", "Vander", "(89)88088-0000");
	}
	
	@Test
	void testNomeCompleto() {
		Contato contato = new Contato(1,"Maria", "Luisa", "(83) 99999-0007");
		assertEquals(contato.nomeCompleto(), "Maria Luisa");
	}

}
