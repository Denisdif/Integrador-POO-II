# Especificación de requisitos de software

## Enunciado del problema

Se debe implementar un sistema para la reserva de turnos en un centro de masajes para mejorar la organización y el aprovechamiento del tiempo del mismo. Cada vez que se atiende a un cliente nuevo se debe completar un formulario de información donde se solicita sus nombres, apellidos, dirección, fecha de nacimiento, número de teléfono y una lista de problemas físicos si los tuviese (prótesis, antecedentes de lesiones, problemas de articulaciones, etc.). Cuando un paciente se comunica por teléfono o de manera presencial para programar una nueva cita (o cambiar una existente) la usuaria del sistema verifica el archivo de citas para ver los espacios de tiempo disponible. Una vez que se encuentra un lugar para el cliente, se programa la cita. Cada cita puede tener tiene asignada uno o más tipos de masajes.

El sistema debe permitir listar clientes, turnos por cliente y turnos en general en orden cronológico a partir del más reciente o próximo, dependiendo si son realizados o por realizar, respectivamente. También deben poder listarse todos juntos. Se debe considerar que se puede dar de baja una cita y la misma queda disponible para ser reutilizada. Además, se debe llevar un control de los pacientes que no acuden a las citas programadas.

## Clientes potenciales

Centro de masajes "Bienestar".

## Solución propuesta 

Escriban algunas oraciones que describan cómo la solución de software resolverá el problema descrito anteriormente.

**Requisitos funcionales**: enumeren los requisitos *(funcionales)* que debe tener el software para resolver el problema mencionado anteriormente. Es útil tratar de agrupar los requisitos en los que son esenciales *(debe estar)* y los que no son esenciales *(sería bueno que estén)*.
 
## Arquitectura de software

¿Será esta una aplicación web / de escritorio / móvil *(todas o algún otro tipo)*? ¿Se ajustaría a la arquitectura de software Cliente-Servidor? 