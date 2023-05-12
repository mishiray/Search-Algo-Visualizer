/*
 * Created by The Code Implementation, Mar 2020.
 * Youtube channel: https://www.youtube.com/channel/UCecfXH0CwYv-CA0Oo3-8PFg
 * Github: https://github.com/TheCodeImplementation
 */

package algorithms;

import visualiser.Algorithm;
import visualiser.DataStructure;
import visualiser.Vertex;
import visualiser.VisNode;

public class BiDirectional extends Algorithm {

//    startq = Queue for BFS from start node
//    endq = Queue for BFS from end node
//    parent= Array where startparent[i] is parent of node i
//            visited= Array where visited[i]=True if node i has been encountered
//while startq is not empty and endq is not empty
//    perform next iteration of BFS for startq (also save the parent of children in parent array)
//    perform next iteration of BFS for endq
//    if we have encountered the intersection node
//    save the intersection node
//        break
//    using intersection node, find the path using parent array

    public void setPseudocode(){
        pseudocode.addAll(
                "Frontier.add(Start)",
                "startq = Queue for BFS from start node", //Score == fScore
                "endq = Queue for BFS from end node",
                "while startq is not empty and endq is not empty",
                "   perform next iteration of BFS for startq (also save the parent of children in parent array)",
                "   perform next iteration of BFS for endq",
                "       if we have encountered the intersection node",
                "           save the intersection node",
                "           break",
                "           if calcGScore(Current, N) < gScore[N]",
                "     using intersection node, find the path using parent array"
        );
    }

    @Override
    public void solve(){
        initializeFrontierAs(Algorithm.QUEUE);
        initializeFrontier2As(Algorithm.QUEUE);
        frontier.add(start);
        step(0);
        visited.add(start);
        step(1);
        frontier2.add(destination);
        visited2.add(destination);
        int intersection = -1;
        step(2);
        while(!frontier.isEmpty() && !frontier2.isEmpty() && intersection == -1) {
            step(3);
            doBFS(frontier, visited);
            step(4)
            doBFS(frontier2, visited2);
            step(5);
            for (Vertex tmp : getCurrent().getNeighbours()) {
//                setNeighbour(tmp);
                step(7);
                if (visited.contains(getCurrent()) && visited2.contains(getCurrent())) {
                    intersection = 1;
                }
            }

            step(6);
            if(intersection == -1) {
                break;
            }
        }
    }

    private void reconstructPath(Vertex current) {
        addToPath(current);
        Vertex tmp = getCurrent();
        while(tmp.getParentNode() != null){
            tmp = tmp.getParentNode();
            addToPath(tmp);
        }
    }

    public void doBFS(DataStructure frontier, DataStructure visited){
        setCurrent(frontier.remove());
        while(!frontier.isEmpty()){
            setCurrent(frontier.remove());
            if(getCurrent() == destination){
                visited.add(getCurrent());
                break;
            }
            visited.add(getCurrent());
            for(Vertex tmp : getCurrent().getNeighbours()){
                setNeighbour(tmp);
                if(!visited.contains(getNeighbour()) && !frontier.contains(getNeighbour())) {
                    frontier.add(getNeighbour());
                    getNeighbour().setParentNode(getCurrent());
                }
                setNeighbour(null);
            }
        }
    }

    public double calcGScore(Vertex a, Vertex b){
        return a.getGScore()
                + nodeDistance(a, b)
                + getWeight(a, b);
    }

    public double nodeDistance(Vertex a, Vertex b){
        return  Math.sqrt(
                    Math.pow( b.getY() - a.getY(), 2 ) +
                    Math.pow( b.getX() - a.getX(), 2 )
        );
    }

    public String toString(){
        return "BiDirectional";
    }
}
