package Repositories.impl;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
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
public class KhachHangRepository implements IKhachHangRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<KhachHang> getAll() {
        return session.createCriteria(KhachHang.class).list();
    }

    @Override
    public String save(KhachHang kh) {
        try {
            transaction.begin();
            session.saveOrUpdate(kh);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(KhachHang kh) {
        try {
            transaction.begin();
            session.delete(kh);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public KhachHang getObjByMa(String ma) {
        KhachHang kh = null;
        try {
            Query query = session.createQuery("SELECT k FROM KhachHang k WHERE k.ma = :ma");
            query.setParameter("ma", ma);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        if (kh == null) {
            return null;
        } else {
            return kh;
        }
    }

    @Override
    public List<KhachHang> findByName(String ten) {
        List<KhachHang> list = new ArrayList<>();
        Query query = session.createQuery("SELECT k FROM KhachHang k WHERE k.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        list = query.getResultList();
        return list;
    }

}
