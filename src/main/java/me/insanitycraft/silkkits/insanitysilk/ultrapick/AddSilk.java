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

import java.lang.reflect.Array;
import java.util.List;

public class AddSilk implements CommandExecutor {
    Plugin plugin = InsanitySilk.getPlugin(InsanitySilk.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String prefix = ChatColor.AQUA + "" + ChatColor.BOLD + "InsanitySilk" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " »";
        ItemStack hand = player.getItemInHand();
        if (String.valueOf(hand).contains("Netherite Ultra Pick")){
            if(String.valueOf(player.getItemInHand().getItemMeta().getDisplayName()).contains("Netherite Ultra Pick")){
                player.sendMessage(prefix + ChatColor.RED + "" + ChatColor.BOLD + "You must re-name your Ultra Pickaxe to something else!");
            }else{
                player.getItemInHand().addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
                hand.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }else if(player.getItemInHand().equals(Material.AIR)){
            player.sendMessage(prefix + ChatColor.RED + "" + ChatColor.BOLD + "You must have an ultra pickaxe in your hand for this command!");
        }else{
            return true;
        }
        return true;
    }
}

