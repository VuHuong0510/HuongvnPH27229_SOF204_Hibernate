package Services;

import ViewModels.QLNhanVien;
import java.util.List;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IQLNhanVienService {

    List<QLNhanVien> getAll();

    String add(QLNhanVien obj);

    String update(QLNhanVien obj);

    String delete(QLNhanVien obj);

    QLNhanVien getObjByMa(String ma);

    List<QLNhanVien> findByName(String ten);
}
