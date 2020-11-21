package ex0;
import javax.naming.NamingEnumeration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/** This Class represent an Unweighted & Undirected Graph
 * Using HashMap Data Structure to store the Vertexes (NodeData) of the Graph
 */
public class Graph_DS implements graph {
    private int nodeCount, edgeCount;
    private HashMap<Integer, node_data> graphTable;
    private int mc;

    public Graph_DS() {
        nodeCount = 0;
        edgeCount = 0;
        this.graphTable = new HashMap<>();
        this.mc = 0;
    }
    /** DeepCopy for Graph */
    public Graph_DS(graph g) {
        this.graphTable = new HashMap<Integer, node_data>();
        for (node_data node : g.getV()) {
            node_data newNode = new NodeData(node);
            this.addNode(newNode);
        }
        for (node_data node : g.getV()) {
            Collection<node_data> neighbors = g.getV(node.getKey());
            Iterator<node_data> t = neighbors.iterator();
            while (t.hasNext()){
                node_data forCopy = new NodeData(t.next());
                this.getNode(node.getKey()).addNi(this.getNode(forCopy.getKey()));
            }
        }
        this.mc = g.getMC();
        this.nodeCount = g.nodeSize();
        this.edgeCount = g.edgeSize();
    }

    /** This Method return a Vertex from the Graph by Key
     * @param key - the node_id
     * @return
     */
    @Override
    public node_data getNode(int key) {
        if(graphTable.containsKey(key)){ return graphTable.get(key); }
        return null;
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
        if (graphTable.containsKey(node1) && graphTable.containsKey(node2)) {
            return getNode(node1).hasNi(node2) && getNode(node2).hasNi(node1);
        }
        return false;
    }

    @Override
    public void addNode(node_data n) {
        graphTable.put(n.getKey(), n);
        nodeCount++;
        mc++;
        return;
    }

    @Override
    public void connect(int node1, int node2) {
        if (graphTable.containsKey(node1) && graphTable.containsKey(node2)) {
            if (hasEdge(node1, node2)) return;
            if (node1 != node2) {
                graphTable.get(node1).addNi(graphTable.get(node2));
                graphTable.get(node2).addNi(graphTable.get(node1));
                edgeCount++;
                mc++;
            }
        }
    }

    /** This Method return a pointer
     * of the the Graph Vertexes as a Collection
     * @return
     */
    @Override
    public Collection<node_data> getV() {
        Collection<node_data> forCopy = graphTable.values();
        return forCopy;
    }

    /** This Method is for receiving a Collection of Neighbors
     * Using Key of the Vertex
     * @param node_id
     * @return
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        return graphTable.get(node_id).getNi();
    }
    /** Using A FOR loop to reach every Vertex
     * If the Vertex is in the Neighbors we remove it from the Neighbors list
     * than remove the Vertex itself from the Graph
     * @param key */
    @Override
    public node_data removeNode(int key) {
        if (!graphTable.containsKey(key)) return null;
        for (node_data r : graphTable.get(key).getNi()) {
            if (graphTable.get(key).hasNi(r.getKey())) {
                r.removeNode(graphTable.get(key));
                edgeCount--;
            }
        }
        mc++;
        nodeCount--;
        return graphTable.remove(key);
    }

    @Override
    public void removeEdge(int node1, int node2) {
        if (!hasEdge(node1, node2)) return;
        graphTable.get(node1).removeNode(graphTable.get(node2));
        graphTable.get(node2).removeNode(graphTable.get(node1));
        edgeCount--;
        mc++;
    }

    @Override
    public int nodeSize() {
        return nodeCount;
    }

    @Override
    public int edgeSize() {
        return edgeCount;
    }

    @Override
    public int getMC() {
        return mc;
    }

    @Override
    public String toString() {
        return graphTable.values() + "";
    }
}


