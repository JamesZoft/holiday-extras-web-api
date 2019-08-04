package jamesreed.holidayextrasapitask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
class UserService {

    private final UserDAO userDAO;

    private final UserDtoMapper mapper;

    @Autowired
    UserService(final UserDAO userDAO, final UserDtoMapper mapper) {
        this.userDAO = userDAO;
        this.mapper = mapper;
    }

    UserDto get( final Long id) {
        return userDAO.findById(id).
                map(mapper::mapUserToDto).
                orElseThrow(EntityNotFoundException::new);
    }

    UserDto upsert(final UserDto userDto) {
        return mapper.mapUserToDto(
                userDAO.save(
                        mapper.mapDtoToUser(userDto)));
    }

    void delete( final Long id) {
        userDAO.deleteById(id);
    }

    List<UserDto> list() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(userDAO.findAll().iterator(), 0), false).
                map(mapper::mapUserToDto).
                collect(Collectors.toList());
    }
}
