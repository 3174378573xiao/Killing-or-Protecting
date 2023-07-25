fun main() {
    println("running!")
    val me = Player()
    me.showvlue()
    do {
        print(">>>")
    } while (me.cmd.gameInput(readln()))
    readln()
}