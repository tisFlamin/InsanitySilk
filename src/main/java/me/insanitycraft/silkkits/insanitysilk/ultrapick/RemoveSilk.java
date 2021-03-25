package me.insanitycraft.silkkits.insanitysilk.ultrapick;

import me.insanitycraft.silkkits.insanitysilk.InsanitySilk;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import sun.security.krb5.Config;

import java.lang.reflect.Array;

public class RemoveSilk implements CommandExecutor {
    Plugin plugin = InsanitySilk.getPlugin(InsanitySilk.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String requiredperms = plugin.getConfig().getStringList("RequiredPermission").get(0);
        ItemStack hand = player.getItemInHand();
        if(player.hasPermission(requiredperms)){
            if(player.getItemInHand().getItemMeta().getLore() == null){
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must hold an ultra pickaxe in your hand for this command!");
            }else if(String.valueOf(hand).contains("Netherite Ultra Pick")){
                player.getItemInHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 30);
                player.getItemInHand().removeEnchantment(Enchantment.SILK_TOUCH);
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Success! You have removed the silk touch enchant from your Ultra Pickaxe.");
            }
        }else if(!player.hasPermission("reclaim.allow.upick")){
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You require an ultra pickaxe for this command!");
        }else if(player.getItemInHand().getItemMeta().equals(null)){
            player.sendMessage("You require an ultra pickaxe in your hand for this command!");
        }else if(player.getItemInHand().getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)){
            if(player.getItemInHand().getItemMeta().getLore().contains("Netherite Ultra Pick")){
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You already have fortune on this pickaxe!");
            }

        }else{
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You require an ultra pickaxe in your hand for this command!" );
        }


        return true;

    }
}
