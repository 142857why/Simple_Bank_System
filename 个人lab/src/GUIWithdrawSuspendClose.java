import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIWithdrawSuspendClose extends JFrame implements ActionListener {
    private JLabel lbWithdrawMessage;
    private JLabel lbBalance;
    private JLabel lbOverlimit;
    private JTextField textFieldWithdraw;
    private JButton btWithdraw;
    private JLabel lbNumBalance;
    private JLabel lbNumOverlimit;
    private JLabel lbAccountType;
    private JLabel lbAccountTypeString;
    private JButton btSuspend;
    private JButton btDelete;
    private JButton btReturn;
    private JButton btChangePIN;

    public GUIWithdrawSuspendClose() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbWithdrawMessage = new JLabel();
        lbBalance = new JLabel();
        lbOverlimit = new JLabel();
        textFieldWithdraw = new JTextField();
        btWithdraw = new JButton();
        lbNumBalance = new JLabel();
        lbNumOverlimit = new JLabel();
        lbAccountType = new JLabel();
        lbAccountTypeString = new JLabel();
        btSuspend = new JButton();
        btDelete = new JButton();
        btReturn = new JButton();
        btChangePIN = new JButton();

        //======== this ========
        setTitle("Welcome to Bank of Rui Zhou!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbWithdrawMessage ----
        lbWithdrawMessage.setText("How much money would you like to withdraw?");
        lbWithdrawMessage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(lbWithdrawMessage);
        lbWithdrawMessage.setBounds(28, 130, 385, 60);

        //---- lbBalance ----
        lbBalance.setText("Balance:");
        lbBalance.setFont(new Font("Consolas", Font.BOLD, 16));
        contentPane.add(lbBalance);
        lbBalance.setBounds(30, 35, 159, lbBalance.getPreferredSize().height);

        //---- lbOverlimit ----
        lbOverlimit.setText("Overdraft Limit:");
        lbOverlimit.setFont(new Font("Consolas", Font.BOLD, 16));
        contentPane.add(lbOverlimit);
        lbOverlimit.setBounds(30, 70, 159, 19);
        contentPane.add(textFieldWithdraw);
        textFieldWithdraw.setBounds(410, 150, 225, 30);

        //---- btWithdraw ----
        btWithdraw.setText("Withdraw");
        contentPane.add(btWithdraw);
        btWithdraw.setBounds(640, 150, 145, btWithdraw.getPreferredSize().height);

        //---- lbNumBalance ----
        lbNumBalance.setText("balabala");
        lbNumBalance.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbNumBalance);
        lbNumBalance.setBounds(280, 35, 145, lbNumBalance.getPreferredSize().height);

        //---- lbNumOverlimit ----
        lbNumOverlimit.setText("$1000.00");
        lbNumOverlimit.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbNumOverlimit);
        lbNumOverlimit.setBounds(279, 70, 145, 16);

        //---- lbAccountType ----
        lbAccountType.setText("Account Type:");
        lbAccountType.setFont(new Font("Consolas", Font.BOLD, 16));
        contentPane.add(lbAccountType);
        lbAccountType.setBounds(470, 45, 159, 19);

        //---- lbAccountTypeString ----
        //显示账户类型
        lbAccountTypeString.setText("Saver");
        lbAccountTypeString.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbAccountTypeString);
        lbAccountTypeString.setBounds(620, 45, 145, 16);

        //---- btSuspend ----
        btSuspend.setText("Suspend Account");
        btSuspend.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
        btSuspend.setFont(new Font("Arial Black", Font.PLAIN, 18));
        contentPane.add(btSuspend);
        btSuspend.setBounds(261, 327, 300, 80);

        //---- btDelete ----
        btDelete.setText("Delete   Account");
        btDelete.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
        btDelete.setFont(new Font("Arial Black", Font.PLAIN, 18));
        contentPane.add(btDelete);
        btDelete.setBounds(260, 406, 300, 80);

        //---- btReturn ----
        btReturn.setText("Return");
        btReturn.setIcon(UIManager.getIcon("FileView.computerIcon"));
        btReturn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(btReturn);
        btReturn.setBounds(260, 485, 300, 80);

        //---- btChangePIN ----
        btChangePIN.setText("Change PIN");
        btChangePIN.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        btChangePIN.setFont(new Font("Arial Black", Font.PLAIN, 18));
        contentPane.add(btChangePIN);
        btChangePIN.setBounds(260, 249, 300, 80);

        contentPane.setPreferredSize(new Dimension(800, 600));
        this.pack();
        new GUIInit().initFrame(this);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //----------------
        btReturn.addActionListener(e -> {
            dispose();
            new GUIManageAccount();
        });

        btSuspend.addActionListener(e -> {
            new GUIWarningSuspend(this);
        });

        btDelete.addActionListener(e -> {
            new GUIWarningDelete(this);
        });

        btChangePIN.addActionListener(e -> {
            this.dispose();
            new GUIChangePIN(); //注意这儿的调用得带着account number
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
