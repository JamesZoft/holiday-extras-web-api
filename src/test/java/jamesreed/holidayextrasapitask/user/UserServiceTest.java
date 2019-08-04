package jamesreed.holidayextrasapitask.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @Mock
    private UserDtoMapper mapper;

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService(userDAO, mapper);
    }

    @Test
    void shouldErrorWhenNoEntityFound() {
        when(userDAO.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.get(1L));
    }

    @Test
    void shouldReturnDtoWhenEntityFound() {
        User user = new User.Builder().
                withId(1L).
                withEmail("june@june.com").
                build();
        UserDto dto = new UserDto.Builder().
                withId(user.getId()).
                withEmail(user.getEmail()).
                build();

        when(userDAO.findById(1L)).thenReturn(Optional.of(user));
        when(mapper.mapUserToDto(user)).thenReturn(dto);

        assertEquals(dto, userService.get(user.getId()));
    }
}
