fun main() {

    // Définition des proriétées d'une classe, en fonction du mot clef "var" ou "val"
    // cela défini automatiquement les getters et setters
    val b = Bouteille()
    println("Bouteille de ${b.capacite}L qui contient ${b.contenu}")

    b.contenu = "Coca"

    val m: Maison = Maison("Bleu", 6, 2, "Argile")
}

class Bouteille {
    // Propriété en lecture seul
    val capacite: Int = 1

    // Propriété en lecture et ecriture
    var contenu: String = "Eau"
}

class Maison(var couleur: String, nbPiece: Int, var nbGarage: Int = 0, terrain: String = "TERRE") {

    // Propriété auto-calculer -> Définition du getter
    val possedeGarage: Boolean
        get() = nbGarage > 0

    // Propriété avec un setter
    var nbPiece:Int = nbPiece      // Initialisation avec la variable "nbPiece" du constructeur primaire
        set(value) {
            if(value <= 0) throw Throwable("Maison sans piece ?")

            // Utilisation du mot clef "field" pour définir le contenu de la prorpiétée
            field = value

            // Attention, ne jamais utiliser le nom de la propriété dans les getters / setters
            // Si vous le faites, cela génére une boucle infini ! :(
        }

    // Propriété avec un setter privé
    // -> Permet d'utiliser le setter dans la classe, mais pas en dehors
    var terrain: String = terrain
        private set(value) {
            field = value.uppercase()
        }
}