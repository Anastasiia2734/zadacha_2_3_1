package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    void update(User user);

    void deleteUser(Long id);

    List<User> findUsersName(String name);

    void save(User user);

}
