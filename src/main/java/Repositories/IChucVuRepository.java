package Repositories;

import DomainModels.ChucVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IChucVuRepository {

    List<ChucVu> getAll();

    String save(ChucVu cv);

    String delete(ChucVu cv);

    ChucVu getObjByMa(String ma);

    ChucVu getObjById(UUID id);

    List<ChucVu> findByName(String ten);
}
