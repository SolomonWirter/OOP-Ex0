package ex0;
import java.util.*;

/** This Class represent a Set of Method to use on Graph (Graph_DS)
 * those Methods Using Breath-First-Search Algorithm
 */
public class Graph_Algo implements graph_algorithms {
    private graph g;

    @Override
    public void init(graph g) {
        this.g = g;
    }

    public Graph_Algo(graph h) {
        this.g = h;
    }

    public Graph_Algo() {
        g = new Graph_DS();
    }
    /** Using A Method from Graph_DS for DeepCopy */
    @Override
    public graph copy() {
        this.g = new Graph_DS(g);
        return g;
    }

    /** BFS Algorithm
     * Using a Queue to keep track of the Vertex that has been reached
     * Giving each Vertex a Integer Tag representing the distance from the src Vertex
     * @param node */
    public void BFS(node_data node) {
        Queue<node_data> queue = new LinkedList<node_data>();
        node.setTag(0);
        queue.add(node);
        while (!queue.isEmpty()) {
            node_data nodeStart = queue.peek();
            queue.poll();
            Iterator<node_data> iterator = nodeStart.getNi().iterator();
            while (iterator.hasNext()) {
                node_data nodeNeighbor = iterator.next();
                if(nodeNeighbor.getTag() == -1) {
                    nodeNeighbor.setTag(nodeStart.getTag()+1);
                    queue.add(nodeNeighbor);
                }
            }
        }
    }
    /** First using Iterator to reach every Vertex and Set the Tag to -1
    * Applying BFS Algorithms on the Graph
    * If Exist a Vertex with Tag = -1 Than the Graph is Not Connected
     * */
    @Override
    public boolean isConnected() {
        if (g.nodeSize() == 0 || g.nodeSize() == 1) {return true;}
        if (g.nodeSize() > g.edgeSize() + 2) {return false;}
        Iterator<node_data> iterator = g.getV().iterator();
        node_data nodeStart = iterator.next();
        for (node_data n : g.getV()){ n.setTag(-1); }
            this.BFS(nodeStart);
        for (node_data i : g.getV()) {
            if (i.getTag() == -1) return false;
        }
        return true;
    }
    /** Using BFS Algorithm
     * each Vertex get Tag that representing the distance from the src Vertex
     * return: the dest Tag
     * @param src
     * @param dest */
    @Override
    public int shortestPathDist(int src, int dest) {
        if(src == dest) return 0;
        for (node_data node: this.g.getV()) { node.setTag(-1); }
        this.BFS(this.g.getNode(src));
        return   this.g.getNode(dest).getTag();

    }
    /** Using BFS Algorithm
     * Starting from the dest Tag adding the Vertexes to the List
     * dest -> V(n) -> V(n-1) -> ... -> src
     * When reaching the src Vertex -> break the loop
     * return : List In Reverse
     * src -> V(1) -> ... -> dest
     * @param src
     * @param dest */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        List<node_data> path = new LinkedList<node_data>();
        path.add(g.getNode(dest));
        if(src == dest) { return path; }
        for (node_data node: this.g.getV()) { node.setTag(-1); }
        this.BFS(this.g.getNode(src));
        int length =  this.g.getNode(dest).getTag() - 1;
        Iterator<node_data> iterator = this.g.getV(dest).iterator();
        while (iterator.hasNext()){
            node_data node = iterator.next();
            if(length == node.getTag()){
                path.add(node);
                length--;
                iterator = node.getNi().iterator();
            }
            if (length == -1) { break; }
        }
        Collections.reverse(path);
        return path;
    }

}
