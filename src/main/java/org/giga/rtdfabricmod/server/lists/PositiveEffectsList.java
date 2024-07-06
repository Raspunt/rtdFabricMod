package org.giga.rtdfabricmod.server.lists;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffect;

import java.util.ArrayList;

public class PositiveEffectsList extends ListBase<StatusEffect> {

    public PositiveEffectsList() {
        objectList.add(StatusEffects.SPEED);
        objectList.add(StatusEffects.STRENGTH);
        objectList.add(StatusEffects.REGENERATION);
        objectList.add(StatusEffects.JUMP_BOOST);
        objectList.add(StatusEffects.RESISTANCE);
        objectList.add(StatusEffects.FIRE_RESISTANCE);
        objectList.add(StatusEffects.INVISIBILITY);
        objectList.add(StatusEffects.HEALTH_BOOST);
        objectList.add(StatusEffects.ABSORPTION);
        objectList.add(StatusEffects.SATURATION);
        objectList.add(StatusEffects.LUCK);
        objectList.add(StatusEffects.CONDUIT_POWER);
        objectList.add(StatusEffects.DOLPHINS_GRACE);
    }
}
