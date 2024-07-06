package org.giga.rtdfabricmod.server.actions;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import java.util.List;
import java.util.Random;

public class GravityRevolutionAction {

    private static final double GRAVITY_FACTOR = 0.2; // Фактор изменения гравитации

    public static void triggerGravityRevolution(ServerPlayerEntity player) {
        Random random = new Random();

        List<Entity> entities = player.getWorld().getOtherEntities(player, player.getBoundingBox().expand(10.0, 10.0, 10.0));

        for (Entity entity : entities) {
            Vec3d motion = entity.getVelocity();
            double randomFactor = random.nextDouble() * GRAVITY_FACTOR * 2 - GRAVITY_FACTOR; // Случайный фактор изменения скорости

            entity.setVelocity(motion.x + randomFactor, motion.y + randomFactor, motion.z + randomFactor);
        }

        player.sendMessage(Text.of("Гравитация вокруг вас снова изменилась!"));
    }
}
