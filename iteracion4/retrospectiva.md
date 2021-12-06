# Retrospectiva 
En esta iteración tuvimos la complicación de que cambiaron los requerimientos del cliente. Esto provocó algunos contratiempos: tuvimos que realizar cambios sobre cosas que estaban hechas y, por el otro lado, cosas que tuvimos que agregar. 

Cosas que faltaron hacer:
- Desarrollar la vista para visualizar los datos del cliente.
- Permitir deshabilitar un tipo de masaje.
- Permitir editar los datos de todas las clases del sistema.
- Añadir tiempo de duración de tipo de masaje.
- Calcular el tiempo de duración del turno.
- Controlar que no se solapen los turnos.
- Permitir cancelar turnos.

El motivo del retraso fue el cambio de requerimiento del cliente, quien solicitó que sus clientes puedan registrarse en el sistema por su cuenta y solicitar las reservas ellos mismos. Para esto debimos implementar el sistema de Login mediante Spring Security; esto fue lo que más complicaciones nos generó. Para esto, implementamos roles y notamos que sería necesario eliminar la tabla cliente.

En cuanto a los requisitos funcionales del sistema, hubieron algunos cambios también:
- De la parte "deben estar", no se implementarán en el mínimo producto viable tres historias de usuario: historial de turnos, listar los turnos del día y cronograma semanal. Esto se debe a cambios por parte del cliente, quien considera más importante que los clientes puedan solicitar los turnos por su cuenta. Estas historias de usuario se implementarán más adelante.
- Por otro lado, de la parte "sería bueno que estén", se implementarán las cuatro historias de usuario que se encuentran en dicha sección. 