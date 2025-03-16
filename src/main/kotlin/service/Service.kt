/*
    * @author: Derek Rojas Mendoza
    * @author: Joseph León Cabezas
*/

package org.example.service

import org.example.dao.DaoMatricula
import org.example.dao.I_DaoMatricula
import org.example.model.*

class Service : I_Service {

    private val dao: I_DaoMatricula = DaoMatricula()

    // ----------------- CRUD para Carrera -----------------

    override fun insertarCarrera(carrera: Carrera) {
        try {
            dao.insertarCarrera(carrera)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCarreras(): Collection<Carrera> {
        try {
            return dao.obtenerCarreras()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarCarrera(carrera: Carrera) {
        try {
            dao.actualizarCarrera(carrera)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarCarrera(codigo: String) {
        try {
            dao.eliminarCarrera(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCarreraPorCodigo(codigo: String): Carrera? {
        try {
            return dao.obtenerCarreraPorCodigo(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCarreraPorNombre(nombre: String): Collection<Carrera> {
        try {
            return dao.obtenerCarreraPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Curso -----------------

    override fun insertarCurso(curso: Curso) {
        try {
            dao.insertarCurso(curso)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCursos(): Collection<Curso> {
        try {
            return dao.obtenerCursos()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarCurso(curso: Curso) {
        try {
            dao.actualizarCurso(curso)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarCurso(codigo: String) {
        try {
            dao.eliminarCurso(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCursoPorCodigo(codigo: String): Curso? {
        try {
            return dao.obtenerCursoPorCodigo(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCursosPorCarrera(codigoCarrera: String): Collection<Curso> {
        try {
            return dao.obtenerCursosPorCarrera(codigoCarrera)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCursosPorNombre(nombre: String): Collection<Curso> {
        try {
            return dao.obtenerCursosPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Carrera_Curso -----------------

    override fun insertarCarreraCurso(carreraCurso: CarreraCurso) {
        try {
            dao.insertarCarreraCurso(carreraCurso)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCarrerasCursos(): Collection<CarreraCurso> {
        try {
            return dao.obtenerCarrerasCursos()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarCarreraCurso(carreraCurso: CarreraCurso) {
        try {
            dao.actualizarCarreraCurso(carreraCurso)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarCarreraCurso(carreraCursoId: Int) {
        try {
            dao.eliminarCarreraCurso(carreraCursoId)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCarreraCursoPorId(carreraCursoId: Int): CarreraCurso? {
        try {
            return dao.obtenerCarreraCursoPorId(carreraCursoId)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Profesor -----------------

    override fun insertarProfesor(profesor: Profesor) {
        try {
            dao.insertarProfesor(profesor)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerProfesores(): Collection<Profesor> {
        try {
            return dao.obtenerProfesores()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarProfesor(profesor: Profesor) {
        try {
            dao.actualizarProfesor(profesor)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarProfesor(cedula: String) {
        try {
            dao.eliminarProfesor(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerProfesorPorCedula(cedula: String): Profesor? {
        try {
            return dao.obtenerProfesorPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerProfesorPorNombre(nombre: String): Collection<Profesor> {
        try {
            return dao.obtenerProfesorPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Alumno -----------------

    override fun insertarAlumno(alumno: Alumno) {
        try {
            dao.insertarAlumno(alumno)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerAlumnos(): Collection<Alumno> {
        try {
            return dao.obtenerAlumnos()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarAlumno(alumno: Alumno) {
        try {
            dao.actualizarAlumno(alumno)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarAlumno(cedula: String) {
        try {
            dao.eliminarAlumno(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerAlumnoPorCedula(cedula: String): Alumno? {
        try {
            return dao.obtenerAlumnoPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerAlumnoPorNombre(nombre: String): Collection<Alumno> {
        try {
            return dao.obtenerAlumnoPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerAlumnosPorCarrera(codigoCarrera: String): Collection<Alumno> {
        try {
            return dao.obtenerAlumnosPorCarrera(codigoCarrera)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Ciclo -----------------

    override fun insertarCiclo(ciclo: Ciclo) {
        try {
            dao.insertarCiclo(ciclo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCiclos(): Collection<Ciclo> {
        try {
            return dao.obtenerCiclos()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarCiclo(ciclo: Ciclo) {
        try {
            dao.actualizarCiclo(ciclo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarCiclo(cicloId: Int) {
        try {
            dao.eliminarCiclo(cicloId)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerCicloPorAnio(anio: Int): Collection<Ciclo> {
        try {
            return dao.obtenerCicloPorAnio(anio)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Grupo -----------------

    override fun insertarGrupo(grupo: Grupo) {
        try {
            dao.insertarGrupo(grupo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerGrupos(): Collection<Grupo> {
        try {
            return dao.obtenerGrupos()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarGrupo(grupo: Grupo) {
        try {
            dao.actualizarGrupo(grupo)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarGrupo(grupoId: Int) {
        try {
            dao.eliminarGrupo(grupoId)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerGrupoPorId(grupoId: Int): Grupo? {
        try {
            return dao.obtenerGrupoPorId(grupoId)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Usuario -----------------

    override fun insertarUsuario(usuario: Usuario) {
        try {
            dao.insertarUsuario(usuario)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerUsuarios(): Collection<Usuario> {
        try {
            return dao.obtenerUsuarios()
        } catch (e: Exception) {
            throw e
        }
    }

    override fun actualizarUsuario(usuario: Usuario) {
        try {
            dao.actualizarUsuario(usuario)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarUsuario(cedula: String) {
        try {
            dao.eliminarUsuario(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun obtenerUsuarioPorCedula(cedula: String): Usuario? {
        try {
            return dao.obtenerUsuarioPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Matrícula -----------------

    override fun registrarMatricula(grupoId: Int, cedulaAlumno: String) {
        try {
            dao.registrarMatricula(grupoId, cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }

    override fun eliminarMatricula(grupoId: Int, cedulaAlumno: String) {
        try {
            dao.eliminarMatricula(grupoId, cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Registro de Notas -----------------

    override fun registrarNota(grupoId: Int, cedulaAlumno: String, nota: Int) {
        try {
            dao.registrarNota(grupoId, cedulaAlumno, nota)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Historial Académico -----------------

    override fun consultarHistorialAcademico(cedulaAlumno: String): Collection<Matricula> {
        try {
            return dao.consultarHistorialAcademico(cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }
}