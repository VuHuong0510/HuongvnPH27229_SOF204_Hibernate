package Repositories.impl;

import DomainModels.NSX;
import Repositories.INsxRepository;
import Utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class NsxRepository implements INsxRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();
    @Override
    public List<NSX> getAll() {
        return session.createCriteria(NSX.class).list();
    }

    @Override
    public String save(NSX nsx) {
        try {
            transaction.begin();
            session.saveOrUpdate(nsx);
            session.getTransaction().commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(NSX nsx) {
        try {
            transaction.begin();
            session.delete(nsx);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
//            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public NSX getObjByMa(String ma) {
        NSX nsx = null;
        try {
            Query query = session.createQuery("FROM NSX WHERE ma = :ma");
            query.setParameter("ma", ma);
            nsx = (NSX) query.getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if(nsx == null){
            return null;
        }else{
            return nsx;
        }
    }

}
