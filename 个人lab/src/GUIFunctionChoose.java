import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFunctionChoose extends JFrame implements ActionListener {

    private JPanel panelControl, panelInfo, panelOpenAccount, panelManageAccount;
    private JButton btExit;
    public GUIFunctionChoose() {
        this.setTitle("Welcome to Bank of Rui Zhou!");
        this.setResizable(false);
        panelInfo = new JPanel();
        panelOpenAccount = new JPanel();
        panelManageAccount = new JPanel();

        JButton btOpenAccount = new JButton("Open Account");
        JButton btManageAccount = new JButton("Manage Account");
        Font f = new Font("Consolas",Font.BOLD, 48);
        btOpenAccount.setFont(f);
        btManageAccount.setFont(f);

        panelOpenAccount.setBorder(new EmptyBorder(30, 40, 40, 40));
        panelOpenAccount.add(btOpenAccount, CENTER_ALIGNMENT);

        panelManageAccount.setBorder(new EmptyBorder(30, 40, 40, 40));
        panelManageAccount.add(btManageAccount, CENTER_ALIGNMENT);

        panelInfo.setLayout(new GridLayout(0, 1, 5, 5));

        //panelInfo.add(btManageAccount, CENTER_ALIGNMENT);
        //panelInfo.add(btOpenAccount, CENTER_ALIGNMENT);
        panelInfo.add(panelOpenAccount);
        panelInfo.add(panelManageAccount);

        panelControl = new JPanel();
        btExit = new JButton("Exit");
        btExit.addActionListener(e -> dispose());
        panelControl.add(btExit);
        this.add(panelControl, BorderLayout.SOUTH);
        this.add(panelInfo, BorderLayout.CENTER);
        new GUIInit().initFrame(this);

        btOpenAccount.addActionListener(e-> {
            dispose();
            new GUIOpenAccount();
        });

        btManageAccount.addActionListener(e-> {
            dispose();
            new GUIManageAccount();
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
