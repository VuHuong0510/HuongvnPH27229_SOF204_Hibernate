package Services;

import ViewModels.QLCuaHang;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLCuaHangService {

    List<QLCuaHang> getAll();

    String add(QLCuaHang obj);

    String update(QLCuaHang obj);

    String delete(QLCuaHang obj);

    QLCuaHang getObjByMa(String ma);

    List<QLCuaHang> findByName(String ten);
}
