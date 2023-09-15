package GUI;

import logic.MatrixOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
        InputPanel firstMatrix, secondMatrix;
        OutputPanel out;
        JPanel operationWithBoth;
        FunctionButtons add, subtract, multiply;
        int [][] result;
        MatrixOperation op =  new MatrixOperation();
        public MainFrame()
        {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(new Dimension(600, 600));
            this.setLayout(null);
            this.setResizable(false);

            //input
            firstMatrix = new InputPanel(new Rectangle(15, 0, 150, this.getHeight()-300), this, "A");
            secondMatrix = new InputPanel(new Rectangle(435, 0, 150,this.getHeight()-300), this, "B");
            //output
            out = new OutputPanel(this);
            out.setBounds(225, 300, 150, 200);

            //operations with both
            operationWithBoth =  new JPanel();
            operationWithBoth.setLayout(new GridLayout(3, 1, 5, 5));
            operationWithBoth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            operationWithBoth.setBounds(250, 110, 100, 100);


            add = new FunctionButtons("A + B", this, operationWithBoth);
            subtract = new FunctionButtons("A - B", this, operationWithBoth);
            multiply = new FunctionButtons("A x B", this, operationWithBoth);




             this.setVisible(true);
             this.add(firstMatrix);
             this.add(secondMatrix);
             this.add(operationWithBoth);
             this.add(out);
        }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            //
        if(e.getSource().equals(add))
        {
            int[][] a = op.readMatrix(firstMatrix);
            int[][] b = op.readMatrix(secondMatrix);

            result = op.addMatrices(a, b);
            printMatrix(result);

        }
        //
        if(e.getSource().equals(subtract))
        {
            int[][] a = op.readMatrix(firstMatrix);
            int[][] b = op.readMatrix(secondMatrix);

            result = op.subtractMatrices(a, b);
            printMatrix(result);
        }
        //
        if(e.getSource().equals(multiply))
        {
            int[][] a = op.readMatrix(firstMatrix);
            int[][] b = op.readMatrix(secondMatrix);
            if(a[0].length == b.length)
            {
                result = op.multiplyMatrices(a, b);
                printMatrix(result);
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                        "Matrix multiplication is not possible due to incompatible dimensions.");
            }
        }

        if(e.getSource().equals(out.insertIn))
        {
            insertIn();
        }

        determinant(e, firstMatrix);

        determinant(e, secondMatrix);

    }

    private void determinant(ActionEvent e, InputPanel panel) {
        if (e.getSource().equals(panel.determinant))
        {
            int[][] a = op.readMatrix(panel);
            printNumber(op.calculateDeterminant(a));

        }
        if (e.getSource().equals(panel.transpose))
        {
            int[][] a = op.readMatrix(panel);
            printMatrix(op.transpose(a));
        }
        if (e.getSource().equals(panel.multiplyBy))
        {
            int[][] a = op.readMatrix(panel);
            try {
                int coefficient = Integer.parseInt(panel.coefficient.getText());
                printMatrix(op.multiplyBy(a, coefficient));
            }catch (Exception error)
            {
                JOptionPane.showMessageDialog(this, "Enter number!", "Error", JOptionPane.ERROR_MESSAGE);
            }



        }
    }


    private void printMatrix(int [][] matrix)
    {
        //clear text field
        out.matrixOutput.setText("");

        for (int[] ints : matrix) {
            for (int anInt : ints) {

                out.matrixOutput.append(anInt + " ");
            }
            out.matrixOutput.append("\n");
        }
    }
    private void insertIn()
    {
        String matrix = out.matrixOutput.getText();
        if(out.nameOfMatrix.getText().equalsIgnoreCase("A"))
        {
            firstMatrix.matrixInput.setText(matrix);

        }
        else if(out.nameOfMatrix.getText().equalsIgnoreCase("B"))
        {
            secondMatrix.matrixInput.setText(matrix);
        }else
        {
            JOptionPane.showMessageDialog(null, "Enter name of matrix(A or B)", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printNumber(int res)
    {
        out.matrixOutput.setText("");
        out.matrixOutput.append(res + "");
    }

}
