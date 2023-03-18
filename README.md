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

Listado de atributos.
---------------------------
## Hospital

| No. | Nombre | Tipo | Primary | Forean | Not null |
| --- | ---------------- | ---------------| ------- | ------ | -------- |
| 1 | ID_HOSPITAL | Integer | x |  | x |
| 2 | NOMBRE | VARCHAR(50) |  |  | x |

## Victima

| No. | Nombre | Tipo | Primary | Forean | Not null |
| --- | ---------------- | ---------------| ------- | ------ | -------- |
| 1 | ID_Victima | Integer | x |  | x |
| 2 | NOMBRE | VARCHAR(50) |  |  | x |
| 3 | APELLIDO | VARCHAR(50) |  |  | x |
| 4 | UBICACION | VARCHAR(50) |  |  | x |
| 5 | fecha_primera_sospecha | TIMESTAMP(6) |  |  | x |
| 6 | fecha_confirmacion | TIMESTAMP(6) |  |  | x |
| 7 | fecha_muerte | TIMESTAMP(6) |  |  |  |
| 8 | ESTADO VICTIMA | VARCHAR(100)|  |  |  |
| 9 | ID_HOSPITAL | Integer|  | x |  |

## Allegado

| No. | Nombre            | Tipo            | Primary | Forean | Not null |
| --- | ---------------- | ---------------| ------- | ------ | -------- |
| 1   | id_allegado      | integer         | X       |        | X        |
| 2   | nombre_allegado  | VARCHAR(100)    |         |        |     x     |
| 3   | apellido_allegado| varchar(100)    |         |        |    x      |
| 4   | fecha_conocio    | TIMESTAMP(6)   |         |        |     x     |

## TIPO CONTACTO

| No. | Nombre                 | Tipo         | Primary | Forean | Not null |
| --- | --------------------- | ------------| ------- | ------ | -------- |
| 1   | id_Tipo_contacto      | integer     | X       |        | X        |
| 2   | nombre_tipo_contacto  | VARCHAR(100)|         |        | X        |

## CONTACTO

| No. | Nombre            | Tipo            | Primary | Forean                      | Not null |
| --- | ---------------- | ---------------| ------- | ---------------------------| -------- |
| 1   | ID_CONTACTO      | integer         | X       |                            | X        |
| 2   | ID_VICTIMA       | integer         |         | x       | X        |
| 3   | ID_ALLEGADO      | integer         |         | x       | X        |
| 4   | ID_TIPO_CONTACTO | integer         |         | x        | X        |
| 5   | FECHA_INICIO     | TIMESTAMP(6)   |         |                            |          |
| 6   | FECHA_FIN        | TIMESTAMP(6)   |         |                            |          |

## TRATAMIENTO

| No. | Nombre                  | Tipo            | Primary | Forean | Not null |
| --- | ---------------------- | ---------------| ------- | ------ | -------- |
| 1   | Id_Tratamiento          | integer         | X       |        | X        |
| 2   | Nombre                  | VARCHAR2(100)   |         |        | X        |
| 3   | FECHA_INICIO_TRATAMIENTO | TIMESTAMP(6)   |         |        |          |
| 4   | FECHA_FIN_TRATAMIENTO    | TIMESTAMP(6)   |         |        |          |
| 5   | EFECTIVIDAD             | NUMBER(2, 1)    |         |        | X        |
| 6   | EFECTIVIDAD_VICTIMA     | NUMBER(2, 1)    |         |        | X        |

##VICTIMA-TRATAMIENTO

| No. | Nombre                 | Tipo    | Primary | Forean                               | Not null |
| --- | ----------------------| ------- | ------- | ------------------------------------| -------- |
| 1   | ID_TRATAMIENTO_VICTIMA | integer | X       |                                      | X        |
| 2   | FECHA                  | date    |         |                                      |          |
| 3   | ID_TRATAMIENTO         | integer |         | Tratamiento (Id_Tratamiento)        | X        |
| 4   | ID_VICTIMA             | integer |         | Victima (id_victima)                | X        |

Relaciones entre Entidades.
---------------------------

•	Un hopsital lo pueden tener muchas victimas, pero cada victima solo puede tener un hospital.

•	Una Victima puede tener a conctacto con varios allegados y un allegado puede ser tener  muchos contactos con victimas.

•	Una Victima puede tener distintos tratamientos y un tipo tratamiento puede ser aplicado a varias victimas.


Consideración de diseño.
----------------------------
 La tabla Contacto fue diseñada para romper la linealidad muchos a muchos entre victima, allegado y tipo de contacto. Ya que muchas victimas podian tener muchos allegados en comun con muchos tipos de conacto.
 De igual forma TratamientoVictima para romper la linealidad de muchos a muchos entre tratamiento y victimas ya que varias victimas pueden tener multiples tratamientos.

Lenguaje/Framework.
---------------------------
La API fue desarrollada con el framework de Java Spring Boot: gradle 3.0.4, con las dependencias Spring Web para realizar los diferentes endpoints solicitados. Ademas se utilizo Oracle Driver para tener acceso a la base de datos deuna forma mas facil y eficiente, ya que Spring Boot tiene un ORM lo que permite la facilidad de manejar bases de datos. 

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