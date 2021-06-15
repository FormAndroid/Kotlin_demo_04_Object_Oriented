fun main() {

    // Le Kotlin permet de surcharger les operateurs (Ce qui est impossible en Java)
    // Il est donc possible de coder un comportement pour :
    //  - Les operateurs arithmetique
    //  - Les operateurs de comparaison
    //  - L'operateur d'acces []
    // Documentation https://kotlinlang.org/docs/operator-overloading.html

    val p1: Pomme = Pomme("Rouge", 100)
    val p2: Pomme = Pomme("Verte", 117)
    val p3: Pomme = Pomme("Jaune", 75)

    val panier1 = Panier()
    panier1.ajouter(p1)
    panier1.ajouter(p2)
    panier1.ajouter(p3)

    val panier2 = Panier()
    panier2.ajouter(Pomme("Rouge", 150))
    panier2.ajouter(Pomme("Verte", 99))

    println("Avant")
    println("Panier1 : " + panier1.contenu.joinToString(", "))
    println("Panier2 : " + panier2.contenu.joinToString(", "))
    println()

    val panier3: Panier = panier1 + panier2 // Equivalent a -> panier1.plus(panier2)

    println("Aprés")
    println("Panier1 : " + panier1.contenu.joinToString(", "))
    println("Panier2 : " + panier2.contenu.joinToString(", "))
    println("Panier3 : " + panier3.contenu.joinToString(", "))
    println()

    val p4 = Pomme("Rose", 75)
    val p5 = Pomme("Rose", 75)
    println("Pomme 4 et pomme 5 sont egale: ${p4 == p5}")
    println("Pomme 4 et pomme 5 ont la même reference: ${p4 === p5}")
}

class Pomme(val couleur: String, poids: Int) {
    var poids: Int = 0
        private set(value) {
            if (value <= 0) throw IllegalArgumentException("Poids invalide !")

            field = value
        }

    init {
        this.poids = poids
    }

    override fun toString(): String {
        return "Pomme $couleur ($poids gr)"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Pomme) {
            return this.couleur == other.couleur && this.poids == other.poids
        }
        return false
    }

}

class Panier {

    // Liste modifiable protegé (Backing propertie)
    private val _contenu: MutableList<Pomme> = mutableListOf()

    // Liste non mutable pour acceder au contenu
    val contenu: List<Pomme>
        get() = _contenu.toList()

    fun ajouter(pomme: Pomme) {
        this._contenu.add(pomme)
    }

    operator fun plus(other: Panier): Panier {
        val panierFinal = Panier()

        panierFinal._contenu.addAll(this.contenu)
        this._contenu.clear()

        panierFinal._contenu.addAll(other.contenu)
        other._contenu.clear()

        return panierFinal
    }

}