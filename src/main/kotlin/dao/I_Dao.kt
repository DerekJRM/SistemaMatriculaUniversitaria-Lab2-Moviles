package org.example.dao

import java.sql.ResultSet

interface I_Dao {

    // ----------------- CRUD para Carrera -----------------

    fun insertarCarrera(codigo: String, nombre: String, titulo: String);

    fun obtenerCarreraPorCodigo(codigo: String): ResultSet?;

    fun actualizarCarrera(codigo: String, nombre: String, titulo: String);

    fun eliminarCarrera(codigo: String);

    // ----------------- CRUD para Curso -----------------

    fun insertarCurso(codigo: String, nombre: String, creditos: Int, horas: Int);

    fun obtenerCursoPorCodigo(codigo: String): ResultSet?;

    fun actualizarCurso(codigo: String, nombre: String, creditos: Int, horas: Int);

    fun eliminarCurso(codigo: String);

    // ----------------- CRUD para Profesor -----------------

    fun insertarProfesor(cedula: String, nombre: String, telefono: String, email: String);

    fun obtenerProfesorPorCedula(cedula: String): ResultSet?;

    fun actualizarProfesor(cedula: String, nombre: String, telefono: String, email: String);

    fun eliminarProfesor(cedula: String);

    // ----------------- CRUD para Alumno -----------------

    fun insertarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String);

    fun obtenerAlumnoPorCedula(cedula: String): ResultSet?;

    fun actualizarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String);

    fun eliminarAlumno(cedula: String);

    // ----------------- CRUD para Ciclo -----------------

    fun insertarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String);

    fun obtenerCicloPorAnio(anio: Int): ResultSet?;

    fun actualizarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String);

    fun eliminarCiclo(anio: Int, numero: Int);

    // ----------------- CRUD para Grupo -----------------

    fun insertarGrupo(cicloId: Int, cursoId: String, numero: Int, horario: String, profesorId: String);

    fun obtenerGrupoPorId(id: Int): ResultSet?;

    fun actualizarGrupo(id: Int, horario: String, profesorId: String);

    fun eliminarGrupo(id: Int);

    // ----------------- CRUD para Usuario -----------------

    fun insertarUsuario(cedula: String, clave: String, rol: String);

    fun obtenerUsuarioPorCedula(cedula: String): ResultSet?;

    fun actualizarUsuario(cedula: String, clave: String, rol: String);

    fun eliminarUsuario(cedula: String);

    // ----------------- Matrícula -----------------

    fun registrarMatricula(alumnoId: String, grupoId: Int);

    fun eliminarMatricula(alumnoId: String, grupoId: Int);

    // ----------------- Registro de Notas -----------------

    fun registrarNota(grupoId: Int, alumnoId: String, nota: Double);

    // ----------------- Historial Académico -----------------

    fun consultarHistorial(alumnoId: String): ResultSet?;
}