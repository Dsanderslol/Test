package me.spyless.eiwarps.commands;

import me.spyless.eiwarps.EIWarps;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    private final EIWarps plugin;

    public WarpCommand(EIWarps plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length != 1) {
                p.sendMessage(plugin.prefix + "Usage: /warp <name>");
            } else {
                if (!(plugin.getConfig().contains(args[0]))) {
                    p.sendMessage(plugin.prefix + "You don't know how to type.");
                } else {
                    p.teleport((Location) plugin.getConfig().get(args[0] + ".location"));
                    p.sendMessage(plugin.prefix + "Warped to " + args[0]);
                }
            }
        }
        return false;
    }
}
