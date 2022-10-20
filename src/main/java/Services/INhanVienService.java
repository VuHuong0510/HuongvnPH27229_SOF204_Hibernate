package Services;

import Repositories.*;
import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface INhanVienService {

    List<NhanVien> getAll();

    String save(NhanVien nv);

    String delete(NhanVien nv);

    NhanVien getObjByMa(String ma);
}
