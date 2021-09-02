package agenda;

 /** Testa a classe Agenda.
  * 
  * @author Maria Luisa Moraes Monteiro Dantas -120210152.
  * */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AgendaTest {
	
	private Agenda agendaBase;
	
	/**
	 * Cria objeto da classe testada.
	 * */
	@BeforeEach
	void agendaUtilizada() {
		this.agendaBase = new Agenda();
	}
	
	/**Teste ao cadastrar um novo contato em posição vazia*/
	@Test
	void testCadastraContato() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
	}
	
	/**Teste ao cadastrar um novo contato em posição existente*/
	@Test
	void testCadastroPosExistente() {
		this.agendaBase.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111");
	}
	
	/**Teste ao cadastrar um novo contato com nome e sobrenome já cadastrados em outra posição*/
	@Test
	void testCadastroContatoJaExistenteOutraPosicao() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agendaBase.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000");
	}
	
	/**Teste ao cadastrar um novo contato na posição limite*/
	@Test
	void testCadastroContatoPosicaoLimite(){
		this.agendaBase.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
	}
	
	/**Teste ao cadastrar um novo contato em uma posição acima do limite*/
	@Test
	void testCadastroContatoPosicaoAcima(){
		assertEquals(this.agendaBase.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"),false);
	}
	
	/**Teste ao cadastrar um novo contato em uma posição abaixo do limite*/
	@Test
	void testCadastroContatoPosicaoAbaixo(){
		assertEquals(this.agendaBase.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"),false);
	}
	
	/**Teste ao cadastrar um novo contato com telefone vazio*/
	@Test
	void testCadastraContatoTelVazio() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "");
	}
	
	/**Teste ao cadastrar um novo contato com nome vazio*/ 	
	@Test
	void testCadastraContatoNomeVazio() {
		this.agendaBase.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000");
	}
	
	/**Teste ao exibir um contato cadastrado com todos os dados*/
	@Test
	void testExibeContato() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(this.agendaBase.exibeContato(1),"\nMatheus Gaudencio\n(83) 99999-0000");
	}
	
	/**Teste ao exibir um contato em uma posição sem contato*/
	@Test
	void testExibirContatoPosicaoVazia() {
		try {
			assertEquals(this.agendaBase.exibeContato(100),"");
			
		} catch(NullPointerException ne) {
			
		}
	}
	
	/**Teste ao exibir um contato em uma posição inválida (limite inferior)*/
	@Test
	void testExibirContatoAbaixoLimite() {
		try {
			assertEquals(this.agendaBase.exibeContato(0),"");
			
		} catch(ArrayIndexOutOfBoundsException ae) {
			
		}
	}
	
	
	/**Teste ao exibir um contato em uma posição inválida (limite superior)*/
	@Test
	void testExibirContatoAcimaLimite() {
		try {
			assertEquals(this.agendaBase.exibeContato(101),"");
			fail("Acesso de posição acima do limite");
		} catch(ArrayIndexOutOfBoundsException ae) {
			
		}
	}
	
	/**Teste ao exibir um contato favoritado*/
	@Test
	void testExibeFavorito() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agendaBase.adicionaFavorito(1, 1);
		assertEquals(this.agendaBase.exibeContato(1),"\n" + "❤️ "+"Matheus Gaudencio\n(83) 99999-0000");
	}
	
	/**Teste ao exibir um contato com tags*/
	void testExibeTags() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		String[] array={"1"}; 
		this.agendaBase.cadastraTag(array, "professor-ufcg", 1);
		assertEquals(this.agendaBase.exibeContato(1),"\n" + "❤️ "+"Matheus Gaudencio\n(83) 99999-0000");
	}
	
	
	
	

}
