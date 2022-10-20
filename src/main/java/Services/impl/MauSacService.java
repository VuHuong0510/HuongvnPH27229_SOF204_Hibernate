package Services.impl;

import DomainModels.MauSac;
import Repositories.IMauSacRepository;
import Repositories.impl.MauSacRepository;
import Services.IMauSacService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class MauSacService implements IMauSacService {

    private IMauSacRepository iMauSacRepository;

    public MauSacService() {
        iMauSacRepository = new MauSacRepository();
    }

    @Override
    public List<MauSac> getAll() {
        return iMauSacRepository.getAll();
    }

    @Override
    public String save(MauSac ms) {
        return iMauSacRepository.save(ms);
    }

    @Override
    public String delete(MauSac ms) {
        return iMauSacRepository.delete(ms);
    }

    @Override
    public MauSac getObjByMa(String ma) {
        return iMauSacRepository.getObjByMa(ma);
    }

}
