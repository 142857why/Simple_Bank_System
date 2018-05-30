import java.io.*;

public class IOOpenAccount {
    /**
     * this method takes a record for further credit check
     * @param name the user's name
     * @param address the user's address
     * @param birthday the user's birthday
     * @param accountType the user's account type
     */
    public void writeRecord(String name, String address, String birthday, String accountType) {
        MyDate nowDate = new MyDate();
        File myFile = new File("./records", nowDate.toString() + "_application.txt");
        try {
            myFile.createNewFile();
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Name: " + name + "\n");
            bufferedWriter.write("Address: " + address + "\n");
            bufferedWriter.write("BirthDay: " + birthday + "\n");
            bufferedWriter.write("Type: " + accountType + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param birthday the user's birthday
     * @param accountType the user's account type
     * @return the account name for further processing
     */
    public static String newAccount(String birthday, String accountType) {

        //return the accountName
        int type = 0;
        if (accountType.equals("Saver")) type = 0;
        if (accountType.equals("Junior")) type = 1;
        if (accountType.equals("Current")) type = 2;

        MyDate nowDate = new MyDate();
        String accountName = "RZ" + nowDate.toString();
        new File("./account", accountName).mkdir();
        File myNewAccount = new File("./account/" + accountName, "account.txt");
        File myNewPIN = new File("./account/" + accountName, "PIN.txt");
        File mySuspend = new File("./account/" + accountName, "suspend.txt");
        File myUncleared  = new File("./account/" + accountName, "uncleared.txt");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(myNewAccount);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(type + "\n");
            bufferedWriter.write("0.01\n");
            bufferedWriter.close();
            fileWriter.close();

            fileWriter = new FileWriter(myNewPIN);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(birthday);
            bufferedWriter.close();
            fileWriter.close();

            fileWriter = new FileWriter(mySuspend);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("0");
            bufferedWriter.close();
            fileWriter.close();

            myUncleared.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountName;
    }
}

