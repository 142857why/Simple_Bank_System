import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class GUIOpenAccount extends JFrame implements ActionListener {

    private JPanel panelInfo, panelControl, panelDateSelect;
    private JLabel lbName, lbAddress, lbDateBirth, lbType;
    private JButton btOkay, btCancel;
    private JTextField textFieldName, textFieldAddress;

    public GUIOpenAccount() {
        this.setTitle("Thank you for choosing Bank Of Rui Zhou!");
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        panelInfo = new JPanel();
        panelControl = new JPanel();

        //---------------------------------------------
        panelDateSelect = new JPanel();
        panelDateSelect.setBorder(new EmptyBorder(30, 40, 40, 40));
        panelDateSelect.setLayout(new FlowLayout());
        final JComboBox<String> year = new JComboBox<>();
        year.setModel(new DefaultComboBoxModel<>(getModel(1978, 2018)));
        panelDateSelect.add(year);
        final JComboBox<String> month = new JComboBox<>();
        month.setModel(new DefaultComboBoxModel<>(getModel(1, 12)));
        panelDateSelect.add(month);
        final JComboBox<String> day = new JComboBox<String>();
        panelDateSelect.add(day);
        year.addItemListener(e -> setDay(year, month, day));
        month.addItemListener(e -> setDay(year, month, day));
        setDay(year, month, day);
        //------------------------------------------------

        panelInfo.setLayout(new GridLayout(4, 2, 30, 30));
        panelControl.setLayout(new FlowLayout());

        lbName = new JLabel("Name:", SwingConstants.CENTER);
        lbAddress = new JLabel("Address", SwingConstants.CENTER);
        lbDateBirth = new JLabel("Please select your date of birth", SwingConstants.CENTER);
        lbType = new JLabel("Please Select the Type of Account", SwingConstants.CENTER);

        textFieldName = new JTextField(SwingConstants.CENTER);
        textFieldAddress = new JTextField(SwingConstants.CENTER);

        JComboBox<String> comboBoxAccountType = new JComboBox<>();
        comboBoxAccountType.addItem("Saver");
        comboBoxAccountType.addItem("Junior");
        comboBoxAccountType.addItem("Current");

        panelInfo.add(lbName);
        panelInfo.add(textFieldName);
        panelInfo.add(lbAddress);
        panelInfo.add(textFieldAddress);
        panelInfo.add(lbDateBirth);
        panelInfo.add(panelDateSelect);
        panelInfo.add(lbType);
        panelInfo.add(comboBoxAccountType);

        btOkay = new JButton("OK");
        btCancel = new JButton("Cancel");
        panelControl.add(btOkay);
        panelControl.add(btCancel);

        this.add(panelInfo, BorderLayout.CENTER);
        this.add(panelControl, BorderLayout.SOUTH);
        new GUIInit().initFrame(this);

        btCancel.addActionListener(e-> {
            dispose();
            new GUIFunctionChoose().setVisible(true);
        });

        btOkay.addActionListener(e -> {
            //0, 1, 2
            //Saver, Junior, Current
            String accountType = String.valueOf(comboBoxAccountType.getSelectedItem());
            String userName = textFieldName.getText();
            String address = textFieldAddress.getText();

            int yearInt = Integer.parseInt((String) year.getSelectedItem());
            int monthInt = Integer.parseInt((String) month.getSelectedItem());
            int dayInt = Integer.parseInt((String) day.getSelectedItem());

            String birthday = getBirthday(yearInt, monthInt, dayInt);
            Boolean flag = new ControlOpenAccount().isAgeAbove16(yearInt, monthInt, dayInt);

            if ((flag) && accountType.equals("Junior")) {
                JOptionPane.showMessageDialog(this,
                        "You can't open a Junior Account since you are over 16!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                new GUICheckCredit(userName, address, birthday, accountType);
                dispose();
                //new GUIInitAccountInfo(this).setVisible(true);
            }

        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * calculate days in select month and year
     * @param  year the selected year
     * @param month the selected month
     * @param  day the selected day
     */
    private void setDay(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day) {
        int y = Integer.parseInt((String) year.getSelectedItem());
        int m = Integer.parseInt((String) month.getSelectedItem());
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m - 1);
        int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        day.setModel(new DefaultComboBoxModel<>(getModel(1, days)));
    }


    /**
     get all the string from start to end
     * @param start the start
     * @param end the end
     * @return a array of String
     */
    private String[] getModel(int start, int end) {
        String[] m = new String[end - start + 1];
        for (int i = 0; i < m.length; i++) {
            m[i] = String.valueOf(i + start);
        }
        return m;
    }

    /**
     * @param x the year
     * @param y the month
     * @param z the date
     * @return the correct String format of the birthday
     */
    private String getBirthday(int x, int y, int z) {
        String returnString = null;
        returnString = "" + String.valueOf(x) + ControlDate.twoDigit(y) + ControlDate.twoDigit(z);
        return returnString;
    }
}
