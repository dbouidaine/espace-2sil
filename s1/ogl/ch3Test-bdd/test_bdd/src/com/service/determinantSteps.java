package com.service;

import com.exception.NoSquareException;
import com.model.Matrix;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;

public class determinantSteps {
    private MatrixMathematics matrixMathematics;
    private double result;

    @Given("j'ai un calculateur de determinant")
    public void jAiUnCalculateurDeDeterminant() {
        matrixMathematics = new MatrixMathematics();
    }

    @When("j'ai une matrice carré")
    public void jAiUneMatriceCarré(DataTable dataTable) throws NoSquareException {
        List<List<Double>> rows = dataTable.asLists(Double.class);

        double[][] data = rows.stream()
                .map(l -> l.stream().mapToDouble(Double::doubleValue).toArray())
                .toArray(double[][]::new);
        Matrix matrix=new Matrix(data);
        result=matrixMathematics.determinant(matrix);
    }

    @Then("le resultat du determinant {double}")
    public void leResultatDuDeterminant(double expected) {
        Assert.assertEquals(expected,result,0.001);
    }

}
