package Repositories.impl;

import DomainModels.NhanVien;
import Repositories.INhanVienRepository;
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
public class NhanVienRepository implements INhanVienRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<NhanVien> getAll() {
        return session.createCriteria(NhanVien.class).list();
    }

    @Override
    public String save(NhanVien nv) {
        try {
            transaction.begin();
            session.saveOrUpdate(nv);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(NhanVien nv) {
        try {
            transaction.begin();
            session.delete(nv);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public NhanVien getObjByMa(String ma) {
        NhanVien nv = null;
        try {
            Query query = session.createQuery("SELECT n FROM NhanVien n WHERE n.ma = :ma");
            query.setParameter("ma", ma);
            nv = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
        }
        if (nv == null) {
            return null;
        } else {
            return nv;
        }
    }

    @Override
    public List<NhanVien> findByName(String ten) {
        List<NhanVien> list = new ArrayList<>();
        Query query = session.createQuery("SELECT h FROM NhanVien h WHERE h.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        list = query.getResultList();
        return list;
    }

}
