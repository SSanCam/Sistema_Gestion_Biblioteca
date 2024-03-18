/**
 * Programa principal.
 * Crearemos instancias de Libros, distintos tipos de Usuarios y comprobaremos las funciones de préstamo de libros.
 */
fun main() {
    val biblioteca = Biblioteca()

    // Crear instancias de libros con su estado inicial
    val libro1 = Biblioteca.Libro("Cien años de soledad", "Gabriel García Márquez", 1967, true)
    val libro2 = Biblioteca.Libro("El nombre del viento", "Patrick Rothfuss", 2007, true)
    val libro3 = Biblioteca.Libro("1984", "George Orwell", 1949, true)
    val libro4 = Biblioteca.Libro("El señor de los anillos", "J.R.R. Tolkien", 1954, true)
    val libro5 = Biblioteca.Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001, true)
    val libro6 = Biblioteca.Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, true)
    val libro7 = Biblioteca.Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, true)
    val libro8 = Biblioteca.Libro("Orgullo y prejuicio", "Jane Austen", 1813, true)
    val libro9 = Biblioteca.Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981, true)
    val libro10 = Biblioteca.Libro("La metamorfosis", "Franz Kafka", 1915, true)

    // Crear instancias de usuarios
    val estudiante1 = Usuario.Estudiante("ID1", "Estudiante 1", "Carrera 1")
    val estudiante2 = Usuario.Estudiante("ID2", "Estudiante 2", "Carrera 2")
    val profesor1 = Usuario.Profesor("ID3", "Profesor 1", "Departamento 1")
    val profesor2 = Usuario.Profesor("ID4", "Profesor 2", "Departamento 2")
    val visitante1 = Usuario.Visitante("ID5", "Visitante 1")
    val visitante2 = Usuario.Visitante("ID6", "Visitante 2")

    // Pruebas de las funciones prestamoLibro y accesoAreasRestringidas
    println("Prueba de la función prestamoLibro:")
    println(biblioteca.prestamoLibro(estudiante1, libro1))
    println(biblioteca.prestamoLibro(estudiante2, libro2))
    println(biblioteca.prestamoLibro(profesor1, libro3))
    println(biblioteca.prestamoLibro(profesor2, libro4))
    println(biblioteca.prestamoLibro(visitante1, libro5))
    println(biblioteca.prestamoLibro(visitante2, libro6))

    println("\nPrueba de la función accesoAreasRestringidas:")
    println(biblioteca.accesoAreasRestringidas(profesor1))
    println(biblioteca.accesoAreasRestringidas(profesor2))
    println(biblioteca.accesoAreasRestringidas(visitante1))
    println(biblioteca.accesoAreasRestringidas(visitante2))
}
