import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIWarningMessage extends JDialog implements ActionListener {
    public GUIWarningMessage(Frame owner) {
        super(owner);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        btConfirm = new JButton();
        btCancel = new JButton();
        lbMessage = new JLabel();

        //======== this ========
        setTitle("Warning!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- btConfirm ----
        btConfirm.setText("Yes! I understand!");
        contentPane.add(btConfirm);
        btConfirm.setBounds(100, 90, 190, btConfirm.getPreferredSize().height);

        //---- btCancel ----
        btCancel.setText("Cancel");
        contentPane.add(btCancel);
        btCancel.setBounds(new Rectangle(new Point(375, 90), btCancel.getPreferredSize()));

        //---- lbMessage ----
        lbMessage.setText("Are you shure you want to do this?");
        lbMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lbMessage.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(lbMessage);
        lbMessage.setBounds(75, 45, 450, lbMessage.getPreferredSize().height);

        new GUIInit().initDialog(this);
        btCancel.addActionListener(e-> dispose());
//        contentPane.setPreferredSize(new Dimension(600, 175));
//        pack();
//        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JButton btConfirm;
    JButton btCancel;
    JLabel lbMessage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
