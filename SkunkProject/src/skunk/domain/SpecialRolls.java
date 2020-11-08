package skunk.domain;

	public enum SpecialRolls{
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

