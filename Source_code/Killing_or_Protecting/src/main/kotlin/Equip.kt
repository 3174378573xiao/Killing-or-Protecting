class Equip(
    val name : String ,
    val type : Types ,
    val addgj : Double ,
    val addfy : Double ,
    val addsan : Double ,
    val addbj : Double ,
) {
    fun showString() : String {
        var a = "$name ${type.str} "
        if (reValue(addgj) != "") a += "${reValue(addgj)}攻击 "
        if (reValue(addfy) != "") a += "${reValue(addfy)}防御 "
        if (reValue(addsan) != "") a += "${reValue(addsan)}san值 "
        if (reValue(addbj) != "") a += "${reValue(addbj)}%暴击 "
        return a
    }

    private fun reValue(value : Double) : String {
        if (value > 0) return "+${value}"
        else if (value < 0) return "-${value}"
        else return ""
    }
}

enum class Types(str : String) {
    wq("武器") ,   //武器
    tk("头盔") ,   //头盔
    xj("胸甲") ,   //胸甲
    ht("护甲") ,   //护甲
    sp("饰品");   //饰品
    val str = str
}

val sz : Equip = Equip("树枝" , Types.wq , 5.0 , 1.0 , 0.0,0.0)