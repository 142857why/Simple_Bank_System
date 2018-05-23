import java.awt.*;

public class GUIWarningSuspend extends GUIWarningMessage{
    public GUIWarningSuspend(Frame owner) {
        super(owner);
        lbMessage.setText("Are you sure to SUSPEND the account?");
        btConfirm.addActionListener(e-> {
            this.dispose();
            this.getOwner().dispose();
            new GUIManageAccount();
        });
    }

}
