package Services;

import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface IQLDongSPService {
    List<QLDongSP> getAll();

    String add(QLDongSP obj);

    String update(QLDongSP obj);

    String delete(QLDongSP obj);

    QLDongSP getObjByMa(String ma);

    List<QLDongSP> findByName(String ten);
}
