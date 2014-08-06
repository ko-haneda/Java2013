package ex02_04;

import java.util.Calendar;

public class Time {

	public static String getTime() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		StringBuffer sb = new StringBuffer(" ");
		if (hour < 10)
			sb.append(0);
		sb.append(hour);
		sb.append(":");
		if (minute < 10)
			sb.append(0);
		sb.append(minute);
		sb.append(":");
		if (second < 10)
			sb.append(0);
		sb.append(second);
		sb.append("  ");
		return sb.toString();
	}
}