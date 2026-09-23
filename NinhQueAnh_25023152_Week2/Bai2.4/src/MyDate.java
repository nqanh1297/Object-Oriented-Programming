public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int day,int month,int year) {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public MyDate(MyDate other) {
        this.day=other.day;
        this.month=other.month;
        this.year=other.year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void printDate() {
        System.out.println(day+"/"+month+"/"+year);
    }
}
