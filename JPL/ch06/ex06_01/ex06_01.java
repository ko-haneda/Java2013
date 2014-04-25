package ch06.ex06_01;

enum EnumWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUTURDAY, SUNDAY
}

enum TraficSignal {
	BLUE, YELLOW, RED
}

public class ex06_01 {
	public static void main(String[] args) {
		EnumWeek e_week = EnumWeek.SUNDAY;

		switch (e_week) {
		case SUNDAY:
			System.out.println("sunday");
			break;
		case MONDAY:
			System.out.println("monday");
			break;
		case TUESDAY:
			System.out.println("tuesday");
			break;
		case WEDNESDAY:
			System.out.println("wednesday");
			break;
		case THURSDAY:
			System.out.println("thursday");
			break;
		case FRIDAY:
			System.out.println("friday");
			break;
		case SUTURDAY:
			System.out.println("suturday");
			break;
		default:
			throw new InternalError();
		}

		TraficSignal e_Signal = TraficSignal.RED;

		switch (e_Signal) {
		case BLUE:
			System.out.println("進む");
			break;
		case YELLOW:
			System.out.println("気をつけて進む");
			break;
		case RED:
			System.out.println("止まれ");
			break;
		default:
			throw new InternalError();
		}

	}
}