public class ControlDate {
    /**
     This is trying to change "0" to "00", "1" to "01", "2" to "02" and so on.
     * @param x the given integer
     * @return the String format of the number
     */
    public static String twoDigit(int x) {
        String returnString = null;

        if (x >= 10) returnString = String.valueOf(x);
        if (x < 10) returnString = "0" + String.valueOf(x);

        return returnString;
    }
}
