/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guy.guysgaming.main.mobevents.mobs.skeleton;

import guy.guysgaming.main.mobevents.mobs.MobUtil;
import guy.guysgaming.main.mobevents.mobs.zombie.CustomZombieEast;
import guy.guysgaming.main.mobevents.pathfindergoals.PathfinderGoalMoveEast;
import java.util.LinkedHashSet;
import net.minecraft.server.v1_12_R1.EntityCreeper;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.EntitySkeleton;
import net.minecraft.server.v1_12_R1.EntitySpider;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_12_R1.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.Location;

/**
 *
 * @author Guy
 */
public class CustomSkeletonEast extends EntitySkeleton {
   
    private static CustomSkeletonEast SkeletonEast;

    public CustomSkeletonEast(World world, Location loc, Location dest) {
        super(world);
       
        setCustomName("SkeletonE");
        setCustomNameVisible(true);
        this.persistent = true;
        this.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        
        LinkedHashSet<?> setB = (LinkedHashSet<?>) MobUtil.getPrivateField("b", PathfinderGoalSelector.class, goalSelector); setB.clear();
        LinkedHashSet<?> setC = (LinkedHashSet<?>) MobUtil.getPrivateField("c", PathfinderGoalSelector.class, goalSelector); setC.clear();

        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0D, false));
        this.goalSelector.a(5, new PathfinderGoalMoveEast(this, dest, 1.0F));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntitySkeleton.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityCreeper.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntitySpider.class, true));
        
        SkeletonEast = this;
    }   
    
    public static CustomSkeletonEast getSkeleton() {
        return SkeletonEast;
    }
}
