package org.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CURSO")
class Curso {
    @Id
    @Column(name = "CODIGO_CURSO", length = 20, nullable = false)
    private var codigoCurso: String = ""

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private var nombre: String = ""

    @Column(name = "CREDITOS", nullable = false)
    private var creditos: Int = 0

    @Column(name = "HORAS_SEMANALES", nullable = false)
    private var horasSemanales: Int = 0

    constructor() {}

    constructor(codigoCurso: String, nombre: String, creditos: Int, horasSemanales: Int) {
        this.codigoCurso = codigoCurso
        this.nombre = nombre
        this.creditos = creditos
        this.horasSemanales = horasSemanales
    }

    // Getters y Setters
    fun getCodigoCurso(): String {
        return codigoCurso
    }

    fun setCodigoCurso(codigoCurso: String) {
        this.codigoCurso = codigoCurso
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getCreditos(): Int {
        return creditos
    }

    fun setCreditos(creditos: Int) {
        this.creditos = creditos
    }

    fun getHorasSemanales(): Int {
        return horasSemanales
    }

    fun setHorasSemanales(horasSemanales: Int) {
        this.horasSemanales = horasSemanales
    }

    // Métodos adicionales

    /**
     * Calcula el costo del curso basado en los créditos
     * @param costoPorCredito El costo por cada crédito
     * @return El costo total del curso
     */
    fun calcularCosto(costoPorCredito: Double): Double {
        return creditos * costoPorCredito
    }

    /**
     * Valida que los datos del curso sean correctos
     * @return true si los datos son válidos, false en caso contrario
     */
    fun validarDatos(): Boolean {
        return codigoCurso.isNotEmpty() && nombre.isNotEmpty() && creditos > 0 && horasSemanales > 0
    }

    /**
     * Verifica si el curso es de alta carga horaria
     * @return true si tiene más de 5 horas semanales, false en caso contrario
     */
    fun esAltaCargaHoraria(): Boolean {
        return horasSemanales > 5
    }

    // toString
    override fun toString(): String {
        return "Curso(codigoCurso='$codigoCurso', nombre='$nombre', creditos=$creditos, horasSemanales=$horasSemanales)"
    }
}