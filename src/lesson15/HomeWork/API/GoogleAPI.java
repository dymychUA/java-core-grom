package lesson15.HomeWork.API;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int size = 0;
        for (Room room : rooms) {
            if (persons == room.getPersons() && city.equals(room.getCityName()) &&
                    hotel.equals(room.getHotelName()) && price == room.getPrice())
                size++;
        }

        Room[] compatibleRooms = new Room[size];

        int index = 0;
        for (Room room : rooms) {
            if (persons == room.getPersons() && city.equals(room.getCityName()) &&
                    hotel.equals(room.getHotelName()) && price == room.getPrice()) {
                compatibleRooms[index] = room;
                index++;
            }
        }

        return compatibleRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
