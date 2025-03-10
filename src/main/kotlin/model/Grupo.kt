package org.example.model

import javax.persistence.*

@Entity
@Table(name = "GRUPO")
class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRUPO_ID")
    private var grupoId: Int = 0

    @Column(name = "ANIO_CICLO", nullable = false)
    private var anioCiclo: Int = 0

    @Column(name = "NUMERO_CICLO", nullable = false)
    private var numeroCiclo: Int = 0

    @Column(name = "CODIGO_CURSO", length = 20, nullable = false)
    private var codigoCurso: String = ""

    @Column(name = "NUMERO_GRUPO", nullable = false)
    private var numeroGrupo: Int = 0

    @Column(name = "HORARIO", length = 100, nullable = false)
    private var horario: String = ""

    @Column(name = "CEDULA_PROFESOR", length = 20, nullable = false)
    private var cedulaProfesor: String = ""

    constructor() {}

    constructor(grupoID: Int, anioCiclo: Int, numeroCiclo: Int, codigoCurso: String, numeroGrupo: Int, horario: String, cedulaProfesor: String) {
        this.grupoId = grupoID
        this.anioCiclo = anioCiclo
        this.numeroCiclo = numeroCiclo
        this.codigoCurso = codigoCurso
        this.numeroGrupo = numeroGrupo
        this.horario = horario
        this.cedulaProfesor = cedulaProfesor
    }

    // Getters y Setters
    fun getGrupoId(): Int {
        return grupoId
    }

    fun setGrupoId(grupoId: Int) {
        this.grupoId = grupoId
    }

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

    fun getHorario(): String {
        return horario
    }

    fun setHorario(horario: String) {
        this.horario = horario
    }

    fun getCedulaProfesor(): String {
        return cedulaProfesor
    }

    fun setCedulaProfesor(cedulaProfesor: String) {
        this.cedulaProfesor = cedulaProfesor
    }

//    // Métodos adicionales
//
//    /**
//     * Genera un identificador único para el grupo
//     * @return String con el identificador único
//     */
//    fun generarIdentificadorUnico(): String {
//        return "$anioCiclo-$numeroCiclo-$codigoCurso-$numeroGrupo"
//    }
//
//    /**
//     * Verifica si el grupo es del período actual
//     * @param anioActual El año actual
//     * @param cicloActual El ciclo actual
//     * @return true si es del período actual, false en caso contrario
//     */
//    fun esPeriodoActual(anioActual: Int, cicloActual: Int): Boolean {
//        return this.anioCiclo == anioActual && this.numeroCiclo == cicloActual
//    }
//
//    /**
//     * Verifica si un profesor está asignado a este grupo
//     * @param cedulaProfesorConsulta La cédula del profesor a verificar
//     * @return true si está asignado, false en caso contrario
//     */
//    fun esImpartidoPor(cedulaProfesorConsulta: String): Boolean {
//        return this.cedulaProfesor == cedulaProfesorConsulta
//    }
//
//    /**
//     * Valida que los datos del grupo sean correctos
//     * @return true si los datos son válidos, false en caso contrario
//     */
//    fun validarDatos(): Boolean {
//        return anioCiclo > 0 && (numeroCiclo == 1 || numeroCiclo == 2) &&
//                codigoCurso.isNotEmpty() && numeroGrupo > 0 &&
//                horario.isNotEmpty() && cedulaProfesor.isNotEmpty()
//    }

    // toString
    override fun toString(): String {
        return "Grupo(grupoId=$grupoId, anioCiclo=$anioCiclo, numeroCiclo=$numeroCiclo, codigoCurso='$codigoCurso', numeroGrupo=$numeroGrupo, horario='$horario', cedulaProfesor='$cedulaProfesor')"
    }
}