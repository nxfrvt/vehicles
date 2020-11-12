package vehicles;

import java.util.ArrayList;
import java.util.List;



public class Application {
    Menu menu;

    List<Vehicle> vehicles;
    Vehicle fastest;
    String ranking_type;

    public Application() {
        init_data();

        menu = new Menu();

        while(true) {
            fastest = null;
            ranking_type = null;
            switch(menu.get_choice()) {

                case 1:
                    ranking_type = "CAR";
                    break;

                case 2:
                    ranking_type = "BOAT";
                    break;

                case 3:
                    ranking_type = "PLANE";
                    break;

                case 4:
                    ranking_type = "BICYCLE";
                    break;

                case 5:
                    ranking_type = "ALL";
                    break;

                case 6:
                    System.out.println("Application closed.");
                    System.exit(0);

                default:
                    System.out.println("Please choose a valid option.");
            }
            if (ranking_type != null) {
                find_the_fastest(ranking_type);
                print_the_fastest(ranking_type, fastest);
            }
        }
    }

    private void find_the_fastest(String type) {
        for(Vehicle vehicle : vehicles) {
            if(vehicle.get_type().equals(type) || type.equals("ALL")) {
                if(fastest == null || vehicle.get_max_speed() > fastest.get_max_speed()) {
                    fastest = vehicle;
                }
            }
        }
    }

    private void print_the_fastest(String type, Vehicle vehicle) {
        System.out.printf("In ranking of %s vehicles, the fastest one is %s with %dkm/h top speed.",
                type.toLowerCase(),
                vehicle.get_manufacturer(),
                vehicle.get_max_speed());
    }

    private void init_data() {
        vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Vehicle("CAR", "BMW", 265));
        vehicles.add(new Vehicle("CAR", "Audi", 320));
        vehicles.add(new Vehicle("BOAT", "Boston Whaler", 54));
        vehicles.add(new Vehicle("BOAT", "Yamaha", 80));
        vehicles.add(new Vehicle("PLANE", "Airbus", 1185));
        vehicles.add(new Vehicle("PLANE", "Boeing", 930));
        vehicles.add(new Vehicle("BICYCLE", "Raleigh", 45));
        vehicles.add(new Vehicle("BICYCLE", "Felt", 32));
    }
}
