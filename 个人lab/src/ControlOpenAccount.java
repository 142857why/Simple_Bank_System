public class ControlOpenAccount {
    /**
     * @param year the year of user's birthday
     * @param month the month of user's birthday
     * @param date the date of user's birthday
     * @return whether or not the user's age is above 16
     */
    public boolean isAgeAbove16(int year, int month, int date) {
        boolean flag;
        MyDate nowDate = new MyDate();
        double age = (nowDate.getYear() - year) + (nowDate.getMonth() - month)/12.0 + (nowDate.getDate() - date) / 365.0;
        if ((age-16) > 1e-7) flag = true; else flag = false;
        return flag;
    }
}
