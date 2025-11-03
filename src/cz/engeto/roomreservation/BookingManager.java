package cz.engeto.roomreservation;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    //region [Domácí úkol - lekce 3: Seznam rezervací]
    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public void addAllBookings(List<Booking> bookingList) {
        this.bookingList.addAll(bookingList);
    }

    public Booking getBooking(int index) {
        return bookingList.get(index);
    }

    public List<Booking> getBookings() {
        return bookingList;
    }

    public void clearBookings() {
        bookingList.clear();
    }
    //endregion

    //region [Domácí úkol - lekce 3: Souhrnné informace o rezervacích]
    public int getNumberOfWorkingBookings() {
        int workingBookings = 0;
        for (Booking booking : bookingList) {
        //    if (booking.isBusinessTrip()) {
              if (booking.getTripPurpose() == TripPurpose.BUSINESS) {
                workingBookings++;
            }
        }
        return workingBookings;
    }

    public double getAverageGuests() {
        int guestTotalNumber = 0;
        for (Booking booking : bookingList) {
            guestTotalNumber += booking.getGuestsCount();
        }
        return (double) guestTotalNumber / bookingList.size();
    }

    public List<Booking> getTopNHolidayBookings(int topNumber){
        int numberOfHolidays = 0;
        List<Booking> topNHolidayBookings = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (numberOfHolidays >= topNumber) {
                break;
            }
            // if(!booking.isBusinessTrip()){
            if(booking.getTripPurpose() == TripPurpose.VACATION){
                topNHolidayBookings.add(booking);
                numberOfHolidays++;
            }
        }

        return topNHolidayBookings;
    }

    public void printGuestStatistics() {
        int reservationsOneGuest = 0;
        int reservationTwoGuests = 0;
        int reservationMoreGuests =0;
        for (Booking booking : bookingList) {
            int numOfGuests = booking.getGuestsCount();
            if ( numOfGuests == 1) {
                reservationsOneGuest++;
            } else if (numOfGuests == 2) {
                reservationTwoGuests++;
            } else if (numOfGuests > 2) {
                reservationMoreGuests++;
            }
        }
        System.out.println("Celkový počet rezervací s jedním hostem: " + reservationsOneGuest);
        System.out.println("Celkový počet rezervací s dvěma hosty: " + reservationTwoGuests);
        System.out.println("Celkový počet rezervací s více než dvěma hosty: " + reservationMoreGuests);

    }
    //endregion

}
