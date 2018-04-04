package guy.guysgaming.main.mobevents.pathfindergoals;

import net.minecraft.server.v1_12_R1.DamageSource;
import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.Navigation;
import net.minecraft.server.v1_12_R1.PathEntity;
import net.minecraft.server.v1_12_R1.PathfinderGoal;
import org.bukkit.Location;

public class PathfinderGoalMoveWest extends PathfinderGoal{
   
   private float speed;
   private EntityInsentient entity;
   private Location loc;
   private Navigation navigation;

    public PathfinderGoalMoveWest(EntityInsentient entity, Location loc, float speed) {
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
        
        if(tempZ > 30.0f){
            tempZ = 30.0f;
        }
        
        if(tempY > 30.0f){
            tempY = 30.0f;
        }
        
        if(tempX < -10.0f){
            tempX = entity.locX - 10.0f;
        }else{
            tempX = loc.getX();
        }
        //System.out.println("tx: " + tempX + " ty: " + tempY + " tz: " + tempZ + " ex: " + entity.locX + " ey: " + entity.locY + " ez: " + entity.locZ);
        PathEntity pathEntity = this.navigation.a(tempX, loc.getY(), loc.getZ());
        this.navigation.a(pathEntity, speed);
        if( ( ((int)entity.locX - 1) <= (int)loc.getX() ) && ( (int)entity.locZ == (int)loc.getZ() ) ){
            entity.damageEntity(DamageSource.MAGIC, 100.0F);
        }
    }
}
