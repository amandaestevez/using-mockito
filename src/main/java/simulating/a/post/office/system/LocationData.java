package simulating.a.post.office.system;


public class LocationData {

    private String state;
    private String city;
    private String address;
    private String complement;
    private String neighborhood;

    public LocationData(final String state, final String city, final String address, final String complement, final String neighborhood) {

        this.state = state;
        this.city = city;
        this.address = address;
        this.complement = complement;
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getCity () {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}
