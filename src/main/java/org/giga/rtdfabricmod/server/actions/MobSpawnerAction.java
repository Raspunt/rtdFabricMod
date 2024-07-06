package org.giga.rtdfabricmod.server.actions;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import org.giga.rtdfabricmod.server.lists.AngryMobsList;
import org.giga.rtdfabricmod.server.lists.FriendlyMobsList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MobSpawnerAction {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public static void spawnRandomAngryMob(ServerPlayerEntity player) {
        player.sendMessage(Text.of("тебе пиздец!"));

        Random random = new Random();
        ArrayList<EntityType<?>> angryMobs = AngryMobsList.angryMobs;
        EntityType<?> randomMobType = angryMobs.get(random.nextInt(angryMobs.size()));
        ServerWorld world = player.getServerWorld();

        for (int i = 0; i < 40; i++) {
            LivingEntity mob = (LivingEntity) randomMobType.create(world);
            if (mob != null) {
                mob.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(),
                            random.nextFloat() * 360.0F, 0.0F);
                world.spawnEntity(mob);
            }
        }
    }

    public static void spawnRandomFriendlyMob(ServerPlayerEntity player) {
        player.sendMessage(Text.of("тебе пиздец! погоди... тебе повезло"));

        Random random = new Random();
        ArrayList<EntityType<?>> friendlyMobs = FriendlyMobsList.friendlyMobs;
        EntityType<?> randomMobType = friendlyMobs.get(random.nextInt(friendlyMobs.size()));

        ServerWorld world = player.getServerWorld();
        for (int i = 0; i < 40; i++) {
            LivingEntity mob = (LivingEntity) randomMobType.create(world);

            if (mob != null) {
                    mob.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(),
                            random.nextFloat() * 360.0F, 0.0F);
                    world.spawnEntity(mob);
            }
        }
    }

    public static void transformIntoPig(ServerPlayerEntity player) {
        PigEntity pigEntity = EntityType.PIG.create(player.getWorld());
        if (pigEntity != null) {
            pigEntity.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());


            player.getWorld().spawnEntity(pigEntity);
            player.setCameraEntity(pigEntity);

            player.sendMessage(Text.of("Ты превратился в свинью!"));

            scheduler.schedule(() -> {

                player.setCameraEntity(player);
                pigEntity.remove(Entity.RemovalReason.DISCARDED);


                player.sendMessage(Text.of("Ты снова человек!"));
            }, 5, TimeUnit.SECONDS); // Возвращение через 5 секунд
        }
    }

}
