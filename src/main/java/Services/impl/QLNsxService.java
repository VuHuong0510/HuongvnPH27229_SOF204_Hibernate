package Services.impl;

import DomainModels.NSX;
import Repositories.INsxRepository;
import Repositories.impl.NsxRepository;
import Services.IQLNsxService;
import ViewModels.QLNsx;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLNsxService implements IQLNsxService {

    private INsxRepository iNsxRepository;
    private List<QLNsx> listNSX;

    public QLNsxService() {
        iNsxRepository = new NsxRepository();
        listNSX = new ArrayList<>();
    }

    @Override
    public List<QLNsx> getAll() {
        listNSX = new ArrayList<>();
        for (NSX x : iNsxRepository.getAll()) {
            listNSX.add(new QLNsx(x.getId(), x.getMa(), x.getTen()));
        }
        return listNSX;
    }

    @Override
    public String add(QLNsx qLNsx) {
        NSX nsx = new NSX();
        nsx.setMa(qLNsx.getMa());
        nsx.setTen(qLNsx.getTen());
        return iNsxRepository.save(nsx);
    }

    @Override
    public String update(QLNsx qLNsx) {
        NSX nsx = iNsxRepository.getObjByMa(qLNsx.getMa());
        nsx.setTen(qLNsx.getTen());
        return iNsxRepository.save(nsx);
    }

    @Override
    public String delete(QLNsx qLNsx) {
        NSX nsx = iNsxRepository.getObjByMa(qLNsx.getMa());
        return iNsxRepository.delete(nsx);
    }

    @Override
    public QLNsx getObjByMa(String ma) {
        NSX nsx = iNsxRepository.getObjByMa(ma);
        if (nsx == null) {
            return null;
        } else {
            return new QLNsx(nsx.getId(), nsx.getMa(), nsx.getTen());
        }
    }

    @Override
    public List<QLNsx> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
