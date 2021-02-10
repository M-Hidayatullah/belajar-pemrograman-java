
package Problem_Buku;

import static java.lang.System.exit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


/**
 *
 * @author DAYAT-dev
 */
public class view extends javax.swing.JFrame {

//    ambil objek dari control
    Control pb = new Control();

    private boolean TAG = true;
   

    
    public view() {
        initComponents();
//     memanggil read untuk langsung dijalankan di constractor
        clear();
        
//        MEMANGGIL METHOD WAKTU
        waktu();
        
    }

//    untuk menghapus data yang diinputan
    private void clear() {
        TAG = true;
        tfKODEBUKU.setEnabled(true);
        tfKODEBUKU.setText("");   
        tfJUDULBUKU.setText("");
        tfHARGA.setText("");
        tfPENULIS.setText("");
        tfPENERBIT.setText("");
        tfTAHUNTERBIT.setText(""); 
        
        

        read();
    }

//    menampilkan data pada tabel
    private void read() {
        pb.read(tblBUKU);

    }

    private boolean validasi() {
        if (tfKODEBUKU.getText().isEmpty()
                || tfJUDULBUKU.getText().isEmpty()
                || tfPENULIS.getText().isEmpty()
                || tfPENERBIT.getText().isEmpty()
                || tfPENERBIT.getText().isEmpty()
                || tfTAHUNTERBIT.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void save() {
        if (validasi()) {
            if (TAG) {
                create(); // true
            } else {
                update(); // false 
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Inptan belum diisi!");
        }
    }

    private void create() {
        model b = new model();
        b.setKODE_BUKU(Integer.valueOf(tfKODEBUKU.getText()));
        b.setJUDUL_BUKU(tfJUDULBUKU.getText().trim());
        b.setJENIS_BUKU(cbPILIH.getSelectedItem().toString());
        b.setHARGA(tfHARGA.getText().trim());
        b.setPENULIS(tfPENULIS.getText());
        b.setPENERBIT(tfPENERBIT.getText());
        b.setTAHUN_TERBIT(Integer.valueOf(tfTAHUNTERBIT.getText()));
        pb.create(b);

        clear();
    }

    private void update() {
        model b = new model();
        b.setKODE_BUKU(Integer.valueOf(tfKODEBUKU.getText()));
        b.setJUDUL_BUKU(tfJUDULBUKU.getText().trim());
        b.setJENIS_BUKU(cbPILIH.getSelectedItem().toString());
        b.setHARGA(tfHARGA.getText().trim());
        b.setPENULIS(tfPENULIS.getText());
        b.setPENERBIT(tfPENERBIT.getText());
        b.setTAHUN_TERBIT(Integer.valueOf(tfTAHUNTERBIT.getText()));        
        pb.update(b);

        clear();
    }

    private void loadData() {
        int select = tblBUKU.getSelectedRowCount();

        if (select == 0) {
            JOptionPane.showMessageDialog(rootPane, "Data Belum Dipilih!");
        } else {

            int pilih = JOptionPane.NO_OPTION;
            pilih = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin Ubah!",
                    "Informasi", JOptionPane.YES_NO_OPTION, 2);

            if (pilih == JOptionPane.YES_OPTION) {
                int baris = tblBUKU.getSelectedRow();
                tfKODEBUKU.setText(tblBUKU.getValueAt(baris, 0).toString());
                tfJUDULBUKU.setText(tblBUKU.getValueAt(baris, 1).toString());
                tfHARGA.setText(tblBUKU.getValueAt(baris, 3).toString());
                tfPENULIS.setText(tblBUKU.getValueAt(baris, 4).toString());
                tfPENERBIT.setText(tblBUKU.getValueAt(baris, 5).toString());
                tfTAHUNTERBIT.setText(tblBUKU.getValueAt(baris, 6).toString());
                

                tfKODEBUKU.setEnabled(false);
            }
        }
    }

    private void DONE() {
        TAG = false;
        save();

    }
    
    private void delete() {
        int select = tblBUKU.getSelectedRowCount();

        if (select == 0) {
            JOptionPane.showMessageDialog(rootPane, "Data Belum Dipilih!");
        } else {

            int pilih = JOptionPane.NO_OPTION;
            pilih = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin Hapus!",
                    "Informasi", JOptionPane.YES_NO_OPTION, 2);

            if (pilih == JOptionPane.YES_OPTION) {
                int baris = tblBUKU.getSelectedRow();

                String JUDUL_BUKU = tblBUKU.getValueAt(baris, 1).toString();
                System.out.println(JUDUL_BUKU);
                pb.delete(JUDUL_BUKU);

                clear();
            }
        }
    }

    private void search() {
        if (tfCARIDATA.getText().isEmpty()) {
            clear();
        } else {
            if (!pb.search(tblBUKU, tfCARIDATA.getText())) {
                JOptionPane.showMessageDialog(rootPane, " Data yang kamu cari tidak ada!");
            };
        }
    }
        private void CLEAR(){
              tfKODEBUKU.setText(null);
              tfJUDULBUKU.setText(null);
              tfPENULIS.setText(null);
              tfPENERBIT.setText(null);
              tfTAHUNTERBIT.setText(null);
              tfCARIDATA.setText(null);
            
        }
        
        private void menubar(){
            int x=  JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin ingin keluar","Keluar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        //yes = 0
      ///no =1
      if (x==0){
          System.exit(0);
//          KELUAR DARI PROGRAM
      }
        }
        
        private void menubarinfo(){
             JOptionPane.showMessageDialog(this, "APLIKASI PENDATAAN BUKU FUNGSINYA MENDATA BUKU DARI PERPUSTAKAAN\n"
        + "VERSI 1.0\n"
        + "OLEH : M.HIDAYATULLAH");
        }
        
        private void btnexit(){
         int x =  JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin ingin keluar","LOGOUT",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        //yes = 0
      ///no =1
      if (x==0){
          System.exit(0);
//          KELUAR DARI PROGRAM 
      }
        }
        private void login(){
//            KONEKSI KE FORM LOGIN
             new FormLogin().show();
            this.dispose();
        }
        
        
        private void waktu(){
             Calendar cal = new GregorianCalendar();
//             untuk tanggal
        int tanggal =cal.get(Calendar.DAY_OF_MONTH);
        int bulan =cal.get(Calendar.MONTH)+1;
        int tahun =cal.get(Calendar.YEAR);
        
        TANGGAL.setText("TANGGAL: "+tanggal+ "-" +bulan+ "-" +tahun); 
        
//        untuk jam
        int jam =cal.get(Calendar.HOUR);
        int menit =cal.get(Calendar.MINUTE);
        int detik =cal.get(Calendar.SECOND);
       
        
        JAM.setText("JAM: "+jam+ ":" +menit+ ":" +detik);
        }
        
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfJUDULBUKU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPENULIS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPENERBIT = new javax.swing.JTextField();
        btnHAPUS = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        btnUBAH = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfCARIDATA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfKODEBUKU = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBUKU = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tfTAHUNTERBIT = new javax.swing.JTextField();
        btnEDIT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbPILIH = new javax.swing.JComboBox<>();
        btnEXIT = new javax.swing.JToggleButton();
        btnLOGIN = new javax.swing.JButton();
        TANGGAL = new javax.swing.JLabel();
        JAM = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfHARGA = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFILE = new javax.swing.JMenu();
        menubarkeluar = new javax.swing.JMenuItem();
        menubarNEW = new javax.swing.JMenuItem();
        jMenuHELP = new javax.swing.JMenu();
        menubarINFO = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("{PENDATAAN BUKU}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("JUDUL BUKU");

        tfJUDULBUKU.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PENULIS");

        tfPENULIS.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("PENERBIT");

        tfPENERBIT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfPENERBIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPENERBITActionPerformed(evt);
            }
        });

        btnHAPUS.setBackground(new java.awt.Color(51, 0, 255));
        btnHAPUS.setForeground(new java.awt.Color(255, 255, 255));
        btnHAPUS.setText("HAPUS");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        btnSIMPAN.setBackground(new java.awt.Color(0, 0, 204));
        btnSIMPAN.setForeground(new java.awt.Color(255, 255, 255));
        btnSIMPAN.setText("SIMPAN");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        btnUBAH.setBackground(new java.awt.Color(0, 51, 204));
        btnUBAH.setForeground(new java.awt.Color(255, 255, 255));
        btnUBAH.setText("UBAH");
        btnUBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUBAHActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("SEARCH");

        tfCARIDATA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfCARIDATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCARIDATAActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("KODE BUKU");

        tfKODEBUKU.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfKODEBUKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKODEBUKUActionPerformed(evt);
            }
        });

        tblBUKU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblBUKU);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("TAHUN TERBIT");

        tfTAHUNTERBIT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfTAHUNTERBIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTAHUNTERBITActionPerformed(evt);
            }
        });

        btnEDIT.setBackground(new java.awt.Color(0, 0, 204));
        btnEDIT.setForeground(new java.awt.Color(255, 255, 255));
        btnEDIT.setText("DONE");
        btnEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("JENIS BUKU");

        cbPILIH.setForeground(new java.awt.Color(51, 51, 255));
        cbPILIH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-PILIH-", "BUKU IT", "BUKU SAINS", "BUKU MTK", "BUKU AGAMA", "PENDIDIKAN", "-LAINNYA." }));

        btnEXIT.setBackground(new java.awt.Color(255, 255, 0));
        btnEXIT.setForeground(new java.awt.Color(0, 0, 255));
        btnEXIT.setText("LOGOUT");
        btnEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXITActionPerformed(evt);
            }
        });

        btnLOGIN.setBackground(new java.awt.Color(255, 255, 0));
        btnLOGIN.setForeground(new java.awt.Color(0, 0, 255));
        btnLOGIN.setText("LOGIN");
        btnLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGINActionPerformed(evt);
            }
        });

        TANGGAL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TANGGAL.setForeground(new java.awt.Color(255, 0, 51));
        TANGGAL.setText("TANGGAL");

        JAM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        JAM.setForeground(new java.awt.Color(255, 0, 0));
        JAM.setText("JAM");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("HARGA");

        tfHARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHARGAActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 51));

        jMenuFILE.setText("FILE");

        menubarkeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menubarkeluar.setText("EXIT ");
        menubarkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubarkeluarActionPerformed(evt);
            }
        });
        jMenuFILE.add(menubarkeluar);

        menubarNEW.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menubarNEW.setText("NEW TEXT");
        menubarNEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubarNEWActionPerformed(evt);
            }
        });
        jMenuFILE.add(menubarNEW);

        jMenuBar1.add(jMenuFILE);

        jMenuHELP.setText("HELP");

        menubarINFO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        menubarINFO.setText("INFO");
        menubarINFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubarINFOActionPerformed(evt);
            }
        });
        jMenuHELP.add(menubarINFO);

        jMenuBar1.add(jMenuHELP);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(TANGGAL)
                        .addGap(27, 27, 27)
                        .addComponent(JAM))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfHARGA, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(39, 39, 39)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbPILIH, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfJUDULBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfKODEBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(tfPENULIS, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfTAHUNTERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEXIT)
                        .addGap(34, 34, 34)
                        .addComponent(btnSIMPAN)
                        .addGap(40, 40, 40)
                        .addComponent(btnUBAH)
                        .addGap(32, 32, 32)
                        .addComponent(btnEDIT)
                        .addGap(32, 32, 32)
                        .addComponent(btnHAPUS)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCARIDATA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLOGIN)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfKODEBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(tfJUDULBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(cbPILIH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TANGGAL)
                            .addComponent(JAM))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfHARGA, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPENULIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEXIT)
                            .addComponent(btnSIMPAN)
                            .addComponent(btnUBAH)
                            .addComponent(btnEDIT)
                            .addComponent(btnHAPUS)
                            .addComponent(btnLOGIN)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCARIDATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfTAHUNTERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        // TODO add your handling code here:
        save();
//        fungsi untuk menyimpan data 
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUBAHActionPerformed
        // TODO add your handling code here:
        loadData();
//        fungsi mengubah data
    }//GEN-LAST:event_btnUBAHActionPerformed

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        // TODO add your handling code here:
        delete();
//        mengahpus data di tabel
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void tfCARIDATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCARIDATAActionPerformed
        // TODO add your handling code here:
        search();
//        mencari data dengan nama buku di tabel
    }//GEN-LAST:event_tfCARIDATAActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed
        // TODO add your handling code here:
        DONE();
//        Menyimpan data yang telah di ubah
    }//GEN-LAST:event_btnEDITActionPerformed

    private void btnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXITActionPerformed
        btnexit();
    
    }//GEN-LAST:event_btnEXITActionPerformed

    private void menubarkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubarkeluarActionPerformed
      menubar();
      
    }//GEN-LAST:event_menubarkeluarActionPerformed

    private void menubarINFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubarINFOActionPerformed
       menubarinfo();
    }//GEN-LAST:event_menubarINFOActionPerformed

    private void menubarNEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubarNEWActionPerformed
        CLEAR();
//        MENGHAPUS SEMUA INPUTAN DI TEXFIELD
    }//GEN-LAST:event_menubarNEWActionPerformed

    private void tfKODEBUKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKODEBUKUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKODEBUKUActionPerformed

    private void btnLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGINActionPerformed
        login();
    }//GEN-LAST:event_btnLOGINActionPerformed

    private void tfHARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHARGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHARGAActionPerformed

    private void tfPENERBITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPENERBITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPENERBITActionPerformed

    private void tfTAHUNTERBITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTAHUNTERBITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTAHUNTERBITActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JAM;
    private javax.swing.JLabel TANGGAL;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JToggleButton btnEXIT;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnLOGIN;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnUBAH;
    private javax.swing.JComboBox<String> cbPILIH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFILE;
    private javax.swing.JMenu jMenuHELP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menubarINFO;
    private javax.swing.JMenuItem menubarNEW;
    private javax.swing.JMenuItem menubarkeluar;
    private javax.swing.JTable tblBUKU;
    private javax.swing.JTextField tfCARIDATA;
    private javax.swing.JTextField tfHARGA;
    private javax.swing.JTextField tfJUDULBUKU;
    private javax.swing.JTextField tfKODEBUKU;
    private javax.swing.JTextField tfPENERBIT;
    private javax.swing.JTextField tfPENULIS;
    private javax.swing.JTextField tfTAHUNTERBIT;
    // End of variables declaration//GEN-END:variables
}
