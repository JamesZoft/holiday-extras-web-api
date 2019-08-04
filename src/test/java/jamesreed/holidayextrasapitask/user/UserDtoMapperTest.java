package jamesreed.holidayextrasapitask.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDtoMapperTest {

    private UserDtoMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new UserDtoMapper();
    }

    @Test
    void shouldMapDtoToUser() {
        UserDto dto = new UserDto.Builder().
                withEmail("bob").
                withFirstName("bob").
                withLastName("elk").
                withId(1L).
                build();

        User user = new User.Builder().
                withEmail(dto.getEmail()).
                withFirstName(dto.getFirstName()).
                withLastName(dto.getLastName()).
                withId(dto.getId()).
                build();

        assertTrue(new ReflectionEquals(user).matches(mapper.mapDtoToUser(dto)));
    }

    @Test
    void shouldMapUserToDto() {
               User user = new User.Builder().
                withEmail("bob@bob.com").
                withFirstName("bob").
                withLastName("elk").
                withId(1L).
                build();

        UserDto dto = new UserDto.Builder().
                withEmail(user.getEmail()).
                withFirstName(user.getFirstName()).
                withLastName(user.getLastName()).
                withId(user.getId()).
                build();

        assertTrue(new ReflectionEquals(dto).matches(mapper.mapUserToDto(user)));
    }
}
