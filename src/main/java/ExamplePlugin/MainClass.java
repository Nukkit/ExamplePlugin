package ExamplePlugin;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

import java.io.IOException;

/**
 * author: MagicDroidX
 * NukkitExamplePlugin Project
 */
public class MainClass extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "I've been loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "I've been enabled!");
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getServer().getScheduler().scheduleReaptingTask(new BroadcastPluginTask(this), 200);
        this.saveResource("string.txt");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "I've been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "example":
                try {
                    this.getLogger().info(Utils.readFile(this.getResource("string.txt")) + " " + sender.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return true;
    }

}
