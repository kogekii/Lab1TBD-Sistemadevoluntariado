package lab1.tbd.serviciovoluntariado.models;

import lombok.Data;

@Data
public class VoluntarioRegisterResponse {
    private Boolean error;
    private String message;
    private Voluntario usuario;
}
