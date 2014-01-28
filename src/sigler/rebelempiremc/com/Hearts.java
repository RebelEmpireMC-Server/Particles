//TODO All Off. Just call all the cancelations of the hash maps in one command.



package sigler.rebelempiremc.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.server.v1_7_R1.PacketPlayOutWorldEvent;
import net.minecraft.util.com.google.common.util.concurrent.AbstractScheduledService.Scheduler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import com.gmail.woodyc40.utilitylib.reflection.ReflectionUtil;

@SuppressWarnings("unused")
public class Hearts extends JavaPlugin implements Listener
{
	private JavaPlugin plugin;
	public void onEnable()
	{
		getServer().getLogger().info("-----------------------------");
		getServer().getLogger().info("REMC Particles has been enabled!");
		getServer().getLogger().info("-----------------------------");
		//getCommand("notes").setExecutor(new Noteeffect());
	}

	public void onDisable()
	{
		getServer().getLogger().info("------------------------------");
		getServer().getLogger().info("REMC Particles has been disabled!");
		getServer().getLogger().info("------------------------------");
		Bukkit.getServer().getScheduler().cancelAllTasks();	
		effectHeart.removeAll(effectHeart);
	}
	
	public BlockFace getDirection(Player player) {
		double rotation = (player.getLocation().getYaw() - 180) % 360;
		if (rotation < 0)
			rotation += 360.0;
		if (0 <= rotation && rotation < 40.0)
			return BlockFace.NORTH;
		else if (40.0 <= rotation && rotation < 80.0)
			return BlockFace.NORTH_EAST;
		else if (80.0 <= rotation && rotation < 120.0)
			return BlockFace.EAST;
		else if (120.0 <= rotation && rotation < 160.0)
			return BlockFace.SOUTH_EAST;
		else if (160.0 <= rotation && rotation < 200.0)
			return BlockFace.SOUTH;
		else if (200.0 <= rotation && rotation < 240.0)
			return BlockFace.SOUTH_WEST;
		else if (240.0 <= rotation && rotation < 280.0)
			return BlockFace.WEST;
		else if (280.0 <= rotation && rotation < 320.0)
			return BlockFace.NORTH_WEST;
		else if (320.0 <= rotation && rotation < 360.0)
			return BlockFace.NORTH;
		else
			return null;
	}
	/*    public BlockFace getDirection(Player player) {
   double rotation = (player.getLocation().getYaw() - 90) % 360;
   if (rotation < 0)
   rotation += 360.0;
   if (0 <= rotation && rotation < 22.5)
   return BlockFace.NORTH;
   else if (22.5 <= rotation && rotation < 67.5)
   return BlockFace.NORTH_EAST;
   else if (67.5 <= rotation && rotation < 112.5)
   return BlockFace.EAST;
   else if (112.5 <= rotation && rotation < 157.5)
   return BlockFace.SOUTH_EAST;
   else if (157.5 <= rotation && rotation < 202.5)
   return BlockFace.SOUTH;
   else if (202.5 <= rotation && rotation < 247.5)
   return BlockFace.SOUTH_WEST;
   else if (247.5 <= rotation && rotation < 292.5)
   return BlockFace.WEST;
   else if (292.5 <= rotation && rotation < 337.5)
   return BlockFace.NORTH_WEST;
   else if (337.5 <= rotation && rotation < 360.0)
   return BlockFace.NORTH;
   else
   return null;
   } */
	

	ArrayList<Player> effectHeart = new ArrayList<Player>();
	Map<String, Integer> heart = new HashMap<String, Integer>();
	Map<String, Integer> portal = new HashMap<String, Integer>();
	Map<String, Integer> flame = new HashMap<String, Integer>();
	Map<String, Integer> cloud = new HashMap<String, Integer>();
	Map<String, Integer> smoke = new HashMap<String, Integer>();
	Map<String, Integer> mflame = new HashMap<String, Integer>();
	Map<String, Integer> ender = new HashMap<String, Integer>();
	Map<String, Integer> bubble = new HashMap<String, Integer>();
	Map<String, Integer> explosion = new HashMap<String, Integer>();
	Map<String, Integer> snow = new HashMap<String, Integer>();
	Map<String, Integer> ench = new HashMap<String, Integer>();
	Map<String, Integer> lava = new HashMap<String, Integer>();
	Map<String, Integer> splash = new HashMap<String, Integer>();
	Map<String, Integer> reddust = new HashMap<String, Integer>();
	Map<String, Integer> villager = new HashMap<String, Integer>();
	Map<String, Integer> all = new HashMap<String, Integer>();

	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		final Player player = (Player) sender;	
		
		if (cmd.getName().equalsIgnoreCase("poff") || cmd.getName().equalsIgnoreCase("particlesoff"))
		{
			if (sender.hasPermission("remc.particle.off"))
			{
				/*Bukkit.getScheduler().cancelTask(heart.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(portal.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(flame.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(cloud.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(smoke.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(mflame.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(ender.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(bubble.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(explosion.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(snow.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(ench.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(lava.get(sender.getName()));
				Bukkit.getScheduler().cancelTask(splash.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(reddust.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(villager.get(sender.getName()));	
				Bukkit.getScheduler().cancelTask(all.get(sender.getName()));	
				heart.remove(sender.getName());
				portal.remove(sender.getName());
				flame.remove(sender.getName());
				cloud.remove(sender.getName());
				smoke.remove(sender.getName());
				mflame.remove(sender.getName());
				ender.remove(sender.getName());
				explosion.remove(sender.getName());
				bubble.remove(sender.getName());
				snow.remove(sender.getName());
				ench.remove(sender.getName());
				lava.remove(sender.getName());
				splash.remove(sender.getName());
				reddust.remove(sender.getName());
				villager.remove(sender.getName());
				all.remove(sender.getName());*/
				Bukkit.getScheduler().cancelAllTasks();	
				
				sender.sendMessage(ChatColor.GREEN + "Particles disabled!");
			}
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("heart") || cmd.getName().equalsIgnoreCase("hearts"))
			{
				if (sender.hasPermission("remc.particle.heart"))
				{


					if (!heart.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int taskheart = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.HEART.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 4L);
						player.sendMessage(ChatColor.BLUE + "Hearts have been enabled!");
						heart.put(sender.getName(), taskheart);
					}//else
					else if (heart.containsKey(sender.getName())) 
					{
						player.sendMessage(ChatColor.AQUA + "Hearts have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(heart.get(sender.getName()));
						heart.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("snow") || cmd.getName().equalsIgnoreCase("snow"))
			{
				if (sender.hasPermission("remc.particle.snow"))
				{


					if (!snow.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int snowtask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.SNOW_SHOVEL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Snow has been enabled!");
						snow.put(sender.getName(), snowtask);
					}//else
					else if (snow.containsKey(sender.getName())) 
					{
						player.sendMessage(ChatColor.AQUA + "Snow has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(snow.get(sender.getName()));
						snow.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("explosion") || cmd.getName().equalsIgnoreCase("explosions"))
			{
				if (sender.hasPermission("remc.particle.explosion"))
				{


					if (!explosion.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int explosiontask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.HUGE_EXPLOSION.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Explosions have been enabled!");
						explosion.put(sender.getName(), explosiontask);
					}//else
					else if (explosion.containsKey(sender.getName())) 
					{
						player.sendMessage(ChatColor.AQUA + "Explosions have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(explosion.get(sender.getName()));
						explosion.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}


		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("portal") || cmd.getName().equalsIgnoreCase("portals"))
			{
				if (sender.hasPermission("remc.particle.portal"))
				{


					if (!portal.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int portaltask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.PORTAL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Portals have been enabled!");
						portal.put(sender.getName(), portaltask);
					}//else
					else if (portal.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Portals have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(portal.get(sender.getName()));
						portal.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}



		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("flame") || cmd.getName().equalsIgnoreCase("flames"))
			{
				if (sender.hasPermission("remc.particle.flame"))
				{


					if (!flame.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int flametask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.FLAME.display(player.getLocation(), .25F, 0.0F, 0.25F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Flames have been enabled!");
						flame.put(sender.getName(), flametask);
					}//else
					else if (flame.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Flames have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(flame.get(sender.getName()));
						flame.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("cloud") || cmd.getName().equalsIgnoreCase("clouds"))
			{
				if (sender.hasPermission("remc.particle.cloud"))
				{


					if (!cloud.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int cloudtask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.CLOUD.display(player.getLocation(), 0.0F, 0.15F, 0.0F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Clouds have been enabled!");
						cloud.put(sender.getName(), cloudtask);
					}//else
					else if (cloud.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Clouds have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(cloud.get(sender.getName()));
						cloud.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("bubble") || cmd.getName().equalsIgnoreCase("bubbles"))
			{
				if (sender.hasPermission("remc.particle.bubble"))
				{


					if (!bubble.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int bubbletask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.BUBBLE.display(player.getLocation(), 0.0F, 0.15F, 0.0F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Bubbles have been enabled!");
						bubble.put(sender.getName(), bubbletask);
					}//else
					else if (bubble.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Bubbles have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(bubble.get(sender.getName()));
						bubble.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("smoke") || cmd.getName().equalsIgnoreCase("smokes"))
			{
				if (sender.hasPermission("remc.particle.smoke"))
				{


					if (!smoke.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int smoketask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@SuppressWarnings("deprecation")
							@Override
							public void run() 
							{
								for(Player pall:Bukkit.getOnlinePlayers())
								{
									pall.playEffect(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), Effect.SMOKE, 0);
								}
							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Smoke have been enabled!");
						smoke.put(sender.getName(), smoketask);
					}//else
					else if (smoke.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Smoke have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(smoke.get(sender.getName()));
						smoke.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("ender") || cmd.getName().equalsIgnoreCase("enders"))
			{
				if (sender.hasPermission("remc.particle.ender"))
				{


					if (!ender.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int endertask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@SuppressWarnings("deprecation")
							@Override
							public void run() 
							{
								for(Player pall:Bukkit.getOnlinePlayers())
								{
									pall.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 0);
								}

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "EnderEye have been enabled!");
						ender.put(sender.getName(), endertask);
					}//else
					else if (ender.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "EnderEye have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(ender.get(sender.getName()));
						ender.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("mflame") || cmd.getName().equalsIgnoreCase("mflames"))
			{
				if (sender.hasPermission("remc.particle.mflame"))
				{


					if (!mflame.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int mflametask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@SuppressWarnings("deprecation")
							@Override
							public void run() 
							{
								for(Player pall:Bukkit.getOnlinePlayers())
								{
									player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
								}

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Clouds have been enabled!");
						mflame.put(sender.getName(), mflametask);
					}//else
					else if (mflame.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Clouds have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(mflame.get(sender.getName()));
						mflame.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("ench") || cmd.getName().equalsIgnoreCase("enchs"))
			{
				if (sender.hasPermission("remc.particle.ench"))
				{


					if (!ench.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int enchtask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.ENCHANTMENT_TABLE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.25, 0.5), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 4L);
						player.sendMessage(ChatColor.BLUE + "Enchantment Particles have been enabled!");
						ench.put(sender.getName(), enchtask);
					}//else
					else if (ench.containsKey(sender.getName())) 
					{
						player.sendMessage(ChatColor.AQUA + "Enchantment particles have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(ench.get(sender.getName()));
						ench.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}

		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("explosion") || cmd.getName().equalsIgnoreCase("explosions"))
			{
				if (sender.hasPermission("remc.particle.explosion"))
				{


					if (!explosion.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int lavatask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.LARGE_EXPLODE.display(player.getLocation(), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 3L);
						player.sendMessage(ChatColor.BLUE + "Explosion has been enabled!");
						explosion.put(sender.getName(), lavatask);
					}//else
					else if (explosion.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Explosions has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(explosion.get(sender.getName()));
						explosion.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		


		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("lava") || cmd.getName().equalsIgnoreCase("lavas"))
			{
				if (sender.hasPermission("remc.particle.lava"))
				{


					if (!lava.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int lavatask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.LAVA.display(player.getLocation(), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 3L);
						player.sendMessage(ChatColor.BLUE + "Lava has been enabled!");
						lava.put(sender.getName(), lavatask);
					}//else
					else if (lava.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Lava has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(lava.get(sender.getName()));
						lava.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("splash") || cmd.getName().equalsIgnoreCase("splashs"))
			{
				if (sender.hasPermission("remc.particle.splash"))
				{


					if (!splash.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int splashtask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.SPLASH.display(player.getLocation(), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 3L);
						player.sendMessage(ChatColor.BLUE + "Splash has been enabled!");
						splash.put(sender.getName(), splashtask);
					}//else
					else if (splash.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Splash has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(splash.get(sender.getName()));
						splash.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("dust") || cmd.getName().equalsIgnoreCase("reddust"))
			{
				if (sender.hasPermission("remc.particle.dust"))
				{


					if (!reddust.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int dusttask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.RED_DUST.display(player.getLocation(), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 3L);
						player.sendMessage(ChatColor.BLUE + "Red Dust has been enabled!");
						reddust.put(sender.getName(), dusttask);
					}//else
					else if (reddust.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Red Dust has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(reddust.get(sender.getName()));
						reddust.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("villager") || cmd.getName().equalsIgnoreCase("av"))
			{
				if (sender.hasPermission("remc.particle.villager"))
				{


					if (!villager.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int villagertask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.ANGRY_VILLAGER.display(player.getLocation(), .15F, 0.15F, 0.15F, .1F, 10);

							}


						},0, 3L);
						player.sendMessage(ChatColor.BLUE + "Villager has been enabled!");
						villager.put(sender.getName(), villagertask);
					}//else
					else if (villager.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Villager has been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(villager.get(sender.getName()));
						villager.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}
		
		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("pall") || cmd.getName().equalsIgnoreCase("palls"))
			{
				if (sender.hasPermission("remc.oponly.all"))
				{


					if (!all.containsKey(sender.getName()))
					{
						player.playSound(player.getLocation(),Sound.LEVEL_UP,1, 0);

						BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
						int alltask = scheduler.scheduleSyncRepeatingTask(this, new Runnable()

						{


							@Override
							public void run() 
							{
								ParticleEffect.ANGRY_VILLAGER.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.BUBBLE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.CLOUD.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.CRIT.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.DEPTH_SUSPEND.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.DRIP_LAVA.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.DRIP_WATER.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.ENCHANTMENT_TABLE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.EXPLODE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.FIREWORKS_SPARK.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.FLAME.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.FOOTSTEP.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.HAPPY_VILLAGER.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.HEART.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.INSTANT_SPELL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.LARGE_SMOKE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.LAVA.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.MAGIC_CRIT.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.MOB_SPELL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.MOB_SPELL_AMBIENT.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.NOTE.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.PORTAL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.RED_DUST.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 2.5, 0.5), .1F, 0.1F, 0.1F, .1F, 1);
								ParticleEffect.SLIME.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.SNOW_SHOVEL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.SNOWBALL_POOF.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.SPELL.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.SPLASH.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.SUSPEND.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.TOWN_AURA.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);
								ParticleEffect.WITCH_MAGIC.display(player.getLocation().getBlock().getRelative(getDirection(player).getOppositeFace()).getLocation().add(0.5, 0.1, 0.5), .5F, 0.1F, 0.5F, .1F, 10);

							}


						},0, 1L);
						player.sendMessage(ChatColor.BLUE + "Particles have been enabled!");
						all.put(sender.getName(), alltask);
					}//else
					else if (all.containsKey(sender.getName())) {
						player.sendMessage(ChatColor.AQUA + "Particles have been disabled!");
						
						player.playSound(player.getLocation(),Sound.ORB_PICKUP,1, 0);	
						Bukkit.getScheduler().cancelTask(all.get(sender.getName()));
						all.remove(sender.getName());
					}


				}else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
				}
			}

		}else
		{
			sender.sendMessage("You must be a player to run this command!");
		}



		if (sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("particles") || cmd.getName().equalsIgnoreCase("particle"))
			{
				if (sender.hasPermission("remc.particle.list"))
				{
					if (args.length == 0) {
						player.sendMessage(ChatColor.DARK_GREEN + "-----" + ChatColor.GREEN + " REMC Particles (1/2) " + ChatColor.DARK_GREEN + "-----");
						player.sendMessage(ChatColor.RED + "/heart " + ChatColor.YELLOW + " Heart effect!");
						player.sendMessage(ChatColor.RED + "/portal " + ChatColor.YELLOW + " Portal effect!");
						player.sendMessage(ChatColor.RED + "/flame " + ChatColor.YELLOW + " Flame Effect!");
						player.sendMessage(ChatColor.RED + "/cloud " + ChatColor.YELLOW + " Cloud Effect!");
						player.sendMessage(ChatColor.RED + "/smoke " + ChatColor.YELLOW + " Smoke effect!");
						player.sendMessage(ChatColor.RED + "/mflame " + ChatColor.YELLOW + " MobFlame effect!");
						player.sendMessage(ChatColor.RED + "/ender " + ChatColor.YELLOW + " EnderEye effect!");
						player.sendMessage(ChatColor.RED + "/bubble " + ChatColor.YELLOW + " Bubble Effect!");
						player.sendMessage(ChatColor.DARK_GREEN + "Type /particle 2 for next page!");
					  }
					if (args[0].equalsIgnoreCase("2"))
					{
					player.sendMessage(ChatColor.DARK_GREEN + "-----" + ChatColor.GREEN + " REMC Particles (2/2) " + ChatColor.DARK_GREEN + "-----");
					player.sendMessage(ChatColor.RED + "/explosion " + ChatColor.YELLOW + " Explosion effect!");
					player.sendMessage(ChatColor.RED + "/snow " + ChatColor.YELLOW + " Snow effect!");
					player.sendMessage(ChatColor.RED + "/lava " + ChatColor.YELLOW + " Lava effect!");
					player.sendMessage(ChatColor.RED + "/villager " + ChatColor.YELLOW + " Villager effect!");
					player.sendMessage(ChatColor.RED + "/splash " + ChatColor.YELLOW + " Splash effect!");
					player.sendMessage(ChatColor.RED + "/dust " + ChatColor.YELLOW + " Dust effect!");
					}
				}else
				{
					player.sendMessage("You do not have permission to view the particle list!");
				}
			}
		}else
		{
			sender.sendMessage("You must be a player to use this command!");
		}

		return false;
	}
}




