package guy.guysgaming.main.mobevents;

import guy.guysgaming.main.MapMain;
import guy.guysgaming.main.mobevents.mobs.EntityTypes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MobSpawner implements Runnable{

    MapMain plugin;
    
    public Location NorthPoint = new Location(null, 8, 64, -192, (float) 0, (float) 0);
    public Location SouthPoint = new Location(null, 8, 64, 208, (float) 179, (float) 2);
    public Location WestPoint = new Location(null, -192, 64, 8, (float) -90, (float) 3);
    public Location EastPoint = new Location(null, 208, 64, 8, (float) 90, (float) 1);

    public Location NorthMidPoint = new Location(null, 8, 64, 0, (float) 179, (float) 2);
    public Location SouthMidPoint = new Location(null, 8, 64, 16, (float) 0, (float) 0);
    public Location WestMidPoint = new Location(null, 0, 64, 8, (float) 90, (float) 1);
    public Location EastMidPoint = new Location(null, 16, 64, 8, (float) -90, (float) 3);
    
    public Location NorthPathPoint = new Location(null, 8, 64, -110, (float) 0, (float) 0);
    public Location SouthPathPoint = new Location(null, 8, 64, 125, (float) 179, (float) 2);
    public Location WestPathPoint = new Location(null, -110, 64, 8, (float) -90, (float) 3);
    public Location EastPathPoint = new Location(null, 125, 64, 8, (float) 90, (float) 1);
    
    public MobSpawner(MapMain instance){
        this.plugin = instance;
    }
    
    @Override
    public void run() {
        for(World world : Bukkit.getWorlds()){
            switch(world.getName()){
                case "0":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "1":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "2":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "3":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "4":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnWETownCenterGate(world, CenterGateOwner);
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "5":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnWETownCenterGate(world, CenterGateOwner);
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "6":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnWETownCenterGate(world, CenterGateOwner);
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "7":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnWETownCenterGate(world, CenterGateOwner);
                    SpawnWestGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "west"));
                    SpawnEastGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "east"));
                }break;
                
                case "8":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnNSTownCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                }break;
                
                case "9":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnNSTownCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                }break;
                
                case "10":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnNSTownCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                }break;
                
                case "11":
                {
                    int CenterGateOwner = plugin.mdHolder.getGateOwner(world.getName(), "center");
                    SpawnNSTownCenterGate(world, CenterGateOwner);
                    SpawnNorthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "north"));
                    SpawnSouthGate(world, CenterGateOwner, plugin.mdHolder.getGateOwner(world.getName(), "south"));
                }break;
                
                case "12":
                {
                    SpawnWEPathGate(world, "3", "4");
                }break;
                
                case "13":
                {
                    SpawnWEPathGate(world, "4", "0");
                }break;
                
                case "14":
                {
                    SpawnWEPathGate(world, "0", "5");
                }break;
                
                case "15":
                {
                    SpawnWEPathGate(world, "5", "1");
                }break;
                
                case "16":
                {
                    SpawnWEPathGate(world, "1", "6");
                }break;
                
                case "17":
                {
                    SpawnWEPathGate(world, "6", "2");
                }break;
                
                case "18":
                {
                    SpawnWEPathGate(world, "2", "7");
                }break;
                
                case "19":
                {
                    SpawnWEPathGate(world, "7", "3");
                }break;
                
                case "20":
                {
                    SpawnNSPathGate(world, "3", "11");
                }break;
                
                case "21":
                {
                    SpawnNSPathGate(world, "11", "0");
                }break;
                
                case "22":
                {
                    SpawnNSPathGate(world, "0", "8");
                }break;
                
                case "23":
                {
                    SpawnNSPathGate(world, "8", "2");
                }break;
                
                case "24":
                {
                    SpawnNSPathGate(world, "2", "10");
                }break;
                
                case "25":
                {
                    SpawnNSPathGate(world, "10", "1");
                }break;
                
                case "26":
                {
                    SpawnNSPathGate(world, "1", "9");
                }break;
                
                case "27":
                {
                    SpawnNSPathGate(world, "9", "3");
                }break;
                
                default:
                {
                    //System.out.println(world.getName());
                }break;
            }
        }     
    }
    
    public void SpawnCenterGate(World world, int GateOwner){
        //Center gate
        NorthPoint.setWorld(world);
        SouthPoint.setWorld(world);
        WestPoint.setWorld(world);
        EastPoint.setWorld(world);

        NorthMidPoint.setWorld(world);
        SouthMidPoint.setWorld(world);
        WestMidPoint.setWorld(world);
        EastMidPoint.setWorld(world);
        
        switch (GateOwner) {
            case 0: {
                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 1: {
                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 2: {
                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 3: {
                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 4: {

            }
            break;
            default: {

            }
            break;
        }
    }
    
    public void SpawnNSTownCenterGate(World world, int GateOwner){
        //Center gate
        NorthPoint.setWorld(world);
        SouthPoint.setWorld(world);

        NorthMidPoint.setWorld(world);
        SouthMidPoint.setWorld(world);
        
        switch (GateOwner) {
            case 0: {
                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(SouthMidPoint, SouthPoint);
            }
            break;
            case 1: {
                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SKELETON_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(SouthMidPoint, SouthPoint);
            }
            break;
            case 2: {
                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_CREEPER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(SouthMidPoint, SouthPoint);
            }
            break;
            case 3: {
                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);

                EntityTypes.CUSTOM_SPIDER_NORTH.spawn(NorthMidPoint, NorthPoint);
                EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(SouthMidPoint, SouthPoint);
            }
            break;
            case 4: {

            }
            break;
            default: {

            }
            break;
        }
    }
    
    public void SpawnWETownCenterGate(World world, int GateOwner){
        //Center gate
        WestPoint.setWorld(world);
        EastPoint.setWorld(world);

        WestMidPoint.setWorld(world);
        EastMidPoint.setWorld(world);
        
        switch (GateOwner) {
            case 0: {
                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 1: {
                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SKELETON_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SKELETON_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 2: {
                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_CREEPER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_CREEPER_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 3: {
                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);

                EntityTypes.CUSTOM_SPIDER_WEST.spawn(WestMidPoint, WestPoint);
                EntityTypes.CUSTOM_SPIDER_EAST.spawn(EastMidPoint, EastPoint);
            }
            break;
            case 4: {

            }
            break;
            default: {

            }
            break;
        }
    }
    
    public void SpawnNorthGate(World world, int CenterGateOwner, int NorthGateOwner){
        //North gate
        if (CenterGateOwner != NorthGateOwner) {
            NorthPoint.setWorld(world);
            SouthPoint.setWorld(world);
            WestPoint.setWorld(world);
            EastPoint.setWorld(world);

            NorthMidPoint.setWorld(world);
            SouthMidPoint.setWorld(world);
            WestMidPoint.setWorld(world);
            EastMidPoint.setWorld(world);
            
            switch (NorthGateOwner) {
                case 0: {
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, NorthMidPoint);

                }
                break;
                case 1: {
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, NorthMidPoint);
                }
                break;
                case 2: {
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                }
                break;
                case 3: {
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, NorthMidPoint);
                }
                break;
                case 4: {

                }
                break;
                default: {

                }
                break;
            }
        }
    }
    
    public void SpawnSouthGate(World world, int CenterGateOwner, int SouthGateOwner){
        //South Gate
        if (CenterGateOwner != SouthGateOwner) {
            NorthPoint.setWorld(world);
            SouthPoint.setWorld(world);
            WestPoint.setWorld(world);
            EastPoint.setWorld(world);

            NorthMidPoint.setWorld(world);
            SouthMidPoint.setWorld(world);
            WestMidPoint.setWorld(world);
            EastMidPoint.setWorld(world);
        
            switch (SouthGateOwner) {
                case 0: {
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, SouthMidPoint);
                }
                break;
                case 1: {
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, SouthMidPoint);
                }
                break;
                case 2: {
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, SouthMidPoint);
                }
                break;
                case 3: {
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                    EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, SouthMidPoint);
                }
                break;
                case 4: {

                }
                break;
                default: {

                }
                break;
            }
        }
    }
    
    public void SpawnWestGate(World world, int CenterGateOwner, int WestGateOwner){
        //West Gate
        if (CenterGateOwner != WestGateOwner) {
            NorthPoint.setWorld(world);
            SouthPoint.setWorld(world);
            WestPoint.setWorld(world);
            EastPoint.setWorld(world);

            NorthMidPoint.setWorld(world);
            SouthMidPoint.setWorld(world);
            WestMidPoint.setWorld(world);
            EastMidPoint.setWorld(world);
            
            switch (WestGateOwner) {
                case 0: {
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, WestMidPoint);
                }
                break;
                case 1: {
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, WestMidPoint);
                }
                break;
                case 2: {
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, WestMidPoint);
                }
                break;
                case 3: {
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                    EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, WestMidPoint);
                }
                break;
                case 4: {

                }
                break;
                default: {

                }
                break;
            }
        }
    }    
    
    public void SpawnEastGate(World world, int CenterGateOwner, int EastGateOwner){
        //East Gate
        if (CenterGateOwner != EastGateOwner) {
            NorthPoint.setWorld(world);
            SouthPoint.setWorld(world);
            WestPoint.setWorld(world);
            EastPoint.setWorld(world);

            NorthMidPoint.setWorld(world);
            SouthMidPoint.setWorld(world);
            WestMidPoint.setWorld(world);
            EastMidPoint.setWorld(world);
            switch (EastGateOwner) {
                case 0: {
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, EastMidPoint);
                }
                break;
                case 1: {
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, EastMidPoint);
                }
                break;
                case 2: {
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, EastMidPoint);
                }
                break;
                case 3: {
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                    EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, EastMidPoint);
                }
                break;
                case 4: {

                }
                break;
                default: {

                }
                break;
            }
        }
    }
    
    public void SpawnWEPathGate(World world, String WestTown, String EastTown){
        WestPathPoint.setWorld(world);
        EastPathPoint.setWorld(world);

        int WestGateOwner = plugin.mdHolder.getGateOwner(WestTown, "east"); // city 3's east gate
        int EastGateOwner = plugin.mdHolder.getGateOwner(EastTown, "west"); // town 4's west gate

        if(WestGateOwner == EastGateOwner){
            int WestTownOwner = plugin.mdHolder.getGateOwner(WestTown, "center");
            int EastTownOwner = plugin.mdHolder.getGateOwner(EastTown, "center");
            if(WestTownOwner == EastGateOwner){
                switch(WestGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 4:
                        {
                        }break;

                    default:
                        {
                        }break;
                }
            }else if(EastTownOwner == WestGateOwner){
                switch(EastGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        }break;
                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        }break;
                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        }break;
                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                            EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        }break;
                    case 4:
                        {
                        }break;
                    default:
                        {
                        }break;
                }

            }else{
                switch(WestGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                            EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        }break;

                    case 4:
                        {
                        }break;

                    default:
                        {
                        }break;
                }
            }
        }else{
            switch(WestGateOwner){
                case 0:
                    {
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_ZOMBIE_EAST.spawn(WestPoint, EastPoint);
                    }break;

                case 1:
                    {
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SKELETON_EAST.spawn(WestPoint, EastPoint);
                    }break;

                case 2:
                    {
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_CREEPER_EAST.spawn(WestPoint, EastPoint);
                    }break;

                case 3:
                    {
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                        EntityTypes.CUSTOM_SPIDER_EAST.spawn(WestPoint, EastPoint);
                    }break;

                case 4:
                    {
                    }break;

                default:
                    {
                    }break;
            }

            switch(EastGateOwner){
                case 0:
                    {
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_ZOMBIE_WEST.spawn(EastPoint, WestPoint);
                    }break;
                case 1:
                    {
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SKELETON_WEST.spawn(EastPoint, WestPoint);
                    }break;
                case 2:
                    {
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_CREEPER_WEST.spawn(EastPoint, WestPoint);
                    }break;
                case 3:
                    {
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                        EntityTypes.CUSTOM_SPIDER_WEST.spawn(EastPoint, WestPoint);
                    }break;
                case 4:
                    {
                    }break;
                default:
                    {
                    }break;
            }
        }
    }
    
    public void SpawnNSPathGate(World world, String NorthTown, String SouthTown){
        NorthPathPoint.setWorld(world);
        SouthPathPoint.setWorld(world);

        int NorthGateOwner = plugin.mdHolder.getGateOwner(NorthTown, "south"); // city 3's east gate
        int SouthGateOwner = plugin.mdHolder.getGateOwner(SouthTown, "north"); // town 4's west gate

        if(NorthGateOwner == SouthGateOwner){
            int NorthTownOwner = plugin.mdHolder.getGateOwner(NorthTown, "center");
            int SouthTownOwner = plugin.mdHolder.getGateOwner(SouthTown, "center");
            if(NorthTownOwner == SouthGateOwner){
                switch(NorthGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 4:
                        {
                        }break;

                    default:
                        {
                        }break;
                }
            }else if(SouthTownOwner == NorthGateOwner){
                switch(SouthGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        }break;
                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        }break;
                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        }break;
                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                            EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        }break;
                    case 4:
                        {
                        }break;
                    default:
                        {
                        }break;
                }

            }else{
                switch(NorthGateOwner){
                    case 0:
                        {
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 1:
                        {
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 2:
                        {
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 3:
                        {
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                            EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        }break;

                    case 4:
                        {
                        }break;

                    default:
                        {
                        }break;
                }
            }
        }else{
            switch(NorthGateOwner){
                case 0:
                    {
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_SOUTH.spawn(NorthPoint, SouthPoint);
                    }break;

                case 1:
                    {
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SKELETON_SOUTH.spawn(NorthPoint, SouthPoint);
                    }break;

                case 2:
                    {
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_CREEPER_SOUTH.spawn(NorthPoint, SouthPoint);
                    }break;

                case 3:
                    {
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                        EntityTypes.CUSTOM_SPIDER_SOUTH.spawn(NorthPoint, SouthPoint);
                    }break;

                case 4:
                    {
                    }break;

                default:
                    {
                    }break;
            }

            switch(SouthGateOwner){
                case 0:
                    {
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_ZOMBIE_NORTH.spawn(SouthPoint, NorthPoint);
                    }break;
                case 1:
                    {
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SKELETON_NORTH.spawn(SouthPoint, NorthPoint);
                    }break;
                case 2:
                    {
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_CREEPER_NORTH.spawn(SouthPoint, NorthPoint);
                    }break;
                case 3:
                    {
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                        EntityTypes.CUSTOM_SPIDER_NORTH.spawn(SouthPoint, NorthPoint);
                    }break;
                case 4:
                    {
                    }break;
                default:
                    {
                    }break;
            }
        }
    }
}
