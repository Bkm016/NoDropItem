package vip.foxcraft.nodropitem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;



public class NoDropItem extends JavaPlugin implements Listener{

	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getConsoleSender().sendMessage("[NoDropItem] §a加载成功! 插件作者: §eSaukiya");
	}
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
        if(!label.equalsIgnoreCase("ndi"))return false;
        if((sender instanceof Player && !sender.hasPermission("ndi.admin"))){
                sender.sendMessage("NoPersmission");
                return true;
        }
        if(args.length==0){
        	sender.sendMessage("§3/ndi off §a关闭插件");
        	return true;
        }
        if(args[0].equalsIgnoreCase("off")){
        	sender.sendMessage("§3插件已关闭！");
        	Bukkit.getPluginManager().disablePlugin(this);
        	return true;
        }
		return false;
	}

	
	@EventHandler
	public void PlayerDropItemEvent(PlayerDropItemEvent event){
		Inventory inv = Bukkit.createInventory(null,18,"§c§l垃圾桶");
		Player p = event.getPlayer();
		p.openInventory(inv);
		event.setCancelled(true);
	}
	
	@Override
	public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("[NoDropItem] §a插件关闭! 插件作者: §eSaukiya");
	}
}
