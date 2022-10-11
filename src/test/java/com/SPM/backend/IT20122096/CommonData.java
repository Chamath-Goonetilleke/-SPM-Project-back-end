package com.SPM.backend.IT20122096;

import com.SPM.backend.IT20122096.LoginRegistrationAuth.DTO.UserRegisterDTO;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.Admin;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.User;
import com.SPM.backend.IT20122096.Places.DTO.PlaceDTO;
import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.TravelPackage.DTO.TravelPackageDTO;
import com.SPM.backend.IT20122096.TravelPackage.Entity.TravelPackage;
import com.SPM.backend.IT20122096.TripPlaning.DTO.PaymentDTO;
import com.SPM.backend.IT20122096.TripPlaning.DTO.TripPlanDTO;
import com.SPM.backend.IT20122096.TripPlaning.Entity.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class CommonData {
    public TripPlanDTO getTripDTO() {
        TripPlanDTO tripPlanDTO = new TripPlanDTO();

        tripPlanDTO.setId(new ObjectId("633372dc0a880e615b3efbce"));
        tripPlanDTO.setUserId(new ObjectId("6331d725d613b66fd9db0f19"));
        tripPlanDTO.setName("Trip to Sigiriya");
        tripPlanDTO.setType("Individual");
        tripPlanDTO.setStartDate("2022-09-20T20:37:36.000Z");
        tripPlanDTO.setEndDate("2022-09-27T20:37:38.000Z");

        Place place = new Place();
        place.setId(new ObjectId("633372dc0a880e615b3efbce"));
        List<VisitingPlace> visitingPlaces = new ArrayList<>();
        visitingPlaces.add(new VisitingPlace("633372dc0a880e615b3efbce", "Rock", "imageUrl"));
        place.setVisitingPlaces(visitingPlaces);

        Accommodation accommodation = new Accommodation();
        accommodation.setId(new ObjectId("633372dc0a880e615b3efbce"));
        accommodation.setNumOfMembers(4);
        accommodation.setTotal(100000.00);
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(123, "Single", 5, 12000.00));
        accommodation.setRooms(rooms);

        Transportation transportation = new Transportation();
        transportation.setId(new ObjectId("633372dc0a880e615b3efbce"));
        transportation.setNumOfKilometers("100");
        transportation.setTotal(10000.00);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("633372dc0a880e615b3efbce", "Car", 5, 1000.00));
        transportation.setVehicles(vehicles);

        tripPlanDTO.setPlace(place);
        tripPlanDTO.setAccommodation(accommodation);
        tripPlanDTO.setTransportation(transportation);
        tripPlanDTO.setTotalCost(200000.00);
        tripPlanDTO.setBooked(false);

        return tripPlanDTO;
    }

    public TripPlan getTripPlan() {
        TripPlanDTO tripPlanDTO = getTripDTO();

        TripPlan tripPlan = new TripPlan();
        tripPlan.setId(new ObjectId());
        tripPlan.setUserId(tripPlanDTO.getUserId());
        tripPlan.setName(tripPlanDTO.getName());
        tripPlan.setType(tripPlanDTO.getType());
        tripPlan.setStartDate(tripPlanDTO.getStartDate());
        tripPlan.setEndDate(tripPlanDTO.getEndDate());
        tripPlan.setPlace(tripPlanDTO.getPlace());
        tripPlan.setAccommodation(tripPlanDTO.getAccommodation());
        tripPlan.setTransportation(tripPlanDTO.getTransportation());
        tripPlan.setTotalCost(tripPlanDTO.getTotalCost());
        tripPlan.setBooked(false);

        return tripPlan;
    }

    public List<TripPlan> getTripPlanList(String type) {
        List<TripPlan> tripPlans = new ArrayList<>();
        TripPlanDTO tripPlanDTO = getTripDTO();
        for (int x = 0; x < 4; x++) {

            TripPlan tripPlan = new TripPlan();
            tripPlan.setId(new ObjectId("633372dc0a880e615b3efbce"));
            tripPlan.setUserId(tripPlanDTO.getUserId());
            tripPlan.setName(tripPlanDTO.getName());
            tripPlan.setType(tripPlanDTO.getType());
            tripPlan.setStartDate(tripPlanDTO.getStartDate());
            tripPlan.setEndDate(tripPlanDTO.getEndDate());
            tripPlan.setPlace(tripPlanDTO.getPlace());
            tripPlan.setAccommodation(tripPlanDTO.getAccommodation());
            tripPlan.setTransportation(tripPlanDTO.getTransportation());
            tripPlan.setTotalCost(tripPlanDTO.getTotalCost());
            if (type.equals("bookings")) {
                tripPlan.setBooked(true);
            } else {
                tripPlan.setBooked(false);
            }

            tripPlans.add(tripPlan);
        }
        return tripPlans;
    }

    public TravelPackageDTO getPackageDTO() {
        Place place = new Place();
        place.setId(new ObjectId("633372dc0a880e615b3efbce"));
        List<VisitingPlace> visitingPlaces = new ArrayList<>();
        visitingPlaces.add(new VisitingPlace("633372dc0a880e615b3efbce", "Rock", "imageUrl"));
        place.setVisitingPlaces(visitingPlaces);

        Accommodation accommodation = new Accommodation();
        accommodation.setId(new ObjectId("633372dc0a880e615b3efbce"));
        accommodation.setNumOfMembers(4);
        accommodation.setTotal(100000.00);
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(123, "Single", 5, 12000.00));
        accommodation.setRooms(rooms);

        Transportation transportation = new Transportation();
        transportation.setId(new ObjectId("633372dc0a880e615b3efbce"));
        transportation.setNumOfKilometers("100");
        transportation.setTotal(10000.00);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("633372dc0a880e615b3efbce", "Car", 5, 1000.00));
        transportation.setVehicles(vehicles);

        TravelPackageDTO travelPackageDTO = new TravelPackageDTO();
        travelPackageDTO.setName("Test Package");
        travelPackageDTO.setType("Budget");
        travelPackageDTO.setNoOfDays(5);
        travelPackageDTO.setPlace(place);
        travelPackageDTO.setAccommodation(accommodation);
        travelPackageDTO.setTransportation(transportation);
        travelPackageDTO.setTotalCost(200000.00);
        travelPackageDTO.setDiscount(20);
        return travelPackageDTO;
    }

    public TravelPackage getPackage(int x) {

        TravelPackageDTO travelPackageDTO = getPackageDTO();

        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setId(new ObjectId("6" + x + "3372dc0a880e615b3efbce"));
        travelPackage.setName(travelPackageDTO.getName());
        travelPackage.setType(travelPackageDTO.getType());
        travelPackage.setNoOfDays(travelPackageDTO.getNoOfDays());
        travelPackage.setPlace(travelPackageDTO.getPlace());
        travelPackage.setAccommodation(travelPackageDTO.getAccommodation());
        travelPackage.setTransportation(travelPackageDTO.getTransportation());
        travelPackage.setTotalCost(travelPackageDTO.getTotalCost());
        travelPackage.setDiscount(travelPackageDTO.getDiscount());

        return travelPackage;
    }

    public List<TravelPackage> getPackageList() {
        List<TravelPackage> travelPackages = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            TravelPackage travelPackage = getPackage(x + 4);
            travelPackages.add(travelPackage);
        }
        return travelPackages;
    }

    public PaymentDTO getPaymentDTO() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTripPlanId(new ObjectId("6331d725d613b66fd9db0f19"));
        paymentDTO.setType("Trip Plan");
        paymentDTO.setDate("2022-09-20T20:37:36.000Z");
        paymentDTO.setUserId(new ObjectId("6331d725d613b66fd9db0f19"));
        paymentDTO.setAmount(12000.00);

        return paymentDTO;
    }

    public Payment getPayment() {
        PaymentDTO paymentDTO = getPaymentDTO();
        Payment payment = new Payment();
        payment.setTripPlanId(paymentDTO.getTripPlanId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setType(paymentDTO.getType());
        payment.setDate(paymentDTO.getDate());
        payment.setUserId(paymentDTO.getUserId());

        return payment;
    }

    public List<Payment> getPaymentList() {
        List<Payment> payments = new ArrayList<>();
        boolean y = true;
        String type;
        for (int x = 0; x < 4; x++) {
            if (y) {
                type = "Trip Plan";
            } else {
                type = "Package";
            }

            Payment payment = new Payment(
                    new ObjectId("6" + x + "3372dc0a880e615b3efbce"),
                    new ObjectId("6" + (x + 2) + "3372dc0a880e615b3efbce"),
                    new ObjectId("6331d725d613b66fd9db0f19"),
                    type,
                    "2022-09-20T20:37:36.000Z",
                    20000.00);
            payments.add(payment);
            y = !y;
        }
        return payments;
    }

    public User getUser() {
        return new User(
                new ObjectId("6331d725d613b66fd9db0f19"),
                "Chamath",
                "admin@gmail.com",
                "$2a$10$4ZNog8tdUVODANq2pph7Lut/5svvn0kjy9DyfCJtJsfib6xsH3VDi",
                "gampaha",
                "0778528876",
                "ImageUrl");
    }

    public Admin getAdmin(UserRegisterDTO userRegisterDTO) {
        Admin user = new Admin(
                userRegisterDTO.getId(),
                userRegisterDTO.getName(),
                userRegisterDTO.getEmail(),
                userRegisterDTO.getPassword(),
                null,
                null,
                null,
                userRegisterDTO.getIsAdmin());


        return user;
    }

    public User getUserByDTOSave(UserRegisterDTO userRegisterDTO) {
        User user = new User(
                userRegisterDTO.getId(), userRegisterDTO.getName(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword(), null, null, null);
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            User user = new User(
                    new ObjectId("6" + x + "31d725d613b66fd9db0f19"),
                    "Chamath",
                    "admin@gmail.com",
                    "123456789",
                    "gampaha",
                    "0778528876",
                    "ImageUrl");
            userList.add(user);
        }
        return userList;
    }

    public PlaceDTO getPlaceDTO() {

        PlaceDTO placeDTO = new PlaceDTO();

        placeDTO.setId(new ObjectId("633372dc0a880e615b3efbce"));
        placeDTO.setName("Sigiriya");
        placeDTO.setDistrict("Nuwara");
        placeDTO.setProvince("Centerl");
        placeDTO.setDescription("test");
        placeDTO.setImageURL("imageUrl");
        List<com.SPM.backend.IT20122096.Places.Entity.VisitingPlace> visitingPlaces = new ArrayList<>();
        visitingPlaces.add(new com.SPM.backend.IT20122096.Places.Entity.VisitingPlace(63337L, "Rock", "imageUrl"));
        placeDTO.setVisitingPlaces(visitingPlaces);

        return placeDTO;
    }

    public com.SPM.backend.IT20122096.Places.Entity.Place getPlace() {
        PlaceDTO placeDTO = getPlaceDTO();
        com.SPM.backend.IT20122096.Places.Entity.Place place = new com.SPM.backend.IT20122096.Places.Entity.Place();

        place.setName(placeDTO.getName());
        place.setDistrict(placeDTO.getDistrict());
        place.setProvince(placeDTO.getProvince());
        place.setDescription(placeDTO.getDescription());
        place.setImageURL(placeDTO.getImageURL());

        List<com.SPM.backend.IT20122096.Places.Entity.VisitingPlace> visitingPlaces = new ArrayList<>();
        long count = 0L;
        for (com.SPM.backend.IT20122096.Places.Entity.VisitingPlace vPlace : placeDTO.getVisitingPlaces()) {

            com.SPM.backend.IT20122096.Places.Entity.VisitingPlace visitingPlace = new com.SPM.backend.IT20122096.Places.Entity.VisitingPlace();
            visitingPlace.setName(vPlace.getName());
            visitingPlace.setImage(vPlace.getImage());
            visitingPlace.setId(System.currentTimeMillis() + count);
            count++;

            visitingPlaces.add(visitingPlace);
        }
        place.setVisitingPlaces(visitingPlaces);

        return place;
    }

    public TransportDTO getTransportDTO() {
        TransportDTO transportDTO = new TransportDTO();
        transportDTO.setId(new ObjectId("6331d725d613b66fd9db0f19"));
        transportDTO.setName("Transport");
        transportDTO.setDistrict("Nuwara");
        transportDTO.setDescription("test");
        transportDTO.setImageURL("imageUrl");
        List<com.SPM.backend.IT20122096.Transport.Entity.Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new com.SPM.backend.IT20122096.Transport.Entity.Vehicle("Car", 5, 20000.00));
        transportDTO.setVehicles(vehicles);
        return transportDTO;

    }

    public Transport getTransport() {
        TransportDTO transportDTO = getTransportDTO();

        Transport transport = new Transport();
        transport.setId(transportDTO.getId());
        transport.setName(transportDTO.getName());
        transport.setDescription(transportDTO.getDescription());
        transport.setDistrict(transportDTO.getDistrict());
        transport.setImageURL(transportDTO.getImageURL());

        List<com.SPM.backend.IT20122096.Transport.Entity.Vehicle> vehicles = new ArrayList<>();
        for (com.SPM.backend.IT20122096.Transport.Entity.Vehicle vehicle : transportDTO.getVehicles()
        ) {
            com.SPM.backend.IT20122096.Transport.Entity.Vehicle vehicle1 = new com.SPM.backend.IT20122096.Transport.Entity.Vehicle(vehicle.getType(), vehicle.getCapacity(), vehicle.getPrice());
            vehicles.add(vehicle1);
        }

        transport.setVehicles(vehicles);

        return transport;
    }

}
