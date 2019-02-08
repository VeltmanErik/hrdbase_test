package nl.veltman.hrdbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    static String HOST_NAME = "jdbc:mysql://localhost:3306/hr";
    static String USER_NAME = "root";
    static String PASSWORD = "12ev@SQL9";

    public static void main(String[] args) {
//        if (args.length != 3) {
//            System.out.println ("Usage: java -jar database-uri username password");
//            System.exit(0);
//        }
//        Application.HOST_NAME = args[0];
//        Application.USER_NAME = args[1];
//        Application.PASSWORD = args[2];

        SpringApplication.run(Application.class);//, args);
    }
}