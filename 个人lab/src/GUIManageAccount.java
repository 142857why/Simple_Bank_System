import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIManageAccount extends JFrame implements ActionListener {
    private JLabel lbAccountNumber;
    private JTextField textFieldAccount;
    private JLabel lbPIN;
    private JPasswordField passFieldPIN;
    private JButton btLogin;
    private JButton btDeposit;
    private JButton btReturn;

    public GUIManageAccount() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbAccountNumber = new JLabel();
        textFieldAccount = new JTextField();
        lbPIN = new JLabel();
        passFieldPIN = new JPasswordField();
        btLogin = new JButton();
        btDeposit = new JButton();
        btReturn = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("Welcome to the Bank of Rui Zhou!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbAccountNumber ----
        lbAccountNumber.setText("Account Number:");
        lbAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lbAccountNumber.setFont(lbAccountNumber.getFont().deriveFont(Font.BOLD|Font.ITALIC, lbAccountNumber.getFont().getSize() + 5f));
        contentPane.add(lbAccountNumber);
        lbAccountNumber.setBounds(140, 105, 215, 100);

        //---- textFieldAccount ----
        textFieldAccount.setFont(textFieldAccount.getFont().deriveFont(textFieldAccount.getFont().getSize() + 2f));
        contentPane.add(textFieldAccount);
        textFieldAccount.setBounds(365, 130, 265, 50);

        //---- lbPIN ----
        lbPIN.setText("PIN:");
        lbPIN.setHorizontalAlignment(SwingConstants.CENTER);
        lbPIN.setFont(lbPIN.getFont().deriveFont(Font.BOLD|Font.ITALIC, lbPIN.getFont().getSize() + 5f));
        contentPane.add(lbPIN);
        lbPIN.setBounds(145, 220, 215, 100);
        contentPane.add(passFieldPIN);
        passFieldPIN.setBounds(365, 245, 265, 50);

        //---- btLogin ----
        btLogin.setText("Login");
        contentPane.add(btLogin);
        btLogin.setBounds(520, 345, 110, 40);

        //---- btDeposit ----
        btDeposit.setText("I only want to deposit");
        btDeposit.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        contentPane.add(btDeposit);
        btDeposit.setBounds(175, 345, 235, 40);

        //---- btReturn ----
        btReturn.setText("Return");
        contentPane.add(btReturn);
        btReturn.setBounds(675, 345, 78, 40);

        new GUIInit().initFrame(this);

        btReturn.addActionListener(e -> {
            dispose();
            new GUIFunctionChoose();
        });

        //----------------login section
        btLogin.addActionListener(e-> {
            String accountName = textFieldAccount.getText();

            String givenPIN = String.valueOf(passFieldPIN.getPassword());
            boolean checkExist = ControlAccount.checkAccountExist(accountName);
            if (!checkExist) {
                JOptionPane.showMessageDialog(this,
                        "Account Not Exist!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                boolean checkDispose = ControlAccount.checkSuspend(accountName);
                if (checkDispose) {
                    int reuseChoice = JOptionPane.showConfirmDialog(this,
                            "The Account has been suspended. Would you like to Re-instated?",
                            "Warning", JOptionPane.YES_NO_OPTION);

                    if (reuseChoice==0) {
                        boolean checkPIN = ControlAccount.checkPassword(accountName, givenPIN);
                        if (!checkPIN) {
                            JOptionPane.showMessageDialog(this,
                                    "Wrong password",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            ControlAccount.suspendAccount(accountName, false);
                            dispose();
                            IOAccount.clearDeposit(accountName);
                            new GUIWithdrawSuspendClose(accountName);
                        }
                    }

                }
                else {
                    boolean checkPIN = ControlAccount.checkPassword(accountName, givenPIN);
                    if (checkPIN) {
                        dispose();
                        IOAccount.clearDeposit(accountName);
                        new GUIWithdrawSuspendClose(accountName);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,
                                "Wrong password",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btDeposit.addActionListener(e -> {
            dispose();
            new GUIDeposit();
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
