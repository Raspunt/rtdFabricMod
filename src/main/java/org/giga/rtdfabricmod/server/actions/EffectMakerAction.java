package org.giga.rtdfabricmod.server.actions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.giga.rtdfabricmod.server.lists.NegativeEffectsList;
import org.giga.rtdfabricmod.server.lists.PositiveEffectsList;

public class EffectMakerAction {

    private final PositiveEffectsList pel;
    private final NegativeEffectsList nel;

    public EffectMakerAction() {
        this.pel = new PositiveEffectsList();
        this.nel = new NegativeEffectsList();
    }

    public void giveRandomPositiveEffect(ServerPlayerEntity player) {
        StatusEffectInstance effectInstance = new StatusEffectInstance(pel.getRandomElement(), 1000, 100);
        player.addStatusEffect(effectInstance);
        player.sendMessage(Text.of("Вы получили позитивный эффект!"));
    }

    public void giveRandomNegativeEffect(ServerPlayerEntity player) {
        StatusEffectInstance effectInstance = new StatusEffectInstance(nel.getRandomElement(), 1000, 100);
        player.addStatusEffect(effectInstance);
        player.sendMessage(Text.of("Вы получили негативный эффект!"));
    }
}
