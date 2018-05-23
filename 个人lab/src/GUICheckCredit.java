import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUICheckCredit extends JFrame {
    private JProgressBar processBar;

    public GUICheckCredit(String userName, String address, String birthday, String accountType) {
        boolean creditFlag = ControlCredit.checkBlackList(userName, address, birthday, accountType);
        //new IOOpenAccount().writeRecord(userName, address, birthday, accountType);
        this.setTitle("Checking Credit...");
        this.setSize(600, 175);
        this.setResizable(false);
        this.setLocationRelativeTo(this.getOwner());

        JPanel contentPane = new JPanel();   // 创建内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置内容面板边框
        setContentPane(contentPane);// 应用(使用)内容面板
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));// 设置为流式布局

        processBar = new JProgressBar();// 创建进度条

        processBar.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示

        processBar.setBackground(Color.WHITE);

        // 创建线程显示进度
        new Thread(() -> {
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(20);  //   让当前线程休眠0.1ms
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                processBar.setValue(i);	// 设置进度条数值
            }
            processBar.setString("Credit Check Complete!");// 设置提示信息
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
        }).start(); //  启动进度条线程

        contentPane.add(processBar);// 向面板添加进度控件

        this.setVisible(true);
    }
}
