package no.mcno.spawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class McnoSpawn extends JavaPlugin {

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {
		
		Player player = null;
		if(sender instanceof Player)
			player = (Player) sender;
		else
			return true;
		
		if(command.getName().equalsIgnoreCase("spawn")) {
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage(ChatColor.GOLD+"Du ble teleportert til spawn...");
			return true;
		}
		else if(command.getName().equalsIgnoreCase("setspawn") && player.isOp()) {
			player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
			player.sendMessage(ChatColor.GREEN+"Du satt spawn til din posisjon...");
			player.sendMessage(ChatColor.GRAY+"Laget av NorskFjellGeit");
			return true;
		}		
		return true;
	}

	@Override
	public void onDisable() {
		System.out.println("McnoSpawn plugin er deaktivert!");
	}

	@Override
	public void onEnable() {
		System.out.println("McnoSpawn plugin er aktivert!");
	}
	
	

}
