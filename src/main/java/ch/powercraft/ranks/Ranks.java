package ch.powercraft.ranks;

import inv.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import net.luckperms.api.LuckPerms;
public final class Ranks extends JavaPlugin {
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    private static LuckPerms luckperms = null;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("onEnable is called!");
        // Plugin startup logic
        try {
            this.getCommand("adminshop").setExecutor(new inv.AdminShop());
            getServer().getPluginManager().registerEvents(new InventoryListener(), this);
            getLogger().info("command 'adminshop' was added.");

            if (!setupEconomy() ) {
                getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
                getServer().getPluginManager().disablePlugin(this);
                return;
            }
            setupPermissions();
            setupChat();


            RegisteredServiceProvider<LuckPerms> provider = getServer().getServicesManager().getRegistration(LuckPerms.class);
            if (provider != null) {
                luckperms = provider.getProvider();
            } else {
                getLogger().warning("could not get LuckPerms API.");
            }

        } catch(Exception e) {
            getLogger().warning("😖failed to add command 'invtest':");
            getLogger().warning(e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    // Vault functions for setup
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    public static LuckPerms getLuck() {
        return luckperms;
    }
}
