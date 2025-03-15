package org.example.controller

import org.example.model.*
import org.example.service.I_Service
import org.example.service.Service

class Controller {
    
    private val service: I_Service = Service()

    // ----------------- CRUD para Carrera -----------------

    fun insertarCarrera(carrera: Carrera) {
        try {
            service.insertarCarrera(carrera)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCarreras(): Collection<Carrera> {
        try {
            return service.obtenerCarreras()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarCarrera(carrera: Carrera) {
        try {
            service.actualizarCarrera(carrera)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarCarrera(codigo: String) {
        try {
            service.eliminarCarrera(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCarreraPorCodigo(codigo: String): Carrera? {
        try {
            return service.obtenerCarreraPorCodigo(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCarreraPorNombre(nombre: String): Collection<Carrera> {
        try {
            return service.obtenerCarreraPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Curso -----------------

    fun insertarCurso(curso: Curso) {
        try {
            service.insertarCurso(curso)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCursos(): Collection<Curso> {
        try {
            return service.obtenerCursos()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarCurso(curso: Curso) {
        try {
            service.actualizarCurso(curso)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarCurso(codigo: String) {
        try {
            service.eliminarCurso(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCursoPorCodigo(codigo: String): Curso? {
        try {
            return service.obtenerCursoPorCodigo(codigo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCursosPorCarrera(codigoCarrera: String): Collection<Curso> {
        try {
            return service.obtenerCursosPorCarrera(codigoCarrera)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCursosPorNombre(nombre: String): Collection<Curso> {
        try {
            return service.obtenerCursosPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Carrera_Curso -----------------

    fun insertarCarreraCurso(carreraCurso: CarreraCurso) {
        try {
            service.insertarCarreraCurso(carreraCurso)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCarrerasCursos(): Collection<CarreraCurso> {
        try {
            return service.obtenerCarrerasCursos()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarCarreraCurso(carreraCurso: CarreraCurso) {
        try {
            service.actualizarCarreraCurso(carreraCurso)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarCarreraCurso(carreraCursoId: Int) {
        try {
            service.eliminarCarreraCurso(carreraCursoId)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCarreraCursoPorId(carreraCursoId: Int): CarreraCurso? {
        try {
            return service.obtenerCarreraCursoPorId(carreraCursoId)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Profesor -----------------

    fun insertarProfesor(profesor: Profesor) {
        try {
            service.insertarProfesor(profesor)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerProfesores(): Collection<Profesor> {
        try {
            return service.obtenerProfesores()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarProfesor(profesor: Profesor) {
        try {
            service.actualizarProfesor(profesor)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarProfesor(cedula: String) {
        try {
            service.eliminarProfesor(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerProfesorPorCedula(cedula: String): Profesor? {
        try {
            return service.obtenerProfesorPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerProfesorPorNombre(nombre: String): Collection<Profesor> {
        try {
            return service.obtenerProfesorPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Alumno -----------------

    fun insertarAlumno(alumno: Alumno) {
        try {
            service.insertarAlumno(alumno)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerAlumnos(): Collection<Alumno> {
        try {
            return service.obtenerAlumnos()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarAlumno(alumno: Alumno) {
        try {
            service.actualizarAlumno(alumno)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarAlumno(cedula: String) {
        try {
            service.eliminarAlumno(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerAlumnoPorCedula(cedula: String): Alumno? {
        try {
            return service.obtenerAlumnoPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerAlumnoPorNombre(nombre: String): Collection<Alumno> {
        try {
            return service.obtenerAlumnoPorNombre(nombre)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerAlumnosPorCarrera(codigoCarrera: String): Collection<Alumno> {
        try {
            return service.obtenerAlumnosPorCarrera(codigoCarrera)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Ciclo -----------------

    fun insertarCiclo(ciclo: Ciclo) {
        try {
            service.insertarCiclo(ciclo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCiclos(): Collection<Ciclo> {
        try {
            return service.obtenerCiclos()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarCiclo(ciclo: Ciclo) {
        try {
            service.actualizarCiclo(ciclo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarCiclo(cicloId: Int) {
        try {
            service.eliminarCiclo(cicloId)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerCicloPorAnio(anio: Int): Collection<Ciclo> {
        try {
            return service.obtenerCicloPorAnio(anio)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Grupo -----------------

    fun insertarGrupo(grupo: Grupo) {
        try {
            service.insertarGrupo(grupo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerGrupos(): Collection<Grupo> {
        try {
            return service.obtenerGrupos()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarGrupo(grupo: Grupo) {
        try {
            service.actualizarGrupo(grupo)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarGrupo(grupoId: Int) {
        try {
            service.eliminarGrupo(grupoId)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerGrupoPorId(grupoId: Int): Grupo? {
        try {
            return service.obtenerGrupoPorId(grupoId)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- CRUD para Usuario -----------------

    fun insertarUsuario(usuario: Usuario) {
        try {
            service.insertarUsuario(usuario)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerUsuarios(): Collection<Usuario> {
        try {
            return service.obtenerUsuarios()
        } catch (e: Exception) {
            throw e
        }
    }

    fun actualizarUsuario(usuario: Usuario) {
        try {
            service.actualizarUsuario(usuario)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarUsuario(cedula: String) {
        try {
            service.eliminarUsuario(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    fun obtenerUsuarioPorCedula(cedula: String): Usuario? {
        try {
            return service.obtenerUsuarioPorCedula(cedula)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Matrícula -----------------

    fun registrarMatricula(grupoId: Int, cedulaAlumno: String) {
        try {
            service.registrarMatricula(grupoId, cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }

    fun eliminarMatricula(grupoId: Int, cedulaAlumno: String) {
        try {
            service.eliminarMatricula(grupoId, cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Registro de Notas -----------------

    fun registrarNota(grupoId: Int, cedulaAlumno: String, nota: Int) {
        try {
            service.registrarNota(grupoId, cedulaAlumno, nota)
        } catch (e: Exception) {
            throw e
        }
    }

    // ----------------- Historial Académico -----------------

    fun consultarHistorialAcademico(cedulaAlumno: String): Collection<Matricula> {
        try {
            return service.consultarHistorialAcademico(cedulaAlumno)
        } catch (e: Exception) {
            throw e
        }
    }
}