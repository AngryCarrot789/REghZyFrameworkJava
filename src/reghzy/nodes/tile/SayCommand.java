package reghzy.nodes.tile;

import reghzy.commands.execute.CommandExecutor;
import reghzy.credentials.IUser;

import java.util.logging.Logger;

public class SayCommand extends CommandExecutor {
    @Override
    public void onCommand(IUser sender, Logger logger, String[] args) {
        logger.info("Hello loool");
    }

    @Override
    public String getName() {
        return "say";
    }
}
