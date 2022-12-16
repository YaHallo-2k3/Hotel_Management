/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_LoaiSanPham;
import BLL.BLL_MaTenLoai;
import BLL.BLL_SanPham;
import DTO.DTO_LoaiSanPham;
import DTO.DTO_SanPham;
import HELPER.HELPER_ChuyenDoi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_SanPham extends javax.swing.JPanel {

    /**
     * Creates new form GUI_pnl_SanPham
     */
    public GUI_pnl_SanPham() {
        initComponents();
        loadLoaiSanPham();
        loadTenLoaiSanPham();
        loadSanPham();
    }

    public void addLoaiSanPham() {
        DTO_LoaiSanPham loaiSanPham = new DTO_LoaiSanPham(txtMaLoai.getText(), txtTenLoai.getText());
        BLL_LoaiSanPham.add(loaiSanPham);
    }

    public void deleteLoaiSanPham(int index) {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String maLoai = tblLoaiSanPham.getValueAt(index, 0).toString();
            BLL_LoaiSanPham.delete(maLoai);
        }
        return;
    }

    public void editLoaiSanPham() {
        DTO_LoaiSanPham loaiSanPham = new DTO_LoaiSanPham(txtMaLoai.getText(), txtTenLoai.getText());
        BLL_LoaiSanPham.edit(loaiSanPham);
    }

    public void fillLoaiSanPham(int index) {
        txtMaLoai.setText(tblLoaiSanPham.getValueAt(index, 0).toString());
        txtTenLoai.setText(tblLoaiSanPham.getValueAt(index, 1).toString());
    }

    public void loadLoaiSanPham() {
        ArrayList<DTO_LoaiSanPham> array = BLL_LoaiSanPham.select();
        BLL_LoaiSanPham.load(array, tblLoaiSanPham);
    }

    public void loadTenLoaiSanPham() {
        ArrayList<DTO_LoaiSanPham> array = BLL_MaTenLoai.selectTenLoaiSanPham();
        BLL_MaTenLoai.loadTenLoaiSanPham(array, cboLoaiHang);
    }

    public void addSanPham() {
        DTO_SanPham sanPham = new DTO_SanPham(txtMaHang.getText(), txtTenHang.getText(), String.valueOf(cboLoaiHang.getSelectedItem()), String.valueOf(cboDonVi.getSelectedItem()), HELPER_ChuyenDoi.getSoInt(txtGiaBan.getText()), HELPER_ChuyenDoi.getNgayDate("dd-MM-yy HH:mm", HELPER_ChuyenDoi.getTimeNow("dd-MM-yy HH:mm")));
        BLL_SanPham.add(sanPham);
    }

    public void deleteSanPham(int index) {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String maSanPham = tblSanPham.getValueAt(index, 0).toString();
            BLL_SanPham.delete(maSanPham);
        }
        return;
    }

    public void editSanPham() {
        DTO_SanPham sanPham = new DTO_SanPham(txtMaHang.getText(), txtTenHang.getText(), String.valueOf(cboLoaiHang.getSelectedItem()), String.valueOf(cboDonVi.getSelectedItem()), HELPER_ChuyenDoi.getSoInt(txtGiaBan.getText()), HELPER_ChuyenDoi.getNgayDate("dd-MM-yy HH:mm", lblSetNgayTao.getText()));
        BLL_SanPham.edit(sanPham);
    }

    public void fillSanPham(int index) {
        txtMaHang.setText(tblSanPham.getValueAt(index, 0).toString());
        txtTenHang.setText(tblSanPham.getValueAt(index, 1).toString());
        cboLoaiHang.setSelectedItem(tblSanPham.getValueAt(index, 2).toString());
        cboDonVi.setSelectedItem(tblSanPham.getValueAt(index, 3).toString());
        txtGiaBan.setText(tblSanPham.getValueAt(index, 4).toString());
        lblSetNgayTao.setText(tblSanPham.getValueAt(index, 5).toString());
    }

    public void loadSanPham() {
        ArrayList<DTO_SanPham> array = BLL_SanPham.select();
        BLL_SanPham.load(array, tblSanPham);
    }

    public void search() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblSanPham.getModel());
        tblSanPham.setRowSorter(rowSorter);
        if (txtTimKiem.getText().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTimKiem.getText()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sdoSanPham = new LIB.PanelShadow();
        lblMaHang = new javax.swing.JLabel();
        lblTenHang = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        lblLoaiHang = new javax.swing.JLabel();
        cboDonVi = new javax.swing.JComboBox<>();
        lblDonVi = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        lblThemHang = new javax.swing.JLabel();
        scrSanPham = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtMaHang = new javax.swing.JTextField();
        cboLoaiHang = new javax.swing.JComboBox<>();
        lblGiaBan = new javax.swing.JLabel();
        lblSetNgayTao = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        sdoLoaiSanPham = new LIB.PanelShadow();
        scrLoaiSanPham = new javax.swing.JScrollPane();
        tblLoaiSanPham = new javax.swing.JTable();
        lblMaLoai = new javax.swing.JLabel();
        lblTenLoai = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        lblLoaiSanPham = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        lblThemLoai = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));

        sdoSanPham.setBackground(new java.awt.Color(255, 255, 255));
        sdoSanPham.setMinimumSize(new java.awt.Dimension(830, 730));
        sdoSanPham.setPreferredSize(new java.awt.Dimension(830, 730));
        sdoSanPham.setShadowOpacity(0.3F);
        sdoSanPham.setShadowType(LIB.ShadowType.BOT_RIGHT);
        sdoSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaHang.setBackground(new java.awt.Color(255, 255, 255));
        lblMaHang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaHang.setForeground(new java.awt.Color(153, 153, 153));
        lblMaHang.setText("Mã Hàng");
        sdoSanPham.add(lblMaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        lblTenHang.setBackground(new java.awt.Color(255, 255, 255));
        lblTenHang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTenHang.setForeground(new java.awt.Color(153, 153, 153));
        lblTenHang.setText("Tên Hàng");
        sdoSanPham.add(lblTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 20));

        txtTenHang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTenHang.setForeground(new java.awt.Color(62, 73, 95));
        txtTenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenHang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sdoSanPham.add(txtTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 100, 20));

        lblLoaiHang.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiHang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblLoaiHang.setForeground(new java.awt.Color(153, 153, 153));
        lblLoaiHang.setText("Loại Hàng");
        sdoSanPham.add(lblLoaiHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 60, 20));

        cboDonVi.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboDonVi.setForeground(new java.awt.Color(62, 73, 95));
        cboDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chai", "Lon", "Ly", "Phần", "Chiếc", "Gói" }));
        cboDonVi.setToolTipText("");
        cboDonVi.setBorder(null);
        sdoSanPham.add(cboDonVi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 70, 20));

        lblDonVi.setBackground(new java.awt.Color(255, 255, 255));
        lblDonVi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDonVi.setForeground(new java.awt.Color(153, 153, 153));
        lblDonVi.setText("Đơn Vị");
        sdoSanPham.add(lblDonVi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 50, 20));

        lblSanPham.setBackground(new java.awt.Color(255, 255, 255));
        lblSanPham.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(62, 73, 95));
        lblSanPham.setText("SẢN PHẨM");
        sdoSanPham.add(lblSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));

        lblNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblNgayTao.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(153, 153, 153));
        lblNgayTao.setText("Ngày Tạo");
        sdoSanPham.add(lblNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 60, 20));

        txtGiaBan.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtGiaBan.setForeground(new java.awt.Color(62, 73, 95));
        txtGiaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiaBan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sdoSanPham.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 70, 20));

        lblThemHang.setBackground(new java.awt.Color(255, 255, 255));
        lblThemHang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblThemHang.setForeground(new java.awt.Color(33, 150, 243));
        lblThemHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (1).png"))); // NOI18N
        lblThemHang.setText("Thêm");
        lblThemHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemHangMouseClicked(evt);
            }
        });
        sdoSanPham.add(lblThemHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 70, 30));

        scrSanPham.setBackground(new java.awt.Color(255, 255, 255));
        scrSanPham.setBorder(null);

        tblSanPham.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblSanPham.setForeground(new java.awt.Color(62, 73, 95));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Loại Hàng", "Đơn Vị", "Giá Bán", "Ngày Tạo", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(30);
        tblSanPham.setShowHorizontalLines(false);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        scrSanPham.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(6).setMaxWidth(40);
            tblSanPham.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        sdoSanPham.add(scrSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 790, 530));

        txtMaHang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtMaHang.setForeground(new java.awt.Color(62, 73, 95));
        txtMaHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaHang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sdoSanPham.add(txtMaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 20));

        cboLoaiHang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboLoaiHang.setForeground(new java.awt.Color(62, 73, 95));
        cboLoaiHang.setToolTipText("");
        cboLoaiHang.setBorder(null);
        sdoSanPham.add(cboLoaiHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 100, 20));

        lblGiaBan.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaBan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGiaBan.setForeground(new java.awt.Color(153, 153, 153));
        lblGiaBan.setText("Giá Bán");
        sdoSanPham.add(lblGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 20));

        lblSetNgayTao.setBackground(new java.awt.Color(255, 255, 255));
        lblSetNgayTao.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblSetNgayTao.setForeground(new java.awt.Color(62, 73, 95));
        sdoSanPham.add(lblSetNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 100, 20));

        txtTimKiem.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(62, 73, 95));
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        sdoSanPham.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 100, 30));

        lblTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        lblTimKiem.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(33, 150, 243));
        lblTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/magnifier (2).png"))); // NOI18N
        lblTimKiem.setText("Tìm Kiếm");
        lblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTimKiemMouseClicked(evt);
            }
        });
        sdoSanPham.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 90, 30));

        sdoLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        sdoLoaiSanPham.setMinimumSize(new java.awt.Dimension(320, 730));
        sdoLoaiSanPham.setPreferredSize(new java.awt.Dimension(320, 730));
        sdoLoaiSanPham.setShadowOpacity(0.3F);
        sdoLoaiSanPham.setShadowType(LIB.ShadowType.BOT_RIGHT);
        sdoLoaiSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        scrLoaiSanPham.setBorder(null);

        tblLoaiSanPham.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblLoaiSanPham.setForeground(new java.awt.Color(62, 73, 95));
        tblLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Loại", "Tên Loại", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSanPham.setRowHeight(30);
        tblLoaiSanPham.setShowHorizontalLines(false);
        tblLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSanPhamMouseClicked(evt);
            }
        });
        scrLoaiSanPham.setViewportView(tblLoaiSanPham);
        if (tblLoaiSanPham.getColumnModel().getColumnCount() > 0) {
            tblLoaiSanPham.getColumnModel().getColumn(2).setMaxWidth(40);
            tblLoaiSanPham.getColumnModel().getColumn(3).setMaxWidth(40);
        }

        sdoLoaiSanPham.add(scrLoaiSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 180, 300, 530));

        lblMaLoai.setBackground(new java.awt.Color(255, 255, 255));
        lblMaLoai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaLoai.setForeground(new java.awt.Color(153, 153, 153));
        lblMaLoai.setText("Mã Loại");
        sdoLoaiSanPham.add(lblMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 20));

        lblTenLoai.setBackground(new java.awt.Color(255, 255, 255));
        lblTenLoai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTenLoai.setForeground(new java.awt.Color(153, 153, 153));
        lblTenLoai.setText("Tên Loại");
        sdoLoaiSanPham.add(lblTenLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 60, 20));

        txtTenLoai.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTenLoai.setForeground(new java.awt.Color(62, 73, 95));
        txtTenLoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sdoLoaiSanPham.add(txtTenLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, 20));

        lblLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiSanPham.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblLoaiSanPham.setForeground(new java.awt.Color(62, 73, 95));
        lblLoaiSanPham.setText("LOẠI SẢN PHẨM");
        sdoLoaiSanPham.add(lblLoaiSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        txtMaLoai.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtMaLoai.setForeground(new java.awt.Color(62, 73, 95));
        txtMaLoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sdoLoaiSanPham.add(txtMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 60, 20));

        lblThemLoai.setBackground(new java.awt.Color(255, 255, 255));
        lblThemLoai.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblThemLoai.setForeground(new java.awt.Color(33, 150, 243));
        lblThemLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (1).png"))); // NOI18N
        lblThemLoai.setText("Thêm");
        lblThemLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemLoaiMouseClicked(evt);
            }
        });
        sdoLoaiSanPham.add(lblThemLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sdoLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sdoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblThemHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemHangMouseClicked
        // TODO add your handling code here:
        addSanPham();
        loadSanPham();
    }//GEN-LAST:event_lblThemHangMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tblSanPham.getSelectedRow();
        int column = tblSanPham.getSelectedColumn();
        if (column < 6) {
            fillSanPham(row);
        } else if (column == 6) {
            if (!GUI_frm_Menu.auThenTiCaTion()) {
                return;
            } else {
                editSanPham();
                loadSanPham();
            }
        } else if (column == 7) {
            if (!GUI_frm_Menu.auThenTiCaTion()) {
                return;
            } else {
                deleteSanPham(row);
                loadSanPham();
            }
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSanPhamMouseClicked
        // TODO add your handling code here:        
        int row = tblLoaiSanPham.getSelectedRow();
        int column = tblLoaiSanPham.getSelectedColumn();
        if (column < 2) {
            fillLoaiSanPham(row);
        } else if (column == 2) {
            if (!GUI_frm_Menu.auThenTiCaTion()) {
                return;
            } else {
                editLoaiSanPham();
                loadLoaiSanPham();
                loadTenLoaiSanPham();
            }
        } else if (column == 3) {
            if (!GUI_frm_Menu.auThenTiCaTion()) {
                return;
            } else {
                deleteLoaiSanPham(row);
                loadLoaiSanPham();
                loadTenLoaiSanPham();
            }
        }
    }//GEN-LAST:event_tblLoaiSanPhamMouseClicked

    private void lblThemLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemLoaiMouseClicked
        // TODO add your handling code here:
        addLoaiSanPham();
        loadLoaiSanPham();
        loadTenLoaiSanPham();
    }//GEN-LAST:event_lblThemLoaiMouseClicked

    private void lblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTimKiemMouseClicked

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboDonVi;
    private javax.swing.JComboBox<String> cboLoaiHang;
    private javax.swing.JLabel lblDonVi;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblLoaiHang;
    private javax.swing.JLabel lblLoaiSanPham;
    private javax.swing.JLabel lblMaHang;
    private javax.swing.JLabel lblMaLoai;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblSetNgayTao;
    private javax.swing.JLabel lblTenHang;
    private javax.swing.JLabel lblTenLoai;
    private javax.swing.JLabel lblThemHang;
    private javax.swing.JLabel lblThemLoai;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JScrollPane scrLoaiSanPham;
    private javax.swing.JScrollPane scrSanPham;
    private LIB.PanelShadow sdoLoaiSanPham;
    private LIB.PanelShadow sdoSanPham;
    private javax.swing.JTable tblLoaiSanPham;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaHang;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtTenHang;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
