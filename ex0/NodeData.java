package ex0;
import java.util.*;

/** This Class Represent a Vertex in an Unweighted & Undirected Graph
 *  Using a HashMap Data Structure
 *  to store the Neighbors of the Vertex
 *  give each Vertex a unique ID
 */
public class NodeData implements node_data {
    private static int ky=0 ;
    private int tag = -1;
    private String meta_data;
    private  HashMap<Integer, node_data> adjacency;
    private int key;

    public NodeData() {
        this.key = ky;
        ky++;
        this.tag = tag;
        this.adjacency = new HashMap<Integer, node_data>();
    }
    public NodeData(node_data node){
        this.key = node.getKey();
        this.setTag(node.getTag());
        this.setInfo(node.getInfo());
        this.adjacency = new HashMap<Integer, node_data>();
    }

    @Override
    public int getKey() {
        return key;
    }

    /** This Method give a Collection of the Neighbors of the Vertex
     * @return
     */
    @Override
    public Collection<node_data> getNi() {
        return adjacency.values();
    }

    /** This Method check if a Vertex is in the Neighbors
     * @param key
     * @return
     */
    @Override
    public boolean hasNi(int key) {
        return adjacency.containsKey(key);
    }

    /** This Method add a Vertex to the Neighbors list
     *
     * @param t
     */
    @Override
    public void addNi(node_data t) {
        if(t == null) { return; }
        if (!adjacency.containsKey(t.getKey())) {
            if (this.key != t.getKey()) {
                adjacency.put(t.getKey(), t);
            }
        }
        return;
    }

    @Override
    public void removeNode(node_data node) {
        if (node == null) return;
        adjacency.remove(node.getKey());

    }

    @Override
    public String getInfo() {
        return meta_data;
    }

    @Override
    public void setInfo(String s) {
        this.meta_data = s;
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setTag(int t) {
        tag = t;
    }

    @Override
    public String toString() {
        String res = "( "+this.key+" |" ;
        for (node_data n : this.getNi()) {
            res = res +n.getKey()+" , " ;
        }
        return res + " )" ;
    }
}
