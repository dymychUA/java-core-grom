package lesson15.HomeWork.API;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int size = 0;
        for (Room room : rooms) {
            if (persons == room.getPersons() && city.equals(room.getCityName()) &&
                hotel.equals(room.getHotelName()) && Math.min(0, price -100) <= price && price <= (price + 100))
                size++;
        }

        Room[] compatibleRooms = new Room[size];

        int index = 0;
        for (Room room : rooms) {
            if (persons == room.getPersons() && city.equals(room.getCityName()) &&
                    hotel.equals(room.getHotelName()) &&
                    Math.max(0, price -100) <= room.getPrice() && room.getPrice() <= (price + 100)) {
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
