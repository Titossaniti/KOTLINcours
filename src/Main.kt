import kotlin.system.exitProcess

val courseList: MutableMap<String,Int> = mutableMapOf();
val cartList: MutableMap<String,Int> = mutableMapOf();
val relai: List<String> = mutableListOf();

//fun relaiList(): MutableMap<String, Int>{
//    for ((item, quantity) in relai) {
//        println("$item : $quantity")
//    }
//    return relai;
//}

fun cartList(): MutableMap<String, Int> {
    if (cartList.isEmpty()) {
        println("Le caddie de course est vide")
    } else {
        println("Voici le contenu du caddie :")
        for ((item, quantity) in cartList) {
            println("$item : $quantity")
        }
    }
    return cartList
}

fun listCourse(): MutableMap<String, Int> {
    if (courseList.isEmpty()) {
        println("La liste de course est vide")
    } else {
        println("Voici la liste de courses :")
        for ((item, quantity) in courseList) {
            println("$item : $quantity")
        }
    }
    return courseList
}

fun addToList(){
    listCourse();
    println("Indiquez le produit à ajouter :")
    val item = readln();
    println("Indiquez la quantité à ajouter")
    val value = readln().toInt();
    courseList[item] = value;
    listCourse();
}

//fun addToCart(){
//    println("Quel produit voulez vous ajouter au caddie ? \n")
////    listCourse();
////    readln();
//
//    val itemCart = readln()
//    println("Combien en ajoutez vous ? \n")
//    val qtt: Int = readln().toInt();
//    for (item in courseList) {
//        if() {} {
//            println("Ajout dans le caddie")
//            relai[itemCart] = cartList.getOrDefault(itemCart, 0)
//            courseList.remove(itemCart)
//            cartList[itemCart] = qtt;
//        }
//    }
//    print("Contenu de la liste de course : ")
//    listCourse();
//    print("Contenu du Caddie : ")
//    cartList();
//
//}

fun removeFromCart(){
    println("Quel produit voulez vous retirer du caddie ? \n");
    cartList();
}

fun removeFromList(){
    listCourse();
    println("Indiquez le nom du produit que vous voulez retirer");
    val item = readln();
    courseList.remove(item);
    listCourse();
}
fun menu(){
    println("1 - Afficher la liste de course \n" +
            "2 - Ajouter un produit à la liste \n" +
            "3 - Retirer un produit de la liste \n" +
            "4 - Afficher le caddie \n" +
            "5 - Ajouter un produit au caddie \n" +
            "6 - Retirer un produit du caddie \n" +
            "9 - Ajouter un produit à la liste");
}
fun main() {

    do {
        menu();
        val choice = readln();

        when (choice) {
            "1" -> {
                listCourse();
            }

            "2" -> {
                addToList();
                listCourse();
            }
            "3" -> {
                removeFromList();
                listCourse();
            }
            "4" -> {
                cartList();
            }
            "9" -> {
                exitProcess(1);
            }
        }
    } while (choice != "");

}