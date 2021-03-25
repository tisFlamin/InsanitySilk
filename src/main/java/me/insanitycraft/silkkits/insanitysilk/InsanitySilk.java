package me.insanitycraft.silkkits.insanitysilk;

import me.insanitycraft.silkkits.insanitysilk.ultrapick.AddSilk;
import me.insanitycraft.silkkits.insanitysilk.ultrapick.RemoveSilk;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.Configuration;


public final class InsanitySilk extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("addsilk").setExecutor(new AddSilk());
        getCommand("desilk").setExecutor(new RemoveSilk());
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
