package Repositories;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface ICuaHangRepository {

    List<CuaHang> getAll();

    String save(CuaHang ch);

    String delete(CuaHang ch);

    CuaHang getObjByMa(String ma);
}
