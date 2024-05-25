package com.example.IKOtomasyon.IKOtomasyon;


import com.example.IKOtomasyon.IKOtomasyon.Dto.PersonalCreateRequest;
import com.example.IKOtomasyon.IKOtomasyon.Entities.Personal;
import com.example.IKOtomasyon.IKOtomasyon.Repository.PersonalRepository;
import com.example.IKOtomasyon.IKOtomasyon.Services.PersonalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class PersonalServiceTest {

    @Mock
    private PersonalRepository personalRepository;

    @InjectMocks
    private PersonalService personalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPersonal() {
        // Arrange
        Personal personal1 = new Personal();
        Personal personal2 = new Personal();
        when(personalRepository.findAll()).thenReturn(Arrays.asList(personal1, personal2));

        // Act
        List<Personal> result = personalService.getALlPersonal();

        // Assert
        assertEquals(2, result.size());
        verify(personalRepository, times(1)).findAll();
    }

    @Test
    void testGetByIdPersonal() {
        // Arrange
        Personal personal = new Personal();
        when(personalRepository.findById(1L)).thenReturn(Optional.of(personal));

        // Act
        Personal result = personalService.getByIdPersonal(1L);

        // Assert
        assertNotNull(result);
        verify(personalRepository, times(1)).findById(1L);
    }

    @Test
    void testGetByIdPersonal_NotFound() {
        // Arrange
        when(personalRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Personal result = personalService.getByIdPersonal(1L);

        // Assert
        assertNull(result);
        verify(personalRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteByIdPersonal() {
        // Act
        personalService.deleteByIdPersonal(1L);

        // Assert
        verify(personalRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateByIdPersonal() {
        // Arrange
        Personal existingPersonal = new Personal();
        Personal newPersonal = new Personal();
        newPersonal.setAd("New Name");

        when(personalRepository.findById(1L)).thenReturn(Optional.of(existingPersonal));

        // Act
        Personal result = personalService.updateByIdPersonal(1L, newPersonal);

        // Assert
        assertNotNull(result);
        assertEquals("New Name", result.getAd());
        verify(personalRepository, times(1)).findById(1L);
        verify(personalRepository, times(1)).save(any(Personal.class));
    }

    @Test
    void testUpdateByIdPersonal_NotFound() {
        // Arrange
        Personal newPersonal = new Personal();
        when(personalRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Personal result = personalService.updateByIdPersonal(1L, newPersonal);

        // Assert
        assertNull(result);
        verify(personalRepository, times(1)).findById(1L);
        verify(personalRepository, never()).save(any(Personal.class));
    }

    @Test
    void testCreatePersonal() {
        // Arrange
        PersonalCreateRequest newPersonalRequest = new PersonalCreateRequest();
        newPersonalRequest.setAd("New Name");
        Personal savedPersonal = new Personal();
        savedPersonal.setAd("New Name");

        when(personalRepository.save(any(Personal.class))).thenReturn(savedPersonal);

        // Act
        Personal result = personalService.createPersonal(newPersonalRequest);

        // Assert
        assertNotNull(result);
        assertEquals("New Name", result.getAd());
        verify(personalRepository, times(1)).save(any(Personal.class));
    }
}
