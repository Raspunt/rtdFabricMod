package org.giga.rtdfabricmod.server.lists;

import net.minecraft.entity.EntityType;
import java.util.ArrayList;
import java.util.Random;

public class FriendlyMobsList extends ListBase<EntityType<?>> {
    public static ArrayList<EntityType<?>> friendlyMobs = new ArrayList<>();

    static {
        friendlyMobs.add(EntityType.VILLAGER);
        friendlyMobs.add(EntityType.COW);
        friendlyMobs.add(EntityType.SHEEP);
        friendlyMobs.add(EntityType.CHICKEN);
        friendlyMobs.add(EntityType.PIG);
    }

    public FriendlyMobsList(){
        objectList = friendlyMobs;
    }


}
