import java.io.*;
import java.util.ArrayList;

public class IOAccount {
    /**
     * @param dir the given file need to be deleted
     */
    public static void deleteAccount(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteAccount(file);
            } else {
                file.delete();
            }
        }
        dir.delete();
    }

    /**
     * @param accountName the account number needs to be processed later
     * @param newPIN1 the new PIN needs to be set
     */
    public static void changePIN(String accountName, String newPIN1) {
        File myFile = new File("./account/" + accountName, "PIN.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(newPIN1);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * update the account information based on the following information
     * @param accountName the account number needs to be processed later
     * @param accountType the account type, use a integer to represent
     * @param balance the current balance
     */
    public static void writeAccount(String accountName, String accountType, String balance) {
        File myFile = new File("./account/" + accountName, "account.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(accountType + "\n");
            bufferedWriter.write(balance + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param accountName the account number needs to be processed later
     * @param depositMoney the previous deposit money
     */
    public static void writeUncleared(String accountName, Double depositMoney) {
        File myFileUnCleared = new File("./account/" +accountName, "uncleared.txt");
        MyDate nowDate = new MyDate();
        String timeStamp = "" + nowDate.getYear() + ControlDate.twoDigit(nowDate.getMonth()) + ControlDate.twoDigit(nowDate.getDate());

        try {
            FileWriter fileWriter = new FileWriter(myFileUnCleared, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(timeStamp + "@" + depositMoney + "\n");
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param accountName the account number needs to be processed later
     */
    public static void clearDeposit(String accountName) {
        File myFileUnCleared = new File("./account/" +accountName, "uncleared.txt");

        Double nowBalance = Double.parseDouble(ControlAccount.getBalanceType(accountName, true));
        int accountType = ControlAccount.typeString2Number(ControlAccount.getBalanceType(accountName, false));

        MyDate nowDate = new MyDate();
        String timeStamp = "" + nowDate.getYear() + ControlDate.twoDigit(nowDate.getMonth()) + ControlDate.twoDigit(nowDate.getDate());

        ArrayList<String> unclearedRecord = new ArrayList<>();
        String oneRecord;
        String[] oneRecordArray;
        try {
            FileReader fileReader = new FileReader(myFileUnCleared);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            oneRecord = bufferedReader.readLine();

            while (!(oneRecord==null)) {
                unclearedRecord.add(oneRecord);
                oneRecord = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (unclearedRecord==null)
            return;
        else {
            try {
                FileWriter fileWriter = new FileWriter(myFileUnCleared);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (int i = 0; i < unclearedRecord.size(); i++) {
                    oneRecord = unclearedRecord.get(i);
                    oneRecordArray = oneRecord.split("@");
                    String tempTime = oneRecordArray[0];
                    Double tempMoney = Double.parseDouble(oneRecordArray[1]);

                    if (!timeStamp.equals(tempTime)) {
                        nowBalance += tempMoney;
                    }
                    else {
                        //System.out.println("更新unclear记录");
                        bufferedWriter.write(oneRecord + "\n");
                    }
                }

                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeAccount(accountName, String.valueOf(accountType), String.valueOf(nowBalance));
        }

    }
}
