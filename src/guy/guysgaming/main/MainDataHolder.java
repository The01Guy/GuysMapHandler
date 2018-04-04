package guy.guysgaming.main;


import guy.guysgaming.main.mobevents.mobs.Mobs;
import guy.guysgaming.mini.Arguments;
import guy.guysgaming.mini.Mini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Guy
 */
public class MainDataHolder {
    
    MapMain plugin;
    //Holds the Team owner for the gates in each world.
    public int WorldGateOwners[][] = new int[28][5];   //World[world#][gate#] = Owner;
    //Holds the amount of life that is left for the gate.
    public int WorldGateHp[][] = new int[28][5];   //World[world#][gate#] = HP;
    
    //Holds the score of each world
    //public int worldScore[] = new int[28];
    //Holds the ID of each player
    
    public Mini PlayerTeams;
    
    public HashMap<String, Integer> playerID = new HashMap<>();
    //Holds each player and what team they are on.
    public HashMap<String, Integer> playerTeam = new HashMap<String, Integer>();
    //Holds players score
    public HashMap<String, Integer> playerScore = new HashMap<String, Integer>();
    //Holds players online status
    public HashMap<String, Boolean> playerOnline = new HashMap<String, Boolean>();
    //Holds the worlds number to match for the name
    public HashMap<String, String> worldName = new HashMap<>();
    
    public Map<UUID, Mobs> MobList = new HashMap<UUID, Mobs>();
    
    public Map<String, Mini> worldDB = new HashMap<String, Mini>();
    
    
    
    public MainDataHolder(MapMain instance){
        plugin = instance;
        PlayerTeams = new Mini(plugin.getDataFolder().getPath() + "/player", "teams.mini");
    }
    
    public void setPlayerTeam(String PlayerName, String team){
        if(PlayerTeams.hasIndex(PlayerName)){
            PlayerTeams.setArgument(PlayerName, "team", team, true);
        }else{
            Arguments playerTeamEntry = new Arguments(PlayerName);
            playerTeamEntry.setValue("team", team);
            PlayerTeams.addIndex(playerTeamEntry.getKey(), playerTeamEntry);
            PlayerTeams.update();
        }
    }
    
    
    
    
    public void addDB(String worldName) {
        if (!worldDB.containsKey(worldName)) {
            
            worldDB.put(worldName, new Mini(plugin.getDataFolder().getPath() + "/World", worldName + ".mini"));
        } else {
            return;
        }
    }

    public Mini getDB(String worldName) {
        if (worldDB.containsKey(worldName)) {
            return worldDB.get(worldName);
        } else {
            addDB(worldName);
            return worldDB.get(worldName);
        }
    }

    public void removeDB(String worldName) {
        if (worldDB.containsKey(worldName)) {
            worldDB.remove(worldName);
        } else {
            return;
        }
    }
    
    
    
    
    
    
    
    public void setGateOwner(String worldName, String gate, int NewOwner, int HP){
        if(worldDB.containsKey(worldName)){
            if(worldDB.get(worldName).hasIndex(gate)){
                
                worldDB.get(worldName).setArgument(gate, "owner", Integer.toString(NewOwner), true);
                worldDB.get(worldName).setArgument(gate, "hp", Integer.toString(HP), true);
            }else{
                Arguments worldGateEntry = new Arguments(gate);
                worldGateEntry.setValue("owner", Integer.toString(NewOwner));
                worldGateEntry.setValue("hp", Integer.toString(HP));
                worldDB.get(worldName).addIndex(worldGateEntry.getKey(), worldGateEntry);
                worldDB.get(worldName).update();
            }
        }
    }
    
    public int getGateOwner(String worldName, String gate){
        if(worldDB.containsKey(worldName)){
            //System.out.println("DB contians Key" + worldName);
            if(worldDB.get(worldName).hasIndex(gate)){
                //System.out.println("DB hadIndex" + gate);
                int result = worldDB.get(worldName).getArguments(gate).getInteger("owner");
                return(result);
            }else{
                Arguments playerEntry = new Arguments(gate);
                playerEntry.setValue("owner", "4");
                playerEntry.setValue("hp", "25");
                worldDB.get(gate).addIndex(playerEntry.getKey(), playerEntry);
                worldDB.get(gate).update();
                return 4;
            }
        }else{
            plugin.mdHolder.addDB(worldName);
        }
        return(0);
    }
    
    public void setGateHP(String worldName, String gate, int hp){
        worldDB.get(worldName).setArgument(gate, "hp", Integer.toString(hp), true);
    }
    
    public int getGateHP(String worldName, String gate){
        return worldDB.get(worldName).getArguments(gate).getInteger("hp");
    }
    
    
    
    
    
    
    
    
    
    public void onStart(){
        /*
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM team");
            if(rs.next()){
                teamScore[0] = rs.getInt("team0");
                teamScore[1] = rs.getInt("team1");
                teamScore[2] = rs.getInt("team2");
                teamScore[3] = rs.getInt("team3");
                System.out.println("MainDataHolder.onStart()");
            } else{
                System.out.println("else statement reached in MainDataHolder.onStart(). DB 'team' is empty");
            }
            rs = st.executeQuery("SELECT * FROM worldowner");
            if(rs.next()){
                for(int i = 0;i<28;i++){
                    worldOwner[i] = rs.getInt("w"+i);
                }
            } else{
                System.out.println("else statement reached in MainDataHolder.onStart(). DB 'worldowner' is empty");
            }
            rs = st.executeQuery("SELECT * FROM worldscore");
            if(rs.next()){
                for(int i = 0;i<28;i++){
                    worldScore[i] = rs.getInt("w"+i);
                }
            } else{
                System.out.println("else statement reached in MainDataHolder.onStart(). DB 'worldscore' is empty");
            }
            rs = st.executeQuery("SELECT * FROM player");
            while(rs.next()){
                String playerName = rs.getString("playerName");
                int id = rs.getInt("id");
                int team = rs.getInt("team");
                int score = rs.getInt("score");
                
                playerID.put(playerName, id);
                playerTeam.put(playerName, team);
                playerScore.put(playerName, score);
            }
            rs = st.executeQuery("SELECT * FROM worldname");
            while(rs.next()){
                worldName.put("" + rs.getInt("id"), rs.getString("name"));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }
    
    public void onStop(){
       /* try{
            st = conn.createStatement();
            int team0 = st.executeUpdate("UPDATE team SET team0='" + teamScore[0] + "'");
            int team1 = st.executeUpdate("UPDATE team SET team1='" + teamScore[1] + "'");
            int team2 = st.executeUpdate("UPDATE team SET team2='" + teamScore[2] + "'");
            int team3 = st.executeUpdate("UPDATE team SET team3='" + teamScore[3] + "'");
            int worldOwnerSet = st.executeUpdate("UPDATE worldowner SET w0='0', w1='1', w2='2', w3='3', "
                    + "w4='"+ worldOwner[4] + "', w5='"+ worldOwner[5] + "', w6='" + worldOwner[6] + "', "
                    + "w7='"+ worldOwner[7] + "', w8='"+ worldOwner[8] + "', w9='" + worldOwner[9] + "', "
                    + "w10='"+ worldOwner[10] + "', w11='"+ worldOwner[11] + "', w12='" + worldOwner[12] + "',"
                    + "w13='"+ worldOwner[13] + "', w14='"+ worldOwner[14] + "', w15='" + worldOwner[15] + "',"
                    + "w16='"+ worldOwner[16] + "', w17='"+ worldOwner[17] + "', w18='" + worldOwner[18] + "',"
                    + "w19='"+ worldOwner[19] + "', w20='"+ worldOwner[20] + "', w21='" + worldOwner[21] + "',"
                    + "w22='"+ worldOwner[22] + "', w23='"+ worldOwner[23] + "', w24='" + worldOwner[24] + "',"
                    + "w25='"+ worldOwner[25] + "', w26='"+ worldOwner[26] + "', w27='" + worldOwner[27] + "'");
            int worldScoreSet = st.executeUpdate("UPDATE worldscore SET w0='0', w1='0', w2='0', w3='0', "
                    + "w4='"+ worldScore[4] + "', w5='"+ worldScore[5] + "', w6='" + worldScore[6] + "', "
                    + "w7='"+ worldScore[7] + "', w8='"+ worldScore[8] + "', w9='" + worldScore[9] + "', "
                    + "w10='"+ worldScore[10] + "', w11='"+ worldScore[11] + "', w12='" + worldScore[12] + "',"
                    + "w13='"+ worldScore[13] + "', w14='"+ worldScore[14] + "', w15='" + worldScore[15] + "',"
                    + "w16='"+ worldScore[16] + "', w17='"+ worldScore[17] + "', w18='" + worldScore[18] + "',"
                    + "w19='"+ worldScore[19] + "', w20='"+ worldScore[20] + "', w21='" + worldScore[21] + "',"
                    + "w22='"+ worldScore[22] + "', w23='"+ worldScore[23] + "', w24='" + worldScore[24] + "',"
                    + "w25='"+ worldScore[25] + "', w26='"+ worldScore[26] + "', w27='" + worldScore[27] + "'");
            for(String e : playerID.keySet()){
                System.out.println(e);
                int playerId = playerID.get(e);
                int tempPlayerTeam = playerTeam.get(e);
                int tempPlayerScore = playerScore.get(e);
                int setPlayerData = st.executeUpdate("UPDATE player SET team='" + tempPlayerTeam + "', score='" + tempPlayerScore + "' WHERE id='" + playerId + "'");
            }
        }catch(Exception e){
            e.printStackTrace();  //TODO: Use local storage if a database can't be connected to.
        }*/
    }
    
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conn = DriverManager.getConnection("jdbc:mysql://192.168.1.135:3388/minecraft", "MinecraftServer", "serverminecraft");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public Connection getConnection() {
        try {
            if (conn.isValid(10)) {
                return conn;
            } else {
                System.out.println("Else statement reached in getConnection()");
                connect();
                if (conn.isValid(10)) {
                    return conn;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MapMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Error in getConnection(). No connection established.");
        return null;
    }

    public void dissconnect() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(MapMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/    
    
}
/*
 * This class is going to hold either all the data or the holders for the data needed
 * Assumed data needed:
 * - World owners  -- w0 w1 w2 w3 w4
 *   * individual owner or team owned  --  w0 = 0 w1 = 1 w2 = 2 w3 = 3 w4 = -1(unowned)
 *   * list of players the owner has allowed to build in thier world.  string or playerIDs seperated by "/"
 *   * Score cost to buy the world from a player or team.(setup a way for players to sell a world they own) Might change to a weekly upkeep. If unpaid it goes back to unowned.
 *   * Player given names of each world.
 * = Players id+4, score, x, y, z, and the world they are in.
 * - Players home chest inventory
 * - size of the players home world.
 * - Towns shared nether chest inventory
 */