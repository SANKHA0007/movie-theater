package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTests {

    @Test
    void movieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 0, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
   //     System.out.println("20 percent discount of 12.5 is "+spiderMan.calculateTicketPrice(showing,0.2));
        assertEquals(10, spiderMan.calculateTicketPrice(showing, 0.2));

    }
    @Test
    void movieWith3DollarsDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
    //    System.out.println("3 dollar discount of 12.5 is "+spiderMan.calculateTicketPrice(showing,0));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing,0));

    }
    @Test
    void failMovieWith3DollarsDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
     //   System.out.println("3 dollar discount of 12.5 is not "+spiderMan.calculateTicketPrice(showing,0));
        assertNotEquals(10.5, spiderMan.calculateTicketPrice(showing,0));

    }

    @Test
    void movieWith2DollarsDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
      //  System.out.println("2 dollar discount of 12.5 is "+spiderMan.calculateTicketPrice(showing,0));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing,0));

    }

    @Test
    void failMovieWith2DollarsDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
       // System.out.println("2 dollar discount of 12.5 is not "+spiderMan.calculateTicketPrice(showing,0));
        assertNotEquals(11.5, spiderMan.calculateTicketPrice(showing,0));

    }

    @Test
    void biggestDiscountWins() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
       // System.out.println("the biggest discount of 12.5 is "+spiderMan.calculateTicketPrice(showing,0.25));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing,0.25));

    }
}
