package Repositories;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public interface INsxRepository {

    List<NSX> getAll();

    String save(NSX nsx);

    String delete(NSX nsx);

    NSX getObjByMa(String ma);
}
