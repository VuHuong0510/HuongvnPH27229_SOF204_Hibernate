package Services.impl;

import DomainModels.HoaDon;
import Repositories.IHoaDonRepository;
import Repositories.impl.HoaDonRepository;
import Services.IHoaDonService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class HoaDonService implements IHoaDonService {

    private IHoaDonRepository iHoaDonRepository;

    public HoaDonService() {
        iHoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<HoaDon> getAll() {
        return iHoaDonRepository.getAll();
    }

    @Override
    public String save(HoaDon hd) {
        return iHoaDonRepository.save(hd);
    }

    @Override
    public HoaDon getObjByMa(String ma) {
        return iHoaDonRepository.getObjByMa(ma);
    }

    @Override
    public List<HoaDon> findByTT(int trangThai) {
        return iHoaDonRepository.findByTT(trangThai);
    }

}
