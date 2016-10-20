package Main.DAO.DAO;

import Main.Model.Apartment;

import java.util.List;

public interface ApartmentDAO {

    Apartment getApartmentById(int id);

    List<Apartment> getAllApartments();
}
