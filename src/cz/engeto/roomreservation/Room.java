package cz.engeto.roomreservation;

import java.math.BigDecimal;
import java.math.BigInteger;

// [Domácí úkol - lekce 2]
public class Room {
    private int roomNumber;
    private BigDecimal price;   // price in CZK
    private int numOfBeds;
    private boolean hasBalcony;
    private boolean hasSeaView;

    //region Constructors
    public Room (int roomNumber, BigDecimal price, int numOfBeds, boolean hasBalcony, boolean hasSeaView) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.numOfBeds = numOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
    }

    public Room (int roomNumber, BigDecimal price) {
        this(roomNumber, price, 2, false, false);
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    // endregion

    //region Getters and setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    // endregion

    public String getDescription() {
        String description = "Pokoj č." + roomNumber + ": " + numOfBeds + " lůžka";
        if (hasBalcony) {
            description += ", s balkónem";
        } else {
            description += ", bez balkónu";
        }
        if (hasSeaView) {
            description += ", s výhledem na moře";
        } else {
            description += ", bez výhledu na moře";
        }
        description += ", cena za noc: " + getPrice() + " Kč";
        return description;
    }
}
