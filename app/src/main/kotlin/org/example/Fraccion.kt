package org.example

class Fraccion(
    numerador: Int,
    denominador: Int
) : Comparable<Fraccion> {

    private var _numerador: Int = numerador
    private var _denominador: Int = denominador

    init {
        if (_denominador == 0) throw IllegalArgumentException("El denominador no puede ser cero")
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
            "$_numerador"
        } else {
            "$_numerador/$_denominador"
        }
    }

    fun mostrarFraccion(): String {
        return "$_numerador / $_denominador es una fracción"
    }

    fun aDecimal(): Double {
        return _numerador.toDouble() / _denominador.toDouble()
    }

    private fun simplificar() {
        val mcd = mcd(_numerador, _denominador)
        _numerador /= mcd
        _denominador /= mcd
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else mcd(b, a % b)
    }

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

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this._numerador * otra._numerador
        val nuevoDenominador = this._denominador * otra._denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        if (otra._numerador == 0) {
            throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")
        }
        val nuevoNumerador = this._numerador * otra._denominador
        val nuevoDenominador = this._denominador * otra._numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    override fun compareTo(other: Fraccion): Int {
        return this.aDecimal().compareTo(other.aDecimal())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this._numerador == other._numerador && this._denominador == other._denominador
    }

    override fun hashCode(): Int {
        return 31 * _numerador + _denominador
    }

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val denominador = 10000
            val numerador = (decimal * denominador).toInt()
            return Fraccion(numerador, denominador)
        }
    }
}
