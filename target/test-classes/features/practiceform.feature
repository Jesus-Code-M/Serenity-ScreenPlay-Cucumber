Feature: Llenar el formulario de Practice Form de ToolsQA

  Scenario: Llenar Nombre, Apellido y Email del Formulario
    Given el usuario ingresa a la url de PracticeForm
    When el usuario llena el nombre con "John" y el apellido con "Doe"
    And el usuario toma un screenshot llamado "Formulario_Test"
    And el usuario ajusta el zoom de la página al "60%"
    And el usuario toma un screenshot llamado "Zoom_60%"
    When el usuario ingresa el email "john.doe@example.com"
    And el usuario toma un screenshot llamado "Formulario_Email"

  Scenario: Marcar los tres radio button de Género
    Given el usuario marca radio button Male
    When el usuario marca radio button Female
    Then el usuario marca radio button Other
    And el usuario ingresa el numero de telefono "1234567890"
    And el usuario toma un screenshot llamado "Formulario_ButtonGender"
