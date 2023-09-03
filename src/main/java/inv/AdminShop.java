package inv;

import ch.powercraft.ranks.Ranks;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


//import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.*;

public class AdminShop implements CommandExecutor {

    public static Inventory inventory = Bukkit.createInventory(null, 9*3, "§x§4§b§f§b§0§4§lP§x§4§4§e§9§0§4§lo§x§3§e§d§7§0§4§lw§x§3§7§c§5§0§5§le§x§3§0§b§3§0§5§lr§x§2§a§a§1§0§5§lC§x§2§3§8§f§0§5§lr§x§1§c§7§d§0§6§la§x§1§6§6§b§0§6§lf§x§0§f§5§9§0§6§lt§r §x§8§4§8§8§8§7§l|§r §9§lRange Kaufen");
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;

        String name = commandSender.getName();
        Player player = Bukkit.getPlayer(name);
        LuckPerms lp = Ranks.getLuck();

        // obtain CachedMetaData - the easiest way is via the PlayerAdapter
        // of course, you can get it via a User too if the player is offline.
        CachedMetaData metaData = lp.getPlayerAdapter(Player.class).getMetaData(player);

        // query & parse the meta value
        Integer weight = metaData.getMetaValue("weight", Integer::parseInt).orElse(0);
        Bukkit.getLogger().info("your weight: " + weight.toString());

        if(weight >= 50) {
            inventory.setItem(10, new ItemBuilder(Material.BEDROCK).setDisplayname("§x§1§a§5§2§f§b§lE§x§5§3§3§7§f§c§lP§x§8§b§1§b§f§e§lI§x§c§4§0§0§f§f§lC").setLore(ChatColor.YELLOW.BOLD + "Du hast es bereits gekauft" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());

        } else {
            inventory.setItem(10, new ItemBuilder(Material.STONE_SWORD).setDisplayname("§x§1§a§5§2§f§b§lE§x§5§3§3§7§f§c§lP§x§8§b§1§b§f§e§lI§x§c§4§0§0§f§f§lC").setLore(ChatColor.YELLOW.BOLD + "Es Kostet 500k" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());
        }
        if(weight >= 60) {
            inventory.setItem(12, new ItemBuilder(Material.BEDROCK).setDisplayname("§x§f§b§e§b§1§8§lT§x§f§c§b§5§1§5§lI§x§f§d§7§f§1§1§lT§x§f§e§4§8§0§e§lA§x§f§f§1§2§0§a§lN").setLore(ChatColor.YELLOW.BOLD + "Du hast es bereits gekauft" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());
        } else {
            inventory.setItem(12 , new ItemBuilder(Material.TRIDENT).setDisplayname("§x§f§b§e§b§1§8§lT§x§f§c§b§5§1§5§lI§x§f§d§7§f§1§1§lT§x§f§e§4§8§0§e§lA§x§f§f§1§2§0§a§lN").setLore(ChatColor.YELLOW.BOLD + "Es Kostet 1M" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());
        }
        if(weight >= 150) {
            inventory.setItem(14, new ItemBuilder(Material.BEDROCK).setDisplayname("§x§1§9§9§3§0§0§lL§x§3§6§7§b§2§b§lE§x§5§2§6§2§5§5§lG§x§6§f§4§a§8§0§lE§x§8§b§3§1§a§a§lN§x§a§8§1§9§d§5§lD§x§c§4§0§0§f§f§lE").setLore(ChatColor.YELLOW.BOLD + "Du hast es bereits gekauft" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());
        } else {
            inventory.setItem(14 , new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE).setDisplayname("§x§1§9§9§3§0§0§lL§x§3§6§7§b§2§b§lE§x§5§2§6§2§5§5§lG§x§6§f§4§a§8§0§lE§x§8§b§3§1§a§a§lN§x§a§8§1§9§d§5§lD§x§c§4§0§0§f§f§lE").setLore(ChatColor.YELLOW.BOLD + "Es Kostet 1,5M" + ChatColor.WHITE + "\nCklicke Rechts cklick um Legende rang zu kaufen").build());
        }
        if(weight >= 190) {
            inventory.setItem(16, new ItemBuilder(Material.BEDROCK).setDisplayname("§x§f§f§f§f§f§f§lG§x§f§f§f§1§8§e§lO§x§f§f§e§2§1§c§lD").setLore(ChatColor.YELLOW.BOLD + "Du hast es bereits gekauft" + ChatColor.WHITE + "\nCklicke Rechts cklick um Titan rang zu kaufen").build());
        } else {
            inventory.setItem(16 , new ItemBuilder(Material.TOTEM_OF_UNDYING).setDisplayname("§x§f§f§f§f§f§f§lG§x§f§f§f§1§8§e§lO§x§f§f§e§2§1§c§lD").setLore(ChatColor.YELLOW.BOLD + "Es Kostet 2M" + ChatColor.WHITE + "\nCklicke Rechts cklick um GOD rang zu kaufen").build());
        }


        player.openInventory(inventory);

        return true;
    }
}