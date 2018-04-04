package guy.guysgaming.main.worldbuilder;

import guy.guysgaming.main.MapMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;

/**
 *
 * @author Guy
 */
public class WorldBuilder {
    MapMain plugin;
    
    public WorldBuilder(MapMain plugin){
        this.plugin = plugin;
    }
    
    
    //TODO: Init the data for each world when it is made.
    public void createWorld(World world) {
        for (Entity entity : world.getEntities()) {
            entity.remove();
        }
        switch (world.getName()) {
            case "0":
            case "1":
            case "2":
            case "3"://towns
                for (int i = -13; i < 14; i++) {
                    for (int j = -13; j < 14; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (i == -13 || i == 13) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                            
                                            if((y >= 64) && (y < 74)){

                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);

                                                }
                                            }
                                            
                                        } else {
                                        }
                                        
                                    } else if (i == -12 || i == 12) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -11 || i == 11) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -10 || i == 10) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -9 || i == 9) {
                                        if (j > -10 && j < 10) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -8 || i == 8) {
                                        if (j == -9 || j == 0 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -7 || i == 7) {
                                        if (j == -9 || j == 0 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -6 || i == 6) {
                                        if (j == -9 || (j > -7 && j < 7) || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -5 || i == 5) {
                                        if (j == -9 || j == -6 || j == 0 || j == 6 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -4 || i == 4) {
                                        if (j == -9 || j == -6 || j == 0 || j == 6 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -3 || i == 3) {
                                        if (j == -9 || j == -6 || j == 0 || j == 6 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -2 || i == 2) {
                                        if (j == -9 || j == -6 || (j > -3 && j < 3) || j == 6 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -1 || i == 1) {
                                        if (j == -9 || j == -6 || j == -2 || j == 0 || j == 2 || j == 6 || j == 9) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == 0) {
                                        if ((j > -14 && j <= 0) || (j >= 0 && j < 14)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                               //if(j != 0){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                                //}
                                            }
                                            if((j == 0) || (j == -13) ||(j == 13)){
                                                if((y >= 64) && (y < 74)){
                                                    
                                                    if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    }
                                                    
                                                    if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                    }
                                                    
                                                    if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    } 
                                                    
                                                    if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    }
                                                    
                                                    if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                        world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);
                                                                
                                                    }
                                                    
                                                    
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }

                }
                
                
                
                
                break;
            case "4":
            case "5":
            case "6":
            case "7"://West to East
                for (int i = -13; i < 14; i++) {
                    for (int j = -13; j < 14; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (i == -13 || i == 13) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                            
                                            if((y >= 64) && (y < 74)){

                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);

                                                }
                                                    
                                                    
                                                
                                            }
                                        } else {
                                        }
                                    } else if (i == -12 || i == 12) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -11 || i == 11) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                            
                                        } else {
                                        }
                                    } else if (i == -10 || i == 10) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -9 || i == 9) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -8 || i == 8) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -7 || i == 7) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -6 || i == 6) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -5 || i == 5) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -4 || i == 4) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -3 || i == 3) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -2 || i == 2) {
                                        if ((j > -12 && j < -6) || (j > -3 && j < 3) || (j > 6 && j < 12)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -1 || i == 1) {
                                        if ((j > -12 && j < -6) || (j > -3 && j < 3) || (j > 6 && j < 12)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == 0) {
                                        if ((j > -12 && j < 0) || (j > 0 && j < 12)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                            
                                        } else {
                                        }
                                        
                                        if(j == 0){
                                            
                                            if((y >= 64) && (y < 74)){

                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);

                                                }


                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "8":
            case "9":
            case "10":
            case "11"://North to South
                for (int i = -13; i < 14; i++) {
                    for (int j = -13; j < 14; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (i == -11 || i == 11) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -10 || i == 10) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -9 || i == 9) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -8 || i == 8) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -7 || i == 7) {
                                        if (j == 0 || (j > -3 && j < 3)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -6 || i == 6) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -5 || i == 5) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -4 || i == 4) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -3 || i == 3) {
                                        if (j == 0) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -2 || i == 2) {
                                        if ((j > -12 && j < -6) || (j > -3 && j < 3) || (j > 6 && j < 12)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == -1 || i == 1) {
                                        if ((j > -12 && j < -6) || (j > -3 && j < 3) || (j > 6 && j < 12)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                    } else if (i == 0) {
                                        if ((j > -14 && j < 0) || (j > 0 && j < 14)) {
                                            if (y < 64 && y > 54) {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                            } else {
                                                world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                            }
                                        } else {
                                        }
                                        if((j == 0) || (j == -13) || (j == 13)){
                                            if((y >= 64) && (y < 74)){

                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);

                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "12":
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "18":
            case "19"://West to East pathways
                for (int i = -13; i < 14; i++) {
                    for (int j = 0; j < 1; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (j == 0) {
                                        if (y < 64 && y > 54) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                        if((i == -13) ||(i == 13)){
                                            if((y >= 64) && (y < 74)){

                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "20":
            case "21":
            case "22":
            case "23":
            case "24":
            case "25":
            case "26":
            case "27"://North to South pathways
                for (int i = 0; i < 1; i++) {
                    for (int j = -13; j < 14; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (i == 0) {
                                        if (y < 64 && y > 54) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                        if((j == -13) ||(j == 13)){
                                            if((y >= 64) && (y < 74)){

                                                if( ((x == 0) && (y == 73)) || ((z == 0) && (y == 73)) || ((x == 15) && (y == 73)) || ((z == 15) && (y == 73)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x == 1) && (y < 72)) || ((z == 1) && (y < 72)) || ((x == 14) && (y < 72)) || ((z == 14) && (y < 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.BIRCH_FENCE);
                                                }

                                                if( ((x == 1) && (z == 1)) || ((x == 1) && (z == 14)) || ((x == 14) && (z == 1)) || ((x == 14) && (z == 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                } 

                                                if( ((x == 1) && (y == 72)) || ((z == 1) && (y == 72)) || ((x == 14) && (y == 72)) || ((z == 14) && (y == 72)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                }

                                                if( ((x > 1) && (x < 14)) && ((z > 1) && (z < 14)) ){
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.CONCRETE);
                                                    world.getChunkAt(i, j).getBlock(x, y, z).setData((byte)15);
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "28":
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5; j++) {
                        for (int x = 0; x < 16; x++) {
                            for (int y = 0; y < 83; y++) {
                                for (int z = 0; z < 16; z++) {
                                    if (i == -4 || i == 4) {
                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                    } else if (j == -4 || j == 4) {
                                        world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.SMOOTH_BRICK);
                                    } //town 0
                                    else if (i == 0 && j == -3) {
                                        if (y < 64) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.LAPIS_BLOCK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                    } //town 1
                                    else if (i == -2 && j == -1) {
                                        if (y < 64) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.GOLD_BLOCK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                    } //town 2
                                    else if (i == -2 && j == 1) {
                                        if (y < 64) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.IRON_BLOCK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                    } //town 3
                                    else if (i == 0 && j == 3) {
                                        if (y < 64) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.DIAMOND_BLOCK);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                    } else {
                                        if (y < 64) {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.GRASS);
                                        } else {
                                            world.getChunkAt(i, j).getBlock(x, y, z).setType(Material.AIR);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
        plugin.mdHolder.addDB(world.getName());       
        
            //plugin.mdHolder.setGateOwner(world.getName(), "center", 0, 25);
        
    }
    
    
    public World loadWorld(String world){
        World Result = Bukkit.getWorld(world);
        return Result;
    }
}


/*
 * This class is going to be used to handle the world construction when the worlds are first created and if they need to be reloaded.
 */
