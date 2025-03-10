package org.example.service

import org.example.Dao.Dao
import java.sql.ResultSet

class Service : I_Service {

    private val dao = Dao()

    // ----------------- CRUD para Carrera -----------------

    override fun insertarCarrera(codigo: String, nombre: String, titulo: String) {
        try {
            dao.insertarCarrera(codigo, nombre, titulo)
            println("Carrera insertada correctamente")
        } catch (e: Exception) {
            println("Error al insertar carrera: ${e.message}")
        }
    }

    override fun obtenerCarreraPorCodigo(codigo: String): ResultSet? {
        return try {
            dao.obtenerCarreraPorCodigo(codigo)
        } catch (e: Exception) {
            println("Error al obtener carrera: ${e.message}")
            null
        }
    }

    override fun actualizarCarrera(codigo: String, nombre: String, titulo: String) {
        try {
            dao.actualizarCarrera(codigo, nombre, titulo)
            println("Carrera actualizada correctamente")
        } catch (e: Exception) {
            println("Error al actualizar carrera: ${e.message}")
        }
    }

    override fun eliminarCarrera(codigo: String) {
        try {
            dao.eliminarCarrera(codigo)
            println("Carrera eliminada correctamente")
        } catch (e: Exception) {
            println("Error al eliminar carrera: ${e.message}")
        }
    }

    // ----------------- CRUD para Curso -----------------

    override fun insertarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {
        try {
            dao.insertarCurso(codigo, nombre, creditos, horas)
            println("Curso insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar curso: ${e.message}")
        }
    }

    override fun obtenerCursoPorCodigo(codigo: String): ResultSet? {
        return try {
            dao.obtenerCursoPorCodigo(codigo)
        } catch (e: Exception) {
            println("Error al obtener curso: ${e.message}")
            null
        }
    }

    override fun actualizarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {
        try {
            dao.actualizarCurso(codigo, nombre, creditos, horas)
            println("Curso actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar curso: ${e.message}")
        }
    }

    override fun eliminarCurso(codigo: String) {
        try {
            dao.eliminarCurso(codigo)
            println("Curso eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar curso: ${e.message}")
        }
    }

    // ----------------- CRUD para Profesor -----------------

    override fun insertarProfesor(cedula: String, nombre: String, telefono: String, email: String) {
        try {
            dao.insertarProfesor(cedula, nombre, telefono, email)
            println("Profesor insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar profesor: ${e.message}")
        }
    }

    override fun obtenerProfesorPorCedula(cedula: String): ResultSet? {
        return try {
            dao.obtenerProfesorPorCedula(cedula)
        } catch (e: Exception) {
            println("Error al obtener profesor: ${e.message}")
            null
        }
    }

    override fun actualizarProfesor(cedula: String, nombre: String, telefono: String, email: String) {
        try {
            dao.actualizarProfesor(cedula, nombre, telefono, email)
            println("Profesor actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar profesor: ${e.message}")
        }
    }

    override fun eliminarProfesor(cedula: String) {
        try {
            dao.eliminarProfesor(cedula)
            println("Profesor eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar profesor: ${e.message}")
        }
    }

    // ----------------- CRUD para Alumno -----------------

    override fun insertarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {
        try {
            dao.insertarAlumno(cedula, nombre, telefono, email, fechaNacimiento, carrera)
            println("Alumno insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar alumno: ${e.message}")
        }
    }

    override fun obtenerAlumnoPorCedula(cedula: String): ResultSet? {
        return try {
            dao.obtenerAlumnoPorCedula(cedula)
        } catch (e: Exception) {
            println("Error al obtener alumno: ${e.message}")
            null
        }
    }

    override fun actualizarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {
        try {
            dao.actualizarAlumno(cedula, nombre, telefono, email, fechaNacimiento, carrera)
            println("Alumno actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar alumno: ${e.message}")
        }
    }

    override fun eliminarAlumno(cedula: String) {
        try {
            dao.eliminarAlumno(cedula)
            println("Alumno eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar alumno: ${e.message}")
        }
    }

    // ----------------- CRUD para Ciclo -----------------

    override fun insertarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {
        try {
            dao.insertarCiclo(anio, numero, fechaInicio, fechaFin)
            println("Ciclo insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar ciclo: ${e.message}")
        }
    }

    override fun obtenerCicloPorAnio(anio: Int): ResultSet? {
        return try {
            dao.obtenerCicloPorAnio(anio)
        } catch (e: Exception) {
            println("Error al obtener ciclo: ${e.message}")
            null
        }
    }

    override fun actualizarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {
        try {
            dao.actualizarCiclo(anio, numero, fechaInicio, fechaFin)
            println("Ciclo actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar ciclo: ${e.message}")
        }
    }

    override fun eliminarCiclo(anio: Int, numero: Int) {
        try {
            dao.eliminarCiclo(anio, numero)
            println("Ciclo eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar ciclo: ${e.message}")
        }
    }

    // ----------------- CRUD para Grupo -----------------

    override fun insertarGrupo(cicloId: Int, cursoId: String, numero: Int, horario: String, profesorId: String) {
        try {
            dao.insertarGrupo(cicloId, cursoId, numero, horario, profesorId)
            println("Grupo insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar grupo: ${e.message}")
        }
    }

    override fun obtenerGrupoPorId(id: Int): ResultSet? {
        return try {
            dao.obtenerGrupoPorId(id)
        } catch (e: Exception) {
            println("Error al obtener grupo: ${e.message}")
            null
        }
    }

    override fun actualizarGrupo(id: Int, horario: String, profesorId: String) {
        try {
            dao.actualizarGrupo(id, horario, profesorId)
            println("Grupo actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar grupo: ${e.message}")
        }
    }

    override fun eliminarGrupo(id: Int) {
        try {
            dao.eliminarGrupo(id)
            println("Grupo eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar grupo: ${e.message}")
        }
    }

    // ----------------- CRUD para Usuario -----------------

    override fun insertarUsuario(cedula: String, clave: String, rol: String) {
        try {
            dao.insertarUsuario(cedula, clave, rol)
            println("Usuario insertado correctamente")
        } catch (e: Exception) {
            println("Error al insertar usuario: ${e.message}")
        }
    }

    override fun obtenerUsuarioPorCedula(cedula: String): ResultSet? {
        return try {
            dao.obtenerUsuarioPorCedula(cedula)
        } catch (e: Exception) {
            println("Error al obtener usuario: ${e.message}")
            null
        }
    }

    override fun actualizarUsuario(cedula: String, clave: String, rol: String) {
        try {
            dao.actualizarUsuario(cedula, clave, rol)
            println("Usuario actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar usuario: ${e.message}")
        }
    }

    override fun eliminarUsuario(cedula: String) {
        try {
            dao.eliminarUsuario(cedula)
            println("Usuario eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar usuario: ${e.message}")
        }
    }

    // ----------------- Matrícula -----------------

    override fun registrarMatricula(alumnoId: String, grupoId: Int) {
        try {
            dao.registrarMatricula(alumnoId, grupoId)
            println("Matrícula registrada correctamente")
        } catch (e: Exception) {
            println("Error al registrar matrícula: ${e.message}")
        }
    }

    override fun eliminarMatricula(alumnoId: String, grupoId: Int) {
        try {
            dao.eliminarMatricula(alumnoId, grupoId)
            println("Matrícula eliminada correctamente")
        } catch (e: Exception) {
            println("Error al eliminar matrícula: ${e.message}")
        }
    }

    // ----------------- Registro de Notas -----------------

    override fun registrarNota(grupoId: Int, alumnoId: String, nota: Double) {
        try {
            dao.registrarNota(grupoId, alumnoId, nota)
            println("Nota registrada correctamente")
        } catch (e: Exception) {
            println("Error al registrar nota: ${e.message}")
        }
    }

    // ----------------- Historial Académico -----------------

    override fun consultarHistorial(alumnoId: String): ResultSet? {
        return try {
            dao.consultarHistorial(alumnoId)
        } catch (e: Exception) {
            println("Error al consultar historial: ${e.message}")
            null
        }
    }
}