package org.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CARRERA")
class Carrera {
    @Id
    @Column(name = "CODIGO_CARRERA", length = 20, nullable = false)
    private var codigoCarrera: String = ""

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private var nombre: String = ""

    @Column(name = "TITULO", length = 100, nullable = false)
    private var titulo: String = ""

    constructor() {}

    constructor(codigoCarrera: String, nombre: String, titulo: String) {
        this.codigoCarrera = codigoCarrera
        this.nombre = nombre
        this.titulo = titulo
    }

    // Getters y Setters
    fun getCodigoCarrera(): String {
        return codigoCarrera
    }

    fun setCodigoCarrera(codigoCarrera: String) {
        this.codigoCarrera = codigoCarrera
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getTitulo(): String {
        return titulo
    }

    fun setTitulo(titulo: String) {
        this.titulo = titulo
    }

    // Métodos adicionales

    /**
     * Valida que los datos de la carrera sean correctos
     * @return true si los datos son válidos, false en caso contrario
     */
    fun validarDatos(): Boolean {
        return codigoCarrera.isNotEmpty() && nombre.isNotEmpty() && titulo.isNotEmpty()
    }

    /**
     * Verifica si la carrera tiene un código específico
     * @param codigo El código a verificar
     * @return true si coincide, false en caso contrario
     */
    fun tieneCodigo(codigo: String): Boolean {
        return this.codigoCarrera == codigo
    }

    // toString
    override fun toString(): String {
        return "Carrera(codigoCarrera='$codigoCarrera', nombre='$nombre', titulo='$titulo')"
    }
}