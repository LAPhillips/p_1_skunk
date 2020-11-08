package skunk.domain;

public enum SpecialRolls {
	SKUNK, //1,x
	DOUBLE_SKUNK, // 1,1
	SKUNK_DEUCE; // 1,2

	private enum rollsToString{
		SKUNK {
			@Override
			public String toString() {
				return "Skunk";
			}
		},
		
		DOUBLE_SKUNK {
			@Override
			public String toString() {
				return "Two Skunks";
			}
		},
		SKUNK_DEUCE {
			@Override
			public String toString() {
				return "Skunk and Deuce";
			}
		};
	}
}
