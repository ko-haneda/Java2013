package ch06.ex06_03;

public class ex06_03 implements Verbose {
	Message level = Message.SILENT;

	public static void main(String[] args) {
		ex06_03 test = new ex06_03();
		test.setVerbosity(Message.TERSE);
		switch (test.getVerbosity()) {
		case SILENT:
			System.out.println("silent");
			break;
		case TERSE:
			System.out.println("terse");
			break;
		case NORMAL:
			System.out.println("normal");
			break;
		case VERBOSE:
			System.out.println("verbose");
			break;
		default:
			break;
		}
	}

	public void setVerbosity(Message level) {
		this.level = level;
	}

	public Message getVerbosity() {
		return this.level;
	}

}

interface Verbose {
	enum Message {
		SILENT, TERSE, NORMAL, VERBOSE
	}
	void setVerbosity(Message level);
	Message getVerbosity();
}
