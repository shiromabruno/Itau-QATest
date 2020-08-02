//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IdentifierMainTest {

	static public ByteArrayOutputStream baOut;
	static public PrintStream psOut;
	
	// execute before methods
	@BeforeAll
	public static void beforeClassInit() {		
		baOut = new ByteArrayOutputStream();
		psOut = new PrintStream(baOut);
		System.setOut(psOut);
	}

	// execute after methods
	@AfterAll
	public static void afterClassFinalize() {
		psOut.close();
	}

	// execute before each method
	@BeforeEach
	public void setUp() {
		baOut.reset();
	}

	@Test
	public void testeValido01() {
		IdentifierMain.main(new String[] { "a1" });
		String output = baOut.toString();
		assertEquals("Valido", output);
	}

	@Test
	public void testeInvalido02() {
		IdentifierMain.main(new String[] { "2b3" });
		String output = baOut.toString();
		assertEquals("Invalido", output);
	}

	@Test
	public void testeInvalido03() {
		IdentifierMain.main(new String[] { "z-12" });
		String output = baOut.toString();
		assertEquals("Invalido", output);
	}

	@Test
	public void testeValido04() {
		IdentifierMain.main(new String[] { "a1b2c" });
		String output = baOut.toString();
		assertEquals("Valido", output);
	}
}
