#lenguaje:es
#Autor: Yesid Sanabria Rey
@stories
Feature: Guia Tecnica Analista Financial
  Como usuario
  Quiero poder ingresar al aplicativo de choucair
  Para hacer uso de los curso que ofrece la pagina

  @Scenario1
  Scenario Outline: Ingresar al curso Guias Tecnicas Analista Financial
    Given que el usuario se autentica con usuario "<usuario>" y contraseña "<contraseña>"
    When el usuario en el menú da clic en la opción "Mis cursos"
    And accede al curso "Guias Técnicas - Analista Financial"
    Then el aplicativo muestra el curso "Guías Técnicas - Analista Financial"

    Examples:
      | usuario    | contraseña    |
      | 1010040480 | Choucair2021* |
