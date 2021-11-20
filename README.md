# Autor: Benjamin Herrera Salazar
## _Sistema de rating de peliculas_
### Instrucciones
- Importar proyecto y ejecutar Maven Install.
- Verificar que usuario y contraseña contenidos en el archivo database.properties se encuentre en la base de datos local (Oracle).
- Ejecutar Proyecto como Spring Boot App.
- De existir problemas con la base de datos, eliminar las siguientes tablas de la base de datos local:

### Caracteristicas
- Sistema desarrollado con Spring Boot, que permite a usuarios ver, crear, editar, eliminar y entregar una calificación a Tv Shows creados por otros usuarios.
- Para usar la aplicación el usuario debe registrarse y posteriormente loguearse, por defecto estos son creados con rol USER_ROLE.
- Sólo pueden editar y eliminar shows aquellos usuarios que crearon el show en particular, sin embargo todos pueden dar una calificación al Show que va desde 1 a 5, si un mismo usuario califica más de una vez esta nota es sobreescrita.
