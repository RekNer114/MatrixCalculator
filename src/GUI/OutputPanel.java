package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OutputPanel extends JPanel {
    JTextArea matrixOutput;
    JScrollPane matrixScroll;
    JButton insertIn;
    JTextField nameOfMatrix;

    OutputPanel(Object a)
    {
        this.setLayout(new BorderLayout(0, 5));

        matrixOutput = new JTextArea(10,30);
        matrixScroll = new JScrollPane(matrixOutput);

        nameOfMatrix = new JTextField(1);
        nameOfMatrix.setPreferredSize(new Dimension(30,20));


        insertIn = new JButton("Insert in");
        insertIn.setFocusable(false);
        insertIn.setLayout(new BorderLayout());
        insertIn.add(nameOfMatrix, BorderLayout.EAST);
        insertIn.addActionListener((ActionListener) a);

        this.add(new JLabel("Result"),  BorderLayout.NORTH);
        this.add(matrixScroll, BorderLayout.CENTER);
        this.add(insertIn, BorderLayout.SOUTH);
    }


}
