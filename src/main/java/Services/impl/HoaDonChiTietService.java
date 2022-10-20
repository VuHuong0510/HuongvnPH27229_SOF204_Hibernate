package Services.impl;

import DomainModels.HoaDonChiTiet;
import Repositories.IHoaDonChiTietRepository;
import Repositories.impl.HoaDonChiTietRepository;
import Services.IHoaDonChiTietService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class HoaDonChiTietService implements IHoaDonChiTietService {

    private IHoaDonChiTietRepository iHoaDonChiTietRepository;

    public HoaDonChiTietService() {
        iHoaDonChiTietRepository = new HoaDonChiTietRepository();
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return iHoaDonChiTietRepository.getAll();
    }

    @Override
    public String save(HoaDonChiTiet hdct) {
        return iHoaDonChiTietRepository.save(hdct);
    }

    @Override
    public List<HoaDonChiTiet> findById(UUID id) {
        return iHoaDonChiTietRepository.findById(id);
    }

    @Override
    public HoaDonChiTiet getObj(UUID idHD, UUID idCTSP) {
        return iHoaDonChiTietRepository.getObj(idHD, idCTSP);
    }

    @Override
    public String delete(HoaDonChiTiet hdct) {
        return iHoaDonChiTietRepository.delete(hdct);
    }

}
