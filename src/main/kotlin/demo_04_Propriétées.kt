fun main() {

    // Définition des proriétées d'une classe, en fonction du mot clef "var" ou "val"
    // cela défini automatiquement les getters et setters
    val b = Bouteille()
    println("Bouteille de ${b.capacite}L qui contient ${b.contenu}")

    b.contenu = "Coca"

    val m: Maison = Maison("Bleu", 4, 2, "Argile")
    println(m)
}

class Bouteille {
    // Propriété en lecture seul
    val capacite: Int = 1

    // Propriété en lecture et ecriture
    var contenu: String = "Eau"
}

class Maison {

    // Propriété avec le getter et le setter
    var couleur: String
    var nbGarage: Int

    // Propriété auto-calculer -> Définition du getter
    val possedeGarage: Boolean
        get() = nbGarage > 0

    // Propriété avec un setter
    var nbPiece:Int
        set(value) {
            if(value <= 0) throw Throwable("Maison sans piece ?")

            // Utilisation du mot clef "field" pour définir le contenu de la prorpiétée
            field = value

            // Attention, ne jamais utiliser le nom de la propriété dans les getters / setters
            // Si vous le faites, cela génére une boucle infini ! :(
        }

    // Propriété avec un setter privé
    // -> Permet d'utiliser le setter dans la classe, mais pas en dehors
    var terrain: String
        private set(value) {
            field = value.uppercase()
        }

    constructor(couleur: String, nbPiece: Int, nbGarage: Int = 0, terrain: String = "TERRE") {
        // Utilisation du constructeur secondaire, pour forcé l'utiliser des setters
        this.terrain = terrain
        this.couleur = couleur
        this.nbGarage = nbGarage
        this.nbPiece = nbPiece
    }

    // Note: l'Initialisation avec une valeur par default ne prend pas en compte le setter
}