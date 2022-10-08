/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_MaTenLoai;
import BLL.BLL_SoDoPhong;
import BLL.BLL_ThuePhong;
import DAL.DAL_ThuePhong;
import DTO.DTO_Phong;
import DTO.DTO_ThuePhong;
import HELPER.HELPER_ChuyenDoi;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CherryCe
 */
public class GUI_dal_ThongTinPhong extends javax.swing.JDialog {

    /**
     * Creates new form GUI_dalThongTinPhong
     */
    public GUI_dal_ThongTinPhong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadThongTinPhong();
        trangThaiPhong();
        tongThoiGian();
    }

    public void trangThaiPhong() {
        JLabel dateTimeNgayDen = new JLabel();
        JLabel dateTimeNgayDi = new JLabel();

        ArrayList<DTO_ThuePhong> arrayThuePhong = BLL_ThuePhong.select(BLL_MaTenLoai.findMaPhong(lblSetSoPhong.getText().substring(0, 3)), BLL_MaTenLoai.findMaTrangThaiPhong(lblSetTrangThai.getText()));
        BLL_ThuePhong.load(arrayThuePhong, lblSetMaPhieuThue, lblSetNhanVien, lblNgayTao, dateTimeNgayDen, dateTimeNgayDi, txtCMND, txtTenKhach, txtSoLuong, txtGhiChu, txtTienCoc, txtGiamGia);

        if (lblSetTrangThai.getText().equals("Phòng Trống")) {
            lblSetTrangThai.setBackground(new Color(97, 177, 90));
            lblSetMaPhieuThue.setText(setMaPhieuThue());
            lblSetNgayTao.setText(HELPER_ChuyenDoi.getTimeNow("dd-MM-yy HH:mm"));
            dateNgayDen.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy")));
            dateNgayDi.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", HELPER_ChuyenDoi.getTimeNow("dd-MM-yyyy")));
            lblGioPhutDen.setText(HELPER_ChuyenDoi.getTimeNow("HH:mm"));
            lblGioPhutDi.setText(HELPER_ChuyenDoi.getTimeNow("HH:mm"));
            lblThanhToanPhong.setVisible(false);
        } else {
            if (lblSetTrangThai.getText().equals("Có Khách")) {
                lblSetTrangThai.setBackground(new Color(255, 142, 113));
            } else if (lblSetTrangThai.getText().equals("Đặt Trước")) {
                lblSetTrangThai.setBackground(new Color(102, 153, 255));
            } else if (lblSetTrangThai.getText().equals("Trả Phòng")) {
                lblSetTrangThai.setBackground(new Color(255, 153, 0));
            }
            
            lblThanhToanPhong.setVisible(true);

            try {
                dateNgayDen.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", dateTimeNgayDen.getText()));
                lblGioPhutDen.setText(HELPER_ChuyenDoi.convertDate("yyyy-MM-dd HH:mm", "HH:mm", dateTimeNgayDen.getText()));
                dateNgayDi.setDate(HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy", dateTimeNgayDi.getText()));
                lblGioPhutDi.setText(HELPER_ChuyenDoi.convertDate("yyyy-MM-dd HH:mm", "HH:mm", dateTimeNgayDi.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String setMaPhieuThue() {
        String maPhieuThue = "PT";
        try {
            maPhieuThue = maPhieuThue + HELPER_ChuyenDoi.getTimeNow("yyMMdd");
            ResultSet rs = DAL_ThuePhong.count(HELPER_ChuyenDoi.getTimeNow("yyMMdd"));
            int rowCount = 0;
            while (rs.next()) {
                rowCount = rs.getInt(1);
                if (rowCount > 99) {
                    maPhieuThue = maPhieuThue + (rowCount + 1);
                } else if (rowCount > 9) {
                    maPhieuThue = maPhieuThue + "0" + (rowCount + 1);
                } else {
                    maPhieuThue = maPhieuThue + "00" + (rowCount + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maPhieuThue;
    }

    public void tongThoiGian() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date d1 = null;
        Date d2 = null;

        String dateStart = lblGioPhutDen.getText();
        String dateStop = lblGioPhutDi.getText();

        try {
            String ngayDen = HELPER_ChuyenDoi.convertDate("dd-MM-yyyy", "yyyy-MM-dd", HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", dateNgayDen.getDate()));
            String ngayDi = HELPER_ChuyenDoi.convertDate("dd-MM-yyyy", "yyyy-MM-dd", HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", dateNgayDi.getDate()));
            java.sql.Date date1 = java.sql.Date.valueOf(ngayDen);
            java.sql.Date date2 = java.sql.Date.valueOf(ngayDi);
            c1.setTime(date1);
            c2.setTime(date2);
            d1 = (Date) format.parse(dateStart);
            d2 = (Date) format.parse(dateStop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        long diff = (d2.getTime() - d1.getTime()) / 1000;
        long diffHours = diff / (60 * 60);
        long diffMinutes = (diff % (60 * 60)) / 60;

        lblTongThoiGian.setText(String.valueOf(noDay + "d " + diffHours + "h " + diffMinutes + "m"));
    }

//    public void validate() {
//        if (lblSetSoPhong.getText().isEmpty() || lblSetMaPhieuThue.getText().isEmpty() || lblSetTrangThai.getText().isEmpty() || lblSetNhanVien.getText().isEmpty() || lblSetNgayTao.getText().isEmpty() || dateNgayDen.getDate().equals(null) || lblGioPhutDen.getText().isEmpty() || dateNgayDi.getDate().equals(null) || lblGioPhutDi.getText().isEmpty() || txtCMND.getText().isEmpty() || txtTenKhach.getText().isEmpty() || txtSoLuong.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Dữ Liệu Không Được Để Trống !!!");
//        }
//       
//    }
    public void addThuePhong() {
//        validate();
        String ngayGioDen = HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", dateNgayDen.getDate()) + " " + lblGioPhutDen.getText();
        String ngayGioDi = HELPER_ChuyenDoi.getNgayString("dd-MM-yyyy", dateNgayDi.getDate()) + " " + lblGioPhutDi.getText();

        DTO_ThuePhong thuePhong = new DTO_ThuePhong(lblSetSoPhong.getText().substring(0, 3), lblSetMaPhieuThue.getText(), lblSetNhanVien.getText(), HELPER_ChuyenDoi.getNgayDate("dd-MM-yy HH:mm", lblSetNgayTao.getText()), HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyyy HH:mm", ngayGioDen), null, txtCMND.getText(), txtTenKhach.getText(), HELPER_ChuyenDoi.getSoInt(txtSoLuong.getText()), txtGhiChu.getText(), HELPER_ChuyenDoi.getSoInt(txtTienCoc.getText()), HELPER_ChuyenDoi.getSoInt(txtGiamGia.getText()), 1);
        BLL_ThuePhong.add(thuePhong);
    }

    public void editThuePhong(int index) {
//        validate();
        String ngayGioDen = new SimpleDateFormat("dd-MM-yyyy").format(dateNgayDen.getDate()) + " " + lblGioPhutDen.getText();
        String ngayGioDi = new SimpleDateFormat("dd-MM-yyyy").format(dateNgayDi.getDate()) + " " + lblGioPhutDi.getText();

        DTO_ThuePhong thuePhong = new DTO_ThuePhong(lblSetSoPhong.getText().substring(0, 3), lblSetMaPhieuThue.getText(), lblSetNhanVien.getText(), HELPER_ChuyenDoi.getNgayDate("dd-MM-yy HH:mm", lblSetNgayTao.getText()), HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyyy HH:mm", ngayGioDen), HELPER_ChuyenDoi.getNgayDate("dd-MM-yyyy HH:mm", ngayGioDi), txtCMND.getText(), txtTenKhach.getText(), Integer.parseInt(txtSoLuong.getText()), txtGhiChu.getText(), Integer.parseInt(txtTienCoc.getText()), Integer.parseInt(txtGiamGia.getText()), 0);
        BLL_ThuePhong.edit(thuePhong);
    }

    public void loadThongTinPhong() {
        ArrayList<DTO_Phong> array = BLL_SoDoPhong.selectPhong(GUI_pnl_ChiTietPhong.indexPosition + 1);
        BLL_SoDoPhong.loadThongTinPhong(array, lblSetSoPhong, lblSetTrangThai);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChucNang = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        lblCapNhat = new javax.swing.JLabel();
        lblThanhToanPhong = new javax.swing.JLabel();
        sdoThongTinPhong = new HELPER.PanelShadow();
        txtSoLuong = new javax.swing.JTextField();
        txtTenKhach = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        lblSetTrangThai = new javax.swing.JLabel();
        lblSetMaPhieuThue = new javax.swing.JLabel();
        lblNhanPhong = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTenKhach = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        lblSoPhong = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        spt_2 = new javax.swing.JSeparator();
        spt_1 = new javax.swing.JSeparator();
        lblSetNhanVien = new javax.swing.JLabel();
        lblSetSoPhong = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblMaPhieu = new javax.swing.JLabel();
        lblTraPhong = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblThongTinPhong = new javax.swing.JLabel();
        lblSetNgayTao = new javax.swing.JLabel();
        dateNgayDi = new com.toedter.calendar.JDateChooser();
        dateNgayDen = new com.toedter.calendar.JDateChooser();
        lblGioPhutDi = new javax.swing.JLabel();
        lblGioPhutDen = new javax.swing.JLabel();
        lblTongThoiGian = new javax.swing.JLabel();
        sdoDichVu = new HELPER.PanelShadow();
        scrDichVu = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        sdoKhoDichVu = new HELPER.PanelShadow();
        scrKhoDichVu = new javax.swing.JScrollPane();
        tblKhoDichVu = new javax.swing.JTable();
        lblExit = new javax.swing.JLabel();
        sdoGiaPhong = new HELPER.PanelShadow();
        txtThanhToan = new javax.swing.JTextField();
        lblSetGiaPhong = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        lblSetCoLai = new javax.swing.JLabel();
        txtTienCoc = new javax.swing.JTextField();
        lblSetDichVu = new javax.swing.JLabel();
        cboThanhToan = new javax.swing.JComboBox<>();
        lblSetTongTien = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        lblTienCoc = new javax.swing.JLabel();
        lblConLai = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        lblDichVu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1020, 570));
        setUndecorated(true);

        pnlChucNang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(33, 150, 243)));
        pnlChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThoat.setBackground(new java.awt.Color(255, 255, 255));
        lblThoat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(33, 150, 243));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logout (6).png"))); // NOI18N
        lblThoat.setText("Thoát");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        pnlChucNang.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 90, 50));

        lblCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(33, 150, 243));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/upgrade (3).png"))); // NOI18N
        lblCapNhat.setText("Cập Nhật");
        lblCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatMouseClicked(evt);
            }
        });
        pnlChucNang.add(lblCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 110, 50));

        lblThanhToanPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThanhToanPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThanhToanPhong.setForeground(new java.awt.Color(33, 150, 243));
        lblThanhToanPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhToanPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cart (3).png"))); // NOI18N
        lblThanhToanPhong.setText("Thanh Toán");
        pnlChucNang.add(lblThanhToanPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 130, 50));

        sdoThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoThongTinPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(33, 150, 243)));
        sdoThongTinPhong.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoThongTinPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSoLuong.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(62, 73, 95));
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoThongTinPhong.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 70, 20));

        txtTenKhach.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtTenKhach.setForeground(new java.awt.Color(62, 73, 95));
        txtTenKhach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoThongTinPhong.add(txtTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 120, 20));

        txtCMND.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtCMND.setForeground(new java.awt.Color(62, 73, 95));
        txtCMND.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoThongTinPhong.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 20));

        txtGhiChu.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(62, 73, 95));
        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoThongTinPhong.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 100, 20));

        lblSetTrangThai.setBackground(new java.awt.Color(255, 102, 102));
        lblSetTrangThai.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lblSetTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetTrangThai.setText("Có Khách");
        lblSetTrangThai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetTrangThai.setOpaque(true);
        sdoThongTinPhong.add(lblSetTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 100, 20));

        lblSetMaPhieuThue.setBackground(new java.awt.Color(255, 255, 255));
        lblSetMaPhieuThue.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetMaPhieuThue.setForeground(new java.awt.Color(62, 73, 95));
        lblSetMaPhieuThue.setText("220912001");
        sdoThongTinPhong.add(lblSetMaPhieuThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        lblNhanPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanPhong.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblNhanPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblNhanPhong.setText("Nhận Phòng");
        sdoThongTinPhong.add(lblNhanPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 30));

        lblSoLuong.setBackground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(153, 153, 153));
        lblSoLuong.setText("Số Lượng");
        sdoThongTinPhong.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        lblTenKhach.setBackground(new java.awt.Color(255, 255, 255));
        lblTenKhach.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTenKhach.setForeground(new java.awt.Color(153, 153, 153));
        lblTenKhach.setText("Tên Khách");
        sdoThongTinPhong.add(lblTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        lblCMND.setBackground(new java.awt.Color(255, 255, 255));
        lblCMND.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblCMND.setForeground(new java.awt.Color(153, 153, 153));
        lblCMND.setText("CMND/ Hộ Chiếu");
        sdoThongTinPhong.add(lblCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        lblSoPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblSoPhong.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblSoPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblSoPhong.setText("Số Phòng");
        sdoThongTinPhong.add(lblSoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        lblGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        lblGhiChu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(153, 153, 153));
        lblGhiChu.setText("Ghi Chú");
        sdoThongTinPhong.add(lblGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));
        sdoThongTinPhong.add(spt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 540, 10));
        sdoThongTinPhong.add(spt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 540, 10));

        lblSetNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNhanVien.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetNhanVien.setForeground(new java.awt.Color(62, 73, 95));
        lblSetNhanVien.setText("CherryCe");
        sdoThongTinPhong.add(lblSetNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 80, 20));

        lblSetSoPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblSetSoPhong.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetSoPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblSetSoPhong.setText("201 - P. Đơn");
        sdoThongTinPhong.add(lblSetSoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 20));

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(153, 153, 153));
        lblNhanVien.setText("Nhân Viên");
        sdoThongTinPhong.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 30));

        lblTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        lblTrangThai.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(153, 153, 153));
        lblTrangThai.setText("Trạng Thái");
        sdoThongTinPhong.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 60, 30));

        lblMaPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblMaPhieu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblMaPhieu.setForeground(new java.awt.Color(153, 153, 153));
        lblMaPhieu.setText("Mã Phiếu");
        sdoThongTinPhong.add(lblMaPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 60, 30));

        lblTraPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblTraPhong.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTraPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblTraPhong.setText("Trả Phòng");
        sdoThongTinPhong.add(lblTraPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, 30));

        lblNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayTao.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(153, 153, 153));
        lblNgayTao.setText("Ngày Tạo");
        sdoThongTinPhong.add(lblNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 60, 30));

        lblThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThongTinPhong.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblThongTinPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblThongTinPhong.setText("THÔNG TIN PHÒNG");
        sdoThongTinPhong.add(lblThongTinPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        lblSetNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNgayTao.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetNgayTao.setForeground(new java.awt.Color(62, 73, 95));
        lblSetNgayTao.setText("16-09-22 22:08");
        sdoThongTinPhong.add(lblSetNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 20));

        dateNgayDi.setBackground(new java.awt.Color(255, 255, 255));
        dateNgayDi.setForeground(new java.awt.Color(62, 73, 95));
        dateNgayDi.setToolTipText("");
        dateNgayDi.setDateFormatString("dd-MM-yyyy");
        dateNgayDi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayDiPropertyChange(evt);
            }
        });
        sdoThongTinPhong.add(dateNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 100, 20));

        dateNgayDen.setBackground(new java.awt.Color(255, 255, 255));
        dateNgayDen.setForeground(new java.awt.Color(62, 73, 95));
        dateNgayDen.setToolTipText("");
        dateNgayDen.setDateFormatString("dd-MM-yyyy");
        dateNgayDen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayDenPropertyChange(evt);
            }
        });
        sdoThongTinPhong.add(dateNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 20));

        lblGioPhutDi.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutDi.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblGioPhutDi.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutDi.setText("00:00");
        lblGioPhutDi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(62, 73, 95)));
        sdoThongTinPhong.add(lblGioPhutDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 40, 20));

        lblGioPhutDen.setBackground(new java.awt.Color(255, 255, 255));
        lblGioPhutDen.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblGioPhutDen.setForeground(new java.awt.Color(62, 73, 95));
        lblGioPhutDen.setText("00:00");
        lblGioPhutDen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(62, 73, 95)));
        sdoThongTinPhong.add(lblGioPhutDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 40, 20));

        lblTongThoiGian.setBackground(new java.awt.Color(255, 255, 255));
        lblTongThoiGian.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTongThoiGian.setForeground(new java.awt.Color(62, 73, 95));
        lblTongThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongThoiGian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/circle (1).png"))); // NOI18N
        lblTongThoiGian.setText("7d 16h 15m");
        lblTongThoiGian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTongThoiGian.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseMoved(evt);
            }
        });
        lblTongThoiGian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTongThoiGianMouseExited(evt);
            }
        });
        sdoThongTinPhong.add(lblTongThoiGian, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 80, 70));

        sdoDichVu.setBackground(new java.awt.Color(255, 255, 255));
        sdoDichVu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(33, 150, 243)));
        sdoDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDichVu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrDichVu.setViewportView(tblDichVu);

        sdoDichVu.add(scrDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 130));

        sdoKhoDichVu.setBackground(new java.awt.Color(255, 255, 255));
        sdoKhoDichVu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(33, 150, 243)));
        sdoKhoDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhoDichVu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        tblKhoDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrKhoDichVu.setViewportView(tblKhoDichVu);

        sdoKhoDichVu.add(scrKhoDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 460));

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/close (1).png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        sdoKhoDichVu.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 30, 20));

        sdoGiaPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoGiaPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(33, 150, 243)));
        sdoGiaPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtThanhToan.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtThanhToan.setForeground(new java.awt.Color(62, 73, 95));
        txtThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoGiaPhong.add(txtThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 60, 20));

        lblSetGiaPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblSetGiaPhong.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetGiaPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblSetGiaPhong.setText("220912001");
        sdoGiaPhong.add(lblSetGiaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        txtGiamGia.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtGiamGia.setForeground(new java.awt.Color(62, 73, 95));
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGiaActionPerformed(evt);
            }
        });
        sdoGiaPhong.add(txtGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 80, 20));

        lblSetCoLai.setBackground(new java.awt.Color(255, 255, 255));
        lblSetCoLai.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetCoLai.setForeground(new java.awt.Color(62, 73, 95));
        lblSetCoLai.setText("220912001");
        sdoGiaPhong.add(lblSetCoLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 30));

        txtTienCoc.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        txtTienCoc.setForeground(new java.awt.Color(62, 73, 95));
        txtTienCoc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoGiaPhong.add(txtTienCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 80, 20));

        lblSetDichVu.setBackground(new java.awt.Color(255, 255, 255));
        lblSetDichVu.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetDichVu.setForeground(new java.awt.Color(62, 73, 95));
        lblSetDichVu.setText("220912001");
        sdoGiaPhong.add(lblSetDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 30));

        cboThanhToan.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        cboThanhToan.setForeground(new java.awt.Color(62, 73, 95));
        cboThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sdoGiaPhong.add(cboThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 80, -1));

        lblSetTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblSetTongTien.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lblSetTongTien.setForeground(new java.awt.Color(62, 73, 95));
        lblSetTongTien.setText("220912001");
        sdoGiaPhong.add(lblSetTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 30));

        lblThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        lblThanhToan.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblThanhToan.setForeground(new java.awt.Color(153, 153, 153));
        lblThanhToan.setText("Thanh Toán");
        sdoGiaPhong.add(lblThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 30));

        lblTienCoc.setBackground(new java.awt.Color(255, 255, 255));
        lblTienCoc.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTienCoc.setForeground(new java.awt.Color(153, 153, 153));
        lblTienCoc.setText("Tiền Cọc");
        sdoGiaPhong.add(lblTienCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        lblConLai.setBackground(new java.awt.Color(255, 255, 255));
        lblConLai.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblConLai.setForeground(new java.awt.Color(153, 153, 153));
        lblConLai.setText("Còn Lại");
        sdoGiaPhong.add(lblConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, 30));

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(153, 153, 153));
        lblTongTien.setText("Tổng Tiền");
        sdoGiaPhong.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 30));

        lblGiamGia.setBackground(new java.awt.Color(255, 255, 255));
        lblGiamGia.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblGiamGia.setForeground(new java.awt.Color(153, 153, 153));
        lblGiamGia.setText("Giảm Giá");
        sdoGiaPhong.add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        lblGiaPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaPhong.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblGiaPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblGiaPhong.setText("Giá Phòng");
        sdoGiaPhong.add(lblGiaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        lblDichVu.setBackground(new java.awt.Color(255, 255, 255));
        lblDichVu.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(153, 153, 153));
        lblDichVu.setText("Dịch Vụ");
        sdoGiaPhong.add(lblDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdoDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdoGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdoKhoDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoThongTinPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoKhoDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblTongThoiGianMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTongThoiGianMouseMoved

    private void lblTongThoiGianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTongThoiGianMouseClicked

    private void lblTongThoiGianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongThoiGianMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTongThoiGianMouseExited

    private void dateNgayDiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayDiPropertyChange
        // TODO add your handling code here:
        if (dateNgayDi.getDate() != null) {
            tongThoiGian();
        }
    }//GEN-LAST:event_dateNgayDiPropertyChange

    private void dateNgayDenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayDenPropertyChange
        // TODO add your handling code here:
        if (dateNgayDi.getDate() != null) {
            tongThoiGian();
        }
    }//GEN-LAST:event_dateNgayDenPropertyChange

    private void lblCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatMouseClicked
        // TODO add your handling code here:
        addThuePhong();
    }//GEN-LAST:event_lblCapNhatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_ThongTinPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_ThongTinPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_ThongTinPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_dal_ThongTinPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI_dal_ThongTinPhong dialog = new GUI_dal_ThongTinPhong(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboThanhToan;
    private com.toedter.calendar.JDateChooser dateNgayDen;
    private com.toedter.calendar.JDateChooser dateNgayDi;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblConLai;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGiaPhong;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblGioPhutDen;
    private javax.swing.JLabel lblGioPhutDi;
    private javax.swing.JLabel lblMaPhieu;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblNhanPhong;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSetCoLai;
    private javax.swing.JLabel lblSetDichVu;
    private javax.swing.JLabel lblSetGiaPhong;
    private javax.swing.JLabel lblSetMaPhieuThue;
    private javax.swing.JLabel lblSetNgayTao;
    private javax.swing.JLabel lblSetNhanVien;
    private javax.swing.JLabel lblSetSoPhong;
    private javax.swing.JLabel lblSetTongTien;
    private javax.swing.JLabel lblSetTrangThai;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblSoPhong;
    private javax.swing.JLabel lblTenKhach;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblThanhToanPhong;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongTinPhong;
    private javax.swing.JLabel lblTienCoc;
    private javax.swing.JLabel lblTongThoiGian;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTraPhong;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JScrollPane scrDichVu;
    private javax.swing.JScrollPane scrKhoDichVu;
    private HELPER.PanelShadow sdoDichVu;
    private HELPER.PanelShadow sdoGiaPhong;
    private HELPER.PanelShadow sdoKhoDichVu;
    private HELPER.PanelShadow sdoThongTinPhong;
    private javax.swing.JSeparator spt_1;
    private javax.swing.JSeparator spt_2;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhoDichVu;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTienCoc;
    // End of variables declaration//GEN-END:variables
}
