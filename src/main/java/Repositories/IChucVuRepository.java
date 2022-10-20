package Repositories;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IChucVuRepository {

    List<ChucVu> getAll();

    String save(ChucVu cv);

    String delete(ChucVu cv);

    ChucVu getObjByMa(String ma);
    
    List<ChucVu> findByName(String ten);
}
