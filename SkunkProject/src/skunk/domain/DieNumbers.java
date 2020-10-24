package skunk.domain;

public class DieNumbers {

	public static int randomOneToSix() {
		int result = (int) (Math.random() * 6 + 1);
		return result;
	}

}
