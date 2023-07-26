class Player {
    private var name : String = ""
    private var cgj : Double = 10.0
    private var cfy : Double = 1.0
    private var san : Double = 100.0
    private var cbj : Double = 10.0
    private var bag : MutableList<Equip> = mutableListOf(pbs , phd)
    private var wq : Equip = Equip("无" , "kwq" , Types.WQ , 0.0 , 0.0 , 0.0 , 0.0)
    private var tk : Equip = Equip("无" , "ktk" , Types.TK , 0.0 , 0.0 , 0.0 , 0.0)
    private var xj : Equip = Equip("无" , "kxj" , Types.XJ , 0.0 , 0.0 , 0.0 , 0.0)
    private var ht : Equip = Equip("无" , "kht" , Types.HT , 0.0 , 0.0 , 0.0 , 0.0)
    private var sp : Equip = Equip("无" , "ksp" , Types.SP , 0.0 , 0.0 , 0.0 , 0.0)

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
        println("武器:\t${wq.showString()}")
        println("头盔:\t${tk.showString()}")
        println("胸甲:\t${xj.showString()}")
        println("护腿:\t${ht.showString()}")
        println("饰品:\t${sp.showString()}")
        println("---------------------------------")
        println("背包:")
        for (eq in bag) {
            println(eq.showString())
        }


    }

    fun use(cmdArgs : List<String>) {
        val fdeq = cmdArgs.getOrElse(1) { "" }
        var outsideEq = Equip("use_test_ling" , "" , Types.WQ , 0.0 , 0.0 , 0.0 , 0.0)

        for (eq in bag) {
            if (eq.name == fdeq || eq.cmdname == fdeq) { //
                outsideEq = eq
            }
        }
        if (outsideEq.name != "use_test_ling") {
            when (outsideEq.type) {
                Types.WQ -> {
                    add(wq , '-')
                    add(outsideEq , '+')
                    bag.add(wq)
                    wq = outsideEq
                }

                Types.TK -> {
                    add(tk , '-')
                    add(outsideEq , '+')
                    bag.add(tk)
                    tk = outsideEq
                }

                Types.XJ -> {
                    add(xj , '-')
                    add(outsideEq , '+')
                    bag.add(xj)
                    xj = outsideEq
                }

                Types.HT -> {
                    add(ht , '-')
                    add(outsideEq , '+')
                    bag.add(ht)
                    ht = outsideEq
                }

                Types.SP -> {
                    add(sp , '-')
                    add(outsideEq , '+')
                    bag.add(sp)
                    sp = outsideEq
                }
            }
            bag.remove(outsideEq) //因为迭代时不能remove所以放到后面
            println("成功装备${outsideEq.name}")
        } else {
            println("在背包中找不到${fdeq}")
        }
    }


    fun addEq(eq : Equip) {
        bag.add(eq)
    }

    private fun add(eq : Equip , char : Char) {
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