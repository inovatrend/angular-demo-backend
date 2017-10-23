package com.inovatrend.demo.user;

import java.util.List;

public interface UserManager {

    User save(User user);

    List<User> getUsers();

    User getUser(Long id);

    void deleteUser(Long id);
}
