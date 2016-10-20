package Main.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope("prototype")
@Table(name = "REWIEW_REQUEST")
public class RewiewRequest {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "REWIEW_USER_NAME")
    private String rewiewUserName;

    @Column(name = "REWIEW_TELEPHONE")
    private String rewiewPhone;

    @Column(name = "REWIEW_DATE")
    private String date;

    @ManyToOne
    private Apartment apartment;

    public String getRewiewUserName() {
        return rewiewUserName;
    }

    public void setRewiewUserName(String rewiewUserName) {
        this.rewiewUserName = rewiewUserName;
    }

    public String getRewiewPhone() {
        return rewiewPhone;
    }

    public void setRewiewPhone(String rewiewPhone) {
        this.rewiewPhone = rewiewPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
