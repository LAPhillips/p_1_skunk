package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RollAdvisorTest {
	

	@Test
	void advisor_shares_type_special_rolls() {
		RollAdvisor advisor = new RollAdvisor();
		int[]advisors = new int[] {1,1};
		RollTypes expected = RollTypes.NORMAL;
		RollTypes special = advisor.getRollType();
		assertEquals(expected, special); //default is Normal
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
	

	

}
