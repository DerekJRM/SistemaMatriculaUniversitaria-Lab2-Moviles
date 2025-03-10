package org.example.service

import org.example.Dao.Dao
import java.sql.ResultSet

class Service : I_Service {

    private val dao = Dao()

    // ----------------- CRUD para Carrera -----------------

    override fun insertarCarrera(codigo: String, nombre: String, titulo: String) {
        try {
            dao.insertarCarrera(codigo, nombre, titulo)
        } catch (e: Exception) {
            println("Error al insertar carrera: ${e.message}")
        }
    }

    override fun obtenerCarreraPorCodigo(codigo: String): ResultSet? {

    override fun actualizarCarrera(codigo: String, nombre: String, titulo: String) {

    override fun eliminarCarrera(codigo: String) {

    // ----------------- CRUD para Curso -----------------

    override fun insertarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {

    override fun obtenerCursoPorCodigo(codigo: String): ResultSet? {

    override fun actualizarCurso(codigo: String, nombre: String, creditos: Int, horas: Int) {

    override fun eliminarCurso(codigo: String) {

    // ----------------- CRUD para Profesor -----------------

    override fun insertarProfesor(cedula: String, nombre: String, telefono: String, email: String) {

    override fun obtenerProfesorPorCedula(cedula: String): ResultSet? {

    override fun actualizarProfesor(cedula: String, nombre: String, telefono: String, email: String) {

    override fun eliminarProfesor(cedula: String) {

    // ----------------- CRUD para Alumno -----------------

    override fun insertarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {

    override fun obtenerAlumnoPorCedula(cedula: String): ResultSet? {

    override fun actualizarAlumno(cedula: String, nombre: String, telefono: String, email: String, fechaNacimiento: String, carrera: String) {

    override fun eliminarAlumno(cedula: String) {

    // ----------------- CRUD para Ciclo -----------------

    override fun insertarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {

    override fun obtenerCicloPorAnio(anio: Int): ResultSet? {

    override fun actualizarCiclo(anio: Int, numero: Int, fechaInicio: String, fechaFin: String) {

    override fun eliminarCiclo(anio: Int, numero: Int) {

    // ----------------- CRUD para Grupo -----------------

    override fun insertarGrupo(cicloId: Int, cursoId: String, numero: Int, horario: String, profesorId: String) {

    override fun obtenerGrupoPorId(id: Int): ResultSet? {

    override fun actualizarGrupo(id: Int, horario: String, profesorId: String) {

    override fun eliminarGrupo(id: Int) {

    // ----------------- CRUD para Usuario -----------------

    override fun insertarUsuario(cedula: String, clave: String, rol: String) {

    override fun obtenerUsuarioPorCedula(cedula: String): ResultSet? {

    override fun actualizarUsuario(cedula: String, clave: String, rol: String) {

    override fun eliminarUsuario(cedula: String) {

    // ----------------- Matrícula -----------------

    override fun registrarMatricula(alumnoId: String, grupoId: Int) {

    override fun eliminarMatricula(alumnoId: String, grupoId: Int) {

    // ----------------- Registro de Notas -----------------

    override fun registrarNota(grupoId: Int, alumnoId: String, nota: Double) {

    // ----------------- Historial Académico -----------------

    override fun consultarHistorial(alumnoId: String): ResultSet? {
}