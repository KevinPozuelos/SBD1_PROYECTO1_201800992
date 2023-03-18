Descripción general del programa.
-----------------------
El Ministerio de Salud de China (MSC) se ha encargado de registrar, controlar
y evaluar estadísticas de las diferentes personas que presentan Coronavirus
en China, para lo cual requiere un sistema de bases de datos donde se
puedan hacer consultas de diferentes casos y tratamientos que han sido
efectuados a distintas víctimas.

Requerimientos del sistema.
------------------------
• java version "17" 

• Java(TM) SE Runtime Environment (build 17.5)

• Oracle Instant Client for Microsoft Windows (x64)

• IDE utilizada: IntelliJ IDEA 2021.3.1

• Espacio en memoria: 1GB MB como mínimo

• Dependencias: stereotype.Repository, stereotype.Component, jdbc.core.JdbcTemplate, security.PublicKey, annotation.Autowired; 

Modelo Propuesto.
---------------------------
![Modelo Propuesto](https://i.imgur.com/GhE8akL.png)


Lista de entidades.
---------------------------
• Hospital
• Victima
• Allegado
• Tratamiento
• Tratamiento-Victima
• Tipo Contacto
• Contacto

Guia de uso de programa.
---------------------------
#### /cargarTemporal ####
El programa permite cargar un archivo .csv mediante una API desarrollada en Java Spring Boot(gradle), dicha API cargara los datos a una tabla temporal en una imagen de Docker que se encuentra en una VM alojada de GCP. 

#### /cargarModelo ####
Este endpoint nos permite crear el modelo relacion, posteriormente en la misma API se cargaran los datos a las diferentes tablas mediante la tabla temporal.

#### /eliminarTemporal ####
Este endpoint permite eliminar la tabla temporal. 

### /eliminarModelo ####
Este endpoint permite eliminar el modelo relaciona. 

### /consulta1 ###
Mostrar el nombre del hospital, su dirección y el número de fallecidos
por cada hospital registrado.

### /consulta2 ###
Mostrar el nombre, apellido de todas las víctimas en cuarentena que
presentaron una efectividad mayor a 5 en el tratamiento
“Transfusiones de sangre”.

### /consulta3 ###
Mostrar el nombre, apellido y dirección de las víctimas fallecidas con
más de tres personas asociadas

### /consulta4 ###
Mostrar el nombre y apellido de todas las víctimas en estado
“Suspendida” que tuvieron contacto físico de tipo “Beso” con más de
2 de sus asociados.

### /consulta5 ###
Top 5 de víctimas que más tratamientos se han aplicado del
tratamiento “Oxígeno”.

### /consulta6 ###
Mostrar el nombre, el apellido y la fecha de fallecimiento de todas las
víctimas que se movieron por la dirección “1987 Delphine Well” a los
cuales se les aplicó "Manejo de la presión arterial" como tratamiento.

### /consulta7 ###
. Mostrar nombre, apellido y dirección de las víctimas que tienen menos
de 2 allegados los cuales hayan estado en un hospital y que se le
hayan aplicado únicamente dos tratamientos..

### /consulta8 ###
Mostrar el número de mes de la fecha de la primera sospecha,
nombre y apellido de las víctimas que más tratamientos se han
aplicado y las que menos. (Todo en una misma consulta).

### /consulta9 ###
Mostrar el porcentaje de víctimas que le corresponden a cada
hospital.

### /consulta10 ###
Mostrar el porcentaje del contacto físico más común de cada
hospital de la siguiente manera: nombre de hospital, nombre del
contacto físico, porcentaje de víctimas.
