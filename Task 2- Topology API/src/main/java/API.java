import java.util.ArrayList;

public class API {
    public static void PrintTopologies(){
        ArrayList<Topology> topologies = TopologyList.getTopologies();
        for (Topology t : topologies) System.out.println(t);
    }
    public static void WriteTopology(String fileName){
        WriteInJSON.WriteTopologyToFile(fileName,WriteInJSON.CreateTopology());
    }
    public static void ReadTopology(String fileName){
        ReadFromJSON.ReadJSON(fileName);
    }
}
