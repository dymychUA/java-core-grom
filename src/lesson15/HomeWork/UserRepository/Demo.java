package lesson15.HomeWork.UserRepository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user_1 = new User(1, "Den", "0001");
        User user_2 = new User(2, "Ben", "0002");
        User user_3 = new User(3, "Zen", "0003");
        User user_4 = null;
        User user_5 = new User(5, "Asd", "0007");


        User[] users = {user_1, user_2, user_3, user_4};
        UserRepository repository = new UserRepository(users);

        //UserRepository repository = null;

        System.out.println(repository.save(user_5));


        //*************************** TESTS ******************************
        UserRepository userRepository = new UserRepository();
        System.out.println(Arrays.toString(userRepository.getUsers()));

        //test save
        User user = new User(1001, "Ann1", "1w21212");
        userRepository.save(user);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.save(user);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann2", "1w21212");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.save(null);

        //test update
        user = new User(1001, "Ann3", "eretertert");
        userRepository.update(user);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        user = new User(9999, "Ann4", "eretertert");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        //test print all users names and ids
        userRepository = new UserRepository(new User[]{user_1, user_2, user_3});
        System.out.println("all users names");

        //test deleting user
        System.out.println("delete user with id=2");
        userRepository.delete(2);
        System.out.println(Arrays.toString(userRepository.getUsers()));

    }
}
