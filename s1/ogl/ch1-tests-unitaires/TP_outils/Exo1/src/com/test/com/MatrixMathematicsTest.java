package com.test.com;

import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import org.junit.Test;
import static org.junit.Assert.*;


public class MatrixMathematicsTest {
    @Test (expected = NoSquareException.class)
    public void determinantMatrixNoSquare() throws NoSquareException {
        /*test de l'exception NoSquareException*/
        /*création d'une matrice non carée (2,1)*/
        Matrix matrix=new Matrix(2,1);
        MatrixMathematics.determinant(matrix);
    }
    @Test
    public void determinantSize1() throws NoSquareException {
        /*test de la méthode determinant dans le cas d'une matrice avec un seul élément*/
        /*création d'une matrice carée (1,1) avec un seul élément '5'*/
        Matrix matrix=new Matrix(1,1);
        matrix.setValueAt(0,0,5);
        /*le résultat attendu=5 */
        assertEquals(5,MatrixMathematics.determinant(matrix),0.001);
    }
    @Test
    public void determinantSize2() throws NoSquareException {
        /*test de la méthode determinant dans le cas d'une matrice 2,2 (size=2)*/
        /*création d'une matrice carée (2,2) */
        Matrix matrix=new Matrix(2,2);
        matrix.setValueAt(0,0,2);
        matrix.setValueAt(0,1,4);
        matrix.setValueAt(1,0,1);
        matrix.setValueAt(1,1,0.5);
        /*le résultat attendu=-3 */
        assertEquals(-3,MatrixMathematics.determinant(matrix),0.001);
    }
    @Test
    public void determinant() throws NoSquareException {
        /*test de la méthode determinant dans le cas d'une matrice avec size>2*/
        /*création d'une matrice carée (3,3) */
        Matrix matrix=new Matrix(3,3);
        matrix.setValueAt(0,0,5);
        matrix.setValueAt(0,1,3);
        matrix.setValueAt(0,2,2);
        matrix.setValueAt(1,0,-7);
        matrix.setValueAt(1,1,5);
        matrix.setValueAt(1,2,-8);
        matrix.setValueAt(2,0,2);
        matrix.setValueAt(2,1,1);
        matrix.setValueAt(2,2,5);
        /*le résultat attendu=188 */
        assertEquals(188,MatrixMathematics.determinant(matrix),0.001);
    }
}