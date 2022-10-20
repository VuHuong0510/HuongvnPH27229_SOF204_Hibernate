package Services;

import Repositories.*;
import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IHoaDonService {

    List<HoaDon> getAll();

    String save(HoaDon hd);
    
    HoaDon getObjByMa(String ma);
    
    List<HoaDon> findByTT(int trangThai);
}
