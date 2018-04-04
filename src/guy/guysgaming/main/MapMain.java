package guy.guysgaming.main;

import guy.guysgaming.main.mobevents.MobSpawner;
import guy.guysgaming.main.mobevents.mobs.EntityTypes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Guy
 */
public class MapMain extends JavaPlugin {

    public ListenerBridge lBridge = new ListenerBridge(this);
    public MainDataHolder mdHolder = new MainDataHolder(this);

    Location NorthPoint = new Location(Bukkit.getWorld("0"), 8, 64, -192, (float) 0, (float) 0);
    Location SouthPoint = new Location(Bukkit.getWorld("0"), 8, 64, 208, (float) 179, (float) 2);
    Location WestPoint = new Location(Bukkit.getWorld("0"), -192, 64, 8, (float) -90, (float) 3);
    Location EastPoint = new Location(Bukkit.getWorld("0"), 208, 64, 8, (float) 90, (float) 1);

    Location NorthMidPoint = new Location(Bukkit.getWorld("0"), 8, 64, 0, (float) 179, (float) 2);
    Location SouthMidPoint = new Location(Bukkit.getWorld("0"), 8, 64, 16, (float) 0, (float) 0);
    Location WestMidPoint = new Location(Bukkit.getWorld("0"), 0, 64, 8, (float) 90, (float) 1);
    Location EastMidPoint = new Location(Bukkit.getWorld("0"), 16, 64, 8, (float) -90, (float) 3);

    @Override
    public void onEnable() {

        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(lBridge, this);
        Bukkit.getServer().createWorld(new WorldCreator("0"));
        EntityTypes.registerEntities();
//        for (int i = 0; i < 28; i++) {
//            World testWorld = Bukkit.getServer().getWorld("" + i + "");
//            if (testWorld == null) {
//                Bukkit.getServer().createWorld(WorldCreator.name("" + i + ""));
//            }
//        }
//        if (Bukkit.getServer().getWorld("home_template") == null) {
//            Bukkit.getServer().createWorld(new WorldCreator("home_template"));
//        }
//        File something = Bukkit.getWorldContainer();
//        System.out.println(something.getAbsolutePath() + " " + something.getPath());
//        File test = new File(something, "temp");
//        
//        copyWorld(Bukkit.getServer().getWorld("home_template").getWorldFolder(), test);
//        Bukkit.getServer().createWorld(new WorldCreator("temp"));
        //mdHolder.connect();
        //mdHolder.onStart();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new MobSpawner(this), 10, 500);
    }

    @Override
    public void onDisable() {
        EntityTypes.unregisterEntities();
        //mdHolder.onStop();
        //mdHolder.dissconnect();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("tp")) {
            Player player = (Player) sender;
            if (args[0] != null) {
                if (args[0].equalsIgnoreCase("guys")) {
                    if (Bukkit.getServer().getWorld(args[0]) == null) {
                        Bukkit.getServer().createWorld(new WorldCreator(args[0]));
                    }
                    player.teleport(new Location(Bukkit.getWorld(args[0]), 410, 246, -326, (float) 179, (float) 2));
                    return true;
                } else if (Bukkit.getServer().getWorld(args[0]) == null) {
                    Bukkit.getServer().createWorld(new WorldCreator(args[0]));
                }
                player.teleport(new Location(Bukkit.getWorld(args[0]), 8, 65, -8, (float) 179, (float) 2));
                return true;
            } else {
                if (Bukkit.getServer().getWorld("28") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("28"));
                }
                player.teleport(new Location(Bukkit.getWorld("28"), 8, 65, 8, (float) 179, (float) 2));
                return true;
            }

        } else if (label.equalsIgnoreCase("butcher")) {
            Player player = (Player) sender;
            for (Entity entity : player.getLocation().getWorld().getEntities()) {
                if (!(entity instanceof Player)) {
                    entity.remove();
                }
            }
            return true;
        } else if (label.equalsIgnoreCase("zombietest")) {

//            CustomZombie superZombie = new CustomZombie(((CraftWorld)Bukkit.getWorld("0")).getHandle(),TestPoint);
//            superZombie.setPositionRotation(TestPoint.getX(), TestPoint.getY(), TestPoint.getZ(), TestPoint.getYaw(), TestPoint.getPitch());
//            ((CraftWorld)TestPoint.getWorld()).getHandle().addEntity(superZombie, SpawnReason.CUSTOM);
            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
            EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
            EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);
        } else {
            return false;
        }
        return false;
    }

    public void copyWorld(File source, File target) {
        try {
            ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
            if (!ignore.contains(source.getName())) {
                if (source.isDirectory()) {
                    if (!target.exists()) {
                        target.mkdirs();
                    }
                    String files[] = source.list();
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyWorld(srcFile, destFile);
                    }
                } else {
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {
        }
    }
}
/*
 * This plugin needs to mimic the other one.
 * It needs to create all the worlds with a path running thru them to connect them.
 * It needs to load all the worlds when the server is turned on and save them all when the server is turned off.
 * It needs to connect all the worlds at their connection points and teleport each player to each world when they are in place.
 * Each world will have to keep track of player positions to limit the sizes of the worlds.
 * It needs to keep track of each teams score for each world and show it for each player.
 *      - A scoreboard will be made for each world that will keep the stats.
 *      - A mySQL database will store all the scores for each world.
 *      - A database will also have to be made to keep players pos so they can spawn back at the loc they logged out in.
 *      - A set corrds will have to be set for each team for when a player dies.
 * A /teleport command will have to be added for me to move to each world.
 * I need to make a way for each team to change the world name that is displayed for each world.
 * I need to make a ranking system for the players to help determine leaders for each world.
 */
