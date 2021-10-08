# Plan tentativo de iteraciones

## Iteración 0
Definición del problema del cliente y la solución propuesta por el equipo de trabajo. Elaboración de las primeras historias de usuario. Definición de las tecnologías escogidas para el desarrollo.

## Iteración 1
Módulo de gestión de clientes, incluye: dar de alta un cliente, modificar sus datos, leer su información y darlo de baja.

*Historias de usuario:*
* Como usuario, quiero registrar nuevos clientes para asociarlos a reservas de turnos.
* Como usuario, quiero gestionar la información de los clientes registrados para contar siempre con sus datos actualizados.


## Iteración 2
Debido a que el centro ofrece distintos tipos de masajes y rutinas, se incluye un módulo de gestión de tipos de masajes, donde se permitirá: dar de alta un tipo de masaje y dar de baja un tipo de masaje. Al incluir poca información, obviamos la modificación y la lectura. El cliente puede directamente eliminar y crear uno nuevo.

*Historia de usuario:*
* Como usuario, quiero gestionar los distintos tipos de masajes que ofrece el centro para asociarlos a cada turno en particular.

De finalizar con el apartado anterior, se dará inicio al módulo de gestión de reservas, el cual incluye: dar de alta una reserva, modificar sus datos, leer sus datos y dar de baja la misma.

*Historia de usuario:*
* Como usuario, quiero gestionar las reservas de turno para tener mejor organizados los horarios del centro.


## Iteración 3
En el comienzo de esta iteración se plantea finalizar el módulo de gestión de reservas iniciado en la etapa anterior. Esto incluirá el control de horarios para evitar solapamientos.

Tras finalizar esta tarea, se podrán listar reservas por cliente y acceder a la información particular de cada reserva, para saber qué tipo de sesión se ofrecerá.

*Historia de usuario:*
* Como usuario, quiero tener un historial de turnos de cada cliente para saber si están siguiendo una rutina especial.
* Como usuario, quiero ver los detalles de cada turno para saber qué tipo de masaje se hará y durante cuánto tiempo se atenderá cada cliente.


## Iteración 4
Esta iteración estará enfocada en la principal característica del sistema: el despliegue de la información útil en cuanto a las reservas realizadas, y, por supuesto, los espacios de tiempo libres donde puedan realizarse nuevas reservas. Esto podrá visualizarse en rango diario y semanal, para mejor aprovechamiento por parte del usuario.

*Historia de usuario:*
* Como usuario, quiero listar los turnos del día para saber a qué clientes atenderé durante la jornada. 
* Como usuario, quiero ver un cronograma semanal para tener una visión completa de la semana.

Si al finalizar la tarea propuesta para esta iteración nos queda margen de tiempo, trataremos de incluir funcionalidades deseables al sistema, para darle un plus adicional al cliente.

## Iteración 5
En la quinta y última iteración nos dedicaremos a limpiar el código, pulir la interfaz de usuario y corregir errores, a fin de poder presentar la versión final con la mayor calidad posible.