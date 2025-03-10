package org.example.model

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "CICLO")
class Ciclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CICLO_ID")
    private var cicloId: Int = 0

    @Column(name = "ANIO", nullable = false)
    private var anio: Int = 0

    @Column(name = "NUMERO", nullable = false)
    private var numero: Int = 0

    @Column(name = "FECHA_INICIO", nullable = false)
    private var fechaInicio: Date = Date()

    @Column(name = "FECHA_FIN", nullable = false)
    private var fechaFin: Date = Date()

    @Column(name = "ACTIVO", nullable = false)
    private var activo: Boolean = false

    constructor() {}

    constructor(cicloId: Int, anio: Int, numero: Int, fechaInicio: Date, fechaFin: Date, activo: Boolean = false) {
        this.cicloId = cicloId
        this.anio = anio
        this.numero = numero
        this.fechaInicio = fechaInicio
        this.fechaFin = fechaFin
        this.activo = activo
    }

    // Getters y Setters
    fun getCicloId(): Int {
        return cicloId
    }

    fun setCicloId(cicloId: Int) {
        this.cicloId = cicloId
    }

    fun getAnio(): Int {
        return anio
    }

    fun setAnio(anio: Int) {
        this.anio = anio
    }

    fun getNumero(): Int {
        return numero
    }

    fun setNumero(numero: Int) {
        if (numero == 1 || numero == 2) {
            this.numero = numero
        } else {
            throw IllegalArgumentException("El número de ciclo debe ser 1 o 2")
        }
    }

    fun getFechaInicio(): Date {
        return fechaInicio
    }

    fun setFechaInicio(fechaInicio: Date) {
        this.fechaInicio = fechaInicio
    }

    fun getFechaFin(): Date {
        return fechaFin
    }

    fun setFechaFin(fechaFin: Date) {
        this.fechaFin = fechaFin
    }

    fun isActivo(): Boolean {
        return activo
    }

    fun setActivo(activo: Boolean) {
        this.activo = activo
    }

//    // Métodos adicionales
//
//    /**
//     * Calcula la duración del ciclo en días
//     * @return Número de días que dura el ciclo
//     */
//    fun calcularDuracion(): Long {
//        val diffInMilis = fechaFin.time - fechaInicio.time
//        return diffInMilis / (1000 * 60 * 60 * 24)
//    }
//
//    /**
//     * Verifica si una fecha está dentro del período del ciclo
//     * @param fecha La fecha a verificar
//     * @return true si la fecha está en el período, false en caso contrario
//     */
//    fun fechaEnPeriodo(fecha: Date): Boolean {
//        return fecha.after(fechaInicio) && fecha.before(fechaFin)
//    }
//
//    /**
//     * Activa el ciclo actual
//     */
//    fun activarCiclo() {
//        this.activo = true
//    }
//
//    /**
//     * Desactiva el ciclo actual
//     */
//    fun desactivarCiclo() {
//        this.activo = false
//    }

    // toString
    override fun toString(): String {
        return "Ciclo(cicloId=$cicloId, anio=$anio, numero=$numero, fechaInicio=$fechaInicio, fechaFin=$fechaFin, activo=$activo)"
    }
}