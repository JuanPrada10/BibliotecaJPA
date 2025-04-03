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
import modelo.Editoriales;

/**
 *
 * @author Estudiante
 */
public class EditorialesJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    
    public EditorialesJpaController() {
        this.emf = emf = Persistence.createEntityManagerFactory("UnidadBD1");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Editoriales editoriales) {
        if (editoriales.getLibrosList() == null) {
            editoriales.setLibrosList(new ArrayList<Libros>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Libros> attachedLibrosList = new ArrayList<Libros>();
            for (Libros librosListLibrosToAttach : editoriales.getLibrosList()) {
                librosListLibrosToAttach = em.getReference(librosListLibrosToAttach.getClass(), librosListLibrosToAttach.getIdLibro());
                attachedLibrosList.add(librosListLibrosToAttach);
            }
            editoriales.setLibrosList(attachedLibrosList);
            em.persist(editoriales);
            for (Libros librosListLibros : editoriales.getLibrosList()) {
                Editoriales oldIdEditorialOfLibrosListLibros = librosListLibros.getIdEditorial();
                librosListLibros.setIdEditorial(editoriales);
                librosListLibros = em.merge(librosListLibros);
                if (oldIdEditorialOfLibrosListLibros != null) {
                    oldIdEditorialOfLibrosListLibros.getLibrosList().remove(librosListLibros);
                    oldIdEditorialOfLibrosListLibros = em.merge(oldIdEditorialOfLibrosListLibros);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Editoriales editoriales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Editoriales persistentEditoriales = em.find(Editoriales.class, editoriales.getIdEditorial());
            List<Libros> librosListOld = persistentEditoriales.getLibrosList();
            List<Libros> librosListNew = editoriales.getLibrosList();
            List<Libros> attachedLibrosListNew = new ArrayList<Libros>();
            for (Libros librosListNewLibrosToAttach : librosListNew) {
                librosListNewLibrosToAttach = em.getReference(librosListNewLibrosToAttach.getClass(), librosListNewLibrosToAttach.getIdLibro());
                attachedLibrosListNew.add(librosListNewLibrosToAttach);
            }
            librosListNew = attachedLibrosListNew;
            editoriales.setLibrosList(librosListNew);
            editoriales = em.merge(editoriales);
            for (Libros librosListOldLibros : librosListOld) {
                if (!librosListNew.contains(librosListOldLibros)) {
                    librosListOldLibros.setIdEditorial(null);
                    librosListOldLibros = em.merge(librosListOldLibros);
                }
            }
            for (Libros librosListNewLibros : librosListNew) {
                if (!librosListOld.contains(librosListNewLibros)) {
                    Editoriales oldIdEditorialOfLibrosListNewLibros = librosListNewLibros.getIdEditorial();
                    librosListNewLibros.setIdEditorial(editoriales);
                    librosListNewLibros = em.merge(librosListNewLibros);
                    if (oldIdEditorialOfLibrosListNewLibros != null && !oldIdEditorialOfLibrosListNewLibros.equals(editoriales)) {
                        oldIdEditorialOfLibrosListNewLibros.getLibrosList().remove(librosListNewLibros);
                        oldIdEditorialOfLibrosListNewLibros = em.merge(oldIdEditorialOfLibrosListNewLibros);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = editoriales.getIdEditorial();
                if (findEditoriales(id) == null) {
                    throw new NonexistentEntityException("The editoriales with id " + id + " no longer exists.");
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
            Editoriales editoriales;
            try {
                editoriales = em.getReference(Editoriales.class, id);
                editoriales.getIdEditorial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The editoriales with id " + id + " no longer exists.", enfe);
            }
            List<Libros> librosList = editoriales.getLibrosList();
            for (Libros librosListLibros : librosList) {
                librosListLibros.setIdEditorial(null);
                librosListLibros = em.merge(librosListLibros);
            }
            em.remove(editoriales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Editoriales> findEditorialesEntities() {
        return findEditorialesEntities(true, -1, -1);
    }

    public List<Editoriales> findEditorialesEntities(int maxResults, int firstResult) {
        return findEditorialesEntities(false, maxResults, firstResult);
    }

    private List<Editoriales> findEditorialesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Editoriales.class));
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

    public Editoriales findEditoriales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Editoriales.class, id);
        } finally {
            em.close();
        }
    }

    public int getEditorialesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Editoriales> rt = cq.from(Editoriales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
