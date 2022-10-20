package Services;

import Repositories.*;
import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IKhachHangService {

    List<KhachHang> getAll();

    String save(KhachHang kh);

    String delete(KhachHang kh);

    KhachHang getObjByMa(String ma);
}
