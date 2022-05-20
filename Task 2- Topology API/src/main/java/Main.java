import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Topology API test");
        while (true){
            System.out.println("Select method to test: ");
            System.out.println("1- Read the file and store the available topologies in the list.");
            System.out.println("2- Manually add a topology");
            System.out.println("3- print the topology list");
            System.out.println("4- Exit");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt(); scanner.nextLine();
            if(x==1){
                String fileName="";
                System.out.println("Do you want to read the topology.json ?y/n");
                String answer = scanner.nextLine();
                if(Objects.equals(answer, "y") || Objects.equals(answer,"Y")){
                    fileName="topology.json";
                }
                else {
                    System.out.println("Enter the file name: ");
                    fileName = scanner.nextLine();

                }
                API.ReadTopology(fileName);
            }
            else if (x==2){
                String fileName="";
                System.out.println("Do you want to write to the topology.json ?y/n");
                String answer = scanner.nextLine();
                if(Objects.equals(answer, "y") || Objects.equals(answer,"Y")){
                    fileName="topology.json";
                }
                else {
                    System.out.println("Enter the file name: ");
                    fileName = scanner.nextLine();

                }
                API.WriteTopology(fileName);
            }
            else if(x==3){
                API.PrintTopologies();
            }
            else {
                System.out.println("Goodbye :)");
                break;
            }

            }
        }

}
