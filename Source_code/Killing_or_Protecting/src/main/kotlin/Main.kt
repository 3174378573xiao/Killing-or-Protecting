fun main() {
    println("Running!")
    val me = Player("ovo")
    me.showstring()
    do {
        print(">>>")
    } while (me.cmd.gameInput(readln()))
    readln()
}