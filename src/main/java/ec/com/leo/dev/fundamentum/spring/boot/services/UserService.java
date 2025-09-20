package ec.com.leo.dev.fundamentum.spring.boot.services;

import ec.com.leo.dev.fundamentum.spring.boot.entity.User;
import ec.com.leo.dev.fundamentum.spring.boot.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findMyUserByEmail(email).orElseThrow(() -> new RuntimeException(MESSAGE_USER_NOT_FOUND));
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    @Override
    public User find(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: {}", user))
                .forEach(userRepository::save);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllPageable(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }
}
