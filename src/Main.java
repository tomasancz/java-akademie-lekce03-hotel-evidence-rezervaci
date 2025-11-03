import cz.engeto.roomreservation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        BookingManager testBookings = new BookingManager();
        fillBookings(testBookings);

        System.out.println("Počet pracovních pobytů:" + testBookings.getNumberOfWorkingBookings());
        System.out.println("\nPrůměrný počet hostů na rezervaci: " + testBookings.getAverageGuests());
        System.out.println("\nPrvních osm rekreačních rezervací: ");
        testBookings.getTopNHolidayBookings(8).forEach(System.out::println);
        System.out.println("\nStatistiky hostů:");
        testBookings.printGuestStatistics();
        System.out.println("\nPočet pracovních pobytů: " + testBookings.getNumberOfWorkingBookings());
        System.out.println("\nFormátovaný výpis všech rezervací v systému:");
        testBookings.getBookings().forEach(booking -> System.out.println(booking.getFormattedSummary()));

    }

    public static void fillBookings(BookingManager bookings) {
        List<Booking> testBookingList = new ArrayList<>();
        // 1. Karel Dvořák, narozen 15. 5. 1990, si rezervuje pokoj číslo 3 od 1. 6. 2023 do 7. 6. 2023. Bude to pracovní pobyt.
        // 2. Jiný pan Karel Dvořák, narozen 3. 1. 1979, si rezervuje pokoj číslo 2 od 18. 7. 2023 do 21. 7. 2023. Bude to rekreační pobyt.
        // 3. Fyzioterapeutka Karolína Tmavá si rezervuje pokoj číslo 3 na celý srpen (od 1.8. do 31.8.). Bude to pracovní pobyt a druhým hostem bude její partner pan Karel Dvořák, narozen 1990 (ten z první rezervace).
        // 4. Stejná fyzioterapeutka Karolína Tmavá si dále pro své klienty rezervuje pokoj číslo 2 na dvoudenní pobyty v měsíci srpnu 2023. Vytvoř 10 dvoudenních rezervací pro rekreační pobyty.
        //
        //První rezervace bude od 1. do 2. 8., druhá rezervace od 3. do 4. 8., třetí od 5. do 6. 8. atd. Poslední rezervace bude od 19. do 20. 8. 2023.
        //
        //Určitě nevytvářej těchto 10 rezervací pomocí Ctrl-C a Ctrl-V, nebo dokonce tak, že bys je vypisoval(a) ručně. Použij cyklus!


        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5,15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1,3));
        Guest guest3 = new Guest("Karolína", "Tmavá", LocalDate.of(1995, 7,1));

        Room room1 = new Room(1, BigDecimal.valueOf(1500), 1, false, false);
        Room room2 = new Room(2, BigDecimal.valueOf(3500), 2, true, true);
        Room room3 = new Room(3, BigDecimal.valueOf(4200), 2, true, false);

        //        bookings.addBooking(new Booking(guest1,  room3, LocalDate.of(2023,6,1), LocalDate.of(2023,6,7), true));
        //        bookings.addBooking(new Booking(guest2,  room2, LocalDate.of(2023,7,18), LocalDate.of(2023,7,21), false));
        //        Booking booking3 = new Booking(guest3,  room2, LocalDate.of(2023,7,18), LocalDate.of(2023,7,21), true);
        bookings.addBooking(new Booking(guest1,  room3, LocalDate.of(2023,6,1), LocalDate.of(2023,6,7), TripPurpose.BUSINESS));
        bookings.addBooking(new Booking(guest2,  room2, LocalDate.of(2023,7,18), LocalDate.of(2023,7,21), TripPurpose.VACATION));
        Booking booking3 = new Booking(guest3,  room2, LocalDate.of(2023,7,18), LocalDate.of(2023,7,21), TripPurpose.BUSINESS);
        booking3.addGuest(guest1);
        bookings.addBooking(booking3);
        for (int i=1; i < 20; i+=2){
        //        bookings.addBooking(new Booking(guest3,  room3, LocalDate.of(2023,8,i), LocalDate.of(2023,8,i+1), false));
            bookings.addBooking(new Booking(guest3,  room3, LocalDate.of(2023,8,i), LocalDate.of(2023,8,i+1), TripPurpose.VACATION));
        }

    }

}
