import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for NoRep class
 * @author Angelica
 *
 */
class NoRepTest {
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Base test
	 */
	@Test
	void baseTest() {
		NoRep sut= new NoRep();
		String result = sut.detect("abab");
		assertEquals("ab", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Opposite test
	 */
	@Test
	void oppositeTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("abab");
		assertNotEquals("a", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * One character test
	 */
	@Test
	void oneCharTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("a");
		assertEquals("a", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Empty String test
	 */
	@Test
	void emptyStringTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("");
		assertEquals("", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Null String test
	 */
	@Test
	void nullStringTest() {
		NoRep sut = new NoRep();
		String result = sut.detect(null);
		assertNull(result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Same character test
	 */
	@Test
	void sameCharacterTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("aaaa");
		assertEquals("a", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * No repetitions String test
	 */
	@Test
	void noRepTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("abcd");
		assertEquals("abcd",result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Nested repetition test
	 */
	@Test
	void nestedRepTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("abababcabababcabababc");
		assertEquals("abababc", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Almost repeated test
	 */
	@Test
	void almostRepeatedTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("abababCabababCababab");
		assertEquals("abababCabababCababab", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Ends with starting char test
	 */
	@Test
	void endStartTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("abaabaaba");
		assertEquals("aba", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Random repeated word test
	 */
	@Test
	void randomRepTest() {
		NoRep sut = new NoRep();
		String result = sut.detect("angelicaangelica");
		assertEquals("angelica", result);
	}
	
	/**
	 * Test method for {@link NoRep#detect(java.lang.String)}.
	 * Super long String test
	 */
	@Test
	void superLongTest() {
		StringBuilder tmp = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			tmp.append("abcdefghi");
		}
		tmp.append("_");
		String seed = tmp.toString();
				
		StringBuilder longSB = new StringBuilder();
		for(int i = 0; i < 1000000; i++) {
			longSB.append(seed);
		}
	
		NoRep sut = new NoRep();
		String result = sut.detect(longSB.toString());
		assertEquals(seed, result);
	}

}
