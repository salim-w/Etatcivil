
package ma.projet.service;

import java.time.LocalDate;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Mariage;
import ma.projet.config.HibernateUtil;
import ma.projet.dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MariageService implements IDao<Mariage>{
   

    @Override
    public boolean create(Mariage o) {
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

    public Mariage findById(int id) {
        Session session = null;
        Mariage m  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
           m= (Mariage) session.get(Mariage.class, id);
            session.getTransaction().commit();
            return m;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return m;
    }

    public List<Mariage> findAll() {
        Session session = null;
        List<Mariage>  mariage = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            mariage = session.createQuery("from Mariage").list();
            session.getTransaction().commit();
            return mariage;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return mariage;
    }
    
    public List<Femme> findEpousesByHommeBetweenDates(Long hommeId, LocalDate startDate, LocalDate endDate) {
        Session session = null;
        List<Femme> epouses = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select m.femme from Mariage m where m.homme.id = :hommeId and m.dateDebut between :startDate and :endDate";
           
                             setParameter("hommeId", hommeId);
                             setParameter("startDate", startDate);
                            setParameter("endDate", endDate);
                          
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return epouses;
    }

    @Override
    public Mariage getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mariage> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object setParameter(String hommeId, Long hommeId0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setParameter(String startDate, LocalDate startDate0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }

