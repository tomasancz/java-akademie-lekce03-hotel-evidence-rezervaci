package cz.engeto.roomreservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// [Domácí úkol - lekce 2]
public class Booking {
    private List<Guest> guestList = new ArrayList<>();
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    // private boolean isBusinessTrip;
    private TripPurpose tripPurpose;
    DateTimeFormatter czechFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // region Constructors
    // public Booking(Guest guest, Room room,  LocalDate checkInDate, LocalDate checkOutDate, boolean isBusinessTrip) {
    public Booking(Guest guest, Room room,  LocalDate checkInDate, LocalDate checkOutDate, TripPurpose tripPurpose) {
        this.guestList.add(guest);
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        //this.isBusinessTrip = isBusinessTrip;
        this.tripPurpose = tripPurpose;
    }

    public Booking(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        //  this(guest, room, checkInDate, checkOutDate, false);
        this(guest, room, checkInDate, checkOutDate, TripPurpose.VACATION);
    }
    // endregion

    // region Getters and setters
    public List<Guest> getGuestList() {
        return guestList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

//    public boolean isBusinessTrip() {
//        return isBusinessTrip;
//    }
//
//    public void setBusinessTrip(boolean businessTrip) {
//        isBusinessTrip = businessTrip;
//    }

    public TripPurpose getTripPurpose() {
        return tripPurpose;
    }

    public void setTripPurpose(TripPurpose tripPurpose) {
        this.tripPurpose = tripPurpose;
    }

    // endregion


    public void addGuest(Guest guest) {
        this.guestList.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.guestList.remove(guest);
    }

    public int getGuestsCount() {
        return guestList.size();
    }

    // [Domácí úkol - lekce 3]
    //region [Domácí úkol - lekce 3: Doplňující informace o rezervacích]
    public long getBookingLength() {
        //return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return checkInDate.until(checkOutDate).getDays();
    }

    public BigDecimal getTotalPrice() {
        return getRoom().getPrice().multiply(BigDecimal.valueOf(getBookingLength()));
    }

    public String getFormattedSummary() {
        return getCheckInDate().format(czechFormat) + " až " + getCheckOutDate().format(czechFormat) +
                ": " + getGuestList().get(0).getName() + " " + getGuestList().get(0).getSurname() +
                " (" + getGuestList().get(0).getBirthdate().format(czechFormat) + ") [počet hostů: " + getGuestsCount() +
                ", výhled na moře: " + (getRoom().isHasSeaView() ? "ano" : "ne") + "] za "  + getTotalPrice() + " Kč.";
        //datumOd až datumDo: jméno hlavního hosta (datum narození)[počet hostů celkem, výhledNaMoře ano/ne] za cena
    }
    //endregion

    public String getDescription() {
        StringBuilder description = new StringBuilder("Rezervace pokoje č." + room.getRoomNumber() +
                " na termín " + getCheckInDate().format(czechFormat) + "-" + getCheckOutDate().format(czechFormat) +
                //     "/" + (isBusinessTrip() ? "(služební cesta)" : "") + " pro ");
                ": " + getTripPurpose() + " pobyt" + " pro ");
        Iterator<Guest> iterator = guestList.iterator();
        while (iterator.hasNext()){
            description.append(iterator.next().getDescription());
            if(iterator.hasNext()) {
                description.append(", ");
            } else {
                description.append(".");
            }
        }
        return description.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
