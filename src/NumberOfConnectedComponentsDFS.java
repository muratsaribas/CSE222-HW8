import java.util.ArrayList;

public class NumberOfConnectedComponentsDFS {
    public static int NumberOfConnectedComponentsDFS(Graph graph){
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        ArrayList<Integer> connected = new ArrayList<>();
        int start = 0;
        int[] arr = dfs.getParent();
        for (int i=0; i < arr.length; i++){
            if (arr[i] != -1 && !connected.contains(i))
                connected.add(i);
        }
        for (int i=0; i<arr.length; i++){
            if (arr[i] != -1){
                int temp = arr[i];
                int par = arr[i];
                while (par != -1){
                    temp = par;
                    par = arr[par];
                }
                if (!connected.contains(temp))
                    connected.add(temp);
            }
        }
        return connected.size();
    }
}
