package org.giga.rtdfabricmod.server.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;

public interface ICommand {
    public void register();
    public int action(CommandContext<ServerCommandSource> context);
}
