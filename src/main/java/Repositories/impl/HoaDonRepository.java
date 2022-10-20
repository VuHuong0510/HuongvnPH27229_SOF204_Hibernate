package Repositories.impl;

import DomainModels.HoaDon;
import Repositories.IHoaDonRepository;
import Utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class HoaDonRepository implements IHoaDonRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        NativeQuery query = session.createNativeQuery("SELECT * FROM HOADON ORDER BY  CAST(SUBSTRING(ma,3,LEN(MA)-2) AS INT) DESC",HoaDon.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public String save(HoaDon hd) {
        try {
            transaction.begin();
            session.saveOrUpdate(hd);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public HoaDon getObjByMa(String ma) {
        HoaDon hd = null;
        try {
            Query query = session.createQuery("SELECT h FROM HoaDon h WHERE h.ma = :ma");
            query.setParameter("ma", ma);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
        }
        if (hd == null) {
            return null;
        } else {
            return hd;
        }
    }

    @Override
    public HoaDon getObjById(UUID id) {
        HoaDon hd = null;
        try {
            Query query = session.createQuery("SELECT h FROM HoaDon h WHERE h.id = :id");
            query.setParameter("id", id);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
        }
        if (hd == null) {
            return null;
        } else {
            return hd;
        }
    }

    @Override
    public List<HoaDon> findByTT(int trangThai) {
        List<HoaDon> list = new ArrayList<>();
        NativeQuery query = session.createNativeQuery("SELECT * FROM HOADON WHERE TINHTRANG=? ORDER BY  CAST(SUBSTRING(ma,3,LEN(MA)-2) AS INT) DESC",HoaDon.class);
           query.setParameter(1, trangThai);
        list = query.getResultList();
//        Query query = session.createQuery("SELECT h FROM HoaDon h WHERE h.tinhTrang = :trangThai ORDER BY h.ma DESC");
//        query.setParameter("trangThai", trangThai);
        return list;
    }

}
