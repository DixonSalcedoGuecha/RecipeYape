# RecipeYape
Este proyecto es una solución para el reto tecnico propuesto por Yape.

## ¿Cómo se realiza la solución del Reto?

Se crea un proyecto de Android utilizando DataBinding, al terminar la creación para continuar con el proceso se aplica clean architecture y MVVM, esto con la finalidad de poder desacoplar la lógica de negocio de la vista y la infraestructura, además de garantizar que se genera un código limpio, estructurado y legible.

Este proyecto también cuenta con pruebas unitarias basadas en resolver la lógica de negocio (Mockk) y para la parta de UI (Expresso).

Por ultimo, en este proyecto se utilzaron buenas parcticas y algunos patrones de diseño segun la necesidad.


## ¿Qué arquitecturas se utiliza?

A continuación se presenta un diagrama de como se ve Clean Architecture:

![Clean Architecture](https://mahedee.net/assets/images/posts/2021/clean.png)
**Nota:** Para este proyecto no se esta utilizando la capa de Application ni de Persistence.

Para poder implementar la arquitectura limpia debemos crear dos modulos o capas más para el proyecto, los cuales son **Domain** y **Infrastructure**, además se renombra la capa **App** por **Presentation**:
* **Presentation:** Se encuentra todo lo que va de cara al usuario.
* **Domain:** Encontramos toda la lógica de negocio.
* **Infrastructure:** Se implementa la conexión a API's o bases de datos para la obtención de data.

También se aplica **MVVM** como arquitectura de diseño que nos ayuda a aplicar reactividad de una manera más simple:

![MVVM](https://www.adictosaltrabajo.com/wp-content/uploads/2020/06/MVVMPattern.png)

Internamente se aplica diferentes patrones de diseño que se ven explicados posteriormente.

## ¿Qué patrones de diseño usamos?

Los patrones de diseño se utilizan para resolver problemas de los cuales se necesita estandarizar una solución que ayude a disminuir la fricción en cuando al entendimiento de la solución, en este caso utilizamos:

* **Translate pattern:** Al recibir DTO cuando consumimos el API, nos ayuda a transformar este objeto a uno de Dominio fácilmente.
* **Dependency injection:** Nos ayuda a crear los objetos de una manera útil, escalable y nos permite desacoplar completamente el dominio de las demás capaz.
* **Object:** Nos permite reutilizar los objetos con el fin de evitar la tarea de crearlos cada vez que nuestra aplicación los requiere, manteniendo así un almacén de objetos creados previamente para ser utilizados.
* **Singleton:** Nos permite que nos permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.

## ¿Qué librerías se utilizaron en el proyecto?

Las librerias cumplen con el proposito de solucionar problemas que a menudo se encuentran en el desarrollo, haciendo mucho más fácil la implementación, para el caso de este proyecto se utilizaron:

* **Hilt:** Inyección de dependencias.
* **Retrofit2:** Realiza la estructura para las peticiones a las API's.
* **LiveData:** Nos ayuda a crear valores reactivos.
* **Mockk:** Se utilizo para realizar los test unitarios a las diferentes funciones de las clases.
* **Expresso:** Se utilizo para realizar los test unitarios a la parte de UI.
* **Glide:** Se utilizo para mostrar las imagenes que trae el servicio de recetas usado en esta prueba
* **Room:** Se utiliza para la persistencia de datos en la aplicacion

## Consideraciones adicionales

El repositorio es publico, por lo cual no hay necesidad de manejar credenciales adicionales ni solicitar permisos al dueño del repositorio DixonSalcedoGuecha para poder acceder a su contenido.

En este proyecto se utilizan los servicios gratuitos de la pagina  (https://spoonacular.com/food-api) en la cual encontramos una documentacion (https://spoonacular.com/food-api/docs#Summarize-Recipe) con muchas servicios para este tipo de pruebas.

