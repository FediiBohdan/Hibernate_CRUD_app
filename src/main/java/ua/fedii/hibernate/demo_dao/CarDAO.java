package ua.fedii.hibernate.demo_dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.fedii.hibernate.entity.Car;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CarDAO {
    public static void main(String[] args) {
        int exitFlag;

        do {
            Configuration configuration = new Configuration();
            configuration.configure().addAnnotatedClass(Car.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();

            Scanner in = new Scanner(System.in);

            System.out.print("\nChoose the action. \n" +
                    "1 - Create a new car\n" +
                    "2 - Read DB table\n" +
                    "3 - Update the car\n" +
                    "4 - Delete the car\n" +
                    "Your choice: ");

            int number = in.nextInt();

            switch (number) {
                case 1:
                    try {
                        Car tempCar = new Car("Toyota", "Land Cruiser", 2020);
                        session.beginTransaction();
                        session.save(tempCar);
                        session.getTransaction().commit();
                    }
                    finally {
                        sessionFactory.close();
                    }
                    break;
                case 2:
                    try {
                        session.beginTransaction();
                        List<Car> theCars = session.createQuery("FROM Car").getResultList();

                        for (Car tempCar : theCars) {
                            System.out.println(tempCar);
                        }

                        session.getTransaction().commit();
                    }
                    finally {
                        sessionFactory.close();
                    }
                    break;
                case 3:
                    try {
                        int carId = 2;
                        session.beginTransaction();
                        Car myCar = session.get(Car.class, carId);
                        myCar.setReleaseYear(2009);
                        session.getTransaction().commit();
                    }
                    finally {
                        sessionFactory.close();
                    }
                    break;
                case 4:
                    try {
                        int id = 3;
                        session.beginTransaction();
                        Car myCar = session.get(Car.class, id);
                        session.delete(myCar);
                        session.getTransaction().commit();
                    }
                    finally {
                        sessionFactory.close();
                    }
                    break;
            }

            System.out.println("Action " + number + " was fulfilled!\n");

            System.out.print("Continue? YES - print \"1\", NO - print \"0\": ");

            exitFlag = in.nextInt();
        } while (exitFlag == 1);
    }
}
