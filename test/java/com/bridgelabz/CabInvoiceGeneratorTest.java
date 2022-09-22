package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator generator;

    @BeforeEach
    void initilize(){
        generator = new CabInvoiceGenerator();
    }

    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){
        double totalFare = generator.calculateFare(4.4,4);
        Assertions.assertEquals(48, totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinimumFare(){
        double totalFare = generator.calculateFare(0.3,1);
        Assertions.assertEquals(5, totalFare);
    }
    @Test
    void givenMultipleRidesShouldReturnTotalFare(){
        Ride ride1 = new Ride(4,10);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        double totalFare = generator.calculateFare(rides);
        Assertions.assertEquals(150.0, totalFare);
    }
    @Test
    void givenMultipleRidesShouldReturnInvoice(){
        Ride ride1 = new Ride(4,10);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
       Invoice actualInvoice = generator.generateInvoice(rides);
       Invoice expectedInvoice = new Invoice(3,150.0,50.0);
       Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    void givenUserIdShouldReturnInvoice(){
        Ride ride1 = new Ride(4,10);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Customer customer = new Customer(1);
        customer.rideList = rides;
//        customer.rideList.add(ride1);
//        customer.rideList.add(ride2);
//        customer.rideList.add(ride3);
        CabInvoiceGenerator.customerList.add(customer);
        Ride ride4 = new Ride(3,15);
        Ride[] rides1 = new Ride[]{ride4};
        Customer customer2 = new Customer(2);
        customer2.rideList = rides1;
//        customer2.rideList.add(ride4);
        CabInvoiceGenerator.customerList.add(customer2);
       Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3,150.0,50.0);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    void givenUserIdHavingPremiumRides_ShouldReturn_Invoice(){
        Ride ride1 = new Ride(10, 6, Ride.Category.PREMIUM_RIDE);
        Ride ride2 = new Ride(5,10);
        Ride ride3 = new Ride(3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Customer customer = new Customer(1);
        customer.rideList = rides;
        CabInvoiceGenerator.customerList.add(customer);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3,170.0,56.666666666666664);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}
