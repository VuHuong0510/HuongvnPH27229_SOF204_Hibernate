package Services.impl;

import DomainModels.MauSac;
import Repositories.IMauSacRepository;
import Repositories.impl.MauSacRepository;
import Services.IQLMauSacService;
import ViewModels.QLMauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLMauSacService implements IQLMauSacService {

    private IMauSacRepository iMauSacRepository;
    List<QLMauSac> listMauSac;

    public QLMauSacService() {
        iMauSacRepository = new MauSacRepository();
        listMauSac = new ArrayList<>();
    }

    @Override
    public List<QLMauSac> getAll() {
        listMauSac = new ArrayList<>();
        for (MauSac x : iMauSacRepository.getAll()) {
            listMauSac.add(new QLMauSac(x.getId(), x.getMa(), x.getTen()));
        }
        return listMauSac;
    }

    @Override
    public String add(QLMauSac qlms) {
        MauSac ms = new MauSac();
        ms.setMa(qlms.getMa());
        ms.setTen(qlms.getTen());
        return iMauSacRepository.save(ms);
    }

    @Override
    public String update(QLMauSac qlms) {
        MauSac ms = iMauSacRepository.getObjByMa(qlms.getMa());
        ms.setTen(qlms.getTen());
        return iMauSacRepository.save(ms);
    }

    @Override
    public String delete(QLMauSac qlms) {
        MauSac ms = iMauSacRepository.getObjByMa(qlms.getMa());
        return iMauSacRepository.delete(ms);
    }

    @Override
    public QLMauSac getObjByMa(String ma) {
        MauSac ms = iMauSacRepository.getObjByMa(ma);
        if (ms == null) {
            return null;
        } else {
            return new QLMauSac(ms.getId(), ms.getMa(), ms.getTen());
        }
    }

    @Override
    public List<QLMauSac> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
