import java.util.HashMap;
import java.util.Map;

public class NetList {
    private Map<String,String> netList;

    public NetList(Map<String,String> netList) {
        this.netList = netList;
    }

    public Map<String,String> getNetList() {
        return netList;
    }

    public void setNetList(Map<String,String> netList) {
        this.netList = netList;
    }

    @Override
    public String toString() {
        String netListString="{";
        for (Map.Entry<String, String> entry : netList.entrySet()) {
            netListString +=  entry.getKey() + ":" + entry.getValue().toString() ;
        }
        return netListString+"}";
    }
}
