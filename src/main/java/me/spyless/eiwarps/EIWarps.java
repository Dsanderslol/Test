package me.spyless.eiwarps;

import me.spyless.eiwarps.commands.DelWarpCommand;
import me.spyless.eiwarps.commands.SetWarpCommand;
import me.spyless.eiwarps.commands.WarpCommand;
import me.spyless.eiwarps.commands.WarpsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class EIWarps extends JavaPlugin {

    public String prefix = "[EIWarps] ";

    @Override
    public void onEnable() {
        customConfig();

        getCommand("setwarp").setExecutor(new SetWarpCommand(this));
        getCommand("warp").setExecutor(new WarpCommand(this));
        getCommand("warps").setExecutor(new WarpsCommand(this));
        getCommand("delwarp").setExecutor(new DelWarpCommand(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void customConfig() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
