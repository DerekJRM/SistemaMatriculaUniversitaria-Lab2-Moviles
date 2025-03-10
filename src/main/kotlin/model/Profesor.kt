package org.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PROFESOR")
class Profesor {
    @Id
    @Column(name = "CEDULA", length = 20, nullable = false)
    private var cedula: String = ""

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private var nombre: String = ""

    @Column(name = "TELEFONO", length = 20)
    private var telefono: String? = null

    @Column(name = "EMAIL", length = 100, nullable = false)
    private var email: String = ""

    constructor() {}

    constructor(cedula: String, nombre: String, telefono: String?, email: String) {
        this.cedula = cedula
        this.nombre = nombre
        this.telefono = telefono
        this.email = email
    }

    // Getters y Setters
    fun getCedula(): String {
        return cedula
    }

    fun setCedula(cedula: String) {
        this.cedula = cedula
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getTelefono(): String? {
        return telefono
    }

    fun setTelefono(telefono: String?) {
        this.telefono = telefono
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

//    // Métodos adicionales
//
//    /**
//     * Valida que los datos del profesor sean correctos
//     * @return true si los datos son válidos, false en caso contrario
//     */
//    fun validarDatos(): Boolean {
//        return cedula.isNotEmpty() && nombre.isNotEmpty() && email.isNotEmpty()
//    }
//
//    /**
//     * Verifica si el email del profesor es institucional
//     * @param dominio El dominio institucional
//     * @return true si es institucional, false en caso contrario
//     */
//    fun tieneEmailInstitucional(dominio: String): Boolean {
//        return email.endsWith(dominio)
//    }
//
//    /**
//     * Obtiene información de contacto completa
//     * @return String con la información de contacto
//     */
//    fun obtenerContacto(): String {
//        return "Nombre: $nombre, Email: $email, Teléfono: ${telefono ?: "No disponible"}"
//    }

    // toString
    override fun toString(): String {
        return "Profesor(cedula='$cedula', nombre='$nombre', telefono=$telefono, email='$email')"
    }
}