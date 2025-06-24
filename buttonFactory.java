import javax.swing.*;
import java.awt.event.ActionListener;

public class buttonFactory {
    public static JButton createButton(String label, ActionListener action) {
        JButton button = new JButton(label);
        button.addActionListener(action);
        return button;
    }
}
