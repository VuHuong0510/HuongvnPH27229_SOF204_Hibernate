package Views;

import DomainModels.*;
import Services.*;
import Services.impl.*;
import Utilities.Helper;
import ViewModels.QLChucVu;
import ViewModels.QLSP;
import ViewModels.SanPhamView;
import java.awt.CardLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class FrmDetails1 extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private int flag_qlsp_sp = 0;

    private DefaultTableModel defaultTableModel;
    private Helper helper;

    private IQLSanPhamService iQLSanPhamService;

    private DefaultComboBoxModel<CuaHang> comBoCuaHang;
    private DefaultComboBoxModel<QLChucVu> comBoChucVu;
    private DefaultComboBoxModel<QLSP> comboSanPham;
    private DefaultComboBoxModel<NSX> comboNSX;
    private DefaultComboBoxModel<MauSac> comboMauSac;
    private DefaultComboBoxModel<DongSP> comboDongSP;

    private IQLSPService iQLSPService;
    private IDongSPService iDongSPService;
    private IMauSacService iMauSacService;
    private INsxService iNsxService;

    private IKhachHangService iKhachHangService;
    private ICuaHangService iCuaHangService;
    private IQLChucVuService iQLChucVuService;
    private INhanVienService iNhanVienService;

    public FrmDetails1() {
        initComponents();
        iQLSanPhamService = new QLSanPhamService();
        iQLSPService = new QLSPService();
        iDongSPService = new DongSPService();
        iMauSacService = new MauSacService();
        iNsxService = new NsxService();

        iKhachHangService = new KhachHangService();
        iCuaHangService = new CuaHangService();
        iQLChucVuService = new QLChucVuService();
        iNhanVienService = new NhanVienService();
        helper = new Helper();

        comBoChucVu = new DefaultComboBoxModel<>();
        comBoCuaHang = new DefaultComboBoxModel<>();
        comboSanPham = new DefaultComboBoxModel<>();
        comboNSX = new DefaultComboBoxModel<>();
        comboMauSac = new DefaultComboBoxModel<>();
        comboDongSP = new DefaultComboBoxModel<>();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        cardLayout = (CardLayout) pn_main.getLayout();
        cardLayout.show(pn_main, "hello");
        loadData();
    }

    // QUẢN LÝ SẢN PHẨM
    // loadData 4 table SanPham,MauSac,DongSP,NSX
    private void load_QLSP() {
        if (flag_qlsp_sp == 0) {
            load_QLSP_SP(iQLSPService.getAll());
        } else if (flag_qlsp_sp == 1) {
            load_QLSP_DongSP(iDongSPService.getAll());
        } else if (flag_qlsp_sp == 2) {
            load_QLSP_MS(iMauSacService.getAll());
        } else if (flag_qlsp_sp == 3) {
            load_QLSP_NSX(iNsxService.getAll());
        }
        getSelectionInterval(0);
    }

    private void load_QLSP_SP(List<QLSP> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlsp_ttsp.getModel();
        defaultTableModel.setRowCount(0);
        for (QLSP x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen()
            });
        }
    }

    private void load_QLSP_MS(List<MauSac> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlsp_ttsp.getModel();
        defaultTableModel.setRowCount(0);
        for (MauSac x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen()
            });
        }
    }

    private void load_QLSP_DongSP(List<DongSP> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlsp_ttsp.getModel();
        defaultTableModel.setRowCount(0);
        for (DongSP x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen()
            });
        }
    }

    private void load_QLSP_NSX(List<NSX> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlsp_ttsp.getModel();
        defaultTableModel.setRowCount(0);
        for (NSX x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen()
            });
        }
    }

    private void load_CTSP() {
        defaultTableModel = (DefaultTableModel) tb_qlsp_ctsp.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamView x : iQLSanPhamService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                x.getSanPham().getMa(), x.getSanPham().getTen(), x.getChiTietSP().getNamBH(), x.getChiTietSP().getMoTa(), x.getChiTietSP().getSoLuongTon(), x.getChiTietSP().getGiaNhap(), x.getChiTietSP().getGiaBan()
            });
        }
    }

    // QUẢN LÝ CỬA HÀNG
    // loadData table CuaHang
    private void load_QLCH_CH() {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlch_cuahang.getModel();
        defaultTableModel.setRowCount(0);
        for (CuaHang x : iCuaHangService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia()
            });
        }
    }

    // loadData table KhachHang
    private void load_QLCH_KH() {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlch_khachhang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang x : iKhachHangService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getHo() + " " + x.getTenDem() + " " + x.getTen(), x.getDiaChi(), x.getSdt()
            });
        }
    }

    // QUẢN LÝ NHÂN VIÊN
    // loadData table NhanVien
    private void load_QLNV_NV() {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlnv_nhanvien.getModel();
        defaultTableModel.setRowCount(0);
        for (NhanVien x : iNhanVienService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen(), x.getDiaChi(), x.getSdt(), x.getCuaHang().getTen(), x.getChucVu().getTen()
            });
        }
    }

    // loadData table ChucVu
    private void load_QLNV_CV() {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_qlnv_chucvu.getModel();
        defaultTableModel.setRowCount(0);
        for (QLChucVu x : iQLChucVuService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getTen()
            });
        }
    }

    // ADD COMBO BOX //
    // addComboBox ChucVu to QLNV
    private void addCbChucVu() {
        cb_nv_chucvu.setModel((DefaultComboBoxModel) comBoChucVu);
        cb_nv_chucvu.removeAllItems();
        for (QLChucVu x : iQLChucVuService.getAll()) {
            comBoChucVu.addElement(x);
        }
    }

    // addComboBox CuaHang to QLNV
    private void addCbCuaHang() {
        cb_nv_cuahang.setModel((DefaultComboBoxModel) comBoCuaHang);
        cb_nv_cuahang.removeAllItems();
        for (CuaHang x : iCuaHangService.getAll()) {
            comBoCuaHang.addElement(x);
        }
    }

    // addComboBox SanPham to QLSP
    private void addCbSanPham() {
        cb_ctsp_sp.setModel((DefaultComboBoxModel) comboSanPham);
        cb_ctsp_sp.removeAllItems();
        for (QLSP x : iQLSPService.getAll()) {
            comboSanPham.addElement(x);
        }
    }

    // addComboBox NSX to QLSP
    private void addCbNSX() {
        cb_ctsp_nsx.setModel((DefaultComboBoxModel) comboNSX);
        cb_ctsp_nsx.removeAllItems();
        for (NSX x : iNsxService.getAll()) {
            comboNSX.addElement(x);
        }
    }

    // addComboBox MauSac to QLSP
    private void addCbMauSac() {
        cb_ctsp_mausac.setModel((DefaultComboBoxModel) comboMauSac);
        cb_ctsp_mausac.removeAllItems();
        for (MauSac x : iMauSacService.getAll()) {
            comboMauSac.addElement(x);
        }
    }

    // addComboBox DongSP to QLSP
    private void addCbDongSP() {
        cb_ctsp_dongsp.setModel((DefaultComboBoxModel) comboDongSP);
        cb_ctsp_dongsp.removeAllItems();
        for (DongSP x : iDongSPService.getAll()) {
            comboDongSP.addElement(x);
        }
    }

    private void loadData() {
        load_QLCH_CH();
        load_QLCH_KH();
        load_QLNV_CV();
        load_QLNV_NV();
        load_QLSP();
        load_CTSP();
        addCbChucVu();
        addCbCuaHang();
        addCbSanPham();
        addCbNSX();
        addCbMauSac();
        addCbDongSP();
    }

    // CRUD SanPham,DongSP,MauSac,NSX
    private boolean checkNullSP() {
        if (helper.checkNull(txt_ttsp_ma, "Mã")
                || helper.checkNull(txt_ttsp_ten, "Tên")
                || helper.checkRegex(txt_ttsp_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")
                || helper.checkRegex(txt_ttsp_ma, "^\\w[a-zA-Z@#0-9.]*$", "Mã không chứa dấu cách!")) {
            return true;
        } else {
            return false;
        }
    }

    private void addSP() {
        QLSP sp = new QLSP();
        if (checkNullSP()) {
            return;
        }
        if (iQLSPService.getObjByMa(txt_ttsp_ma.getText()) == null) {
            sp.setMa(txt_ttsp_ma.getText());
            sp.setTen(txt_ttsp_ten.getText());
            iQLSPService.add(sp);
            loadData();
            helper.alert(this, "Thêm thành công!");
        } else {
            helper.error(this, "Mã sản phẩm đã tồn tại!");
        }
    }

    private void updateSP() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            QLSP sp = iQLSPService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (checkNullSP()) {
                return;
            }
            sp.setTen(txt_ttsp_ten.getText());
            iQLSPService.update(sp);
            loadData();
            tb_qlsp_ttsp.setRowSelectionInterval(row, row);
            showDetailQLSP();
            helper.alert(this, "Cập nhật thành công!");
        }
    }

    private void deleteSP() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            QLSP sp = iQLSPService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                if (iQLSPService.delete(sp).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    helper.alert(this, "Xóa thành công!");
                }

            }
        }
    }

    private void addNSX() {
        NSX nsx = new NSX();
        if (checkNullSP()) {
            return;
        }
        if (iNsxService.getObjByMa(txt_ttsp_ma.getText()) == null) {
            nsx.setMa(txt_ttsp_ma.getText());
            nsx.setTen(txt_ttsp_ten.getText());
            iNsxService.save(nsx);
            loadData();
            helper.alert(this, "Thêm thành công!");
        } else {
            helper.error(this, "Mã NSX đã tồn tại!");
        }
    }

    private void updateNSX() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            if (checkNullSP()) {
                return;
            }
            NSX nsx = iNsxService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            nsx.setTen(txt_ttsp_ten.getText());
            iNsxService.save(nsx);
            loadData();
            tb_qlsp_ttsp.setRowSelectionInterval(row, row);
            showDetailQLSP();
            helper.alert(this, "Cập nhật thành công!");
        }
    }

    private void deleteNSX() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            NSX nsx = iNsxService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                if (iNsxService.delete(nsx).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    helper.alert(this, "Xóa thành công!");
                }
            }
        }
    }

    private void addDongSP() {
        DongSP dsp = new DongSP();
        if (checkNullSP()) {
            return;
        }
        if (iDongSPService.getObjByMa(txt_ttsp_ma.getText()) == null) {
            dsp.setMa(txt_ttsp_ma.getText());
            dsp.setTen(txt_ttsp_ten.getText());
            iDongSPService.save(dsp);
            loadData();
            helper.alert(this, "Thêm thành công!");
        } else {
            helper.error(this, "Mã dòng SP đã tồn tại!");
        }
    }

    private void updateDongSP() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            if (checkNullSP()) {
                return;
            }
            DongSP dsp = iDongSPService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            dsp.setTen(txt_ttsp_ten.getText());
            iDongSPService.save(dsp);
            loadData();
            tb_qlsp_ttsp.setRowSelectionInterval(row, row);
            showDetailQLSP();
            helper.alert(this, "Cập nhật thành công!");
        }
    }

    private void deleteDongSP() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            DongSP dsp = iDongSPService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                if (iDongSPService.delete(dsp).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    helper.alert(this, "Xóa thành công!");
                }
            }
        }
    }

    private void addMauSac() {
        MauSac ms = new MauSac();
        if (checkNullSP()) {
            return;
        }
        if (iMauSacService.getObjByMa(txt_ttsp_ma.getText()) == null) {
            ms.setMa(txt_ttsp_ma.getText());
            ms.setTen(txt_ttsp_ten.getText());
            iMauSacService.save(ms);
            loadData();
            helper.alert(this, "Thêm thành công!");
        } else {
            helper.error(this, "Mã màu sắc đã tồn tại!");
        }
    }

    private void updateMauSac() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            MauSac ms = iMauSacService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (checkNullSP()) {
                return;
            }
            ms.setTen(txt_ttsp_ten.getText());
            iMauSacService.save(ms);
            loadData();
            tb_qlsp_ttsp.setRowSelectionInterval(row, row);
            showDetailQLSP();
            helper.alert(this, "Cập nhật thành công!");
        }
    }

    private void deleteMauSac() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            MauSac ms = iMauSacService.getObjByMa((String) tb_qlsp_ttsp.getValueAt(row, 1));
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                if (iMauSacService.delete(ms).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    helper.alert(this, "Xóa thành công!");
                }
            }
        }
    }

    private void saveCTSP(SanPhamView spv, ChiTietSP ctsp, String message) {
        SanPham sp = (SanPham) comboSanPham.getSelectedItem();
        DongSP dsp = (DongSP) comboDongSP.getSelectedItem();
        MauSac ms = (MauSac) comboMauSac.getSelectedItem();
        NSX nsx = (NSX) comboNSX.getSelectedItem();
        if (helper.checkNull(txt_ctsp_nambh, "Năm BH")
                || helper.checkNull(txt_ctsp_gianhap, "Giá nhập")
                || helper.checkNull(txt_ctsp_giaban, "Giá bán")
                || helper.checkNull(txt_ctsp_mota, "Mô tả")
                || helper.convertToDecimal(txt_ctsp_gianhap, "Giá nhập không hợp lệ") == null
                || helper.convertToDecimal(txt_ctsp_giaban, "Giá bán không hợp lệ") == null) {
            return;
        }
        ctsp.setSanPham(sp);
        ctsp.setNsx(nsx);
        ctsp.setMauSac(ms);
        ctsp.setDongSP(dsp);
        ctsp.setNamBH(Integer.parseInt(txt_ctsp_nambh.getText()));
        ctsp.setSoLuongTon((int) sp_ctsp_slton.getValue());
        ctsp.setGiaNhap(helper.convertToDecimal(txt_ctsp_gianhap, "Giá nhập không hợp lệ"));
        ctsp.setGiaBan(helper.convertToDecimal(txt_ctsp_giaban, "Giá nhập không hợp lệ"));
        ctsp.setMoTa(txt_ctsp_mota.getText());

        spv.setChiTietSP(ctsp);
        iQLSanPhamService.save(spv);
        loadData();
        helper.alert(this, message);
    }

    private void getSelectionInterval(int index) {
        if (tb_qlsp_ttsp.getRowCount() > 0) {
            tb_qlsp_ttsp.setRowSelectionInterval(index, index);
            showDetailQLSP();
        }
    }

    private void showDetailQLSP() {
        int row = tb_qlsp_ttsp.getSelectedRow();
        txt_ttsp_ma.setText((String) tb_qlsp_ttsp.getValueAt(row, 1));
        txt_ttsp_ten.setText((String) tb_qlsp_ttsp.getValueAt(row, 2));
    }

    private void showDetailCTSP() {
        int row = tb_qlsp_ctsp.getSelectedRow();
        SanPhamView spv = iQLSanPhamService.getAll().get(row);
        ChiTietSP ctsp = spv.getChiTietSP();
        comboSanPham.setSelectedItem(ctsp.getSanPham());
        comboDongSP.setSelectedItem(ctsp.getDongSP());
        comboNSX.setSelectedItem(ctsp.getNsx());
        comboMauSac.setSelectedItem(ctsp.getMauSac());
        txt_ctsp_nambh.setText(ctsp.getNamBH() + "");
        sp_ctsp_slton.setValue(ctsp.getSoLuongTon());
        txt_ctsp_giaban.setText(ctsp.getGiaBan() + "");
        txt_ctsp_gianhap.setText(ctsp.getGiaNhap() + "");
        txt_ctsp_mota.setText(ctsp.getMoTa());
    }

    private void showDetailNhanVien() {
        int row = tb_qlnv_nhanvien.getSelectedRow();
        NhanVien nv = iNhanVienService.getObjByMa((String) tb_qlnv_nhanvien.getValueAt(row, 1));
        txt_nv_ma.setText(nv.getMa());
        txt_nv_ten.setText(nv.getTen());
        if (nv.getGioiTinh().equals("Nam")) {
            rd_nv_nam.setSelected(true);
        } else {
            rd_nv_nu.setSelected(true);
        }
        txt_nv_sodt.setText(nv.getSdt());
        txt_nv_diachi.setText(nv.getDiaChi());
        comBoChucVu.setSelectedItem(nv.getChucVu());
        comBoCuaHang.setSelectedItem(nv.getCuaHang());
    }

    private void showDetailChucVu() {
        int row = tb_qlnv_chucvu.getSelectedRow();
        txt_cv_ma.setText((String) tb_qlnv_chucvu.getValueAt(row, 1));
        txt_cv_ten.setText((String) tb_qlnv_chucvu.getValueAt(row, 2));
    }

    private void effectNav(JPanel pn_goc, JPanel pn1, JPanel pn2, JPanel pn3, JPanel pn4, String title) {
        pn_goc.setBackground(Color.lightGray);
        pn1.setBackground(Color.GRAY);
        pn2.setBackground(Color.GRAY);
        pn3.setBackground(Color.GRAY);
        pn4.setBackground(Color.GRAY);
        setTitle(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        qlch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        qlnv = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sp = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        gh = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        hd = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        pn_logout = new javax.swing.JPanel();
        lbl_logout = new javax.swing.JLabel();
        pn_main = new javax.swing.JPanel();
        pn_hello = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        pn_qlch = new javax.swing.JPanel();
        qlch_kh = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_qlch_khachhang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cb_kh_tp = new javax.swing.JComboBox<>();
        txt_kh_quocgia = new javax.swing.JTextField();
        txt_kh_diachi = new javax.swing.JTextField();
        txt_kh_ma = new javax.swing.JTextField();
        txt_kh_ten = new javax.swing.JTextField();
        txt_kh_tendem = new javax.swing.JTextField();
        txt_kh_ho = new javax.swing.JTextField();
        txt_kh_ngaysinh = new javax.swing.JTextField();
        txt_kh_sdt = new javax.swing.JTextField();
        btn_kh_them = new javax.swing.JButton();
        btn_kh_clear = new javax.swing.JButton();
        btn_kh_capnhat = new javax.swing.JButton();
        btn_kh_xoa = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        txt_kh_matkhau = new javax.swing.JTextField();
        qlch_ch = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_qlch_cuahang = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_ch_ma = new javax.swing.JTextField();
        txt_ch_ten = new javax.swing.JTextField();
        txt_ch_diachi = new javax.swing.JTextField();
        cb_ch_thanhpho = new javax.swing.JComboBox<>();
        txt_ch_quocgia = new javax.swing.JTextField();
        btn_ch_xoa = new javax.swing.JButton();
        btn_ch_them = new javax.swing.JButton();
        btn_ch_timkiem = new javax.swing.JButton();
        btn_ch_capnhat = new javax.swing.JButton();
        pn_qlnv = new javax.swing.JPanel();
        qlnv_nv = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_qlnv_nhanvien = new javax.swing.JTable();
        txt_nv_ma = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_nv_ten = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_nv_diachi = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_nv_sodt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cb_nv_cuahang = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cb_nv_chucvu = new javax.swing.JComboBox<>();
        btn_nv_them = new javax.swing.JButton();
        btn_nv_clear = new javax.swing.JButton();
        btn_nv_capnhat = new javax.swing.JButton();
        btn_nv_xoa = new javax.swing.JButton();
        rd_nv_nam = new javax.swing.JRadioButton();
        rd_nv_nu = new javax.swing.JRadioButton();
        qlnv_cv = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_qlnv_chucvu = new javax.swing.JTable();
        txt_cv_ten = new javax.swing.JTextField();
        txt_cv_ma = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btn_cv_xoa = new javax.swing.JButton();
        btn_cv_clear = new javax.swing.JButton();
        btn_cv_them = new javax.swing.JButton();
        btn_cv_capnhat = new javax.swing.JButton();
        pn_qlsp = new javax.swing.JPanel();
        qlsp_sp = new javax.swing.JPanel();
        lbl_title_gener = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_qlsp_ttsp = new javax.swing.JTable();
        cb_gener = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_ttsp_ma = new javax.swing.JTextField();
        txt_ttsp_ten = new javax.swing.JTextField();
        btn_ttsp_xoa = new javax.swing.JButton();
        btn_ttsp_clear = new javax.swing.JButton();
        btn_ttsp_capnhat = new javax.swing.JButton();
        btn_ttsp_them = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        qlsp_ctsp = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_qlsp_ctsp = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cb_ctsp_sp = new javax.swing.JComboBox<>();
        cb_ctsp_nsx = new javax.swing.JComboBox<>();
        cb_ctsp_mausac = new javax.swing.JComboBox<>();
        cb_ctsp_dongsp = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_ctsp_nambh = new javax.swing.JTextField();
        txt_ctsp_gianhap = new javax.swing.JTextField();
        txt_ctsp_giaban = new javax.swing.JTextField();
        btn_ctsp_them = new javax.swing.JButton();
        btn_ctsp_clear = new javax.swing.JButton();
        btn_ctsp_capnhat = new javax.swing.JButton();
        btn_ctsp_xoa = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        txt_ctsp_mota = new javax.swing.JTextField();
        sp_ctsp_slton = new javax.swing.JSpinner();
        pn_giohang = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pn_hoadon = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(128, 128, 128));

        qlch.setBackground(new java.awt.Color(128, 128, 128));
        qlch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qlchMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý cửa hàng");

        javax.swing.GroupLayout qlchLayout = new javax.swing.GroupLayout(qlch);
        qlch.setLayout(qlchLayout);
        qlchLayout.setHorizontalGroup(
            qlchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        qlchLayout.setVerticalGroup(
            qlchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        qlnv.setBackground(new java.awt.Color(128, 128, 128));
        qlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qlnvMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý nhân viên");

        javax.swing.GroupLayout qlnvLayout = new javax.swing.GroupLayout(qlnv);
        qlnv.setLayout(qlnvLayout);
        qlnvLayout.setHorizontalGroup(
            qlnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        qlnvLayout.setVerticalGroup(
            qlnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sp.setBackground(new java.awt.Color(128, 128, 128));
        sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout spLayout = new javax.swing.GroupLayout(sp);
        sp.setLayout(spLayout);
        spLayout.setHorizontalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        spLayout.setVerticalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gh.setBackground(new java.awt.Color(128, 128, 128));
        gh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ghMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giỏ hàng");

        javax.swing.GroupLayout ghLayout = new javax.swing.GroupLayout(gh);
        gh.setLayout(ghLayout);
        ghLayout.setHorizontalGroup(
            ghLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ghLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        ghLayout.setVerticalGroup(
            ghLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ghLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        hd.setBackground(new java.awt.Color(128, 128, 128));
        hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hdMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("About me");

        javax.swing.GroupLayout hdLayout = new javax.swing.GroupLayout(hd);
        hd.setLayout(hdLayout);
        hdLayout.setHorizontalGroup(
            hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        hdLayout.setVerticalGroup(
            hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(128, 128, 128));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome PolyShop!");

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("image");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_logout.setBackground(new java.awt.Color(102, 102, 102));
        pn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_logoutMouseClicked(evt);
            }
        });

        lbl_logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logout.setText("Đăng xuất");

        javax.swing.GroupLayout pn_logoutLayout = new javax.swing.GroupLayout(pn_logout);
        pn_logout.setLayout(pn_logoutLayout);
        pn_logoutLayout.setHorizontalGroup(
            pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_logoutLayout.setVerticalGroup(
            pn_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_logoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(qlnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qlch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gh, qlch, qlnv, sp});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qlch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qlnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gh, qlch, qlnv, sp});

        pn_main.setLayout(new java.awt.CardLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Hi!");

        javax.swing.GroupLayout pn_helloLayout = new javax.swing.GroupLayout(pn_hello);
        pn_hello.setLayout(pn_helloLayout);
        pn_helloLayout.setHorizontalGroup(
            pn_helloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_helloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_helloLayout.setVerticalGroup(
            pn_helloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_helloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_main.add(pn_hello, "hello");

        pn_qlch.setLayout(new java.awt.GridLayout(1, 1, 2, 0));

        qlch_kh.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));

        tb_qlch_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Địa chỉ", "Số điện thoại"
            }
        ));
        tb_qlch_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlch_khachhangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_qlch_khachhang);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("KHÁCH HÀNG");

        jLabel16.setText("Mã");

        jLabel17.setText("Tên");

        jLabel18.setText("Tên đệm");

        jLabel19.setText("Họ");

        jLabel20.setText("Ngày sinh");

        jLabel21.setText("SDT");

        jLabel22.setText("Địa chỉ");

        jLabel23.setText("Thành phố");

        jLabel24.setText("Quốc gia");

        cb_kh_tp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));

        txt_kh_quocgia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_diachi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_ma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_tendem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_ho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_ngaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_kh_sdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_kh_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_kh_them.setText("Thêm");
        btn_kh_them.setBorderPainted(false);
        btn_kh_them.setFocusPainted(false);
        btn_kh_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kh_themActionPerformed(evt);
            }
        });

        btn_kh_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_kh_clear.setText("Clear");
        btn_kh_clear.setBorderPainted(false);
        btn_kh_clear.setFocusPainted(false);
        btn_kh_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kh_clearActionPerformed(evt);
            }
        });

        btn_kh_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_kh_capnhat.setText("Cập nhật");
        btn_kh_capnhat.setBorderPainted(false);
        btn_kh_capnhat.setFocusPainted(false);
        btn_kh_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kh_capnhatActionPerformed(evt);
            }
        });

        btn_kh_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_kh_xoa.setText("Xóa");
        btn_kh_xoa.setBorderPainted(false);
        btn_kh_xoa.setFocusPainted(false);
        btn_kh_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kh_xoaActionPerformed(evt);
            }
        });

        jLabel49.setText("Mật khẩu");

        txt_kh_matkhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout qlch_khLayout = new javax.swing.GroupLayout(qlch_kh);
        qlch_kh.setLayout(qlch_khLayout);
        qlch_khLayout.setHorizontalGroup(
            qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlch_khLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(qlch_khLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txt_kh_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kh_them))
                    .addGroup(qlch_khLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txt_kh_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kh_clear))
                    .addGroup(qlch_khLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txt_kh_tendem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kh_capnhat))
                    .addGroup(qlch_khLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txt_kh_ho, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kh_xoa))
                    .addGroup(qlch_khLayout.createSequentialGroup()
                        .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlch_khLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txt_kh_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlch_khLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(txt_kh_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlch_khLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(txt_kh_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlch_khLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(cb_kh_tp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(qlch_khLayout.createSequentialGroup()
                                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel49))
                                .addGap(18, 18, 18)
                                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_kh_quocgia, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txt_kh_matkhau))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        qlch_khLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24});

        qlch_khLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_kh_tp, txt_kh_diachi, txt_kh_ho, txt_kh_ma, txt_kh_ngaysinh, txt_kh_quocgia, txt_kh_sdt, txt_kh_ten, txt_kh_tendem});

        qlch_khLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_kh_capnhat, btn_kh_clear, btn_kh_them, btn_kh_xoa});

        qlch_khLayout.setVerticalGroup(
            qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlch_khLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_kh_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kh_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_kh_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kh_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_kh_tendem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kh_capnhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_kh_ho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kh_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_kh_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_kh_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_kh_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cb_kh_tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_kh_quocgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txt_kh_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        qlch_khLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_kh_capnhat, btn_kh_clear, btn_kh_them, btn_kh_xoa, cb_kh_tp, txt_kh_diachi, txt_kh_ho, txt_kh_ma, txt_kh_matkhau, txt_kh_ngaysinh, txt_kh_quocgia, txt_kh_sdt, txt_kh_ten, txt_kh_tendem});

        pn_qlch.add(qlch_kh);

        qlch_ch.setBorder(javax.swing.BorderFactory.createTitledBorder("Cừa hàng"));

        tb_qlch_cuahang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Địa chỉ", "Thành phố"
            }
        ));
        tb_qlch_cuahang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlch_cuahangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_qlch_cuahang);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CỬA HÀNG");

        jLabel7.setText("Mã");

        jLabel10.setText("Tên");

        jLabel11.setText("Địa chỉ");

        jLabel13.setText("Thành phố");

        jLabel15.setText("Quốc gia");

        txt_ch_ma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_ch_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_ch_diachi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        cb_ch_thanhpho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));

        txt_ch_quocgia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_ch_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_ch_xoa.setText("Xóa");
        btn_ch_xoa.setBorderPainted(false);
        btn_ch_xoa.setFocusPainted(false);
        btn_ch_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ch_xoaActionPerformed(evt);
            }
        });

        btn_ch_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_ch_them.setText("Thêm");
        btn_ch_them.setBorderPainted(false);
        btn_ch_them.setFocusPainted(false);
        btn_ch_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ch_themActionPerformed(evt);
            }
        });

        btn_ch_timkiem.setBackground(new java.awt.Color(204, 204, 204));
        btn_ch_timkiem.setText("Clear");
        btn_ch_timkiem.setBorderPainted(false);
        btn_ch_timkiem.setFocusPainted(false);
        btn_ch_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ch_timkiemActionPerformed(evt);
            }
        });

        btn_ch_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_ch_capnhat.setText("Cập nhật");
        btn_ch_capnhat.setBorderPainted(false);
        btn_ch_capnhat.setFocusPainted(false);
        btn_ch_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ch_capnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout qlch_chLayout = new javax.swing.GroupLayout(qlch_ch);
        qlch_ch.setLayout(qlch_chLayout);
        qlch_chLayout.setHorizontalGroup(
            qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlch_chLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(qlch_chLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ch_quocgia)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(qlch_chLayout.createSequentialGroup()
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlch_chLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ch_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlch_chLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ch_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlch_chLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cb_ch_thanhpho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(qlch_chLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ch_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ch_them)
                            .addComponent(btn_ch_timkiem)
                            .addComponent(btn_ch_capnhat)
                            .addComponent(btn_ch_xoa))))
                .addContainerGap())
        );

        qlch_chLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel13, jLabel15, jLabel7});

        qlch_chLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_ch_thanhpho, txt_ch_diachi, txt_ch_ma, txt_ch_quocgia, txt_ch_ten});

        qlch_chLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ch_capnhat, btn_ch_them, btn_ch_timkiem, btn_ch_xoa});

        qlch_chLayout.setVerticalGroup(
            qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlch_chLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlch_chLayout.createSequentialGroup()
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_ch_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ch_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_ch_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cb_ch_thanhpho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(qlch_chLayout.createSequentialGroup()
                        .addComponent(btn_ch_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ch_timkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ch_capnhat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ch_xoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlch_chLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_ch_quocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        qlch_chLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ch_capnhat, btn_ch_them, btn_ch_timkiem, btn_ch_xoa, cb_ch_thanhpho, txt_ch_diachi, txt_ch_ma, txt_ch_quocgia, txt_ch_ten});

        pn_qlch.add(qlch_ch);

        pn_main.add(pn_qlch, "qlch");

        pn_qlnv.setLayout(new java.awt.GridLayout(1, 1));

        qlnv_nv.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên"));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("NHÂN VIÊN");

        tb_qlnv_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Địa chỉ", "Cửa hàng", "Chức vụ"
            }
        ));
        tb_qlnv_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlnv_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_qlnv_nhanvien);

        txt_nv_ma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel27.setText("Mã");

        jLabel28.setText("Tên");

        txt_nv_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel29.setText("Giới tính");

        jLabel30.setText("Địa chỉ");

        txt_nv_diachi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel31.setText("Số DT");

        txt_nv_sodt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel32.setText("Cửa hàng");

        cb_nv_cuahang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cb_nv_cuahang.setFocusable(false);

        jLabel33.setText("Chức vụ");

        cb_nv_chucvu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cb_nv_chucvu.setFocusable(false);

        btn_nv_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_nv_them.setText("Thêm");
        btn_nv_them.setBorderPainted(false);
        btn_nv_them.setFocusPainted(false);
        btn_nv_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nv_themActionPerformed(evt);
            }
        });

        btn_nv_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_nv_clear.setText("Clear");
        btn_nv_clear.setBorderPainted(false);
        btn_nv_clear.setFocusPainted(false);
        btn_nv_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nv_clearActionPerformed(evt);
            }
        });

        btn_nv_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_nv_capnhat.setText("Cập nhật");
        btn_nv_capnhat.setBorderPainted(false);
        btn_nv_capnhat.setFocusPainted(false);
        btn_nv_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nv_capnhatActionPerformed(evt);
            }
        });

        btn_nv_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_nv_xoa.setText("Xóa");
        btn_nv_xoa.setBorderPainted(false);
        btn_nv_xoa.setFocusPainted(false);
        btn_nv_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nv_xoaActionPerformed(evt);
            }
        });

        buttonGroup.add(rd_nv_nam);
        rd_nv_nam.setText("Nam");
        rd_nv_nam.setFocusPainted(false);

        buttonGroup.add(rd_nv_nu);
        rd_nv_nu.setText("Nữ");
        rd_nv_nu.setFocusPainted(false);

        javax.swing.GroupLayout qlnv_nvLayout = new javax.swing.GroupLayout(qlnv_nv);
        qlnv_nv.setLayout(qlnv_nvLayout);
        qlnv_nvLayout.setHorizontalGroup(
            qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnv_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(qlnv_nvLayout.createSequentialGroup()
                        .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlnv_nvLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(18, 18, 18)
                                .addComponent(cb_nv_chucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(qlnv_nvLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(cb_nv_cuahang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlnv_nvLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nv_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(qlnv_nvLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nv_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nv_them))
                    .addGroup(qlnv_nvLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nv_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nv_clear))
                    .addGroup(qlnv_nvLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(rd_nv_nam)
                        .addGap(18, 18, 18)
                        .addComponent(rd_nv_nu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nv_capnhat))
                    .addGroup(qlnv_nvLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nv_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nv_xoa)))
                .addContainerGap())
        );

        qlnv_nvLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel27, jLabel28, jLabel29, jLabel30, jLabel31, jLabel32, jLabel33});

        qlnv_nvLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_nv_chucvu, cb_nv_cuahang, txt_nv_diachi, txt_nv_ma, txt_nv_sodt, txt_nv_ten});

        qlnv_nvLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_nv_capnhat, btn_nv_clear, btn_nv_them, btn_nv_xoa});

        qlnv_nvLayout.setVerticalGroup(
            qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnv_nvLayout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txt_nv_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nv_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_nv_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nv_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(btn_nv_capnhat)
                    .addComponent(rd_nv_nam)
                    .addComponent(rd_nv_nu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txt_nv_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nv_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txt_nv_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cb_nv_cuahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cb_nv_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        qlnv_nvLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_nv_capnhat, btn_nv_clear, btn_nv_them, btn_nv_xoa, cb_nv_chucvu, cb_nv_cuahang, rd_nv_nam, rd_nv_nu, txt_nv_diachi, txt_nv_ma, txt_nv_sodt, txt_nv_ten});

        pn_qlnv.add(qlnv_nv);

        qlnv_cv.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức vụ"));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("CHỨC VỤ");

        tb_qlnv_chucvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên"
            }
        ));
        tb_qlnv_chucvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlnv_chucvuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_qlnv_chucvu);
        if (tb_qlnv_chucvu.getColumnModel().getColumnCount() > 0) {
            tb_qlnv_chucvu.getColumnModel().getColumn(0).setResizable(false);
        }

        txt_cv_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_cv_ma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel34.setText("Mã");

        jLabel35.setText("Tên");

        btn_cv_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_cv_xoa.setText("Xóa");
        btn_cv_xoa.setBorderPainted(false);
        btn_cv_xoa.setFocusPainted(false);
        btn_cv_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cv_xoaActionPerformed(evt);
            }
        });

        btn_cv_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_cv_clear.setText("Clear");
        btn_cv_clear.setBorderPainted(false);
        btn_cv_clear.setFocusPainted(false);
        btn_cv_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cv_clearActionPerformed(evt);
            }
        });

        btn_cv_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_cv_them.setText("Thêm");
        btn_cv_them.setBorderPainted(false);
        btn_cv_them.setFocusPainted(false);
        btn_cv_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cv_themActionPerformed(evt);
            }
        });

        btn_cv_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_cv_capnhat.setText("Cập nhật");
        btn_cv_capnhat.setBorderPainted(false);
        btn_cv_capnhat.setFocusPainted(false);
        btn_cv_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cv_capnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout qlnv_cvLayout = new javax.swing.GroupLayout(qlnv_cv);
        qlnv_cv.setLayout(qlnv_cvLayout);
        qlnv_cvLayout.setHorizontalGroup(
            qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnv_cvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlnv_cvLayout.createSequentialGroup()
                        .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlnv_cvLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_cv_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlnv_cvLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(txt_cv_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cv_capnhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cv_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cv_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cv_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        qlnv_cvLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel34, jLabel35});

        qlnv_cvLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_cv_capnhat, btn_cv_clear, btn_cv_them, btn_cv_xoa});

        qlnv_cvLayout.setVerticalGroup(
            qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlnv_cvLayout.createSequentialGroup()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlnv_cvLayout.createSequentialGroup()
                        .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txt_cv_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlnv_cvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_cv_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(qlnv_cvLayout.createSequentialGroup()
                        .addComponent(btn_cv_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cv_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cv_capnhat)))
                .addGap(7, 7, 7)
                .addComponent(btn_cv_xoa)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        qlnv_cvLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_cv_capnhat, btn_cv_clear, btn_cv_them, btn_cv_xoa, txt_cv_ten});

        pn_qlnv.add(qlnv_cv);

        pn_main.add(pn_qlnv, "qlnv");

        pn_qlsp.setLayout(new java.awt.GridLayout(1, 0));

        qlsp_sp.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        lbl_title_gener.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_title_gener.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title_gener.setText("SẢN PHẨM");

        tb_qlsp_ttsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên"
            }
        ));
        tb_qlsp_ttsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlsp_ttspMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_qlsp_ttsp);

        cb_gener.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm", "NSX", "Màu sắc", "Dòng SP" }));
        cb_gener.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_generItemStateChanged(evt);
            }
        });

        jLabel46.setText("Mã");

        jLabel47.setText("Tên");

        txt_ttsp_ma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_ttsp_ten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_ttsp_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_xoa.setText("Xóa");
        btn_ttsp_xoa.setBorderPainted(false);
        btn_ttsp_xoa.setFocusPainted(false);
        btn_ttsp_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_xoaActionPerformed(evt);
            }
        });

        btn_ttsp_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_clear.setText("Clear");
        btn_ttsp_clear.setBorderPainted(false);
        btn_ttsp_clear.setFocusPainted(false);
        btn_ttsp_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_clearActionPerformed(evt);
            }
        });

        btn_ttsp_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_capnhat.setText("Cập nhật");
        btn_ttsp_capnhat.setBorderPainted(false);
        btn_ttsp_capnhat.setFocusPainted(false);
        btn_ttsp_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_capnhatActionPerformed(evt);
            }
        });

        btn_ttsp_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_them.setText("Thêm");
        btn_ttsp_them.setBorderPainted(false);
        btn_ttsp_them.setFocusPainted(false);
        btn_ttsp_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_themActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(java.awt.Color.red);
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Bạn đang cập nhật thông tin cho ");

        javax.swing.GroupLayout qlsp_spLayout = new javax.swing.GroupLayout(qlsp_sp);
        qlsp_sp.setLayout(qlsp_spLayout);
        qlsp_spLayout.setHorizontalGroup(
            qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_spLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title_gener, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_spLayout.createSequentialGroup()
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlsp_spLayout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ttsp_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlsp_spLayout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ttsp_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ttsp_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ttsp_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ttsp_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_spLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ttsp_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_spLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_gener, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel46, jLabel47});

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ttsp_capnhat, btn_ttsp_clear, btn_ttsp_them, btn_ttsp_xoa});

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_ttsp_ma, txt_ttsp_ten});

        qlsp_spLayout.setVerticalGroup(
            qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_spLayout.createSequentialGroup()
                .addComponent(lbl_title_gener)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlsp_spLayout.createSequentialGroup()
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txt_ttsp_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txt_ttsp_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(qlsp_spLayout.createSequentialGroup()
                        .addComponent(btn_ttsp_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ttsp_clear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ttsp_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ttsp_xoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_gener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap())
        );

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ttsp_clear, btn_ttsp_them, btn_ttsp_xoa, txt_ttsp_ma});

        pn_qlsp.add(qlsp_sp);

        qlsp_ctsp.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết sản phẩm"));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("CHI TIẾT SẢN PHẨM");

        tb_qlsp_ctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Năm BH", "Mô tả", "Số lượng", "Giá nhập", "Giá bán"
            }
        ));
        tb_qlsp_ctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_qlsp_ctspMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_qlsp_ctsp);

        jLabel38.setText("Sản phẩm");

        jLabel39.setText("Nhà sản xuất");

        jLabel40.setText("Màu sắc");

        jLabel41.setText("Dòng SP");

        jLabel42.setText("Năm BH");

        jLabel43.setText("Số lượng tồn");

        jLabel44.setText("Giá nhập");

        jLabel45.setText("Giá bán");

        txt_ctsp_nambh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_ctsp_gianhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_ctsp_giaban.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_ctsp_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_them.setText("Thêm");
        btn_ctsp_them.setBorderPainted(false);
        btn_ctsp_them.setFocusPainted(false);
        btn_ctsp_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_themActionPerformed(evt);
            }
        });

        btn_ctsp_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_clear.setText("Clear");
        btn_ctsp_clear.setBorderPainted(false);
        btn_ctsp_clear.setFocusPainted(false);
        btn_ctsp_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_clearActionPerformed(evt);
            }
        });

        btn_ctsp_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_capnhat.setText("Cập nhật");
        btn_ctsp_capnhat.setBorderPainted(false);
        btn_ctsp_capnhat.setFocusPainted(false);
        btn_ctsp_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_capnhatActionPerformed(evt);
            }
        });

        btn_ctsp_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_xoa.setText("Xóa");
        btn_ctsp_xoa.setBorderPainted(false);
        btn_ctsp_xoa.setFocusPainted(false);
        btn_ctsp_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_xoaActionPerformed(evt);
            }
        });

        jLabel48.setText("Mô tả");

        txt_ctsp_mota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout qlsp_ctspLayout = new javax.swing.GroupLayout(qlsp_ctsp);
        qlsp_ctsp.setLayout(qlsp_ctspLayout);
        qlsp_ctspLayout.setHorizontalGroup(
            qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_ctspLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(cb_ctsp_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ctsp_them))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(cb_ctsp_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ctsp_clear))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(cb_ctsp_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ctsp_capnhat))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ctsp_gianhap))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(sp_ctsp_slton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42))
                                .addGap(18, 18, 18)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_ctsp_dongsp, 0, 158, Short.MAX_VALUE)
                                    .addComponent(txt_ctsp_nambh)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qlsp_ctspLayout.createSequentialGroup()
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel48))
                                .addGap(18, 18, 18)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ctsp_mota)
                                    .addComponent(txt_ctsp_giaban))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btn_ctsp_xoa)))
                .addContainerGap())
        );

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel38, jLabel39, jLabel40, jLabel41, jLabel42, jLabel43, jLabel44, jLabel45});

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ctsp_capnhat, btn_ctsp_clear, btn_ctsp_them, btn_ctsp_xoa});

        qlsp_ctspLayout.setVerticalGroup(
            qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(cb_ctsp_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctsp_them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(cb_ctsp_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctsp_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cb_ctsp_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctsp_capnhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(cb_ctsp_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ctsp_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_ctsp_nambh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(sp_ctsp_slton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txt_ctsp_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txt_ctsp_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txt_ctsp_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ctsp_capnhat, btn_ctsp_clear, btn_ctsp_them, btn_ctsp_xoa, cb_ctsp_dongsp, cb_ctsp_mausac, cb_ctsp_nsx, cb_ctsp_sp, sp_ctsp_slton, txt_ctsp_giaban, txt_ctsp_gianhap, txt_ctsp_nambh});

        pn_qlsp.add(qlsp_ctsp);

        pn_main.add(pn_qlsp, "qlsp");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GIỎ HÀNG");

        javax.swing.GroupLayout pn_giohangLayout = new javax.swing.GroupLayout(pn_giohang);
        pn_giohang.setLayout(pn_giohangLayout);
        pn_giohangLayout.setHorizontalGroup(
            pn_giohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_giohangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_giohangLayout.setVerticalGroup(
            pn_giohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_giohangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_main.add(pn_giohang, "giohang");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("404");

        javax.swing.GroupLayout pn_hoadonLayout = new javax.swing.GroupLayout(pn_hoadon);
        pn_hoadon.setLayout(pn_hoadonLayout);
        pn_hoadonLayout.setHorizontalGroup(
            pn_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_hoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_hoadonLayout.setVerticalGroup(
            pn_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_hoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_main.add(pn_hoadon, "hoadon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qlchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlchMouseClicked
        effectNav(qlch, qlnv, sp, gh, hd, "Quản lý cửa hàng");
        qlch.setBackground(Color.lightGray);
        qlnv.setBackground(Color.GRAY);
        sp.setBackground(Color.GRAY);
        gh.setBackground(Color.GRAY);
        cardLayout.show(pn_main, "qlch");
    }//GEN-LAST:event_qlchMouseClicked

    private void qlnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlnvMouseClicked
        effectNav(qlnv, qlch, sp, gh, hd, "Quản lý nhân viên");
        cardLayout.show(pn_main, "qlnv");
    }//GEN-LAST:event_qlnvMouseClicked

    private void spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spMouseClicked
        effectNav(sp, qlch, qlnv, gh, hd, "Quản lý sản phẩm");
        cardLayout.show(pn_main, "qlsp");
    }//GEN-LAST:event_spMouseClicked

    private void ghMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ghMouseClicked
        effectNav(gh, qlch, qlnv, sp, hd, "PolyShop");
        cardLayout.show(pn_main, "giohang");
        this.dispose();
        new FrmManager().setVisible(true);
    }//GEN-LAST:event_ghMouseClicked

    private void hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hdMouseClicked
        effectNav(hd, gh, qlch, qlnv, sp, "PolyShop");
        cardLayout.show(pn_main, "hoadon");
    }//GEN-LAST:event_hdMouseClicked

    private void cb_generItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_generItemStateChanged
        String result = (String) cb_gener.getSelectedItem();
        lbl_title_gener.setText(result);
        if (result.equals("Sản phẩm")) {
            flag_qlsp_sp = 0;
        } else if (result.equals("Dòng SP")) {
            flag_qlsp_sp = 1;
        } else if (result.equals("Màu sắc")) {
            flag_qlsp_sp = 2;
        } else if (result.equals("NSX")) {
            flag_qlsp_sp = 3;
        }
        load_QLSP();
    }//GEN-LAST:event_cb_generItemStateChanged

    private void btn_ttsp_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_themActionPerformed
        if (flag_qlsp_sp == 0) {
            addSP();
        } else if (flag_qlsp_sp == 1) {
            addDongSP();
        } else if (flag_qlsp_sp == 2) {
            addMauSac();
        } else if (flag_qlsp_sp == 3) {
            addNSX();
        }
    }//GEN-LAST:event_btn_ttsp_themActionPerformed

    private void btn_ttsp_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_capnhatActionPerformed
        if (flag_qlsp_sp == 0) {
            updateSP();
        } else if (flag_qlsp_sp == 1) {
            updateDongSP();
        } else if (flag_qlsp_sp == 2) {
            updateMauSac();
        } else if (flag_qlsp_sp == 3) {
            updateNSX();
        }

    }//GEN-LAST:event_btn_ttsp_capnhatActionPerformed

    private void btn_ttsp_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_xoaActionPerformed
        if (flag_qlsp_sp == 0) {
            deleteSP();
        } else if (flag_qlsp_sp == 1) {
            deleteDongSP();
        } else if (flag_qlsp_sp == 2) {
            deleteMauSac();
        } else if (flag_qlsp_sp == 3) {
            deleteNSX();
        }
        clearTTSP();
    }//GEN-LAST:event_btn_ttsp_xoaActionPerformed

    private void tb_qlsp_ttspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlsp_ttspMouseClicked
        showDetailQLSP();
    }//GEN-LAST:event_tb_qlsp_ttspMouseClicked

    private void btn_ctsp_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_themActionPerformed
        saveCTSP(new SanPhamView(), new ChiTietSP(), "Thêm thành công!");
    }//GEN-LAST:event_btn_ctsp_themActionPerformed

    private void btn_ctsp_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_capnhatActionPerformed
        int row = tb_qlsp_ctsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cẩn cập nhật!");
        } else {
            SanPhamView spv = iQLSanPhamService.getAll().get(row);
            ChiTietSP ctsp = spv.getChiTietSP();
            saveCTSP(spv, ctsp, "Cập nhật thành công!");
            tb_qlsp_ctsp.setRowSelectionInterval(row, row);
            showDetailCTSP();
        }
    }//GEN-LAST:event_btn_ctsp_capnhatActionPerformed

    private void btn_ctsp_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_xoaActionPerformed
        int row = tb_qlsp_ctsp.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cẩn xóa!");
        } else {
            SanPhamView spv = iQLSanPhamService.getAll().get(row);
            ChiTietSP ctsp = spv.getChiTietSP();
            if (helper.confirm(this, "Xác nhận xóa ?")) {
                iQLSanPhamService.delete(spv);
                loadData();
                clearCTSP();
                helper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_ctsp_xoaActionPerformed

    private void tb_qlsp_ctspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlsp_ctspMouseClicked
        showDetailCTSP();
    }//GEN-LAST:event_tb_qlsp_ctspMouseClicked

    private void btn_kh_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kh_themActionPerformed
        KhachHang kh = new KhachHang();
        if (helper.checkNull(txt_kh_ma, "Mã")
                || helper.checkNull(txt_kh_ten, "Tên")
                || helper.checkNull(txt_kh_tendem, "Tên đệm")
                || helper.checkNull(txt_kh_ho, "Họ")
                || helper.checkNull(txt_kh_ngaysinh, "Ngày sinh")
                || helper.checkNull(txt_kh_sdt, "SDT")
                || helper.checkNull(txt_kh_diachi, "Địa chỉ")
                || helper.checkNull(txt_kh_quocgia, "Quốc gia")
                || helper.checkNull(txt_kh_matkhau, "Mật khẩu")
                || helper.checkRegex(txt_kh_ma, "^\\w[a-zA-Z@#0-9.]*$", "Mã không chứa dấu cách!")
                || helper.checkRegex(txt_kh_sdt, "^0[0-9]{9,10}", "SDT không đúng định dạng!")
                || helper.checkRegex(txt_kh_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")
                || helper.checkDate(txt_kh_ngaysinh.getText()) == null) {
            return;
        }
        if (iKhachHangService.getObjByMa(txt_kh_ma.getText()) != null) {
            helper.error(this, "Mã KH đã tồn tại!");
            return;
        } else {
            kh.setMa(txt_kh_ma.getText());
        }
        kh.setTen(txt_kh_ten.getText());
        kh.setTenDem(txt_kh_tendem.getText());
        kh.setHo(txt_kh_ho.getText());
        kh.setNgaySinh(helper.checkDate(txt_kh_ngaysinh.getText()));
        kh.setSdt(txt_kh_sdt.getText());
        kh.setDiaChi(txt_kh_diachi.getText());
        kh.setQuocGia(txt_kh_quocgia.getText());
        kh.setMatKhau(txt_kh_matkhau.getText());
        kh.setThanhPho((String) cb_kh_tp.getSelectedItem());
        iKhachHangService.save(kh);
        load_QLCH_KH();
        helper.alert(this, "Thêm thành công!");
    }//GEN-LAST:event_btn_kh_themActionPerformed

    private void btn_kh_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kh_capnhatActionPerformed
        int row = tb_qlch_khachhang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            KhachHang kh = iKhachHangService.getObjByMa((String) tb_qlch_khachhang.getValueAt(row, 1));
            if (helper.checkNull(txt_kh_ten, "Tên")
                    || helper.checkNull(txt_kh_tendem, "Tên đệm")
                    || helper.checkNull(txt_kh_ho, "Họ")
                    || helper.checkNull(txt_kh_ngaysinh, "Ngày sinh")
                    || helper.checkNull(txt_kh_sdt, "SDT")
                    || helper.checkNull(txt_kh_diachi, "Địa chỉ")
                    || helper.checkNull(txt_kh_quocgia, "Quốc gia")
                    || helper.checkNull(txt_kh_matkhau, "Mật khẩu")
                    || helper.checkRegex(txt_kh_sdt, "^0[0-9]{9,10}", "SDT không đúng định dạng!")
                    || helper.checkDate(txt_kh_ngaysinh.getText()) == null) {
                return;
            }
            kh.setTen(txt_kh_ten.getText());
            kh.setTenDem(txt_kh_tendem.getText());
            kh.setHo(txt_kh_ho.getText());
            kh.setNgaySinh(helper.checkDate(txt_kh_ngaysinh.getText()));
            kh.setSdt(txt_kh_sdt.getText());
            kh.setDiaChi(txt_kh_diachi.getText());
            kh.setQuocGia(txt_kh_quocgia.getText());
            kh.setMatKhau(txt_kh_matkhau.getText());
            kh.setThanhPho((String) cb_kh_tp.getSelectedItem());
            iKhachHangService.save(kh);
            load_QLCH_KH();
            tb_qlch_khachhang.setRowSelectionInterval(row, row);
            helper.alert(this, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_btn_kh_capnhatActionPerformed

    private void btn_kh_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kh_xoaActionPerformed
        int row = tb_qlch_khachhang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            KhachHang kh = iKhachHangService.getObjByMa((String) tb_qlch_khachhang.getValueAt(row, 1));
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                iKhachHangService.delete(kh);
                load_QLCH_KH();
                clearKH();
                helper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_kh_xoaActionPerformed

    private void tb_qlch_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlch_khachhangMouseClicked
        int row = tb_qlch_khachhang.getSelectedRow();
        KhachHang kh = iKhachHangService.getObjByMa((String) tb_qlch_khachhang.getValueAt(row, 1));
        txt_kh_ma.setText(kh.getMa());
        txt_kh_ten.setText(kh.getTen());
        txt_kh_tendem.setText(kh.getTenDem());
        txt_kh_ho.setText(kh.getHo());
        txt_kh_ngaysinh.setText(helper.formatDate(kh.getNgaySinh()));
        txt_kh_sdt.setText(kh.getSdt());
        txt_kh_diachi.setText(kh.getDiaChi());
        cb_kh_tp.setSelectedItem(kh.getThanhPho());
        txt_kh_quocgia.setText(kh.getQuocGia());
        txt_kh_matkhau.setText(kh.getMatKhau());
    }//GEN-LAST:event_tb_qlch_khachhangMouseClicked

    private void btn_ch_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ch_themActionPerformed
        CuaHang ch = new CuaHang();
        if (helper.checkNull(txt_ch_ma, "Mã")
                || helper.checkNull(txt_ch_ten, "Tên")
                || helper.checkNull(txt_ch_diachi, "Địa chỉ")
                || helper.checkNull(txt_ch_quocgia, "Quốc gia")
                || helper.checkRegex(txt_ch_ma, "^\\w[a-zA-Z@#0-9.]*$", "Mã không chứa dấu cách")) {
            return;
        }
        if (iCuaHangService.getObjByMa(txt_ch_ma.getText()) != null) {
            helper.error(this, "Mã cửa hàng đã tồn tại!");
        } else {
            ch.setMa(txt_ch_ma.getText());
            ch.setTen(txt_ch_ten.getText());
            ch.setDiaChi(txt_ch_diachi.getText());
            ch.setThanhPho((String) cb_ch_thanhpho.getSelectedItem());
            ch.setQuocGia(txt_ch_quocgia.getText());
            iCuaHangService.save(ch);
            loadData();
            helper.alert(this, "Thêm thành công!");
        }
    }//GEN-LAST:event_btn_ch_themActionPerformed

    private void btn_ch_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ch_capnhatActionPerformed
        int row = tb_qlch_cuahang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            CuaHang ch = iCuaHangService.getObjByMa((String) tb_qlch_cuahang.getValueAt(row, 1));
            if (helper.checkNull(txt_ch_ten, "Tên")
                    || helper.checkNull(txt_ch_diachi, "Địa chỉ")
                    || helper.checkNull(txt_ch_quocgia, "Quốc gia")) {
                return;
            }
            ch.setTen(txt_ch_ten.getText());
            ch.setDiaChi(txt_ch_diachi.getText());
            ch.setThanhPho((String) cb_ch_thanhpho.getSelectedItem());
            ch.setQuocGia(txt_ch_quocgia.getText());
            iCuaHangService.save(ch);
            loadData();
            helper.alert(this, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_btn_ch_capnhatActionPerformed

    private void btn_ch_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ch_xoaActionPerformed
        int row = tb_qlch_cuahang.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                CuaHang ch = iCuaHangService.getObjByMa((String) tb_qlch_cuahang.getValueAt(row, 1));
                if (iCuaHangService.delete(ch).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    clearCH();
                    helper.alert(this, "Xóa thành công!");
                }
            }
        }
    }//GEN-LAST:event_btn_ch_xoaActionPerformed

    private void tb_qlch_cuahangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlch_cuahangMouseClicked
        int row = tb_qlch_cuahang.getSelectedRow();
        CuaHang ch = iCuaHangService.getObjByMa((String) tb_qlch_cuahang.getValueAt(row, 1));
        txt_ch_ma.setText(ch.getMa());
        txt_ch_ten.setText(ch.getTen());
        txt_ch_diachi.setText(ch.getDiaChi());
        cb_ch_thanhpho.setSelectedItem(ch.getThanhPho());
        txt_ch_quocgia.setText(ch.getQuocGia());
    }//GEN-LAST:event_tb_qlch_cuahangMouseClicked

    private void btn_cv_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cv_themActionPerformed
        QLChucVu qlcv = new QLChucVu();
        if (helper.checkNull(txt_cv_ma, "Mã")
                || helper.checkNull(txt_cv_ten, "Tên")
                || helper.checkRegex(txt_cv_ma, "^\\w[a-zA-Z@#0-9.]*$", "Mã không chứa đấu cách!")
                || helper.checkRegex(txt_cv_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")) {
            return;
        }
        if (iQLChucVuService.getObjByMa(txt_cv_ma.getText()) == null) {
            qlcv.setMa(txt_cv_ma.getText());
            qlcv.setTen(txt_cv_ten.getText());
            iQLChucVuService.add(qlcv);
            loadData();
            helper.alert(this, "Thêm thành công!");
        } else {
            helper.error(this, "Mã chức vụ đã tồn tại!");
        }
    }//GEN-LAST:event_btn_cv_themActionPerformed

    private void btn_cv_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cv_capnhatActionPerformed
        int row = tb_qlnv_chucvu.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần cập nhật");
        } else {
            QLChucVu qlcv = iQLChucVuService.getObjByMa((String) tb_qlnv_chucvu.getValueAt(row, 1));
            if (helper.checkNull(txt_cv_ten, "Tên")) {
                return;
            }
            qlcv.setTen(txt_cv_ten.getText());
            iQLChucVuService.update(qlcv);
            loadData();
            tb_qlnv_chucvu.setRowSelectionInterval(row, row);
            showDetailChucVu();
            helper.alert(this, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_btn_cv_capnhatActionPerformed

    private void btn_cv_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cv_xoaActionPerformed
        int row = tb_qlnv_chucvu.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                QLChucVu qlcv = iQLChucVuService.getObjByMa((String) tb_qlnv_chucvu.getValueAt(row, 1));
                if (iQLChucVuService.delete(qlcv).equals("NotOK")) {
                    helper.error(this, "Xóa thất bại!");
                } else {
                    loadData();
                    clearCV();
                    helper.alert(this, "Xóa thành công!");
                }
            }
        }
    }//GEN-LAST:event_btn_cv_xoaActionPerformed

    private void tb_qlnv_chucvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlnv_chucvuMouseClicked
        showDetailChucVu();
    }//GEN-LAST:event_tb_qlnv_chucvuMouseClicked

    private void btn_nv_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nv_themActionPerformed
        NhanVien nv = new NhanVien();
        if (helper.checkNull(txt_nv_ma, "Mã")
                || helper.checkNull(txt_nv_ten, "Tên")
                || helper.checkNull(txt_nv_diachi, "Địa chỉ")
                || helper.checkNull(txt_nv_ma, "SDT")
                || helper.checkRegex(txt_nv_ma, "^\\w[a-zA-Z@#0-9.]*$", "Mã không chứa dấu cách!")
                || helper.checkRegex(txt_nv_ten, "(\\S+ )*\\S+", "Tên không hợp lệ!")
                || helper.checkRegex(txt_nv_sodt, "^0[0-9]{9,10}", "SDT không đúng định dạng!")) {
            return;
        }
        if (iNhanVienService.getObjByMa(txt_nv_ma.getText()) != null) {
            helper.error(this, "Mã NV đã tồn tại!");
        } else {
            nv.setMa(txt_nv_ma.getText());
            nv.setTen(txt_nv_ten.getText());
            if (rd_nv_nam.isSelected() == false && rd_nv_nu.isSelected() == false) {
                helper.error(this, "Vui lòng chọn giới tính!");
                return;
            } else {
                if (rd_nv_nam.isSelected()) {
                    nv.setGioiTinh("Nam");
                } else {
                    nv.setGioiTinh("Nữ");
                }
            }
            nv.setDiaChi(txt_nv_diachi.getText());
            nv.setSdt(txt_nv_sodt.getText());
            CuaHang ch = (CuaHang) comBoCuaHang.getSelectedItem();
            ChucVu cv = (ChucVu) comBoChucVu.getSelectedItem();
            nv.setCuaHang(ch);
            nv.setChucVu(cv);
            iNhanVienService.save(nv);
            load_QLNV_NV();
            helper.alert(this, "Thêm thành công!");
        }
    }//GEN-LAST:event_btn_nv_themActionPerformed

    private void btn_nv_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nv_capnhatActionPerformed
        int row = tb_qlnv_nhanvien.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cẩn cập nhật!");
        } else {
            NhanVien nv = iNhanVienService.getObjByMa((String) tb_qlnv_nhanvien.getValueAt(row, 1));
            if (helper.checkNull(txt_nv_ten, "Tên")
                    || helper.checkNull(txt_nv_diachi, "Địa chỉ")
                    || helper.checkNull(txt_nv_ma, "SDT")
                    || helper.checkRegex(txt_nv_sodt, "^0[0-9]{9,10}", "SDT không đúng định dạng!")) {
                return;
            }
            nv.setTen(txt_nv_ten.getText());
            if (rd_nv_nam.isSelected() == false && rd_nv_nu.isSelected() == false) {
                helper.error(this, "Vui lòng chọn giới tính!");
                return;
            } else {
                if (rd_nv_nam.isSelected()) {
                    nv.setGioiTinh("Nam");
                } else {
                    nv.setGioiTinh("Nữ");
                }
            }
            nv.setDiaChi(txt_nv_diachi.getText());
            nv.setSdt(txt_nv_sodt.getText());
            CuaHang ch = (CuaHang) comBoCuaHang.getSelectedItem();
            ChucVu cv = (ChucVu) comBoChucVu.getSelectedItem();
            nv.setCuaHang(ch);
            nv.setChucVu(cv);
            iNhanVienService.save(nv);
            load_QLNV_NV();
            tb_qlnv_nhanvien.setRowSelectionInterval(row, row);
            showDetailNhanVien();
            helper.alert(this, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_btn_nv_capnhatActionPerformed

    private void btn_nv_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nv_xoaActionPerformed
        int row = tb_qlnv_nhanvien.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            if (helper.confirm(this, "Xác nhận muốn xóa ?")) {
                NhanVien nv = iNhanVienService.getObjByMa((String) tb_qlnv_nhanvien.getValueAt(row, 1));
                iNhanVienService.delete(nv);
                load_QLNV_NV();
                clearNV();
                helper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_nv_xoaActionPerformed

    private void tb_qlnv_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_qlnv_nhanvienMouseClicked
        showDetailNhanVien();
    }//GEN-LAST:event_tb_qlnv_nhanvienMouseClicked

    private void pn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_logoutMouseClicked
        if (helper.confirm(this, "Bạn có chắc muốn đăng xuất khỏi trái đất ?")) {
            helper.alert(this, "Đăng xuất thành công!");
            System.exit(0);
        }
    }//GEN-LAST:event_pn_logoutMouseClicked

    private void btn_kh_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kh_clearActionPerformed
        clearKH();
    }//GEN-LAST:event_btn_kh_clearActionPerformed

    private void btn_ch_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ch_timkiemActionPerformed
        clearCH();
    }//GEN-LAST:event_btn_ch_timkiemActionPerformed

    private void btn_nv_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nv_clearActionPerformed
        clearNV();
    }//GEN-LAST:event_btn_nv_clearActionPerformed

    private void btn_cv_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cv_clearActionPerformed
        clearCV();
    }//GEN-LAST:event_btn_cv_clearActionPerformed

    private void btn_ttsp_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_clearActionPerformed
        clearTTSP();
    }//GEN-LAST:event_btn_ttsp_clearActionPerformed

    private void btn_ctsp_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_clearActionPerformed
        clearCTSP();
    }//GEN-LAST:event_btn_ctsp_clearActionPerformed

    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDetails1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ch_capnhat;
    private javax.swing.JButton btn_ch_them;
    private javax.swing.JButton btn_ch_timkiem;
    private javax.swing.JButton btn_ch_xoa;
    private javax.swing.JButton btn_ctsp_capnhat;
    private javax.swing.JButton btn_ctsp_clear;
    private javax.swing.JButton btn_ctsp_them;
    private javax.swing.JButton btn_ctsp_xoa;
    private javax.swing.JButton btn_cv_capnhat;
    private javax.swing.JButton btn_cv_clear;
    private javax.swing.JButton btn_cv_them;
    private javax.swing.JButton btn_cv_xoa;
    private javax.swing.JButton btn_kh_capnhat;
    private javax.swing.JButton btn_kh_clear;
    private javax.swing.JButton btn_kh_them;
    private javax.swing.JButton btn_kh_xoa;
    private javax.swing.JButton btn_nv_capnhat;
    private javax.swing.JButton btn_nv_clear;
    private javax.swing.JButton btn_nv_them;
    private javax.swing.JButton btn_nv_xoa;
    private javax.swing.JButton btn_ttsp_capnhat;
    private javax.swing.JButton btn_ttsp_clear;
    private javax.swing.JButton btn_ttsp_them;
    private javax.swing.JButton btn_ttsp_xoa;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> cb_ch_thanhpho;
    private javax.swing.JComboBox<String> cb_ctsp_dongsp;
    private javax.swing.JComboBox<String> cb_ctsp_mausac;
    private javax.swing.JComboBox<String> cb_ctsp_nsx;
    private javax.swing.JComboBox<String> cb_ctsp_sp;
    private javax.swing.JComboBox<String> cb_gener;
    private javax.swing.JComboBox<String> cb_kh_tp;
    private javax.swing.JComboBox<String> cb_nv_chucvu;
    private javax.swing.JComboBox<String> cb_nv_cuahang;
    private javax.swing.JPanel gh;
    private javax.swing.JPanel hd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_title_gener;
    private javax.swing.JPanel pn_giohang;
    private javax.swing.JPanel pn_hello;
    private javax.swing.JPanel pn_hoadon;
    private javax.swing.JPanel pn_logout;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_qlch;
    private javax.swing.JPanel pn_qlnv;
    private javax.swing.JPanel pn_qlsp;
    private javax.swing.JPanel qlch;
    private javax.swing.JPanel qlch_ch;
    private javax.swing.JPanel qlch_kh;
    private javax.swing.JPanel qlnv;
    private javax.swing.JPanel qlnv_cv;
    private javax.swing.JPanel qlnv_nv;
    private javax.swing.JPanel qlsp_ctsp;
    private javax.swing.JPanel qlsp_sp;
    private javax.swing.JRadioButton rd_nv_nam;
    private javax.swing.JRadioButton rd_nv_nu;
    private javax.swing.JPanel sp;
    private javax.swing.JSpinner sp_ctsp_slton;
    private javax.swing.JTable tb_qlch_cuahang;
    private javax.swing.JTable tb_qlch_khachhang;
    private javax.swing.JTable tb_qlnv_chucvu;
    private javax.swing.JTable tb_qlnv_nhanvien;
    private javax.swing.JTable tb_qlsp_ctsp;
    private javax.swing.JTable tb_qlsp_ttsp;
    private javax.swing.JTextField txt_ch_diachi;
    private javax.swing.JTextField txt_ch_ma;
    private javax.swing.JTextField txt_ch_quocgia;
    private javax.swing.JTextField txt_ch_ten;
    private javax.swing.JTextField txt_ctsp_giaban;
    private javax.swing.JTextField txt_ctsp_gianhap;
    private javax.swing.JTextField txt_ctsp_mota;
    private javax.swing.JTextField txt_ctsp_nambh;
    private javax.swing.JTextField txt_cv_ma;
    private javax.swing.JTextField txt_cv_ten;
    private javax.swing.JTextField txt_kh_diachi;
    private javax.swing.JTextField txt_kh_ho;
    private javax.swing.JTextField txt_kh_ma;
    private javax.swing.JTextField txt_kh_matkhau;
    private javax.swing.JTextField txt_kh_ngaysinh;
    private javax.swing.JTextField txt_kh_quocgia;
    private javax.swing.JTextField txt_kh_sdt;
    private javax.swing.JTextField txt_kh_ten;
    private javax.swing.JTextField txt_kh_tendem;
    private javax.swing.JTextField txt_nv_diachi;
    private javax.swing.JTextField txt_nv_ma;
    private javax.swing.JTextField txt_nv_sodt;
    private javax.swing.JTextField txt_nv_ten;
    private javax.swing.JTextField txt_ttsp_ma;
    private javax.swing.JTextField txt_ttsp_ten;
    // End of variables declaration//GEN-END:variables

    private void clearKH() {
        txt_kh_ma.setText("");
        txt_kh_ten.setText("");
        txt_kh_tendem.setText("");
        txt_kh_ho.setText("");
        txt_kh_ngaysinh.setText("");
        txt_kh_sdt.setText("");
        txt_kh_diachi.setText("");
        txt_kh_quocgia.setText("");
        txt_kh_matkhau.setText("");
        cb_kh_tp.setSelectedIndex(0);
        tb_qlch_khachhang.clearSelection();
    }

    private void clearCH() {
        txt_ch_ma.setText("");
        txt_ch_ten.setText("");
        txt_ch_diachi.setText("");
        txt_ch_quocgia.setText("");
        cb_ch_thanhpho.setSelectedIndex(0);
        tb_qlch_cuahang.clearSelection();
    }

    private void clearNV() {
        txt_nv_ma.setText("");
        txt_nv_ten.setText("");
        txt_nv_diachi.setText("");
        txt_nv_sodt.setText("");
        buttonGroup.clearSelection();
        cb_nv_cuahang.setSelectedIndex(0);
        cb_nv_chucvu.setSelectedIndex(0);
        tb_qlnv_nhanvien.clearSelection();
    }

    private void clearCV() {
        txt_cv_ma.setText("");
        txt_cv_ten.setText("");
        tb_qlnv_chucvu.clearSelection();
    }

    private void clearTTSP() {
        txt_ttsp_ma.setText("");
        txt_ttsp_ten.setText("");
        tb_qlsp_ttsp.clearSelection();
    }

    private void clearCTSP() {
        txt_ctsp_nambh.setText("");
        txt_ctsp_gianhap.setText("");
        txt_ctsp_giaban.setText("");
        txt_ctsp_mota.setText("");
        sp_ctsp_slton.setValue(0);
        tb_qlsp_ctsp.clearSelection();
    }
}
