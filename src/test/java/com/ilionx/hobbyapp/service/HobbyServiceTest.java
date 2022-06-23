package com.ilionx.hobbyapp.service;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.persistance.HobbyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class HobbyServiceTest {

    @InjectMocks
    private HobbyService hobbyService;

    @Mock
    private HobbyRepository hobbyRepository;

    public HobbyServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Musician mockedMusician = new Musician();
        mockedMusician.setId(4);
        Optional<Musician> mockedOptionalMusician = Optional.of(mockedMusician);
        Mockito.when(this.hobbyRepository.findById(4L)).thenReturn(mockedOptionalMusician);

        Optional<Musician> optionalMusician = this.hobbyService.findById(4L);

        assertEquals(4L, optionalMusician.get().getId());
    }

    @Test
    void updateByID() {
        Musician mockedMusician = new Musician();
        mockedMusician.setId(3L);
        mockedMusician.setInstrument("piano");
        Optional<Musician> mockedOptionalMusician = Optional.of(mockedMusician);
        Mockito.when(this.hobbyRepository.findById(3L)).thenReturn(mockedOptionalMusician);

        Optional<Musician> optionalMusician = this.hobbyService.updateByID(3L, mockedOptionalMusician);

        assertEquals(4L, optionalMusician.get().getId());

    }

    @Test
    void deleteByID() {
    }
}