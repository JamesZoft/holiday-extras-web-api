package jamesreed.holidayextrasapitask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserDAO userDAO;

    private final UserDtoMapper mapper;

    @Autowired
    public UserService(final UserDAO userDAO, final UserDtoMapper mapper) {
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
}
