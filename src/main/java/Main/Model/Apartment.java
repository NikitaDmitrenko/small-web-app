package Main.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Component
@Table(name = "APARTMENT")
public class Apartment {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
