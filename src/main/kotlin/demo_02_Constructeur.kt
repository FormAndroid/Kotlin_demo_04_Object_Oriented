fun main() {
    // Création de l'objet "s" qui est une instance de la classe "Student"
    val s: Student = Student("Donald", "Duck")
    println("Etudiant : ${s.firstname} ${s.lastname}")
}

// Utilisation du mot clef "constructor" pour définir un constructeur dans le corp de la classe.
class Student {
    var firstname: String
    var lastname: String

    constructor(firstname: String, lastname: String) {
        this.firstname = firstname
        this.lastname = lastname.lowercase()
    }

    // Création d'une méthode
    fun sayHello() {
        println("$firstname $lastname vous dit bonjour !")
    }
}

// Alternative via le constructeur primaire (avec des variables) et l'initialisation des propriétées
class Teacher(firstname: String, lastname: String) {
    var firstname = firstname
    var lastname = lastname.uppercase()

    // Création d'une méthode
    fun sayHello() {
        println("$firstname $lastname vous dit bonjour !")
    }
}