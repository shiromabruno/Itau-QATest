import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.*;


public class IdentifierMainTest {

	static private ByteArrayOutputStream baOut;
	static private PrintStream psOut;
	
	//execute before methods
	@BeforeClass
	public static void beforeClassInit() {
		baOut = new ByteArrayOutputStream();
		psOut = new PrintStream(baOut);
		System.setOut(psOut);
	}
	
	//execute after methods
	@AfterClass
	public static void afterClassFinalize() {
		psOut.close();
	}
	
	//execute before each method
	@Before
	public void setUp() {
		baOut.reset();
	}
	
	@Test
	public void testeValido01() {
		IdentifierMain.main(new String [] {"a1"});
		String output = baOut.toString();
		//String output2 = System.out.toString();
     	assertEquals("Valido", output);
	}
	
	@Test
	public void testeInvalido02() {
		IdentifierMain.main(new String [] {"2b3"});
		String output = baOut.toString();
		assertEquals("Invalido", output);
	}
	
	@Test
	public void testeInvalido03() {
		IdentifierMain.main(new String [] {"z-12"});
		String output = baOut.toString();
		assertEquals("Invalido", output);
	}
	
	@Test
	public void testeValido04() {
		IdentifierMain.main(new String [] {"a1b2c"});
		String output = baOut.toString();
		assertEquals("Valido", output);
	}
}
