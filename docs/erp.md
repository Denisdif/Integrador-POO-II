# Especificación de requisitos de software

## Enunciado del problema

Un centro de masajes experimenta problemas con la organización de las citas al no llevar un registro detallado de las mismas. Actualmente, las citas se programan mediante llamadas, mensajes de WhatsAppp o bien, personalmente. Las citas son registradas en una agenda de manera escrita, a pesar de los riesgos que esta práctica conlleva. Tachaduras, sobreescrituras, modificaciones y baja legibilidad generan malentendidos para la dueña del centro y ha ocurrido que se acumularon varias citas en una misma franja horaria, generando insatisfacción para los clientes. También ocurre que los clientes cancelan las citas y la dueña del centro no reprograma sus horarios en pos de aprovechar el tiempo de mejor manera, provocando espacios de tiempo improductivos entre turno y turno, lo que repercute en pérdida de dinero. La dueña tampoco lleva un registro de la información de sus clientes; esto provoca que por ejemplo, si un nuevo cliente se acercó al centro a programar una cita personalmente y la dueña se olvida de pedirle su número de teléfono, o bien le pide y luego no  encuentra el lugar donde lo anotó, no puede avisarle de un repentino cambio en su cita. Esto se debe, nuevamente, a la falta de organización de la información que tiene su centro.

## Descripción del sistema (esto no va, creo)

Se debe implementar un sistema para la reserva de turnos en un centro de masajes para mejorar la organización y el aprovechamiento del tiempo del mismo. Cada vez que se atiende a un cliente nuevo se debe completar un formulario de información donde se solicita sus nombres, apellidos, dirección, fecha de nacimiento, número de teléfono y una lista de problemas físicos si los tuviese (prótesis, antecedentes de lesiones, problemas de articulaciones, etc.). Cuando un paciente se comunica por teléfono o de manera presencial para programar una nueva cita (o cambiar una existente) la usuaria del sistema verifica el archivo de citas para ver los espacios de tiempo disponible. Una vez que se encuentra un lugar para el cliente, se programa la cita. Cada cita puede tener tiene asignada uno o más tipos de masajes.

El sistema debe permitir listar clientes, turnos por cliente y turnos en general en orden cronológico a partir del más reciente o próximo, dependiendo si son realizados o por realizar, respectivamente. También deben poder listarse todos juntos. Se debe considerar que se puede dar de baja una cita y la misma queda disponible para ser reutilizada. Además, se debe llevar un control de los pacientes que no acuden a las citas programadas.

## Clientes potenciales

Centro de masajes *Carelly*.

## Solución propuesta 

Escriban algunas oraciones que describan cómo la solución de software resolverá el problema descrito anteriormente.

**Requisitos funcionales**: enumeren los requisitos *(funcionales)* que debe tener el software para resolver el problema mencionado anteriormente. Es útil tratar de agrupar los requisitos en los que son esenciales *(debe estar)* y los que no son esenciales *(sería bueno que estén)*.

*(Debe estar)*
El sistema debe poder registrar un cliente.
El sistema debe poder visualizar los datos de un cliente.
El sistema debe poder editar los datos de un cliente.
El sistema debe poder dar de baja un cliente.

El sistema debe poder registrar un tipo de masaje.
El sistema debe poder visualizar los datos de un tipo de masaje.
El sistema debe poder editar los datos de un tipo de masaje.
El sistema debe poder dar de baja un tipo de masaje.

El sistema debe poder registrar un turno.
El sistema debe poder visualizar los datos de un turno.
El sistema debe poder editar los datos de un turno.
El sistema debe poder dar de baja un turno.

*(Sería bueno que estén)*
El sistema debe poder listar los turnos asociados a un cliente.
El sistema debe poder listar los turnos por dia.
El sistema debe poder informar si un cliente tiene inasistencias.
El sistema debe poder registrar la inasistencia de un cliente a un turno.
El sistema debe poder registrar los problemas físicos de los clientes.
## Arquitectura de software

Aplicación web - Cliente-Servidor
