package org.example

// ====================================
// === Etapa 1: Definición de la Clase
// ====================================
class Fraccion(
    numerador: Int,
    denominador: Int
) {
    private var _numerador: Int = numerador
    private var _denominador: Int = denominador

    init {
        if (denominador == 0) throw IllegalArgumentException("El denominador no puede ser cero")
        // Normalizar signo
        if (_denominador < 0) {
            _numerador = -_numerador
            _denominador = -_denominador
        }
        simplificar()
    }

    var numerador: Int
        get() = _numerador
        set(value) {
            _numerador = value
            simplificar()
        }

    var denominador: Int
        get() = _denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            _denominador = value
            if (_denominador < 0) {
                _numerador = -_numerador
                _denominador = -_denominador
            }
            simplificar()
        }

    override fun toString(): String {
        return if (_denominador == 1) {
            _numerador.toString()
        } else {
            "$_numerador/$_denominador"
        }
    }

    fun obtenerValor(): String {
        return toString()
    }

    fun mostrarFraccion(): String {
        return "$_numerador / $_denominador es una fracción"
    }

    // ============================================
    // === Etapa 2: Suma y Resta de Fracciones
    // ============================================

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._denominador + this._denominador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._denominador - this._denominador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }
