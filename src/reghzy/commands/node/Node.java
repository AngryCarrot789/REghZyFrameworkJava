package reghzy.commands.node;

import reghzy.helpers.StringHelper;

import java.util.HashMap;

public class Node implements INode {
    private final String name;
    final HashMap<String, INode> nodes;

    public final char branchSplitter;

    public Node(String name, char branchSplitter) {
        this.name = name;
        this.branchSplitter = branchSplitter;
        this.nodes = new HashMap<String, INode>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public INode getNode(String name) {
        return nodes.get(name);
    }

    @Override
    public INode connectNode(INode node) {
        return nodes.put(node.getName(), node);
    }

    @Override
    public INode getNodeDownBranch(String branch, String nodeName) {
        String[] branches = StringHelper.split(branch, branchSplitter, 0);
        if (branches.length == 0)
            return null;

        INode currentNode = this.getNode(branches[0]);
        if (currentNode == null)
            return null;
        for (int i = 1; i < branches.length; i++) {
            INode subNode = currentNode.getNode(branches[i]);
            if (subNode == null) {
                return null;
            }
            currentNode = subNode;
        }
        return currentNode.getNode(nodeName);
    }

    @Override
    public INode getNodeDownBranch(String fullBranch) {
        String[] branches = StringHelper.split(fullBranch, branchSplitter, 0);
        if (branches.length == 0)
            return null;

        INode currentNode = this.getNode(branches[0]);
        if (currentNode == null)
            return null;
        for (int i = 1; i < branches.length; i++) {
            INode subNode = currentNode.getNode(branches[i]);
            if (subNode == null) {
                return null;
            }
            currentNode = subNode;
        }
        return currentNode;
    }

    @Override
    public INode getClosestNodeDownBranch(String branch, String nodeName) {
        String[] branches = StringHelper.split(branch, branchSplitter, 0);
        if (branches.length == 0)
            return null;

        INode currentNode = this.getNode(branches[0]);
        if (currentNode == null)
            return this;
        for (int i = 1; i < branches.length; i++) {
            INode subNode = currentNode.getNode(branches[i]);
            if (subNode == null) {
                return currentNode;
            }
            currentNode = subNode;
        }
        INode subNode = currentNode.getNode(nodeName);
        if (subNode == null)
            return currentNode;
        return subNode;
    }

    @Override
    public INode getClosestNodeDownBranch(String fullBranch) {
        String[] branches = StringHelper.split(fullBranch, branchSplitter, 0);
        if (branches.length == 0)
            return null;

        INode currentNode = this.getNode(branches[0]);
        if (currentNode == null)
            return this;
        for (int i = 1; i < branches.length; i++) {
            INode subNode = currentNode.getNode(branches[i]);
            if (subNode == null) {
                return currentNode;
            }
            currentNode = subNode;
        }
        return currentNode;
    }

    @Override
    public INode connectNodeToBranch(String branch, INode node) {
        String[] branches = StringHelper.split(branch, branchSplitter, 0);
        if (branches.length == 0)
            return this.connectNode(node);

        INode currentNode = this.getNode(branches[0]);
        for (int i = 1; i < branches.length; i++) {
            INode subNode = currentNode.getNode(branches[i]);
            if (subNode == null) {
                subNode = new Node(branches[i], branchSplitter);
                currentNode.connectNode(subNode);
                currentNode = subNode;
            }
        }
        return currentNode.connectNode(node);
    }

    @Override
    public INode findNode(String name) {
        INode node = this.getNode(name);
        if (node == null) {
            for(INode subNode : this.nodes.values()) {
                node = subNode.findNode(name);
                if (node != null)
                    return node;
            }
        }
        return null;
    }
}
