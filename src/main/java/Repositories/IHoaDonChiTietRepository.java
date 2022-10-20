package Repositories;

import DomainModels.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IHoaDonChiTietRepository {

    List<HoaDonChiTiet> getAll();

    String save(HoaDonChiTiet hdct);
    
    String delete(HoaDonChiTiet hdct);
    
    List<HoaDonChiTiet> findById(UUID id);
    
    HoaDonChiTiet getObj(UUID idHD,UUID idCTSP);
}
