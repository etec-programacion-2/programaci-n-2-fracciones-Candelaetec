
// App.kt
package org.example
fun main() {
   

    println("=== PRUEBAS BÁSICAS (Etapa 1) ===")
    val fraccion = Fraccion(3, 4)
    fraccion.mostrar()

    fraccion.numerador = 5
    fraccion.mostrar()

    fraccion.denominador = 2
    fraccion.mostrar()

    try {
        fraccion.denominador = 0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    println("\n=== PRUEBAS DE OPERADORES SUMA Y RESTA (Etapa 2) ===")

    val fraccion1 = Fraccion(1, 2)
    val fraccion2 = Fraccion(1, 3)
    val fraccion3 = Fraccion(3, 4)
    val fraccion4 = Fraccion(-1, 3)

    println("Fracciones creadas:")
    print("fraccion1: "); fraccion1.mostrar()
    print("fraccion2: "); fraccion2.mostrar()
    print("fraccion3: "); fraccion3.mostrar()
    print("fraccion4: "); fraccion4.mostrar()

    println("\n--- Operaciones de suma ---")
    val suma1 = fraccion1 + fraccion2
    println("${fraccion1} + ${fraccion2} = ${suma1}")
    println("Decimal: ${suma1.aDecimal()}")

    val suma2 = fraccion3 + fraccion1
    println("${fraccion3} + ${fraccion1} = ${suma2}")
    println("Decimal: ${suma2.aDecimal()}")

    println("\n--- Operaciones de resta ---")
    val resta1 = fraccion3 - fraccion1
    println("${fraccion3} - ${fraccion1} = ${resta1}")
    println("Decimal: ${resta1.aDecimal()}")

    val resta2 = fraccion1 - fraccion2
    println("${fraccion1} - ${fraccion2} = ${resta2}")
    println("Decimal: ${resta2.aDecimal()}")

    val resta3 = fraccion2 - fraccion1
    println("${fraccion2} - ${fraccion1} = ${resta3}")
    println("Decimal: ${resta3.aDecimal()}")

    println("\n--- Operaciones con fracciones negativas ---")
    val suma3 = fraccion1 + fraccion4
    println("${fraccion1} + ${fraccion4} = ${suma3}")
    println("Decimal: ${suma3.aDecimal()}")

    val resta4 = fraccion1 - fraccion4
    println("${fraccion1} - ${fraccion4} = ${resta4}")
    println("Decimal: ${resta4.aDecimal()}")

    println("\n=== PRUEBAS DE SIMPLIFICACIÓN (Etapa 2) ===")
    val fraccionCompleja1 = Fraccion(6, 8)
    val fraccionCompleja2 = Fraccion(10, 15)

    println("Fracciones que se simplifican automáticamente:")
    println("Fracción(6, 8) = ${fraccionCompleja1}")
    println("Fracción(10, 15) = ${fraccionCompleja2}")

    val sumaCompleja = fraccionCompleja1 + fraccionCompleja2
    println("${fraccionCompleja1} + ${fraccionCompleja2} = ${sumaCompleja}")
    println("Decimal: ${sumaCompleja.aDecimal()}")

    println("\n=== OPERACIONES ENCADENADAS (Etapa 2) ===")
    val f1 = Fraccion(1, 4)
    val f2 = Fraccion(1, 4)
    val f3 = Fraccion(1, 2)

    val resultado = f1 + f2 + f3
    println("${f1} + ${f2} + ${f3} = ${resultado}")
    println("Decimal: ${resultado.aDecimal()}")

    println("\n=== MODIFICACIÓN DE PROPIEDADES (Etapa 1) ===")
    val fraccionModificable = Fraccion(1, 2)
    println("Fracción inicial: ${fraccionModificable}")

    fraccionModificable.numerador = 4
    println("Después de cambiar numerador a 4: ${fraccionModificable}")

    fraccionModificable.denominador = 6
    println("Después de cambiar denominador a 6: ${fraccionModificable}")

    println("\n=== PRUEBAS DE VALIDACIÓN (Etapa 4) ===")
    try {
        val fraccionInvalida = Fraccion(1, 0)
    } catch (e: IllegalArgumentException) {
        println("Error al crear fracción con denominador 0: ${e.message}")
    }

    try {
        val f1 = Fraccion(1, 2)
        val f2 = Fraccion(1, 1)
        println("Intentando cambiar denominador a 0...")
        f2.denominador = 0
        val resultado = f1 + f2
    } catch (e: IllegalArgumentException) {
        println("Error capturado correctamente: ${e.message}")
    }

     // ======================================
    // === Etapa 4: Métodos de Utilidad
    // ======================================

    fun aDecimal(): Double = _numerador.toDouble() / _denominador.toDouble()

    fun esMayor(otra: Fraccion): Boolean {
        return this.compareTo(otra) > 0
    }

    fun esMenor(otra: Fraccion): Boolean {
        return this.compareTo(otra) < 0
    }

    // ======================================
    // === Etapa 4: Comparaciones
    // ======================================

    operator fun compareTo(otra: Fraccion): Int {
        val thisDecimal = this.aDecimal()
        val otherDecimal = otra.aDecimal()
        return when {
            thisDecimal < otherDecimal -> -1
            thisDecimal > otherDecimal -> 1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return _numerador == other._numerador && _denominador == other._denominador
    }

    override fun hashCode(): Int {
        return 31 * _numerador + _denominador
    }

    // ======================================
    // === Etapa 4: Conversión desde Decimal
    // ======================================

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val denominador = 10000
            val numerador = (decimal * denominador).toInt()
            return Fraccion(numerador, denominador).apply { simplificar() }
        }
    }
}