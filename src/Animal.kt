open class Animal(val nom: String, val cri: String) {


    fun crier() {
        println("$nom fait $cri");
    }
}

class Chien(nom: String) : Animal(nom, "waf waf");
class Chat(nom: String) : Animal(nom, "Miaou");

fun main() {
    val dog = Chien("Bernard");
    dog.crier();

    val cat = Chat("Grizzi");
    cat.crier()
}