fun main() {

    // Le constructeur primaire ne pouvant pas contenir de logique de code
    // Il est possible de créer une bloc d'initialisation via le mot clef "init"

    // Il est possible d'ajouter plusieur bloc "init", ceux-ci seront executer
    // dans l'ordre de déclaration des elemennts
    // Attention : ils n'ont acces qu'aux propriétés déclaré avant eux !

    val d: DemoInit = DemoInit("John", 42)
}

class DemoInit(name: String, val number: Int) {

    init {
        println("Utilisation du 1er init")
        println("La valeur de \"number\" est $number\n")
        // N'a pas acces à la propriété "name"
    }

    var name: String? = "Default".also { println("Delcaration et initialisation de la propriété \"Name\"\n") }
        set(value) {
            println("Déclanchement du setter de la propriété \"name\"")
            field = value?.uppercase()
        }

    init {
        println("Utilisation du 2e init")
        println("La valeur de \"name\" est ${this.name}")
        this.name = name
        println("La valeur de \"name\" est ${this.name}\n")
    }
}




/*
class EquivalentJavaDemoInit {

	private int number;
	private String name;

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value
	}

	constructor(String name, int number) {
		this.number = number
		this.setName(name);
	}
}
*/