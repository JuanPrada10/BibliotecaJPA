/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Autores;
import modelo.Editoriales;
import modelo.Libros;

/**
 *
 * @author Estudiante
 */
public class LibrosJpaController implements Serializable {

    public LibrosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libros libros) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autores idAutor = libros.getIdAutor();
            if (idAutor != null) {
                idAutor = em.getReference(idAutor.getClass(), idAutor.getIdAutor());
                libros.setIdAutor(idAutor);
            }
            Editoriales idEditorial = libros.getIdEditorial();
            if (idEditorial != null) {
                idEditorial = em.getReference(idEditorial.getClass(), idEditorial.getIdEditorial());
                libros.setIdEditorial(idEditorial);
            }
            em.persist(libros);
            if (idAutor != null) {
                idAutor.getLibrosList().add(libros);
                idAutor = em.merge(idAutor);
            }
            if (idEditorial != null) {
                idEditorial.getLibrosList().add(libros);
                idEditorial = em.merge(idEditorial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libros libros) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libros persistentLibros = em.find(Libros.class, libros.getIdLibro());
            Autores idAutorOld = persistentLibros.getIdAutor();
            Autores idAutorNew = libros.getIdAutor();
            Editoriales idEditorialOld = persistentLibros.getIdEditorial();
            Editoriales idEditorialNew = libros.getIdEditorial();
            if (idAutorNew != null) {
                idAutorNew = em.getReference(idAutorNew.getClass(), idAutorNew.getIdAutor());
                libros.setIdAutor(idAutorNew);
            }
            if (idEditorialNew != null) {
                idEditorialNew = em.getReference(idEditorialNew.getClass(), idEditorialNew.getIdEditorial());
                libros.setIdEditorial(idEditorialNew);
            }
            libros = em.merge(libros);
            if (idAutorOld != null && !idAutorOld.equals(idAutorNew)) {
                idAutorOld.getLibrosList().remove(libros);
                idAutorOld = em.merge(idAutorOld);
            }
            if (idAutorNew != null && !idAutorNew.equals(idAutorOld)) {
                idAutorNew.getLibrosList().add(libros);
                idAutorNew = em.merge(idAutorNew);
            }
            if (idEditorialOld != null && !idEditorialOld.equals(idEditorialNew)) {
                idEditorialOld.getLibrosList().remove(libros);
                idEditorialOld = em.merge(idEditorialOld);
            }
            if (idEditorialNew != null && !idEditorialNew.equals(idEditorialOld)) {
                idEditorialNew.getLibrosList().add(libros);
                idEditorialNew = em.merge(idEditorialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libros.getIdLibro();
                if (findLibros(id) == null) {
                    throw new NonexistentEntityException("The libros with id " + id + " no longer exists.");
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
            Libros libros;
            try {
                libros = em.getReference(Libros.class, id);
                libros.getIdLibro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libros with id " + id + " no longer exists.", enfe);
            }
            Autores idAutor = libros.getIdAutor();
            if (idAutor != null) {
                idAutor.getLibrosList().remove(libros);
                idAutor = em.merge(idAutor);
            }
            Editoriales idEditorial = libros.getIdEditorial();
            if (idEditorial != null) {
                idEditorial.getLibrosList().remove(libros);
                idEditorial = em.merge(idEditorial);
            }
            em.remove(libros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libros> findLibrosEntities() {
        return findLibrosEntities(true, -1, -1);
    }

    public List<Libros> findLibrosEntities(int maxResults, int firstResult) {
        return findLibrosEntities(false, maxResults, firstResult);
    }

    private List<Libros> findLibrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libros.class));
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

    public Libros findLibros(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libros.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libros> rt = cq.from(Libros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
