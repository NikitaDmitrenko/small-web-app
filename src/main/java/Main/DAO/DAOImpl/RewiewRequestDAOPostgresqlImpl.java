package Main.DAO.DAOImpl;

import Main.DAO.DAO.RewiewRequestDAO;
import Main.Model.Apartment;
import Main.Model.RewiewRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RewiewRequestDAOPostgresqlImpl implements RewiewRequestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(RewiewRequest rewiewRequest) {
        sessionFactory.getCurrentSession().save(rewiewRequest);
    }

    @Transactional
    public RewiewRequest checkForAvailableRewiewByDate(String date, Apartment apartment) {
        return (RewiewRequest) sessionFactory.
                getCurrentSession().
                createQuery("from RewiewRequest a join fetch a.apartment where a.date =:date and a.apartment=:apartment").
                setParameter("date", date).
                setParameter("apartment", apartment).
                uniqueResult();
    }
}
