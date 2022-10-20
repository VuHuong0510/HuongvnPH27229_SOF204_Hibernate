package Repositories.impl;

import DomainModels.HoaDonChiTiet;
import Repositories.IHoaDonChiTietRepository;
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
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return session.createCriteria(HoaDonChiTiet.class).list();
    }

    @Override
    public String save(HoaDonChiTiet hdct) {
        try {
            transaction.begin();
            session.saveOrUpdate(hdct);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public List<HoaDonChiTiet> findById(UUID id) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        Query query = session.createQuery("SELECT h FROM HoaDonChiTiet h WHERE h.hoaDon.id = :id");
        query.setParameter("id", id);
        list = query.getResultList();
        return list;
    }

    @Override
    public HoaDonChiTiet getObj(UUID idHD, UUID idCTSP) {
        HoaDonChiTiet hdct = null;
        try {
            Query query = session.createQuery("SELECT hd FROM HoaDonChiTiet hd WHERE hd.hoaDon.id = :idHD AND hd.chiTietSP.id = :idCTSP");
            query.setParameter("idHD", idHD);
            query.setParameter("idCTSP", idCTSP);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
        }
        if (hdct == null) {
            return null;
        } else {
            return hdct;
        }
    }

    @Override
    public String delete(HoaDonChiTiet hdct) {
        try {
            transaction.begin();
            session.delete(hdct);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

}
