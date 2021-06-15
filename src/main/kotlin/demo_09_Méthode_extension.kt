fun main() {

    // Les méthodes d'extension permettent d'ajouter des comportements sur des types de données

    val de: DemoExtension = DemoExtension("Hello World", 200)
    de.isOk() // J'ai acces à la méthode "isOk" qui n'est pas défini dans la classe

    val data: MutableList<Int> = mutableListOf(4, 5, 3, 6, 2)
    println("Avant Swap : " + data.joinToString(" > "))
    data.swap(0, 2)
    println("Aprés Swap : " + data.joinToString(" > "))
    println()

    val name1: String = "Duck"
    val name2: String = "Vanderquack"
    val name3: String = "Eléphant"
    val name4: String = "Noël"
    println("$name1 contient un \"e\" : ${name1.hasCharactereE()}")
    println("$name2 contient un \"e\" : ${name2.hasCharactereE()}")
    println("$name3 contient un \"e\" : ${name3.hasCharactereE()}")
    println("$name4 contient un \"e\" : ${name4.hasCharactereE()}")

    val nb1: Int = 42
    val nb2: Int? = 13
    val nb3: Int? = null

    println("$nb1 est pair : ${nb1.isEven()}")
    println("$nb2 est pair : ${nb2.isEven()}")
    println("$nb3 est pair : ${nb3.isEven()}")
}

//region Demo sur la classe "DemoExtension"
class DemoExtension(val message: String, val code: Int) {
    // Pour la démo, le code fonctionne comme les codes html

    override fun toString(): String {
        return "($code) $message"
    }
}

fun DemoExtension.isOk() : Boolean {
    return code in 200 until 300;
}
//endregion

//region Demo sur des classes existante
fun MutableList<Int>.swap(indice1: Int, indice2: Int) {
    val temp = this[indice1]
    this[indice1] = this[indice2]
    this[indice2] = temp
}

fun String.hasCharactereE() = this.contains(Regex("[eéèêë]", RegexOption.IGNORE_CASE))
//endregion

//region Demo avec la gestion du nullable
fun Int?.isEven(): Boolean {
    if(this == null)
        return false

    return this % 2 == 0
}
//endregion