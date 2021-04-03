package reghzy.commands.query;

import reghzy.commands.node.CommandMap;
import reghzy.commands.node.INode;
import reghzy.helpers.StringHelper;

public class CommandQuery {
    private final String query;

    public CommandQuery(String query) {
        this.query = query;
    }

    public INode getLastNodeBeforeArgs(CommandMap map) {
        return map.getClosestNodeDownBranch(query);
    }

    public String getContentAfterNode(INode node) {
        return StringHelper.getAfter(query, node.getName(), 0);
    }

    public String translateBranch(String query, char oldSplit, char newSplit) {
        return query.replace(oldSplit, newSplit);
    }
}
