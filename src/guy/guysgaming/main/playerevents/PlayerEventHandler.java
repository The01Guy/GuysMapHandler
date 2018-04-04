package guy.guysgaming.main.playerevents;

import guy.guysgaming.main.MapMain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Guy
 */
public class PlayerEventHandler {

    MapMain plugin;
    Connection conn;
    Statement st;
    ResultSet rs;
    boolean HasDataBase = false;

    
    public PlayerEventHandler(MapMain instance, Connection connect, boolean hasDataBase) {
        plugin = instance;
        if(hasDataBase) {
            this.conn = connect;
            HasDataBase = hasDataBase;
        } else {
            HasDataBase = hasDataBase;
            this.conn = null;
        }
    }

    //Adds players team to the database
    public void playerTeamAdd(String pName, int team) {
        if(HasDataBase){
            try {
                int pTeam = st.executeUpdate("UPDATE player SET team='" + team + "' WHERE playerName='" + pName + "'");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            plugin.mdHolder.setPlayerTeam(pName, Integer.toString(team));
        }
    }

    public void handleLogin(PlayerLoginEvent event){
        
    }
    
    public void handleJoin(PlayerJoinEvent event, MapMain plugin) {
        if (!(playerHasTableCheck(event.getPlayer().getName()))) {
            playerTableAdd(event.getPlayer().getName());
        }
        PlayerWorldJoin(event.getPlayer());
        System.out.println(event.getPlayer().getWorld().getName());
    }

    public void handleQuit(String playerName) {

    }
    
    //Checks to see if a player is already in the database
    public boolean playerHasTableCheck(String pName) {
        if(HasDataBase){
            try {
                st = conn.createStatement();
                rs = st.executeQuery("SELECT playerName FROM player WHERE playerName='" + pName + "'");
                if (rs.next()) {
                    return true;

                } else {
                    return false;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
        return false;
    }
    
    //Puts players into the database
    public void playerTableAdd(String pName) {
        if(HasDataBase){
            try {
                int pAdd = st.executeUpdate("INSERT INTO player(playerName) VALUES('" + pName + "')");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public int getPlayerTeam(String pName) {
        if(HasDataBase){
            try {
                st = conn.createStatement();
                rs = st.executeQuery("SELECT team FROM player WHERE playerName='" + pName + "'");
                if (rs.next()) {
                    int team = rs.getInt("team");
                    return team;
                } else {
                    return 6;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return 6;
        }else{
            if(plugin.mdHolder.PlayerTeams.hasIndex(pName)){
                int result = plugin.mdHolder.PlayerTeams.getArguments(pName).getInteger("team");
                return(result);
            }else{
                return(5);
            }
        }
    }

    public void PlayerWorldJoin(Player player) {
        switch (getPlayerTeam(player.getName())) {
            case 0:
                if (Bukkit.getServer().getWorld("0") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("0"));
                }
                player.teleport(new Location(Bukkit.getWorld("0"), 8, 65, -50, (float) 0, (float) -44));
                break;
            case 1:
                if (Bukkit.getServer().getWorld("1") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("1"));
                }
                player.teleport(new Location(Bukkit.getWorld("1"), 8, 65, -50, (float) 0, (float) -44));
                break;
            case 2:
                if (Bukkit.getServer().getWorld("2") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("2"));
                }
                player.teleport(new Location(Bukkit.getWorld("2"), 8, 65, -50, (float) 0, (float) -44));
                break;
            case 3:
                if (Bukkit.getServer().getWorld("3") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("3"));
                }
                player.teleport(new Location(Bukkit.getWorld("3"), 8, 65, -50, (float) 0, (float) -44));
                break;
            default:
                if (Bukkit.getServer().getWorld("28") == null) {
                    Bukkit.getServer().createWorld(new WorldCreator("28"));
                }
                player.teleport(new Location(Bukkit.getWorld("28"), 8, 65, 8, (float) 179, (float) 2));
                break;
        }
    }
    
    public void unloadWorld(String world){
        if(Bukkit.getWorld(world).getPlayers().isEmpty())
        {
            Bukkit.getServer().unloadWorld(world, true);
        }
    }
    
    public void handleMove(Player player, Location to, Location from) {
        switch (player.getWorld().getName()) {
            case "0":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                    break;
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("21") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("21"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("21"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("22") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("22"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("22"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//west
                    if (Bukkit.getServer().getWorld("13") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("13"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("13"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("14") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("14"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("14"), -110, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                    break;
                }
                break;
            case "1":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                    break;
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("25") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("25"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("25"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("26") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("26"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("26"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//west
                    if (Bukkit.getServer().getWorld("15") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("15"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("15"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("16") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("16"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("16"), -110, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                    break;
                }
                break;
            case "2":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                    break;
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("23") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("23"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("23"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("24") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("24"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("24"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//west
                    if (Bukkit.getServer().getWorld("17") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("17"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("17"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("18") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("18"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("18"), -110, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                    break;
                }
                break;
            case "3":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                    break;
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("27") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("27"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("27"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("20") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("20"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("20"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//west
                    if (Bukkit.getServer().getWorld("19") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("19"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("19"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("12") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("12"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("12"), -110, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                    break;
                }
                break;
            //End of towns

            //Start West to East villages
            case "4":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                    break;
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//weat
                    if (Bukkit.getServer().getWorld("12") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("12"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("12"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//East
                    if (Bukkit.getServer().getWorld("13") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("13"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("13"), -109, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                    break;
                }
                
                break;
            case "5":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//weat
                    if (Bukkit.getServer().getWorld("14") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("14"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("14"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//East
                    if (Bukkit.getServer().getWorld("15") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("15"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("15"), -109, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;

            case "6":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//weat
                    if (Bukkit.getServer().getWorld("16") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("16"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("16"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//East
                    if (Bukkit.getServer().getWorld("17") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("17"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("17"), -109, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;
            case "7":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//weat
                    if (Bukkit.getServer().getWorld("18") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("18"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("18"), 125, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//East
                    if (Bukkit.getServer().getWorld("19") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("19"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("19"), -109, 65, 8, (float) -90, (float) 3));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;
            //End of west to east +

            //Start of North to South Villages
            case "8":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("22") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("22"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("22"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("23") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("23"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("23"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;
            case "9":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("26") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("26"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("26"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("27") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("27"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("27"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;
            case "10":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("24") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("24"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("24"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("25") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("25"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("25"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 410, 250, -332, (float) 0, (float) 0));
                } else {
                }
                break;
            case "11":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("20") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("20"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("20"), 8, 65, 125, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("21") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("21"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("21"), 8, 65, -110, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 0) {
                    //player.teleport(new Location(Bukkit.getWorld("guys"), 353, 72, -126, (float) -56, (float) 11));
                }
                break;
            //end of North and south +

            //Start of West to East Paths
            case "12":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("3") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("3"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("3"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("4") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("4"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("4"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "13":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("4") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("4"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("4"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("0") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("0"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("0"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "14":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("0") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("0"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("0"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("5") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("5"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("5"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "15":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("5") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("5"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("5"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("1") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("1"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("1"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "16":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("1") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("1"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("1"), 205, 65, -119, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("6") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("6"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("6"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "17":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("6") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("6"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("6"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("2") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("2"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("2"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "18":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("2") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("2"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("2"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("7") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("7"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("7"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            case "19":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == -13 && to.getChunk().getZ() == 0) {//West
                    if (Bukkit.getServer().getWorld("7") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("7"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("7"), 205, 65, 8, (float) 90, (float) 1));
                } else if (to.getChunk().getX() == 13 && to.getChunk().getZ() == 0) {//east
                    if (Bukkit.getServer().getWorld("3") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("3"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("3"), -190, 65, 8, (float) -90, (float) 3));
                } else {
                }
                break;
            //End of West to East pathways

            //Start of North to South Paths
            case "20":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("3") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("3"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("3"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("11") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("11"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("11"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "21":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("11") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("11"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("11"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("0") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("0"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("0"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "22":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("0") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("0"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("0"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("8") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("8"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("8"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "23":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("8") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("8"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("8"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("2") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("2"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("2"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "24":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("2") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("2"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("2"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("10") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("10"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("10"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "25":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("10") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("10"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("10"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("1") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("1"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("1"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "26":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("1") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("1"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("1"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("9") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("9"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("9"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            case "27":
                if ((to.getChunk().getX() != 0 && to.getChunk().getZ() == -13)
                        || (to.getChunk().getX() != 0 && to.getChunk().getZ() == 13)
                        || (to.getChunk().getX() == -13 && to.getChunk().getZ() != 0)
                        || (to.getChunk().getX() == 13 && to.getChunk().getZ() != 0)) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -13) {//north
                    if (Bukkit.getServer().getWorld("9") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("9"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("9"), 8, 65, 205, (float) 179, (float) 2));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 13) {//south
                    if (Bukkit.getServer().getWorld("3") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("3"));
                    }
                    player.teleport(new Location(Bukkit.getWorld("3"), 8, 65, -190, (float) 0, (float) 0));
                } else {
                }
                break;
            //End of North to South pathways

            case "28":
                //TODO: set players team here and teleport them to the right town
                if (to.getChunk().getX() == -4 || to.getChunk().getX() == 4 || to.getChunk().getZ() == -4
                        || to.getChunk().getZ() == 4) {
                    player.teleport(from);
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == -3) { //Lapis
                    playerTeamAdd(player.getName(), 0);
                    if (Bukkit.getServer().getWorld("0") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("0"));
                    }
                    plugin.mdHolder.setPlayerTeam(player.getName(), "0");
                    player.teleport(new Location(Bukkit.getWorld("0"), 8, 65, -50, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -2 && to.getChunk().getZ() == -1) { //Gold
                    playerTeamAdd(player.getName(), 1);
                    if (Bukkit.getServer().getWorld("1") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("1"));
                    }
                    plugin.mdHolder.setPlayerTeam(player.getName(), "1");
                    player.teleport(new Location(Bukkit.getWorld("1"), 8, 65, -50, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == -2 && to.getChunk().getZ() == 1) {//white
                    playerTeamAdd(player.getName(), 2);
                    if (Bukkit.getServer().getWorld("2") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("2"));
                    }
                    plugin.mdHolder.setPlayerTeam(player.getName(), "2");
                    player.getPlayer().teleport(new Location(Bukkit.getWorld("2"), 8, 65, -50, (float) 0, (float) 0));
                } else if (to.getChunk().getX() == 0 && to.getChunk().getZ() == 3) {//Diamond
                    playerTeamAdd(player.getName(), 3);
                    if (Bukkit.getServer().getWorld("3") == null) {
                        Bukkit.getServer().createWorld(new WorldCreator("3"));
                    }
                    plugin.mdHolder.setPlayerTeam(player.getName(), "3");
                    player.teleport(new Location(Bukkit.getWorld("3"), 8, 65, -50, (float) 0, (float) 0));
                } else {
                }
                break;
            case "guys":
                
                //TODO: Setup a system of portals to the other worlds.
                if (to.getChunk().getZ() == -26) {
                    player.teleport(new Location(Bukkit.getWorld("0"), -167, 65, -167, (float) 0, (float) -44));
                }
                break;
            default:
                break;
        }
        //unloadWorld(from.getWorld().getName());
    }
}
/*
 * Create methods that accept only info needed.
 * 
 * Handle player move events
 *     - Block players from moving outside of the maps
 *     - Teleport players when they get to the set locations on the map
 * Handle player login
 *     - Get the player information from the database and set it in the Plugins
 * Handle player join 
 *     - Use the info from login to set the player in the right world at the right pos with pitch and yaw
 * Handle player quitting
 *     - Save the players info in the database; (world, x, y, z, pitch, yaw)
 */
