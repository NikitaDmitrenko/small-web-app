package Main.DAO.DAOImpl;

import Main.DAO.DAO.ApartmentDAO;
import Main.Model.Apartment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ApartmentDAOPostgresqlImpl implements ApartmentDAO {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Apartment getApartmentById(int id) {
        return sessionFactory.getCurrentSession().get(Apartment.class,id);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Apartment> getAllApartments() {
        return (List<Apartment>) sessionFactory.getCurrentSession().createQuery("from Apartment").list();
    }
}
