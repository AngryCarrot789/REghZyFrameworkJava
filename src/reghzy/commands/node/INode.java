package reghzy.commands.node;

/**
 * A node connected to a tree, starting at the top and ending at the bottom. it is is something that can
 * connect to other nodes, and can have other nodes connected to it, like lots of extension leads.
 * <p>
 *     They also have the ability to look down the branch
 * </p>
 */
public interface INode {
    /**
     * The name of the node. this should not be null, as it's required
     */
    String getName();

    /**
     * Gets a node (with the given name) connected to this node (does not look down the branch).
     * <p>
     *     returns null if one doesn't exist with the given name
     * </p>
     */
    INode getNode(String name);

    /**
     * Connects the given node to this node
     * <p>
     *     Returns the node that was previously there before (with the same name).
     *     or returns null if there wasn't a node there before
     * </p>
     */
    INode connectNode(INode node);

    /**
     * Gets a node down this node's branch, at the given branch starting at this node, with the given name
     * <p>
     *     Returns null if one doesn't exist with the given name
     * </p>
     */
    INode getNodeDownBranch(String branch, String nodeName);
    INode getNodeDownBranch(String fullBranch);

    /**
     * Goes down this node's branch, at the given branch starting at this node, with the given name
     * and tries to find a node. if a node doesn't exist down the branch, it will return whatever node it
     * was currently processing
     * <p>
     * Returns null if one doesn't exist with the given name
     * </p>
     */
    INode getClosestNodeDownBranch(String branch, String nodeName);
    INode getClosestNodeDownBranch(String fullBranch);

    /**
     * Connects a node down this node's branch, at the given branch starting at this node.
     * <p>
     *     Creates nodes down the branch if they dont exist
     * </p>
     * <p>
     *     Returns the node that was previously there before (with the same name).
     *     or returns null if there wasn't a node there before
     * </p>
     */
    INode connectNodeToBranch(String branch, INode node);

    /**
     * Tries to find a node (by looking down every branch) with the given name
     * <p>
     *     Returns null if one isn't found
     * </p>
     */
    INode findNode(String name);
}