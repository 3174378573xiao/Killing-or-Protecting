import java.util.*

class Cmd {
    private var cmd : String = ""
    private fun setCmd(cmd : String) {
        this.cmd = cmd
    }

    private fun doCmd() : Boolean {
        cmd.lowercase(Locale.getDefault())
        val topCmd : String = cmd.split(" ")[0]
        val cmdArgs : List<String> = cmd.split(" ")
        when (topCmd) {
            "test" -> {
                println("This is a test!")
                var i = 1
                if (cmdArgs.isNotEmpty()) {
                    println("Args:")
                    for (arg in cmdArgs) {
                        if (arg != topCmd) {
                            println("${i}:\t $arg")
                            i++
                        }
                    }
                } else {
                    println("This order do not have args.")
                }
            }

            "exit" -> {
                println("Exit successfully!")
                return false
            }
            "help" ->{
                println("\"help\" for help.")
                println("\"exit\" for exiting.")
                println("\"test\" for test and show the args.format: test [arg]...")
            }

            else -> {
                println("Cannot find order as \"${topCmd}\"")
            }
        }
        return true
    }

    fun gameInput(cmd : String) : Boolean {
        setCmd(cmd)
        return doCmd()
    }
}