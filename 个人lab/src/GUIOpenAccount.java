import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class GUIOpenAccount extends JFrame implements ActionListener {

    private JPanel panelInfo, panelControl, panelDateSelect;
    private JLabel lbName, lbAddress, lbDateBirth;
    private JButton btOkay, btCancel;
    private JTextField textFieldName, textFieldAddress;
    public GUIOpenAccount() {
        this.setTitle("Welcome to Bank of Rui Zhou!");
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        panelInfo = new JPanel();
        panelControl = new JPanel();
        panelDateSelect = new JPanel();

        panelDateSelect.setBorder(new EmptyBorder(30, 40, 40, 40));
        panelDateSelect.setLayout(new FlowLayout());
        final JComboBox year = new JComboBox();
        year.setModel(new DefaultComboBoxModel(getModel(1978, 2018)));
        panelDateSelect.add(year);
        final JComboBox month = new JComboBox();
        month.setModel(new DefaultComboBoxModel(getModel(1, 12)));
        panelDateSelect.add(month);
        final JComboBox day = new JComboBox();
        panelDateSelect.add(day);
        year.addItemListener(e -> setDay(year, month, day));
        month.addItemListener(e -> setDay(year, month, day));
        setDay(year, month, day);

        panelInfo.setLayout(new GridLayout(4, 2, 30, 30));
        panelControl.setLayout(new FlowLayout());

        lbName = new JLabel("Name:", SwingConstants.CENTER);
        lbAddress = new JLabel("Address", SwingConstants.CENTER);
        lbDateBirth = new JLabel("Please select your date of birth", SwingConstants.CENTER);

        textFieldName = new JTextField(SwingConstants.CENTER);
        textFieldAddress = new JTextField(SwingConstants.CENTER);

        panelInfo.add(lbName);
        panelInfo.add(textFieldName);
        panelInfo.add(lbAddress);
        panelInfo.add(textFieldAddress);
        panelInfo.add(lbDateBirth);
        panelInfo.add(panelDateSelect);

        btOkay = new JButton("OK");
        btCancel = new JButton("Cancel");
        panelControl.add(btOkay);
        panelControl.add(btCancel);

        this.add(panelInfo, BorderLayout.CENTER);
        this.add(panelControl, BorderLayout.SOUTH);
        new GUIInit().initFrame(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * calculate days in select month & year
     */
    private void setDay(JComboBox year, JComboBox month, JComboBox day) {
        int y = Integer.parseInt((String) year.getSelectedItem());
        int m = Integer.parseInt((String) month.getSelectedItem());
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, y);
        c.set(Calendar.MONTH, m - 1);
        int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        day.setModel(new DefaultComboBoxModel(getModel(1, days)));
    }

    /**
     * get String array [start, end]
     */
    private String[] getModel(int start, int end) {
        String[] m = new String[end - start + 1];
        for (int i = 0; i < m.length; i++) {
            m[i] = String.valueOf(i + start);
        }
        return m;
    }
}
