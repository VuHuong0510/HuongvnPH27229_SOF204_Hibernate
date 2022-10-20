package Repositories.impl;

import DomainModels.ChiTietSP;
import Repositories.IChiTietSPRepository;
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
public class ChiTietSPRepository implements IChiTietSPRepository {

    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public List<ChiTietSP> getAll() {
        return session.createCriteria(ChiTietSP.class).list();
    }

    @Override
    public String save(ChiTietSP ctsp) {
        try {
            transaction.begin();
            session.saveOrUpdate(ctsp);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public String delete(ChiTietSP ctsp) {
        try {
            transaction.begin();
            session.delete(ctsp);
            transaction.commit();
            return "OK";
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "NotOK";
        }
    }

    @Override
    public List<ChiTietSP> findByName(String ten) {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            Query query = session.createQuery("SELECT ct FROM ChiTietSP ct WHERE ct.sanPham.ten LIKE :ten");
            query.setParameter("ten", "%" + ten + "%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public static void main(String[] args) {
//        ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
//        
//        for (ChiTietSP x : chiTietSPRepository.findByName("Bitis Hunter")) {
//            System.out.println(x.toString());
//        }
//    }
    @Override
    public ChiTietSP getObjById(UUID id) {
        ChiTietSP ctsp = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChiTietSP c WHERE c.id = :id");
            query.setParameter("id", id);
            ctsp = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {

        }

        if (ctsp == null) {
            return null;
        } else {
            return ctsp;
        }
    }
}
