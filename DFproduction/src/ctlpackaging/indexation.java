package ctlpackaging;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class indexation extends javax.swing.JFrame {
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;

    Connecter conn=new Connecter();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    private String tmp;
    private String ListJList;
    private String ListJList15;
    private String ListJList21;
    private String ListJList22;
    private String ListJList23;
    public static String AddElement = null;
    public static String PageIndex = null;
    
    public indexation() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Indexation de fichier");
                                            
        RecupFichier.setCurrentSoftware("Production", "main");


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX(); //Position X de la souris au clic
                posY = e.getY(); //Position Y de la souris au clic
            }
        });
         
        addMouseMotionListener(new MouseMotionAdapter() {
            // A chaque deplacement on recalcul le positionnement de la fenetre
            @Override
            public void mouseDragged(MouseEvent e) {
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                setLocation(getX()+depX, getY()+depY);
            }
        });
        afficher();
        this.TablLIer();
        rempList();
      
    String nom_string = main.test_txt.getText();
    String AntiApo = null;
    AntiApo = nom_string;
    AntiApo = AntiApo.replaceAll("\\\\'","\'");
    
    //nom_string = nom_string.replaceAll("\\\\'","\'");
    fichier_show.setText(AntiApo);
    
    String cheminseul_string = main.cheminseul_txt.getText(); 
    //cheminseul_string = cheminseul_string.replaceAll("\\\\'","\'");
    chemin_show.setText(cheminseul_string);
    String version = searchVersion(AntiApo);
    System.out.println(version);
    jVersion.setText(searchVersion(version));
    } 
    
    private indexation(Runnable aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fichier_show = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chemin_show = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jScrollPane23 = new javax.swing.JScrollPane();
        jList23 = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jVersion = new javax.swing.JTextField();
        btnAddN1 = new javax.swing.JButton();
        txtAddN1 = new javax.swing.JTextField();
        btnAddAtelier = new javax.swing.JButton();
        btnAddGFH = new javax.swing.JButton();
        btnAddMachine = new javax.swing.JButton();
        btnAddSE = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(249, 411));

        jPanel6.setBackground(new java.awt.Color(0, 136, 198));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/add_24px.png"))); // NOI18N
        jLabel21.setText("INDEXER UN FICHIER");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(0, 86, 172));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/search_more_24px.png"))); // NOI18N
        jLabel22.setText("RECHERCHER UN FICHIER");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 86, 172));

        jLabel20.setBackground(new java.awt.Color(0, 136, 198));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/home_24px.png"))); // NOI18N
        jLabel20.setText("ACCUEIL");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 86, 172));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/settings_24px.png"))); // NOI18N
        jLabel23.setText("OPTIONS");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(0, 86, 172));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/sign_out_24px.png"))); // NOI18N
        jLabel24.setText("QUITTER");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/new_file_24px.png"))); // NOI18N
        jLabel3.setText("DocFinder");

        jPanel18.setBackground(new java.awt.Color(0, 136, 198));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(0, 136, 198));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/processor_24px.png"))); // NOI18N
        jLabel26.setText("MODE PRODUCTION");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(0, 86, 172));
        jPanel19.setPreferredSize(new java.awt.Dimension(210, 45));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel19MouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/full_tool_storage_box_24px.png"))); // NOI18N
        jLabel27.setText("MODE TECHNIQUE");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        jPanel3.setBackground(new java.awt.Color(98, 173, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/pin_50px.png"))); // NOI18N
        jLabel7.setText(" INDEXER UN FICHIER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(24, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/multiply_24px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setMinimumSize(new java.awt.Dimension(24, 24));
        jPanel5.setPreferredSize(new java.awt.Dimension(24, 24));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/compress_24px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        fichier_show.setEditable(false);
        fichier_show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CHEMIN COMPLET :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NOM DU FICHIER :");

        chemin_show.setEditable(false);
        chemin_show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chemin_show.setPreferredSize(new java.awt.Dimension(579, 26));

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList14.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList14ValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(jList14);

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList15.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList15ValueChanged(evt);
            }
        });
        jScrollPane15.setViewportView(jList15);

        jScrollPane21.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList21.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList21ValueChanged(evt);
            }
        });
        jScrollPane21.setViewportView(jList21);

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList22.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList22ValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(jList22);

        jScrollPane23.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList23.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList23ValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(jList23);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("VERSION :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Atelier :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Machine :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Sous-ensemble :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("GFH - Ligne : ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/add_24px.png"))); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jVersion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jVersion.setPreferredSize(new java.awt.Dimension(579, 26));

        btnAddN1.setText("+");
        btnAddN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN1ActionPerformed(evt);
            }
        });

        txtAddN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN1MouseReleased(evt);
            }
        });

        btnAddAtelier.setText("+");
        btnAddAtelier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAtelierActionPerformed(evt);
            }
        });

        btnAddGFH.setText("+");
        btnAddGFH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGFHActionPerformed(evt);
            }
        });

        btnAddMachine.setText("+");
        btnAddMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMachineActionPerformed(evt);
            }
        });

        btnAddSE.setText("+");
        btnAddSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSEActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Type de document N1 :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddAtelier))
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAddGFH)))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAddMachine)))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAddSE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fichier_show)
                                                .addComponent(chemin_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnAddSE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddN1)
                            .addComponent(jLabel19)
                            .addComponent(btnAddGFH)
                            .addComponent(jLabel17)
                            .addComponent(btnAddMachine)
                            .addComponent(jLabel18))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddAtelier)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane22))))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fichier_show, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chemin_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
      
    private String searchVersion(String fichier){
        final String SEPARATEUR = " ";
        String mots[] = fichier.split(SEPARATEUR);
 
        for (String mot : mots) {
            System.out.println(mot.length());
            
            if(mot.length()>=2){
                String premierCaractere = Character.toString(mot.charAt(0));
                String deuxiemeCaractere = Character.toString(mot.charAt(1));
                System.out.println("premierCaractere "+premierCaractere);
                System.out.println("deuxiemeCaractere "+deuxiemeCaractere);
                boolean Test = isNumeric(deuxiemeCaractere); 
                if(((premierCaractere.equals("v")) && (Test == true)) || (premierCaractere.equals("V")) && (Test == true)){
                    mot = mot.replaceAll("[^\\d.]", "");
                    String dernierCharac = Character.toString(mot.charAt(mot.length()-1));
                    if (dernierCharac.equals(".")){
                        mot = mot.substring(0, mot.length() - 1);
                    }
                    mot = "V"+mot;
                    //System.out.println(mot);
                    return mot;
                }
            }
        }
        return "";
    }
    
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
  }
    private void afficher(){
        try {
                    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    stm=conn.obtenirconnexion().createStatement();
                   
                    //-------------TABLE LIER DOC-N3----------------------------
                    
                    ResultSet Rstd=stm.executeQuery("Select * from prod_type_document");
                 
                    //System.out.println(a);
                    DefaultListModel Document=new DefaultListModel();
                    DefaultListModel Type_de_Document_N1=new DefaultListModel();
                    
                    while(Rstd.next()) {
                        String nomDoc = Rstd.getString("Document");
                        String nomN1 = Rstd.getString("Type_de_Document_N1");
                        int incremDoc = 0;
                        int incremN1 = 0;
                        
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Document.size(); i++) {
                            
                            String DocI = (String) Document.get(i);
                            
                            if(DocI.equals(nomDoc)){
                                incremDoc++;
                            }
                        }
                        if(incremDoc == 0){
                            if(nomDoc != null) {
                        
                                if(!"[]".equals(nomN1)){
                                   Document.addElement(nomDoc);    
                                }
                            }
                        }
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Type_de_Document_N1.size(); i++) {
                            
                            String DocI = (String) Type_de_Document_N1.get(i);
                            
                            if(DocI.equals(nomN1)){
                                incremN1++;
                            }
                        }
                        if(incremN1 == 0){
                            if(nomN1 != null) { 
                                if(!"[]".equals(nomN1)){
                                 Type_de_Document_N1.addElement(nomN1);    
                                }
                                
                                
                            }
                            
                        }
                       
                        
                    }
                    
                    jList14.setModel(Type_de_Document_N1);
                    
                    
                    //-------------TABLE LIER ATELIERS-GFH-LIgne----------------------------
                    
                    ResultSet Rstj=stm.executeQuery("Select * from prod_atelier_gfh_ligne ORDER BY `prod_atelier_gfh_ligne`.`GFH_Ligne` ASC");
                 
                    //System.out.println(a);
                    DefaultListModel Ateliers=new DefaultListModel();
                    DefaultListModel GFH_Ligne=new DefaultListModel();
                    
                    while(Rstj.next()) { 
                        String nomAteliers = Rstj.getString("Ateliers");
                        String nomGFH_Ligne = Rstj.getString("GFH_Ligne");
                        int incremAteliers = 0;
                        int incremGFH_Ligne = 0;

                        //------------------------------------------------------------------------
                        for (int i = 0; i < Ateliers.size(); i++) {
                            
                            String DocI = (String) Ateliers.get(i);
                            
                            if(DocI.equals(nomAteliers)){
                                incremAteliers++;
                            }
                        }
                        if(incremAteliers == 0){
                            if(nomAteliers != null) {
                                System.out.println(nomAteliers);
                                    if(!"[]".equals(nomAteliers)){
                                   Ateliers.addElement(nomAteliers);    
                                }
                               
                            }
                        }

                        //------------------------------------------------------------------------
                        for (int i = 0; i < GFH_Ligne.size(); i++) {
                            
                            String DocI = (String) GFH_Ligne.get(i);
                            
                            if(DocI.equals(nomGFH_Ligne)){
                                incremGFH_Ligne++;
                            }
                        }
                        if(incremGFH_Ligne == 0){
                            if(nomGFH_Ligne != null) {
                                if(!"[]".equals(nomGFH_Ligne)){
                                GFH_Ligne.addElement(nomGFH_Ligne);
                            }
                            }
                        }
                        
                    }
                    jList15.setModel(Ateliers);
                    jList21.setModel(GFH_Ligne);
                    
                    
                    //-------------TABLE LIER Machines-Sous_ensemble----------------------------
                    
                    ResultSet Rsms=stm.executeQuery("Select * from prod_machines_sous_ensemble");
                 
                    //System.out.println(a);
                    DefaultListModel Machines=new DefaultListModel();
                    DefaultListModel Sous_ensemble=new DefaultListModel();
                    
                    while(Rsms.next()) {
                        String nomMachines = Rsms.getString("Machines");
                        String nomSous_ensemble = Rsms.getString("Sous_ensemble");
                        int incremMachines = 0;
                        int incremSous_ensemble = 0;
                        
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Machines.size(); i++) {
                            
                            String DocI = (String) Machines.get(i);
                            
                            if(DocI.equals(nomMachines)){
                                incremMachines++;
                            }
                        }
                        if(incremMachines == 0){
                            if(nomMachines != null) {
                                if(!"[]".equals(nomMachines)){
                                Machines.addElement(nomMachines);
                            }
                                }
                        }//------------------------------------------------------------------------
                        for (int i = 0; i < Sous_ensemble.size(); i++) {
                            
                            String DocI = (String) Sous_ensemble.get(i);
                            
                            if(DocI.equals(nomSous_ensemble)){
                                incremSous_ensemble++;
                            }
                        }
                        if(incremSous_ensemble == 0){
                            if(nomSous_ensemble != null) {
                                 if(!"[]".equals(nomSous_ensemble)){
                                Sous_ensemble.addElement(nomSous_ensemble);
                            }
                                 }
                        }
                        
                    }
                    jList22.setModel(Machines);
                    jList23.setModel(Sous_ensemble);
                    
                   
                     
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                

}
    
    private void TablLIer() {
        
        /*
            SELECT
                `docfinder`.`prod_atelier_gfh_ligne`.`Ateliers`,
                `docfinder`.`prod_atelier_gfh_ligne`.`GFH_Ligne`,
                `docfinder`.`prod_gfh_ligne_machines`.`Machines`,
                `docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble`
            FROM
                `docfinder`.`prod_atelier_gfh_ligne`,
                `docfinder`.`prod_gfh_ligne_machines`,
                `docfinder`.`prod_machines_sous_ensemble`
            WHERE
                (`docfinder`.`prod_gfh_ligne_machines`.`Machines` LIKE `docfinder`.`prod_machines_sous_ensemble`.`Machines`)
                AND (`docfinder`.`prod_atelier_gfh_ligne`.`GFH_Ligne` LIKE `docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne`)
                AND ((`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%")) OR (`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Chenille%")))
                AND ((`docfinder`.`prod_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%")) )
                AND ((`docfinder`.`prod_atelier_gfh_ligne`.`GFH_Ligne` LIKE("%%")) )
                AND ((`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE("%%")) )
        
        */
        
        /*
        SELECT
            `prod_atelier_gfh_ligne`.`id`,
            `prod_atelier_gfh_ligne`.`Ateliers`,
            `prod_gfh_ligne_machines`.`GFH_Ligne`,
            `prod_machines_sous_ensemble`.`Machines`,
            `prod_machines_sous_ensemble`.`Sous_ensemble`
        FROM
            `prod_atelier_gfh_ligne`
        INNER JOIN `prod_gfh_ligne_machines` ON `prod_atelier_gfh_ligne`.`GFH_Ligne` = `prod_gfh_ligne_machines`.`GFH_Ligne`
        INNER JOIN `prod_machines_sous_ensemble` ON `prod_gfh_ligne_machines`.`Machines` = `prod_machines_sous_ensemble`.`Machines` 

        AND ((`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%Bouchons%')) )
        AND ((`docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%')) )
        AND ((`docfinder`.`prod_machines_sous_ensemble`.`Machines` LIKE('%%')) )
        AND ((`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%')) )  
        ORDER BY `prod_atelier_gfh_ligne`.`id` ASC
      
        */
        
       
            ListJList23 = "(`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
            ListJList22 = "(`docfinder`.`prod_machines_sous_ensemble`.`Machines` LIKE('%%'))";
            ListJList21 = "(`docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%'))";
            ListJList15 = "(`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
        

        //======================================================================================================================================\\
        //(`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE("%%"))
        List<String> SQLJList15 = jList15.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList15.isEmpty()) {
            ListJList15 = "(`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList15.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList15.size()) {
                case 1:
                    
                    ListJList15 = ListJList15 + SQLJList15.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList15 = ListJList15+" OR (`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%"+ SQLJList15.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList15)){
            ListJList15 = "(`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList15 = ListJList15.substring(60);
            }
            System.out.println("-ListJList15- "+ListJList15);
        System.out.println(ListJList15);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`prod_atelier_gfh_ligne`.`GFH_Ligne` LIKE("%%"))
        List<String> SQLJList21 = jList21.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList21.isEmpty()) {
            ListJList21 = "(`docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList21.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList21.size()) {
                case 1:
                    
                    ListJList21 = ListJList21 + SQLJList21.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList21 = ListJList21+" OR (`docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne` LIKE('%"+ SQLJList21.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
         }
        if( "".equals(ListJList21)){
            ListJList21 = "(`docfinder`.`prod_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList21 = ListJList21.substring(61);
            }
            System.out.println("-ListJList21- "+ListJList21);
        System.out.println(ListJList21);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`prod_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%"))
        List<String> SQLJList22 = jList22.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList22.isEmpty()) {
            ListJList22 = "(`docfinder`.`prod_machines_sous_ensemble`.`Machines` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList22.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList22.size()) {
                case 1:
                    
                    ListJList22 = ListJList22 + SQLJList22.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList22 = ListJList22+" OR (`docfinder`.`prod_machines_sous_ensemble`.`Machines` LIKE('%"+ SQLJList22.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList22)){
            ListJList22 = "(`docfinder`.`prod_machines_sous_ensemble`.`Machines` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList22 = ListJList22.substring(65);
            }
            System.out.println("-ListJList22- "+ListJList22);
        System.out.println(ListJList22);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%"))
        List<String> SQLJList23 = jList23.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList23.isEmpty()) {
            ListJList23 = "(`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList23.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList23.size()) {
                case 1:
                    
                    ListJList23 = ListJList23 + SQLJList23.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList23 = ListJList23+" OR (`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%"+ SQLJList23.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList23)){
            ListJList23 = "(`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList23 = ListJList23.substring(69);
            }
            System.out.println("-ListJList23- "+ListJList23);
        System.out.println(ListJList23);
        }
        //======================================================================================================================================\\
        
            if( "".equals(ListJList23)){
            ListJList23 = "(`docfinder`.`prod_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
            }if( "".equals(ListJList22)){
            ListJList22 = "(`docfinder`.`prod_gfh_ligne_machines`.`Machines` LIKE('%%'))";
            }if( "".equals(ListJList21)){
            ListJList21 = "(`docfinder`.`prod_atelier_gfh_ligne`.`GFH_Ligne` LIKE('%%'))";
            }if( "".equals(ListJList15)){
            ListJList15 = "(`docfinder`.`prod_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
            }
            
            
            
            
    }
    private void rempList(){
        rempList15();
        rempList21();
        rempList22();
        rempList23();
    }
    
    private void rempList15(){
        System.out.println("RempList15");
        List<String> Listj = jList15.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT `prod_atelier_gfh_ligne`.`id`, `prod_atelier_gfh_ligne`.`Ateliers`, `prod_gfh_ligne_machines`.`GFH_Ligne`, `prod_machines_sous_ensemble`.`Machines`, `prod_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`prod_atelier_gfh_ligne`" +
            "INNER JOIN `prod_gfh_ligne_machines` ON `prod_atelier_gfh_ligne`.`GFH_Ligne` = `prod_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `prod_machines_sous_ensemble` ON `prod_gfh_ligne_machines`.`Machines` = `prod_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ORDER BY `prod_atelier_gfh_ligne`.`Ateliers` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Ateliers");
                if("[".equals(nomjList.substring(0, 1))){
                    nomjList = nomjList.substring(1);
                    nomjList = nomjList.substring(0, nomjList.length() - 1);
                }
                String mots[] = nomjList.split(", ");
                for (String mot1 : mots) {
                    mot = mot1;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest != 0) {
                    int incremjList = 0;
                    for (int i = 0; i < jListModel.size(); i++) {

                        String DocI = (String) jListModel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI.equals(mot)){
                            incremjList++;
                        }
                    }
                    if(incremjList == 0){
                        if(nomjList != null) {
                            jListModel.addElement(mot);   
                        }
                    }
                }else {
                    jListModel.addElement(mot);
                }
                incemTest++;
            }
            jList15.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
    
    private void rempList21(){
        System.out.println("RempList21");
        List<String> Listj = jList21.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT `prod_atelier_gfh_ligne`.`id`, `prod_atelier_gfh_ligne`.`Ateliers`, `prod_gfh_ligne_machines`.`GFH_Ligne`, `prod_machines_sous_ensemble`.`Machines`, `prod_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`prod_atelier_gfh_ligne`" +
            "INNER JOIN `prod_gfh_ligne_machines` ON `prod_atelier_gfh_ligne`.`GFH_Ligne` = `prod_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `prod_machines_sous_ensemble` ON `prod_gfh_ligne_machines`.`Machines` = `prod_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("GFH_Ligne");
                if("[".equals(nomjList.substring(0, 1))){
                    nomjList = nomjList.substring(1);
                    nomjList = nomjList.substring(0, nomjList.length() - 1);
                }
                String mots[] = nomjList.split(", ");
                for (String mot1 : mots) {
                    mot = mot1;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest != 0) {
                    int incremjList = 0;
                    for (int i = 0; i < jListModel.size(); i++) {

                        String DocI = (String) jListModel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI.equals(mot)){
                            incremjList++;
                        }
                    }
                    if(incremjList == 0){
                        if(nomjList != null) {
                            jListModel.addElement(mot);   
                        }
                    }
                }else {
                    jListModel.addElement(mot);
                }
                incemTest++;
            }
            jList21.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }}
   
    private void rempList22(){
        System.out.println("RempList22");
        List<String> Listj = jList22.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT `prod_atelier_gfh_ligne`.`id`, `prod_atelier_gfh_ligne`.`Ateliers`, `prod_gfh_ligne_machines`.`GFH_Ligne`, `prod_machines_sous_ensemble`.`Machines`, `prod_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`prod_atelier_gfh_ligne`" +
            "INNER JOIN `prod_gfh_ligne_machines` ON `prod_atelier_gfh_ligne`.`GFH_Ligne` = `prod_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `prod_machines_sous_ensemble` ON `prod_gfh_ligne_machines`.`Machines` = `prod_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ORDER BY `prod_machines_sous_ensemble`.`Machines` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Machines");
                if("[".equals(nomjList.substring(0, 1))){
                    nomjList = nomjList.substring(1);
                    nomjList = nomjList.substring(0, nomjList.length() - 1);
                }
                String mots[] = nomjList.split(", ");
                for (String mot1 : mots) {
                    mot = mot1;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest != 0) {
                    int incremjList = 0;
                    for (int i = 0; i < jListModel.size(); i++) {

                        String DocI = (String) jListModel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI.equals(mot)){
                            incremjList++;
                        }
                    }
                    if(incremjList == 0){
                        if(nomjList != null) {
                            jListModel.addElement(mot);   
                        }
                    }
                }else {
                    jListModel.addElement(mot);
                }
                incemTest++;
            }
            jList22.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
   
    private void rempList23(){
        System.out.println("RempList23");
        List<String> Listj = jList23.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT `prod_atelier_gfh_ligne`.`id`, `prod_atelier_gfh_ligne`.`Ateliers`, `prod_gfh_ligne_machines`.`GFH_Ligne`, `prod_machines_sous_ensemble`.`Machines`, `prod_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`prod_atelier_gfh_ligne`" +
            "INNER JOIN `prod_gfh_ligne_machines` ON `prod_atelier_gfh_ligne`.`GFH_Ligne` = `prod_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `prod_machines_sous_ensemble` ON `prod_gfh_ligne_machines`.`Machines` = `prod_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ORDER BY `prod_machines_sous_ensemble`.`Sous_ensemble` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            System.out.println(requete);
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Sous_ensemble");
                if("[".equals(nomjList.substring(0, 1))){
                    nomjList = nomjList.substring(1);
                    nomjList = nomjList.substring(0, nomjList.length() - 1);
                }
                String mots[] = nomjList.split(", ");
                for (String mot1 : mots) {
                    mot = mot1;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest != 0) {
                    int incremjList = 0;
                    for (int i = 0; i < jListModel.size(); i++) {

                        String DocI = (String) jListModel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI.equals(mot)){
                            incremjList++;
                        }
                    }
                    if(incremjList == 0){
                        if(nomjList != null) {
                            jListModel.addElement(mot);   
                        }
                    }
                }else {
                    jListModel.addElement(mot);
                }
                incemTest++;
            }
            jList23.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
   
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
System.exit(0);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
this.setState(main.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
this.dispose();
  recherche rchr = new recherche();
   rchr.setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String jVersion=this.jVersion.getText();
        if(!"".equals(jVersion)){
        
            String fichier=fichier_show.getText();
            fichier = fichier.replaceAll("\'","\\\\'");
            String chemin=chemin_show.getText();

            String Version =  this.jVersion.getText();

            List<String> Type_de_document_N1 = jList14.getSelectedValuesList();

            List<String> Atelier = jList15.getSelectedValuesList();
            List<String> GFH_Lignes = jList21.getSelectedValuesList();
            List<String> Machines = jList22.getSelectedValuesList();
            List<String> Sous_ensemble = jList23.getSelectedValuesList();

            String requete="insert into bddproduction(id,fichier,chemin,service,Type_de_document_N1,Atelier,GFH_Lignes,Machines,Sous_ensemble,Version)VALUES"
                    + "(NULL,'"+fichier+"','"+chemin+"','[Production]','"+Type_de_document_N1+"','"+Atelier+"','"+GFH_Lignes+"','"+Machines+"','"+Sous_ensemble+"','"+Version+"')";
            try{
                stm.executeUpdate(requete);
                this.dispose();
                main mn = new main();
                mn.setVisible(true);
                JOptionPane.showMessageDialog(null,"L'index du fichier "+fichier+" à bien été ajoutée.");
                fichier_show.setText("");
                chemin_show.setText("");
                //txtpr.setText("");txtbr.setSelectedItem(2);txtnot.setText("");
                afficher();


            }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
        }else {
           JOptionPane.showMessageDialog(null,
                    "Veuillez indiquez une version.",
                    "IMPOSSIBLE D'INDEXER.",
                    JOptionPane.WARNING_MESSAGE);
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList14ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList14ValueChanged
 try {
                    stm=conn.obtenirconnexion().createStatement();
                                        
                    //-------------TABLE LIER DOC-N3----------------------------
                    //String TypeN1SQL = JList7.getSelectedValuesList().toString();
                    //TypeN1SQL  = TypeN1SQL.replaceAll("\\[|\\]", "");    
                    
                    List<String> ServiceSQL = jList14.getSelectedValuesList();
                    String JListTrier = "";
                    for(int i=0; i<ServiceSQL.size(); i++) {
                        //System.out.println(ListeTEST.get(i));
                        JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";
                        
                     }
                    if (!"".equals(JListTrier)) {
                        JListTrier = JListTrier.substring(2);
                    }
                    ResultSet Rstd=stm.executeQuery("SELECT * "
                            + "FROM `prod_type_document` "
                            + "WHERE `Type_de_Document_N1`IN ("+JListTrier+")");
                    
                    DefaultListModel Document=new DefaultListModel();
                    
                    while(Rstd.next()) {
                        String nomDoc = Rstd.getString("Document");
                        int incremDoc = 0;
                        
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Document.size(); i++) {
                            
                            String DocI = (String) Document.get(i);
                            
                            if(DocI.equals(nomDoc)){
                                incremDoc++;
                            }
                        }
                        if(incremDoc == 0){
                            if(nomDoc != null) {
                                Document.addElement(nomDoc);
                            }
                        }
                        
                        
                    }
                                     
                    
                    
                     
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }        // TODO add your handling code here:
    }//GEN-LAST:event_jList14ValueChanged

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
// try {
//                    stm=conn.obtenirconnexion().createStatement();
//                                        
//                    //-------------TABLE LIER DOC-N3----------------------------
//                    List<String> ServiceSQL = jList15.getSelectedValuesList();
//                    String JListTrier = "";
//                    for(int i=0; i<ServiceSQL.size(); i++) {
//                        //System.out.println(ListeTEST.get(i));
//                        JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";
//                        
//                     }
//                    if (!"".equals(JListTrier)) {
//                        JListTrier = JListTrier.substring(2);
//                    } 
//                    ResultSet Rstd=stm.executeQuery("SELECT * "
//                            + "FROM `prod_atelier_gfh_ligne` "
//                            + "WHERE `Ateliers`IN ("+JListTrier+")");
//                    
//                    DefaultListModel GFH_Ligne=new DefaultListModel();
//                    DefaultListModel Rien=new DefaultListModel();
//                    //DefaultListModel Type_de_Document_N2=new DefaultListModel();
//                    
//                    while(Rstd.next()) {
//                        String nomGFH_Ligne = Rstd.getString("GFH_Ligne");
//                        int incremGFH_Ligne = 0;
//                        
//                        //------------------------------------------------------------------------
//                        for (int i = 0; i < GFH_Ligne.size(); i++) {
//                            
//                            String DocI = (String) GFH_Ligne.get(i);
//                            
//                            if(DocI.equals(nomGFH_Ligne)){
//                                incremGFH_Ligne++;
//                            }
//                        }
//                        if(incremGFH_Ligne == 0){
//                            if(nomGFH_Ligne != null) {
//                                GFH_Ligne.addElement(nomGFH_Ligne);
//                            }
//                        }
//                        
//                        
////                        if(Rstd.getString("Type_de_Document_N1") != null) {
////                            Type_de_Document_N1.addElement(Rstd.getString("Type_de_Document_N1"));
////                        }
////                        
////                        if(Rstd.getString("Type_de_Document_N2") != null) {
////                            Type_de_Document_N2.addElement(Rstd.getString("Type_de_Document_N2"));
////                        }
//                        
//                    }
//                    jList21.setModel(GFH_Ligne);
//                    jList22.setModel(Rien);
//                    jList23.setModel(Rien);
//                                     
//                    
//                    
//                     
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }
//                // TODO add your handling code here:
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList15ValueChanged

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged
//      try {
//                    stm=conn.obtenirconnexion().createStatement();
//                                        
//                    //-------------TABLE LIER DOC-N3----------------------------
//                    List<String> ServiceSQL = jList21.getSelectedValuesList();
//                    String JListTrier = "";
//                    for(int i=0; i<ServiceSQL.size(); i++) {
//                        //System.out.println(ListeTEST.get(i));
//                        JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";
//                        
//                     }
//                    if (!"".equals(JListTrier)) {
//                        JListTrier = JListTrier.substring(2);
//                    }
//                    ResultSet Rstd=stm.executeQuery("SELECT * "
//                            + "FROM `prod_gfh_ligne_machines` "
//                            + "WHERE `GFH_Ligne`IN ("+JListTrier+")");
//                    
//                    DefaultListModel Machines=new DefaultListModel();
//                    DefaultListModel Rien=new DefaultListModel();
//                    //DefaultListModel Type_de_Document_N1=new DefaultListModel();
//                    //DefaultListModel Type_de_Document_N2=new DefaultListModel();
//                    
//                    while(Rstd.next())
//                    { 
//                        String nomMachines = Rstd.getString("Machines");
//                        int incremMachines = 0;
//                        
//                        //------------------------------------------------------------------------
//                        for (int i = 0; i < Machines.size(); i++) {
//                            
//                            String DocI = (String) Machines.get(i);
//                            
//                            if(DocI.equals(nomMachines)){
//                                incremMachines++;
//                            }
//                        }
//                        if(incremMachines == 0){
//                            if(nomMachines != null) {
//                                Machines.addElement(nomMachines);
//                            }
//                        }
//                        
//                    }
//                    jList22.setModel(Machines);
//                    jList23.setModel(Rien);
//                    //JList7.setModel(Type_de_Document_N1);
//                    //JList8.setModel(Type_de_Document_N2);
//                                     
//                    
//                    
//                     
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }        // TODO add your handling code here:  // TODO add your handling code here:
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList21ValueChanged

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
//try {
//                    stm=conn.obtenirconnexion().createStatement();
//                                        
//                    //-------------TABLE LIER DOC-N3----------------------------
//                    List<String> ServiceSQL = jList22.getSelectedValuesList();
//                    String JListTrier = "";
//                    for(int i=0; i<ServiceSQL.size(); i++) {
//                        //System.out.println(ListeTEST.get(i));
//                        JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";
//                        
//                     }
//                    if (!"".equals(JListTrier)) {
//                        JListTrier = JListTrier.substring(2);
//                    }
//                    ResultSet Rstd=stm.executeQuery("SELECT * "
//                            + "FROM `prod_machines_sous_ensemble` "
//                            + "WHERE `Machines`IN ("+JListTrier+")");
//                    
//                    DefaultListModel Sous_ensemble=new DefaultListModel();
//                    //DefaultListModel Type_de_Document_N1=new DefaultListModel();
//                    //DefaultListModel Type_de_Document_N2=new DefaultListModel();
//                    
//                    while(Rstd.next())
//                    { 
//                        String nomSous_ensemble = Rstd.getString("Sous_ensemble");
//                        int incremSous_ensemble = 0;
//                        
//                        //------------------------------------------------------------------------
//                        for (int i = 0; i < Sous_ensemble.size(); i++) {
//                            
//                            String DocI = (String) Sous_ensemble.get(i);
//                            
//                            if(DocI.equals(nomSous_ensemble)){
//                                incremSous_ensemble++;
//                            }
//                        }
//                        if(incremSous_ensemble == 0){
//                            if(nomSous_ensemble != null) {
//                                Sous_ensemble.addElement(nomSous_ensemble);
//                            }
//                        }
//                        
//                        
////                        if(Rstd.getString("Type_de_Document_N1") != null) {
////                            Type_de_Document_N1.addElement(Rstd.getString("Type_de_Document_N1"));
////                        }
////                        
////                        if(Rstd.getString("Type_de_Document_N2") != null) {
////                            Type_de_Document_N2.addElement(Rstd.getString("Type_de_Document_N2"));
////                        }
//                        
//                    }
//                    jList23.setModel(Sous_ensemble);
//                    //JList7.setModel(Type_de_Document_N1);
//                    //JList8.setModel(Type_de_Document_N2);
//                                     
//                    
//                    
//                     
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }        // TODO add your handling code here:
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList22ValueChanged

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
            this.dispose();
   main mn = new main();
   mn.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
    jPanel7.setBackground(new Color (0,136,198));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
      jPanel7.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
       jPanel9.setBackground(new Color (0,136,198));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
       jPanel9.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jPanel8.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
       jPanel8.setBackground(new Color (0,86,172)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
       jPanel10.setBackground(new Color (0,136,198));  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(new Color (0,86,172)); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

 option option = new option();
        option.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jList23ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList23ValueChanged

        // TODO add your handling code here:
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList23ValueChanged

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked

        admin adm = new admin();
        adm.setVisible(true);
        main.page = "tech";
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        jPanel19.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        jPanel19.setBackground(new Color (0,86,172));          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        // TODO add your handling code here:
        jPanel19.setBackground(new Color (0,136,198));
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited

        jPanel19.setBackground(new Color (0,86,172));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseExited

    private void btnAddN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN1ActionPerformed

        String AddN1 = this.txtAddN1.getText();
        PageIndex = "Simple";
        String requete="INSERT INTO `prod_type_document` (`id`, `Document`, `Type_de_Document_N1`) VALUES (NULL, 'Production', '"+AddN1+"')";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere N1, "+AddN1+" à bien été ajoutée.");
            this.txtAddN1.setText("");
            this.btnAddN1.setVisible(false);
            afficher();
            this.TablLIer();
            rempList(); 
            jList14.setSelectedValue(AddN1, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}


        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddN1ActionPerformed

    private void txtAddN1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN1MouseReleased
        this.btnAddN1.setVisible(true);
    }//GEN-LAST:event_txtAddN1MouseReleased

    private void btnAddAtelierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAtelierActionPerformed
        // TODO add your handling code here:
        AddElement = "Ateliers";
        PageIndex = "Simple";
        new addAteliersSE().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddAtelierActionPerformed

    private void btnAddGFHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGFHActionPerformed
        // TODO add your handling code here:
        AddElement = "GFH";
        PageIndex = "Simple";
        new addAteliersSE().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddGFHActionPerformed

    private void btnAddMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMachineActionPerformed
        // TODO add your handling code here:
        AddElement = "Machine";
        PageIndex = "Simple";
        new addAteliersSE().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddMachineActionPerformed

    private void btnAddSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSEActionPerformed
        // TODO add your handling code here:
        AddElement = "SE";
        PageIndex = "Simple";
        new addAteliersSE().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddSEActionPerformed
    
    private void OpenFile(String file){
        try {
        
        File pdfFile = new File(file);
        if (pdfFile.exists()) {

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Awt Desktop is not supported!");
            }

        } else {
            System.out.println("File is not exists!");
        }

        System.out.println("Done");

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indexation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new indexation().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAtelier;
    private javax.swing.JButton btnAddGFH;
    private javax.swing.JButton btnAddMachine;
    private javax.swing.JButton btnAddN1;
    private javax.swing.JButton btnAddSE;
    private javax.swing.JTextField chemin_show;
    private javax.swing.JTextField fichier_show;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JTextField jVersion;
    private javax.swing.JTextField txtAddN1;
    // End of variables declaration//GEN-END:variables
}
