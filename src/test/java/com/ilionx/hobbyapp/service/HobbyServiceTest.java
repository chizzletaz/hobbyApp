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
    void testSave() {
//        Given
        Musician mockedMusician = new Musician();
        mockedMusician.setName("Tasco Silva");
        mockedMusician.setAge(44);
        mockedMusician.setInstrument("piano");
        Mockito.when(this.hobbyRepository.save(mockedMusician)).thenReturn(mockedMusician);

//         When
        Musician savedMusician = hobbyRepository.save(mockedMusician);
//        Then
        assertEquals("Tasco Silva", savedMusician.getName());
        assertEquals(44, savedMusician.getAge());
        Mockito.verify(this.hobbyRepository).save(mockedMusician);
    }
    @Test
    void findById() {
//        Given
        Musician mockedMusician = new Musician();
        mockedMusician.setId(4);
        Optional<Musician> mockedOptionalMusician = Optional.of(mockedMusician);
        Mockito.when(this.hobbyRepository.findById(4L)).thenReturn(mockedOptionalMusician);
//      When
        Optional<Musician> optionalMusician = this.hobbyService.findById(4L);
//      Then
        assertEquals(4L, optionalMusician.get().getId());
    }

    @Test
    void updateByID() {
//        Given
        Musician mockedMusician = new Musician();
        mockedMusician.setId(3L);
        mockedMusician.setInstrument("piano");
        Mockito.when(this.hobbyRepository.findById(3L)).thenReturn(Optional.of(mockedMusician));
        Mockito.when(this.hobbyRepository.save(mockedMusician)).thenReturn(mockedMusician);
//          When
        Musician musician = this.hobbyService.updateByID(3L, mockedMusician);
//          Then
        assertEquals(3L, musician.getId());

    }

//    @Test
//    void deleteByID() {
//        //        Given
//        Musician mockedMusician = new Musician();
//        mockedMusician.setId(3L);
//        mockedMusician.setName("Tasco Silva");
//        mockedMusician.setAge(44);
//        mockedMusician.setInstrument("piano");
//        Mockito.when(this.hobbyRepository.findById(3L)).thenReturn(Optional.of(mockedMusician));
//        Mockito.when(this.hobbyRepository.deleteById(3L)).thenReturn()
//    }
}