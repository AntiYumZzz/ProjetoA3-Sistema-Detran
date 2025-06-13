import javax.swing.*;
import java.awt.*;

class CaixaTexto extends JTextField {
    private String placeholder;

    public CaixaTexto(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont());
            g2.drawString(placeholder, 5, getHeight() / 2 + getFont().getSize() / 2 - 4);
            g2.dispose();
        }
    }
}

