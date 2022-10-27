package Services;

import ViewModels.QLKhachHang;
import java.util.List;

/**
 *
 * @author VU NGUYEN HUONG
 */
public interface IQLKhachHangService {
    List<QLKhachHang> getAll();

    String add(QLKhachHang obj);

    String update(QLKhachHang obj);

    String delete(QLKhachHang obj);

    QLKhachHang getObjByMa(String ma);

    List<QLKhachHang> findByName(String ten);
}
