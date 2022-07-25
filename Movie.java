package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    //private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;


    public Movie(String title, Duration runningTime, double ticketPrice) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing,double splCode ) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(),splCode);
    }

    private double getDiscount(int showSequence, double splCode) {
        double specialDiscount = 0;
        if (splCode ==0.2) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }
        if(splCode==0.25){
            specialDiscount = ticketPrice * 0.25;  // 25% discount for special movie
        }

        double sequenceDiscount=0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        }else if(showSequence == 2){
            sequenceDiscount = 2; // $2 discount for 2nd show
        }
        else if (showSequence == 3){
            sequenceDiscount = 1; // $1 discount showing on 7th
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        // biggest discount wins
        return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice);
    }
}