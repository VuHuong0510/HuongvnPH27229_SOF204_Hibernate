package Services.impl;

import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Repositories.impl.SanPhamRepository;
import Services.ISanPhamService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class SanPhamService implements ISanPhamService {

    private ISanPhamRepository iSanPhamRepository;

    public SanPhamService() {
        iSanPhamRepository = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getAll() {
        return iSanPhamRepository.getAll();
    }

    @Override
    public String save(SanPham sp) {
        return iSanPhamRepository.save(sp);
    }

    @Override
    public String delete(SanPham sp) {
        return iSanPhamRepository.delete(sp);
    }

    @Override
    public SanPham getObjByMa(String ma) {
        return iSanPhamRepository.getObjByMa(ma);
    }

}
