package ua.fedii.hibernate.demoDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.fedii.hibernate.entity.Car;
import org.hibernate.cfg.Configuration;

public class CreateCar {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Car.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Car tempCar = new Car("Toyota", "Land Cruiser", 2020);
            session.beginTransaction();
            session.save(tempCar);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
