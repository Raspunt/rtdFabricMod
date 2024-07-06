package org.giga.rtdfabricmod.server;

import org.giga.rtdfabricmod.server.commands.RtdCommand;

public class CommandMaker {

    private final RtdCommand rtdCommand;

    public CommandMaker() {
        this.rtdCommand = new RtdCommand();
    }

    public void registerCommands() {
        rtdCommand.register();
    }
}
