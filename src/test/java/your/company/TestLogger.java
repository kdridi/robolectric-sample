package your.company;

public class TestLogger {

	public static void debug(String format, Object... args) {
		final String message = String.format(format, args);
		System.out.println(message);
	}

}
