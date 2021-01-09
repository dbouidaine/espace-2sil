$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/com/Features/matrixFeature.feature");
formatter.feature({
  "name": "calcul determinent",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "scenario 1",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "j\u0027ai un calculateur de determinant",
  "keyword": "Given "
});
formatter.match({
  "location": "determinantSteps.jAiUnCalculateurDeDeterminant()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "j\u0027ai une matrice carré",
  "rows": [
    {
      "cells": [
        "2",
        "5",
        "3"
      ]
    },
    {
      "cells": [
        "3",
        "1",
        "-2"
      ]
    },
    {
      "cells": [
        "2",
        "6",
        "1"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "determinantSteps.jAiUneMatriceCarré(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "le resultat du determinant 39.0",
  "keyword": "Then "
});
formatter.match({
  "location": "determinantSteps.leResultatDuDeterminant(double)"
});
formatter.result({
  "status": "passed"
});
});