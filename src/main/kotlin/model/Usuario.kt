package org.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USUARIO")
class Usuario {
    @Id
    @Column(name = "CEDULA", length = 20, nullable = false)
    private var cedula: String = ""

    @Column(name = "CLAVE", length = 20, nullable = false)
    private var clave: String = ""

    @Column(name = "TIPO_USUARIO", length = 20, nullable = false)
    private var tipoUsuario: String = ""

    companion object {
        const val TIPO_ADMINISTRADOR = "ADMINISTRADOR"
        const val TIPO_MATRICULADOR = "MATRICULADOR"
        const val TIPO_PROFESOR = "PROFESOR"
        const val TIPO_ALUMNO = "ALUMNO"
    }

    constructor() {}

    constructor(cedula: String, clave: String, tipoUsuario: String) {
        this.cedula = cedula
        this.clave = clave
        setTipoUsuario(tipoUsuario) // Usa el setter para validar
    }

    // Getters y Setters
    fun getCedula(): String {
        return cedula
    }

    fun setCedula(cedula: String) {
        this.cedula = cedula
    }

    fun getClave(): String {
        return clave
    }

    fun setClave(clave: String) {
        this.clave = clave
    }

    fun getTipoUsuario(): String {
        return tipoUsuario
    }

    fun setTipoUsuario(tipoUsuario: String) {
        if (tipoUsuario == TIPO_ADMINISTRADOR ||
            tipoUsuario == TIPO_MATRICULADOR ||
            tipoUsuario == TIPO_PROFESOR ||
            tipoUsuario == TIPO_ALUMNO) {
            this.tipoUsuario = tipoUsuario
        } else {
            throw IllegalArgumentException("Tipo de usuario no válido")
        }
    }

//    // Métodos adicionales
//
//    /**
//     * Verifica si las credenciales proporcionadas son correctas
//     * @param cedulaInput La cédula a verificar
//     * @param claveInput La clave a verificar
//     * @return true si las credenciales son correctas, false en caso contrario
//     */
//    fun verificarCredenciales(cedulaInput: String, claveInput: String): Boolean {
//        return this.cedula == cedulaInput && this.clave == claveInput
//    }
//
//    /**
//     * Verifica si el usuario es administrador
//     * @return true si es administrador, false en caso contrario
//     */
//    fun esAdministrador(): Boolean {
//        return tipoUsuario == TIPO_ADMINISTRADOR
//    }
//
//    /**
//     * Verifica si el usuario es matriculador
//     * @return true si es matriculador, false en caso contrario
//     */
//    fun esMatriculador(): Boolean {
//        return tipoUsuario == TIPO_MATRICULADOR
//    }
//
//    /**
//     * Verifica si el usuario es profesor
//     * @return true si es profesor, false en caso contrario
//     */
//    fun esProfesor(): Boolean {
//        return tipoUsuario == TIPO_PROFESOR
//    }
//
//    /**
//     * Verifica si el usuario es alumno
//     * @return true si es alumno, false en caso contrario
//     */
//    fun esAlumno(): Boolean {
//        return tipoUsuario == TIPO_ALUMNO
//    }
//
//    /**
//     * Cambia la contraseña del usuario
//     * @param claveActual La clave actual para verificación
//     * @param claveNueva La nueva clave a establecer
//     * @return true si el cambio fue exitoso, false si la clave actual es incorrecta
//     */
//    fun cambiarClave(claveActual: String, claveNueva: String): Boolean {
//        if (this.clave == claveActual) {
//            this.clave = claveNueva
//            return true
//        }
//        return false
//    }
//
//    /**
//     * Valida que los datos del usuario sean correctos
//     * @return true si los datos son válidos, false en caso contrario
//     */
//    fun validarDatos(): Boolean {
//        return cedula.isNotEmpty() && clave.isNotEmpty() &&
//                (tipoUsuario == TIPO_ADMINISTRADOR ||
//                        tipoUsuario == TIPO_MATRICULADOR ||
//                        tipoUsuario == TIPO_PROFESOR ||
//                        tipoUsuario == TIPO_ALUMNO)
//    }

    // toString
    override fun toString(): String {
        return "Usuario(cedula='$cedula', tipoUsuario='$tipoUsuario')"
    }
}