package me.spyless.eiwarps.commands;

import me.spyless.eiwarps.EIWarps;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpsCommand implements CommandExecutor {

    private final EIWarps plugin;

    public WarpsCommand(EIWarps plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            p.sendMessage(plugin.prefix + "All of your warps are listed below:");
            for (String str : plugin.getConfig().getKeys(false)) {
                p.sendMessage(str);
            }
        }
        return false;
    }
}
