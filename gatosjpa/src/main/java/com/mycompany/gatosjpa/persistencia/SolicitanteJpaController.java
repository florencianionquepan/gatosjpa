/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatosjpa.persistencia;

import com.mycompany.gatosjpa.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.gatosjpa.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gatosjpa.logica.Gato;
import com.mycompany.gatosjpa.logica.Solicitante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author florencia
 */
public class SolicitanteJpaController implements Serializable {

    public SolicitanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SolicitanteJpaController() {
        emf=Persistence.createEntityManagerFactory("gatosjpaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Solicitante solicitante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gato gato = solicitante.getGato();
            if (gato != null) {
                gato = em.getReference(gato.getClass(), gato.getId());
                solicitante.setGato(gato);
            }
            em.persist(solicitante);
            if (gato != null) {
                gato.getListaSolic().add(solicitante);
                gato = em.merge(gato);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSolicitante(solicitante.getDni()) != null) {
                throw new PreexistingEntityException("Solicitante " + solicitante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Solicitante solicitante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitante persistentSolicitante = em.find(Solicitante.class, solicitante.getDni());
            Gato gatoOld = persistentSolicitante.getGato();
            Gato gatoNew = solicitante.getGato();
            if (gatoNew != null) {
                gatoNew = em.getReference(gatoNew.getClass(), gatoNew.getId());
                solicitante.setGato(gatoNew);
            }
            solicitante = em.merge(solicitante);
            if (gatoOld != null && !gatoOld.equals(gatoNew)) {
                gatoOld.getListaSolic().remove(solicitante);
                gatoOld = em.merge(gatoOld);
            }
            if (gatoNew != null && !gatoNew.equals(gatoOld)) {
                gatoNew.getListaSolic().add(solicitante);
                gatoNew = em.merge(gatoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = solicitante.getDni();
                if (findSolicitante(id) == null) {
                    throw new NonexistentEntityException("The solicitante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitante solicitante;
            try {
                solicitante = em.getReference(Solicitante.class, id);
                solicitante.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitante with id " + id + " no longer exists.", enfe);
            }
            Gato gato = solicitante.getGato();
            if (gato != null) {
                gato.getListaSolic().remove(solicitante);
                gato = em.merge(gato);
            }
            em.remove(solicitante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Solicitante> findSolicitanteEntities() {
        return findSolicitanteEntities(true, -1, -1);
    }

    public List<Solicitante> findSolicitanteEntities(int maxResults, int firstResult) {
        return findSolicitanteEntities(false, maxResults, firstResult);
    }

    private List<Solicitante> findSolicitanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Solicitante.class));
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

    public Solicitante findSolicitante(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitante.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitante> rt = cq.from(Solicitante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
