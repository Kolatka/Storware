
import com.kolatka.app.calculator.Calculator;
import com.kolatka.app.calculator.FileHandler;
import com.kolatka.app.exception.InvalidInstructionException;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.*;


public class MainTest {

	private Calculator calculator;

	void prepareTest(String location) throws InvalidInstructionException {
		calculator = new Calculator(false);
		FileHandler fileHandler = new FileHandler(location);
		fileHandler.readFile();
		calculator.setInstructionList(fileHandler.getInstructionList());
	}

	@Test
	void AllCorrectOperatorsTest() throws InvalidInstructionException {
		prepareTest("src\\test\\java\\files\\AllCorrectOperatorsTest.txt");
		assertThat(calculator.calculate(), is("4.0"));
	}

	@Test
	void EmptyFileTest() throws InvalidInstructionException {
		prepareTest("src\\test\\java\\files\\EmptyFileTest.txt");
		Throwable exception = assertThrows(InvalidInstructionException.class, () ->
				calculator.calculate());
		assertEquals("List of instructions is empty", exception.getMessage());
	}

	@Test
	void InvalidInstructionTest(){
		Throwable exception = assertThrows(InvalidInstructionException.class, () ->
				prepareTest("src\\test\\java\\files\\InvalidInstructionTest.txt"));
		assertEquals("Invalid instruction: 'add 2 2 2 2 2'.", exception.getMessage());

	}
	@Test
	void InvalidOperatorTest() {
		Throwable exception = assertThrows(InvalidInstructionException.class, () ->
				prepareTest("src\\test\\java\\files\\InvalidOperatorTest.txt"));
		assertEquals("Invalid operator: 'Apple'.", exception.getMessage());
	}

	@Test
	void InvalidValueTest(){
		Throwable exception = assertThrows(NumberFormatException .class, () ->
				prepareTest("src\\test\\java\\files\\InvalidValueTest.txt"));
		assertEquals("For input string: \"2,,5\"", exception.getMessage());
	}

	@Test
	void NoApplyAtTheEndTest() throws InvalidInstructionException {
		prepareTest("src\\test\\java\\files\\NoApplyAtTheEndTest.txt");
		Throwable exception = assertThrows(InvalidInstructionException.class, () ->
				calculator.calculate());
		assertEquals("Last instruction should be 'Apply'", exception.getMessage());
	}

}
