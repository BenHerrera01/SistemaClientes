# Autor: Benjamin Herrera

#### Explicación del Problema

- Se pide crear un sistema para la visualización, inserción, edición, importación y exportación de clientes con un rut, nombre, apellido, años como cliente (tiempo) y un estado (Activo-Inactivo).

### Solución

	- En cuanto a la visualización, se muestra una lista con todos los clientes registrados (agregados uno a uno o importados).
	- Respecto a la inserción, se pide ingresar de manera obligatoria el run del cliente, y luego de manera opcional el nombre, apellido, tiempo siendo cliente. El estado se setea de manera automática en ACTIVO al agregar.
	- Para la edición, el usuario puede editar el estado del cliente y también puede cambiar el resto de sus datos uno a uno. 
	- Para importar, se cargan los datos de un archivo csv en una ruta especificada por el usuario, estos datos se llevan a una lista y se agrega a la lista principal de clientes.
	- Para exportar, el usuario decide si desea guardar los datos en un archivo csv o un txt, en una ruta especificada por él.

### Supuestos

- Se asume que el sistema operativo del usuario será Windows.
- Las rutas serán ingresadas de la forma C:/Users/Documents
- Si se agregan clientes de manera manual, y luego se importan datos, estos últimos se insertarán en la lista principal y se descartarán aquellos clientes que tengan un rut ya registrado anteriormente.






https://github.com/BenHerrera01/SistemaClientes