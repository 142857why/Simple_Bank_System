import java.io.*;

public class IOAccount {
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
}
