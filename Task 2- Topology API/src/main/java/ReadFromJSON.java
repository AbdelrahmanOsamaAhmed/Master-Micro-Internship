import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadFromJSON {

    public static void ReadJSON(String fileName){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject Topologies = (JSONObject) obj;
            String topologyID = (String) Topologies.get("id");
            JSONArray components = (JSONArray) Topologies.get("components");
            Component[] TopologyComponents = new Component[components.size()];
            int n=0;
            //Iterate over employee array
            for (Object component : components) {
                JSONObject x = (JSONObject) component;
                String type = (String) x.get("type");
                String id = (String) x.get("type");
                JSONObject specs;
                String name;
                if(x.get("resistance")==null){
                    specs = (JSONObject) x.get("m(l)");
                     name = "m(l)";
                }
                else {
                    specs = (JSONObject) x.get("resistance");
                     name = "resistance";
                }
                Object[] defaultAndminAndmax = specs.values().toArray();
                String defaultValue = String.valueOf(defaultAndminAndmax[0]);
                String minValue= String.valueOf(defaultAndminAndmax[1]);
                String maxValue= String.valueOf(defaultAndminAndmax[2]);
                Specifications spec = new Specifications(name,  defaultValue, minValue, maxValue);
                JSONObject netlist = (JSONObject) x.get("netlist");
                Object[] keys = netlist.keySet().toArray();
                Object[] values = netlist.values().toArray();
                Map<String,String> m=new HashMap<>();
                for (int i = 0 ; i < keys.length; i++){
                    m.put((String) keys[i], (String) values[i]);
                }
                NetList TopologyNetList = new NetList(m);
                TopologyComponents[n++]=new Component(type,id,spec,TopologyNetList);
            }
            Topology topology = new Topology(topologyID,TopologyComponents);
            TopologyList.addTopology(topology);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }


}
