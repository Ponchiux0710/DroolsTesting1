package com.example.droolstesting1;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * La clase Deadline representa un objeto que contiene información sobre un plazo
 * o fecha límite en una aplicación. Puede utilizarse para realizar un seguimiento
 * de fechas límite y su estado.
 */
public class Deadline {

    private String type; // El tipo de la fecha límite
    private String createdDate; // La fecha en que se creó la fecha límite
    private boolean state; // El estado de la fecha límite (activa o inactiva)
    private String result; // El resultado asociado a la fecha límite (opcional)

    /**
     * Devuelve el estado de la fecha límite.
     *
     * @return true si la fecha límite está activa, false si está inactiva.
     */
    public boolean isState() {
        return state;
    }

    /**
     * Establece el estado de la fecha límite.
     *
     * @param state true para activar la fecha límite, false para desactivarla.
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Devuelve el tipo de la fecha límite.
     *
     * @return El tipo de la fecha límite.
     */
    public String getType() {
        return type;
    }

    /**
     * Establece el tipo de la fecha límite.
     *
     * @param type El tipo de la fecha límite.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Devuelve la fecha en que se creó la fecha límite.
     *
     * @return La fecha de creación de la fecha límite en formato "yyyy-MM-dd".
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Establece la fecha en que se creó la fecha límite.
     *
     * @param createdDate La fecha de creación de la fecha límite.
     */
    public void setCreatedDate(Date createdDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.createdDate = sdf.format(createdDate);
    }

    /**
     * Devuelve el resultado asociado a la fecha límite.
     *
     * @return El resultado asociado a la fecha límite (puede ser nulo si no se ha establecido).
     */
    public String getResult() {
        return result;
    }

    /**
     * Establece el resultado asociado a la fecha límite.
     *
     * @param result El resultado asociado a la fecha límite.
     */
    public void setResult(String result) {
        this.result = result;
    }
}
