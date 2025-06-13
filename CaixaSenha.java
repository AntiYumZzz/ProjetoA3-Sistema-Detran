import javax.swing.*;
import java.awt.*;

class CaixaSenha extends JPasswordField {
    private String placeholder;

    public CaixaSenha(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getPassword().length == 0 && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont());
            g2.drawString(placeholder, 5, getHeight() / 2 + getFont().getSize() / 2 - 4);
            g2.dispose();
        }
    }
}
