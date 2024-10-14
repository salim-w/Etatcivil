package ma.projet.service;
import ma.projet.beans.Homme;
import ma.projet.dao.IDao;
import ma.projet.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.HibernateException;
public class HommeService implements IDao<Homme>{
    @Override
    public boolean create(Homme o) {
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


    public Homme findById(int id) {
        Session session = null;
        Homme e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Homme) session.get(Homme.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    public List<Homme> findAll() {
        Session session = null;
        List<Homme>  homme = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            homme = session.createQuery("from Homme").list();
            session.getTransaction().commit();
            return homme;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return homme;
    }
    @Override
    public Homme getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Homme> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    }