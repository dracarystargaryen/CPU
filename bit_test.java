public class bit_test extends bit {


	// Running the test ccompiler to allow test cases to run
	public void runsTest() {
		// Declaring bits with integers.
		bit bit1 = new bit();
		bit bit2 = new bit();

		bit newBit = new bit();

		// Testing AND
		bit AND = bit.and(newBit);
		Assert.assertEquals(AND, 00);
		Assert.assertEquals(AND, 01);
		//Testing OR
		bit OR = bit.or(newBit);
		Assert.assertEquals(OR, 00);
		Assert.assertEquals(OR, 01);
		//Testing XOR
		bit XOR = bit.xor(newBit);
		Assert.assertEquals(XOR, 00);
		Assert.assertEquals(XOR, 01);
		//Testing NOT
		bit NOT = bit.not();
		Assert.assertEquals(NOT, 00);
		Assert.assertEquals(NOT, 01);
		
		//Converting string to bits
		
	}

  }

