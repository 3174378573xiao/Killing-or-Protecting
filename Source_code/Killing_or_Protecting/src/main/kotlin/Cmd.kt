import java.util.*

class Cmd(private var me : Player) {

    private var cmd : String = ""
    private fun setCmd(cmd : String) {
        this.cmd = cmd
    }

    private fun doCmd() : Boolean {
        cmd.lowercase(Locale.getDefault())
        val topCmd : String = cmd.split(" ")[0]
        val cmdArgs : List<String> = cmd.split(" ")
        when (topCmd) {
            "test" -> text(topCmd , cmdArgs)
            "exit" -> return exit()
            "help" -> help()
            "show" -> show(cmdArgs)
            "use" -> use(cmdArgs)         //有bug
            else -> {
                println("找不到命令 \"${topCmd}\"")
            }
        }
        return true
    }

    private fun text(topCmd : String , cmdArgs : List<String>) {
        println("这是一个测试!")
        var i = 1
        if (cmdArgs.isNotEmpty()) {
            println("参数:")
            for (arg in cmdArgs) {
                if (arg != topCmd) {
                    println("${i}:\t $arg")
                    i++
                }
            }
        } else {
            println("此命令没有参数.")
        }
    }

    private fun exit() : Boolean {
        println("成功退出！")
        return false
    }

    private fun help() {
        println("\"help\" 查看帮助.")
        println("\"exit\" 退出.")
        println("\"test\" 用于测试和显示参数.format: test [arg]...")
    }

    private fun show(cmdArgs : List<String>) {
        when (cmdArgs.getOrElse(1) { "" }) {
            "player" -> me.showvlue()
            else -> {
                println("找不到ShowObject \"${cmdArgs.getOrElse(1) { "" }}\"")
                println("format : show |ShowObject| ")
                println("such as : show player")
            }
        }
    }

    private fun use(cmdArgs : List<String>) {
        me.use(cmdArgs)
    }

    fun gameInput(cmd : String) : Boolean {
        setCmd(cmd)
        return doCmd()
    }
}