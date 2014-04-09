package ch10.ex10_03;

enum EnumWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class ex10_03 {
	//コード量的にswitchを使用した方が少なく済むので、switchを使用した方が多少明瞭になる。
	//もし、月曜日から日曜日まですべて条件に入れる場合は絶対switchのほうが良い。
	public static void main(String[] args) {
		EnumWeek e_week = EnumWeek.SATURDAY;
		if(isWeekday1(e_week))	System.out.println("働く");
		else					System.out.println("休み");
		if(isWeekday2(e_week))	System.out.println("働く");
		else					System.out.println("休み");
	}
	
	public static boolean isWeekday1(EnumWeek e_week){
		if(e_week == EnumWeek.SATURDAY || e_week == EnumWeek.SUNDAY)
			return false;
		else
			return true;
	}
	public static boolean isWeekday2(EnumWeek e_week){
		switch(e_week){
			case SATURDAY: case SUNDAY:		
				return false;
			default:
				return true;
		}
	}

}