import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriteInJSON {

    public static Topology CreateTopology(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the ID of the Topology: ");
        String topologyID = scan.nextLine();
        System.out.print("\n How many Components does this topology have? :");
        int numberOfComponents = scan.nextInt();
        scan.nextLine();
        Component[] components = new Component[numberOfComponents];
        for (int i = 0 ; i < numberOfComponents; i++){
            System.out.print("Enter the type of Component "+(i+1) +": ");
            String type = scan.nextLine();
            System.out.print("Enter the ID of Component "+(i+1) +": ");
            String id = scan.nextLine();
            System.out.println("Enter the specification type: (something like resistance or m(l)) ");
            String specificationName = scan.nextLine();
            System.out.println("Enter the default value: ");
            //double defaultValue= scan.nextDouble(); scan.nextLine();
            String defaultValue = scan.nextLine();
            System.out.println("Enter the minimum value: ");
            String minValue = scan.nextLine();
            System.out.println("Enter The maximum value: ");
            String maxValue = scan.nextLine();
            Specifications specifications = new Specifications(specificationName,defaultValue,minValue,maxValue);
            Map<String,String> netList = new HashMap<String,String>();
            System.out.println("Enter the number of required NetList elements: ");
            int netListNumber = scan.nextInt(); scan.nextLine();
            for (int j = 0 ; j < netListNumber; j++){
                System.out.println("Enter the NetList label: ");
                String name = scan.nextLine();
                System.out.println("Enter the value: ");
                String value = scan.nextLine();
                netList.put(name,value);
            }
            NetList netListComponent = new NetList(netList);
            components[i]=new Component(specificationName,id,specifications,netListComponent);
        }
        Topology topology = new Topology(topologyID,components);
        TopologyList.addTopology(topology);
        return topology;
    }
    public static void WriteTopologyToFile(String fileName,Topology topology){
        ObjectMapper mapper = new ObjectMapper();
        JSONObject topologyJSON = new JSONObject();
        String id = topology.getId();
        topologyJSON.put("id",id);
        JSONArray componentsJSON = new JSONArray();
        Component[] components = topology.getComponents();
        for (Component component : components){
            JSONObject componentI = new JSONObject();
            componentI.put("type",component.getType());
            componentI.put("id",component.getId());
            Specifications specs = component.getSpecifications();
            JSONObject specsJSON = new JSONObject();
            specsJSON.put("default",specs.getDefaultValue());
            specsJSON.put("min",specs.getMinValue());
            specsJSON.put("max",specs.getMaxValue());
            componentI.put(specs.getName(),specsJSON);
            NetList netListI = component.getNetList();
            JSONObject netListJSON = new JSONObject();
            for (Map.Entry<String,String> m : netListI.getNetList().entrySet()){
                netListJSON.put(m.getKey(),m.getValue());
            }
            componentI.put("netlist",netListJSON);



            componentsJSON.add(componentI);

        }
        topologyJSON.put("components",componentsJSON);

        try (FileWriter file = new FileWriter(fileName,true)) {
            //We can write any JSONArray or JSONObject instance to the file

            file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(topologyJSON));
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


















