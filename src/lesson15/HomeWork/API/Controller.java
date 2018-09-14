package lesson15.HomeWork.API;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int size = 0;

        for (API api : apis) {
            Room[] apiRooms = requestRoomsAPI(api, price, persons, city, hotel);
            size += apiRooms.length;
        }

        Room[] rooms = new Room[size];

        int index = 0;
        for (API api : apis) {
            Room[] apiRooms = requestRoomsAPI(api, price, persons, city, hotel);
            for (Room room : apiRooms) {
                rooms[index] = room;
                index++;
            }
        }

        return rooms;
    }

    private Room[] requestRoomsAPI(API api, int price, int persons, String city, String hotel) {
        return api.findRooms(price, persons, city, hotel);
    }

    public Room[] check(API api1, API api2) {
        if (api1 == null || api2 == null)
            return null;

        int size = 0;
        Room[] roomsAPI1 = api1.getAll();
        Room[] roomsAPI2 = api2.getAll();

        for (Room room1 : roomsAPI1) {
            if (room1 == null)
                continue;
            for (Room room2 : roomsAPI2) {
                if (room2 == null)
                    continue;
                if (room1.equals(room2))
                    size++;
            }
        }

        if (size == 0)
            return null;

        int index = 0;
        Room[] rooms = new Room[size];
        for (Room room1 : roomsAPI1) {
            if (room1 == null)
                continue;
            for (Room room2 : roomsAPI2) {
                if (room2 == null)
                    continue;
                if (room1.equals(room2)) {
                    rooms[index] = room1;
                    index++;
                }
            }
        }

        return rooms;
    }
}
