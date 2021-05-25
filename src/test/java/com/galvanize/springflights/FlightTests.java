package com.galvanize.springflights;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightsController.class)
public class FlightTests {

	@Autowired
	MockMvc mvc;

    @Test
    public void testGetFlight() throws Exception {

        RequestBuilder requestBuilder = get("/flights/flight")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", Matchers.is("Some name")))
                .andExpect(jsonPath("$.Tickets[0].Price", Matchers.is(200)));

    }
    @Test
    public void testGetListFlight() throws Exception {
        RequestBuilder requestBuilder=get("/flights")
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName", Matchers.is("Some name")))
                .andExpect(jsonPath("$[1].Tickets[0].Passenger.FirstName", Matchers.is("Some name")));


    }

}


