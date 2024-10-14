package etatcivil;

import ma.projet.config.HibernateUtil;
import org.hibernate.Hibernate ;
public class Etatcivil {

    public static void main(String[] args) {
    HibernateUtil.getSessionFactory().openSession();
    }
    
}
