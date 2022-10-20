package Services.impl;

import DomainModels.DongSP;
import Repositories.IDongSPRepository;
import Repositories.impl.DongSPRepository;
import Services.IDongSPService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class DongSPService implements IDongSPService {

    private IDongSPRepository iDongSPRepository;

    public DongSPService() {
        iDongSPRepository = new DongSPRepository();
    }

    @Override
    public List<DongSP> getAll() {
        return iDongSPRepository.getAll();
    }

    @Override
    public String save(DongSP dsp) {
        return iDongSPRepository.save(dsp);
    }

    @Override
    public String delete(DongSP dsp) {
        return iDongSPRepository.delete(dsp);
    }

    @Override
    public DongSP getObjByMa(String ma) {
        return iDongSPRepository.getObjByMa(ma);
    }

}
