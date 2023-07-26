class Equip(
    val name : String ,
    val cmdname : String ,
    val type : Types ,
    val addgj : Double ,
    val addfy : Double ,
    val addsan : Double ,
    val addbj : Double ,
) {
    fun showString() : String {
        var a = "$name(使用指令:${cmdname}) ${type.str} "
        if (reValue(addgj) != "") a += "${reValue(addgj)}攻击 "
        if (reValue(addfy) != "") a += "${reValue(addfy)}防御 "
        if (reValue(addsan) != "") a += "${reValue(addsan)}san值 "
        if (reValue(addbj) != "") a += "${reValue(addbj)}%暴击 "
        return a
    }

    private fun reValue(value : Double) : String {
        return if (value > 0) "+${value}"
        else if (value < 0) "-${value}"
        else ""
    }
}

enum class Types(val str : String) {
    WQ("武器") ,   //武器
    TK("头盔") ,   //头盔
    XJ("胸甲") ,   //胸甲
    HT("护甲") ,   //护甲
    SP("饰品");   //饰品
}

val pbs : Equip = Equip("破匕首" , "pbs" , Types.WQ , 5.0 , 1.0 , 0.0 , 5.0)
val phd : Equip = Equip("破护盾" , "phd" , Types.WQ , 1.0 , 5.0 , 10.0 , 0.0)