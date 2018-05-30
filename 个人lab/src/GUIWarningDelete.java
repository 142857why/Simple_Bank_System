import javax.swing.*;
import java.awt.*;

public class GUIWarningDelete extends GUIWarningMessage{
    public GUIWarningDelete(Frame owner, String accountName) {
        super(owner);
        lbMessage.setText("Are you sure to DELETE this account?");
        btConfirm.addActionListener(e -> {
            Double nowBalance = Double.parseDouble(ControlAccount.getBalanceType(accountName, true));
            if (nowBalance>1e-7) {
                JOptionPane.showMessageDialog(this,
                        "You can't delete the account right now :-(",
                        "Sorry...", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
            else {
                this.dispose();
                //don't forget to check the condition for delete
                this.getOwner().dispose();
                ControlAccount.deleteAccount(accountName);
                new GUIManageAccount();
            }
        });
    }
}
