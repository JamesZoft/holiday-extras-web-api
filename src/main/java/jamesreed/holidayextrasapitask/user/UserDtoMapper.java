package jamesreed.holidayextrasapitask.user;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
class UserDtoMapper {

    UserDto mapUserToDto(User user) {
        return new UserDto.Builder().
                withId(user.getId()).
                withEmail(user.getEmail()).
                withFirstName(user.getFirstName()).
                withLastName(user.getLastName()).
                withCreated(user.getCreated()).
                build();
    }

    User mapDtoToUser(UserDto dto) {
        return new User.Builder().
                withId(dto.getId()).
                withEmail(dto.getEmail()).
                withFirstName(dto.getFirstName()).
                withLastName(dto.getLastName()).
                build();
    }
}
