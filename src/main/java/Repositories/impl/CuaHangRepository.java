package Repositories.impl;

import DomainModels.CuaHang;
import Repositories.ICuaHangRepository;
import Utilities.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class CuaHangRepository implements ICuaHangRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<CuaHang> getAll() {
        return session.createCriteria(CuaHang.class).list();
    }

    @Override
    public String save(CuaHang ch) {
        try {
            transaction.begin();
            session.saveOrUpdate(ch);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(CuaHang ch) {
        try {
            transaction.begin();
            session.delete(ch);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
//            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public CuaHang getObjByMa(String ma) {
        CuaHang ch = null;
        try {
            Query query = session.createQuery("SELECT c FROM CuaHang c WHERE c.ma = :ma");
            query.setParameter("ma", ma);
            ch = (CuaHang) query.getSingleResult();
        } catch (Exception e) {

        }
        if (ch == null) {
            return null;
        } else {
            return ch;
        }
    }

    @Override
    public CuaHang getObjById(UUID id) {
        CuaHang ch = null;
        try {
            Query query = session.createQuery("SELECT c FROM CuaHang c WHERE c.id = :id");
            query.setParameter("id", id);
            ch = (CuaHang) query.getSingleResult();
        } catch (Exception e) {

        }
        if (ch == null) {
            return null;
        } else {
            return ch;
        }
    }

}
