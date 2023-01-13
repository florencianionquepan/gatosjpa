/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.logica.Ficha;
import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author florencia
 */
public class FichaJpaController implements Serializable {

    public FichaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public FichaJpaController(){
        emf=Persistence.createEntityManagerFactory("gatosjpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ficha ficha) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ficha);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ficha ficha) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ficha = em.merge(ficha);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ficha.getId();
                if (findFicha(id) == null) {
                    throw new NonexistentEntityException("The ficha with id " + id + " no longer exists.");
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
            Ficha ficha;
            try {
                ficha = em.getReference(Ficha.class, id);
                ficha.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ficha with id " + id + " no longer exists.", enfe);
            }
            em.remove(ficha);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ficha> findFichaEntities() {
        return findFichaEntities(true, -1, -1);
    }

    public List<Ficha> findFichaEntities(int maxResults, int firstResult) {
        return findFichaEntities(false, maxResults, firstResult);
    }

    private List<Ficha> findFichaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ficha.class));
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

    public Ficha findFicha(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ficha.class, id);
        } finally {
            em.close();
        }
    }

    public int getFichaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ficha> rt = cq.from(Ficha.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
