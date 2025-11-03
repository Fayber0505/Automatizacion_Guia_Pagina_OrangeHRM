Feature: Consulta de empleados en OrangeHRM API

  Como automatizador de pruebas
  Quiero consultar el endpoint de empleados
  Para validar el código de estado, estructura y datos retornados

  Scenario: Obtener lista de empleados activos
    Given que el usuario tiene acceso a la API de OrangeHRM
    When consulta la lista de empleados
    Then el servicio debe responder con estado 200
    And la respuesta debe contener al menos un empleado
    And el primer empleado debe tener nombre "Fayber Yesid"
