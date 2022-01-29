import data.DB;
import data.postgres.Postgres;
import models.User;
import repos.EntityRepo;
import repos.users.UserRepo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB db = new Postgres();
        EntityRepo<User> userRepo = new UserRepo(db);

        List<User> users = userRepo.getAll();
        for (User user : users)
            System.out.println(user);

        System.out.println("+++++++++++++++++++++");
        System.out.println("Please enter ID:");
        int id = sc.nextInt();
        User user = userRepo.get(id);

        if (user == null) {
            System.out.println("User under ID=" + id + " does not exist.");
        } else {
            System.out.println(user);
        }

        db.close();
    }
}
