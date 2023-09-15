package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FunctionButtons extends JButton {

    FunctionButtons(String name, JFrame listener, JPanel addTo)
    {
        this.setFocusable(false);
        this.setText(name);
        this.addActionListener((ActionListener) listener);
        addTo.add(this);
    }
}
