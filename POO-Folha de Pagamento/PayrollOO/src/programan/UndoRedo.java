package programan;

import java.util.Stack;
import java.util.List;

public class UndoRedo {

    public Stack<List<Employee>> undoStack = new Stack<List<Employee>>();

    public Stack<List<Employee>> redoStack = new Stack<List<Employee>>();

    public Stack<Integer> counterRedo = new Stack<Integer>();

    public Stack<Integer> counterUndo = new Stack<Integer>();

}