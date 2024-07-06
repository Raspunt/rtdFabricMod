package org.giga.rtdfabricmod.server.lists;

import net.minecraft.entity.EntityType;

import java.util.ArrayList;

public class AngryMobsList extends ListBase<EntityType<?>> {

    public static ArrayList<EntityType<?>> angryMobs = new ArrayList<>();

    static {
        angryMobs.add(EntityType.ZOMBIE);
        angryMobs.add(EntityType.CREEPER);
        angryMobs.add(EntityType.SPIDER);
        angryMobs.add(EntityType.SKELETON);
        angryMobs.add(EntityType.PIGLIN);
        angryMobs.add(EntityType.BLAZE);
        angryMobs.add(EntityType.WARDEN);
        angryMobs.add(EntityType.WITHER);
        angryMobs.add(EntityType.WITHER_SKELETON);
    }

    public AngryMobsList() {
        objectList = angryMobs;
    }
}
