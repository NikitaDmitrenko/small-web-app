package Main.DAO.DAO;

import Main.Model.Apartment;
import Main.Model.RewiewRequest;

public interface RewiewRequestDAO {

    void save(RewiewRequest rewiewRequest);

    RewiewRequest checkForAvailableRewiewByDate(String date,Apartment apartment);
}
