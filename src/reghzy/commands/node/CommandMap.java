package reghzy.commands.node;

import reghzy.commands.execute.ICommandExecutor;

public class CommandMap extends Node implements ICommandNode {
    public CommandMap(String name, char branchSplitter) {
        super(name, branchSplitter);
    }

    @Override
    public ICommandExecutor getCommand(String mainCommand, String commandName) {
        INode node = this.getNodeDownBranch(mainCommand, commandName);
        if (node instanceof ICommandExecutor) {
            return (ICommandExecutor) node;
        }
        return null;
    }

    @Override
    public ICommandExecutor getCommand(String commandName) {
        INode node = this.findNode(commandName);
        if (node instanceof ICommandExecutor)
            return (ICommandExecutor) node;

        return null;
    }

    @Override
    public ICommandExecutor connectCommand(String branch, ICommandExecutor commandNode) {
        INode node = this.connectNodeToBranch(branch, commandNode);
        if (node instanceof ICommandNode) {
            return (ICommandExecutor) node;
        }
        return null;
    }

    @Override
    public ICommandNode connectMap(String branch, ICommandNode commandNode) {
        INode node = this.connectNodeToBranch(branch, commandNode);
        if (node instanceof ICommandNode) {
            return (ICommandNode) node;
        }
        return null;
    }
}
