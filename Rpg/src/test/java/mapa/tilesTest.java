package mapa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeClass;
import org.junit.jupiter.api.Test;

import mapa.Tiles;

class tilesTest {

	Tiles prueba;

	@BeforeClass
	public void createTiles() {
		prueba = new Tiles("prueba", true, true, true, true);
	}

//Gets
	@Test
	public void TestGetCodigo() {
		String resultado = prueba.getCode();
		assertEquals("prueba", resultado);
	}

	@Test
	public void TestGetUp() {
		boolean resultado = prueba.isUp();
		assertTrue(true == resultado);
	}

	@Test
	public void TestGetDown() {
		boolean resultado = prueba.isDown();
		assertTrue(true == resultado);
	}

	@Test
	public void TestGetRight() {
		boolean resultado = prueba.isRight();
		assertTrue(true == resultado);
	}

	@Test
	public void TestGetLeft() {
		boolean resultado = prueba.isLeft();
		assertTrue(true == resultado);
	}

//Sets
	@Test
	public void TestSetCodigo() {
		prueba.setCode("cambiado");
		String resultado = prueba.getCode();
		assertEquals("cambiado", resultado);
	}

	@Test
	public void TestSetUp() {
		prueba.setUp(false);
		boolean resultado = prueba.isUp();
		assertTrue(false == resultado);
	}

	@Test
	public void TestSetDown() {
		prueba.setDown(false);
		boolean resultado = prueba.isDown();
		assertTrue(false == resultado);
	}

	@Test
	public void TestSetRight() {
		prueba.setRight(false);
		boolean resultado = prueba.isRight();
		assertTrue(false == resultado);
	}

	@Test
	public void TestSetLeft() {
		prueba.setLeft(false);
		boolean resultado = prueba.isLeft();
		assertTrue(false == resultado);
	}

}
