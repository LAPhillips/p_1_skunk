package skunk.domain;

	public enum RollTypes{
		SKUNK {
			@Override
			public String toString() {
				return "Sorry, you rolled a Skunk! Your turn ends, and you lose 1 Chip.";
			}
		},
		
		DOUBLE_SKUNK {
			@Override
			public String toString() {
				return "Sorry, you rolled Two Skunks! Your turn ends, you lose all your points, and you lose 4 Chips.";
			}
		},
		SKUNK_DEUCE {
			@Override
			public String toString() {
				return "Sorry, you rolled a Skunk and Deuce! Your turn ends, and you lose 2 Chips";
			}
		},
		
		NORMAL {
			@Override
			public String toString() {
				return "Nice roll!";
			}
		};
	}

