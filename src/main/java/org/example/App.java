package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App {
    public static void main(String[] args) {
        // Crear la conexión con ObjectDB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personas.odb");
        EntityManager em = emf.createEntityManager();

        // Insertar personas en la base de datos
        em.getTransaction().begin();
        em.persist(new Persona("Juan", "Pérez", 30));
        em.persist(new Persona("Ana", "García", 25));
        em.persist(new Persona("Luis", "Martínez", 40));
        em.getTransaction().commit();

        // Consultar todas las personas
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        // Mostrar los resultados
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        // Cerrar la conexión
        em.close();
        emf.close();
    }
}