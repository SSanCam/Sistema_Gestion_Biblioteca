/**
 * Clase Biblioteca
 * Contiene las clases de Libro, Revista y Dvd
 */
class Biblioteca {
    data class Libro(val title: String, val author: String, val year: Int, var estado: Boolean = true) {}
    data class Revista(val title: String, val issue: Int, val year: Int) {}
    data class Dvd(val title: String, val director: String, val year: Int) {}


    // Variables tipo texto para nuestras funciones de Biblioteca:
    private var textoPrestamoLibro = ""
    private var textoAccesoRestringido = ""

    /**
     * Prestamo libro
     *
     * @param usuario Usuario Recibimos uno de los tres tipos de usuarios posibles.
     * @param libro Libro Recibimos un libro que contenga la biblioteca.
     * @return String Devuelve un texto que nos diga si es posible, o no, tomar prestado el libro y por cúanto tiempo, según usuario.
     */
    fun prestamoLibro(usuario: Usuario, libro: Libro): String {
        val disponibilidad = comprobarDisponibilidad(libro)
        if (usuario is Usuario.Visitante) {
            textoPrestamoLibro = "Lo sentimos, los visitantes no pueden sacar libros de la biblioteca."
        }
        if (usuario is Usuario.Estudiante) {
            if (disponibilidad == true) {
                libro.estado = false
                textoPrestamoLibro = "El libro '${libro.title}' está disponible.\nDebes devolverlo en dos días."
            }
            if (disponibilidad == false) {
                textoPrestamoLibro = "Lo sentimos, el libro \'${libro.title}\' se encuentra en préstamo."
            }
        }
        if (usuario is Usuario.Profesor) {
            if (disponibilidad == true) {
                libro.estado = false
                textoPrestamoLibro = "El libro \'${libro.title}\' está disponible.\nDebes devolverlo en 4 días."
            }
            if (disponibilidad == false) {
                textoPrestamoLibro = "Lo sentimos, el libro \'${libro.title}\' se encuentra en préstamo."
            }
        }
        return textoPrestamoLibro
    }

    /**
     * Acceso areas restringidas
     *
     * @param usuario Usuario
     * @return Texto indicando si el usuario tiene acceso o no al área restringida.
     */
    fun accesoAreasRestringidas(usuario: Usuario): String {
        return when (usuario) {
            is Usuario.Estudiante -> "Acceso denegado."
            is Usuario.Visitante -> "Acceso denegado."
            is Usuario.Profesor -> "Acceso condecido"
        }
    }

// Funciones para Biblioteca
    /**
     * Devolucion libro
     * Cambia el estado del libro de false a true para que pueda volver a ser prestado.
     */
    private fun devolucionLibro(libro: Libro) {
        libro.estado = true
    }

    /**
     * Comprobar disponibilidad
     * @param libro Libro Recibimos un libro y comprobaremos el estado de disponibilidad
     * @return true: se puede prestar | false: está en préstamo.
     */
    private fun comprobarDisponibilidad(libro: Libro): Boolean {
        if (libro.estado == true) {
            return true
        } else {
            return false
        }
    }

    override fun toString(): String {
        val estadoLibro = textoPrestamoLibro.ifEmpty { "No se ha realizado ninguna petición de libro." }
        val accesoRestringido = textoAccesoRestringido.ifEmpty { "No se ha realizado ninguna petición de acceso a áreas restringidas." }

        return "Biblioteca(Estado de libro: '$estadoLibro'\nEstado de acceso restringido: '$accesoRestringido')"
    }

}