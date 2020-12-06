package reportportal.services.users;

import reportportal.models.User;

import java.util.List;

public interface UsersService {

    User getUserById(int id);

    List<User> getUsers();

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);
}
