import java.io.*;

public class ControlCredit {
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
