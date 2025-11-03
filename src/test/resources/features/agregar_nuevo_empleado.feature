@stories
Feature: Agregar/Consultar empleado en el modulo PIM
  Como administrador del aplicativo orangehrm
  Quiero ingresar al aplicativo de orangehrm
  Para agregar un nuevo empleado a la lista y posterior consultarlo

  @Scenario1
  Scenario Outline: Agregar un nuevo empleado en el modulo PIM
    Given que el administrador del aplicativo se autentica con usuario "<usuario>" y contraseña "<contraseña>"
    When el administrador del aplicativo ingresa y da clic en el modulo PIM
    And le da clic en el boton add
    And valida que el usuario ingrese al formulario "Add Employee"
    Then el administrador adjunta la foto del empleado y diligencia el formulario Add Employee con las datos basicos del empleado
    And selecciona la opccion Save
    When el administrador navega al módulo de directorio
    And realizan la búsqueda por el nombre del empleado
    Then el aplicativo deberá mostrar una ficha con el hombre del empleado

    Examples:
      | usuario | contraseña |
      | Admin   | admin123   |
