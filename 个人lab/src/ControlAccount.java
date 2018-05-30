import java.io.*;


public class ControlAccount {
    /**
     * @param accountName the account number that needs to be checked
     * @return whether or not the account is exist
     */
    public static boolean checkAccountExist(String accountName) {
        File myFile = new File("./account/" + accountName, "account.txt");
        if (myFile.exists()) return true; else return false;
    }

    /**
     * @param accountName the account number that needs to be checked
     * @return whether or not the account has been suspended
     */
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

    /**
     * @param accountName the account number that needs to be checked
     * @param givenPIN the PIN that needs to be checked
     * @return whether or not the password is right
     */
    public static boolean checkPassword(String accountName, String givenPIN) {
        File myFile = new File("./account/" + accountName, "PIN.txt");
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

    /**
     * @param accountName the account number that needs to be processed
     * @param flag whether or not to suspend the given account
     */
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

    /**
     * @param accountName the account number that needs to be delete
     */
    public static void deleteAccount(String accountName) {
        String filePath = "./account/" + accountName;
        File dir = new File(filePath);
        IOAccount.deleteAccount(dir);
    }

    /**
     * @param accountName the account number that needs to be checked
     * @param flag if flag is true, then return balance else return type
     * @return balance or account type based on the flag
     */
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

    /**
     * @param str "Saver", "Junior" or "Current"
     * @return a integer that can represent the type
     */
    public static int typeString2Number(String str) {
        int result = 0;
        if (str.equals("Saver")) {
            result = 0;
        }
        else if (str.equals("Junior")) {
            result = 1;
        }
        else if (str.equals("Current")){
            result = 2;
        }

        return result;
    }

    /**
     * @param accountName the account number that needs to be processed
     * @param depositMoney money that needs to be deposit
     * @param depositType "clear" or "unclear"
     * @return whether or not the deposit is successful
     */
    public static boolean depositAccount(String accountName, Double depositMoney, int depositType) {
        //0 is cash
        //1 is unclered

        boolean isClear = false;
        int accountType = typeString2Number(getBalanceType(accountName, false));
        Double nowBalance = Double.parseDouble(getBalanceType(accountName, true));

        switch (depositType) {
            case 0:
                nowBalance += depositMoney;
                IOAccount.writeAccount(accountName, String.valueOf(accountType), String.valueOf(nowBalance));
                isClear = true;
                break;
            case 1:
                IOAccount.writeUncleared(accountName, depositMoney);
                isClear = false;
                break;
        }
        return isClear;
    }

    /**
     * @param accountName the account number that needs to be processed
     * @param withdrawMoney  money that needs to be withdraw
     * @param type the account type,
     *             0 for Saver
     *             1 for Junior
     *             2 for Current
     * @return -1 for not enough money;
     */
    public static int withdrawAccount(String accountName, Double withdrawMoney, int type) {
        //0 : Saver：needs warning, returnFlag = 1
        //1:  Junior
        //2:  Current：can over Withdraw
        int returnFlag = 0;
        Double nowBalance = Double.parseDouble(getBalanceType(accountName, true));
        if (type==2) {
            if (nowBalance + 1000 < withdrawMoney) {
                returnFlag = -1; //not enough money
            }
            else {
                nowBalance -= withdrawMoney;
                IOAccount.writeAccount(accountName, String.valueOf(type), String.valueOf(nowBalance));
                returnFlag = 0;
            }
        }
        else if (type==0) {
            if (nowBalance < withdrawMoney) {
                returnFlag = -1;
            }
            else
            {
                nowBalance -= withdrawMoney;
                IOAccount.writeAccount(accountName, String.valueOf(type), String.valueOf(nowBalance));
                returnFlag = 1; //needs warning
            }
        }
        else if (type==1) {
            if (nowBalance < withdrawMoney) {
                returnFlag = -1;
            }
            else
            {
                nowBalance -= withdrawMoney;
                IOAccount.writeAccount(accountName, String.valueOf(type), String.valueOf(nowBalance));
                returnFlag = 0; //needs warning
            }
        }
        return returnFlag;
    }
}
