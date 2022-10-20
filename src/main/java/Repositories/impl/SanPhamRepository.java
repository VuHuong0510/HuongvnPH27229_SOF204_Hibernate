package Repositories.impl;

import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Utilities.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SanPhamRepository implements ISanPhamRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<SanPham> getAll() {
        return session.createCriteria(SanPham.class).list();
    }

    @Override
    public String save(SanPham sanPham) {
        try {
            transaction.begin();
            session.saveOrUpdate(sanPham);
            transaction.commit();
            return "NotOK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "OK";
        }
    }

    @Override
    public String delete(SanPham sp) {
        try {
            transaction.begin();
            session.delete(sp);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            return "NotOK";
//            e.printStackTrace();
        }
    }

    @Override
    public SanPham getObjByMa(String ma) {
        SanPham sp = null;
        try {
            Query query = session.createQuery("FROM SanPham WHERE ma = :ma");
            query.setParameter("ma", ma);
            sp = (SanPham) query.getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (sp == null) {
            return null;
        } else {
            return sp;
        }

    }

}
