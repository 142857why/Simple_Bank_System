public class ControlDate {
    public static String twoDigit(int x) {
        String returnString = null;

        if (x >= 10) returnString = String.valueOf(x);
        if (x < 10) returnString = "0" + String.valueOf(x);

        return returnString;
    }
}
