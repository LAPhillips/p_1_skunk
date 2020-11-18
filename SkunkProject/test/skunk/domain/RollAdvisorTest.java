package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RollAdvisorTest {


	@Test
	void advisor_checks_for_special_rolls() {
		RollAdvisor advisor = new RollAdvisor();
		int [] firstRoll = new int[] {2,3};
		Boolean roll1 = advisor.isSpecial(firstRoll);
		assertFalse(roll1);
		
		int[] secondRoll = new int[] {1, 1};
		Boolean roll2 = advisor.isSpecial(secondRoll);
		assertTrue(roll2);
		
		int[] thirdRoll = new int[] {2,1};
		Boolean roll3 = advisor.isSpecial(thirdRoll);
		assertTrue(roll3);	
		
		int[] fourthRoll = new int[] {3, 1};
		Boolean roll4 = advisor.isSpecial(fourthRoll);
		assertTrue(roll4);
		
		int[] fifthRoll = new int[] {1,3};
		Boolean roll5 = advisor.isSpecial(thirdRoll);
		assertTrue(roll5);	
		
		int[] sixthRoll = new int[] {1,2};
		Boolean roll6 = advisor.isSpecial(sixthRoll);
		assertTrue(roll6);	
	}
	

	@Test
	void advisor_categorizes_special_rolls() {
		RollAdvisor advisor = new RollAdvisor();
		int[]advisors = new int[] {1,1};
		advisor.setRollType(advisors);
		RollTypes special = advisor.getRollType();
		RollTypes expected = RollTypes.DOUBLE_SKUNK;
		assertEquals(expected, special);
		
		int[]advisors2 = new int[] {2,1};
		advisor.setRollType(advisors2);
		special = advisor.getRollType();
		expected = RollTypes.SKUNK_DEUCE;
		assertEquals(expected, special);
		
		int[]advisors3 = new int[] {5,1};
		advisor.setRollType(advisors3);
		special = advisor.getRollType();
		expected = RollTypes.SKUNK;
		assertEquals(expected, special);
	}
	
	@Test
	void advisor_shares_type_special_rolls() {
		RollAdvisor advisor = new RollAdvisor();
		int[]advisors = new int[] {1,1};
		RollTypes expected = RollTypes.NORMAL;
		RollTypes special = advisor.getRollType();
		assertEquals(expected, special); //default is Normal
	}
	

}
