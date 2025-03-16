/*
    * @author: Derek Rojas Mendoza
    * @author: Joseph León Cabezas
*/

package org.example.dao

import org.example.exceptions.GlobalException
import org.example.exceptions.NoDataException
import org.example.model.*
import java.sql.*
import kotlin.jvm.Throws

class DaoMatricula : Dao(), I_DaoMatricula {
    
    private fun tryConnection() {
        try {
            conectar()
        } catch (e: ClassNotFoundException) {
            throw GlobalException("No se ha localizado el driver")
        } catch (e: SQLException) {
            throw NoDataException("La base de datos no se encuentra disponible")
        }
    }

    // ----------------- CRUD para Carrera -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarCarrera(carrera: Carrera) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarCarrera (?, ?, ?)}")
            pstmt?.setString(1, carrera.getCodigoCarrera())
            pstmt?.setString(2, carrera.getNombre())
            pstmt?.setString(3, carrera.getTitulo())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCarreras(): Collection<Carrera> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Carrera>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCarreras()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Carrera(rs.getString("codigo_carrera"), rs.getString("nombre"), rs.getString("titulo")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarCarrera(carrera: Carrera) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarCarrera (?, ?, ?)}")
            pstmt?.setString(1, carrera.getCodigoCarrera())
            pstmt?.setString(2, carrera.getNombre())
            pstmt?.setString(3, carrera.getTitulo())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarCarrera(codigo: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarCarrera(?)}")
            pstmt?.setString(1, codigo)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCarreraPorCodigo(codigo: String): Carrera? {
        this.tryConnection()

        var rs: ResultSet? = null
        var laCarrera: Carrera? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCarreraPorCodigo(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, codigo)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                laCarrera = Carrera(rs.getString("codigo_carrera"), rs.getString("nombre"), rs.getString("titulo"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return laCarrera
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCarreraPorNombre(nombre: String): Collection<Carrera> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Carrera>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCarreraPorNombre(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, nombre)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Carrera(rs.getString("codigo_carrera"), rs.getString("nombre"), rs.getString("titulo")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    // ----------------- CRUD para Curso -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarCurso(curso: Curso) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarCurso (?, ?, ?, ?)}")
            pstmt?.setString(1, curso.getCodigoCurso())
            pstmt?.setString(2, curso.getNombre())
            pstmt?.setInt(3, curso.getCreditos())
            pstmt?.setInt(4, curso.getHorasSemanales())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCursos(): Collection<Curso> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Curso>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCursos()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Curso(rs.getString("codigo_curso"), rs.getString("nombre"), rs.getInt("creditos"), rs.getInt("horas_semanales")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarCurso(curso: Curso) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarCurso (?, ?, ?, ?)}")
            pstmt?.setString(1, curso.getCodigoCurso())
            pstmt?.setString(2, curso.getNombre())
            pstmt?.setInt(3, curso.getCreditos())
            pstmt?.setInt(4, curso.getHorasSemanales())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarCurso(codigo: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarCurso(?)}")
            pstmt?.setString(1, codigo)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCursoPorCodigo(codigo: String): Curso? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elCurso: Curso? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCursoPorCodigo(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, codigo)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elCurso = Curso(rs.getString("codigo_curso"), rs.getString("nombre"), rs.getInt("creditos"), rs.getInt("horas_semanales"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elCurso
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCursosPorCarrera(codigoCarrera: String): Collection<Curso> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Curso>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCursosPorCarrera(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, codigoCarrera)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Curso(rs.getString("codigo_curso"), rs.getString("nombre"), rs.getInt("creditos"), rs.getInt("horas_semanales")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCursosPorNombre(nombre: String): Collection<Curso> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Curso>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCursosPorNombre(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, nombre)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Curso(rs.getString("codigo_curso"), rs.getString("nombre"), rs.getInt("creditos"), rs.getInt("horas_semanales")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    // ----------------- CRUD para Carrera_Curso -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarCarreraCurso(carreraCurso: CarreraCurso) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarCarreraCurso (?, ?, ?, ?, ?)}")
            pstmt?.setString(1, carreraCurso.getCodigoCarrera())
            pstmt?.setString(2, carreraCurso.getCodigoCurso())
            pstmt?.setInt(3, carreraCurso.getAnio())
            pstmt?.setInt(4, carreraCurso.getCiclo())
            pstmt?.setInt(5, carreraCurso.getOrden())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCarrerasCursos(): Collection<CarreraCurso> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<CarreraCurso>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCarrerasCursos()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(CarreraCurso(rs.getInt("carrera_curso_id"), rs.getString("codigo_carrera"), rs.getString("codigo_curso"), rs.getInt("anio"), rs.getInt("ciclo"), rs.getInt("orden")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarCarreraCurso(carreraCurso: CarreraCurso) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarCarreraCurso (?, ?, ?, ?)}")
            pstmt?.setInt(1, carreraCurso.getCarreraCursoId())
            pstmt?.setInt(2, carreraCurso.getAnio())
            pstmt?.setInt(3, carreraCurso.getCiclo())
            pstmt?.setInt(4, carreraCurso.getOrden())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satistactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarCarreraCurso(carreraCursoId: Int) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarCarreraCurso(?)}")
            pstmt?.setInt(1, carreraCursoId)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCarreraCursoPorId(carreraCursoId: Int): CarreraCurso? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elCarreraCurso: CarreraCurso? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCarreraCursoPorId(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setInt(2, carreraCursoId)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elCarreraCurso = CarreraCurso(rs.getInt("carrera_curso_id"), rs.getString("codigo_carrera"), rs.getString("codigo_curso"), rs.getInt("anio"), rs.getInt("ciclo"), rs.getInt("orden"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elCarreraCurso
    }

    // ----------------- CRUD para Profesor -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarProfesor(profesor: Profesor) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarProfesor (?, ?, ?, ?)}")
            pstmt?.setString(1, profesor.getCedula())
            pstmt?.setString(2, profesor.getNombre())
            pstmt?.setString(3, profesor.getTelefono())
            pstmt?.setString(4, profesor.getEmail())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerProfesores(): Collection<Profesor> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Profesor>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerProfesores()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Profesor(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarProfesor(profesor: Profesor) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarProfesor (?, ?, ?, ?)}")
            pstmt?.setString(1, profesor.getCedula())
            pstmt?.setString(2, profesor.getNombre())
            pstmt?.setString(3, profesor.getTelefono())
            pstmt?.setString(4, profesor.getEmail())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarProfesor(cedula: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarProfesor(?)}")
            pstmt?.setString(1, cedula)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerProfesorPorCedula(cedula: String): Profesor? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elProfesor: Profesor? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerProfesorPorCedula(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, cedula)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elProfesor = Profesor(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elProfesor
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerProfesorPorNombre(nombre: String): Collection<Profesor> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Profesor>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerProfesorPorNombre(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, nombre)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Profesor(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    // ----------------- CRUD para Alumno -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarAlumno(alumno: Alumno) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarAlumno (?, ?, ?, ?, ?, ?)}")
            pstmt?.setString(1, alumno.getCedula())
            pstmt?.setString(2, alumno.getNombre())
            pstmt?.setString(3, alumno.getTelefono())
            pstmt?.setString(4, alumno.getEmail())
            pstmt?.setDate(5, Date.valueOf(alumno.getFechaNacimiento().toString()))
            pstmt?.setString(6, alumno.getCodigoCarrera())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerAlumnos(): Collection<Alumno> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Alumno>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerAlumnos()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Alumno(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email"), rs.getDate("fecha_nacimiento"), rs.getString("codigo_carrera")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarAlumno(alumno: Alumno) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarAlumno (?, ?, ?, ?, ?, ?)}")
            pstmt?.setString(1, alumno.getCedula())
            pstmt?.setString(2, alumno.getNombre())
            pstmt?.setString(3, alumno.getTelefono())
            pstmt?.setString(4, alumno.getEmail())
            pstmt?.setDate(5, Date.valueOf(alumno.getFechaNacimiento().toString()))
            pstmt?.setString(6, alumno.getCodigoCarrera())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarAlumno(cedula: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarAlumno(?)}")
            pstmt?.setString(1, cedula)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerAlumnoPorCedula(cedula: String): Alumno? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elAlumno: Alumno? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerAlumnoPorCedula(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, cedula)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elAlumno = Alumno(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email"), rs.getDate("fecha_nacimiento"),rs.getString("codigo_carrera"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elAlumno
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerAlumnoPorNombre(nombre: String): Collection<Alumno> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Alumno>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerAlumnoPorNombre(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, nombre)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Alumno(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email"), rs.getDate("fecha_nacimiento"),rs.getString("codigo_carrera")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerAlumnosPorCarrera(codigoCarrera: String): Collection<Alumno> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Alumno>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerAlumnosPorCarrera(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, codigoCarrera)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Alumno(rs.getString("cedula"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("email"), rs.getDate("fecha_nacimiento"),rs.getString("codigo_carrera")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    // ----------------- CRUD para Ciclo -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarCiclo(ciclo: Ciclo) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarCiclo (?, ?, ?, ?, ?)}")
            pstmt?.setInt(1, ciclo.getAnio())
            pstmt?.setInt(2, ciclo.getNumero())
            pstmt?.setDate(3, Date.valueOf(ciclo.getFechaInicio().toString()))
            pstmt?.setDate(4, Date.valueOf(ciclo.getFechaFin().toString()))
            pstmt?.setBoolean(5, ciclo.isActivo())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCiclos(): Collection<Ciclo> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Ciclo>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCiclos()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Ciclo(rs.getInt("ciclo_id"), rs.getInt("anio"), rs.getInt("numero"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getBoolean("activo")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarCiclo(ciclo: Ciclo) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarCiclo (?, ?, ?, ?, ?, ?)}")
            pstmt?.setInt(1, ciclo.getCicloId())
            pstmt?.setInt(2, ciclo.getAnio())
            pstmt?.setInt(3, ciclo.getNumero())
            pstmt?.setDate(4, Date.valueOf(ciclo.getFechaInicio().toString()))
            pstmt?.setDate(5, Date.valueOf(ciclo.getFechaFin().toString()))
            pstmt?.setBoolean(6, ciclo.isActivo())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarCiclo(cicloId: Int) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarCiclo(?)}")
            pstmt?.setInt(1, cicloId)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerCicloPorAnio(anio: Int): Collection<Ciclo> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Ciclo>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerCicloPorAnio(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setInt(2, anio)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Ciclo(rs.getInt("ciclo_id"), rs.getInt("anio"), rs.getInt("numero"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getBoolean("activo")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    // ----------------- CRUD para Grupo -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarGrupo(grupo: Grupo) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarGrupo (?, ?, ?, ?, ?, ?)}")
            pstmt?.setInt(1, grupo.getAnioCiclo())
            pstmt?.setInt(2, grupo.getNumeroCiclo())
            pstmt?.setString(3, grupo.getCodigoCurso())
            pstmt?.setInt(4, grupo.getNumeroGrupo())
            pstmt?.setString(5, grupo.getHorario())
            pstmt?.setString(6, grupo.getCedulaProfesor())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerGrupos(): Collection<Grupo> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Grupo>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerGrupos()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Grupo(rs.getInt("grupo_id"), rs.getInt("anio_ciclo"), rs.getInt("numero_ciclo"), rs.getString("codigo_curso"), rs.getInt("numero_grupo"), rs.getString("horario"), rs.getString("cedula_profesor")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarGrupo(grupo: Grupo) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarGrupo (?, ?, ?, ?, ?, ?, ?)}")
            pstmt?.setInt(1, grupo.getGrupoId())
            pstmt?.setInt(2, grupo.getAnioCiclo())
            pstmt?.setInt(3, grupo.getNumeroCiclo())
            pstmt?.setString(4, grupo.getCodigoCurso())
            pstmt?.setInt(5, grupo.getNumeroGrupo())
            pstmt?.setString(6, grupo.getHorario())
            pstmt?.setString(7, grupo.getCedulaProfesor())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarGrupo(grupoId: Int) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarGrupo(?)}")
            pstmt?.setInt(1, grupoId)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerGrupoPorId(grupoId: Int): Grupo? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elGrupo: Grupo? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerGrupoPorId(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setInt(2, grupoId)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elGrupo = Grupo(rs.getInt("grupo_id"), rs.getInt("anio_ciclo"), rs.getInt("numero_ciclo"), rs.getString("codigo_curso"), rs.getInt("numero_grupo"), rs.getString("horario"), rs.getString("cedula_profesor"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elGrupo
    }

    // ----------------- CRUD para Usuario -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun insertarUsuario(usuario: Usuario) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call insertarUsuario (?, ?, ?)}")
            pstmt?.setString(1, usuario.getCedula())
            pstmt?.setString(2, usuario.getClave())
            pstmt?.setString(3, usuario.getTipoUsuario())
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerUsuarios(): Collection<Usuario> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Usuario>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerUsuarios()}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Usuario(rs.getString("cedula"), rs.getString("clave"), rs.getString("tipo_usuario")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun actualizarUsuario(usuario: Usuario) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call actualizarUsuario (?, ?, ?)}")
            pstmt?.setString(1, usuario.getCedula())
            pstmt?.setString(2, usuario.getClave())
            pstmt?.setString(3, usuario.getTipoUsuario())
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo la actualización")
            }

            println("\nModificación Satisfactoria!")

        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarUsuario(cedula: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarUsuario(?)}")
            pstmt?.setString(1, cedula)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun obtenerUsuarioPorCedula(cedula: String): Usuario? {
        this.tryConnection()

        var rs: ResultSet? = null
        var elUsuario: Usuario? = null
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call obtenerUsuarioPorCedula(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, cedula)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?
            if (rs?.next() == true) {
                elUsuario = Usuario(rs.getString("cedula"), rs.getString("clave"), rs.getString("tipo_usuario"))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        return elUsuario
    }

    // ----------------- Matrícula -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun registrarMatricula(grupoId: Int, cedulaAlumno: String) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call registrarMatricula (?, ?)}")
            pstmt?.setInt(1, grupoId)
            pstmt?.setString(2, cedulaAlumno)
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    @Throws(GlobalException::class, NoDataException::class)
    override fun eliminarMatricula(grupoId: Int, cedulaAlumno: String) {
        this.tryConnection()

        var pstmt: PreparedStatement? = null

        try {
            pstmt = conexion?.prepareStatement("{call eliminarMatricula(?, ?)}")
            pstmt?.setInt(1, grupoId)
            pstmt?.setString(2, cedulaAlumno)
            val resultado = pstmt?.executeUpdate()
            if (resultado == 0) {
                throw NoDataException("No se realizo el borrado")
            }

            println("\nEliminación Satisfactoria!")
        } catch (e: SQLException) {
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    // ----------------- Registro de Notas -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun registrarNota(grupoId: Int, cedulaAlumno: String, nota: Int) {
        this.tryConnection()

        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{call registrarNota (?, ?, ?)}")
            pstmt?.setInt(1, grupoId)
            pstmt?.setString(2, cedulaAlumno)
            pstmt?.setInt(3, nota)
            val resultado = pstmt?.execute()
            if (resultado == true) {
                throw NoDataException("No se realizo la inserción")
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Llave duplicada")
        } finally {
            try {
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }
    }

    // ----------------- Historial Académico -----------------

    @Throws(GlobalException::class, NoDataException::class)
    override fun consultarHistorialAcademico(cedulaAlumno: String): Collection<Matricula> {
        this.tryConnection()

        var rs: ResultSet? = null
        val coleccion = mutableListOf<Matricula>()
        var pstmt: CallableStatement? = null

        try {
            pstmt = conexion?.prepareCall("{?=call consultarHistorialAcademico(?)}")
            pstmt?.registerOutParameter(1, Types.OTHER)
            pstmt?.setString(2, cedulaAlumno)
            pstmt?.execute()
            rs = pstmt?.getObject(1) as ResultSet?

            while (rs?.next() == true) {
                coleccion.add(Matricula(rs.getInt("matricula_id"), rs.getInt("anio_ciclo"), rs.getInt("numero_ciclo"), rs.getString("codigo_curso"), rs.getInt("numero_grupo"), rs.getString("cedula_alumno"), rs.getBigDecimal("nota")))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            throw GlobalException("Sentencia no valida")
        } finally {
            try {
                rs?.close()
                pstmt?.close()
                desconectar()
            } catch (e: SQLException) {
                throw GlobalException("Estatutos invalidos o nulos")
            }
        }

        if (coleccion.isNotEmpty()) {
            return coleccion
        } else {
            throw NoDataException("No hay datos")
        }
    }
}