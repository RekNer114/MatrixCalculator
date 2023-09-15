package logic;

import GUI.InputPanel;

import javax.swing.*;

public class MatrixOperation {
    //addition
    public int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int[][] result = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int[][] result = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    public int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {

            int rowsA = matrixA.length;
            int colsA = matrixA[0].length;
            int colsB = matrixB[0].length;
            int[][] result = new int[rowsA][colsB];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
            return result;
        }


        //operation with 1 matrix
    public int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            //for a 1x1 matrix
            return matrix[0][0];
        } else if (n == 2) {
            // for a 2x2 matrix
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int determinant = 0;

            for (int col = 0; col < n; col++) {
                int [][] subMatrix = new int[n - 1][n - 1];
                for (int i = 1; i < n; i++) {
                    for (int j = 0, k = 0; j < n; j++) {
                        if (j == col) {
                            continue;
                        }
                        subMatrix[i - 1][k] = matrix[i][j];
                        k++;
                    }
                }
                determinant += (int) (matrix[0][col] * Math.pow(-1, col) * calculateDeterminant(subMatrix));
            }

            return determinant;
        }
    }


    //multiply matrix
    public int[][] multiplyBy(int[][] matrix, int coefficient) {

        for (int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j<matrix[i].length; j++)
            {
                matrix[i][j] *= coefficient;
            }
        }

        return matrix;
    }

    //transposeMatrix
    public int[][] transpose(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] transposedMatrix = new int[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
    public int[][] readMatrix(InputPanel matrix) {
        String text = matrix.matrixInput.getText();
        String[] rows = text.split("\n");

        int numOfRows = rows.length;
        int numOfCols = rows[0].split("\\s+").length;

        int[][] res = new int[numOfRows][numOfCols];

        for (int i = 0; i < numOfRows; i++)
        {
            String[] values = rows[i].split("\\s+");
            for (int j = 0; j<numOfCols; j++)
            {
                try {
                    res[i][j] = Integer.parseInt(values[j]);
                }
                catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Enter numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            }

        //printMatrix(res);
        return res;
    }
}
