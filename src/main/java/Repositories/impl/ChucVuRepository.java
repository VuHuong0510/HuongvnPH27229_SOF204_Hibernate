package Repositories.impl;

import DomainModels.ChucVu;
import Repositories.IChucVuRepository;
import Utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class ChucVuRepository implements IChucVuRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<ChucVu> getAll() {
        return session.createCriteria(ChucVu.class).list();
    }

    @Override
    public String save(ChucVu cv) {
        try {
            transaction.begin();
            session.saveOrUpdate(cv);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(ChucVu cv) {
        try {
            transaction.begin();
            session.delete(cv);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
//            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public ChucVu getObjByMa(String ma) {
        ChucVu cv = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChucVu c WHERE c.ma = :ma");
            query.setParameter("ma", ma);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
        }
        if (cv == null) {
            return null;
        } else {
            return cv;
        }
    }

    @Override
    public List<ChucVu> findByName(String ten) {
        List<ChucVu> list = new ArrayList<>();
        Query query = session.createQuery("SELECT c FROM ChucVu c WHERE c.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        return list;
    }

    @Override
    public ChucVu getObjById(UUID id) {
        ChucVu cv = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChucVu c WHERE c.id = :id");
            query.setParameter("id", id);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
        }
        if (cv == null) {
            return null;
        } else {
            return cv;
        }
    }

}
