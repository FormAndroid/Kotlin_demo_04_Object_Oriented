fun main() {
    val d1: DemoSurcharge = DemoSurcharge("Riri")

    d1.sayHello();
    d1.sayHello("Zaza")

    val res = d1.addition(42, 1L)
}

class DemoSurcharge(val name: String) {

    // Surcharge d'une procedure
    fun sayHello() {
        println("$name dit bonjour.")
    }

    fun sayHello(other: String) {
        println("$name dit bonjour à $other.")
    }

    // Surcharge de fonction
    fun addition(nb1: Int, nb2: Int): Int {
        return nb1 + nb2
    }

    fun addition(nb1: Int, nb2: Int, nb3: Int): Int {
        return addition(nb1, nb2) + nb3
    }

    fun addition(nb1: Long, nb2: Long, nb3: Long = 0): Long {
        return nb1 + nb2
    }
}