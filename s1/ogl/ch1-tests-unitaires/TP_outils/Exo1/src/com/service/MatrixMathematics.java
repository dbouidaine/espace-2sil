package com.service;

import com.exception.NoSquareException;
import com.model.Matrix;

public class MatrixMathematics {

    public static double determinant(Matrix matrix) throws NoSquareException {
        if (!matrix.isSquare())
            throw new NoSquareException("matrix need to be square.");
        if (matrix.size() == 1){
            return matrix.getValueAt(0, 0);
        }

        if (matrix.size()==2) {
            return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
        }
        double sum = 0.0;
        for (int i=0; i<matrix.getNcols(); i++) {
            sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
        }
        return sum;
    }

    public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
        Matrix mat = new Matrix(matrix.getNrows()-1, matrix.getNcols()-1);
        int r = -1;
        for (int i=0;i<matrix.getNrows();i++) {
            if (i==excluding_row)
                continue;
            r++;
            int c = -1;
            for (int j=0;j<matrix.getNcols();j++) {
                if (j==excluding_col)
                    continue;
                mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
            }
        }
        return mat;
    }

    private static int changeSign(int i) {
        if (i%2==0)
            return 1;
        return -1;
    }
}
