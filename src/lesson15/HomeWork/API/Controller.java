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

        for (int i = 0; i < roomsAPI1.length; i++) {
            if (roomsAPI1[i] == null)
                break;
            for (int j = 0; j < roomsAPI2.length; j++) {
                if (roomsAPI2[j] == null)
                    break;
                if (roomsAPI1[i].equals(roomsAPI2[j]))
                    size++;
            }
        }

        int index = 0;
        Room[] rooms = new Room[size];
        for (int i = 0; i < roomsAPI1.length; i++) {
            if (roomsAPI1[i] == null)
                break;
            for (int j = 0; j < roomsAPI2.length; j++) {
                if (roomsAPI2[j] == null)
                    break;
                if (roomsAPI1[i].equals(roomsAPI2[j])) {
                    rooms[index] = roomsAPI1[i];
                    index++;
                }
            }
        }

        return rooms;
    }
}
