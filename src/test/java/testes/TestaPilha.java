package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.leda.tad.pilha.MinhaPilha;
import org.leda.tad.pilha.PilhaCheiaException;
import org.leda.tad.pilha.PilhaIF;
import org.leda.tad.pilha.PilhaVaziaException;

import static org.junit.jupiter.api.Assertions.*;

public class TestaPilha {
	
	protected PilhaIF<Integer> pilha = null;
	
	@BeforeEach
	public void iniciar() {
		pilha = new MinhaPilha();
	}
	
	@Test
	public void empilharTest() {
		try {
			pilha.empilhar(3);
		
			assertEquals(Integer.valueOf(3), pilha.topo());
			pilha.empilhar(5);
			assertEquals(Integer.valueOf(5), pilha.topo());
			pilha.empilhar(7);
			assertEquals(Integer.valueOf(7), pilha.topo());
			pilha.empilhar(4);
			assertEquals(Integer.valueOf(4), pilha.topo());
			pilha.empilhar(2);
			assertEquals(Integer.valueOf(2), pilha.topo());
		} catch (PilhaCheiaException e) {
			fail("empilharTest está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
            fail("empilharTest está acessando o topo erroneamente");
        }
    }
	
	@Test
	public void topoTest() {
        try {
            assertNull(pilha.topo());
			fail("deveria lançar uma exceção quando chamar o desempilhar de uma pilha vazia");
        } catch (PilhaVaziaException e) {

        }
        try {
			pilha.empilhar(3);
			assertEquals(Integer.valueOf(3), pilha.topo());
			pilha.empilhar(5);
			assertEquals(Integer.valueOf(5), pilha.topo());
			pilha.empilhar(7);
			assertEquals(Integer.valueOf(7), pilha.topo());
			pilha.empilhar(4);
			assertEquals(Integer.valueOf(4), pilha.topo());
			pilha.empilhar(2);
			assertEquals(Integer.valueOf(2), pilha.topo());
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
			fail(" está acessando o topo da pilha erroneamente");
        }

    }
	
	@Test
	public void desempilharTest() {
		try {
			pilha.desempilhar();
			fail("deveria lançar uma exceção quando chamar o desempilhar de uma pilha vazia");
		} catch (Exception e) {}
		try {
			pilha.empilhar(3);
			assertEquals(Integer.valueOf(3), pilha.topo());
			pilha.empilhar(5);
			assertEquals(Integer.valueOf(5), pilha.topo());
			pilha.empilhar(7);
			assertEquals(Integer.valueOf(7), pilha.topo());
			pilha.empilhar(4);
			assertEquals(Integer.valueOf(4), pilha.topo());
			pilha.empilhar(2);
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
			fail(" está acessando o topo da pilha erroneamente");
        }
        try {
			assertEquals(Integer.valueOf(2), pilha.topo());
			assertEquals(Integer.valueOf(2), pilha.desempilhar());
			assertEquals(Integer.valueOf(4), pilha.topo());
			
			assertEquals(Integer.valueOf(4), pilha.desempilhar());
			assertEquals(Integer.valueOf(7), pilha.topo());
			
			assertEquals(Integer.valueOf(7), pilha.desempilhar());
			assertEquals(Integer.valueOf(5), pilha.topo());
			
			assertEquals(Integer.valueOf(5), pilha.desempilhar());
			assertEquals(Integer.valueOf(3), pilha.topo());
			
			assertEquals(Integer.valueOf(3), pilha.topo());
		} catch (PilhaVaziaException e) {
			fail(" está esvaziando a pilha erroneamente");
		}
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(pilha.isEmpty());
		try { 
			pilha.empilhar(3);
			assertEquals(Integer.valueOf(3), pilha.topo());
			assertFalse(pilha.isEmpty());
			pilha.desempilhar();
			assertTrue(pilha.isEmpty());
			pilha.empilhar(4);
			pilha.empilhar(6);
			assertFalse(pilha.isEmpty());
		} catch (PilhaCheiaException e) {
			fail(" está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
			fail(" está esvaziando a pilha erroneamente");
		}
	}
	
	@Test
	public void pilhaVaziaTest() {
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
	    });
	}
	
	@Test
	public void pilhaCheiaTest() {
		assertThrows(PilhaCheiaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
	    });
	}
	
	@Test
	public void multitopTest() throws PilhaVaziaException {
		PilhaIF<Integer> saida = new MinhaPilha(3); // saida.getMeusDados de mesmo tamanho de pilha.multiTop(3)
		PilhaIF<Integer> saida2 = new MinhaPilha(1); // saida2.getMeusDados de mesmo tamanho de pilha.multiTop(1)
		try {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			saida.empilhar(3);
			saida.empilhar(10);
			saida.empilhar(2);
			saida2.empilhar(3);
		} catch (PilhaCheiaException e) {
			fail("Estouro inexperado da pilha");
		}
		assertArrayEquals(saida.getMeusDados(), pilha.multitop(3).getMeusDados()); // 3, 10, 2
		assertArrayEquals(saida2.getMeusDados(), pilha.multitop(1).getMeusDados()); // saida2 só recebe um empilhamento
		
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.multitop(10);
	    });
	}
	

	

}
