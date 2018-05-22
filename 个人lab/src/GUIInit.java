import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIInit extends JFrame implements ActionListener {

    void initFrame(JFrame myFrame) {
        //when trying to call this method, remember to pass this
        myFrame.setSize(800, 600);
        myFrame.setLocation(400, 150);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(myFrame.getOwner());
        myFrame.setVisible(true);
    }

    void initDialog(JFrame myFrame) {
        myFrame.setSize(240, 180);
        myFrame.setLocation(900, 300);
        //myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
