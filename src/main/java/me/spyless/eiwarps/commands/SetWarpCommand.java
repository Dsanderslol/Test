package me.spyless.eiwarps.commands;

import me.spyless.eiwarps.EIWarps;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {

    private final EIWarps plugin;

    public SetWarpCommand(EIWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length != 1) {
                p.sendMessage(plugin.prefix + "Usage: /setwarp <name>");
            } else {
                if (!(plugin.getConfig().contains(args[0]))) {
                    plugin.getConfig().set(args[0] + ".location", p.getLocation());
                    plugin.saveConfig();
                    p.sendMessage(plugin.prefix + "Warp " + args[0] + " successfully set.");
                } else {
                    p.sendMessage(plugin.prefix + "The warp " + args[0] + " already exists.");
                }
            }
        }
        return false;
    }
}
