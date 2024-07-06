package org.giga.rtdfabricmod.server.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.giga.rtdfabricmod.server.actions.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.literal;

public class RtdCommand implements ICommand {

    private  EffectMakerAction effectMaker ;
    private ArrayList<Integer> historyOfActions = new ArrayList<>();


    public  RtdCommand(){
        this.effectMaker = new EffectMakerAction();
    }

    @Override
    public void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("rtd")
                    .executes(context -> {
                        return action(context);
                    })
            );
        });
    }

    @Override
    public int action(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        if (source.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) source.getEntity();
            ArrayList<Runnable> actions = registerActionCommands(player);
            runRandomAction(actions);
            return 1;
        } else {
            source.sendFeedback((Supplier<Text>) Text.of("Эту команду может выполнять только игрок!"), false);
            return 0;
        }
    }

    private ArrayList<Runnable> registerActionCommands(ServerPlayerEntity player) {
        ArrayList<Runnable> actions = new ArrayList<>();

        actions.add(() -> MobSpawnerAction.spawnRandomAngryMob(player));
        actions.add(() -> MobSpawnerAction.spawnRandomFriendlyMob(player));
        actions.add(() -> ItemsGiverAction.giveRandomSword(player));
        actions.add(() -> ItemsGiverAction.giveStick(player));
        actions.add(() -> ItemsGiverAction.give9999PoisonPotatoes(player));
        actions.add(() -> ItemsGiverAction.giveDiamondPants(player));
        actions.add(() -> this.effectMaker.giveRandomNegativeEffect(player));
        actions.add(() -> this.effectMaker.giveRandomPositiveEffect(player));
        actions.add(() -> TeleportAndBlocksAction.goToTheSun(player));
        actions.add(() -> TeleportAndBlocksAction.spawnDiamond(player));
        actions.add(() -> ItemsGiverAction.giveIronSet(player));
        actions.add(() -> TeleportAndBlocksAction.triggerBouncyBlocks(player));
//        actions.add(() -> GravityRevolutionAction.triggerGravityRevolution(player));
        actions.add(() -> MobSpawnerAction.transformIntoPig(player));
        actions.add(() -> TeleportAndBlocksAction.spawnArena(player));




        return actions;
    }

    private void runRandomAction(ArrayList<Runnable> actions) {
        Random rand = new Random();
        int randNumber;

        do {
            randNumber = rand.nextInt(actions.size());
        } while (historyOfActions.contains(randNumber));

        historyOfActions.add(randNumber);

        int oneThirdSize = historyOfActions.size() / 3;
        if (historyOfActions.size() > oneThirdSize) {
            historyOfActions.remove(0);
        }

        actions.get(randNumber).run();
    }
}
