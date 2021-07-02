package ua.fedii.hibernate.demoDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.fedii.hibernate.entity.Car;

public class ReadCar {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Car.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Car tempCar = new Car("Honda", "Civic", 2015);
            session.beginTransaction();
            System.out.println(tempCar);
            session.save(tempCar);
            session.getTransaction().commit();

            //reading information
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Car myCar = session.get(Car.class, tempCar.getId());
            System.out.println(myCar);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
