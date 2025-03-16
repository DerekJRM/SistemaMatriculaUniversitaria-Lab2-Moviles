/*
    * @author: Derek Rojas Mendoza
    * @author: Joseph León Cabezas
*/

package org.example.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "MATRICULA", schema = "MOVILES")
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

    // toString
    override fun toString(): String {
        return "Matricula(matriculaId=$matriculaId, anioCiclo=$anioCiclo, numeroCiclo=$numeroCiclo, codigoCurso='$codigoCurso', numeroGrupo=$numeroGrupo, cedulaAlumno='$cedulaAlumno', nota=$nota)"
    }
}