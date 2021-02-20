package me.arasple.mc.trmenu.module.internal.migrate

import com.extendedclip.deluxemenus.menu.Menu
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.inventory.InventoryType

/**
 * @author Arasp
 * @date 2021/2/20 19:07
 */
class MigrateDeluxeMenus : Migrate("DeluxeMenus") {

    override fun migrate() {
        Menu.getAllMenus().forEach {
            val name = it.menuName
            val defUpdate = it.updateInterval
            YamlConfiguration().run {

                if (it.inventoryType != InventoryType.CHEST) {
                    set("Type", it.name)
                }
                if (it.menuCommands.isNotEmpty()) {
                    set("Bindings.Commands", it.menuCommands)
                }
                it.openHandler
                set("Title", it.menuTitle)
                set("Size", it.size)
                set("Icons", it.menuItems)

                it.menuItems
                it.openHandler
                it.closeHandler
                it.registersCommand()
            }
        }
    }

}