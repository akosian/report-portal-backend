package reportportal.dao.users;

import reportportal.models.User;

import java.util.List;

public interface UsersDao {

    User getUserById(int id);

    List<User> getUsers();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);
}