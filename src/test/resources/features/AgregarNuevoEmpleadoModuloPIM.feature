@stories
Feature: Agregar empleado en el modulo PIM
  Como administrador del aplicativo orangehrm
  Quiero ingresar al aplicativo de orangehrm
  Para agregar un nuevo empleado a la lista

  @Scenario1
  Scenario Outline: Agregar un nuevo empleado en el modulo PIM
    Given que el administrador del aplicativo se autentica con usuario "<usuario>" y contraseña "<contraseña>"
    When el administrador del aplicativo ingresa y da clic en el modulo PIM
    And le da clic en el boton add
    And valida que el usuario ingrese al formulario "Add Employee"
    Then el administrador diligencia el formulario Add Employee con las datos basicos del empleado
    And selecciona la opccion Save

    Examples:
      | usuario | contraseña |
      | Admin   | admin123   |
