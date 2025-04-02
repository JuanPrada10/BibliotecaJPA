/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Libros;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Autores;

/**
 *
 * @author Estudiante
 */
public class AutoresJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public AutoresJpaController() {
        emf = Persistence.createEntityManagerFactory("UnidadBD1");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autores autores) {
        if (autores.getLibrosList() == null) {
            autores.setLibrosList(new ArrayList<Libros>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Libros> attachedLibrosList = new ArrayList<Libros>();
            for (Libros librosListLibrosToAttach : autores.getLibrosList()) {
                librosListLibrosToAttach = em.getReference(librosListLibrosToAttach.getClass(), librosListLibrosToAttach.getIdLibro());
                attachedLibrosList.add(librosListLibrosToAttach);
            }
            autores.setLibrosList(attachedLibrosList);
            em.persist(autores);
            for (Libros librosListLibros : autores.getLibrosList()) {
                Autores oldIdAutorOfLibrosListLibros = librosListLibros.getIdAutor();
                librosListLibros.setIdAutor(autores);
                librosListLibros = em.merge(librosListLibros);
                if (oldIdAutorOfLibrosListLibros != null) {
                    oldIdAutorOfLibrosListLibros.getLibrosList().remove(librosListLibros);
                    oldIdAutorOfLibrosListLibros = em.merge(oldIdAutorOfLibrosListLibros);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autores autores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autores persistentAutores = em.find(Autores.class, autores.getIdAutor());
            List<Libros> librosListOld = persistentAutores.getLibrosList();
            List<Libros> librosListNew = autores.getLibrosList();
            List<Libros> attachedLibrosListNew = new ArrayList<Libros>();
            for (Libros librosListNewLibrosToAttach : librosListNew) {
                librosListNewLibrosToAttach = em.getReference(librosListNewLibrosToAttach.getClass(), librosListNewLibrosToAttach.getIdLibro());
                attachedLibrosListNew.add(librosListNewLibrosToAttach);
            }
            librosListNew = attachedLibrosListNew;
            autores.setLibrosList(librosListNew);
            autores = em.merge(autores);
            for (Libros librosListOldLibros : librosListOld) {
                if (!librosListNew.contains(librosListOldLibros)) {
                    librosListOldLibros.setIdAutor(null);
                    librosListOldLibros = em.merge(librosListOldLibros);
                }
            }
            for (Libros librosListNewLibros : librosListNew) {
                if (!librosListOld.contains(librosListNewLibros)) {
                    Autores oldIdAutorOfLibrosListNewLibros = librosListNewLibros.getIdAutor();
                    librosListNewLibros.setIdAutor(autores);
                    librosListNewLibros = em.merge(librosListNewLibros);
                    if (oldIdAutorOfLibrosListNewLibros != null && !oldIdAutorOfLibrosListNewLibros.equals(autores)) {
                        oldIdAutorOfLibrosListNewLibros.getLibrosList().remove(librosListNewLibros);
                        oldIdAutorOfLibrosListNewLibros = em.merge(oldIdAutorOfLibrosListNewLibros);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autores.getIdAutor();
                if (findAutores(id) == null) {
                    throw new NonexistentEntityException("The autores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autores autores;
            try {
                autores = em.getReference(Autores.class, id);
                autores.getIdAutor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autores with id " + id + " no longer exists.", enfe);
            }
            List<Libros> librosList = autores.getLibrosList();
            for (Libros librosListLibros : librosList) {
                librosListLibros.setIdAutor(null);
                librosListLibros = em.merge(librosListLibros);
            }
            em.remove(autores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autores> findAutoresEntities() {
        return findAutoresEntities(true, -1, -1);
    }

    public List<Autores> findAutoresEntities(int maxResults, int firstResult) {
        return findAutoresEntities(false, maxResults, firstResult);
    }

    private List<Autores> findAutoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autores.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Autores findAutores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autores.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autores> rt = cq.from(Autores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
