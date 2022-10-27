package Services.impl;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Repositories.impl.KhachHangRepository;
import Services.IQLKhachHangService;
import ViewModels.QLKhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class QLKhachHangService implements IQLKhachHangService {

    private IKhachHangRepository iKhachHangRepository;
    private List<QLKhachHang> list;

    public QLKhachHangService() {
        iKhachHangRepository = new KhachHangRepository();
        list = new ArrayList<>();
    }

    @Override
    public List<QLKhachHang> getAll() {
        list = new ArrayList<>();
        for (KhachHang x : iKhachHangRepository.getAll()) {
            list.add(new QLKhachHang(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getNgaySinh(), x.getSdt(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia(), x.getMatKhau()));
        }
        return list;
    }

    @Override
    public String add(QLKhachHang obj) {
        KhachHang kh = new KhachHang();
        kh.setMa(obj.getMa());
        kh.setTen(obj.getTen());
        kh.setTenDem(obj.getTenDem());
        kh.setHo(obj.getHo());
        kh.setNgaySinh(obj.getNgaySinh());
        kh.setSdt(obj.getSdt());
        kh.setDiaChi(obj.getDiaChi());
        kh.setThanhPho(obj.getThanhPho());
        kh.setQuocGia(obj.getQuocGia());
        kh.setMatKhau(obj.getMatKhau());
        return iKhachHangRepository.save(kh);
    }

    @Override
    public String update(QLKhachHang obj) {
        KhachHang kh = iKhachHangRepository.getObjByMa(obj.getMa());
        kh.setTen(obj.getTen());
        kh.setTenDem(obj.getTenDem());
        kh.setHo(obj.getHo());
        kh.setNgaySinh(obj.getNgaySinh());
        kh.setSdt(obj.getSdt());
        kh.setDiaChi(obj.getDiaChi());
        kh.setThanhPho(obj.getThanhPho());
        kh.setQuocGia(obj.getQuocGia());
        kh.setMatKhau(obj.getMatKhau());
        return iKhachHangRepository.save(kh);
    }

    @Override
    public String delete(QLKhachHang obj) {
        KhachHang kh = iKhachHangRepository.getObjByMa(obj.getMa());
        return iKhachHangRepository.delete(kh);
    }

    @Override
    public QLKhachHang getObjByMa(String ma) {
        KhachHang kh = iKhachHangRepository.getObjByMa(ma);
        if (kh == null) {
            return null;
        } else {
            return new QLKhachHang(kh.getId(), kh.getMa(), kh.getTen(), kh.getTenDem(), kh.getHo(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(), kh.getThanhPho(), kh.getQuocGia(), kh.getMatKhau());
        }
    }

    @Override
    public List<QLKhachHang> findByName(String ten) {
        list = new ArrayList<>();
        for (KhachHang x : iKhachHangRepository.findByName(ten)) {
            list.add(new QLKhachHang(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getNgaySinh(), x.getSdt(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia(), x.getMatKhau()));
        }
        return list;
    }

}
