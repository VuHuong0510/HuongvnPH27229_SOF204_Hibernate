package Services;

import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLMauSacService {

    List<QLMauSac> getAll();

    String add(QLMauSac qlms);

    String update(QLMauSac qlms);

    String delete(QLMauSac qlms);

    QLMauSac getObjByMa(String ma);

    List<QLMauSac> findByName(String ten);
}
