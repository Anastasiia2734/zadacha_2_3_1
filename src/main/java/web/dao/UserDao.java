package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User read(Long id);

    List<User> readAll();

    void update(User user);

    void delete(Long id);

    public List<User> findByName(String name);

}
