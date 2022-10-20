package Services;

import ViewModels.QLNsx;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLNsxService {
    List<QLNsx> getAll();

    String add(QLNsx qLNsx);

    String update(QLNsx qLNsx);

    String delete(QLNsx qLNsx);

    QLNsx getObjByMa(String ma);

    List<QLNsx> findByName(String ten);
}
