import java.awt.*;

public class GUIWarningSuspend extends GUIWarningMessage{
    public GUIWarningSuspend(Frame owner, String accountName) {
        super(owner);
        lbMessage.setText("Are you sure to SUSPEND the account?");
        btConfirm.addActionListener(e-> {
            this.dispose();
            this.getOwner().dispose();
            ControlAccount.suspendAccount(accountName, true);
            new GUIManageAccount();
        });

    }

}
