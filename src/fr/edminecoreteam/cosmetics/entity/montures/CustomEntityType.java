// 
// Decompiled by Procyon v0.5.36
// 

package fr.edminecoreteam.cosmetics.entity.montures;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.EntityTypes;
import java.util.Map;

import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableBlaze;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableChicken;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableCow;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableCreeper;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableEnderDragon;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableEnderman;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableGolem;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableHorse;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableMooshroom;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableOcelot;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideablePig;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideablePigman;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableRabbit;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSheep;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSilverFish;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSkeleton;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableSpider;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableVillager;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWitch;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWither;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableWolf;
import fr.edminecoreteam.cosmetics.entity.montures.entities.RideableZombie;

import java.util.ArrayList;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityIronGolem;
import net.minecraft.server.v1_8_R3.EntityBlaze;
import net.minecraft.server.v1_8_R3.EntityEnderman;
import net.minecraft.server.v1_8_R3.EntityHorse;
import net.minecraft.server.v1_8_R3.EntityPigZombie;
import net.minecraft.server.v1_8_R3.EntityRabbit;
import net.minecraft.server.v1_8_R3.EntitySpider;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.EntityWitch;
import net.minecraft.server.v1_8_R3.EntityWither;
import net.minecraft.server.v1_8_R3.EntityMushroomCow;
import net.minecraft.server.v1_8_R3.EntityChicken;
import net.minecraft.server.v1_8_R3.EntityCow;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.EntityEnderDragon;
import net.minecraft.server.v1_8_R3.EntityPig;
import net.minecraft.server.v1_8_R3.EntitySheep;
import net.minecraft.server.v1_8_R3.EntitySilverfish;
import net.minecraft.server.v1_8_R3.EntityOcelot;
import net.minecraft.server.v1_8_R3.EntityWolf;
import java.util.HashMap;

public class CustomEntityType
{
    private static HashMap<String, Integer> ensI;
    private static HashMap<Integer, String> ensN;
    
    static {
        CustomEntityType.ensI = new HashMap<String, Integer>();
        CustomEntityType.ensN = new HashMap<Integer, String>();
    }
    
    public static void registerAllEntities() {
        registerEntity("Wolf", 95, (Class<? extends EntityInsentient>)EntityWolf.class, (Class<? extends EntityInsentient>)RideableWolf.class);
        registerEntity("Ocelot", 98, (Class<? extends EntityInsentient>)EntityOcelot.class, (Class<? extends EntityInsentient>)RideableOcelot.class);
        registerEntity("Sheep", 91, (Class<? extends EntityInsentient>)EntitySheep.class, (Class<? extends EntityInsentient>)RideableSheep.class);
        registerEntity("Pig", 90, (Class<? extends EntityInsentient>)EntityPig.class, (Class<? extends EntityInsentient>)RideablePig.class);
        registerEntity("Cow", 92, (Class<? extends EntityInsentient>)EntityCow.class, (Class<? extends EntityInsentient>)RideableCow.class);
        registerEntity("Chicken", 93, (Class<? extends EntityInsentient>)EntityChicken.class, (Class<? extends EntityInsentient>)RideableChicken.class);
        registerEntity("Mooshroom", 96, (Class<? extends EntityInsentient>)EntityMushroomCow.class, (Class<? extends EntityInsentient>)RideableMooshroom.class);
        registerEntity("Villager", 120, (Class<? extends EntityInsentient>)EntityVillager.class, (Class<? extends EntityInsentient>)RideableVillager.class);
        registerEntity("Zombie", 54, (Class<? extends EntityInsentient>)EntityZombie.class, (Class<? extends EntityInsentient>)RideableZombie.class);
        registerEntity("Skeleton", 51, (Class<? extends EntityInsentient>)EntitySkeleton.class, (Class<? extends EntityInsentient>)RideableSkeleton.class);
        registerEntity("Spider", 52, (Class<? extends EntityInsentient>)EntitySpider.class, (Class<? extends EntityInsentient>)RideableSpider.class);
        registerEntity("Pigman", 57, (Class<? extends EntityInsentient>)EntityPigZombie.class, (Class<? extends EntityInsentient>)RideablePigman.class);
        registerEntity("Enderman", 58, (Class<? extends EntityInsentient>)EntityEnderman.class, (Class<? extends EntityInsentient>)RideableEnderman.class);
        registerEntity("Blaze", 61, (Class<? extends EntityInsentient>)EntityBlaze.class, (Class<? extends EntityInsentient>)RideableBlaze.class);
        registerEntity("Golem", 99, (Class<? extends EntityInsentient>)EntityIronGolem.class, (Class<? extends EntityInsentient>)RideableGolem.class);
        registerEntity("Witch", 66, (Class<? extends EntityInsentient>)EntityWitch.class, (Class<? extends EntityInsentient>)RideableWitch.class);
        registerEntity("Rabbit", 101, (Class<? extends EntityInsentient>)EntityRabbit.class, (Class<? extends EntityInsentient>)RideableRabbit.class);
        registerEntity("Horse", 100, (Class<? extends EntityInsentient>)EntityHorse.class, (Class<? extends EntityInsentient>)RideableHorse.class);
        registerEntity("Creeper", 50, (Class<? extends EntityInsentient>)EntityCreeper.class, (Class<? extends EntityInsentient>)RideableCreeper.class);
        registerEntity("Silverfish", 60, (Class<? extends EntityInsentient>)EntitySilverfish.class, (Class<? extends EntityInsentient>)RideableSilverFish.class);
        registerEntity("Wither", 64, (Class<? extends EntityInsentient>)EntityWither.class, (Class<? extends EntityInsentient>)RideableWither.class);
        registerEntity("Ender_Dragon", 63, (Class<? extends EntityInsentient>)EntityEnderDragon.class, (Class<? extends EntityInsentient>)RideableEnderDragon.class);
    }
    
    public static void registerEntity(final String name, final int id, final Class<? extends EntityInsentient> nmsClass, final Class<? extends EntityInsentient> customClass) {
        try {
            List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
            Field[] declaredFields;
            for (int length = (declaredFields = EntityTypes.class.getDeclaredFields()).length, i = 0; i < length; ++i) {
                Field f = declaredFields[i];
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMaps.add((Map<?, ?>)f.get(null));
                }
            }
            if (dataMaps.get(2).containsKey(id)) {
                dataMaps.get(0).remove(name);
                dataMaps.get(2).remove(id);
            }
            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, Integer.TYPE);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);
            Field[] declaredFields2;
            for (int length2 = (declaredFields2 = BiomeBase.class.getDeclaredFields()).length, j = 0; j < length2; ++j) {
                Field f2 = declaredFields2[j];
                if (f2.getType().getSimpleName().equals(BiomeBase.class.getSimpleName()) && f2.get(null) != null) {
                    Field[] declaredFields3;
                    for (int length3 = (declaredFields3 = BiomeBase.class.getDeclaredFields()).length, k = 0; k < length3; ++k) {
                        Field list = declaredFields3[k];
                        if (list.getType().getSimpleName().equals(List.class.getSimpleName())) {
                            list.setAccessible(true);
                            @SuppressWarnings("unchecked")
							List<BiomeBase.BiomeMeta> metaList = (List<BiomeBase.BiomeMeta>)list.get(f2.get(null));
                            for (BiomeBase.BiomeMeta meta : metaList) {
                                Field clazz = BiomeBase.BiomeMeta.class.getDeclaredFields()[0];
                                if (clazz.get(meta).equals(nmsClass)) {
                                    clazz.set(meta, customClass);
                                }
                            }
                        }
                    }
                }
            }
            CustomEntityType.ensI.put(name, id);
            CustomEntityType.ensN.put(id, name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getID(String name) {
        return CustomEntityType.ensI.get(name);
    }
    
    public static String getName(int id) {
        return CustomEntityType.ensN.get(id);
    }
}
