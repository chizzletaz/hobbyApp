package com.ilionx.hobbyapp;

import com.ilionx.hobbyapp.api.HobbyController;
import com.ilionx.hobbyapp.model.Musician;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HobbyControllerIT {

    private static long currentId = -1;

    @Autowired
    private TestRestTemplate restTemplate; // sort of Postman

    @Test
    @Order(1)
    public void testCreateUsingPost() {

        Musician musician = new Musician();
        musician.setName("Tasco Silva");
        musician.setAge(44);
        musician.setInstrument("piano");

        ResponseEntity<Musician> response = this.restTemplate.postForEntity(HobbyController.url, musician, Musician.class);

        Musician returnedMusician = response.getBody();
        assertNotEquals(0, returnedMusician.getId()); //check if it is saved
        assertNotNull(returnedMusician);
        currentId = returnedMusician.getId();   //forward the set id to the other methods
    }

    @Test
    @Order(2)
    public void testFetchMusician() {
        ResponseEntity<Musician> response = this.restTemplate.getForEntity(HobbyController.url+"/"+currentId, Musician.class);
        assertNotNull(response.getBody());
        Musician responsedMusician = response.getBody();
        assertEquals(44, responsedMusician.getAge());
    }
}
