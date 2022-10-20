package Services.impl;

import DomainModels.NSX;
import Repositories.INsxRepository;
import Repositories.impl.NsxRepository;
import Services.INsxService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class NsxService implements INsxService {

    private INsxRepository iNsxRepository;

    public NsxService() {
        iNsxRepository = new NsxRepository();
    }

    @Override
    public List<NSX> getAll() {
        return iNsxRepository.getAll();
    }

    @Override
    public String save(NSX nsx) {
        return iNsxRepository.save(nsx);
    }

    @Override
    public String delete(NSX nsx) {
        return iNsxRepository.delete(nsx);
    }

    @Override
    public NSX getObjByMa(String ma) {
        return iNsxRepository.getObjByMa(ma);
    }

}
