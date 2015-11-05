package ExamplePlugin;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.ServerCommandEvent;

/**
 * author: MagicDroidX
 * NukkitExamplePlugin Project
 */
public class EventListener implements Listener {
    MainClass plugin;

    public EventListener(MainClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false) //DON'T FORGET THE ANNOTATION @EventHandler
    public void onServerCommand(ServerCommandEvent event) {
        this.plugin.getLogger().info("ServerCommandEvent is called!");
        //you can do more here!
    }
}
