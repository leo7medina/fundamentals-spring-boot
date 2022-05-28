package ec.com.leo.dev.fundamentum.spring.boot.services;

import ec.com.leo.dev.fundamentum.spring.boot.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    User find(Long id);

    void save(List<User> users);

    void update(User user);

    void delete(Long id);

    Page<User> findAllPageable(Integer page, Integer size);
}
