package com.practice.movies;

import java.util.Enumeration;
import java.util.Vector;

@SuppressWarnings("ALL")
public class Customer {
    public String name;
    public Vector rentals = new Vector();

    public Customer(String name, Vector rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + name + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amount for each line
            switch (each.movie.priceCode) {
                case Movie.REGULAR :
                    thisAmount += 2;
                    if (each.daysRented > 2)
                        thisAmount += (each.daysRented - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.daysRented > 3)
                        thisAmount += (each.daysRented - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.movie.priceCode == Movie.NEW_RELEASE) && each.daysRented > 1)
                frequentRenterPoints ++;

            // show figures for this rental
            result += "\t" + each.movie.title + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }
}
