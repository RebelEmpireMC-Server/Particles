package sigler.rebelempiremc.com;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConfigListener implements Listener {
	private Hearts instance;

	public static List<String> playersEffect = new ArrayList<String>();

	public ConfigListener(Hearts instance) {
		this.instance = instance;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (!player.hasPlayedBefore()) {
			// if player has not played before add him to config.
			playersEffect.add(player.getName());
			instance.getConfig().set("player.list", playersEffect);
			instance.saveConfig();
			instance.reloadConfig();

		} else {
			if (instance.getConfig().getStringList("player.list").contains(player)) {
				// if the player's name is in the config then add him to the arraylist (if he is not already on there)
				System.out.println(player.getName() + " is contained within player.list");
				for (String playerName : instance.getConfig().getStringList("player.list")) {
					if (!playersEffect.contains(playerName)) {
						playersEffect.add(playerName);
					}
				}
			}else {
				// if the player's name is not in the config and he has played before add him to the config.
				playersEffect.add(player.getName());
				instance.getConfig().set("player.list", playersEffect);
				instance.saveConfig();
				instance.reloadConfig();
			}
		}
	}
}
