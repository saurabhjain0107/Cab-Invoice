package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    private int totalNumberOfRides;
    private double totalFare;
    private double averageFare;

    public Invoice(int totalNumberOfRides, double totalFare, double averageFare) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    public void setAverageFare(double averageFare) {
        this.averageFare = averageFare;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalNumberOfRides=" + totalNumberOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalNumberOfRides == invoice.totalNumberOfRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.averageFare, averageFare) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(totalNumberOfRides, totalFare, averageFare);
    }
}
