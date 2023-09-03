package inv;
import ch.powercraft.ranks.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;




public class InventoryListener implements Listener {

    private String prefix = "§x§4§b§f§b§0§4§lP§x§4§4§e§9§0§4§lo§x§3§e§d§7§0§4§lw§x§3§7§c§5§0§5§le§x§3§0§b§3§0§5§lr§x§2§a§a§1§0§5§lC§x§2§3§8§f§0§5§lr§x§1§c§7§d§0§6§la§x§1§6§6§b§0§6§lf§x§0§f§5§9§0§6§lt§r §x§8§4§8§8§8§7§l|§r ";

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        if (e.getInventory().equals(AdminShop.inventory)) {
            Bukkit.getLogger().info("inventory click event!");
            e.setCancelled(true);

            final ItemStack clickedItem = e.getCurrentItem();

            // verify current item is not null
            if (clickedItem == null || clickedItem.getType().isAir()) return;
            final Player p = (Player) e.getWhoClicked();

            if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
                // Using slots click is a best option for your inventory click's
                if (Ranks.getEconomy().has(p, 10000)) {
                    Ranks.getEconomy().withdrawPlayer(p, 10000);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "lp user " + p.getName() + " parent add epic");
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast jetzt Epic Rang. Viel Spass");
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendMessage("\n" +
                                prefix + " Der spieler " + p.getName() + " hat Epic gekauft" +
                                "\n");
                    });

                } else {
                    p.sendMessage(prefix + " Du hast nicht genug Geld");
                }
            }

            if (e.getCurrentItem().getType() == Material.TRIDENT) {
                // Using slots click is a best option for your inventory click's
                if (Ranks.getEconomy().has(p, 1000000)) {
                    Ranks.getEconomy().withdrawPlayer(p, 1000000);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "lp user " + p.getName() + " parent add titan");
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast jetzt TITAN Rang. Viel Spass");
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendMessage("\n" +
                                prefix + " Der spieler " + p.getName() + " hat Titan gekauft" +
                                "\n");
                    });
                } else {
                    p.sendMessage(prefix + " Du hast nicht genug Geld");
                }
            }

            if (e.getCurrentItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                // Using slots click is a best option for your inventory click's
                if (Ranks.getEconomy().has(p, 150000)) {
                    Ranks.getEconomy().withdrawPlayer(p, 150000);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "lp user " + p.getName() + " parent add legende");
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast jetzt LEGENDE Rang. Viel Spass");
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendMessage("\n" +
                                prefix + " Der spieler " + p.getName() + " hat LEGENDE gekauft" +
                                "\n");
                    });
                } else {
                    p.sendMessage(prefix + " Du hast nicht genug Geld");
                }
            }

            if (e.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
                // Using slots click is a best option for your inventory click's
                if (Ranks.getEconomy().has(p, 2000000)) {
                    Ranks.getEconomy().withdrawPlayer(p, 2000000);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "lp user " + p.getName() + " parent add god");
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast jetzt GOD Rang. Viel Spass");
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendMessage("\n" +
                                prefix + " Der spieler " + p.getName() + " hat GOD gekauft" +
                                "\n");
                    });
                } else {
                    p.sendMessage(prefix + " Du hast nicht genug Geld");
                }
            }
            if (e.getCurrentItem().getType() == Material.BEDROCK) {
                // Using slots click is a best option for your inventory click's
                p.sendMessage(prefix + " du hast es bereits gekauft!");
                p.sendMessage(prefix + " wenn du Hilfe brauchst dann erstelle doch ein Ticket auf discord.");
            }
        }
    }
}
