package day0110_arr1;

class MyDate {

	private int year;
	private int month;
	private int day;

	// 디폴트생성자
	public MyDate() {

	}

	// 명시적생성자_생성과 동시에 초기화 가능
	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}

	// setter
	public void setYear(int y) {
		this.year = y;
	}

	public void setMonth(int m) {
		this.month = m;
	}

	public void setDay(int d) {
		this.day = d;
	}

	// getter
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

}

public class MyDate_14 {

	public static void main(String[] args) {

		MyDate m1 = new MyDate(2024, 01, 10);

		int year = m1.getYear();
		int month = m1.getMonth();
		int day = m1.getDay();

		System.out.println(year + "-" + month + "-" + day);

		MyDate m2 = new MyDate();

		m2.setYear(2022);
		m2.setMonth(9);
		m2.setDay(11);

		int y = m2.getYear();
		int m = m2.getMonth();
		int d = m2.getDay();

		System.out.println(y + "년" + m + "월" + d + "일");

	}

}
