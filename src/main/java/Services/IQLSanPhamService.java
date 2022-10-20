package Services;

import ViewModels.SanPhamView;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLSanPhamService {

    List<SanPhamView> getAll();

    String save(SanPhamView spv);

    String delete(SanPhamView spv);
    
    List<SanPhamView> findByName(String ten);
    
    SanPhamView getObjById(UUID id);
}
