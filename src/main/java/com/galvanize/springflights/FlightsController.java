package com.galvanize.springflights;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
@RestController
public class FlightsController {
    @GetMapping("/ff")
    public void test() throws ParseException {
        Flight flight=new Flight();
        String d1 = "2017-04-21 14:34";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date date1 = format.parse(d1);
        flight.setDeparts(date1);
    }


    @GetMapping("/flights/flight")
    public Flight getFlight() throws ParseException {
        Flight flight=new Flight();
        String string = "2017-04-21 14:34";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date date = format.parse(string);
        flight.setDeparts(date);
        Ticket ticket1=new Ticket();
        Passenger passenger=new Passenger();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some Other name");
        ticket1.setPassenger(passenger);
        ticket1.setPrice(200);
        List<Ticket> tickets=new ArrayList<>();
        tickets.add(ticket1);
        flight.setTickets(tickets);
        return flight;
    }
    @GetMapping("/flights")
    public List<Flight> getListOfFlights() throws ParseException {
        Flight flight1=new Flight();
        String d1 = "2017-04-21 14:34";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date date1 = format.parse(d1);
        flight1.setDeparts(date1);
        Ticket ticket1=new Ticket();
        Passenger passenger1=new Passenger();
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some Other name");
        ticket1.setPassenger(passenger1);
        ticket1.setPrice(200);
        List<Ticket> ticket1List=new ArrayList<>();
        ticket1List.add(ticket1);
        flight1.setTickets(ticket1List);

        Flight flight2=new Flight();
        String d2 = "2017-04-21 14:34";
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Date date2 = format2.parse(d2);
        flight2.setDeparts(date2);
        Ticket ticket2=new Ticket();
        Passenger passenger2=new Passenger();
        passenger2.setFirstName("Some name");
        passenger2.setLastName(null);
        ticket2.setPassenger(passenger2);
        ticket2.setPrice(400);
        List<Ticket> ticket2List=new ArrayList<>();
        ticket2List.add(ticket2);
        flight2.setTickets(ticket2List);
        List<Flight> flightList=new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        return flightList;
    }


    public static class Flight {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private Date departs;
        private List<Ticket> ticktes;
        @JsonProperty("Departs")
        public Date getDeparts() {
            return departs;
        }
        public void setDeparts(Date departs) {
            this.departs = departs;
        }
        @JsonProperty("Tickets")
        public List<Ticket> getTickets() {
            return ticktes;
        }
        public void setTickets(List<Ticket> tickets) {
            this.ticktes = tickets;
        }
    }
    public static class Ticket {

        private Passenger passenger;
        private int price;
        @JsonProperty("Passenger")
        public Passenger getPassenger() {
            return passenger;
        }
        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }
        @JsonProperty("Price")
        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Passenger{
        private String firstName;
        private String lastName;
        @JsonProperty("FirstName")
        public String getFirstName() {
            return firstName;
        }
        @JsonProperty("LastName")
        public String getLastName() {
            return lastName;
        }
        public void setFirstName(String some_name) {
            this.firstName=some_name;
        }
        public void setLastName(String some_other_name) {
            lastName=some_other_name;
        }
    }

}
