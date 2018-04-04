package guy.guysgaming.main.mobevents.mobs;

import java.lang.reflect.Field;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;

public class MobUtil {
    
    public static Object getPrivateField(String fieldName, Class<PathfinderGoalSelector> clazz, Object object){
        Field field;
        Object o = null;
        try{
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            o = field.get(object);
        }
        catch(NoSuchFieldException e){
            e.printStackTrace();
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return o;
    }
}
