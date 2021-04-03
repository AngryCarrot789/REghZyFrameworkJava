package reghzy.commands.node;

import reghzy.commands.execute.ICommandExecutor;

public interface ICommandNode extends INode {
    /**
     * Gets a command executor at the given main command branch
     * and with the given command name
     */
    ICommandExecutor getCommand(String mainCommand, String commandName);

    /**
     * Tries to find a command with the given name (down every branch)
     */
    ICommandExecutor getCommand(String commandName);

    /**
     * Connects a command down starting at this node branch, down the given branch
     * <p>
     *     Returns the command that already existed down the branch with the
     *     given command name. or returns null if no command already existed
     * </p>
     */
    ICommandExecutor connectCommand(String branch, ICommandExecutor commandNode);

    /**
     * Connects a command node starting at this node branch, down the given branch
     * <p>
     *     Returns the command node that already existed down the branch with the
     *     given command node's name. or returns null if no command already existed
     * </p>
     */
    ICommandNode connectMap(String branch, ICommandNode node);
}
