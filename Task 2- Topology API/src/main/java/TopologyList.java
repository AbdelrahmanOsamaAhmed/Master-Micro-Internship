import java.util.ArrayList;

public class TopologyList {
    private static ArrayList<Topology> topologies=new ArrayList<>();
    public static void addTopology(Topology topology){
        topologies.add(topology);
    }

    public static ArrayList<Topology> getTopologies() {
        return topologies;
    }
}
