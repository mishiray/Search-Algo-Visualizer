package algorithms;

import visualiser.Algorithm;

public class DepthLimited extends Algorithm {

    public void setPseudocode(){
        pseudocode.addAll(
                "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        ""
        );
    }

    @Override
    public void solve(){
        initializeFrontierAs(Algorithm.STACK);
        frontier.add(start);
        step(0);

    }
}
