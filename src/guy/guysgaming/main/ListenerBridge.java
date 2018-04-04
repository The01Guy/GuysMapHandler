package guy.guysgaming.main;

import guy.guysgaming.main.blockevents.BlockEventHandler;
import guy.guysgaming.main.mobevents.MobEventHandler;
import guy.guysgaming.main.mobevents.mobs.Mobs;
import guy.guysgaming.main.playerevents.PlayerEventHandler;
import guy.guysgaming.main.worldbuilder.WorldBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.util.Vector;

public class ListenerBridge implements Listener {

    MapMain plugin;

    Connection conn;
    Statement st;
    ResultSet rs;

    public WorldBuilder wBuilder;
    public PlayerEventHandler pHandler;
    public BlockEventHandler bHandler;
    public boolean SQLTables;
    public MobEventHandler mHandler;

    public ListenerBridge(MapMain instance) {
        plugin = instance;
        //conn = connect();
        SQLTables = false;
        wBuilder = new WorldBuilder(instance);
        pHandler = new PlayerEventHandler(instance, conn, SQLTables);
        mHandler = new MobEventHandler(instance);
        bHandler = new BlockEventHandler();
    }

    
        @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        //System.out.println("EntityDeathEvent called");
//        if (plugin.mdHolder.MobList.containsKey(event.getEntity().getUniqueId())) {
//            plugin.mdHolder.MobList.remove(event.getEntity().getUniqueId());
//        }
        
        
        //TODO:://Check to see where the mob dies and how it dies to decide what needs to happen.
              //use the entity type to see if the gate needs to open or close. if the gate is 4
              //then the gate needs to be set to an open state.
        
        mHandler.HandleCreatureDeath(event);
        event.getDrops().clear();
              
              
              
              
              
              
              
    }
    
    
    
    
    
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            return DriverManager.getConnection("jdbc:mysql://192.168.1.135:3388/minecraft", "MinecraftServer", "serverminecraft");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return null;
    }

    //Tests if the tables exist and creates them if they don't.
    public boolean tableTest() {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SHOW TABLES LIKE 'player'");
            if (rs.next()) {
                System.out.println("Player table Exist");
            } else {
                int ptable = st.executeUpdate("CREATE TABLE player (id INT UNSIGNED AUTO_INCREMENT KEY, playerName VARCHAR(50), team INT(10) NOT NULL DEFAULT '6') ENGINE MyISAM");
                System.out.println("Player table created.");
            }
            rs = st.executeQuery("SHOW TABLES LIKE 'worlds'");
            if (rs.next()) {
                System.out.println("worlds table Exist");
            } else {
                //Towns
                int wvtable = st.executeUpdate("CREATE TABLE worlds (ID INT, NExit INT,  SExit INT,  WExit INT,  EExit INT, NExitHP INT,  SExitHP INT,  WExitHP INT,  EExitHP INT) ENGINE MyISAM");
                int t0 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('0','0','0','0','0','0','25','25','25','25','25')");
                int t1 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('1','1','1','1','1','1','25','25','25','25','25')");
                int t2 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('2','2','2','2','2','2','25','25','25','25','25')");
                int t3 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('3','3','3','3','3','3','25','25','25','25','25')");

                //East to West MidPoints
                int ew4 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('4','4',NULL,NULL,'3','0','25',NULL,NULL,'25','25')");
                int ew5 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('5','4',NULL,NULL,'0','1','25',NULL,NULL,'25','25')");
                int ew6 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('6','4',NULL,NULL,'1','2','25',NULL,NULL,'25','25')");
                int ew7 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('7','4',NULL,NULL,'2','3','25',NULL,NULL,'25','25')");

                //North to South MidPoints
                int sn8 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('8','4','0','2',NULL,NULL,'25','25','25',NULL,NULL)");
                int sn9 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('9','4','1','3',NULL,NULL,'25','25','25',NULL,NULL)");
                int sn10 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('10','4','2','1',NULL,NULL,'25','25','25',NULL,NULL)");
                int sn11 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('11','4','3','0',NULL,NULL,'25','25','25',NULL,NULL)");

                //West to East Paths
                int we12 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('12','4',NULL,NULL,'3','3','25',NULL,NULL,'25','25')");
                int sn13 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('13','4',NULL,NULL,'0','0','25',NULL,NULL,'25','25')");
                int sn14 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('14','4',NULL,NULL,'0','0','25',NULL,NULL,'25','25')");
                int sn15 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('15','4',NULL,NULL,'1','1','25',NULL,NULL,'25','25')");
                int sn16 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('16','4',NULL,NULL,'1','1','25',NULL,NULL,'25','25')");
                int sn17 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('17','4',NULL,NULL,'2','2','25',NULL,NULL,'25','25')");
                int sn18 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('18','4',NULL,NULL,'2','2','25',NULL,NULL,'25','25')");
                int sn19 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('19','4',NULL,NULL,'3','3','25',NULL,NULL,'25','25')");

                //North to South Paths
                int ns20 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('20','4','3','3',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns21 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('21','4','0','0',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns22 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('22','4','0','0',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns23 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('23','4','2','2',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns24 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('24','4','2','2',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns25 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('25','4','1','1',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns26 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('26','4','1','1',NULL,NULL,'25','25','25',NULL,NULL)");
                int ns27 = st.executeUpdate("INSERT INTO worlds(ID, Center, NExit,  SExit,  WExit,  EExit, CenterHP, NExitHP,  SExitHP,  WExitHP,  EExitHP) VALUES('27','4','3','3',NULL,NULL,'25','25','25',NULL,NULL)");

                System.out.println("WorldScore table created and populated.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @EventHandler
    public void firstWorldCreation(WorldInitEvent event) {
        System.out.println("firstWorldCreation() called");
        wBuilder.createWorld(event.getWorld());
        plugin.mdHolder.addDB(event.getWorld().getName());
    }

    @EventHandler
    public void moveEvent(PlayerMoveEvent event) {
        pHandler.handleMove(event.getPlayer(), event.getTo(), event.getFrom());
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        pHandler.handleLogin(event);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        pHandler.handleQuit(event.getPlayer().getName());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        pHandler.handleJoin(event, plugin);
    }

    @EventHandler
    public void test(PlayerChangedWorldEvent event) {
        System.out.println("From world: " + event.getFrom().getName() + ", Player world " + event.getPlayer().getWorld().getName());
    }

    @EventHandler
    public void MobControlEvent(CreatureSpawnEvent event) {
        //System.out.println("CreatureSpawnEvent called in world " + event.getLocation().getWorld().getName());
        //mHandler.MobMove(event.getLocation().getWorld(), event.getLocation().getWorld().getEntities());
        //event.setCancelled(mHandler.HandleCreatureSpawn(event));
        if(event.getEntity().getCustomName() != null){
            
            if (event.getEntity().getCustomName().equalsIgnoreCase("test")) {
                
                event.getEntity().setRemoveWhenFarAway(false);
            }
        }else{
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void entityExplodeEvent(EntityExplodeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if(! (event.getEntity() instanceof Player)){
            event.getEntity().remove();
            
        }
        if(!(event.getDamager() instanceof Player)){
            event.getDamager().remove();
        }
    }

    


//    public void SpawnMob(World world, Location location, EntityType type) {
//        world.spawnEntity(location, type);
//    }

    @EventHandler
    public void OnEntityCombustEvent(EntityCombustEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void GateSwitchTest(PlayerInteractEvent event) {

        if (!(event.isCancelled())) {

            //System.out.println("X: " + event.getClickedBlock().getLocation().getBlockX() + " Y: " + event.getClickedBlock().getLocation().getBlockY() + " Z: " + event.getClickedBlock().getLocation().getBlockZ());
            if ((event.getClickedBlock().getLocation().getBlockX() == 366) && (event.getClickedBlock().getLocation().getBlockY() == 71) && (event.getClickedBlock().getLocation().getBlockZ() == -118)) {
                if (!(plugin.mdHolder.getGateOwner("11", "center") == 0)) {
                    plugin.mdHolder.setGateOwner("11", "center", 0, 5);
                }

            } else if ((event.getClickedBlock().getLocation().getBlockX() == 372) && (event.getClickedBlock().getLocation().getBlockY() == 71) && (event.getClickedBlock().getLocation().getBlockZ() == -129)) {
                if (!(plugin.mdHolder.getGateOwner("9", "center") == 0)) {
                    plugin.mdHolder.setGateOwner("9", "center", 0, 5);
                }
            } else if ((event.getClickedBlock().getLocation().getBlockX() == 389) && (event.getClickedBlock().getLocation().getBlockY() == 71) && (event.getClickedBlock().getLocation().getBlockZ() == -112)) {
                if (!(plugin.mdHolder.getGateOwner("10", "center") == 0)) {
                    plugin.mdHolder.setGateOwner("10", "center", 0, 5);
                }
            } else if ((event.getClickedBlock().getLocation().getBlockX() == 378) && (event.getClickedBlock().getLocation().getBlockY() == 71) && (event.getClickedBlock().getLocation().getBlockZ() == -106)) {
                if (!(plugin.mdHolder.getGateOwner("8", "center") == 0)) {
                    plugin.mdHolder.setGateOwner("8", "center", 0, 5);
                }
            }
        }
    }
}
/*
 * This class is going to hold all the plugins event handlers.
 * This class will hold the class that will hold the servers info. The methods will return
 *      the values needed to populate the holder class.
 */
