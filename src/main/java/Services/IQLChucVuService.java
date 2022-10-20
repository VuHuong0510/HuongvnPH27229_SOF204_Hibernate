package Services;

import ViewModels.QLChucVu;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLChucVuService {

    List<QLChucVu> getAll();

    String add(QLChucVu qlcv);

    String update(QLChucVu qlcv);

    String delete(QLChucVu qlcv);

    QLChucVu getObjByMa(String ma);

    List<QLChucVu> findByName(String ten);
}
