package me.spyless.eiwarps.commands;

import me.spyless.eiwarps.EIWarps;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelWarpCommand implements CommandExecutor {

    private final EIWarps plugin;

    public DelWarpCommand(EIWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length != 1) {
                p.sendMessage(plugin.prefix + "Usage: /delwarp <name>");
            } else {
                if (!(plugin.getConfig().contains(args[0]))) {
                    plugin.getConfig().set(args[0], null);
                    plugin.saveConfig();
                    p.sendMessage(plugin.prefix + "Warp " + args[0] + " successfully deleted.");
                } else {
                    p.sendMessage(plugin.prefix + "The warp " + args[0] + " doesn't exists.");
                }
            }
        }
        return false;
    }
}
