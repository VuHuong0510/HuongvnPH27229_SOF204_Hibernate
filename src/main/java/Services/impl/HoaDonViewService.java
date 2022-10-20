package Services.impl;

import DomainModels.HoaDonChiTiet;
import Repositories.IChiTietSPRepository;
import Repositories.IHoaDonChiTietRepository;
import Repositories.IHoaDonRepository;
import Repositories.impl.ChiTietSPRepository;
import Repositories.impl.HoaDonChiTietRepository;
import Repositories.impl.HoaDonRepository;
import Services.IHoaDonViewService;
import ViewModels.QLHoaDonCT;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class HoaDonViewService implements IHoaDonViewService {

    private IHoaDonChiTietRepository iHoaDonChiTietRepository;
    private IChiTietSPRepository iChiTietSPRepository;
    private IHoaDonRepository iHoaDonRepository;

    public HoaDonViewService() {
        iHoaDonChiTietRepository = new HoaDonChiTietRepository();
        iChiTietSPRepository = new ChiTietSPRepository();
        iHoaDonRepository = new HoaDonRepository();
    }

    @Override
    public List<QLHoaDonCT> getAll() {
        List<QLHoaDonCT> list = new ArrayList<>();
        var hdct = iHoaDonChiTietRepository.getAll();
        for (HoaDonChiTiet x : hdct) {
            list.add(new QLHoaDonCT(x.getHoaDon().getId(), x.getChiTietSP().getId(), x.getChiTietSP().getSoLuongTon(), x.getChiTietSP().getGiaBan()));
        }
        return list;
    }

    @Override
    public String add(QLHoaDonCT hdv) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setHoaDon(iHoaDonRepository.getObjById(hdv.getIdHoaDon()));
        hdct.setChiTietSP(iChiTietSPRepository.getObjById(hdv.getIdChiTietSP()));
        hdct.setSoLuong(hdv.getSoLuong());
        hdct.setDonGia(hdv.getDonGia());
        iHoaDonChiTietRepository.save(hdct);

        return "Save";
    }

}
