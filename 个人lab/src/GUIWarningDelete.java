import java.awt.*;

public class GUIWarningDelete extends GUIWarningMessage{
    public GUIWarningDelete(Frame owner) {
        super(owner);
        lbMessage.setText("Are you sure to DELETE this account?");
        btConfirm.addActionListener(e -> {
            this.dispose();
            //不要忘记检查，必须欠款为0才能delete
            this.getOwner().dispose();
            new GUIManageAccount();
        });
    }
}
