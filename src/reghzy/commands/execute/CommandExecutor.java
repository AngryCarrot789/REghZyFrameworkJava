package reghzy.commands.execute;

import reghzy.commands.node.INode;

public abstract class CommandExecutor implements ICommandExecutor {
    @Override
    public INode getNode(String name) {
        return null;
    }

    @Override
    public INode connectNode(INode node) {
        return null;
    }
}
