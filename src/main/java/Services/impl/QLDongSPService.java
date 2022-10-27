package Services.impl;

import DomainModels.DongSP;
import Repositories.IDongSPRepository;
import Repositories.impl.DongSPRepository;
import Services.IQLDongSPService;
import ViewModels.QLDongSP;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLDongSPService implements IQLDongSPService {

    private IDongSPRepository iDongSPRepository;
    private List<QLDongSP> list;

    public QLDongSPService() {
        iDongSPRepository = new DongSPRepository();
        list = new ArrayList<>();
    }

    @Override
    public List<QLDongSP> getAll() {
        list = new ArrayList<>();
        for (DongSP x : iDongSPRepository.getAll()) {
            list.add(new QLDongSP(x.getId(), x.getMa(), x.getTen()));
        }
        return list;
    }

    @Override
    public String add(QLDongSP obj) {
        DongSP dongSP = new DongSP();
        dongSP.setMa(obj.getMa());
        dongSP.setTen(obj.getTen());
        return iDongSPRepository.save(dongSP);
    }

    @Override
    public String update(QLDongSP obj) {
        DongSP dongSP = iDongSPRepository.getObjByMa(obj.getMa());
        dongSP.setTen(obj.getTen());
        return iDongSPRepository.save(dongSP);
    }

    @Override
    public String delete(QLDongSP obj) {
        DongSP dongSP = iDongSPRepository.getObjByMa(obj.getMa());
        return iDongSPRepository.delete(dongSP);
    }

    @Override
    public QLDongSP getObjByMa(String ma) {
        DongSP dongSP = iDongSPRepository.getObjByMa(ma);
        if (dongSP == null) {
            return null;
        } else {
            return new QLDongSP(dongSP.getId(), dongSP.getMa(), dongSP.getTen());
        }
    }

    @Override
    public List<QLDongSP> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
