package com.example.droolstesting1;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * El controlador DeadlineController maneja las solicitudes relacionadas con las fechas límite (Deadlines)
 * en la aplicación. Permite agregar una fecha límite y activar las reglas de negocio asociadas a ella.
 */
@RestController
public class DeadlineController {

    @Autowired
    private KieSession session; // La sesión de Drools utilizada para evaluar las reglas de negocio.

    /**
     * Maneja las solicitudes POST en la ruta "/deadline". Agrega una fecha límite al sistema y activa las reglas de negocio asociadas.
     *
     * @param deadline El objeto Deadline que se va a agregar y evaluar.
     * @return El mismo objeto Deadline después de la evaluación de las reglas (puede tener modificaciones).
     */
    @PostMapping("/deadline")
    public Deadline deadlineFinish(@RequestBody Deadline deadline) {
        // Inserta la fecha límite en la sesión de Drools para su evaluación.
        session.insert(deadline);

        // Activa todas las reglas de negocio en la sesión.
        session.fireAllRules();

        // Devuelve la fecha límite después de la evaluación de las reglas.
        return deadline;
    }
}
