package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.dao.IDao;
import ma.projet.beans.Femme;
import ma.projet.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;

public class FemmetService implements IDao<Femme> {
    @Override
    public boolean create(Femme o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

 

    public Femme findById(int id) {
        Session session = null;
        Femme e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Femme) session.get(Femme.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    public List<Femme> findAll() {
        Session session = null;
        List<Femme>  developpeurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            developpeurs = session.createQuery("from Femme").list();
            session.getTransaction().commit();
            return developpeurs;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return developpeurs;
    }

    @Override
    public Femme getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Femme> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
