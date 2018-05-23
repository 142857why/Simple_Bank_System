import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIInitAccountInfo extends JDialog implements ActionListener {

    public GUIInitAccountInfo(Frame owner) {
        super(owner);
        initComponents();
    }

    public GUIInitAccountInfo(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        lbAccountMessage = new JLabel();
        lbPINMessage = new JLabel();
        btOkay = new JButton();
        lbAccount = new JLabel();
        lbPIN = new JLabel();
        laMessage = new JLabel();

        //======== this ========
        setTitle("IMPORTANT");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbAccountMessage ----
        lbAccountMessage.setText("This is your Account Number:");
        lbAccountMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lbAccountMessage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(lbAccountMessage);
        lbAccountMessage.setBounds(5, 40, 250, 25);

        //---- lbPINMessage ----
        lbPINMessage.setText("This is your intial PIN");
        lbPINMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lbPINMessage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(lbPINMessage);
        lbPINMessage.setBounds(5, 64, 250, 25);

        //---- btOkay ----
        btOkay.setText("Okay!");
        contentPane.add(btOkay);
        btOkay.setBounds(new Rectangle(new Point(285, 105), btOkay.getPreferredSize()));

        //---- lbAccount ----
        lbAccount.setText("bala");
        lbAccount.setFont(new Font("Segoe UI", Font.BOLD, 18));
        contentPane.add(lbAccount);
        lbAccount.setBounds(406, 40, 185, 25);

        //---- lbPIN ----
        lbPIN.setText("bala");
        lbPIN.setFont(new Font("Segoe UI", Font.BOLD, 18));
        contentPane.add(lbPIN);
        lbPIN.setBounds(405, 65, 185, 25);

        //---- laMessage ----
        laMessage.setText("Thank you for choosing Bank of RZ! You have good credit!");
        laMessage.setHorizontalAlignment(SwingConstants.CENTER);
        laMessage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        contentPane.add(laMessage);
        laMessage.setBounds(20, 5, 600, laMessage.getPreferredSize().height);

        new GUIInit().initDialog(this);

        btOkay.addActionListener(e-> {
            dispose();
            this.getOwner().dispose();
            new GUIFunctionChoose();
        });

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbAccountMessage;
    private JLabel lbPINMessage;
    private JButton btOkay;
    private JLabel lbAccount;
    private JLabel lbPIN;
    private JLabel laMessage;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
