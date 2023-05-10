/*
 * Created by Ayomitide OAJ
 * 
 * 
 */

package visualiser;

import java.util.ArrayDeque;

abstract class Deque extends DataStructure {
    private final ArrayDeque<Vertex> frontier = new ArrayDeque<>();

    Deque(Controller controller, int listType) {
        super(controller, listType);
    }
    void push(Vertex node){
        frontier.push(node);
        super.visualiseAdd(node);
    }
    Vertex pop(){
        Vertex node = frontier.pop();
        super.visualiseRemove(node);
        return node;
    }
    void enqueue(Vertex node){
        frontier.add(node);
        super.visualiseAdd(node);
    }
    Vertex dequeue(){
        Vertex node = frontier.remove();
        super.visualiseRemove(node);
        return node;
    }
    public boolean contains(Vertex node){
        return frontier.contains(node);
    }
    public boolean isEmpty(){
        return frontier.isEmpty();
    }
}
