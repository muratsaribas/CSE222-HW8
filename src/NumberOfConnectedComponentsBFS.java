import java.util.ArrayList;

public class NumberOfConnectedComponentsBFS {

    public static int NumberOfConnectedComponentsBFS(Graph graph){
        ArrayList<Integer> connected = new ArrayList<>();
        int start = 0;
        int[] arr;
        while (start < graph.size()){
            arr = BreadthFirstSearch.breadthFirstSearch(graph, start);
            for (int i=0; i< arr.length; i++){
                if (arr[i] != -1 && !connected.contains(i))
                    connected.add(i);
            }
            start++;
        }
        return connected.size();
    }
}
