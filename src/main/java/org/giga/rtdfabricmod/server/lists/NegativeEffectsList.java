package org.giga.rtdfabricmod.server.lists;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffect;

import java.util.ArrayList;

public class NegativeEffectsList extends ListBase<StatusEffect> {

    public NegativeEffectsList() {
        objectList.add(StatusEffects.POISON);
        objectList.add(StatusEffects.WEAKNESS);
        objectList.add(StatusEffects.SLOWNESS);
        objectList.add(StatusEffects.BLINDNESS);
        objectList.add(StatusEffects.WITHER);
        objectList.add(StatusEffects.BAD_OMEN);
        objectList.add(StatusEffects.UNLUCK);
    }
}
