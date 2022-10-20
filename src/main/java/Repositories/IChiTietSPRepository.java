package Repositories;

import DomainModels.ChiTietSP;
import DomainModels.SanPham;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IChiTietSPRepository {

    List<ChiTietSP> getAll();

    String save(ChiTietSP ctsp);

    String delete(ChiTietSP ctsp);

    List<ChiTietSP> findByName(String ten);
    
    ChiTietSP getObjById(UUID id);
}
