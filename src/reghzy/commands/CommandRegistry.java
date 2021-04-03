package reghzy.commands;

import reghzy.commands.execute.ICommandExecutor;
import reghzy.commands.node.CommandMap;
import reghzy.commands.node.INode;

import java.util.HashMap;

public class CommandRegistry {
    private final CommandMap map;

    public CommandRegistry() {
        map = new CommandMap("main", ' ');
    }

    /**
     * Registers a command and connects it down the command branch. dont supply the command name in the branch itself
     * e.g. if the full branch is commands.mycommands.tile.ShowTiles, supply commands.mycommands.tile (aka the main command)
     */
    public void registerCommand(String mainCommandBranch, ICommandExecutor commandExecutor) {
        map.connectCommand(mainCommandBranch, commandExecutor);
    }

    public ICommandExecutor getCommand(String mainCommand, String commandName) {
        return map.getCommand(mainCommand, commandName);
    }
}
