package lesson8.ads;

public class HouseAd extends Ad {
    String ownerName;
    String adress;
    double square;
    int floors;

    public HouseAd(long id, int price, String ownerName, String adress, double square, int floors) {
        super(id, price);
        this.ownerName = ownerName;
        this.adress = adress;
        this.square = square;
        this.floors = floors;
    }

    boolean checkOwner() {
        Owners owners = new Owners();

        for (String owner : owners.owners) {
            if (owner == ownerName)
                return true;
        }

        return false;
    }
}
