package vehicles;

public class Vehicle {

    private String TYPE;
    private String MANUFACTURER;
    private int MAX_SPEED;

    public Vehicle(String type, String manufacturer, int speed) {
        TYPE = type.toUpperCase();
        MANUFACTURER = manufacturer;
        MAX_SPEED = speed;
    }

    public String get_type() {
        return TYPE;
    }

    public String get_manufacturer() {
        return MANUFACTURER;
    }

    public int get_max_speed() {
        return MAX_SPEED;
    }

}
