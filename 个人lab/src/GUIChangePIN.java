import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIChangePIN extends JFrame implements ActionListener {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbNewPIN1;
    private JPasswordField passFieldNewPIN1;
    private JButton btReturn;
    private JLabel lbOldPIN;
    private JPasswordField passFieldOldPIN;
    private JLabel lbNewPIN2;
    private JPasswordField passFieldNewPIN2;
    private JButton btOK;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public GUIChangePIN() {
        lbNewPIN1 = new JLabel();
        passFieldNewPIN1 = new JPasswordField();
        btReturn = new JButton();
        lbOldPIN = new JLabel();
        passFieldOldPIN = new JPasswordField();
        lbNewPIN2 = new JLabel();
        passFieldNewPIN2 = new JPasswordField();
        btOK = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("Be Careful to Choose your PIN");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lbNewPIN1 ----
        lbNewPIN1.setText("New PIN:");
        lbNewPIN1.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewPIN1.setFont(lbNewPIN1.getFont().deriveFont(Font.BOLD|Font.ITALIC, lbNewPIN1.getFont().getSize() + 5f));
        contentPane.add(lbNewPIN1);
        lbNewPIN1.setBounds(145, 217, 215, 100);
        contentPane.add(passFieldNewPIN1);
        passFieldNewPIN1.setBounds(365, 240, 265, 50);

        //---- btReturn ----
        btReturn.setText("Return");
        contentPane.add(btReturn);
        btReturn.setBounds(670, 480, 78, 40);

        //---- lbOldPIN ----
        lbOldPIN.setText("Original PIN:");
        lbOldPIN.setHorizontalAlignment(SwingConstants.CENTER);
        lbOldPIN.setFont(lbOldPIN.getFont().deriveFont(Font.BOLD|Font.ITALIC, lbOldPIN.getFont().getSize() + 5f));
        contentPane.add(lbOldPIN);
        lbOldPIN.setBounds(150, 95, 215, 100);
        contentPane.add(passFieldOldPIN);
        passFieldOldPIN.setBounds(365, 120, 265, 50);

        //---- lbNewPIN2 ----
        lbNewPIN2.setText("Confirm New PIN:");
        lbNewPIN2.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewPIN2.setFont(lbNewPIN2.getFont().deriveFont(Font.BOLD|Font.ITALIC, lbNewPIN2.getFont().getSize() + 5f));
        contentPane.add(lbNewPIN2);
        lbNewPIN2.setBounds(145, 330, 215, 100);
        contentPane.add(passFieldNewPIN2);
        passFieldNewPIN2.setBounds(365, 355, 265, 50);

        //---- btOK ----
        btOK.setText("Okay");
        contentPane.add(btOK);
        btOK.setBounds(560, 480, 78, 40);

        new GUIInit().initFrame(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
