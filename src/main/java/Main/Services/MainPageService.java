package Main.Services;

import Main.DAO.DAO.ApartmentDAO;
import Main.DAO.DAO.RewiewRequestDAO;
import Main.Model.Apartment;
import Main.Model.OrderResult;
import Main.Model.RewiewRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MainPageService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RewiewRequestDAO rewiewRequestDAO;

    @Autowired
    ApartmentDAO dao;


    public List<Apartment> getAllApartments() {
        return  dao.getAllApartments();
    }

    public OrderResult makeNewOrder(String name, String phone, String date, int apartmentId) {
        boolean status = false;
        OrderResult result = new OrderResult();
        Apartment apartment = getApartmentById(apartmentId);
        RewiewRequest rewiewRequest = rewiewRequestDAO.checkForAvailableRewiewByDate(date,apartment);
        if (rewiewRequest == null) {
            rewiewRequest = new RewiewRequest();
            rewiewRequest.setRewiewUserName(name);
            rewiewRequest.setRewiewPhone(phone);
            rewiewRequest.setDate(date);
            rewiewRequest.setApartment(apartment);
            rewiewRequestDAO.save(rewiewRequest);
            status = true;
        }
        result.setStatus(status);
        result.setRewiewRequest(rewiewRequest);
        return result;
    }

    public Apartment getApartmentById(int id){
        return dao.getApartmentById(id);
    }



}
