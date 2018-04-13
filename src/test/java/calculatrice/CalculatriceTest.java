package calculatrice;

import org.junit.Test;
import junit.framework.TestCase;

public class CalculatriceTest extends TestCase{
	
	private Calculatrice calc;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calc = new Calculatrice();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		calc = null;
	}

	@Test
	public void testAdd() {
		calc.add(1, 2);
		assertEquals(3, calc.getResult());
		
		calc.add(-1, 8);
		assertEquals(7, calc.getResult());
		
		calc.add(-2, -4);
		assertEquals(-6, calc.getResult());
	}

	@Test
	public void testMinus() {
		calc.minus(2, 1);
		assertEquals(1, calc.getResult());
		
		calc.minus(-1, 8);
		assertEquals(-9, calc.getResult());
		
		calc.minus(-2, -4);
		assertEquals(2, calc.getResult());
	}

	@Test
	public void testMultiply() {
		calc.multiply(2, 3);
		assertEquals(6, calc.getResult());
		
		calc.multiply(-1, 8);
		assertEquals(-8, calc.getResult());
		
		calc.multiply(-2, -4);
		assertEquals(8, calc.getResult());
	}

	@Test
	public void testDivide() {
		calc.divide(6, 2);
		assertEquals(3, calc.getResult());
		
		calc.divide(6, -2);
		assertEquals(-3, calc.getResult());
		
		calc.divide(-6, -3);
		assertEquals(2, calc.getResult());
		
		calc.divide(5, 0);
		assertEquals(0, calc.getResult());
	}

}
