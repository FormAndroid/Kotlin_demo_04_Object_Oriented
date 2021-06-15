fun main() {

    // Il est possible d'utiliser d'un propriété privé en tant que valeur d'un propriété

    // Exemple avec une liste qu'on souhaite initialiser uniquement si on l'utilise
    val d: DemoBackingProp = DemoBackingProp()
    // -> Le dataSet est null

    d.dataSet.joinToString()
    // -> Le dataSet est initialiser
}


class DemoBackingProp {

    private var _dataSet: MutableList<Int>? = null

    val dataSet: MutableList<Int>
        get() {
            if(this._dataSet == null) {
                this._dataSet = mutableListOf()
            }

            return this._dataSet ?: throw Throwable("Error with DataSet")
        }

    // Cela permet egalement d'utiliser la propriété privé dans la classe et non la propriété publique.
    // Ce qui permet d'evité d'utiliser les getters et setters
}