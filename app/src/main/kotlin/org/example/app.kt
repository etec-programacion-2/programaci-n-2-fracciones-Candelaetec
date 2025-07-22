package org.example

fun main() {
    println("=== PRUEBAS BÁSICAS (Etapa 1) ===")
    val fraccion = Fraccion(3, 4)
    println(fraccion)

    fraccion.numerador = 5
    println(fraccion)

    fraccion.denominador = 2
    println(fraccion)

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
    println("fraccion1: $fraccion1")
    println("fraccion2: $fraccion2")
    println("fraccion3: $fraccion3")
    println("fraccion4: $fraccion4")

    println("\n--- Operaciones de suma ---")
    println("$fraccion1 + $fraccion2 = ${fraccion1 + fraccion2}")
    println("Decimal: ${(fraccion1 + fraccion2).aDecimal()}")

    println("$fraccion3 + $fraccion1 = ${fraccion3 + fraccion1}")
    println("Decimal: ${(fraccion3 + fraccion1).aDecimal()}")

    println("\n--- Operaciones de resta ---")
    println("$fraccion3 - $fraccion1 = ${fraccion3 - fraccion1}")
    println("Decimal: ${(fraccion3 - fraccion1).aDecimal()}")

    println("$fraccion1 - $fraccion2 = ${fraccion1 - fraccion2}")
    println("Decimal: ${(fraccion1 - fraccion2).aDecimal()}")

    println("$fraccion2 - $fraccion1 = ${fraccion2 - fraccion1}")
    println("Decimal: ${(fraccion2 - fraccion1).aDecimal()}")

    println("\n--- Operaciones con fracciones negativas ---")
    println("$fraccion1 + $fraccion4 = ${fraccion1 + fraccion4}")
    println("Decimal: ${(fraccion1 + fraccion4).aDecimal()}")

    println("$fraccion1 - $fraccion4 = ${fraccion1 - fraccion4}")
    println("Decimal: ${(fraccion1 - fraccion4).aDecimal()}")

    println("\n=== PRUEBAS DE SIMPLIFICACIÓN (Etapa 2) ===")
    val fraccionCompleja1 = Fraccion(6, 8)
    val fraccionCompleja2 = Fraccion(10, 15)

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
    println("$f1 + $f2 + $f3 = $resultado")
    println("Decimal: ${resultado.aDecimal()}")

    println("\n=== MODIFICACIÓN DE PROPIEDADES (Etapa 1) ===")
    val fraccionModificable = Fraccion(1, 2)
    println("Fracción inicial: $fraccionModificable")

    fraccionModificable.numerador = 4
    println("Después de cambiar numerador a 4: $fraccionModificable")

    fraccionModificable.denominador = 6
    println("Después de cambiar denominador a 6: $fraccionModificable")

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
}
