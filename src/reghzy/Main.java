package reghzy;

import reghzy.commands.CommandRegistry;
import reghzy.commands.execute.ICommandExecutor;
import reghzy.graphics.collision.AxisAlignedBB;
import reghzy.helpers.StringHelper;
import reghzy.nodes.help.HelpCommand;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CommandRegistry registry = new CommandRegistry();

        //registry.registerCommand("help", new HelpCommand());
        //registry.registerCommand("tile.something.say", new HelpCommand());
        //registry.registerCommand("ok.then", new HelpCommand());
        //ICommandExecutor help = registry.getCommand(null, "help");
        //ICommandExecutor say = registry.getCommand("tile.something", "say");
        //ICommandExecutor then = registry.getCommand("ok", "then");
        //ICommandExecutor ok = registry.getCommand(null, "ok");

        AxisAlignedBB box = new AxisAlignedBB();
    }
}
