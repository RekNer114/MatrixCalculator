package GUI;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    public JTextArea matrixInput;
    JScrollPane matrixScroll;
    JPanel buttonsPanel;
    JTextField coefficient;
    FunctionButtons determinant, multiplyBy, transpose;


    InputPanel(Rectangle r, JFrame listener, String name)
    {
        this.setBounds(r);
        this.setLayout(new BorderLayout(10, 10));


        matrixInput = new JTextArea(10, 30);
        matrixScroll = new JScrollPane(matrixInput);


        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1,5, 5));


        determinant = new FunctionButtons("Determinant", listener, buttonsPanel);

        multiplyBy = new FunctionButtons("Multiply", listener, buttonsPanel);
        multiplyBy.setLayout(new BorderLayout());
        coefficient = new JTextField(1);
        coefficient.setPreferredSize(new Dimension(30, 20));
        multiplyBy.add(coefficient, BorderLayout.EAST);

        transpose = new FunctionButtons("Transpose", listener, buttonsPanel);


        this.add(new JLabel("Matrix "+ name +":"),  BorderLayout.NORTH);
        this.add(matrixScroll,BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        matrixInput.setPreferredSize(new Dimension(80, 80));
    }
}
