package moon.example.demo.optionalExamle;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> userList;

    public UserDao() {
        getUsers();
    }

    private void getUsers() {
        userList = new ArrayList<>();
        User user1 = new User(1L, "moon1", "Moon");
        User user2 = new User(2L, "moon2", "Moon");
        User user3 = new User(3L, "moon3", "Moon");
        User user4 = new User(4L, "sun", "Sun");
        User user5 = new User(5L, "astrid", "Astrid");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    public User findUserByUserName(String userName) {
        User user = null;
        for (User eachUser : userList) {
            if (eachUser.getUserName().equals(userName)) {
                user = eachUser;
            }
        }
        return user;
    }

    public void deleteUser(User user) {
        userList.remove(user);
        System.out.print(user.getUserName() + " kullanıcısı silindi. Diğer Kullanıcılar : ");
        userList.stream().forEach(value -> System.out.print(" " + value.getUserName()));
        System.out.println();
    }

}

