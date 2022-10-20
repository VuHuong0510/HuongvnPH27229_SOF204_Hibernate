package Services.impl;

import DomainModels.NhanVien;
import Repositories.INhanVienRepository;
import Repositories.impl.NhanVienRepository;
import Services.INhanVienService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class NhanVienService implements INhanVienService {

    private INhanVienRepository iNhanVienRepository;

    public NhanVienService() {
        iNhanVienRepository = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getAll() {
        return iNhanVienRepository.getAll();
    }

    @Override
    public String save(NhanVien nv) {
        return iNhanVienRepository.save(nv);
    }

    @Override
    public String delete(NhanVien nv) {
        return iNhanVienRepository.delete(nv);
    }

    @Override
    public NhanVien getObjByMa(String ma) {
        return iNhanVienRepository.getObjByMa(ma);
    }

}
