package lab1.tbd.serviciovoluntariado.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Registration {
    @Id
    @Column(name = "email")
    private String name;
    private String email;
    private String password;

}
