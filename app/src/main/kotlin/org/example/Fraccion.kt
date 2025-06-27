package org.example
class Fraccion(numeradorInicial: Int, denominadorInicial: Int) {
    var numerador: Int = numeradorInicial
        set(value) {
            field = value
        }
    
    var denominador: Int = denominadorInicial
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }
    
    // Validar denominador en el constructor
    init {
        if (denominadorInicial == 0) {
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }
    
    // Método toString para representación en cadena
    override fun toString(): String {
        return "$numerador/$denominador"
    }
    
    // Método mostrar para imprimir la fracción
    fun mostrar() {
        println(this.toString())
    }
}