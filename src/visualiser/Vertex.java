package visualiser;

import java.util.ArrayList;

public interface Vertex {
    String getId();
    void setParentNode(Vertex node);
    Vertex getParentNode();
    void setScore(double score);
    double getScore();
    void setGScore(double score);
    double getGScore();
    ArrayList<Vertex> getNeighbours();
    double getX();
    double getY();
}
