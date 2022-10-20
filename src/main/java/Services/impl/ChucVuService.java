package Services.impl;

import DomainModels.ChucVu;
import Repositories.IChucVuRepository;
import Repositories.impl.ChucVuRepository;
import Services.IChucVuService;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class ChucVuService implements IChucVuService {
    
    private IChucVuRepository iChucVuRepository;
    
    public ChucVuService() {
        iChucVuRepository = new ChucVuRepository();
    }
    
    @Override
    public List<ChucVu> getAll() {
        return iChucVuRepository.getAll();
    }
    
    @Override
    public String save(ChucVu cv) {
        return iChucVuRepository.save(cv);
    }
    
    @Override
    public String delete(ChucVu cv) {
        return iChucVuRepository.delete(cv);
    }
    
    @Override
    public ChucVu getObjByMa(String ma) {
        return iChucVuRepository.getObjByMa(ma);
    }
    
}
