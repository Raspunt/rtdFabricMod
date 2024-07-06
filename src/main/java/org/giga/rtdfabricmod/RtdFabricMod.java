package org.giga.rtdfabricmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import org.giga.rtdfabricmod.server.CommandMaker;

public class RtdFabricMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandMaker commandMaker = new CommandMaker();
        commandMaker.registerCommands();

        ServerLifecycleEvents.SERVER_STARTED.register(this::sendModInstalledMessage);
    }

    private void sendModInstalledMessage(MinecraftServer server) {
        // Создаем текст сообщения
        Text message = Text.of("Мод rtd установлен!");

        // Отправляем сообщение каждому игроку на сервере
        server.getPlayerManager().getPlayerList().forEach(player ->
                player.sendMessage(message, false)
        );
    }

}
