package reghzy.commands.execute;

import reghzy.commands.node.IEndNode;
import reghzy.credentials.IUser;

import java.util.logging.Logger;

public interface ICommandExecutor extends IEndNode {
    void onCommand(IUser sender, Logger logger, String[] args);
}
