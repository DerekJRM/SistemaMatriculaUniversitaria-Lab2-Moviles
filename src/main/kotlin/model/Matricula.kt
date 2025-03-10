package org.example.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "MATRICULA")
class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATRICULA_ID")
    private var matriculaId: Int = 0

    @Column(name = "ANIO_CICLO", nullable = false)
    private var anioCiclo: Int = 0

    @Column(name = "NUMERO_CICLO", nullable = false)
    private var numeroCiclo: Int = 0

    @Column(name = "CODIGO_CURSO", length = 20, nullable = false)
    private var codigoCurso: String = ""

    @Column(name = "NUMERO_GRUPO", nullable = false)
    private var numeroGrupo: Int = 0

    @Column(name = "CEDULA_ALUMNO", length = 20, nullable = false)
    private var cedulaAlumno: String = ""

    @Column(name = "NOTA")
    private var nota: BigDecimal? = null

    constructor() {}

    constructor(matriculaId: Int, anioCiclo: Int, numeroCiclo: Int, codigoCurso: String, numeroGrupo: Int, cedulaAlumno: String, nota: BigDecimal? = null) {
        this.matriculaId = matriculaId
        this.anioCiclo = anioCiclo
        this.numeroCiclo = numeroCiclo
        this.codigoCurso = codigoCurso
        this.numeroGrupo = numeroGrupo
        this.cedulaAlumno = cedulaAlumno
        this.nota = nota
    }

    // Getters y Setters
    fun getAnioCiclo(): Int {
        return anioCiclo
    }

    fun setAnioCiclo(anioCiclo: Int) {
        this.anioCiclo = anioCiclo
    }

    fun getNumeroCiclo(): Int {
        return numeroCiclo
    }

    fun setNumeroCiclo(numeroCiclo: Int) {
        if (numeroCiclo == 1 || numeroCiclo == 2) {
            this.numeroCiclo = numeroCiclo
        } else {
            throw IllegalArgumentException("El número de ciclo debe ser 1 o 2")
        }
    }

    fun getCodigoCurso(): String {
        return codigoCurso
    }

    fun setCodigoCurso(codigoCurso: String) {
        this.codigoCurso = codigoCurso
    }

    fun getNumeroGrupo(): Int {
        return numeroGrupo
    }

    fun setNumeroGrupo(numeroGrupo: Int) {
        this.numeroGrupo = numeroGrupo
    }

    fun getCedulaAlumno(): String {
        return cedulaAlumno
    }

    fun setCedulaAlumno(cedulaAlumno: String) {
        this.cedulaAlumno = cedulaAlumno
    }

    fun getNota(): BigDecimal? {
        return nota
    }

    fun setNota(nota: BigDecimal?) {
        this.nota = nota
    }

//    // Métodos adicionales
//
//    /**
//     * Verifica si la matrícula ya tiene una nota asignada
//     * @return true si tiene nota, false en caso contrario
//     */
//    fun tieneNota(): Boolean {
//        return nota != null
//    }
//
//    /**
//     * Verifica si el alumno aprobó el curso (nota >= 70)
//     * @return true si aprobó, false si no aprobó o no tiene nota
//     */
//    fun estaAprobado(): Boolean {
//        return nota?.compareTo(BigDecimal("70")) != null &&
//                nota?.compareTo(BigDecimal("70")) != null &&
//                nota?.compareTo(BigDecimal("70"))!! >= 0
//    }
//
//    /**
//     * Calcula el estado de la matrícula basado en la nota
//     * @return String con el estado (Aprobado, Reprobado, Sin Evaluar)
//     */
//    fun calcularEstado(): String {
//        if (nota == null) {
//            return "Sin Evaluar"
//        }
//
//        return if (estaAprobado()) "Aprobado" else "Reprobado"
//    }
//
//    /**
//     * Genera un identificador único para la matrícula
//     * @return String con el identificador único
//     */
//    fun generarIdentificadorUnico(): String {
//        return "$anioCiclo-$numeroCiclo-$codigoCurso-$numeroGrupo-$cedulaAlumno"
//    }
//
//    /**
//     * Valida que los datos de la matrícula sean correctos
//     * @return true si los datos son válidos, false en caso contrario
//     */
//    fun validarDatos(): Boolean {
//        return anioCiclo > 0 && (numeroCiclo == 1 || numeroCiclo == 2) &&
//                codigoCurso.isNotEmpty() && numeroGrupo > 0 &&
//                cedulaAlumno.isNotEmpty()
//    }

    // toString
    override fun toString(): String {
        return "Matricula(matriculaId=$matriculaId, anioCiclo=$anioCiclo, numeroCiclo=$numeroCiclo, codigoCurso='$codigoCurso', numeroGrupo=$numeroGrupo, cedulaAlumno='$cedulaAlumno', nota=$nota)"
    }
}