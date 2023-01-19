/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.gatosjpa.logica.Gato;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gatosjpa.logica.Voluntario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author florencia
 */
public class GatoJpaController implements Serializable {

    public GatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public GatoJpaController() {
        emf=Persistence.createEntityManagerFactory("gatosjpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gato gato) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voluntario volunt = gato.getVolunt();
            if (volunt != null) {
                volunt = em.getReference(volunt.getClass(), volunt.getDni());
                gato.setVolunt(volunt);
            }
            em.persist(gato);
            if (volunt != null) {
                volunt.getGatos().add(gato);
                volunt = em.merge(volunt);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gato gato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato persistentGato = em.find(Gato.class, gato.getId());
            Voluntario voluntOld = persistentGato.getVolunt();
            Voluntario voluntNew = gato.getVolunt();
            if (voluntNew != null) {
                voluntNew = em.getReference(voluntNew.getClass(), voluntNew.getDni());
                gato.setVolunt(voluntNew);
            }
            gato = em.merge(gato);
            if (voluntOld != null && !voluntOld.equals(voluntNew)) {
                voluntOld.getGatos().remove(gato);
                voluntOld = em.merge(voluntOld);
            }
            if (voluntNew != null && !voluntNew.equals(voluntOld)) {
                voluntNew.getGatos().add(gato);
                voluntNew = em.merge(voluntNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = gato.getId();
                if (findGato(id) == null) {
                    throw new NonexistentEntityException("The gato with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato gato;
            try {
                gato = em.getReference(Gato.class, id);
                gato.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gato with id " + id + " no longer exists.", enfe);
            }
            Voluntario volunt = gato.getVolunt();
            if (volunt != null) {
                volunt.getGatos().remove(gato);
                volunt = em.merge(volunt);
            }
            em.remove(gato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gato> findGatoEntities() {
        return findGatoEntities(true, -1, -1);
    }

    public List<Gato> findGatoEntities(int maxResults, int firstResult) {
        return findGatoEntities(false, maxResults, firstResult);
    }

    private List<Gato> findGatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gato.class));
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

    public Gato findGato(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gato.class, id);
        } finally {
            em.close();
        }
    }

    public int getGatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gato> rt = cq.from(Gato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
