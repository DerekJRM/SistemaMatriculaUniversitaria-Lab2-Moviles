/*
    * @author: Derek Rojas Mendoza
    * @author: Joseph León Cabezas
*/

package org.example.exceptions

class NoDataException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
    constructor() : super()
}