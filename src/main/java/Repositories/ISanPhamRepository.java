package Repositories;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface ISanPhamRepository {

    List<SanPham> getAll();

    String save(SanPham sanPham);

    String delete(SanPham sp);

    SanPham getObjByMa(String ma);
}
