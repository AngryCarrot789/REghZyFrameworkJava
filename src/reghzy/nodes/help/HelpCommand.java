package reghzy.nodes.help;

import reghzy.commands.execute.CommandExecutor;
import reghzy.credentials.IUser;

import java.util.logging.Logger;

public class HelpCommand extends CommandExecutor {
    @Override
    public void onCommand(IUser sender, Logger logger, String[] args) {
        logger.info("Hello " + sender.getName() + ", here's help lol");
        logger.info("None");
    }

    @Override
    public String getName() {
        return "help";
    }
}
