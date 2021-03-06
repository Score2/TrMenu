package me.arasple.mc.trmenu.module.internal.hook.impl

import me.arasple.mc.trmenu.module.internal.hook.HookAbstract
import me.scoretwo.fastscript.FastScript

/**
 * @author Score2
 * @date 2021/2/24 22:02
 */
class HookFastScript : HookAbstract() {

    val expansionManager get() = FastScript.instance.expansionManager

    fun getExpansionByNameOrSign(key: String) = expansionManager.getExpansionBySign(key) ?: expansionManager.getExpansionByName(key)

}