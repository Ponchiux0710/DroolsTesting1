package com.example.droolstesting1;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
/**
 * La clase DroolConfig es una clase de configuración de Spring que se encarga de configurar
 * y crear los componentes necesarios para el funcionamiento de Drools en la aplicación.
 */
@Configuration
public class DroolConfig {
    private KieServices kieServices = KieServices.Factory.get();

    /**
     * Obtiene un sistema de archivos Kie que contiene las reglas definidas en el archivo "deadline.drl".
     *
     * @return El sistema de archivos Kie configurado con las reglas.
     * @throws IOException Si ocurre un error al acceder al archivo de reglas.
     */
    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("deadline.drl"));
        return kieFileSystem;
    }

    /**
     * Crea y configura un contenedor Kie que contiene las reglas definidas en el sistema de archivos Kie.
     *
     * @return El contenedor Kie configurado.
     * @throws IOException Si ocurre un error al acceder al sistema de archivos Kie.
     */
    @Bean
    public KieContainer getKieContainer() throws IOException {
        System.out.println("Container created...");
        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kContainer;
    }

    /**
     * Obtiene y configura el repositorio Kie para el funcionamiento de Drools.
     */
    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    /**
     * Crea y devuelve una sesión Kie que se utilizará para aplicar las reglas de negocio definidas.
     *
     * @return Una sesión Kie configurada.
     * @throws IOException Si ocurre un error al acceder al contenedor Kie.
     */
    @Bean
    public KieSession getKieSession() throws IOException {
        System.out.println("session created...");
        return getKieContainer().newKieSession();
    }
}