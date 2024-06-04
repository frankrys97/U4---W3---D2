package francescocristiano;

import francescocristiano.dao.EventoDAO;
import francescocristiano.entities.Evento;
import francescocristiano.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento evento1 = new Evento("Evento1", new Date(), "Descrizione1", francescocristiano.enums.TipoEvento.PUBBLICO, 10);
        Evento evento2 = new Evento("Evento2", new Date(), "Descrizione2", francescocristiano.enums.TipoEvento.PUBBLICO, 20);
        Evento evento3 = new Evento("Evento3", new Date(), "Descrizione3", francescocristiano.enums.TipoEvento.PRIVATO, 30);
        Evento evento4 = new Evento("Evento4", new Date(), "Descrizione4", francescocristiano.enums.TipoEvento.PUBBLICO, 40);
        Evento evento5 = new Evento("Evento5", new Date(), "Descrizione5", francescocristiano.enums.TipoEvento.PRIVATO, 50);

/*        ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3);
        ed.save(evento4);
        ed.save(evento5);*/
        try {
            ed.findAndDeleteById(1);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            ed.getById(1);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ed.getById(5));
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        em.close();
        emf.close();
    }
}
