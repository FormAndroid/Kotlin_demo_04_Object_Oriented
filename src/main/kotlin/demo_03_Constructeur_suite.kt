fun main() {

    // En plus du constructeur primaire, il est possible de créer des constructeurs secondaires
    val toto: Chat = Chat("Toto", false)
    val leChat: Chat = Chat("Le chat", true, 5, true)

    // Il est possible d'utiliser les parametres par default dans les constructeurs
    val rex: Chien = Chien("Rex", "Labradore", 10, true)
    val riri: Chien = Chien("Riri", "Eurasier", estSterile = true)
}


class Chat(val nom: String, val poilsLong: Boolean) {
    private var estSterile: Boolean = false
    var age : Int? = null

    constructor(nom: String, poilsLong: Boolean, age: Int) : this(nom, poilsLong) {
        this.age = age
    }

    constructor(nom: String, poilsLong: Boolean, age:Int, estSterile: Boolean) : this(nom, poilsLong, age) {
        this.estSterile = estSterile
    }
}

class Chien(val nom: String, val race: String, var age: Int? = null, val estSterile: Boolean = false)
