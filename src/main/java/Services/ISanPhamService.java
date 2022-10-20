package Services;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface ISanPhamService {

    List<SanPham> getAll();

    String save(SanPham sp);

    String delete(SanPham sp);

    SanPham getObjByMa(String ma);
}
