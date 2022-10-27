package Services.impl;

import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Repositories.impl.SanPhamRepository;
import Services.IQLSPService;
import ViewModels.QLSP;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLSPService implements IQLSPService {

    private ISanPhamRepository iSanPhamRepository;
    private List<QLSP> list;

    public QLSPService() {
        iSanPhamRepository = new SanPhamRepository();
        list = new ArrayList<>();
    }

    @Override
    public List<QLSP> getAll() {
        list = new ArrayList<>();
        for (SanPham x : iSanPhamRepository.getAll()) {
            list.add(new QLSP(x.getId(), x.getMa(), x.getTen()));
        }
        return list;
    }

    @Override
    public String add(QLSP obj) {
        SanPham sp = new SanPham();
        sp.setMa(obj.getMa());
        sp.setTen(obj.getTen());
        return iSanPhamRepository.save(sp);
    }

    @Override
    public String update(QLSP obj) {
        SanPham sp = iSanPhamRepository.getObjByMa(obj.getMa());
        sp.setTen(obj.getTen());
        return iSanPhamRepository.save(sp);
    }

    @Override
    public String delete(QLSP obj) {
        SanPham sp = iSanPhamRepository.getObjByMa(obj.getMa());
        return iSanPhamRepository.delete(sp);
    }

    @Override
    public QLSP getObjByMa(String ma) {
        SanPham sp = iSanPhamRepository.getObjByMa(ma);
        if (sp == null) {
            return null;
        } else {
            return new QLSP(sp.getId(), sp.getMa(), sp.getTen());
        }
    }

    @Override
    public List<QLSP> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
