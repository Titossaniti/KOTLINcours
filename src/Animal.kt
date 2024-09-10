open class Animal(val nom: String, val cri: String) {

    open fun faireCrier() {
        println("$nom fait $cri")
    }
}

class Chien(nom: String) : Animal(nom, "waf waf") {

    // On peut redéfinir la méthode si besoin, mais ici on utilise celle du parent
    override fun faireCrier() {
        super.faireCrier()
    }
}

class Chat(nom: String) : Animal(nom, "Miaou") {

    override fun faireCrier() {
        super.faireCrier()
    }
}

fun main() {
    val animaux: List<Animal> = listOf(Chien("Bernard"), Chat("Grizzy"))

    for (animal in animaux) {
        animal.faireCrier()
    }
}
