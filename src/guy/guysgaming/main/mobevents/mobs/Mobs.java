package guy.guysgaming.main.mobevents.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class Mobs {
    
    Vector MovingDirection;
    Location StartingLocation;
    boolean Attacking = false;
    
    int TeamID;
    Location EndGate;

    public Mobs(){
        this.StartingLocation = null;
        this.MovingDirection = null;
    }
    
    public Mobs(Location StartingGate, Vector MovingDirection) {
        this.StartingLocation = StartingGate;
        this.MovingDirection = MovingDirection;
    }
        
    public Vector getDirection(){
        return(MovingDirection);
    }
    
    public Location getStartingGate(){
        return(StartingLocation);
    }
    
    public Location getEndingGate(){
        return(EndGate);
    }
    
    public boolean compairStartGate(Location gate){
        if( (StartingLocation.getBlockX() == gate.getBlockX()) && (StartingLocation.getBlockY() == gate.getBlockY()) && (StartingLocation.getBlockZ() == gate.getBlockZ()) ){
            return(true);
        }else{
            return(false);
        }
    }
    
    public void MoveMob(Entity entity){
        entity.setVelocity(new Vector());
        entity.setVelocity(MovingDirection);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
