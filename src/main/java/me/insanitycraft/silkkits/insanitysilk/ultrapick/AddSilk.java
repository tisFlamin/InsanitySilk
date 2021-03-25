package me.insanitycraft.silkkits.insanitysilk.ultrapick;

import me.insanitycraft.silkkits.insanitysilk.InsanitySilk;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Array;
import java.util.List;

public class AddSilk implements CommandExecutor {
    Plugin plugin = InsanitySilk.getPlugin(InsanitySilk.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack hand = player.getItemInHand();
        String requiredperms = plugin.getConfig().getStringList("RequiredPermission").get(0);
        if(player.hasPermission(requiredperms)){
            if(player.getItemInHand().getItemMeta().getLore() == null){
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must hold an ultra pickaxe in your hand for this command!");
            }else if(String.valueOf(hand).contains("Netherite Ultra Pick")){
                player.getItemInHand().addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                player.getItemInHand().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Success! You have added the silk touch enchant from your Ultra Pickaxe. Do /desilk to undo this action!");
            }
        }else if(!player.hasPermission("reclaim.allow.upick")){
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You require an ultra pickaxe for this command!");
        }else if(player.getItemInHand().getItemMeta().equals(null)){
            player.sendMessage("You require an ultra pickaxe in your hand for this command!");
        }else{
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You require an ultra pickaxe in your hand for this command!" );
        }


        return true;
    }
}

