# Caso de uso 1:

# Nombre del caso de uso: Seleccionar médico
## Descripción breve: Un paciente desea seleccionar un médico para tener su turno
## Actor primario: Paciente
## Trigger: El caso de uso comienza cuando un Paciente quiere Seleccionar un médico
## Curso básico:
El caso de uso comienza cuando un Paciente quiere seleccionar un médico en el sistema para tener un turno con el mismo. El sistema le da la opción de filtrar médicos por especialidad y obra social.
## Curso basico:
1. El sistema filtra según las preferencias del paciente.
2. El sistema le ofrece un listado de médicos que cumplen con los requisitos seleccionados por el paciente.
3. El Paciente elige un médico.
4. El caso de uso finaliza.
## Curso alternativo:
2. El sistema le ofrece un listado de médicos que cumplen con los requisitos seleccionados por el paciente.
2.1. El sistema informa que no existen médicos que cumplan sus requisitos.
2.2. Se retoma el curso básico en el paso 2.
## Suposición: Supongo que el paciente se registró y logueó en el sistema.

### Caso de uso 2:

## Nombre caso de uso: Seleccionar Turno
## Descripción breve: El paciente quiere seleccionar un turno 
## Actor primario: Paciente
## Trigger: El caso de uso comienza cuando un paciente quiere seleccionar    un turno
## Curso Básico
    1- El caso de uso comienza cuando un paciente quiere seleccionar un turno
    2- El sistema mostrará los turnos disponibles
    3- El paciente selecciona un turno
    4- El sistema solicitará al paciente que reconfirme sus datos personales
    5- El paciente ingresa su nombre, apellido, dirección teléfono, email, obra social y número de afiliado
    6- El sistema verifica que los datos personales son los correctos
    7- El sistema dará la opción de imprimir los datos del turno
    8- El paciente decide que quiere imprimir los datos del turno(alternativo el no)
    9- El sistema imprime datos del turno
    10- El sistema verifica si la obra social del paciente el medico lo cubre al 100%
    11- El sistema registra el turno
    12- El sistema brindará un detalle del turno registrado, y él mismo lo enviará por mail
    13- El caso de uso finaliza
## Caso alternativo
    6.El sistema verifica que los datos personales son los correctos
    6.1 El sistema identifica que los datos no son los correctos
    6.2 Se retoma el curso básico en el paso 5.

    8. El paciente decide que quiere imprimir los datos del turno.
    8.1 El paciente decide que no quiere imprimir los datos.
    8.2 Se retoma el curso básico en el paso 9.
    10. El sistema verifica si la obra social del paciente el médico lo cubre al 100%
    10.1 El sistema identifica que el médico no cubre la obra social o cobra un diferencial.
    10.2 El sistema da la opción de cambiar médico o seguir con el turno. 
    10.3 El paciente elige cambiar de médico.
    10.4 Se retoma el curso básico en el paso 9.
    
    10.2 El sistema da la opción de cambiar médico o seguir con el turno.
    10.2.1 El sistema da la opción de cambiar médico o seguir con el turno. 
    10.2.2  El paciente decide seguir con el turno.
    10.2.3  Se retoma el curso básico en el paso 9.
## Postcondición: Se registró el turno.
## Suposición: El paciente ya se encuentra registrado y logueado.

# Caso de uso 3:

## Nombre caso de uso: Seleccionar rango fechas y horarios
## Descripción breve: Una vez seleccionado el médico, se muestran los días y horarios en los que atiende y se puede elegir filtrar si el turno es de mañana o tarde
## Actor primario: Paciente
## Trigger: El caso de uso comienza cuando el Paciente selecciona el médico.
##Curso Básico
   1. El Caso de Uso comienza cuando el Paciente selecciona el médico.
   2. El Sistema solicita un rango de fechas para mostrar los turnos disponibles.
   3. El Paciente ingresa un rango de fechas.
   4. Si el Paciente quiere elegir una franja horaria el Sistema presenta las opciones disponibles:
   * Mañana 	  * Tarde
   5. El Paciente selecciona una franja horaria.
   6. El Sistema actualiza la franja horaria.
   7. El Caso de Uso finaliza.
## Cursos alternativos: 
 El Paciente no selecciona una franja horaria.
  4.  Si el Paciente quiere elegir una franja horaria el Sistema presenta las opciones disponibles:
   * Mañana 	  * Tarde
  4.1 El Paciente no desea elegir una franja horaria.
  4.2 El Caso de Uso finaliza.

## Suposiciones: Los turnos de los médicos están cargados. El Paciente está registrado correctamente.
## Casos de uso que extiende: -.
## Casos de uso incluidos: -.
## Finalización del caso de uso: Se desarrolló correctamente. Finalizó en el curso alternativo.