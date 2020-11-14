package postgresApiexample.optionalExamle;

import java.util.Optional;

public class OptionalTester {
    static UserDao userDao = new UserDao();

    public static void main(String[] args) throws Throwable {

        User user = userDao.findUserByUserName("moon1");

        // Optional oluşturma
        Optional optional1 = Optional.empty();
        Optional optional2 = Optional.of(user);
        Optional optional3 = Optional.ofNullable(user);

        // isPresent
        System.out.println("Optinal1 : " + optional1.isPresent());
        System.out.println("Optinal2 : " + optional2.isPresent());
        System.out.println("Optinal3 : " + optional3.isPresent());

        // ifPresent
        optional3.ifPresent(value -> {
            userDao.deleteUser((User) value);
        });

        // map
        System.out.println("map örneği");
        optional3.map(value -> ((User) value).getUserName().length()).ifPresent(System.out::println);
        optional1.map(value -> ((User) value).getUserName().length()).ifPresent(System.out::println);

        // filter
        System.out.println("filter örneği");
        optional3.filter(value -> ((User) value).getName().equals("Moon")).ifPresent(value -> {
            userDao.deleteUser((User) value);
        });

        // orElse
        User userSun = userDao.findUserByUserName("sun");
        User user1 = (User) optional1.orElse(userSun);
        User user2 = (User) optional3.orElse(userSun);
        System.out.println("orElse örneği optional1 Kullanıcı " + user1.getUserName());
        System.out.println("orElse örneği optioanel3 Kullanıcı " + user2.getUserName());

        // orElseGet
//        orElseGet (Varsa al, yoksa üret)
//        Bu metod orElse metoduna çok benzer, fakat orElseGet metod parametresi olarak Supplier fonksiyonel arayüzü türünden nesne kabul eder.
        User user3 = (User) optional1.orElseGet(() -> userDao.findUserByUserName("astrid"));
        User user4 = (User) optional3.orElseGet(() -> userDao.findUserByUserName("astrid"));
        System.out.println("orElseGet örneği optional1 Kullanıcı " + user3.getUserName());
        System.out.println("orElseGet örneği optional3 Kullanıcı " + user4.getUserName());

        // orElseThrow
        optional3.orElseThrow(NullPointerException::new);
        try {
            optional1.orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            System.out.println("orElseThrow örneği optional1 throw exception");
        }

    }

}
