package com.bridgelabz;

public class Ride {

    public double time;
    public double distance;
    public Category category;
    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double time, double distance, Category category) {
        this.time = time;
        this.distance = distance;
        this.category = category;
    }

    public enum Category {
        NORMAL_RIDE(10, 1, 5), PREMIUM_RIDE(15, 2, 20);

        public  final double costPerKm;
        public final int costPerMinute;
        public final double minimumFarePerRide;

        Category(double costPerKm, int costPerMinute, double minimumFarePerRide) {
            this.costPerKm = costPerKm;
            this.costPerMinute = costPerMinute;
            this.minimumFarePerRide = minimumFarePerRide;
        }
    }
}
