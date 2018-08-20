package lesson11.HomeWork;

import javax.naming.ldap.Control;
import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        //*************************** TESTS ******************************

        Room room1 = new Room(1123, 500, 3, new Date(), "Atlanta", "Kiev");
        Room room2 = new Room(1124, 600, 1, new Date(), "At Joe", "NY");
        Room room3 = new Room(1125, 1500, 2, new Date(), "Malibu", "Odessa");
        Room room4 = new Room(1126, 900, 1, new Date(), "Ukaraine", "Dnepr");
        Room room5 = new Room(1127, 4500, 2, new Date(), "Lux Hostel", "Kiev");
        Room room6 = new Room(1128, 2600, 5, new Date(), "Lux Hostel", "Kiev");
        Room room7 = new Room(2127, 4500, 2, new Date(), "Lux Hostel", "Kiev");
        Room room8 = new Room(2128, 2600, 5, new Date(), "Lux Hostel", "Kiev");
        Room room9 = new Room(3123, 600, 3, new Date(), "Atlanta", "Kiev");
        Room room10 = new Room(3124, 500, 2, new Date(), "Atlanta", "Kiev");


        API google = new GoogleAPI(new Room[]{room1, room2, room3});
        API booking = new BookingComAPI(new Room[]{room4, room5, room6, room9});
        API tripAdvisor = new TripAdvisorAPI(new Room[]{room2, room7, room8, room10});

        Controller controller = new Controller(new API[]{google, booking, tripAdvisor});

        //finding compatible (1123, 3123, 3124)
        System.out.println(Arrays.toString(controller.requestRooms(500, 3, "Kiev", "Atlanta")));

        //checking similar rooms (1127 = 2127, 1128 = 2128)
        System.out.println(Arrays.toString(controller.check(booking, tripAdvisor)));

        //room = null
        System.out.println();
        tripAdvisor = new TripAdvisorAPI(new Room[]{null, room2, room7, room8, room10, null});
        System.out.println(Arrays.toString(controller.requestRooms(500, 3, "Kiev", "Atlanta")));
        System.out.println(Arrays.toString(controller.check(booking, tripAdvisor)));

        //api = null
        System.out.println();
        tripAdvisor = null;
        System.out.println(Arrays.toString(controller.check(booking, tripAdvisor)));

    }

}
