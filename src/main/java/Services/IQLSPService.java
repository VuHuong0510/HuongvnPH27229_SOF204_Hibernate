package Services;

import ViewModels.QLSP;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLSPService {

    List<QLSP> getAll();

    String add(QLSP obj);

    String update(QLSP obj);

    String delete(QLSP obj);

    QLSP getObjByMa(String ma);

    List<QLSP> findByName(String ten);
}
