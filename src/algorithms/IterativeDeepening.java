package algorithms;

import visualiser.Algorithm;
import visualiser.Vertex;

public class IterativeDeepening extends Algorithm {

    int depth = 10;
    int limit = 2;

    public void setPseudocode(){
        pseudocode.addAll(
                "Stack.put(Start)",
                "while Stack not empty",
                "if depth <= limit",
                "   Current := Stack.pop()",
                "   if Current = Destination",
                "       trace path and finish",
                "   Visited.add(Start)",
                "       for all neighbours (N) of Current",
                "           if N not in Visited or Stack",
                "               Stack.put(N)",
                "               parent[N] := Current",
                "else return path"
        );
    }

    @Override
    public void solve(){
        for (int i = 0; i <= depth; i++)
            DLS(i);
    }

    private void DLS(int depth){
        initializeFrontierAs(Algorithm.STACK);
        frontier.add(start);
        step(0);
        while(!frontier.isEmpty()){
            if(depth <= limit) {
                step(1);
                setCurrent(frontier.remove());
                step(3);
                step(4);
                if (getCurrent() == destination) {
                    visited.add(getCurrent());
                    reconstructPath(getCurrent());
                    drawPath();
                    step(5);
                    break;
                }
                visited.add(getCurrent());
                step(6);
                step(7);
                for (Vertex tmp : getCurrent().getNeighbours()) {
                    setNeighbour(tmp);
                    step(8);
                    if (!visited.contains(getNeighbour()) && !frontier.contains(getNeighbour())) {
                        frontier.add(getNeighbour());
                        step(9);
                        getNeighbour().setParentNode(getCurrent());
                        step(10);
                    }
                    setNeighbour(null);
                }
                depth++;
            }else{
                step(11);
                reconstructPath(getCurrent());
                drawPath();
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

    public String toString(){
        return "DepthLimited";
    }
}
