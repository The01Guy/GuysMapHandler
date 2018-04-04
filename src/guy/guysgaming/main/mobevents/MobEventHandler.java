package guy.guysgaming.main.mobevents;

import guy.guysgaming.main.MapMain;
import guy.guysgaming.main.mobevents.mobs.Mobs;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.util.Vector;

public class MobEventHandler {
    
    MapMain plugin;
    
    public Location NorthPoint = new Location(Bukkit.getWorld("0"), 8, 64, -192, (float) 0, (float) 0);
    public Location SouthPoint = new Location(Bukkit.getWorld("0"), 8, 64, 208, (float) 179, (float) 2);
    public Location WestPoint = new Location(Bukkit.getWorld("0"), -192, 64, 8, (float) -90, (float) 3);
    public Location EastPoint = new Location(Bukkit.getWorld("0"), 208, 64, 8, (float) 90, (float) 1);

    public Location NorthMidPoint = new Location(Bukkit.getWorld("0"), 8, 64, 0, (float) 179, (float) 2);
    public Location SouthMidPoint = new Location(Bukkit.getWorld("0"), 8, 64, 16, (float) 0, (float) 0);
    public Location WestMidPoint = new Location(Bukkit.getWorld("0"), 0, 64, 8, (float) 90, (float) 1);
    public Location EastMidPoint = new Location(Bukkit.getWorld("0"), 16, 64, 8, (float) -90, (float) 3);
    
    public Location NorthPathPoint = new Location(Bukkit.getWorld("0"), 8, 64, -110, (float) 0, (float) 0);
    public Location SouthPathPoint = new Location(Bukkit.getWorld("0"), 8, 64, 125, (float) 179, (float) 2);
    public Location WestPathPoint = new Location(Bukkit.getWorld("0"), -110, 64, 8, (float) -90, (float) 3);
    public Location EastPathPoint = new Location(Bukkit.getWorld("0"), 125, 64, 8, (float) 90, (float) 1);
    
    public Vector SouthVector = new Vector(0.0f, 0.0f, 0.2f);
    public Vector NorthVector = new Vector(0.0f, 0.0f, -0.2f);
    public Vector WestVector = new Vector(-0.2f, 0.0f, 0.0f);
    public Vector EastVector = new Vector(0.2f, 0.0f, 0.0f);
    
    int NorthGateCount = 0;
    int SouthGateCount = 0;
    int WestGateCount = 0;
    int EastGateCount = 0;
    int NorthMidGateCount = 0;
    int SouthMidGateCount = 0;
    int WestMidGateCount = 0;
    int EastMidGateCount = 0;
    
    int CenterGateOwner;
    int NorthGateOwner;
    int SouthGateOwner;
    int WestGateOwner;
    int EastGateOwner;
    
    
    //Mobs[][] testMob = new Mobs[8][6]; 
    /*
    
    5 = NorthPoint
    6 = SouthPoint
    7 = WestPoint
    8 = EastPoint
    1 = NorthMidPoint
    2 = SouthMidPoint
    3 = WestMidPoint
    4 = EastMidPoint
    
    9 = NorthPathPoint
    10 = SouthPathPoint
    11 = WestPathPoint
    12 = EastPathPoint
    */
    
    public MobEventHandler(MapMain instance){
        this.plugin = instance;
    }
    
    public void handleTownDeaths(LivingEntity entity){
        if(entity.getLocation().getChunk().getZ() <= -12){//North Moving Mob
            //System.out.println("X 0 Z -12");
            int NorthGateOwner = plugin.mdHolder.getGateOwner(entity.getLocation().getWorld().getName(), "north");
            switch(entity.getType()){
                case ZOMBIE:
                    {
                        if((NorthGateOwner != 0) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "north");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "north", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "north", newGateHp);
                            }
                        }
                    }break;
                case SKELETON:
                    {
                        if((NorthGateOwner != 1) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "north");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "north", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "north", newGateHp);
                            }
                        }
                    }break;
                case CREEPER:
                    {
                        if((NorthGateOwner != 2) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "north");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "north", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "north", newGateHp);
                            }
                        }
                    }break;
                case SPIDER:
                    {
                        if((NorthGateOwner != 3) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "north");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "north", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "north", newGateHp);
                            }
                        }
                    }break;
                default:
                {

                }break;
            }
        }else if(entity.getLocation().getChunk().getZ() >= 12){//South Moving Mob
            //System.out.println("X 0 Z 12");
            int SouthGateOwner = plugin.mdHolder.getGateOwner(entity.getLocation().getWorld().getName(), "south");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "south");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "south", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "south", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((SouthGateOwner != 1) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "south");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "south", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "south", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((SouthGateOwner != 2) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "south");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "south", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "south", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((SouthGateOwner != 3) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "south");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "south", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "south", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else{
            
        }
        
        if(entity.getLocation().getChunk().getX() <= -12){//West Moving Mob
            //System.out.println("X -12 Z 0");
            int WestGateOwner = plugin.mdHolder.getGateOwner(entity.getLocation().getWorld().getName(), "west");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((WestGateOwner != 0) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "west", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((WestGateOwner != 1) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "west", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((WestGateOwner != 2) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "west", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((WestGateOwner != 3) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "west", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else if(entity.getLocation().getChunk().getX() >= 12){//East Moving Mob
            //System.out.println("X 12 Z 0");
            int EastGateOwner = plugin.mdHolder.getGateOwner(entity.getLocation().getWorld().getName(), "east");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((EastGateOwner != 0) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "east", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((EastGateOwner != 1) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "east", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((EastGateOwner != 2) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "east", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((EastGateOwner != 3) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "east", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else{
            
        }
        
        if((entity.getLocation().getChunk().getX() == 0) && (entity.getLocation().getChunk().getZ() == 0)){//Center Mob
            //System.out.println("X 0 Y 0");
            int CenterGateOwner = plugin.mdHolder.getGateOwner(entity.getLocation().getWorld().getName(), "center");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((CenterGateOwner != 0) && (CenterGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "center");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "center", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "center", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((CenterGateOwner != 1) && (CenterGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "center");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "center", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "center", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((CenterGateOwner != 2) && (CenterGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "center");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "center", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "center", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((CenterGateOwner != 3) && (CenterGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(entity.getLocation().getWorld().getName(), "center");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(entity.getLocation().getWorld().getName(), "center", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(entity.getLocation().getWorld().getName(), "center", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }
    }
    
    public void handleNSPathDeaths(LivingEntity entity, String TownN, String TownS) {
        if(entity.getLocation().getChunk().getZ() <= -12){//North Moving Mob
            int NorthGateOwner = plugin.mdHolder.getGateOwner(TownN, "south");
            switch(entity.getType()){
                case ZOMBIE:
                    {
                        if((NorthGateOwner != 0) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(TownN, "south");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(TownN, "south", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(TownN, "south", newGateHp);
                            }
                        }
                    }break;
                case SKELETON:
                    {
                        if((NorthGateOwner != 1) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(TownN, "south");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(TownN, "south", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(TownN, "south", newGateHp);
                            }
                        }
                    }break;
                case CREEPER:
                    {
                        if((NorthGateOwner != 2) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(TownN, "south");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(TownN, "south", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(TownN, "south", newGateHp);
                            }
                        }
                    }break;
                case SPIDER:
                    {
                        if((NorthGateOwner != 3) && (NorthGateOwner != 4)){
                            int NorthGateHp = plugin.mdHolder.getGateHP(TownN, "south");
                            int newGateHp = NorthGateHp - 1;
                            if(newGateHp <= 0){
                                plugin.mdHolder.setGateOwner(TownN, "south", 4, 500);
                            }else{

                                plugin.mdHolder.setGateHP(TownN, "south", newGateHp);
                            }
                        }
                    }break;
                default:
                {

                }break;
            }
        }else if(entity.getLocation().getChunk().getZ() >= 12){//South Moving Mob
            int SouthGateOwner = plugin.mdHolder.getGateOwner(TownS, "north");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(TownS, "north");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownS, "north", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownS, "north", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((SouthGateOwner != 1) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(TownS, "north");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownS, "north", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownS, "north", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((SouthGateOwner != 2) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(TownS, "north");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownS, "north", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownS, "north", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((SouthGateOwner != 3) && (SouthGateOwner != 4)){
                        int SouthGateHp = plugin.mdHolder.getGateHP(TownS, "north");
                        int newGateHp = SouthGateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownS, "north", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownS, "north", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else{
            
        }
    }
    
    public void handleWEPathDeaths(LivingEntity entity, String TownW, String TownE) {
        if(entity.getLocation().getChunk().getX() <= -12){//West Moving Mob
            int WestGateOwner = plugin.mdHolder.getGateOwner(TownW, "east");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((WestGateOwner != 0) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownW, "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownW, "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownW, "east", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((WestGateOwner != 1) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownW, "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownW, "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownW, "east", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((WestGateOwner != 2) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownW, "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownW, "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownW, "east", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((WestGateOwner != 3) && (WestGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownW, "east");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownW, "east", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownW, "east", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else if(entity.getLocation().getChunk().getX() >= 12){//East Moving Mob
            int EastGateOwner = plugin.mdHolder.getGateOwner(TownE, "west");
            switch(entity.getType()){
                case ZOMBIE:
                {
                    if((EastGateOwner != 0) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownE, "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownE, "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownE, "west", newGateHp);
                        }
                    }
                }break;
                case SKELETON:
                {
                    if((EastGateOwner != 1) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownE, "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownE, "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownE, "west", newGateHp);
                        }
                    }
                }break;
                case CREEPER:
                {
                    if((EastGateOwner != 2) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownE, "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownE, "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownE, "west", newGateHp);
                        }
                    }
                }break;
                case SPIDER:
                {
                    if((EastGateOwner != 3) && (EastGateOwner != 4)){
                        int GateHp = plugin.mdHolder.getGateHP(TownE, "west");
                        int newGateHp = GateHp - 1;
                        if(newGateHp <= 0){
                            plugin.mdHolder.setGateOwner(TownE, "west", 4, 500);
                        }else{

                            plugin.mdHolder.setGateHP(TownE, "west", newGateHp);
                        }
                    }
                }break;
                default:
                {
                    
                }break;
            }
        }else{
            
        }
    }
    
    public void HandleCreatureDeath(EntityDeathEvent event) {//Sting worldName, Location DiedAt
        switch(event.getEntity().getLocation().getWorld().getName()){
            
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "11":
            {
                
                handleTownDeaths(event.getEntity());
            }break;
            case "12":
            {
                handleWEPathDeaths(event.getEntity(), "3", "4");
            }break;
            case "13":
            {
                handleWEPathDeaths(event.getEntity(), "4", "0");
            }break;
            case "14":
            {
                handleWEPathDeaths(event.getEntity(), "0", "5");
            }break;
            case "15":
            {
                handleWEPathDeaths(event.getEntity(), "5", "1");
            }break;
            case "16":
            {
                handleWEPathDeaths(event.getEntity(), "1", "6");
            }break;
            case "17":
            {
                handleWEPathDeaths(event.getEntity(), "6", "2");
            }break;
            case "18":
            {
                handleWEPathDeaths(event.getEntity(), "2", "7");
            }break;
            case "19":
            {
                handleWEPathDeaths(event.getEntity(), "7", "3");
            }break;
            
            
            
            
            case "20":
            {
                handleNSPathDeaths(event.getEntity(), "3", "11");
            }break;
            case "21":
            {
                handleNSPathDeaths(event.getEntity(), "11", "0");
            }break;
            case "22":
            {
                handleNSPathDeaths(event.getEntity(), "0", "8");
            }break;
            case "23":
            {
                handleNSPathDeaths(event.getEntity(), "8", "2");
            }break;
            case "24":
            {
                handleNSPathDeaths(event.getEntity(), "2", "10");
            }break;
            case "25":
            {
                handleNSPathDeaths(event.getEntity(), "10", "1");
            }break;
            case "26":
            {
                handleNSPathDeaths(event.getEntity(), "1", "9");
            }break;
            case "27":
            {
                handleNSPathDeaths(event.getEntity(), "9", "3");
            }break;
            default:
            {
                
            }break;

        }
        //handleTownDeaths(event.getEntity() );
        
        
        /*
        //System.out.println(event.getEntity().getLocation().getWorld().getName());
        if(!(event.getEntity().getLastDamageCause() == null)){
            Location mobDeath = event.getEntity().getLocation();
            switch(mobDeath.getWorld().getName()){
                case "0":
                    {
                        if(mobDeath.getChunk().getZ() < -11){
                            //System.out.println("chunk is < -11");
                            switch(event.getEntityType()){
                                case ZOMBIE:
                                {
                                    //System.out.println("Zombie");
                                    int NorthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "north");
                                    if((NorthGateOwner != 0) && (NorthGateOwner != 4)){
                                        int NorthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "north");
                                        int newGateHp = NorthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "north", 4, 500);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "north", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case SKELETON:
                                {
                                    //System.out.println("Zombie");
                                    int NorthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "north");
                                    if((NorthGateOwner != 1) && (NorthGateOwner != 4)){
                                        int NorthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "north");
                                        int newGateHp = NorthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "north", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "north", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case CREEPER:
                                {
                                    //System.out.println("Zombie");
                                    int NorthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "north");
                                    if((NorthGateOwner != 2) && (NorthGateOwner != 4)){
                                        int NorthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "north");
                                        int newGateHp = NorthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "north", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "north", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case SPIDER:
                                {
                                    //System.out.println("Zombie");
                                    int NorthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "north");
                                    if((NorthGateOwner != 3) && (NorthGateOwner != 4)){
                                        int NorthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "north");
                                        int newGateHp = NorthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "north", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "north", newGateHp);
                                        }
                                    }
                                }break;
                                default:
                                {
                                    //System.out.println("default EntityType called " + event.getEntityType().getName());
                                }break;
                            }
                        }else if(mobDeath.getChunk().getZ() > 11){
                            //System.out.println("chunk is < -11");
                            switch(event.getEntityType()){
                                case ZOMBIE:
                                {
                                    //System.out.println("Zombie");
                                    int SouthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "south");
                                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                                        int SouthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "south");
                                        int newGateHp = SouthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "south", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "south", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case SKELETON:
                                {
                                    //System.out.println("Zombie");
                                    int SouthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "south");
                                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                                        int SouthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "south");
                                        int newGateHp = SouthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "south", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "south", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case CREEPER:
                                {
                                    //System.out.println("Zombie");
                                    int SouthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "south");
                                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                                        int SouthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "south");
                                        int newGateHp = SouthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "south", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "south", newGateHp);
                                        }
                                    }
                                }break;
                                
                                case SPIDER:
                                {
                                    //System.out.println("Zombie");
                                    int SouthGateOwner = plugin.mdHolder.getGateOwner(mobDeath.getWorld().getName(), "south");
                                    if((SouthGateOwner != 0) && (SouthGateOwner != 4)){
                                        int SouthGateHp = plugin.mdHolder.getGateHP(mobDeath.getWorld().getName(), "south");
                                        int newGateHp = SouthGateHp - 1;
                                        if(newGateHp <= 0){
                                            plugin.mdHolder.setGateOwner(mobDeath.getWorld().getName(), "south", 4, 5);
                                        }else{
                                            
                                            plugin.mdHolder.setGateHP(mobDeath.getWorld().getName(), "south", newGateHp);
                                        }
                                    }
                                }break;
                                default:
                                {
                                    //System.out.println("default EntityType called " + event.getEntityType().getName());
                                }break;
                            }
                        }else{
                            System.out.println("chunk is !< -11" + mobDeath.getChunk().getX());
                        }
                        
                    }break;
                default:
                    {
                        System.out.println(event.getEntity().getLocation().getWorld().getName());
                    }break;
            }
        }*/
    }
    
    public void MobMove(World world, List<Entity> entityList){        
        NorthGateCount = 0;
        SouthGateCount = 0;
        WestGateCount = 0;
        EastGateCount = 0;
        NorthMidGateCount = 0;
        SouthMidGateCount = 0;
        WestMidGateCount = 0;
        EastMidGateCount = 0;
        
        switch (world.getName()) {
            case "0":
            case "1":
            case "2":
            case "3"://towns
                {
                    NorthPoint.setWorld(world);
                    SouthPoint.setWorld(world);
                    WestPoint.setWorld(world);
                    EastPoint.setWorld(world);
                    NorthMidPoint.setWorld(world);
                    SouthMidPoint.setWorld(world);
                    WestMidPoint.setWorld(world);
                    EastMidPoint.setWorld(world);
                    for (Entity entity : entityList) {
                        //System.out.println("TP X: " + entity.getLocation().getBlockX()+" Y: " + entity.getLocation().getBlockY()+" Z: " + entity.getLocation().getBlockZ());
                        if(entity != null){
                            if(CenterGateOwner == 0){
                                if(entity instanceof Zombie){
                                    if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                        
                                        if(plugin.mdHolder.MobList.containsKey(entity.getUniqueId())){
                                            //System.out.println("Here I am! X: " + plugin.mdHolder.MobList.get(entity.getUniqueId()).getStartingGate().getBlockX());
                                            plugin.mdHolder.MobList.get(entity.getUniqueId()).MoveMob(entity);
                                            
//                                            if(((Zombie) entity).getTarget() == null){
//                                                //System.out.println("Target nothing");
//                                            }else{
//                                                System.out.println("Target something");
//                                            }
//                                            
//                                            if( ((Zombie) entity).getTargetBlock(null, 100) == null ){
//                                                //System.out.println("Target block");
//                                            }else{
//                                                System.out.println("Target block" + ((Zombie) entity).getTargetBlock(null, 100).getType().name());
//                                                
//                                            }
                                            //entity.setVelocity(plugin.mdHolder.MobList.get(entity.getUniqueId()).getDirection());
                                            if(plugin.mdHolder.MobList.get(entity.getUniqueId()).compairStartGate(NorthMidPoint)){
                                                NorthMidGateCount++;
                                            }
                                        }
                                        

                                        entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 0){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 0, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }                                            
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }
                                        
                                    }else if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;

                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 0){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 0, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                        
                                    }else if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());
                                        
                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 0){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 0, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 0){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 0, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                        
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 1){
                                if(entity instanceof Skeleton){
                                    if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                             if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 1){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                System.out.println(gateHP);
                                                
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 1, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }
                                    }else if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;
                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthMidPoint.getDirection());
                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 1){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 1, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 1){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 1, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());


                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 1){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 1, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 2){
                                if(entity instanceof Creeper){
                                    if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                             if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 2){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                System.out.println(gateHP);
                                                
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 2, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }
                                    }else if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;
                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthMidPoint.getDirection());
                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 2){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 2, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 2){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 2, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 2){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 2, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 3){
                                if(entity instanceof Spider){
                                    if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                             if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 3){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                System.out.println(gateHP);
                                                
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 3, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }
                                    }else if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;
                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthMidPoint.getDirection());
                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 3){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 3, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }

                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 3){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 3, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 3){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 3, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else{

                            }




                            if(!(CenterGateOwner == NorthGateOwner)){
                                if(NorthGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());
                                            
                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    entity.teleport(NorthMidPoint);
                                                    ((Zombie) entity).setRemainingAir(1);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            }
                                            
                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    entity.teleport(NorthMidPoint);
                                                    ((Skeleton) entity).setRemainingAir(1);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            }
                                            
                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    entity.teleport(NorthMidPoint);
                                                    ((Creeper) entity).setRemainingAir(1);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            }
                                            
                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    entity.teleport(NorthMidPoint);
                                                    ((Spider) entity).setRemainingAir(1);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            }
                                            
                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }
                            }

                            
                            
                            
                            if(!(CenterGateOwner == SouthGateOwner)){
                                if(SouthGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    entity.teleport(SouthMidPoint);
                                                    ((Zombie) entity).setRemainingAir(2);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    entity.teleport(SouthMidPoint);
                                                    ((Skeleton) entity).setRemainingAir(2);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    entity.teleport(SouthMidPoint);
                                                    ((Creeper) entity).setRemainingAir(2);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    entity.teleport(SouthMidPoint);
                                                    ((Spider) entity).setRemainingAir(2);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }
                            }

                            if(!(CenterGateOwner == WestGateOwner)){
                                if(WestGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    entity.teleport(WestMidPoint);
                                                    ((Zombie) entity).setRemainingAir(3);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    entity.teleport(WestMidPoint);
                                                    ((Skeleton) entity).setRemainingAir(3);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    entity.teleport(WestMidPoint);
                                                    ((Creeper) entity).setRemainingAir(3);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    entity.teleport(WestMidPoint);
                                                    ((Spider) entity).setRemainingAir(3);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }
                            }

                            if(!(CenterGateOwner == EastGateOwner)){
                                if(EastGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    entity.teleport(EastMidPoint);
                                                    ((Zombie) entity).setRemainingAir(4);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    entity.teleport(EastMidPoint);
                                                    ((Skeleton) entity).setRemainingAir(4);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    entity.teleport(EastMidPoint);
                                                    ((Creeper) entity).setRemainingAir(4);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    entity.teleport(EastMidPoint);
                                                    ((Creeper) entity).setRemainingAir(4);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }break;
            case "4":
            case "5":
            case "6":
            case "7"://West to East
                {
                    WestPoint.setWorld(world);
                    EastPoint.setWorld(world);
                    WestMidPoint.setWorld(world);
                    EastMidPoint.setWorld(world);
                    for (Entity entity : entityList) {
                        //System.out.println("TP X: " + entity.getLocation().getBlockX()+" Y: " + entity.getLocation().getBlockY()+" Z: " + entity.getLocation().getBlockZ());
                        if(entity != null){
                            if(CenterGateOwner == 0){
                                if(entity instanceof Zombie){
                                    if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 0){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 0, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 0){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 0, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 1){
                                if(entity instanceof Skeleton){
                                    if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 1){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 1, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 1){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 1, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 2){
                                if(entity instanceof Creeper){
                                    if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 2){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 2, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 2){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 2, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 3){
                                if(entity instanceof Spider){
                                    if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                        WestMidGateCount++;
                                        entity.setVelocity(WestVector);
                                        entity.getLocation().setDirection(WestMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "west") == 0){
                                                entity.teleport(WestMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "west");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "west", 3, 5);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "west", gateHP);
                                                    entity.teleport(WestMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(WestMidPoint);
                                        }
                                    }else if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                        EastMidGateCount++;
                                        entity.setVelocity(EastVector);
                                        entity.getLocation().setDirection(EastMidPoint.getDirection());

                                        if(entity.getLocation().getChunk().getX() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "east") == 0){
                                                entity.teleport(EastMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "east");
                                                gateHP--;
                                                //System.out.println(gateHP);

                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "east", 3, 5);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "east", gateHP);
                                                    entity.teleport(EastMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getZ() != 0){
                                            entity.teleport(EastMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else{

                            }

                            if(!(CenterGateOwner == WestGateOwner)){
                                if(WestGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    ((Zombie) entity).setRemainingAir(3);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    ((Skeleton) entity).setRemainingAir(3);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    ((Creeper) entity).setRemainingAir(3);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }else if(WestGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                            WestGateCount++;
                                            entity.setVelocity(EastVector);
                                            entity.getLocation().setDirection(WestMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    ((Spider) entity).setRemainingAir(3);
                                                    entity.teleport(WestMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(WestPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(WestPoint);
                                            }
                                        }
                                    }
                                }
                            }

                            if(!(CenterGateOwner == EastGateOwner)){
                                if(EastGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    ((Zombie) entity).setRemainingAir(4);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    ((Skeleton) entity).setRemainingAir(4);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    ((Creeper) entity).setRemainingAir(4);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }else if(EastGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                            EastGateCount++;
                                            entity.setVelocity(WestVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    ((Spider) entity).setRemainingAir(4);
                                                    entity.teleport(EastMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(EastPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getZ() != 0){
                                                entity.teleport(EastPoint);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }break;
            case "8":
            case "9":
            case "10":
            case "11"://North to South
                {
                    NorthPoint.setWorld(world);
                    SouthPoint.setWorld(world);
                    NorthMidPoint.setWorld(world);
                    SouthMidPoint.setWorld(world);
                    for (Entity entity : entityList) {
                        //System.out.println("TP X: " + entity.getLocation().getBlockX()+" Y: " + entity.getLocation().getBlockY()+" Z: " + entity.getLocation().getBlockZ());
                        if(entity != null){
                            if(CenterGateOwner == 0){
                                if(entity instanceof Zombie){
                                    if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 0){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 0, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }

                                    }else if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;

                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 0){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 0, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 1){
                                if(entity instanceof Skeleton){
                                    if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 1){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 1, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }

                                    }else if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;

                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 1){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 1, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 2){
                                if(entity instanceof Creeper){
                                    if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 2){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 2, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }

                                    }else if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;

                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 2){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 2, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else if(CenterGateOwner == 3){
                                if(entity instanceof Spider){
                                    if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                        NorthMidGateCount++;
                                        entity.setVelocity(NorthVector);
                                        entity.getLocation().setDirection(NorthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() < -12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "north") == 3){
                                                entity.teleport(NorthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "north");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "north", 3, 5);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "north", gateHP);
                                                    entity.teleport(NorthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(NorthMidPoint);
                                        }

                                    }else if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                        SouthMidGateCount++;

                                        entity.setVelocity(SouthVector);
                                        entity.getLocation().setDirection(SouthPoint.getDirection());

                                        if(entity.getLocation().getChunk().getZ() > 12){
                                            if(plugin.mdHolder.getGateOwner(world.getName(), "south") == 3){
                                                entity.teleport(SouthMidPoint);
                                            }else{
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "south");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "south", 3, 5);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "south", gateHP);
                                                    entity.teleport(SouthMidPoint);
                                                }
                                            }
                                        }
                                        
                                        if(entity.getLocation().getChunk().getX() != 0){
                                            entity.teleport(SouthMidPoint);
                                        }
                                    }else{
                                        entity.remove();
                                    }
                                }
                            }else{

                            }

                            if(!(CenterGateOwner == NorthGateOwner)){
                                if(NorthGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    ((Zombie) entity).setRemainingAir(1);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    ((Skeleton) entity).setRemainingAir(1);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    ((Creeper) entity).setRemainingAir(1);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }else if(NorthGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                            NorthGateCount++;
                                            entity.setVelocity(SouthVector);
                                            entity.getLocation().setDirection(NorthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    ((Spider) entity).setRemainingAir(1);
                                                    entity.teleport(NorthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(NorthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(NorthPoint);
                                            }
                                        }
                                    }
                                }
                            }

                            if(!(CenterGateOwner == SouthGateOwner)){
                                if(SouthGateOwner == 0){
                                    if(entity instanceof Zombie){
                                        if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 5);
                                                    ((Zombie) entity).setRemainingAir(2);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 1){
                                    if(entity instanceof Skeleton){
                                        if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 1, 5);
                                                    ((Skeleton) entity).setRemainingAir(2);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 2){
                                    if(entity instanceof Creeper){
                                        if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 2, 5);
                                                    ((Creeper) entity).setRemainingAir(2);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }else if(SouthGateOwner == 3){
                                    if(entity instanceof Spider){
                                        if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                            SouthGateCount++;
                                            entity.setVelocity(NorthVector);
                                            entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                            if((entity.getLocation().getChunk().getZ() == 0) && (entity.getLocation().getChunk().getX() == 0)){
                                                int gateHP = plugin.mdHolder.getGateHP(world.getName(), "center");
                                                gateHP--;
                                                //System.out.println(gateHP);
                                                if(gateHP <= 0){
                                                    plugin.mdHolder.setGateOwner(world.getName(), "center", 3, 5);
                                                    ((Spider) entity).setRemainingAir(2);
                                                    entity.teleport(SouthMidPoint);
                                                }else{
                                                    plugin.mdHolder.setGateHP(world.getName(), "center", gateHP);
                                                    entity.teleport(SouthPoint);
                                                }
                                            } 

                                            if(entity.getLocation().getChunk().getX() != 0){
                                                entity.teleport(SouthPoint);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }break;
            case "12":
                {
                    handleWEPathMove(world, entityList, "3", "4");
                }break;
            case "13":
                {
                    handleWEPathMove(world, entityList, "4", "0");
                }break;
            case "14":
                {
                    handleWEPathMove(world, entityList, "0", "5");
                }break;
            case "15":
                {
                    handleWEPathMove(world, entityList, "5", "1");
                }break;
            case "16":
                {
                    handleWEPathMove(world, entityList, "1", "6");
                }break;
            case "17":
                {
                    handleWEPathMove(world, entityList, "6", "2");
                }break;
            case "18":
                {
                    handleWEPathMove(world, entityList, "2", "7");
                }break;
            case "19":
                {
                    handleWEPathMove(world, entityList, "7", "3");
                }break;
                //West to East pathways End
                
                //North to South Pathways Start
            case "20":
                {
                    handleNSPathMove(world, entityList, "3", "11");
                }break;
            case "21":
                {
                    handleNSPathMove(world, entityList, "11", "0");
                }break;
            case "22":
                {
                    handleNSPathMove(world, entityList, "0", "8");
                }break;
            case "23":
                {
                    handleNSPathMove(world, entityList, "8", "2");
                }break;
            case "24":
                {
                    handleNSPathMove(world, entityList, "2", "10");
                }break;
            case "25":
                {
                    handleNSPathMove(world, entityList, "10", "1");
                }break;
            case "26":
                {
                    handleNSPathMove(world, entityList, "1", "9");
                }break;
            case "27"://North to South pathways
                {
                    handleNSPathMove(world, entityList, "9", "3");
                }break;
            default:
            {
            }break;
        }
    }
    
    public void handleWEPathMove(World world, List<Entity> entityList, String TownW, String TownE){
        WestPathPoint.setWorld(world);
        EastPathPoint.setWorld(world);

        WestGateOwner = plugin.mdHolder.getGateOwner(TownW,"east");
        EastGateOwner = plugin.mdHolder.getGateOwner(TownE,"west");

        for (Entity entity : entityList) {
            if(entity != null){
                if(WestGateOwner == EastGateOwner){
                    if(plugin.mdHolder.getGateOwner(TownW,"center") == EastGateOwner){
                        //Spawn a mob to path in the east direction.
                        if(WestGateOwner == 0){
                            if(entity instanceof Zombie){
                                if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                    WestGateCount++;
                                    entity.setVelocity(EastVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                        entity.teleport(WestPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(WestPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(WestGateOwner == 1){
                            if(entity instanceof Skeleton){
                                if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                    WestGateCount++;
                                    entity.setVelocity(EastVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                        entity.teleport(WestPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(WestPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(WestGateOwner == 2){
                            if(entity instanceof Creeper){
                                if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                    WestGateCount++;
                                    entity.setVelocity(EastVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                        entity.teleport(WestPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(WestPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(WestGateOwner == 3){
                            if(entity instanceof Spider){
                                if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                    WestGateCount++;
                                    entity.setVelocity(EastVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                        entity.teleport(WestPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(WestPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else{
                            entity.remove();
                        }

                    }else if(plugin.mdHolder.getGateOwner(TownE,"center") == WestGateOwner){
                        //Spawn a mob to path in the west direction.
                        if(EastGateOwner == 0){
                            if(entity instanceof Zombie){
                                if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                    EastGateCount++;
                                    entity.setVelocity(WestVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                        entity.teleport(EastPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(EastPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(EastGateOwner == 1){
                            if(entity instanceof Skeleton){
                                if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                    EastGateCount++;
                                    entity.setVelocity(WestVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                        entity.teleport(EastPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(EastPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(EastGateOwner == 2){
                            if(entity instanceof Creeper){
                                if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                    EastGateCount++;
                                    entity.setVelocity(WestVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                        entity.teleport(EastPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(EastPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(EastGateOwner == 3){
                            if(entity instanceof Spider){
                                if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                    EastGateCount++;
                                    entity.setVelocity(WestVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                        entity.teleport(EastPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getZ() != 0){
                                        entity.teleport(EastPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else{
                            entity.remove();
                        }
                    }else{
                        //Probably don't even need this else statment but I'm going to keep it just incase.
                        entity.remove();
                    }
                }else{
                    //Spawn the different mobs to path
                    if(WestGateOwner == 0){
                        if(entity instanceof Zombie){
                            if(((Zombie) entity).getMaximumAir() == 4){//East Moving
                                WestGateCount++;
                                entity.setVelocity(EastVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                    
                                    int gateHP = plugin.mdHolder.getGateHP(TownE, "west");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownE, "west", 0, 5);
                                        entity.teleport(WestPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownE, "west", gateHP);
                                        entity.teleport(WestPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(WestPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(WestGateOwner == 1){
                        if(entity instanceof Skeleton){
                            if(((Skeleton) entity).getMaximumAir() == 4){//East Moving
                                WestGateCount++;
                                entity.setVelocity(EastVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownE, "west");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownE, "west", 1, 5);
                                        entity.teleport(WestPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownE, "west", gateHP);
                                        entity.teleport(WestPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(WestPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(WestGateOwner == 2){
                        if(entity instanceof Creeper){
                            if(((Creeper) entity).getMaximumAir() == 4){//East Moving
                                WestGateCount++;
                                entity.setVelocity(EastVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownE, "west");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownE, "west", 2, 5);
                                        entity.teleport(WestPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownE, "west", gateHP);
                                        entity.teleport(WestPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(WestPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(WestGateOwner == 3){
                        if(entity instanceof Spider){
                            if(((Spider) entity).getMaximumAir() == 4){//East Moving
                                WestGateCount++;
                                entity.setVelocity(EastVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (EastPathPoint.getChunk().getX() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownE, "west");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownE, "west", 3, 5);
                                        entity.teleport(WestPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownE, "west", gateHP);
                                        entity.teleport(WestPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(WestPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else{
                        entity.remove();
                    }

                    if(EastGateOwner == 0){
                        if(entity instanceof Zombie){
                            if(((Zombie) entity).getMaximumAir() == 3){//West Moving
                                EastGateCount++;
                                entity.setVelocity(WestVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownW, "east");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownW, "east", 0, 5);
                                        entity.teleport(EastPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownW, "east", gateHP);
                                        entity.teleport(EastPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(EastPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(EastGateOwner == 1){
                        if(entity instanceof Skeleton){
                            if(((Skeleton) entity).getMaximumAir() == 3){//West Moving
                                EastGateCount++;
                                entity.setVelocity(WestVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownW, "east");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownW, "east", 1, 5);
                                        
                                        entity.teleport(EastPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownW, "east", gateHP);
                                        entity.teleport(EastPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(EastPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(EastGateOwner == 2){
                        if(entity instanceof Creeper){
                            if(((Creeper) entity).getMaximumAir() == 3){//West Moving
                                EastGateCount++;
                                entity.setVelocity(WestVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownW, "east");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownW, "east", 2, 5);
                                        
                                        entity.teleport(EastPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownW, "east", gateHP);
                                        entity.teleport(EastPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(EastPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(EastGateOwner == 3){
                        if(entity instanceof Spider){
                            if(((Spider) entity).getMaximumAir() == 3){//West Moving
                                EastGateCount++;
                                entity.setVelocity(WestVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getX() == (WestPathPoint.getChunk().getX() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(TownW, "east");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(TownW, "east", 3, 5);
                                        
                                        entity.teleport(EastPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(TownW, "east", gateHP);
                                        entity.teleport(EastPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getZ() != 0){
                                    entity.teleport(EastPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else{
                        entity.remove();
                    }
                }
            }
        }
    }
    
    
    public void handleNSPathMove(World world, List<Entity> entityList, String Town1, String Town2){
        NorthPathPoint.setWorld(world);
        SouthPathPoint.setWorld(world);

        NorthGateOwner = plugin.mdHolder.getGateOwner(Town1,"south");
        SouthGateOwner = plugin.mdHolder.getGateOwner(Town2,"north");

        for (Entity entity : entityList) {
            if(entity != null){
                if(NorthGateOwner == SouthGateOwner){
                    if(plugin.mdHolder.getGateOwner(Town1,"center") == SouthGateOwner){
                        //Spawn a mob to path in the east direction.
                        if(NorthGateOwner == 0){
                            if(entity instanceof Zombie){
                                if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                    NorthGateCount++;
                                    entity.setVelocity(SouthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                        entity.teleport(NorthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(NorthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(NorthGateOwner == 1){
                            if(entity instanceof Skeleton){
                                if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                    NorthGateCount++;
                                    entity.setVelocity(SouthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                        entity.teleport(NorthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(NorthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(NorthGateOwner == 2){
                            if(entity instanceof Creeper){
                                if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                    NorthGateCount++;
                                    entity.setVelocity(SouthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                        entity.teleport(NorthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(NorthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(NorthGateOwner == 3){
                            if(entity instanceof Spider){
                                if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                    NorthGateCount++;
                                    entity.setVelocity(SouthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                        entity.teleport(NorthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(NorthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else{
                            entity.remove();
                        }

                    }else if(plugin.mdHolder.getGateOwner(Town2,"center") == NorthGateOwner){
                        //Spawn a mob to path in the west direction.
                        if(SouthGateOwner == 0){
                            if(entity instanceof Zombie){
                                if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                    SouthGateCount++;
                                    entity.setVelocity(NorthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                        entity.teleport(SouthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(SouthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(SouthGateOwner == 1){
                            if(entity instanceof Skeleton){
                                if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                    SouthGateCount++;
                                    entity.setVelocity(NorthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                        entity.teleport(SouthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(SouthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(SouthGateOwner == 2){
                            if(entity instanceof Creeper){
                                if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                    SouthGateCount++;
                                    entity.setVelocity(NorthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                        entity.teleport(SouthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(SouthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else if(SouthGateOwner == 3){
                            if(entity instanceof Spider){
                                if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                    SouthGateCount++;
                                    entity.setVelocity(NorthVector);
                                    //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                    if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                        entity.teleport(SouthPathPoint);
                                    } 

                                    if(entity.getLocation().getChunk().getX() != 0){
                                        entity.teleport(SouthPathPoint);
                                    }
                                }else{
                                    entity.remove();
                                }
                            }
                        }else{
                            entity.remove();
                        }
                    }else{
                        //Probably don't even need this else statment but I'm going to keep it just incase.
                        entity.remove();
                    }
                }else{
                    //Spawn the different mobs to path
                    if(NorthGateOwner == 0){
                        if(entity instanceof Zombie){
                            if(((Zombie) entity).getMaximumAir() == 2){//South Moving
                                NorthGateCount++;
                                entity.setVelocity(SouthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town2, "north");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town2, "north", 0, 5);
                                        entity.teleport(NorthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town2, "north", gateHP);
                                        entity.teleport(NorthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(NorthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(NorthGateOwner == 1){
                        if(entity instanceof Skeleton){
                            if(((Skeleton) entity).getMaximumAir() == 2){//South Moving
                                NorthGateCount++;
                                entity.setVelocity(SouthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town2, "north");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town2, "north", 1, 5);
                                        entity.teleport(NorthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town2, "north", gateHP);
                                        entity.teleport(NorthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(NorthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(NorthGateOwner == 2){
                        if(entity instanceof Creeper){
                            if(((Creeper) entity).getMaximumAir() == 2){//South Moving
                                NorthGateCount++;
                                entity.setVelocity(SouthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town2, "north");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town2, "north", 2, 5);
                                        entity.teleport(NorthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town2, "north", gateHP);
                                        entity.teleport(NorthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(NorthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(NorthGateOwner == 3){
                        if(entity instanceof Spider){
                            if(((Spider) entity).getMaximumAir() == 2){//South Moving
                                NorthGateCount++;
                                entity.setVelocity(SouthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (SouthPathPoint.getChunk().getZ() + 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town2, "north");
                                    gateHP--;
                                    //System.out.println(gateHP);
                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town2, "north", 3, 5);
                                        entity.teleport(NorthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town2, "north", gateHP);
                                        entity.teleport(NorthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(NorthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else{
                        entity.remove();
                    }
                    
                    if(SouthGateOwner == 0){
                        if(entity instanceof Zombie){
                            if(((Zombie) entity).getMaximumAir() == 1){//North Moving
                                SouthGateCount++;
                                entity.setVelocity(NorthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town1, "south");
                                    gateHP--;
                                    System.out.println(gateHP);

                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town1, "south", 0, 5);
                                        entity.teleport(SouthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town1, "south", gateHP);
                                        entity.teleport(SouthPathPoint);
                                    }
                                }
                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(SouthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(SouthGateOwner == 1){
                        if(entity instanceof Skeleton){
                            if(((Skeleton) entity).getMaximumAir() == 1){//North Moving
                                SouthGateCount++;
                                entity.setVelocity(NorthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town1, "south");
                                    gateHP--;
                                    System.out.println(gateHP);

                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town1, "south", 1, 5);
                                        entity.teleport(SouthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town1, "south", gateHP);
                                        entity.teleport(SouthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(SouthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(SouthGateOwner == 2){
                        if(entity instanceof Creeper){
                            if(((Creeper) entity).getMaximumAir() == 1){//North Moving
                                SouthGateCount++;
                                entity.setVelocity(NorthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town1, "south");
                                    gateHP--;
                                    System.out.println(gateHP);

                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town1, "south", 2, 5);
                                        entity.teleport(SouthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town1, "south", gateHP);
                                        entity.teleport(SouthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(SouthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else if(SouthGateOwner == 3){
                        if(entity instanceof Spider){
                            if(((Spider) entity).getMaximumAir() == 1){//North Moving
                                SouthGateCount++;
                                entity.setVelocity(NorthVector);
                                //entity.getLocation().setDirection(SouthMidPoint.getDirection());

                                if((entity.getLocation().getChunk().getZ() == (NorthPathPoint.getChunk().getZ() - 1))){
                                    int gateHP = plugin.mdHolder.getGateHP(Town1, "south");
                                    gateHP--;
                                    System.out.println(gateHP);

                                    if(gateHP <= 0){
                                        plugin.mdHolder.setGateOwner(Town1, "south", 3, 5);
                                        entity.teleport(SouthPathPoint);
                                    }else{
                                        plugin.mdHolder.setGateHP(Town1, "south", gateHP);
                                        entity.teleport(SouthPathPoint);
                                    }
                                } 

                                if(entity.getLocation().getChunk().getX() != 0){
                                    entity.teleport(SouthPathPoint);
                                }
                            }else{
                                entity.remove();
                            }
                        }
                    }else{
                        entity.remove();
                    }
                }
            }
        }      
    }
    
    public void setEntityLocation(LivingEntity entity, Location location){
        entity.getLocation().setX(location.getX());
        entity.getLocation().setY(location.getY());
        entity.getLocation().setZ(location.getZ());
        entity.getLocation().setPitch(location.getPitch());
        entity.getLocation().setYaw(location.getYaw());
        
        entity.setRemoveWhenFarAway(false);
    }
    
    public boolean HandleCreatureSpawn(CreatureSpawnEvent event){
        
        NorthPoint.setWorld(event.getLocation().getWorld());
        SouthPoint.setWorld(event.getLocation().getWorld());
        WestPoint.setWorld(event.getLocation().getWorld());
        EastPoint.setWorld(event.getLocation().getWorld());
        NorthMidPoint.setWorld(event.getLocation().getWorld());
        SouthMidPoint.setWorld(event.getLocation().getWorld());
        WestMidPoint.setWorld(event.getLocation().getWorld());
        EastMidPoint.setWorld(event.getLocation().getWorld());
        switch (event.getLocation().getWorld().getName()) {
            case "0":
            case "1":
            case "2":
            case "3"://towns
                {
                    NorthPoint.setWorld(event.getLocation().getWorld());
                    SouthPoint.setWorld(event.getLocation().getWorld());
                    WestPoint.setWorld(event.getLocation().getWorld());
                    EastPoint.setWorld(event.getLocation().getWorld());
                    NorthMidPoint.setWorld(event.getLocation().getWorld());
                    SouthMidPoint.setWorld(event.getLocation().getWorld());
                    WestMidPoint.setWorld(event.getLocation().getWorld());
                    EastMidPoint.setWorld(event.getLocation().getWorld());
                
                    CenterGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"center");
                    NorthGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"north");
                    SouthGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"south");
                    WestGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"west");
                    EastGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"east");
                    switch(CenterGateOwner){
                        case 0:
                            {
                                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        
                                        //event.getEntity().setAI(false);
                                        if(!(plugin.mdHolder.MobList.containsKey(event.getEntity().getUniqueId()))){
                                            plugin.mdHolder.MobList.put(event.getEntity().getUniqueId(), new Mobs(NorthMidPoint, NorthVector));
                                        }
                                        return(false);

                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        if(!(plugin.mdHolder.MobList.containsKey(event.getEntity().getUniqueId()))){
                                            plugin.mdHolder.MobList.put(event.getEntity().getUniqueId(), new Mobs(SouthMidPoint, SouthVector));
                                        }
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        if(!(plugin.mdHolder.MobList.containsKey(event.getEntity().getUniqueId()))){
                                            plugin.mdHolder.MobList.put(event.getEntity().getUniqueId(), new Mobs(WestMidPoint, WestVector));
                                        }
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        if(!(plugin.mdHolder.MobList.containsKey(event.getEntity().getUniqueId()))){
                                            plugin.mdHolder.MobList.put(event.getEntity().getUniqueId(), new Mobs(EastMidPoint, EastVector));
                                        }
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 1:
                            {
                                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 2:
                            {
                                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 3:
                            {
                                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        default:
                        {

                        }break;
                    }
                    
                    if(!(CenterGateOwner == NorthGateOwner)){
                        if(NorthGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }

                    if(!(CenterGateOwner == SouthGateOwner)){
                        if(SouthGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);

                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }

                    if(!(CenterGateOwner == WestGateOwner)){
                        if(WestGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }

                    if(!(CenterGateOwner == EastGateOwner)){
                        if(EastGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);

                                    return(false);
                                }
                            }
                        }else{

                        }
                    }
                }break;
            case "4":
            case "5":
            case "6":
            case "7"://West to East
                {
                    WestPoint.setWorld(event.getLocation().getWorld());
                    EastPoint.setWorld(event.getLocation().getWorld());
                    WestMidPoint.setWorld(event.getLocation().getWorld());
                    EastMidPoint.setWorld(event.getLocation().getWorld());
                
                    CenterGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"center");
                    WestGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"west");
                    EastGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"east");
                    switch(plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"center")){
                        case 0:
                            {
                                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                    if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 1:
                            {
                                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                    if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 2:
                            {
                                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                    if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 3:
                            {
                                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                    if(WestMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), WestMidPoint);
                                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go. 3 == west
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(EastMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), EastMidPoint);
                                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go. 4 == east
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        default:
                        {

                        }break;
                    }

                    if(!(CenterGateOwner == WestGateOwner)){
                        if(WestGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(WestGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(WestGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), WestPoint);
                                    event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }

                    if(!(CenterGateOwner == EastGateOwner)){
                        if(EastGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(EastGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(EastGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), EastPoint);
                                    event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }
                }break;
            case "8":
            case "9":
            case "10":
            case "11"://North to South
                {
                    NorthPoint.setWorld(event.getLocation().getWorld());
                    SouthPoint.setWorld(event.getLocation().getWorld());
                    NorthMidPoint.setWorld(event.getLocation().getWorld());
                    SouthMidPoint.setWorld(event.getLocation().getWorld());
                
                    CenterGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"center");
                    NorthGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"north");
                    SouthGateOwner = plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"south");
                    switch(plugin.mdHolder.getGateOwner(event.getLocation().getWorld().getName(),"center")){
                        case 0:
                            {
                                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 1:
                            {
                                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 2:
                            {
                                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        case 3:
                            {
                                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                    if(NorthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), NorthMidPoint);
                                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go. 1 == north
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else if(SouthMidGateCount <= 5 ){
                                        setEntityLocation(event.getEntity(), SouthMidPoint);
                                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go. 2 == south
                                        event.getEntity().setRemoveWhenFarAway(false);
                                        //event.getEntity().setAI(false);
                                        return(false);
                                    }else{
                                        return(true);
                                    }
                                }
                            }break;
                        default:
                        {

                        }break;
                    }      

                    if(!(CenterGateOwner == NorthGateOwner)){
                        if(NorthGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(NorthGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(NorthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), NorthPoint);
                                    event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }

                    }

                    if(!(CenterGateOwner == SouthGateOwner)){
                        if(SouthGateOwner == 0){
                            if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 1){
                            if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    //event.getEntity().setAI(false);
                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 2){
                            if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else if(SouthGateOwner == 3){
                            if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                                if(SouthGateCount <= 5 ){
                                    setEntityLocation(event.getEntity(), SouthPoint);
                                    event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                                    event.getEntity().setRemoveWhenFarAway(false);
                                    return(false);
                                }
                            }
                        }else{

                        }
                    }
                }break;
                //Start of West to East Pathways
            case "12":
                {
                    if(!(handleWEMobSpawns(event, "3", "4"))){
                        return(false);
                    }
                }break;
            case "13":
                {
                    if(!(handleWEMobSpawns(event, "4", "0"))){
                        return(false);
                    }
                }break;
            case "14":
                {
                    if(!(handleWEMobSpawns(event, "0", "5"))){
                        return(false);
                    }
                }break;
            case "15":
                {
                    if(!(handleWEMobSpawns(event, "5", "1"))){
                        return(false);
                    }
                }break;
            case "16":
                {
                    if(!(handleWEMobSpawns(event, "1", "6"))){
                        return(false);
                    }
                }break;
            case "17":
                {
                    if(!(handleWEMobSpawns(event, "6", "2"))){
                        return(false);
                    }
                }break;
            case "18":
                {
                    if(!(handleWEMobSpawns(event, "2", "7"))){
                        return(false);
                    }
                }break;
            case "19":
                {
                    if(!(handleWEMobSpawns(event, "7", "3"))){
                        return(false);
                    }
                }break;
                //West to East pathways
            case "20":
                {
                    if(!(handleNSMobSpawns(event, "3", "11"))){
                        return(false);
                    }
                }break;
            case "21":
                {
                    if(!(handleNSMobSpawns(event, "11", "0"))){
                        return(false);
                    }
                }break;
            case "22":
                {
                    if(!(handleNSMobSpawns(event, "0", "8"))){
                        return(false);
                    }
                }break;
            case "23":
                {
                    if(!(handleNSMobSpawns(event, "8", "2"))){
                        return(false);
                    }
                }break;
            case "24":
                {
                    if(!(handleNSMobSpawns(event, "2", "10"))){
                        return(false);
                    }
                }break;
            case "25":
                {
                    if(!(handleNSMobSpawns(event, "10", "1"))){
                        return(false);
                    }
                }break;
            case "26":
                {
                    if(!(handleNSMobSpawns(event, "1", "9"))){
                        return(false);
                    }
                }break;
            case "27"://North to South pathways
                {
                    if(!(handleNSMobSpawns(event, "9", "3"))){
                        return(false);
                    }
                }break;
            case "28":
                {
                    return(true);
                }
            default:
                { 

                }break;
        }
        return(true);
    }
    
    public boolean handleWEMobSpawns(CreatureSpawnEvent event, String TownW, String TownE){
        WestPathPoint.setWorld(event.getLocation().getWorld());
        EastPathPoint.setWorld(event.getLocation().getWorld());
        WestGateOwner = plugin.mdHolder.getGateOwner(TownW,"east");
        EastGateOwner = plugin.mdHolder.getGateOwner(TownE,"west");

        if(WestGateOwner == EastGateOwner){
            if(plugin.mdHolder.getGateOwner(TownW,"center") == EastGateOwner){
                //Spawn a mob to path in the east direction.
                if(WestGateOwner == 0){
                    if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                        if(WestGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), WestPathPoint);
                            event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(WestGateOwner == 1){
                    if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                        if(WestGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), WestPathPoint);
                            event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            //event.getEntity().setAI(false);
                            return(false);
                        }
                    }
                }else if(WestGateOwner == 2){
                    if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                        if(WestGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), WestPathPoint);
                            event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(WestGateOwner == 3){
                    if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                        if(WestGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), WestPathPoint);
                            event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else{

                }
            }else if(plugin.mdHolder.getGateOwner(TownE,"center") == WestGateOwner){
                //Spawn a mob to path in the west direction.
                if(EastGateOwner == 0){
                    if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                        if(EastGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), EastPathPoint);
                            event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(EastGateOwner == 1){
                    if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                        if(EastGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), EastPathPoint);
                            event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            //event.getEntity().setAI(false);
                            return(false);
                        }
                    }
                }else if(EastGateOwner == 2){
                    if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                        if(EastGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), EastPathPoint);
                            event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(EastGateOwner == 3){
                    if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                        if(EastGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), EastPathPoint);
                            event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else{

                }
            }else{
                //Probably don't even need this else statment but I'm going to keep it just incase.
            }
        }else{
            //Spawn the different mobs to path
            if(WestGateOwner == 0){
                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                    if(WestGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), WestPathPoint);
                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(WestGateOwner == 1){
                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                    if(WestGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), WestPathPoint);
                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        //event.getEntity().setAI(false);
                        return(false);
                    }
                }
            }else if(WestGateOwner == 2){
                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                    if(WestGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), WestPathPoint);
                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(WestGateOwner == 3){
                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                    if(WestGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), WestPathPoint);
                        event.getEntity().setMaximumAir(4);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else{

            }

            if(EastGateOwner == 0){
                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                    if(EastGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), EastPathPoint);
                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(EastGateOwner == 1){
                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                    if(EastGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), EastPathPoint);
                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        //event.getEntity().setAI(false);
                        return(false);
                    }
                }
            }else if(EastGateOwner == 2){
                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                    if(EastGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), EastPathPoint);
                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(EastGateOwner == 3){
                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                    if(EastGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), EastPathPoint);
                        event.getEntity().setMaximumAir(3);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else{

            }
        }
        return(true);
    }
    
    public boolean handleNSMobSpawns(CreatureSpawnEvent event, String TownN, String TownS){
        NorthPathPoint.setWorld(event.getLocation().getWorld());
        SouthPathPoint.setWorld(event.getLocation().getWorld());
        NorthGateOwner = plugin.mdHolder.getGateOwner(TownN,"south");
        SouthGateOwner = plugin.mdHolder.getGateOwner(TownS,"north");

        if(NorthGateOwner == SouthGateOwner){
            if(plugin.mdHolder.getGateOwner(TownN,"center") == SouthGateOwner){
                //Spawn a mob to path in the east direction.
                if(NorthGateOwner == 0){
                    if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                        if(NorthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), NorthPathPoint);
                            event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(NorthGateOwner == 1){
                    if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                        if(NorthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), NorthPathPoint);
                            event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            //event.getEntity().setAI(false);
                            return(false);
                        }
                    }
                }else if(NorthGateOwner == 2){
                    if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                        if(NorthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), NorthPathPoint);
                            event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(NorthGateOwner == 3){
                    if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                        if(NorthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), NorthPathPoint);
                            event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else{

                }
            }else if(plugin.mdHolder.getGateOwner(TownS,"center") == NorthGateOwner){
                //Spawn a mob to path in the west direction.
                if(SouthGateOwner == 0){
                    if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                        if(SouthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), SouthPathPoint);
                            event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(SouthGateOwner == 1){
                    if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                        if(SouthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), SouthPathPoint);
                            event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            //event.getEntity().setAI(false);
                            return(false);
                        }
                    }
                }else if(SouthGateOwner == 2){
                    if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                        if(SouthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), SouthPathPoint);
                            event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else if(SouthGateOwner == 3){
                    if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                        if(SouthGateCount <= 5 ){
                            setEntityLocation(event.getEntity(), SouthPathPoint);
                            event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                            event.getEntity().setRemoveWhenFarAway(false);
                            return(false);
                        }
                    }
                }else{

                }
            }else{
                //Probably don't even need this else statment but I'm going to keep it just incase.
            }
        }else{
            //Spawn the different mobs to path
            if(NorthGateOwner == 0){
                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                    if(NorthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), NorthPathPoint);
                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(NorthGateOwner == 1){
                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                    if(NorthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), NorthPathPoint);
                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        //event.getEntity().setAI(false);
                        return(false);
                    }
                }
            }else if(NorthGateOwner == 2){
                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                    if(NorthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), NorthPathPoint);
                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(NorthGateOwner == 3){
                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                    if(NorthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), NorthPathPoint);
                        event.getEntity().setMaximumAir(2);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else{

            }

            if(SouthGateOwner == 0){
                if (event.getEntityType().compareTo(EntityType.ZOMBIE) == 0) {
                    if(SouthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), SouthPathPoint);
                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(SouthGateOwner == 1){
                if (event.getEntityType().compareTo(EntityType.SKELETON) == 0) {
                    if(SouthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), SouthPathPoint);
                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        //event.getEntity().setAI(false);
                        return(false);
                    }
                }
            }else if(SouthGateOwner == 2){
                if (event.getEntityType().compareTo(EntityType.CREEPER) == 0) {
                    if(SouthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), SouthPathPoint);
                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else if(SouthGateOwner == 3){
                if (event.getEntityType().compareTo(EntityType.SPIDER) == 0) {
                    if(SouthGateCount <= 5 ){
                        setEntityLocation(event.getEntity(), SouthPathPoint);
                        event.getEntity().setMaximumAir(1);                           //Going to use this to figure out what direction the mobs need to go.
                        event.getEntity().setRemoveWhenFarAway(false);
                        return(false);
                    }
                }
            }else{

            }
        }
        return(true);
    }

    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
