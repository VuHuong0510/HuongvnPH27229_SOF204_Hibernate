package Services.impl;

import DomainModels.CuaHang;
import Repositories.ICuaHangRepository;
import Repositories.impl.CuaHangRepository;
import Services.ICuaHangService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class CuaHangService implements ICuaHangService {

    private ICuaHangRepository iCuaHangRepository;

    public CuaHangService() {
        iCuaHangRepository = new CuaHangRepository();
    }

    @Override
    public List<CuaHang> getAll() {
        return iCuaHangRepository.getAll();
    }

    @Override
    public String save(CuaHang ch) {
        return iCuaHangRepository.save(ch);
    }

    @Override
    public String delete(CuaHang ch) {
        return iCuaHangRepository.delete(ch);
    }

    @Override
    public CuaHang getObjByMa(String ma) {
        return iCuaHangRepository.getObjByMa(ma);
    }

}
