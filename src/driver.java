import java.util.ArrayList;
import java.util.Random;

public class driver {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 10;
        long startTime = 0;
        long stopTime = 0;
        Random random = new Random();
        int source;
        int dest;
        Edge edge;

        ArrayList<Long> RunningTimes1kBFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes2kBFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes5kBFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes10kBFS = new ArrayList<Long>();

        ArrayList<Long> RunningTimes1kDFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes2kDFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes5kDFS = new ArrayList<Long>();
        ArrayList<Long> RunningTimes10kDFS = new ArrayList<Long>();


        Graph[] graphs_1k = new Graph[10];
        Graph[] graphs_2k = new Graph[10];
        Graph[] graphs_5k = new Graph[10];
        Graph[] graphs_10k = new Graph[10];
        for (int i=0; i<SIZE; i++) {
            graphs_1k[i] = new ListGraph(1000, false);
            graphs_2k[i] = new ListGraph(2000, false);
            graphs_5k[i] = new ListGraph(5000, false);
            graphs_10k[i] = new ListGraph(10000, false);
        }


        int density = 200;
        for (int j=0; j<SIZE; j++){
            int newDensity = density * j + density;
            for (int i=0; i < newDensity; i++){
                source = random.nextInt(graphs_1k[j].size());
                dest = random.nextInt(graphs_1k[j].size());
                edge = new Edge(source, dest);
                graphs_1k[j].insert(edge);
            }
        }

        density = 400;
        for (int j=0; j<SIZE; j++){
            int newDensity = density * j + density;
            for (int i=0; i < newDensity; i++){
                source = random.nextInt(graphs_2k[j].size());
                dest = random.nextInt(graphs_2k[j].size());
                edge = new Edge(source, dest);
                graphs_2k[j].insert(edge);
            }
        }

        density = 1000;
        for (int j=0; j<SIZE; j++){
            int newDensity = density * j + density;
            for (int i=0; i < newDensity; i++){
                source = random.nextInt(graphs_5k[j].size());
                dest = random.nextInt(graphs_5k[j].size());
                edge = new Edge(source, dest);
                graphs_5k[j].insert(edge);
            }
        }

        density = 2000;
        for (int j=0; j<SIZE; j++){
            int newDensity = density * j + density;
            for (int i=0; i < newDensity; i++){
                source = random.nextInt(graphs_10k[j].size());
                dest = random.nextInt(graphs_10k[j].size());
                edge = new Edge(source, dest);
                graphs_10k[j].insert(edge);
            }
        }

        for (int i=0; i < SIZE; i++){
            System.out.println("###### i: " + i);
            startTime = System.nanoTime();
            int count = NumberOfConnectedComponentsBFS.NumberOfConnectedComponentsBFS(graphs_1k[i]);
            stopTime = System.nanoTime();
            RunningTimes1kBFS.add(stopTime - startTime);
            System.out.println("BFS: " + count);

            Thread.sleep(500);
            startTime = System.nanoTime();
            count = NumberOfConnectedComponentsDFS.NumberOfConnectedComponentsDFS(graphs_1k[i]);
            stopTime = System.nanoTime();
            RunningTimes1kDFS.add(stopTime - startTime);
            System.out.println("DFS: " + count);
        }

        for (int i=0; i < SIZE; i++){
            System.out.println("###### i: " + i);
            startTime = System.nanoTime();
            int count = NumberOfConnectedComponentsBFS.NumberOfConnectedComponentsBFS(graphs_2k[i]);
            stopTime = System.nanoTime();
            RunningTimes2kBFS.add(stopTime - startTime);
            System.out.println("BFS: " + count);

            Thread.sleep(500);
            startTime = System.nanoTime();
            count = NumberOfConnectedComponentsDFS.NumberOfConnectedComponentsDFS(graphs_2k[i]);
            stopTime = System.nanoTime();
            RunningTimes2kDFS.add(stopTime - startTime);
            System.out.println("DFS: " + count);
        }

        for (int i=0; i < SIZE; i++){
            System.out.println("###### i: " + i);
            startTime = System.nanoTime();
            int count = NumberOfConnectedComponentsBFS.NumberOfConnectedComponentsBFS(graphs_5k[i]);
            stopTime = System.nanoTime();
            RunningTimes5kBFS.add(stopTime - startTime);
            System.out.println("BFS: " + count);

            Thread.sleep(500);
            startTime = System.nanoTime();
            count = NumberOfConnectedComponentsDFS.NumberOfConnectedComponentsDFS(graphs_5k[i]);
            stopTime = System.nanoTime();
            RunningTimes5kDFS.add(stopTime - startTime);
            System.out.println("DFS: " + count);
        }

        for (int i=0; i < SIZE; i++){
            System.out.println("###### i: " + i);
            startTime = System.nanoTime();
            int count = NumberOfConnectedComponentsBFS.NumberOfConnectedComponentsBFS(graphs_10k[i]);
            stopTime = System.nanoTime();
            RunningTimes10kBFS.add(stopTime - startTime);
            System.out.println("BFS: " + count);

            startTime = System.nanoTime();
            count = NumberOfConnectedComponentsDFS.NumberOfConnectedComponentsDFS(graphs_10k[i]);
            stopTime = System.nanoTime();
            RunningTimes10kDFS.add(stopTime - startTime);
            System.out.println("DFS: " + count);
        }

        System.out.println("### BFS 1k ###");
        System.out.println(RunningTimes1kBFS.toString());
        System.out.println("### BFS 2k ###");
        System.out.println(RunningTimes2kBFS.toString());
        System.out.println("### BFS 3k ###");
        System.out.println(RunningTimes5kBFS.toString());
        System.out.println("### BFS 10k ###");
        System.out.println(RunningTimes10kBFS.toString());

        System.out.println("### DFS 1k ###");
        System.out.println(RunningTimes1kDFS.toString());
        System.out.println("### DFS 2k ###");
        System.out.println(RunningTimes2kDFS.toString());
        System.out.println("### DFS 3k ###");
        System.out.println(RunningTimes5kDFS.toString());
        System.out.println("### DFS 10k ###");
        System.out.println(RunningTimes10kDFS.toString());



    }
}
