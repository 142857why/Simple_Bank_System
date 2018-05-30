public class ControlInput {
    /**
     * @param str the user's input for the money
     * @return whether ot not the user entering a correct money
     */
    public static boolean CheckInputMoney(String str) {
        boolean finalFlag = true;
        char c;
        if (str.length()==0) finalFlag = false;
        if (str.charAt(0)=='.')
            finalFlag = false;
        else {
            int indexDot = str.indexOf('.');
            //System.out.println(indexDot);
            for (int i = 0; i < indexDot; i++) {
                c = str.charAt(i);
                if (!checkNumber(c)) {
                    finalFlag = false;
                    break;
                }
            }
            for (int i = indexDot + 1; i < str.length(); i++) {
                c = str.charAt(i);
                if (!checkNumber(c)) {
                    finalFlag = false;
                    break;
                }
            }
        }
        return finalFlag;
    }

    /**
     * @param c the given char needs to be checked
     * @return whether or not c is a digit
     */
    public static boolean checkNumber(char c) {
        boolean flag = false;
        if ((c>='0') && (c<='9')) flag = true;
        return flag;
    }

}
