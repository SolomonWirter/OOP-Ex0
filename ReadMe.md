#Ex0 Project - Unweighted & Undirected Graph. - Welcome !

**This Project represent 3 Classes:**
	
*Class NodeData-*

**Each Node is representing a Vertex of the Graph.**

_Contains these elements:_

* Key for identification.
* Tag Integer for using in Graph Algorithms.
* `HashMap` Data Structure for storing the neighbors of each Vertex & the Key for the current Vertex.
**Info:** 
* Receiving a Key `getKey()` , to receive Neighbors list `getNi()` & check if Vertexes are Neighbors `hasNi(Key)` 
* Add/Remove a Vertex to/from another Vertex Neighbors list `addNi(Vertex)` / `removeNode(Vertex)`.

*Class Graph_DS-*

**Graph<V,E> `V` - for Vertex , `E` - for Edges.**
>The Graph is using `HashMap` Data Structure for storing all the Vertexes of the Graph & Key for quick access to each Vertex.

**Info:**
* Receiving/Add a Vertex from/to the Graph `getNode(Key)` / `addNode(Vertex)`
* Check (Or Connect) if there is an Edge between 2 Vertexes `hasEdge(Vertex1,Vertex2)` - return Boolean, Can use `connect(Vertex1,Vertex2)` if there is no Edge.
* Remove a Vertex from Graph `removeNode(Key)` Remove an Edge `removeEdge(Vertex1,Vertex2)`
* Collection of the Graph Vertex is reachable by `getV()` , Collection of Vertex Neighbors is reachable by `getV(Key)`

*Class Graph_Algo-*

>* Checking the Graph above if it is Connected - (Every Vertex is reachable from Every Vertex).
>* Returning the Shortest path from Vertex - A to Vertex - B, (A,B\ \in\ V)
>* Those Methods Using Breadth First Search Algorithm - For traversing on the Graph and gives each Vertex (that reachable from src Vertex) a Tag Value
>
**info:**
* For checking if the Graph is connected apply `isConnected()` - return Boolean on the Graph
* There are 2 Methods for receiving the Shortest Path -
* `shortestPathDist(src - Key, dest - Key)` - return Integer - represent the shortest distance from src to dest (Number of Edges)
* `shortestPath(src - Key, dest - Key)` - return List - Vertex(src) -> Vertex(1) -> V -> V -> ... -> Vertex(dest)




