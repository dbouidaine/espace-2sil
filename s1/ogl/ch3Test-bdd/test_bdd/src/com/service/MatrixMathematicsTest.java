package com.service;
import com.exception.NoSquareException;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(Cucumber.class)
@CucumberOptions(features ="src/com/Features",plugin = {"pretty","html:report"})
public class MatrixMathematicsTest {

}