class Player(
    private var name : String = "myName",
    private var cgj : Double = 10.0,
    private var cfy : Double = 1.0,
    private var san : Double = 100.0
) {
    public var cmd : Cmd = Cmd()
    public fun showstring() {
        println("key  \tvalue")
        println("name:\t${name}")
        println("cgf:\t${cgj}")
        println("cfy:\t${cfy}")
        println("san:\t${san}")
    }
}