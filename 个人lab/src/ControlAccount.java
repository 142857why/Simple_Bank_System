import java.io.*;


public class ControlAccount {
    public static boolean checkAccountExist(String accountName) {
        File myFile = new File("./account/" + accountName, "account.txt");
        if (myFile.exists()) return true; else return false;
    }

    public static boolean checkSuspend(String accountName) {
        File myFile = new File("./account/" + accountName,  "suspend.txt");
        int suspendFlag = 0;
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            suspendFlag = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
            fileReader.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        if (suspendFlag == 0) return false; else return true;
    }

    public static boolean checkPassword(String accoutName, String givenPIN) {
        File myFile = new File("./account/" + accoutName, "PIN.txt");
        String correctPIN;
        boolean flag = false;
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            correctPIN = bufferedReader.readLine();
            if (givenPIN.equals(correctPIN)) flag = true;
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return flag;
    }

    public static void suspendAccount(String accountName, boolean flag) {
        File myFile = new File("./account/" + accountName,  "suspend.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (flag) {
                bufferedWriter.write("1\n");
            }
            else {
                bufferedWriter.write("0\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteAccount(String accountName) {
        String filePath = "./account/" + accountName;
        File dir = new File(filePath);
        IOAccount.deleteAccount(dir);
    }

    public static String getBalanceType(String accountName, boolean flag) {
        String balance = null;
        int typeInt;
        String type = null;
        File myFile = new File("./account/" + accountName, "account.txt");
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            typeInt = Integer.parseInt(bufferedReader.readLine());
            switch (typeInt) {
                case 0:
                    type = "Saver";
                    break;
                case 1:
                    type = "Junior";
                    break;
                case 2:
                    type = "Current";
                    break;
            }
            balance = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag) return balance; else return type;
    }

}
