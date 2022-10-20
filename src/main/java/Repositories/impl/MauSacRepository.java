package Repositories.impl;

import DomainModels.MauSac;
import Repositories.IMauSacRepository;
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
public class MauSacRepository implements IMauSacRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<MauSac> getAll() {
        return session.createCriteria(MauSac.class).list();
    }

    @Override
    public String save(MauSac ms) {
        try {
            transaction.begin();
            session.saveOrUpdate(ms);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(MauSac ms) {
        try {
            transaction.begin();
            session.delete(ms);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
//            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public MauSac getObjByMa(String ma) {
        MauSac ms = null;
        try {
            Query query = session.createQuery("From MauSac where ma = :ma");
            query.setParameter("ma", ma);
            ms = (MauSac) query.getSingleResult();
        } catch (Exception e) {
        }
        if (ms == null) {
            return null;
        } else {
            return ms;
        }
    }

}
