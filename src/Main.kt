import kotlin.system.exitProcess

val courseList: MutableMap<String, Int> = mutableMapOf()
val cartList: MutableList<String> = mutableListOf()
val relai: MutableMap<String, Int> = mutableMapOf()

// Fonction pour afficher la liste des produits dans le relai avec leur quantité
fun relaiList(): MutableMap<String, Int> {
    if (relai.isEmpty()) {
        println("Le relai est vide")
    } else {
        println("Voici le contenu du relai :")
        for ((item, quantity) in relai) {
            println("$item : $quantity")
        }
    }
    return relai
}

// Fonction pour afficher le contenu du caddie (seulement les noms des produits)
fun cartList(): MutableList<String> {
    if (cartList.isEmpty()) {
        println("Le caddie de course est vide")
    } else {
        println("Voici le contenu du caddie :")
        for (item in cartList) {
            println(item)
        }
    }
    return cartList
}

// Fonction pour afficher la liste de courses
fun listCourse(): MutableMap<String, Int> {
    if (courseList.isEmpty()) {
        println("La liste de courses est vide")
    } else {
        println("Voici la liste de courses :")
        for ((item, quantity) in courseList) {
            println("$item : $quantity")
        }
    }
    return courseList
}

// Fonction pour ajouter un produit à la liste de courses
fun addToList() {
    println("Indiquez le produit à ajouter :")
    val item = readln()
    println("Indiquez la quantité à ajouter :")
    val value = readln().toInt()
    courseList[item] = courseList.getOrDefault(item, 0) + value
    listCourse()
}

// Fonction pour ajouter un produit au caddie
fun addToCart() {
    println("Quel produit voulez-vous ajouter au caddie ?")
    listCourse()

    val itemCart = readln()
    if (courseList.containsKey(itemCart)) {
        val availableQty = courseList[itemCart] ?: 0

        // Ajouter le produit dans le caddie et stocker la quantité dans le relai
        cartList.add(itemCart)
        relai[itemCart] = availableQty

        // Retirer le produit de la liste de courses
        courseList.remove(itemCart)

        println("Ajouté au caddie.")
    } else {
        println("Ce produit n'existe pas dans la liste de courses.")
    }

    println("Contenu de la liste de courses :")
    listCourse()
    println("Contenu du caddie :")
    cartList()
}

// Fonction pour retirer un produit du caddie et le remettre dans la liste de courses
fun removeFromCart() {
    println("Quel produit voulez-vous retirer du caddie ?")
    cartList()

    val item = readln()
    if (cartList.contains(item)) {
        // Remettre la quantité du relai dans la liste de courses
        val quantity = relai[item] ?: 0
        courseList[item] = courseList.getOrDefault(item, 0) + quantity

        // Retirer le produit du caddie et du relai
        cartList.remove(item)
        relai.remove(item)

        println("Produit retiré du caddie et remis dans la liste de courses.")
    } else {
        println("Ce produit n'est pas dans le caddie.")
    }

    println("Contenu de la liste de courses :")
    listCourse()
    println("Contenu du caddie :")
    cartList()
}

// Fonction pour retirer un produit de la liste de courses
fun removeFromList() {
    listCourse()
    println("Indiquez le nom du produit que vous voulez retirer :")
    val item = readln()
    courseList.remove(item)
    listCourse()
}

fun menu() {
    println(
        """
        1 - Afficher la liste de courses
        2 - Ajouter un produit à la liste
        3 - Retirer un produit de la liste
        4 - Afficher le caddie
        5 - Ajouter un produit au caddie
        6 - Retirer un produit du caddie
        9 - Quitter
        """.trimIndent()
    )
}

fun main() {

    do {
        menu()
        val choice = readln()

        when (choice) {
            "1" -> listCourse()
            "2" -> addToList()
            "3" -> removeFromList()
            "4" -> cartList()
            "5" -> addToCart()
            "6" -> removeFromCart()
            "9" -> exitProcess(1)
        }
    } while (choice != "")
}
