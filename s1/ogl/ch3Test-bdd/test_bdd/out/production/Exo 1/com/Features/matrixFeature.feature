Feature: calcul determinent
  Scenario:scenario 1
    Given j'ai un calculateur de determinant
    When j'ai une matrice carré
    | 2  | 5  | 3 |
    | 3  | 1  |-2 |
    | 2  | 6  | 1 |
    Then le resultat du determinant 39.0
