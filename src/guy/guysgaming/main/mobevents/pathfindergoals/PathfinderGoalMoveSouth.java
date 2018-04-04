package guy.guysgaming.main.mobevents.pathfindergoals;

import net.minecraft.server.v1_12_R1.DamageSource;
import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.Navigation;
import net.minecraft.server.v1_12_R1.PathEntity;
import net.minecraft.server.v1_12_R1.PathfinderGoal;
import org.bukkit.Location;

public class PathfinderGoalMoveSouth extends PathfinderGoal{
   
   private float speed;
   private EntityInsentient entity;
   private Location loc;
   private Navigation navigation;

    public PathfinderGoalMoveSouth(EntityInsentient entity, Location loc, float speed) {
        this.entity = entity;
        this.loc = loc;
        this.navigation = (Navigation) this.entity.getNavigation();
        this.speed = speed;
    }

   @Override
    public boolean a() {
        if(entity.getGoalTarget() != null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void c() {
        
        double tempX = loc.getX() - entity.locX;
        double tempY = loc.getY() - entity.locY;
        double tempZ = loc.getZ() - entity.locZ;
        
        if(tempX > 30.0f){
            tempX = 30.0f;
        }
        
        if(tempY > 30.0f){
            tempY = 30.0f;
        }
        
        if(tempZ > 10.0f){
            tempZ = entity.locZ + 10.0f;
        }else{
            tempZ = loc.getZ();
        }
        
        PathEntity pathEntity = this.navigation.a(loc.getX(), loc.getY(), tempZ);
        this.navigation.a(pathEntity, speed);
        if(((int)entity.locX == (int)loc.getX()) && ((int)(entity.locZ + 1) == (int)loc.getZ())){
            entity.damageEntity(DamageSource.MAGIC, 100.0F);
        }
    }
}