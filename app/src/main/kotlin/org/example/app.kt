
// App.kt
package org.example
fun main() {
    // ====================================
    // === Etapa 1: Pruebas Básicas
    // ====================================
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

    // ================================================
    // === Etapa 2: Pruebas de Suma y Resta
    // ================================================
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
