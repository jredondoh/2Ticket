# 2Ticket

**Requisitos de sistema**

Para replicar los resultados de los retos son necesarios:
- Docker, Docker-Compose
- NodeJS v8.9+
- Maven
- curl
- Git
- Java 1.8+
- Python 3+

## RETO 1 y 2 ##

En la carpeta geoDBprueba1, ejecutamos

`mvn clean package`

Si la configuración es correcta, obtenemos el fichero: 
> target/geoDBprueba1-1.0-SNAPSHOT.jar

Que puede ser ejecutado con:

`java -cp target/geoDBprueba1-1.0-SNAPSHOT.jar com.jrh.geoDBprueba1.test`

Los resultados se muestran por salida estándar y son:
- todos los ejemplos de tickets generados para el reto 1
- idTicket de los mínimos y máximos tickets comunes para los tres nodos del reto 2
- número de tickets comunes para los tres nodos del reto 2

## RETO 3 y 4 ##

Para la ilustrar la solución elegida para el reto 3 y el planteamiento del reto 4 se ha añadido un fichero .pdf:
> Reto3y4.pdf

**Reto 4** 

Para la solución del reto 4 se ha incluido en el repositorio:
- Los ficheros de texto generados con la solución a los Retos 1 y 2 usados como entrada
> input_txt  
- El fichero de TypeScript usado en la instancia de HyperLedger Fabric para inicializar la base de datos y proporcionar la interfaz necesaria a los nodos secundarios como nodo primario.
> MyChaincode.ts 
- Los ficheros de python usados para manejar los ficheros de entrada en texto y generar los scripts de bash que actúan como nodos secundarios
> sh_creator.py  
> sh_query_creator.py
- Los scripts de bash generados, separados en scripts de sincronización:
> nodo_secundario1.sh  
> nodo_secundario2.sh  
- Y los de consulta:
> query_nodo_secundario1.sh  
> query_nodo_secundario2.sh  
  
- Para terminar se han incluído unos ficheros de texto con la salida estándar de los scripts de consulta:
> out_query_nodo_secundario1.txt  
> out_query_nodo_secundario2.txt  

Como se puede observar, toda la información de los eventos es coherente y conocida por todos los nodos, secundarios y primario.

**Instrucciones para repetir el proceso**

Clonar el repositorio usado para generar la instancia de Hyperledger Fabric:

`git clone https://github.com/michielmulders/hyperledger-fabric-blockgeeks.git`

Ejecutar el código que inicialice la instancia:

`/scripts/bootstrap.sh`

Copiar el fichero **MyChaincode.ts** proporcionado en este repositorio a la carpeta:

>    ./chaincode/node/src/

Ejecutar el código que inicie Hyperledger Fabric:

`/scripts/startFabric.sh`

Ejecutar los scripts de sincronización o consulta de los nodos secundarios en el orden se desee, incluso de forma concurrente.

**Instrucciones para generar nuevos inputs**

En la carpeta geoDBprueba1, ejecutamos

`mvn clean package`

`java -cp target/geoDBprueba1-1.0-SNAPSHOT.jar com.jrh.geoDBprueba1.generatorForPOC`

La salida estándar de esta ejecución la enviamos a un fichero de texto que nos permitirá generar el nuevo código de `InitLedger` para HyperLedger Fabric y los nuevos scripts de interacción de los nodos secundarios.


