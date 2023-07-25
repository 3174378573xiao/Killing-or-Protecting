class Player() {
    private var name : String = ""
    private var cgj : Double = 10.0
    private var cfy : Double = 1.0
    private var san : Double = 100.0
    private var cbj : Double = 10.0
    var bag : MutableList<Equip>? = mutableListOf(sz)
    private var wq : Equip? = null
    private var tk : Equip? = null
    private var xj : Equip? = null
    private var ht : Equip? = null
    private var sp : Equip? = null

    init {
        do {
            print("请输入玩家名称:")
            name = readln()
            if (name == "") println("玩家名称不能为空")
        } while (name == "")
    }

    var cmd : Cmd = Cmd(this)
    fun showvlue() {
        println("玩家信息:")
        println("属性  \t值")
        println("名字:\t${name}")
        println("攻击:\t${cgj}")
        println("防御:\t${cfy}")
        println("san值:\t${san}")
        println("暴击:\t${cbj}%")
        println("武器:\t${wq?.showString() ?: "无"}")
        println("头盔:\t${tk?.showString() ?: "无"}")
        println("胸甲:\t${xj?.showString() ?: "无"}")
        println("护腿:\t${ht?.showString() ?: "无"}")
        println("饰品:\t${sp?.showString() ?: "无"}")
        println("---------------------------------")
        println("背包:")
        if (bag == null) println("空")
        else {
            for (eq in bag!!) {
                println(eq.showString())
            }
        }

    }

    fun use(eq : Equip) {
        when (eq.type) {
            Types.wq -> {
                wq = if (wq != null) {
                    add(wq!! , '-')
                    add(eq , '+')
                    bag?.add(wq!!)
                    eq
                } else {
                    add(eq , '+')
                    bag?.remove(eq)
                    eq
                }
            }

            Types.tk -> {
                tk = if (tk != null) {
                    add(tk!! , '-')
                    add(eq , '+')
                    bag?.add(tk!!)
                    eq
                } else {
                    add(eq , '+')
                    bag?.remove(eq)
                    eq
                }
            }

            Types.xj -> {
                xj = if (xj != null) {
                    add(xj!! , '-')
                    add(eq , '+')
                    bag?.add(xj!!)
                    eq
                } else {
                    add(eq , '+')
                    bag?.remove(eq)
                    eq
                }
            }

            Types.ht -> {
                ht = if (ht != null) {
                    add(ht!! , '-')
                    add(eq , '+')
                    bag?.add(ht!!)
                    eq
                } else {
                    add(eq , '+')
                    bag?.remove(eq)
                    eq
                }
            }

            Types.sp -> {
                sp = if (sp != null) {
                    add(sp!! , '-')
                    add(eq , '+')
                    bag?.add(sp!!)
                    eq
                } else {
                    add(eq , '+')
                    bag?.remove(eq)
                    eq
                }
            }
        }
        println("成功装备${eq.name}")
    }

    fun addEq(eq : Equip) {
        bag?.add(eq)
    }

    fun add(eq : Equip , char : Char) {
        when (char) {
            '-' -> {
                cgj -= eq.addgj
                cfy -= eq.addfy
                san -= eq.addsan
                cbj -= eq.addbj
            }

            '+' -> {
                cgj += eq.addgj
                cfy += eq.addfy
                san += eq.addsan
                cbj += eq.addbj
            }
        }
    }
}