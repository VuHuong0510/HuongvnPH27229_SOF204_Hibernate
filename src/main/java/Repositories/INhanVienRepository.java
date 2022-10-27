package Repositories;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();

    String save(NhanVien nv);

    String delete(NhanVien nv);

    NhanVien getObjByMa(String ma);

    List<NhanVien> findByName(String ten);
}
