package org.giga.rtdfabricmod.server.actions;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class TeleportAndBlocksAction {

    private static final int MAX_JUMP_HEIGHT = 4;

    public static void goToTheSun(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        BlockPos sunCoordinates = new BlockPos(0, 1000, 0);
        player.teleport(world, sunCoordinates.getX(), sunCoordinates.getY(), sunCoordinates.getZ(),player.getYaw(),player.getYaw());
    }

    public static void spawnDiamond(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        BlockPos playerPos = player.getBlockPos();

        int radius = 4;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                BlockPos blockPos = playerPos.add(x, 0, z);
                world.setBlockState(blockPos, Blocks.DIAMOND_BLOCK.getDefaultState());
            }
        }
        player.sendMessage(Text.of("мне кажеться тебе понравиться"));
    }

    public static void triggerBouncyBlocks(ServerPlayerEntity player) {
        Random random = new Random();

        int radius = 20;
        BlockPos playerPos = player.getBlockPos();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -radius; y <= radius; y++) {
                    BlockPos blockPos = playerPos.add(x, y, z);
                    if (random.nextInt(10) == 0) {
                        int currentY = blockPos.getY();
                        int newY = currentY + random.nextInt(TeleportAndBlocksAction.MAX_JUMP_HEIGHT + 1);


                        if (newY > 0 && player.getServerWorld().getBlockState(blockPos).getBlock() != Blocks.AIR) {
                            BlockPos newBlockPos = new BlockPos(blockPos.getX(), newY, blockPos.getZ());
                            player.getServerWorld().setBlockState(blockPos, Blocks.AIR.getDefaultState());
                            player.getServerWorld().setBlockState(newBlockPos, Blocks.STONE.getDefaultState());
                        }
                    }
                }
            }
        }
        player.sendMessage(Text.of("Ого! я не знал что ты архитектор!"));
    }

    public static void spawnArena(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        BlockPos playerPos = player.getBlockPos();

        int radius = 10;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                BlockPos blockPos = playerPos.add(x, 0, z);
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
            }
        }

        for (int y = 1; y <= 3; y++) {
            for (int x = -radius; x <= radius; x++) {
                BlockPos blockPos1 = playerPos.add(x, y, -radius);
                BlockPos blockPos2 = playerPos.add(x, y, radius);
                world.setBlockState(blockPos1, Blocks.STONE_BRICKS.getDefaultState());
                world.setBlockState(blockPos2, Blocks.STONE_BRICKS.getDefaultState());
            }
            for (int z = -radius; z <= radius; z++) {
                BlockPos blockPos1 = playerPos.add(-radius, y, z);
                BlockPos blockPos2 = playerPos.add(radius, y, z);
                world.setBlockState(blockPos1, Blocks.STONE_BRICKS.getDefaultState());
                world.setBlockState(blockPos2, Blocks.STONE_BRICKS.getDefaultState());
            }
        }

        world.setBlockState(playerPos, Blocks.DIAMOND_BLOCK.getDefaultState());
        player.sendMessage(Text.of("Арена создана вокруг вас!"));
    }




}
