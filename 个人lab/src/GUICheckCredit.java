import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUICheckCredit extends JFrame {
    private JProgressBar processBar;

    /**
     * @param userName the username
     * @param address the user's address
     * @param birthday the user's birthday
     * @param accountType the user's account type
     */
    public GUICheckCredit(String userName, String address, String birthday, String accountType) {
        boolean creditFlag = ControlCredit.checkBlackList(userName, address, birthday, accountType);

        this.setTitle("Checking Credit...");
        this.setSize(600, 175);
        this.setResizable(false);
        this.setLocationRelativeTo(this.getOwner());

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

        processBar = new JProgressBar();

        processBar.setStringPainted(true);

        processBar.setBackground(Color.WHITE);

        new Thread(() -> {
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                processBar.setValue(i);
            }
            processBar.setString("Credit Check Complete!");
            try {
                Thread.sleep(2000);
                dispose();
                if (!creditFlag) {
                    String accountName = IOOpenAccount.newAccount(birthday, accountType);
                    new GUIInitAccountInfo(this, accountName, birthday).setVisible(true);
                }
                else {
                    new GUIOpenAccount();
                    JOptionPane.showMessageDialog(this,
                            "You can't open an Account since you are in poor credit :-(",
                            "Sorry...", JOptionPane.ERROR_MESSAGE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start(); //  start the process bar thread

        contentPane.add(processBar);

        this.setVisible(true);
    }
}
