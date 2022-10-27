package Views;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Services.IHoaDonChiTietService;
import Services.IHoaDonService;
import Services.IHoaDonViewService;
import Services.INhanVienService;
import Services.IQLSanPhamService;
import Services.impl.HoaDonChiTietService;
import Services.impl.HoaDonService;
import Services.impl.HoaDonViewService;
import Services.impl.NhanVienService;
import Services.impl.QLSanPhamService;
import Utilities.Helper;
import ViewModels.QLHoaDonCT;
import ViewModels.SanPhamView;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class FrmManager extends javax.swing.JFrame {

    private IQLSanPhamService iQLSanPhamService;
    private IHoaDonChiTietService iHoaDonChiTietService;

    private IHoaDonService iHoaDonService;
    private INhanVienService iNhanVienService;
    private Helper helper = new Helper();

    private DefaultTableModel defaultTableModel;
    private Integer checkSearchSP = 0;

    public FrmManager() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Vu Nguyen Huong PH27229");
        iQLSanPhamService = new QLSanPhamService();
        iHoaDonService = new HoaDonService();
        iHoaDonChiTietService = new HoaDonChiTietService();
        iNhanVienService = new NhanVienService();

        load_CTSP(iQLSanPhamService.getAll());
        rd_tatca.setSelected(true);
        load_HD(iHoaDonService.getAll());
        tb_sanpham.getTableHeader().setReorderingAllowed(false);
        tb_giohang.getTableHeader().setReorderingAllowed(false);
        tb_hoadon.getTableHeader().setReorderingAllowed(false);
    }

    private void load_HD(List<HoaDon> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_hoadon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getMa(), x.getNgayTao(), x.getNhanVien().getTen(), x.getTrangThaiHD(x.getTinhTrang())
            });
        }
    }

    private void load_CTSP(List<SanPhamView> list) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamView x : list) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getSanPham().getMa(), x.getSanPham().getTen(), x.getChiTietSP().getNamBH(), x.getChiTietSP().getMoTa(), x.getChiTietSP().getSoLuongTon(), x.getChiTietSP().getGiaNhap(), x.getChiTietSP().getGiaBan()
            });
        }
    }

    private void loadGioHang(UUID id) {
        int stt = 1;
        defaultTableModel = (DefaultTableModel) tb_giohang.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet x : iHoaDonChiTietService.findById(id)) {
            defaultTableModel.addRow(new Object[]{
                stt++, x.getChiTietSP().getSanPham().getMa(), x.getChiTietSP().getSanPham().getTen(), x.getSoLuong(), x.getDonGia(), x.getSoLuong() * x.getDonGia().doubleValue()
            });
        }
    }

    private void tongTien() {
        Double tongTien = 0.0;
        for (int i = 0; i < tb_giohang.getRowCount(); i++) {
            tongTien = tongTien + Double.parseDouble(tb_giohang.getValueAt(i, 5).toString());
        }
        txt_tongtien.setText(tongTien.toString());
    }

    private void showDetailHD() {
        int rowHD = tb_hoadon.getSelectedRow();
        txt_mahd.setText((String) tb_hoadon.getValueAt(rowHD, 1));
        txt_ngaytao.setText(tb_hoadon.getValueAt(rowHD, 2).toString());
        txt_tennv.setText((String) tb_hoadon.getValueAt(rowHD, 3));
        if (rd_tatca.isSelected()) {
            loadGioHang(iHoaDonService.getAll().get(rowHD).getId());
        } else if (rd_chott.isSelected()) {
            loadGioHang(iHoaDonService.findByTT(0).get(rowHD).getId());
        } else {
            loadGioHang(iHoaDonService.findByTT(1).get(rowHD).getId());
        }
    }

    private void clearHD() {
        txt_mahd.setText("");
        txt_ngaytao.setText("");
        txt_tennv.setText("");
        txt_tongtien.setText("");
        txt_tienkhachdua.setText("");
        txt_tienthua.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoadon = new javax.swing.JTable();
        rd_datt = new javax.swing.JRadioButton();
        rd_tatca = new javax.swing.JRadioButton();
        rd_chott = new javax.swing.JRadioButton();
        btn_taohd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_giohang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        txt_sanpham = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        txt_tennv = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        txt_tienkhachdua = new javax.swing.JTextField();
        txt_tienthua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Tên nhân viên", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoadon);

        buttonGroup.add(rd_datt);
        rd_datt.setText("Đã thanh toán");
        rd_datt.setFocusPainted(false);
        rd_datt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_dattActionPerformed(evt);
            }
        });

        buttonGroup.add(rd_tatca);
        rd_tatca.setText("Tất cả");
        rd_tatca.setFocusPainted(false);
        rd_tatca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_tatcaActionPerformed(evt);
            }
        });

        buttonGroup.add(rd_chott);
        rd_chott.setText("Chờ thanh toán");
        rd_chott.setFocusPainted(false);
        rd_chott.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_chottActionPerformed(evt);
            }
        });

        btn_taohd.setBackground(new java.awt.Color(153, 153, 153));
        btn_taohd.setForeground(new java.awt.Color(255, 255, 255));
        btn_taohd.setText("Tạo hóa đơn");
        btn_taohd.setBorder(null);
        btn_taohd.setFocusPainted(false);
        btn_taohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_taohd, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rd_tatca)
                        .addGap(18, 18, 18)
                        .addComponent(rd_chott)
                        .addGap(18, 18, 18)
                        .addComponent(rd_datt))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_datt)
                    .addComponent(rd_tatca)
                    .addComponent(rd_chott))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_taohd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tb_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_giohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_giohangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_giohang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm BH", "Mô tả", "SL  SP", "Giá nhập", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_sanpham);

        txt_sanpham.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_sanpham.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_sanphamCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        jLabel1.setText("Mã HD");

        txt_mahd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel2.setText("Ngày tạo");

        txt_ngaytao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txt_tennv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txt_tongtien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txt_tienkhachdua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_tienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tienkhachduaCaretUpdate(evt);
            }
        });

        txt_tienthua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel3.setText("Tên NV");

        jLabel4.setText("Tổng tiền");

        jLabel5.setText("Tiền khách đưa");

        jLabel6.setText("Tiền thừa");

        btn_thanhtoan.setBackground(new java.awt.Color(153, 153, 153));
        btn_thanhtoan.setForeground(new java.awt.Color(255, 255, 255));
        btn_thanhtoan.setText("THANH TOÁN");
        btn_thanhtoan.setBorder(null);
        btn_thanhtoan.setFocusPainted(false);
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(txt_ngaytao)
                    .addComponent(txt_tennv)
                    .addComponent(txt_tongtien)
                    .addComponent(txt_tienkhachdua)
                    .addComponent(txt_tienthua))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_mahd, txt_ngaytao, txt_tennv, txt_tienkhachdua, txt_tienthua, txt_tongtien});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(41, 41, 41)
                .addComponent(btn_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_mahd, txt_ngaytao, txt_tennv, txt_tienkhachdua, txt_tienthua, txt_tongtien});

        btn_return.setBackground(new java.awt.Color(153, 153, 153));
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Trở về màn hình chính");
        btn_return.setBorderPainted(false);
        btn_return.setFocusPainted(false);
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_taohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohdActionPerformed
        HoaDon hd = new HoaDon();
        String result;
        for (int i = 0; i < iHoaDonService.getAll().size() + 1; i++) {
            result = "HD" + i;
            if (iHoaDonService.getObjByMa(result) == null) {
                hd.setMa(result);
                break;
            } else {
                continue;
            }
        }
        hd.setNgayTao(java.sql.Date.valueOf(LocalDate.now()));
        try {
            hd.setNhanVien(iNhanVienService.getAll().get(0));
        } catch (Exception e) {
            helper.error(this, "Nhân viên không tồn tại!");
            return;
        }
        hd.setTinhTrang(0);
        if (helper.confirm(this, "Xác nhận tạo hóa đơn ?")) {
            iHoaDonService.save(hd);
            load_HD(iHoaDonService.getAll());
            rd_tatca.setSelected(true);
            helper.alert(this, "Tạo thành công!");
        }
    }//GEN-LAST:event_btn_taohdActionPerformed

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int rowHD = tb_hoadon.getSelectedRow();
        int rowSP = tb_sanpham.getSelectedRow();
        Integer soLuongNhap = 0;
        if (rowHD == -1) {
            tb_sanpham.clearSelection();
            helper.error(this, "Vui lòng chọn hóa đơn cần thêm!");
        } else {
            SanPhamView spv;
            HoaDon hd = iHoaDonService.getObjByMa(txt_mahd.getText());
            if (hd.getTinhTrang() == 1 || rd_datt.isSelected()) {
                tb_sanpham.clearSelection();
                helper.error(this, "Hóa đơn đã được thanh toán!");
                return;
            }
            if (checkSearchSP == 0) {
                spv = iQLSanPhamService.getAll().get(rowSP);
            } else {
                spv = iQLSanPhamService.findByName(txt_sanpham.getText()).get(rowSP);
            }

            if (spv.getChiTietSP().getSoLuongTon() == 0) {
                helper.error(this, "Đã cháy hàng!");
                return;
            }

            String slString = JOptionPane.showInputDialog(this, "Vui lòng nhập số lượng: ");
            try {
                soLuongNhap = Integer.parseInt(slString);
                if (soLuongNhap <= 0) {
                    helper.error(this, "Vui lòng nhập lại!");
                    return;
                } else if (soLuongNhap > spv.getChiTietSP().getSoLuongTon()) {
                    helper.error(this, "Quá số lượng cho phép!");
                    return;
                }
            } catch (Exception e) {
                helper.error(this, "Vui lòng nhập lại!");
                return;
            }

            if (iHoaDonChiTietService.getObj(hd.getId(), spv.getChiTietSP().getId()) == null) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setChiTietSP(spv.getChiTietSP());
                hdct.setHoaDon(hd);
                hdct.setSoLuong(soLuongNhap);
                spv.getChiTietSP().setSoLuongTon(spv.getChiTietSP().getSoLuongTon() - soLuongNhap);
                hdct.setDonGia(spv.getChiTietSP().getGiaBan());
                iHoaDonChiTietService.save(hdct);
                iQLSanPhamService.save(spv);
            } else {
                HoaDonChiTiet hdct = iHoaDonChiTietService.getObj(hd.getId(), spv.getChiTietSP().getId());
                hdct.setSoLuong(hdct.getSoLuong() + soLuongNhap);
                spv.getChiTietSP().setSoLuongTon(spv.getChiTietSP().getSoLuongTon() - soLuongNhap);
                iQLSanPhamService.save(spv);
                iHoaDonChiTietService.save(hdct);
            }
            loadGioHang(hd.getId());
            load_CTSP(iQLSanPhamService.getAll());
            checkSearchSP = 0;
        }
        tongTien();
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void tb_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoadonMouseClicked
        showDetailHD();
        tongTien();
    }//GEN-LAST:event_tb_hoadonMouseClicked

    private void txt_sanphamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_sanphamCaretUpdate
        load_CTSP(iQLSanPhamService.findByName(txt_sanpham.getText()));
        if (txt_sanpham.getText().isEmpty()) {
            checkSearchSP = 0;
        } else {
            checkSearchSP = 1;
        }
    }//GEN-LAST:event_txt_sanphamCaretUpdate

    private void tb_giohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_giohangMouseClicked
        int rowGH = tb_giohang.getSelectedRow();
        int rowHD = tb_hoadon.getSelectedRow();
        Integer soLuongNhap = 0;
        HoaDon hd = iHoaDonService.getObjByMa(txt_mahd.getText());
        if (hd.getTinhTrang() == 1) {
            tb_giohang.clearSelection();
            helper.error(this, "Hóa đơn đã được thanh toán");
        } else {
            HoaDonChiTiet hdct = iHoaDonChiTietService.findById(hd.getId()).get(rowGH);
            SanPhamView spv = iQLSanPhamService.getObjById(hdct.getChiTietSP().getId());
            String slString = JOptionPane.showInputDialog(this, "Vui lòng nhập số lượng: ");
            try {
                soLuongNhap = Integer.parseInt(slString);
                if (spv.getChiTietSP().getSoLuongTon() == 0) {
                    if (soLuongNhap > hdct.getSoLuong()) {
                        helper.error(this, "Quá số lượng cho phép!");
                        return;
                    }
                } else if (soLuongNhap > spv.getChiTietSP().getSoLuongTon()) {
                    helper.error(this, "Quá số lượng cho phép!");
                    return;
                }
            } catch (Exception e) {
                helper.error(this, "Vui lòng nhập lại!");
                return;
            }

            if (soLuongNhap == 0) {
                if (helper.confirm(this, "Xác nhận xóa mặt hàng ?")) {
                    spv.getChiTietSP().setSoLuongTon(spv.getChiTietSP().getSoLuongTon() + hdct.getSoLuong());
                    iQLSanPhamService.save(spv);
                    iHoaDonChiTietService.delete(hdct);
                    loadGioHang(hd.getId());
                    load_CTSP(iQLSanPhamService.getAll());
                    checkSearchSP = 0;
                    helper.alert(this, "Xóa thành công!");
                }
            } else if (soLuongNhap < 0) {
                helper.error(this, "Vui lòng nhập lại!");
            } else {
                spv.getChiTietSP().setSoLuongTon(spv.getChiTietSP().getSoLuongTon() + hdct.getSoLuong() - soLuongNhap);
                iQLSanPhamService.save(spv);
                hdct.setSoLuong(soLuongNhap);
                iHoaDonChiTietService.save(hdct);
                loadGioHang(hd.getId());
                load_CTSP(iQLSanPhamService.getAll());
                checkSearchSP = 0;
                helper.alert(this, "Cập nhật thành công!");
            }
        }
    }//GEN-LAST:event_tb_giohangMouseClicked

    private void rd_chottActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_chottActionPerformed
        load_HD(iHoaDonService.findByTT(0));
    }//GEN-LAST:event_rd_chottActionPerformed

    private void rd_dattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_dattActionPerformed
        load_HD(iHoaDonService.findByTT(1));
    }//GEN-LAST:event_rd_dattActionPerformed

    private void rd_tatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_tatcaActionPerformed
        load_HD(iHoaDonService.getAll());
    }//GEN-LAST:event_rd_tatcaActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        if (txt_mahd.getText().isEmpty()) {
            helper.error(this, "Vui lòng chọn hóa đơn cần thanh toán!");
        } else {
            if (Double.parseDouble(txt_tongtien.getText()) == 0) {
                helper.error(this, "Hóa đơn trống, hãy thêm gì đó vào giỏ hàng!");
                return;
            }
            if (txt_tienkhachdua.getText().isEmpty()) {
                helper.error(this, "Bạn chưa nhập tiền khách đưa!");
            } else {
                HoaDon hd = iHoaDonService.getObjByMa(txt_mahd.getText());
                if (hd.getTinhTrang() == 1) {
                    helper.error(this, "Hóa đơn đã được thanh toán!");
                } else {
                    hd.setTinhTrang(1);
                    if (helper.confirm(this, "Xác nhận thanh toán ?")) {
                        iHoaDonService.save(hd);
                        rd_datt.setSelected(true);
                        load_HD(iHoaDonService.findByTT(1));
                        txt_tienkhachdua.setText("");
                        txt_tienthua.setText("");
                        helper.alert(this, "Thanh toán thành công!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void txt_tienkhachduaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tienkhachduaCaretUpdate
        Double tongTien = 0.0;
        Double tienKhachDua = 0.0;
        try {
            tongTien = Double.parseDouble(txt_tongtien.getText().toString());
            tienKhachDua = Double.parseDouble(txt_tienkhachdua.getText().toString());
        } catch (Exception e) {
        }
        txt_tienthua.setText(tienKhachDua - tongTien + "");
    }//GEN-LAST:event_txt_tienkhachduaCaretUpdate

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.dispose();
        new FrmDetails().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

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
//            java.util.logging.Logger.getLogger(ViewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_taohd;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rd_chott;
    private javax.swing.JRadioButton rd_datt;
    private javax.swing.JRadioButton rd_tatca;
    private javax.swing.JTable tb_giohang;
    private javax.swing.JTable tb_hoadon;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_sanpham;
    private javax.swing.JTextField txt_tennv;
    private javax.swing.JTextField txt_tienkhachdua;
    private javax.swing.JTextField txt_tienthua;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}
