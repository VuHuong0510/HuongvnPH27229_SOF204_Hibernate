package Repositories.impl;

import DomainModels.DongSP;
import Repositories.IDongSPRepository;
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
public class DongSPRepository implements IDongSPRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<DongSP> getAll() {
        return session.createCriteria(DongSP.class).list();
    }

    @Override
    public String save(DongSP dongSP) {
        try {
            transaction.begin();
            session.saveOrUpdate(dongSP);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(DongSP dsp) {
        try {
            transaction.begin();
            session.delete(dsp);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
//            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public DongSP getObjByMa(String ma) {
        DongSP dongSP = null;
        try {
            Query query = session.createQuery("From DongSP where ma = :ma");
            query.setParameter("ma", ma);
            dongSP = (DongSP) query.getSingleResult();
        } catch (Exception e) {
        }
        if (dongSP == null) {
            return null;
        } else {
            return dongSP;
        }
    }

}
