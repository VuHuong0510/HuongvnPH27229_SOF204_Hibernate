package Repositories;

import DomainModels.HoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IHoaDonRepository {

    List<HoaDon> getAll();

    String save(HoaDon hd);

    HoaDon getObjByMa(String ma);

    HoaDon getObjById(UUID id);
    
    List<HoaDon> findByTT(int trangThai);
}
