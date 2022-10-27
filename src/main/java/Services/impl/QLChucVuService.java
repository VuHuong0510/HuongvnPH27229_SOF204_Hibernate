package Services.impl;

import DomainModels.ChucVu;
import Repositories.IChucVuRepository;
import Repositories.impl.ChucVuRepository;
import Services.IQLChucVuService;
import ViewModels.QLChucVu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class QLChucVuService implements IQLChucVuService {

    private IChucVuRepository iChucVuRepository;
    private List<QLChucVu> listCV;

    public QLChucVuService() {
        iChucVuRepository = new ChucVuRepository();
        listCV = new ArrayList<>();
    }

    @Override
    public List<QLChucVu> getAll() {
        listCV = new ArrayList<>();
        var chucVu = iChucVuRepository.getAll();
        for (ChucVu x : chucVu) {
            listCV.add(new QLChucVu(x.getId(), x.getMa(), x.getTen()));
        }
        return listCV;
    }

    @Override
    public String add(QLChucVu qlcv) {
        ChucVu cv = new ChucVu();
        cv.setMa(qlcv.getMa());
        cv.setTen(qlcv.getTen());
        return iChucVuRepository.save(cv);
    }

    @Override
    public String update(QLChucVu qlcv) {
        ChucVu cv = iChucVuRepository.getObjByMa(qlcv.getMa());
        cv.setTen(qlcv.getTen());
        return iChucVuRepository.save(cv);
    }

    @Override
    public String delete(QLChucVu qlcv) {
        ChucVu cv = iChucVuRepository.getObjByMa(qlcv.getMa());
        return iChucVuRepository.delete(cv);
    }

    @Override
    public List<QLChucVu> findByName(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QLChucVu getObjByMa(String ma) {
        ChucVu cv = iChucVuRepository.getObjByMa(ma);
        if (cv == null) {
            return null;
        } else {
            return new QLChucVu(cv.getId(), cv.getMa(), cv.getTen());
        }
    }

}
