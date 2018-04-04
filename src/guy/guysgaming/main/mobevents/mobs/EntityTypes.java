/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guy.guysgaming.main.mobevents.mobs;

import guy.guysgaming.main.mobevents.mobs.creeper.CustomCreeperEast;
import guy.guysgaming.main.mobevents.mobs.creeper.CustomCreeperNorth;
import guy.guysgaming.main.mobevents.mobs.creeper.CustomCreeperSouth;
import guy.guysgaming.main.mobevents.mobs.creeper.CustomCreeperWest;
import guy.guysgaming.main.mobevents.mobs.skeleton.CustomSkeletonEast;
import guy.guysgaming.main.mobevents.mobs.skeleton.CustomSkeletonNorth;
import guy.guysgaming.main.mobevents.mobs.skeleton.CustomSkeletonSouth;
import guy.guysgaming.main.mobevents.mobs.skeleton.CustomSkeletonWest;
import guy.guysgaming.main.mobevents.mobs.spider.CustomSpiderEast;
import guy.guysgaming.main.mobevents.mobs.spider.CustomSpiderNorth;
import guy.guysgaming.main.mobevents.mobs.spider.CustomSpiderSouth;
import guy.guysgaming.main.mobevents.mobs.spider.CustomSpiderWest;
import guy.guysgaming.main.mobevents.mobs.zombie.CustomZombieEast;
import guy.guysgaming.main.mobevents.mobs.zombie.CustomZombieSouth;
import guy.guysgaming.main.mobevents.mobs.zombie.CustomZombieNorth;
import guy.guysgaming.main.mobevents.mobs.zombie.CustomZombieWest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.minecraft.server.v1_12_R1.*;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.MinecraftKey;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.EntityType;

public enum EntityTypes {

   CUSTOM_ZOMBIE_NORTH("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, CustomZombieNorth.class),
   CUSTOM_ZOMBIE_SOUTH("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, CustomZombieSouth.class),
   CUSTOM_ZOMBIE_WEST("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, CustomZombieWest.class),
   CUSTOM_ZOMBIE_EAST("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, CustomZombieEast.class),
   CUSTOM_SKELETON_NORTH("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, CustomSkeletonNorth.class),
   CUSTOM_SKELETON_SOUTH("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, CustomSkeletonSouth.class),
   CUSTOM_SKELETON_WEST("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, CustomSkeletonWest.class),
   CUSTOM_SKELETON_EAST("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, CustomSkeletonEast.class),
   CUSTOM_CREEPER_NORTH("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CustomCreeperNorth.class),
   CUSTOM_CREEPER_SOUTH("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CustomCreeperSouth.class),
   CUSTOM_CREEPER_WEST("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CustomCreeperWest.class),
   CUSTOM_CREEPER_EAST("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CustomCreeperEast.class),
   CUSTOM_SPIDER_NORTH("Spider", 52, EntityType.SPIDER, EntitySpider.class, CustomSpiderNorth.class),
   CUSTOM_SPIDER_SOUTH("Spider", 52, EntityType.SPIDER, EntitySpider.class, CustomSpiderSouth.class),
   CUSTOM_SPIDER_WEST("Spider", 52, EntityType.SPIDER, EntitySpider.class, CustomSpiderWest.class),
   CUSTOM_SPIDER_EAST("Spider", 52, EntityType.SPIDER, EntitySpider.class, CustomSpiderEast.class);

   private static Method validateEntityMethod;

   static  {
      try {
         validateEntityMethod = World.class.getDeclaredMethod("b", Entity.class);
         validateEntityMethod.setAccessible(true);
      } catch (NoSuchMethodException e) {
         e.printStackTrace();
      }
   }

   private String name;
   private int id;
   private EntityType entityType;
   private Class<? extends Entity> nmsClass;
   private Class<? extends Entity> customClass;
   private MinecraftKey key;
   private MinecraftKey oldKey;

   private EntityTypes(String name, int id, EntityType entityType, Class<? extends Entity> nmsClass, Class<? extends Entity> customClass) {
      this.name = name;
      this.id = id;
      this.entityType = entityType;
      this.nmsClass = nmsClass;
      this.customClass = customClass;
      this.key = new MinecraftKey(name);
      this.oldKey = net.minecraft.server.v1_12_R1.EntityTypes.b.b(nmsClass);
   }

   public static void registerEntities() { for (EntityTypes ce : EntityTypes.values()) ce.register(); }
   public static void unregisterEntities() { for (EntityTypes ce : EntityTypes.values()) ce.unregister(); }

   private void register() {
      net.minecraft.server.v1_12_R1.EntityTypes.d.add(key);
      net.minecraft.server.v1_12_R1.EntityTypes.b.a(id, key, customClass);
   }

   private void unregister() {
      net.minecraft.server.v1_12_R1.EntityTypes.d.remove(key);
      net.minecraft.server.v1_12_R1.EntityTypes.b.a(id, oldKey, nmsClass);
   }

   public void spawn(Location spawnLoc, Location destLoc) {
      try {
         Constructor customClassConstructor = customClass.getConstructor(World.class, Location.class, Location.class);
         EntityLiving entity = (EntityLiving) customClassConstructor.newInstance(((CraftWorld) spawnLoc.getWorld()).getHandle(), spawnLoc, destLoc);

         if(addEntityToWorld(((CraftWorld) spawnLoc.getWorld()).getHandle(), entity)) {
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private boolean addEntityToWorld(WorldServer nmsWorld, Entity nmsEntity) {
      final int chunkX = MathHelper.floor(nmsEntity.locX / 16.0);
      final int chunkZ = MathHelper.floor(nmsEntity.locZ / 16.0);

      if (!nmsWorld.getChunkProviderServer().isLoaded(chunkX, chunkZ)) {
         nmsEntity.dead = true;
         return false;
      }

      nmsWorld.getChunkAt(chunkX, chunkZ).a(nmsEntity);
      nmsWorld.entityList.add(nmsEntity);

      try {
         validateEntityMethod.invoke(nmsWorld, nmsEntity);
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }

      return true;
   }

   public String getName() {
      return name;
   }

   public int getID() {
      return id;
   }

   public EntityType getEntityType() {
      return entityType;
   }

   public Class<?> getCustomClass() {
      return customClass;
   }
}