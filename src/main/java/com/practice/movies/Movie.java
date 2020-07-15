package com.practice.movies;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    public String title;
    public int priceCode;

    public Movie (String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
}
