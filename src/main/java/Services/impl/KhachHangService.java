package Services.impl;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Repositories.impl.KhachHangRepository;
import Services.IKhachHangService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class KhachHangService implements IKhachHangService {

    private IKhachHangRepository iKhachHangRepository;

    public KhachHangService() {
        iKhachHangRepository = new KhachHangRepository();
    }

    @Override
    public List<KhachHang> getAll() {
        return iKhachHangRepository.getAll();
    }

    @Override
    public String save(KhachHang kh) {
        return iKhachHangRepository.save(kh);
    }

    @Override
    public String delete(KhachHang kh) {
        return iKhachHangRepository.delete(kh);
    }

    @Override
    public KhachHang getObjByMa(String ma) {
        return iKhachHangRepository.getObjByMa(ma);
    }

}
