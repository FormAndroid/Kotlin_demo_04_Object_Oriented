fun main(args: Array<String>) {
    // En Kotlin, il est possible de créer plusieurs classes dans un seul fichier

    // Les classes sont le plan pour créer un objet
    //  - Mot clef "class"
    //  - Le corp de la classe en accolade (optionnel)

    // L'encapsulation se réaliser à l'aide de propriété
    //  - Appel "caché" à la méthode "get" ou "set" en fonction du context d'utilisation

    // Possibilité de créer le constructeur "primaire"
    //  - Celui-ci s'ecrit lors de la déclaration de la classe
    //  - Permet de définir les propriétées de la classe
    //      - Avec "val" => Propriétée en lecture seul (Getter uniquement)
    //      - Avec "var" => Propriétée modifiable (Getter et Setter)
    //  - Pas de code necessaire pour l'affection (Fait pour nous, par le langage)
    //  - Par défaut les propriétées sont public, sauf si elle sont précédé de "private"

    val p = Person("zaza", "Vanderquack")

    // Utilisation des getters
    println("Ma personne -> ${p.firstname} ${p.lastname}")

    // Utilisation des setters
    p.firstname = "Zaza"
}

class Person(var firstname:String, var lastname: String)