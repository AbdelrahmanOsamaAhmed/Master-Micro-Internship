public class Component {
    private String type;
    private String id;
    private Specifications specifications;
    private NetList netList;

    public Component(String type, String id, Specifications specifications, NetList netList) {
        this.type = type;
        this.id = id;
        this.specifications = specifications;
        this.netList = netList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public NetList getNetList() {
        return netList;
    }

    public void setNetList(NetList netList) {
        this.netList = netList;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ",\n"+specifications.getName()+" = \n" + specifications.toString() +
                ", \nnetList=" + netList.toString() +
                '}';
    }
}
