import java.io.*;

public class ControlCredit {
    /**
     * @param userName the username
     * @param address the user's address
     * @param birthday the user's birthday
     * @param accountType the user's account type
     * @return whether or not the user is in the blacklist
     */
    public static boolean checkBlackList(String userName, String address, String birthday, String accountType) {
        boolean flag = false;

        String checkString = userName + "@" + address + "@" + birthday;
        File myFile = new File("./records", "blacklist.txt");
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneline = bufferedReader.readLine();
            while ((oneline!=null)) {
                if (oneline.equals(checkString)) {
                    flag = true;
                    break;
                }
                oneline = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        new IOOpenAccount().writeRecord(userName, address, birthday, accountType);
        return flag;
    }
}
