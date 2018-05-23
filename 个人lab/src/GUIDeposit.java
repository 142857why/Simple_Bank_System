import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDeposit extends JFrame implements ActionListener {

    private JLabel lbDepositMessage;
    private JLabel lbAccountNumber;
    private JTextField textFieldDeposit;
    private JButton btDeposit;
    private JButton btReturn;
    private JTextField textFieldAccountNumber;
    private JLabel lbDepositType;
    private JComboBox comboBoxDepositType;

    public GUIDeposit() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbDepositMessage = new JLabel();
        lbAccountNumber = new JLabel();
        textFieldDeposit = new JTextField();
        btDeposit = new JButton();
        btReturn = new JButton();
        textFieldAccountNumber = new JTextField();
        lbDepositType = new JLabel();
        comboBoxDepositType = new JComboBox();

        //======== this ========
        setTitle("Welcome to Bank of Rui Zhou!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbDepositMessage ----
        lbDepositMessage.setText("How much money would you like to deposit?");
        lbDepositMessage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(lbDepositMessage);
        lbDepositMessage.setBounds(28, 130, 385, 60);

        //---- lbAccountNumber ----
        lbAccountNumber.setText("Please enter the account number you wish to deposit:");
        lbAccountNumber.setFont(new Font("Consolas", Font.BOLD, 16));
        contentPane.add(lbAccountNumber);
        lbAccountNumber.setBounds(30, 35, 480, 70);
        contentPane.add(textFieldDeposit);
        textFieldDeposit.setBounds(410, 150, 225, 30);

        //---- btDeposit ----
        btDeposit.setText("Deposit");
        contentPane.add(btDeposit);
        btDeposit.setBounds(640, 150, 145, btDeposit.getPreferredSize().height);

        //---- btReturn ----
        btReturn.setText("Return");
        btReturn.setIcon(UIManager.getIcon("FileView.computerIcon"));
        btReturn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(btReturn);
        btReturn.setBounds(260, 400, 300, 80);
        contentPane.add(textFieldAccountNumber);
        textFieldAccountNumber.setBounds(510, 55, 225, 30);

        //---- lbDepositType ----
        lbDepositType.setText("Please Select the Type You Wish to Deposit:");
        lbDepositType.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        contentPane.add(lbDepositType);
        lbDepositType.setBounds(135, 230, 270, 60);

        comboBoxDepositType.addItem("Cash(Cleared)");
        comboBoxDepositType.addItem("Cheque(uncleared)");
        contentPane.add(comboBoxDepositType);
        comboBoxDepositType.setBounds(490, 245, 120, comboBoxDepositType.getPreferredSize().height);

        new GUIInit().initFrame(this);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //--------
        btReturn.addActionListener(e -> {
            dispose();
            new GUIManageAccount();
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
