package JunitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssumptionTest {
	
	@Test
	void testAssumeTrue() {
		boolean b = 'A' == 'A';
		assumeTrue(b);
		// only if assumeTrue is True, below statements will be executed.
		System.out.println("A == A Test Succeed");
		assertEquals("Hello", "Hello");
	}
	
	@Test
	@DisplayName("Test Execution Begins")
	public void testAssumeTruePart2() {
		LocalDateTime dt = LocalDateTime.now();
		assumeTrue(dt.getDayOfWeek().getValue() == 6);
		System.out.println("Further code will execute only if above assumption holds true");
	}
	
	@Test
	void testAssumeFalse() {
		boolean b = 'A' != 'A';
		assumeFalse(b);
		System.out.println("A != A TestAssumeFalse Succeed");
		assertEquals("Hello", "Hello");
	}
	
	@Test
	void testAssumeFalsePart2() {
		System.setProperty("env", "prod");
		assumeFalse("dev".equals(System.getProperty("env")));
		System.out.println("Further code will execute only if above assumption holds");
	}
	
	@Test
	void testAssumingThat() {
		System.setProperty("env", "test");
		assumingThat("test".equals(System.getProperty("env")), 
					() -> {
						assertEquals(10, 10);
			            System.out.println("perform below assertions only on the test env");
					});
		// remaining statement below will be executed irrespective of the results of assumingThat - can be true/false
		assertEquals(20, 20);
		System.out.println("Perform below assertion on all environment");
	}
	
	
}
