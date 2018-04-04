package guy.guysgaming.main.mobevents.mobs.spider;

import guy.guysgaming.main.mobevents.mobs.MobUtil;
import guy.guysgaming.main.mobevents.pathfindergoals.PathfinderGoalMoveWest;
import java.util.LinkedHashSet;
import net.minecraft.server.v1_12_R1.EntityCreeper;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.EntitySkeleton;
import net.minecraft.server.v1_12_R1.EntitySpider;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_12_R1.PathfinderGoalLeapAtTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_12_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.Location;

public class CustomSpiderWest extends EntitySpider {
   
    private static CustomSpiderWest SpiderWest;

    public CustomSpiderWest(World world, Location loc, Location dest) {
        super(world);
       
        setCustomName("SpiderW");
        setCustomNameVisible(true);
        this.setHealth(20.0F);
        this.persistent = true;
        this.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        
        LinkedHashSet<?> setB = (LinkedHashSet<?>) MobUtil.getPrivateField("b", PathfinderGoalSelector.class, goalSelector); setB.clear();
        LinkedHashSet<?> setC = (LinkedHashSet<?>) MobUtil.getPrivateField("c", PathfinderGoalSelector.class, goalSelector); setC.clear();

        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0D, false));
        this.goalSelector.a(3, new PathfinderGoalLeapAtTarget(this, 0.4F));
        this.goalSelector.a(5, new PathfinderGoalMoveWest(this, dest, 1.0F));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntitySkeleton.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityCreeper.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityZombie.class, true));
        
        SpiderWest = this;
    }   
    
    public static CustomSpiderWest getSpider() {
        return SpiderWest;
    }
}
