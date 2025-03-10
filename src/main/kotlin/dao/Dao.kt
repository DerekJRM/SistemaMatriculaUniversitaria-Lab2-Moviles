package org.example.Dao

import org.example.dao.I_Dao
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

class Dao : I_Dao {
    private val jdbcUrl = "jdbc:sqlite:identifier.sqlite"

    // Método para establecer la conexión
    private fun connect(): Connection? {
        return try {
            DriverManager.getConnection(jdbcUrl).apply {
                println("Conexión exitosa a la base de datos SQLite.")
            }
        } catch (e: SQLException) {
            println("Error al conectar con la base de datos: ${e.message}")
            null
        }
    }

    // ----------------- CRUD para Carrera -----------------

    override  fun insertarCarrera(codigo: String, nombre: String, titulo: String) {
        val sql = "INSERT INTO Carrera (codigo, nombre, titulo) VALUES (?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, codigo)
                pstmt.setString(2, nombre)
                pstmt.setString(3, titulo)
                pstmt.executeUpdate()
            }
        }
    }

    override  fun obtenerCarreraPorCodigo(codigo: String): ResultSet? {
        val sql = "SELECT * FROM Carrera WHERE codigo = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, codigo)
        }?.executeQuery()
    }

    override  fun actualizarCarrera(codigo: String, nombre: String, titulo: String) {
        val sql = "UPDATE Carrera SET nombre = ?, titulo = ? WHERE codigo = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, nombre)
                pstmt.setString(2, titulo)
                pstmt.setString(3, codigo)
                pstmt.executeUpdate()
            }
        }
    }

    override  fun eliminarCarrera(codigo: String) {
        val sql = "DELETE FROM Carrera WHERE codigo = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, codigo)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Curso -----------------
    
    override fun insertarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {
        val sql = "INSERT INTO Curso (codigo, nombre, creditos, horas) VALUES (?, ?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, codigo)
                pstmt.setString(2, nombre)
                pstmt.setInt(3, creditos)
                pstmt.setInt(4, horas)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerCursoPorCodigo(codigo: String): ResultSet? {
        val sql = "SELECT * FROM Curso WHERE codigo = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, codigo)
        }?.executeQuery()
    }

    override fun actualizarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {
        val sql = "UPDATE Curso SET nombre = ?, creditos = ?, horas = ? WHERE codigo = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, nombre)
                pstmt.setInt(2, creditos)
                pstmt.setInt(3, horas)
                pstmt.setString(4, codigo)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarCurso(codigo: String) {
        val sql = "DELETE FROM Curso WHERE codigo = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, codigo)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Profesor -----------------

    override fun insertarProfesor(cedula: String, nombre: String, telefono: String, email: String) {
        val sql = "INSERT INTO Profesor (cedula, nombre, telefono, email) VALUES (?, ?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.setString(2, nombre)
                pstmt.setString(3, telefono)
                pstmt.setString(4, email)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerProfesorPorCedula(cedula: String): ResultSet? {
        val sql = "SELECT * FROM Profesor WHERE cedula = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, cedula)
        }?.executeQuery()
    }

    override fun actualizarProfesor(cedula: String, nombre: String, telefono: String, email: String) {
        val sql = "UPDATE Profesor SET nombre = ?, telefono = ?, email = ? WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, nombre)
                pstmt.setString(2, telefono)
                pstmt.setString(3, email)
                pstmt.setString(4, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarProfesor(cedula: String) {
        val sql = "DELETE FROM Profesor WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Alumno -----------------

    override fun insertarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {
        val sql = "INSERT INTO Alumno (cedula, nombre, telefono, email, fecha_nacimiento, carrera) VALUES (?, ?, ?, ?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.setString(2, nombre)
                pstmt.setString(3, telefono)
                pstmt.setString(4, email)
                pstmt.setString(5, fechaNacimiento)
                pstmt.setString(6, carrera)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerAlumnoPorCedula(cedula: String): ResultSet? {
        val sql = "SELECT * FROM Alumno WHERE cedula = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, cedula)
        }?.executeQuery()
    }

    override fun actualizarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {
        val sql = "UPDATE Alumno SET nombre = ?, telefono = ?, email = ?, fecha_nacimiento = ?, carrera = ? WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, nombre)
                pstmt.setString(2, telefono)
                pstmt.setString(3, email)
                pstmt.setString(4, fechaNacimiento)
                pstmt.setString(5, carrera)
                pstmt.setString(6, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarAlumno(cedula: String) {
        val sql = "DELETE FROM Alumno WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Ciclo -----------------

    override fun insertarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {
        val sql = "INSERT INTO Ciclo (anio, numero, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, anio)
                pstmt.setInt(2, numero)
                pstmt.setString(3, fechaInicio)
                pstmt.setString(4, fechaFin)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerCicloPorAnio(anio: Int): ResultSet? {
        val sql = "SELECT * FROM Ciclo WHERE anio = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setInt(1, anio)
        }?.executeQuery()
    }

    override fun actualizarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {
        val sql = "UPDATE Ciclo SET numero = ?, fecha_inicio = ?, fecha_fin = ? WHERE anio = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, numero)
                pstmt.setString(2, fechaInicio)
                pstmt.setString(3, fechaFin)
                pstmt.setInt(4, anio)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarCiclo(anio: Int, numero: Int) {
        val sql = "DELETE FROM Ciclo WHERE anio = ? AND numero = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, anio)
                pstmt.setInt(2, numero)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Grupo -----------------

    override fun insertarGrupo(cicloId: Int, cursoId: String, numero: Int, horario: String, profesorId: String) {
        val sql = "INSERT INTO Grupo (ciclo_id, curso_id, numero, horario, profesor_id) VALUES (?, ?, ?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, cicloId)
                pstmt.setString(2, cursoId)
                pstmt.setInt(3, numero)
                pstmt.setString(4, horario)
                pstmt.setString(5, profesorId)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerGrupoPorId(id: Int): ResultSet? {
        val sql = "SELECT * FROM Grupo WHERE grupo_id = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setInt(1, id)
        }?.executeQuery()
    }

    override fun actualizarGrupo(id: Int, horario: String, profesorId: String) {
        val sql = "UPDATE Grupo SET horario = ?, profesor_id = ? WHERE grupo_id = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, horario)
                pstmt.setString(2, profesorId)
                pstmt.setInt(3, id)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarGrupo(id: Int) {
        val sql = "DELETE FROM Grupo WHERE grupo_id = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, id)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- CRUD para Usuario -----------------

    override fun insertarUsuario(cedula: String, clave: String, rol: String) {
        val sql = "INSERT INTO Usuario (cedula, clave, rol) VALUES (?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.setString(2, clave)
                pstmt.setString(3, rol)
                pstmt.executeUpdate()
            }
        }
    }

    override fun obtenerUsuarioPorCedula(cedula: String): ResultSet? {
        val sql = "SELECT * FROM Usuario WHERE cedula = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, cedula)
        }?.executeQuery()
    }

    override fun actualizarUsuario(cedula: String, clave: String, rol: String) {
        val sql = "UPDATE Usuario SET clave = ?, rol = ? WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, clave)
                pstmt.setString(2, rol)
                pstmt.setString(3, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarUsuario(cedula: String) {
        val sql = "DELETE FROM Usuario WHERE cedula = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, cedula)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- Matrícula -----------------

    override fun registrarMatricula(alumnoId: String, grupoId: Int) {
        val sql = "INSERT INTO Matricula (alumno_id, grupo_id) VALUES (?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, alumnoId)
                pstmt.setInt(2, grupoId)
                pstmt.executeUpdate()
            }
        }
    }

    override fun eliminarMatricula(alumnoId: String, grupoId: Int) {
        val sql = "DELETE FROM Matricula WHERE alumno_id = ? AND grupo_id = ?"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setString(1, alumnoId)
                pstmt.setInt(2, grupoId)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- Registro de Notas -----------------

    override fun registrarNota(grupoId: Int, alumnoId: String, nota: Double) {
        val sql = "INSERT INTO Nota (grupo_id, alumno_id, nota) VALUES (?, ?, ?)"
        connect()?.use { conn ->
            conn.prepareStatement(sql).use { pstmt ->
                pstmt.setInt(1, grupoId)
                pstmt.setString(2, alumnoId)
                pstmt.setDouble(3, nota)
                pstmt.executeUpdate()
            }
        }
    }

    // ----------------- Historial Académico -----------------

    override fun consultarHistorial(alumnoId: String): ResultSet? {
        val sql = "SELECT * FROM Nota WHERE alumno_id = ?"
        return connect()?.prepareStatement(sql)?.apply {
            setString(1, alumnoId)
        }?.executeQuery()
    }
}