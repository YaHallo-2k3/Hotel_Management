/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_LoaiPhong;
import BLL.BLL_MaTenLoai;
import BLL.BLL_Phong;
import BLL.BLL_SoTang;
import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;
import DTO.DTO_SoTang;
import HELPER.HELPER_ChuyenDoi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author CherryCe
 */
public class GUI_pnl_ThietDatPhong extends javax.swing.JPanel {

    /**
     * Creates new form GUI_pnl_ThietDatPhong
     */
    public GUI_pnl_ThietDatPhong() {
        initComponents();
        loadSoTang();
        loadTenTang();
        loadLoaiPhong();
        loadTenLoaiPhong();
        loadPhong();
        formatSTT();
    }

    public void addSoTang() {
        DTO_SoTang soTang = new DTO_SoTang(txtMaTang.getText(), txtTenTang.getText());
        BLL_SoTang.add(soTang);
    }

    public void deleteSoTang(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Xóa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                int indexs[] = tblTang.getSelectedRows();
                for (int i = 0; i < indexs.length; i++) {
                    String maTang = tblTang.getValueAt(indexs[i], 0).toString();
                    BLL_SoTang.delete(maTang);
                }
            }
            return;
        }
    }

    public void editSoTang(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        }
        DTO_SoTang soTang = new DTO_SoTang(txtMaTang.getText(), txtTenTang.getText());
        BLL_SoTang.edit(soTang);
    }

    public void fillSoTang(int index) {
        txtMaTang.setText(tblTang.getValueAt(index, 0).toString());
        txtTenTang.setText(tblTang.getValueAt(index, 1).toString());
    }

    public void loadSoTang() {
        ArrayList<DTO_SoTang> array = BLL_SoTang.select();
        new BLL_SoTang().load(array, tblTang);
    }

    public void loadTenTang() {
        ArrayList<DTO_SoTang> array = BLL_MaTenLoai.selectTenTang();
        BLL_MaTenLoai.loadTenTang(array, cboTang);
    }

    public void addLoaiPhong() {
        DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong(txtMaLoaiPhong.getText(), txtTenLoaiPhong.getText(), HELPER_ChuyenDoi.getSoInt(txtGiaGio.getText()), HELPER_ChuyenDoi.getSoInt(txtGiaNgay.getText()), HELPER_ChuyenDoi.getSoInt(txtSoGiuong.getText()), HELPER_ChuyenDoi.getSoInt(txtSoNguoi.getText()));
        BLL_LoaiPhong.add(loaiPhong);
    }

    public void deleteLoaiPhong(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Xóa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                int indexs[] = tblLoaiPhong.getSelectedRows();
                for (int i = 0; i < indexs.length; i++) {
                    String maLoaiPhong = tblLoaiPhong.getValueAt(indexs[i], 0).toString();
                    BLL_LoaiPhong.delete(maLoaiPhong);
                }
            }
            return;
        }
    }

    public void editLoaiPhong(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        }
        DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong(txtMaLoaiPhong.getText(), txtTenLoaiPhong.getText(), HELPER_ChuyenDoi.getSoInt(txtGiaGio.getText()), HELPER_ChuyenDoi.getSoInt(txtGiaNgay.getText()), HELPER_ChuyenDoi.getSoInt(txtSoGiuong.getText()), HELPER_ChuyenDoi.getSoInt(txtSoNguoi.getText()));
        BLL_LoaiPhong.edit(loaiPhong);
    }

    public void fillLoaiPhong(int index) {
        txtMaLoaiPhong.setText(tblLoaiPhong.getValueAt(index, 0).toString());
        txtTenLoaiPhong.setText(tblLoaiPhong.getValueAt(index, 1).toString());
        txtGiaGio.setText(tblLoaiPhong.getValueAt(index, 2).toString());
        txtGiaNgay.setText(tblLoaiPhong.getValueAt(index, 3).toString());
        txtSoGiuong.setText(tblLoaiPhong.getValueAt(index, 4).toString());
        txtSoNguoi.setText(tblLoaiPhong.getValueAt(index, 5).toString());
    }

    public void loadLoaiPhong() {
        ArrayList<DTO_LoaiPhong> array = BLL_LoaiPhong.select();
        new BLL_LoaiPhong().load(array, tblLoaiPhong);
    }

    public void loadTenLoaiPhong() {
        ArrayList<DTO_LoaiPhong> array = BLL_MaTenLoai.selectTenLoaiPhong();
        BLL_MaTenLoai.loadTenLoaiPhong(array, cboLoaiPhong);
    }

    public void addPhong() {
        DTO_Phong phong = new DTO_Phong(txtMaPhong.getText(), txtTenPhong.getText(), String.valueOf(cboTang.getSelectedItem()), String.valueOf(cboLoaiPhong.getSelectedItem()), "Phòng Trống");
        BLL_Phong.add(phong);
    }

    public void deletePhong(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Xóa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                int indexs[] = tblPhong.getSelectedRows();
                for (int i = 0; i < indexs.length; i++) {
                    String maPhong = tblPhong.getValueAt(indexs[i], 1).toString();
                    BLL_Phong.delete(maPhong);
                }
            }
            return;
        }
    }

    public void editPhong(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Dòng Cần Sửa");
        }
        DTO_Phong phong = new DTO_Phong(txtMaPhong.getText(), txtTenPhong.getText(), String.valueOf(cboTang.getSelectedItem()), String.valueOf(cboLoaiPhong.getSelectedItem()), "Có Khách");
        BLL_Phong.edit(phong);
    }

    public void fillPhong(int index) {
        lblSetSTT.setText(tblPhong.getValueAt(index, 0).toString());
        txtMaPhong.setText(tblPhong.getValueAt(index, 1).toString());
        txtTenPhong.setText(tblPhong.getValueAt(index, 2).toString());
        cboTang.setSelectedItem(tblPhong.getValueAt(index, 3).toString());
        cboLoaiPhong.setSelectedItem(tblPhong.getValueAt(index, 4).toString());
    }

    public void loadPhong() {
        ArrayList<DTO_Phong> array = BLL_Phong.select();
        new BLL_Phong().load(array, tblPhong);
    }
    
    public void formatSTT() {
        for (int i = 0; i < tblPhong.getRowCount(); i++) {
            tblPhong.setValueAt(i + 1, i, 0);
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

        sdoTang = new HELPER.PanelShadow();
        lblMaTang = new javax.swing.JLabel();
        lblTenTang = new javax.swing.JLabel();
        txtTenTang = new javax.swing.JTextField();
        txtMaTang = new javax.swing.JTextField();
        scrTang = new javax.swing.JScrollPane();
        tblTang = new javax.swing.JTable();
        lblThietDatSoTang = new javax.swing.JLabel();
        lblThemTang = new javax.swing.JLabel();
        sdoPhong = new HELPER.PanelShadow();
        lblTang = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblTenPhong = new javax.swing.JLabel();
        lblThietDatPhong = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        scrPhong = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        lblThemPhong = new javax.swing.JLabel();
        lblSTT = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        cboLoaiPhong = new javax.swing.JComboBox<>();
        cboTang = new javax.swing.JComboBox<>();
        lblSetSTT = new javax.swing.JLabel();
        sdoLoaiPhong = new HELPER.PanelShadow();
        lblSoNguoi = new javax.swing.JLabel();
        lblMaLoaiPhong = new javax.swing.JLabel();
        lblTenLoaiPhong = new javax.swing.JLabel();
        lblThietDatLoaiPhong = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();
        txtSoNguoi = new javax.swing.JTextField();
        txtMaLoaiPhong = new javax.swing.JTextField();
        scrLoaiPhong = new javax.swing.JScrollPane();
        tblLoaiPhong = new javax.swing.JTable();
        lblThemLoaiPhong = new javax.swing.JLabel();
        lblGiaGio = new javax.swing.JLabel();
        lblGiaNgay = new javax.swing.JLabel();
        lblSoGiuong = new javax.swing.JLabel();
        txtGiaGio = new javax.swing.JTextField();
        txtGiaNgay = new javax.swing.JTextField();
        txtSoGiuong = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 730));
        setPreferredSize(new java.awt.Dimension(1150, 730));

        sdoTang.setBackground(new java.awt.Color(255, 255, 255));
        sdoTang.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoTang.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoTang.setShadowOpacity(0.3F);
        sdoTang.setShadowType(HELPER.ShadowType.BOT_RIGHT);
        sdoTang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaTang.setBackground(new java.awt.Color(255, 255, 255));
        lblMaTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaTang.setForeground(new java.awt.Color(153, 153, 153));
        lblMaTang.setText("Mã Tầng");
        sdoTang.add(lblMaTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 7, 60, 30));

        lblTenTang.setBackground(new java.awt.Color(255, 255, 255));
        lblTenTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTenTang.setForeground(new java.awt.Color(153, 153, 153));
        lblTenTang.setText("Tên Tầng");
        sdoTang.add(lblTenTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 70, 30));

        txtTenTang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTenTang.setForeground(new java.awt.Color(62, 73, 95));
        txtTenTang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTangActionPerformed(evt);
            }
        });
        sdoTang.add(txtTenTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 80, 20));

        txtMaTang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtMaTang.setForeground(new java.awt.Color(62, 73, 95));
        txtMaTang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTangActionPerformed(evt);
            }
        });
        sdoTang.add(txtMaTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, 20));

        tblTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblTang.setForeground(new java.awt.Color(62, 73, 95));
        tblTang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Tầng", "Tên Tầng", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTang.setRowHeight(30);
        tblTang.setShowHorizontalLines(false);
        tblTang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTangMouseClicked(evt);
            }
        });
        scrTang.setViewportView(tblTang);
        if (tblTang.getColumnModel().getColumnCount() > 0) {
            tblTang.getColumnModel().getColumn(2).setMaxWidth(40);
            tblTang.getColumnModel().getColumn(3).setMaxWidth(40);
        }

        sdoTang.add(scrTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 370, 120));

        lblThietDatSoTang.setBackground(new java.awt.Color(255, 255, 255));
        lblThietDatSoTang.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblThietDatSoTang.setForeground(new java.awt.Color(62, 73, 95));
        lblThietDatSoTang.setText("SỐ TẦNG");
        sdoTang.add(lblThietDatSoTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        lblThemTang.setBackground(new java.awt.Color(255, 255, 255));
        lblThemTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThemTang.setForeground(new java.awt.Color(33, 150, 243));
        lblThemTang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (1).png"))); // NOI18N
        lblThemTang.setText("Thêm");
        lblThemTang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemTangMouseClicked(evt);
            }
        });
        sdoTang.add(lblThemTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 60, 30));

        sdoPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoPhong.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoPhong.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoPhong.setShadowOpacity(0.3F);
        sdoPhong.setShadowType(HELPER.ShadowType.BOT_RIGHT);
        sdoPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTang.setBackground(new java.awt.Color(255, 255, 255));
        lblTang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTang.setForeground(new java.awt.Color(153, 153, 153));
        lblTang.setText("Tầng");
        sdoPhong.add(lblTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 60, 30));

        lblLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblLoaiPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblLoaiPhong.setText("Loại Phòng");
        sdoPhong.add(lblLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 90, 30));

        lblTenPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblTenPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTenPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblTenPhong.setText("Tên Phòng");
        sdoPhong.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 80, 30));

        lblThietDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThietDatPhong.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblThietDatPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblThietDatPhong.setText("THIẾT ĐẶT PHÒNG");
        sdoPhong.add(lblThietDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        txtMaPhong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtMaPhong.setForeground(new java.awt.Color(62, 73, 95));
        txtMaPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });
        sdoPhong.add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 70, 20));

        tblPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblPhong.setForeground(new java.awt.Color(62, 73, 95));
        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Phòng", "Tên Phòng", "Tầng", "Loại Phòng", "Trạng Thái", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.setRowHeight(30);
        tblPhong.setShowHorizontalLines(false);
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        scrPhong.setViewportView(tblPhong);
        if (tblPhong.getColumnModel().getColumnCount() > 0) {
            tblPhong.getColumnModel().getColumn(6).setMaxWidth(40);
            tblPhong.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        sdoPhong.add(scrPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1120, 410));

        lblThemPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThemPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThemPhong.setForeground(new java.awt.Color(33, 150, 243));
        lblThemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (1).png"))); // NOI18N
        lblThemPhong.setText("Thêm");
        lblThemPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemPhongMouseClicked(evt);
            }
        });
        sdoPhong.add(lblThemPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 70, 30));

        lblSTT.setBackground(new java.awt.Color(255, 255, 255));
        lblSTT.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSTT.setForeground(new java.awt.Color(153, 153, 153));
        lblSTT.setText("STT");
        sdoPhong.add(lblSTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 30, 30));

        lblMaPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblMaPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblMaPhong.setText("Mã Phòng");
        sdoPhong.add(lblMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 70, 30));

        txtTenPhong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTenPhong.setForeground(new java.awt.Color(62, 73, 95));
        txtTenPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongActionPerformed(evt);
            }
        });
        sdoPhong.add(txtTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 90, 20));

        cboLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboLoaiPhong.setForeground(new java.awt.Color(62, 73, 95));
        cboLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiPhong.setToolTipText("");
        cboLoaiPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoPhong.add(cboLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 130, 20));

        cboTang.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        cboTang.setForeground(new java.awt.Color(62, 73, 95));
        cboTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTang.setToolTipText("");
        cboTang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoPhong.add(cboTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, 20));

        lblSetSTT.setBackground(new java.awt.Color(255, 255, 255));
        lblSetSTT.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblSetSTT.setForeground(new java.awt.Color(62, 73, 95));
        lblSetSTT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sdoPhong.add(lblSetSTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 40, 20));

        sdoLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        sdoLoaiPhong.setMinimumSize(new java.awt.Dimension(560, 280));
        sdoLoaiPhong.setPreferredSize(new java.awt.Dimension(560, 280));
        sdoLoaiPhong.setShadowOpacity(0.3F);
        sdoLoaiPhong.setShadowType(HELPER.ShadowType.BOT_RIGHT);
        sdoLoaiPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSoNguoi.setBackground(new java.awt.Color(255, 255, 255));
        lblSoNguoi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSoNguoi.setForeground(new java.awt.Color(153, 153, 153));
        lblSoNguoi.setText("Số Người");
        sdoLoaiPhong.add(lblSoNguoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 60, 30));

        lblMaLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblMaLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblMaLoaiPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblMaLoaiPhong.setText("Mã Loại");
        sdoLoaiPhong.add(lblMaLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 50, 30));

        lblTenLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblTenLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTenLoaiPhong.setForeground(new java.awt.Color(153, 153, 153));
        lblTenLoaiPhong.setText("Tên Loại");
        sdoLoaiPhong.add(lblTenLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 60, 30));

        lblThietDatLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThietDatLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lblThietDatLoaiPhong.setForeground(new java.awt.Color(62, 73, 95));
        lblThietDatLoaiPhong.setText("LOẠI PHÒNG");
        sdoLoaiPhong.add(lblThietDatLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txtTenLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtTenLoaiPhong.setForeground(new java.awt.Color(62, 73, 95));
        txtTenLoaiPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiPhongActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtTenLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 80, 20));

        txtSoNguoi.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtSoNguoi.setForeground(new java.awt.Color(62, 73, 95));
        txtSoNguoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSoNguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtSoNguoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 60, 20));

        txtMaLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtMaLoaiPhong.setForeground(new java.awt.Color(62, 73, 95));
        txtMaLoaiPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiPhongActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtMaLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 50, 20));

        tblLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tblLoaiPhong.setForeground(new java.awt.Color(62, 73, 95));
        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Loai", "Tên Loại", "Giá Giờ", "Giá Ngày", "Số Giường", "Số Người", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiPhong.setRowHeight(30);
        tblLoaiPhong.setShowHorizontalLines(false);
        tblLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiPhongMouseClicked(evt);
            }
        });
        scrLoaiPhong.setViewportView(tblLoaiPhong);
        if (tblLoaiPhong.getColumnModel().getColumnCount() > 0) {
            tblLoaiPhong.getColumnModel().getColumn(6).setMaxWidth(40);
            tblLoaiPhong.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        sdoLoaiPhong.add(scrLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 720, 120));

        lblThemLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        lblThemLoaiPhong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblThemLoaiPhong.setForeground(new java.awt.Color(33, 150, 243));
        lblThemLoaiPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add (1).png"))); // NOI18N
        lblThemLoaiPhong.setText("Thêm");
        lblThemLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemLoaiPhongMouseClicked(evt);
            }
        });
        sdoLoaiPhong.add(lblThemLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 60, 30));

        lblGiaGio.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaGio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGiaGio.setForeground(new java.awt.Color(153, 153, 153));
        lblGiaGio.setText("Giá Giờ");
        sdoLoaiPhong.add(lblGiaGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 50, 30));

        lblGiaNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaNgay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblGiaNgay.setForeground(new java.awt.Color(153, 153, 153));
        lblGiaNgay.setText("Giá Ngày");
        sdoLoaiPhong.add(lblGiaNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 60, 30));

        lblSoGiuong.setBackground(new java.awt.Color(255, 255, 255));
        lblSoGiuong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSoGiuong.setForeground(new java.awt.Color(153, 153, 153));
        lblSoGiuong.setText("Số Giường");
        sdoLoaiPhong.add(lblSoGiuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 70, 30));

        txtGiaGio.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtGiaGio.setForeground(new java.awt.Color(62, 73, 95));
        txtGiaGio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiaGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaGioActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtGiaGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 50, 20));

        txtGiaNgay.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtGiaNgay.setForeground(new java.awt.Color(62, 73, 95));
        txtGiaNgay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiaNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNgayActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtGiaNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 60, 20));

        txtSoGiuong.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        txtSoGiuong.setForeground(new java.awt.Color(62, 73, 95));
        txtSoGiuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSoGiuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoGiuongActionPerformed(evt);
            }
        });
        sdoLoaiPhong.add(txtSoGiuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sdoTang, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sdoLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sdoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdoTang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdoLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(sdoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTangActionPerformed

    private void txtMaTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTangActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void txtTenLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLoaiPhongActionPerformed

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void txtMaLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiPhongActionPerformed

    private void txtTenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenPhongActionPerformed

    private void lblThemTangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemTangMouseClicked
        // TODO add your handling code here:
        addSoTang();
        loadSoTang();
        loadTenTang();
    }//GEN-LAST:event_lblThemTangMouseClicked

    private void tblTangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTangMouseClicked
        // TODO add your handling code here:
        int row = tblTang.getSelectedRow();
        int column = tblTang.getSelectedColumn();
        if (tblTang.getValueAt(row, column) != null && tblTang.getValueAt(row, column + 1) != null || tblTang.getValueAt(row, column) != null && tblTang.getValueAt(row, column - 1) != null) {
            fillSoTang(row);
        } else if (tblTang.getValueAt(row, column) == null && tblTang.getValueAt(row, column - 1) != null) {
            editSoTang(row);
            loadSoTang();
            loadTenTang();
        } else if (tblTang.getValueAt(row, column) == null && tblTang.getValueAt(row, column - 1) == null) {
            deleteSoTang(row);
            loadSoTang();
            loadTenTang();
        }
    }//GEN-LAST:event_tblTangMouseClicked

    private void lblThemLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemLoaiPhongMouseClicked
        // TODO add your handling code here:
        addLoaiPhong();
        loadLoaiPhong();
        loadTenLoaiPhong();
    }//GEN-LAST:event_lblThemLoaiPhongMouseClicked

    private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
        // TODO add your handling code here:
        int row = tblLoaiPhong.getSelectedRow();
        int column = tblLoaiPhong.getSelectedColumn();
        if (tblLoaiPhong.getValueAt(row, column) != null && tblLoaiPhong.getValueAt(row, column + 1) != null || tblLoaiPhong.getValueAt(row, column) != null && tblLoaiPhong.getValueAt(row, column - 1) != null) {
            fillLoaiPhong(row);
        } else if (tblLoaiPhong.getValueAt(row, column) == null && tblLoaiPhong.getValueAt(row, column - 1) != null) {
            editLoaiPhong(row);
            loadLoaiPhong();
            loadTenLoaiPhong();
        } else if (tblLoaiPhong.getValueAt(row, column) == null && tblLoaiPhong.getValueAt(row, column - 1) == null) {
            deleteLoaiPhong(row);
            loadLoaiPhong();
            loadTenLoaiPhong();
        }
    }//GEN-LAST:event_tblLoaiPhongMouseClicked

    private void lblThemPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemPhongMouseClicked
        // TODO add your handling code here:
        addPhong();
        loadPhong();
        formatSTT();
    }//GEN-LAST:event_lblThemPhongMouseClicked

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        // TODO add your handling code here:
        int row = tblPhong.getSelectedRow();
        int column = tblPhong.getSelectedColumn();
        if (tblPhong.getValueAt(row, column) != null && tblPhong.getValueAt(row, column + 1) != null || tblPhong.getValueAt(row, column) != null && tblPhong.getValueAt(row, column - 1) != null) {
            fillPhong(row);
        } else if (tblPhong.getValueAt(row, column) == null && tblPhong.getValueAt(row, column - 1) != null) {
            editPhong(row);
            loadPhong();
            formatSTT();
        } else if (tblPhong.getValueAt(row, column) == null && tblPhong.getValueAt(row, column - 1) == null) {
            deletePhong(row);
            loadPhong();
            formatSTT();
        }
    }//GEN-LAST:event_tblPhongMouseClicked

    private void txtGiaGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaGioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaGioActionPerformed

    private void txtGiaNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNgayActionPerformed

    private void txtSoGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoGiuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoGiuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLoaiPhong;
    private javax.swing.JComboBox<String> cboTang;
    private javax.swing.JLabel lblGiaGio;
    private javax.swing.JLabel lblGiaNgay;
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblMaLoaiPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblMaTang;
    private javax.swing.JLabel lblSTT;
    private javax.swing.JLabel lblSetSTT;
    private javax.swing.JLabel lblSoGiuong;
    private javax.swing.JLabel lblSoNguoi;
    private javax.swing.JLabel lblTang;
    private javax.swing.JLabel lblTenLoaiPhong;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JLabel lblTenTang;
    private javax.swing.JLabel lblThemLoaiPhong;
    private javax.swing.JLabel lblThemPhong;
    private javax.swing.JLabel lblThemTang;
    private javax.swing.JLabel lblThietDatLoaiPhong;
    private javax.swing.JLabel lblThietDatPhong;
    private javax.swing.JLabel lblThietDatSoTang;
    private javax.swing.JScrollPane scrLoaiPhong;
    private javax.swing.JScrollPane scrPhong;
    private javax.swing.JScrollPane scrTang;
    private HELPER.PanelShadow sdoLoaiPhong;
    private HELPER.PanelShadow sdoPhong;
    private HELPER.PanelShadow sdoTang;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTable tblTang;
    private javax.swing.JTextField txtGiaGio;
    private javax.swing.JTextField txtGiaNgay;
    private javax.swing.JTextField txtMaLoaiPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMaTang;
    private javax.swing.JTextField txtSoGiuong;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTenLoaiPhong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTenTang;
    // End of variables declaration//GEN-END:variables
}
