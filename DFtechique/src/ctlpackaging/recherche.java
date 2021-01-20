package ctlpackaging;

import static ctlpackaging.main.cheminseul_txt;
import static ctlpackaging.main.connect;
import static ctlpackaging.main.tableauindex;
import static ctlpackaging.main.test_txt;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class recherche extends javax.swing.JFrame {
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;
    public static String idFichier = null;

    
    Connecter conn=new Connecter();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    private int tmp;
    private int reini = 0;
    private String ListJList = "";
    private String ListJList7 = "";
    private String ListJList8 = "";
    private String ListJList9 = "";
    private String ListJList10 = "";
    private String ListJList11 = "";
    private String ListJList12 = "";
    private String ListJList13 = "";
    private String ListJList1 = "";
    private String ListJList2 = "";
    private String ListJList3 = "";
    private String ListJList4 = "";
    private String ListJList5 = "";
    private boolean BeforeSelectedList = false;
    private String RechercheMotClef;
    
    
    public recherche() {
        
        initComponents();
        connecter();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Recherche");
        
         RecupFichier.setCurrentSoftware("Technique", "recherche");
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
        model.addColumn("Fichiers");
        model.addColumn("Chemin");
      

    try {
        stm=conn.obtenirconnexion().createStatement();
        ResultSet Rs=stm.executeQuery("Select * from bddmaintenance ORDER BY `fichier` ASC");
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getString("fichier"),Rs.getString("chemin")});
        }
        }catch(SQLException e){System.err.println(e);}
       // this.jTextField1.setSize(350, 32);
        tlbRecherche.setModel(model);
        tlbRecherche.setDefaultEditor(Object.class, null);
        tlbRecherche.getColumnModel().getColumn(1).setMinWidth(0);
        tlbRecherche.getColumnModel().getColumn(1).setMaxWidth(0);
        tlbRecherche.getColumnModel().getColumn(1).setWidth(0);

       
       this.reini();
    }
   
    
    public void connecter() {
        
        if (main.connect == false) {
            ////System.out.printlnSe connecter ?");
            this.lblConnecter.setText("SE CONNECTER ?");
        }else {jPanel12.setBackground(new Color (0,136,198)); 
            ////System.out.printlnConnecter : ADMIN");
            this.lblConnecter.setText("Connecté : ADMIN");
        }
        
    }
    
    
    
    private recherche(Runnable aThis) {
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
        jPanel12 = new javax.swing.JPanel();
        lblConnecter = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        jList16 = new javax.swing.JList<>();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList17 = new javax.swing.JList<>();
        jScrollPane18 = new javax.swing.JScrollPane();
        jList18 = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList<>();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList19 = new javax.swing.JList<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList20 = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jScrollPane23 = new javax.swing.JScrollPane();
        jList23 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jList24 = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tlbRecherche = new javax.swing.JTable();
        txtRecherche = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

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

        jPanel6.setBackground(new java.awt.Color(0, 86, 172));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/add_24px.png"))); // NOI18N
        jLabel21.setText("INDEXER UN FICHIER");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });

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

        jPanel9.setBackground(new java.awt.Color(0, 136, 198));

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

        jPanel12.setBackground(new java.awt.Color(0, 86, 172));

        lblConnecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConnecter.setForeground(new java.awt.Color(255, 255, 255));
        lblConnecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/loginnnnn_24px.png"))); // NOI18N
        lblConnecter.setText("SE CONNECTER");
        lblConnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConnecterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConnecterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConnecterMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConnecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConnecter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(0, 136, 198));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(0, 136, 198));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/full_tool_storage_box_24px.png"))); // NOI18N
        jLabel26.setText("MODE TECHNIQUE");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(0, 86, 172));
        jPanel18.setPreferredSize(new java.awt.Dimension(210, 45));
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

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/processor_24px.png"))); // NOI18N
        jLabel28.setText("MODE PRODUCTION");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
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
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(98, 173, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/loupe.png"))); // NOI18N
        jLabel7.setText("RECHERCHER UN FICHIER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
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

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList11.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jList11VetoableChange(evt);
            }
        });
        jList11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList11ValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(jList11);

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList12ValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(jList12);

        jScrollPane16.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList16.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList16ValueChanged(evt);
            }
        });
        jScrollPane16.setViewportView(jList16);

        jScrollPane17.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList17.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList17ValueChanged(evt);
            }
        });
        jScrollPane17.setViewportView(jList17);

        jScrollPane18.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList18.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList18ValueChanged(evt);
            }
        });
        jScrollPane18.setViewportView(jList18);

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList14.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jList14ComponentRemoved(evt);
            }
        });
        jList14.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jList14AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jList14AncestorRemoved(evt);
            }
        });
        jList14.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jList14AncestorMoved1(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jList14AncestorResized(evt);
            }
        });
        jList14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList14MouseClicked(evt);
            }
        });
        jList14.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jList14ComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jList14ComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jList14ComponentShown(evt);
            }
        });
        jList14.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jList14CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jList14.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList14ValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(jList14);

        jScrollPane19.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList19.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jList19ComponentResized(evt);
            }
        });
        jList19.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList19ValueChanged(evt);
            }
        });
        jScrollPane19.setViewportView(jList19);

        jScrollPane20.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList20.setMinimumSize(new java.awt.Dimension(35, 92));
        jList20.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jList20ComponentResized(evt);
            }
        });
        jList20.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList20ValueChanged(evt);
            }
        });
        jScrollPane20.setViewportView(jList20);

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Service : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Type de matériel :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Matériel :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Années :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Type de document N1 :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Type de document N2 :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Type de document N3 :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Atelier :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Machine :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Sous-ensemble :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("GFH - Ligne : ");

        jScrollPane24.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList24.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jList24HierarchyChanged(evt);
            }
        });
        jList24.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jList24AncestorResized(evt);
            }
        });
        jList24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList24MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList24MouseReleased(evt);
            }
        });
        jList24.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jList24ComponentResized(evt);
            }
        });
        jList24.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList24ValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(jList24);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Lieu d'archivage :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Constructeur :");

        tlbRecherche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbRecherche.setCellSelectionEnabled(true);
        tlbRecherche.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tlbRecherche.setGridColor(new java.awt.Color(255, 255, 255));
        tlbRecherche.setRowHeight(25);
        tlbRecherche.setSelectionBackground(new java.awt.Color(98, 173, 255));
        tlbRecherche.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tlbRecherche.setShowHorizontalLines(false);
        tlbRecherche.setShowVerticalLines(false);
        tlbRecherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbRechercheMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tlbRecherche);
        tlbRecherche.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tlbRecherche.getColumnModel().getColumnCount() > 0) {
            tlbRecherche.getColumnModel().getColumn(0).setResizable(false);
            tlbRecherche.getColumnModel().getColumn(1).setMinWidth(0);
            tlbRecherche.getColumnModel().getColumn(1).setPreferredWidth(0);
            tlbRecherche.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        txtRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRechercheActionPerformed(evt);
            }
        });
        txtRecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRechercheKeyReleased(evt);
            }
        });

        jButton1.setText("Réinitialiser les filtres");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Recherche par mot-clé :");

        btnModifier.setText("Modifier");
        btnModifier.setEnabled(false);
        btnModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifierMouseClicked(evt);
            }
        });
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Nombre de fichier correspondant à votre recherche : AUCUN");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel25)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8)
                    .addComponent(jLabel25)
                    .addComponent(btnModifier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel19))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void affichjList() {
            if( "".equals(ListJList)){
            ListJList = "`service` LIKE '%%'";
            }if( "".equals(ListJList7)){
            ListJList7 = "`Type_de_document_N1` LIKE '%%'";
            }if( "".equals(ListJList8)){
            ListJList8 = "`Type_de_document_N2` LIKE '%%'";
            }if( "".equals(ListJList9)){
            ListJList9 = "`Type_de_document_N3` LIKE '%%'";
            }if( "".equals(ListJList1)){
            ListJList1 = "`Lieu_Archivage` LIKE '%%'";
            }if( "".equals(ListJList2)){
            ListJList2 = "`Type_de_Materiel` LIKE '%%'";
            }if( "".equals(ListJList3)){
            ListJList3 = "`Constructeur` LIKE '%%'";
            }if( "".equals(ListJList4)){
            ListJList4 = "`Materiel` LIKE '%%'";
            }if( "".equals(ListJList10)){
            ListJList10 = "`Atelier` LIKE '%%'";
            }if( "".equals(ListJList11)){
            ListJList11 = "`GFH_Lignes` LIKE '%%'";
            }if( "".equals(ListJList12)){
            ListJList12 = "`Machines` LIKE '%%'";
            }if( "".equals(ListJList13)){
            ListJList13 = "`Sous_ensemble` LIKE '%%'";
            }if( "".equals(ListJList5)){
            ListJList5 = "`Annees` LIKE '%%'";
            }

            affichejList();
        
        
    }
    
   private void affichejList() /*service*/ {
        try {
            List<String> Listj24 = jList24.getSelectedValuesList();
            List<String> Listj14 = jList14.getSelectedValuesList();
            List<String> Listj19 = jList19.getSelectedValuesList();
            List<String> Listj20 = jList20.getSelectedValuesList();
            
            List<String> Listj15 = jList15.getSelectedValuesList();
            List<String> Listj21 = jList21.getSelectedValuesList();
            List<String> Listj22 = jList22.getSelectedValuesList();
            List<String> Listj23 = jList23.getSelectedValuesList();
            
            List<String> Listj12 = jList12.getSelectedValuesList();
            List<String> Listj17 = jList17.getSelectedValuesList();
            List<String> Listj16 = jList16.getSelectedValuesList();
            List<String> Listj11 = jList11.getSelectedValuesList();
            List<String> Listj18 = jList18.getSelectedValuesList();
            //System.out.println("Listj24 "+Listj24);
            ////System.out.println(this.jList24.getSelectedIndex());
            
                //System.out.println("BeforeSelectedList "+BeforeSelectedList);
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
                
                if (Listj24.isEmpty() || 1 == reini || this.jList24.getSelectedIndex()==-1) {
                ListJList = "`service` LIKE '%%'";
                }if (Listj14.isEmpty() || 1 == reini || this.jList14.getSelectedIndex()==-1) {
                ListJList7 = "`Type_de_document_N1` LIKE '%%'";
                }if (Listj19.isEmpty() || 1 == reini || this.jList19.getSelectedIndex()==-1) {
                ListJList8 = "`Type_de_document_N2` LIKE '%%'";
                }if (Listj20.isEmpty() || 1 == reini || this.jList20.getSelectedIndex()==-1) {
                ListJList9 = "`Type_de_document_N3` LIKE '%%'";
                }

                if (Listj15.isEmpty() || 1 == reini || this.jList15.getSelectedIndex()==-1) {
                ListJList10 = "`Atelier` LIKE '%%'";
                }if (Listj21.isEmpty() || 1 == reini || this.jList21.getSelectedIndex()==-1) {
                ListJList11 = "`GFH_Lignes` LIKE '%%'";
                }if (Listj22.isEmpty() || 1 == reini || this.jList22.getSelectedIndex()==-1) {
                ListJList12 = "`Machines` LIKE '%%'";
                }if (Listj23.isEmpty() || 1 == reini || this.jList23.getSelectedIndex()==-1) {
                ListJList13 = "`Sous_ensemble` LIKE '%%'";
                }

                if (Listj12.isEmpty() || 1 == reini || this.jList12.getSelectedIndex()==-1) {
                ListJList2 = "`Type_de_Materiel` LIKE '%%'";
                }if (Listj17.isEmpty() || 1 == reini || this.jList17.getSelectedIndex()==-1) {
                ListJList3= "`Constructeur` LIKE '%%'";
                }if (Listj16.isEmpty() || 1 == reini || this.jList16.getSelectedIndex()==-1) {
                ListJList4 = "`Materiel` LIKE '%%'";
                }if (Listj11.isEmpty() || 1 == reini || this.jList11.getSelectedIndex()==-1) {
                ListJList1 = "`Lieu_Archivage` LIKE '%%'";
                }if (Listj18.isEmpty() || 1 == reini || this.jList18.getSelectedIndex()==-1) {
                ListJList5 = "`Annees` LIKE '%%'";
                }
            
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddmaintenance` ORDER BY `service` ASC");
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddmaintenance` WHERE ("+ListJList+") ORDER BY `fichier` ASC");`service` LIKE '%%'
            ////System.out.println(ListJList+" + "+ListJList7);
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddmaintenance` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList8+") "
                  + "AND ("+ListJList9+") "
                  + "AND ("+ListJList1+") "
                  + "AND ("+ListJList2+") "
                  + "AND ("+ListJList3+") "
                  + "AND ("+ListJList4+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + "ORDER BY `service` ASC");
            
            DefaultListModel jListModel_service=new DefaultListModel();
            List<String> jListModelle_service = new ArrayList();
            DefaultListModel jListModel_Type_de_document_N1=new DefaultListModel();
            List<String> jListModelle_Type_de_document_N1 = new ArrayList();
            DefaultListModel jListModel_Type_de_document_N2=new DefaultListModel();
            List<String> jListModelle_Type_de_document_N2 = new ArrayList();
            DefaultListModel jListModel_Type_de_document_N3=new DefaultListModel();
            List<String> jListModelle_Type_de_document_N3 = new ArrayList();
            
            DefaultListModel jListModel_Atelier=new DefaultListModel();
            List<String> jListModelle_Atelier = new ArrayList();
            DefaultListModel jListModel_GFH_Lignes=new DefaultListModel();
            List<String> jListModelle_GFH_Lignes = new ArrayList();
            DefaultListModel jListModel_Machines=new DefaultListModel();
            List<String> jListModelle_Machines = new ArrayList();
            DefaultListModel jListModel_Sous_ensemble=new DefaultListModel();
            List<String> jListModelle_Sous_ensemble = new ArrayList();
            
    
            DefaultListModel jListModel_Type_de_Materiel=new DefaultListModel();
            List<String> jListModelle_Type_de_Materiel = new ArrayList();
            DefaultListModel jListModel_Constructeur=new DefaultListModel();
            List<String> jListModelle_Constructeur = new ArrayList();
            DefaultListModel jListModel_Materiel=new DefaultListModel();
            List<String> jListModelle_Materiel = new ArrayList();
            DefaultListModel jListModel_Lieu_Archivage=new DefaultListModel();
            List<String> jListModelle_Lieu_Archivage = new ArrayList();
            DefaultListModel jListModel_Annees=new DefaultListModel();
            List<String> jListModelle_Annees = new ArrayList();
            
            int incemTest_service =0;
            int incemTest_Type_de_document_N1 =0;
            int incemTest_Type_de_document_N2 =0;
            int incemTest_Type_de_document_N3 =0;
            
            int incemTest_Atelier =0;
            int incemTest_GFH_Lignes =0;
            int incemTest_Machines =0;
            int incemTest_Sous_ensemble =0;
            
            int incemTest_Type_de_Materiel =0;
            int incemTest_Constructeur =0;
            int incemTest_Materiel =0;
            int incemTest_Lieu_Archivage =0;
            int incemTest_Annees =0;
            
            String mot_service = null;
            String mot_Type_de_document_N1 = null;
            String mot_Type_de_document_N2 = null;
            String mot_Type_de_document_N3 = null;
            
            String mot_Atelier = null;
            String mot_GFH_Lignes = null;
            String mot_Machines = null;
            String mot_Sous_ensemble = null;
            
            String mot_Type_de_Materiel = null;
            String mot_Constructeur = null;
            String mot_Materiel = null;
            String mot_Lieu_Archivage = null;
            String mot_Annees = null;
            
            while(Rse.next())
            {   
                //------------------------------------------------------SERVICE----------------------------------------------------------
                String nomjList_service = Rse.getString("service");
                if("[".equals(nomjList_service.substring(0, 1))){
                    nomjList_service = nomjList_service.substring(1);
                    nomjList_service = nomjList_service.substring(0, nomjList_service.length() - 1);
                }
                String mots_service[] = nomjList_service.split(", ");
                for (String mot1_service : mots_service) {
                    mot_service = mot1_service;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_service != 0) {
                    int incremjList_service = 0;
                    for (int i = 0; i < jListModel_service.size(); i++) {

                        String DocI_service = (String) jListModel_service.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_service.equals(mot_service)){
                            incremjList_service++;
                        }
                    }
                    if(incremjList_service == 0){
                        if(nomjList_service != null) {
                            jListModel_service.addElement(mot_service);   
                            System.out.println(mot_service);
                            jListModelle_service.add(mot_service); 
                        }
                    }
                }else {
                    jListModel_service.addElement(mot_service);
                    jListModelle_service.add(mot_service); 
                }
                incemTest_service++;
                //------------------------------------------------------SERVICE-----------------------------------------------------------
                
                //------------------------------------------------------Type_de_document_N1----------------------------------------------------------
                String nomjList_Type_de_document_N1 = Rse.getString("Type_de_document_N1");
                if("[".equals(nomjList_Type_de_document_N1.substring(0, 1))){
                    nomjList_Type_de_document_N1 = nomjList_Type_de_document_N1.substring(1);
                    nomjList_Type_de_document_N1 = nomjList_Type_de_document_N1.substring(0, nomjList_Type_de_document_N1.length() - 1);
                }
                String mots_Type_de_document_N1[] = nomjList_Type_de_document_N1.split(", ");
                for (String mot1_Type_de_document_N1 : mots_Type_de_document_N1) {
                    mot_Type_de_document_N1 = mot1_Type_de_document_N1;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Type_de_document_N1 != 0) {
                    int incremjList_Type_de_document_N1 = 0;
                    for (int i = 0; i < jListModel_Type_de_document_N1.size(); i++) {

                        String DocI_Type_de_document_N1 = (String) jListModel_Type_de_document_N1.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Type_de_document_N1.equals(mot_Type_de_document_N1)){
                            incremjList_Type_de_document_N1++;
                        }
                    }
                    if(incremjList_Type_de_document_N1 == 0){
                        if(nomjList_Type_de_document_N1 != null) {
                            jListModel_Type_de_document_N1.addElement(mot_Type_de_document_N1);   
                            jListModelle_Type_de_document_N1.add(mot_Type_de_document_N1);  
                        }
                    }
                }else {
                    jListModel_Type_de_document_N1.addElement(mot_Type_de_document_N1);
                     jListModelle_Type_de_document_N1.add(mot_Type_de_document_N1);  
                }
                incemTest_Type_de_document_N1++;
                //------------------------------------------------------Type_de_document_N1----------------------------------------------------------
                
                //------------------------------------------------------Type_de_document_N2----------------------------------------------------------
                String nomjList_Type_de_document_N2 = Rse.getString("Type_de_document_N2");
                if("[".equals(nomjList_Type_de_document_N2.substring(0, 1))){
                    nomjList_Type_de_document_N2 = nomjList_Type_de_document_N2.substring(1);
                    nomjList_Type_de_document_N2 = nomjList_Type_de_document_N2.substring(0, nomjList_Type_de_document_N2.length() - 1);
                }
                String mots_Type_de_document_N2[] = nomjList_Type_de_document_N2.split(", ");
                for (String mot1_Type_de_document_N2 : mots_Type_de_document_N2) {
                    mot_Type_de_document_N2 = mot1_Type_de_document_N2;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Type_de_document_N2 != 0) {
                    int incremjList_Type_de_document_N2 = 0;
                    for (int i = 0; i < jListModel_Type_de_document_N2.size(); i++) {

                        String DocI_Type_de_document_N2 = (String) jListModel_Type_de_document_N2.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Type_de_document_N2.equals(mot_Type_de_document_N2)){
                            incremjList_Type_de_document_N2++;
                        }
                    }
                    if(incremjList_Type_de_document_N2 == 0){
                        if(nomjList_Type_de_document_N2 != null) {
                            jListModel_Type_de_document_N2.addElement(mot_Type_de_document_N2);  
                            jListModelle_Type_de_document_N2.add(mot_Type_de_document_N2);    
                        }
                    }
                }else {
                    jListModel_Type_de_document_N2.addElement(mot_Type_de_document_N2);
                    jListModelle_Type_de_document_N2.add(mot_Type_de_document_N2);
                }
                incemTest_Type_de_document_N2++;
                //------------------------------------------------------Type_de_document_N2----------------------------------------------------------
                
                //------------------------------------------------------Type_de_document_N3----------------------------------------------------------
                String nomjList_Type_de_document_N3 = Rse.getString("Type_de_document_N3");
                if("[".equals(nomjList_Type_de_document_N3.substring(0, 1))){
                    nomjList_Type_de_document_N3 = nomjList_Type_de_document_N3.substring(1);
                    nomjList_Type_de_document_N3 = nomjList_Type_de_document_N3.substring(0, nomjList_Type_de_document_N3.length() - 1);
                }
                String mots_Type_de_document_N3[] = nomjList_Type_de_document_N3.split(", ");
                for (String mot1_Type_de_document_N3 : mots_Type_de_document_N3) {
                    mot_Type_de_document_N3 = mot1_Type_de_document_N3;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Type_de_document_N3 != 0) {
                    int incremjList_Type_de_document_N3 = 0;
                    for (int i = 0; i < jListModel_Type_de_document_N3.size(); i++) {

                        String DocI_Type_de_document_N3 = (String) jListModel_Type_de_document_N3.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Type_de_document_N3.equals(mot_Type_de_document_N3)){
                            incremjList_Type_de_document_N3++;
                        }
                    }
                    if(incremjList_Type_de_document_N3 == 0){
                        if(nomjList_Type_de_document_N3 != null) {
                            jListModel_Type_de_document_N3.addElement(mot_Type_de_document_N3);  
                            jListModelle_Type_de_document_N3.add(mot_Type_de_document_N3);   
                        }
                    }
                }else {
                    jListModel_Type_de_document_N3.addElement(mot_Type_de_document_N3);
                    jListModelle_Type_de_document_N3.add(mot_Type_de_document_N3);
                }
                incemTest_Type_de_document_N3++;
                //------------------------------------------------------Type_de_document_N3----------------------------------------------------------
                
                //------------------------------------------------------Materiel----------------------------------------------------------
                String nomjList_Materiel = Rse.getString("Materiel");
                if("[".equals(nomjList_Materiel.substring(0, 1))){
                    nomjList_Materiel = nomjList_Materiel.substring(1);
                    nomjList_Materiel = nomjList_Materiel.substring(0, nomjList_Materiel.length() - 1);
                }
                String mots_Materiel[] = nomjList_Materiel.split(", ");
                for (String mot1_Materiel : mots_Materiel) {
                    mot_Materiel = mot1_Materiel;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Materiel != 0) {
                    int incremjList_Materiel = 0;
                    for (int i = 0; i < jListModel_Materiel.size(); i++) {

                        String DocI_Materiel = (String) jListModel_Materiel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Materiel.equals(mot_Materiel)){
                            incremjList_Materiel++;
                        }
                    }
                    if(incremjList_Materiel == 0){
                        if(nomjList_Materiel != null) {
                            jListModel_Materiel.addElement(mot_Materiel);   
                            jListModelle_Materiel.add(mot_Materiel);   
                        }
                    }
                }else {
                    jListModel_Materiel.addElement(mot_Materiel);
                    jListModelle_Materiel.add(mot_Materiel);
                }
                incemTest_Materiel++;
                //------------------------------------------------------Materiel----------------------------------------------------------
                
                //------------------------------------------------------Atelier----------------------------------------------------------
                String nomjList_Atelier = Rse.getString("Atelier");
                if("[".equals(nomjList_Atelier.substring(0, 1))){
                    nomjList_Atelier = nomjList_Atelier.substring(1);
                    nomjList_Atelier = nomjList_Atelier.substring(0, nomjList_Atelier.length() - 1);
                }
                String mots_Atelier[] = nomjList_Atelier.split(", ");
                for (String mot1_Atelier : mots_Atelier) {
                    mot_Atelier = mot1_Atelier;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Atelier != 0) {
                    int incremjList_Atelier = 0;
                    for (int i = 0; i < jListModel_Atelier.size(); i++) {

                        String DocI_Atelier = (String) jListModel_Atelier.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Atelier.equals(mot_Atelier)){
                            incremjList_Atelier++;
                        }
                    }
                    if(incremjList_Atelier == 0){
                        if(nomjList_Atelier != null) {
                            jListModel_Atelier.addElement(mot_Atelier);   
                            jListModelle_Atelier.add(mot_Atelier);   
                        }
                    }
                }else {
                    jListModel_Atelier.addElement(mot_Atelier);
                    jListModelle_Atelier.add(mot_Atelier);
                }
                incemTest_Atelier++;
                //------------------------------------------------------Atelier----------------------------------------------------------
                
                //------------------------------------------------------GFH_Lignes----------------------------------------------------------
                String nomjList_GFH_Lignes = Rse.getString("GFH_Lignes");
                if("[".equals(nomjList_GFH_Lignes.substring(0, 1))){
                    nomjList_GFH_Lignes = nomjList_GFH_Lignes.substring(1);
                    nomjList_GFH_Lignes = nomjList_GFH_Lignes.substring(0, nomjList_GFH_Lignes.length() - 1);
                }
                String mots_GFH_Lignes[] = nomjList_GFH_Lignes.split(", ");
                for (String mot1_GFH_Lignes : mots_GFH_Lignes) {
                    mot_GFH_Lignes = mot1_GFH_Lignes;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_GFH_Lignes != 0) {
                    int incremjList_GFH_Lignes = 0;
                    for (int i = 0; i < jListModel_GFH_Lignes.size(); i++) {

                        String DocI_GFH_Lignes = (String) jListModel_GFH_Lignes.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_GFH_Lignes.equals(mot_GFH_Lignes)){
                            incremjList_GFH_Lignes++;
                        }
                    }
                    if(incremjList_GFH_Lignes == 0){
                        if(nomjList_GFH_Lignes != null) {
                            jListModel_GFH_Lignes.addElement(mot_GFH_Lignes);   
                            jListModelle_GFH_Lignes.add(mot_GFH_Lignes);   
                        }
                    }
                }else {
                    jListModel_GFH_Lignes.addElement(mot_GFH_Lignes);
                    jListModelle_GFH_Lignes.add(mot_GFH_Lignes);
                }
                incemTest_GFH_Lignes++;
                //------------------------------------------------------GFH_Lignes----------------------------------------------------------
                
                //------------------------------------------------------Machines----------------------------------------------------------
                String nomjList_Machines = Rse.getString("Machines");
                if("[".equals(nomjList_Machines.substring(0, 1))){
                    nomjList_Machines = nomjList_Machines.substring(1);
                    nomjList_Machines = nomjList_Machines.substring(0, nomjList_Machines.length() - 1);
                }
                String mots_Machines[] = nomjList_Machines.split(", ");
                for (String mot1_Machines : mots_Machines) {
                    mot_Machines = mot1_Machines;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Machines != 0) {
                    int incremjList_Machines = 0;
                    for (int i = 0; i < jListModel_Machines.size(); i++) {

                        String DocI_Machines = (String) jListModel_Machines.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Machines.equals(mot_Machines)){
                            incremjList_Machines++;
                        }
                    }
                    if(incremjList_Machines == 0){
                        if(nomjList_Machines != null) {
                            jListModel_Machines.addElement(mot_Machines);   
                            jListModelle_Machines.add(mot_Machines);   
                        }
                    }
                }else {
                    jListModel_Machines.addElement(mot_Machines);
                    jListModelle_Machines.add(mot_Machines);
                }
                incemTest_Machines++;
                //------------------------------------------------------Machines----------------------------------------------------------
                
                //------------------------------------------------------Sous_ensemble----------------------------------------------------------
                String nomjList_Sous_ensemble = Rse.getString("Sous_ensemble");
                if("[".equals(nomjList_Sous_ensemble.substring(0, 1))){
                    nomjList_Sous_ensemble = nomjList_Sous_ensemble.substring(1);
                    nomjList_Sous_ensemble = nomjList_Sous_ensemble.substring(0, nomjList_Sous_ensemble.length() - 1);
                }
                String mots_Sous_ensemble[] = nomjList_Sous_ensemble.split(", ");
                for (String mot1_Sous_ensemble : mots_Sous_ensemble) {
                    mot_Sous_ensemble = mot1_Sous_ensemble;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Sous_ensemble != 0) {
                    int incremjList_Sous_ensemble = 0;
                    for (int i = 0; i < jListModel_Sous_ensemble.size(); i++) {

                        String DocI_Sous_ensemble = (String) jListModel_Sous_ensemble.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Sous_ensemble.equals(mot_Sous_ensemble)){
                            incremjList_Sous_ensemble++;
                        }
                    }
                    if(incremjList_Sous_ensemble == 0){
                        if(nomjList_Sous_ensemble != null) {
                            jListModel_Sous_ensemble.addElement(mot_Sous_ensemble);   
                            jListModelle_Sous_ensemble.add(mot_Sous_ensemble);   
                        }
                    }
                }else {
                    jListModel_Sous_ensemble.addElement(mot_Sous_ensemble);
                    jListModelle_Sous_ensemble.add(mot_Sous_ensemble);
                }
                incemTest_Sous_ensemble++;
                //------------------------------------------------------Sous_ensemble----------------------------------------------------------
                
                //------------------------------------------------------Lieu_Archivage----------------------------------------------------------
                String nomjList_Lieu_Archivage = Rse.getString("Lieu_Archivage");
                if("[".equals(nomjList_Lieu_Archivage.substring(0, 1))){
                    nomjList_Lieu_Archivage = nomjList_Lieu_Archivage.substring(1);
                    nomjList_Lieu_Archivage = nomjList_Lieu_Archivage.substring(0, nomjList_Lieu_Archivage.length() - 1);
                }
                String mots_Lieu_Archivage[] = nomjList_Lieu_Archivage.split(", ");
                for (String mot1_Lieu_Archivage : mots_Lieu_Archivage) {
                    mot_Lieu_Archivage = mot1_Lieu_Archivage;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Lieu_Archivage != 0) {
                    int incremjList_Lieu_Archivage = 0;
                    for (int i = 0; i < jListModel_Lieu_Archivage.size(); i++) {

                        String DocI_Lieu_Archivage = (String) jListModel_Lieu_Archivage.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Lieu_Archivage.equals(mot_Lieu_Archivage)){
                            incremjList_Lieu_Archivage++;
                        }
                    }
                    if(incremjList_Lieu_Archivage == 0){
                        if(nomjList_Lieu_Archivage != null) {
                            jListModel_Lieu_Archivage.addElement(mot_Lieu_Archivage);  
                            jListModelle_Lieu_Archivage.add(mot_Lieu_Archivage);    
                        }
                    }
                }else {
                    jListModel_Lieu_Archivage.addElement(mot_Lieu_Archivage);
                    jListModelle_Lieu_Archivage.add(mot_Lieu_Archivage);
                }
                incemTest_Lieu_Archivage++;
                //------------------------------------------------------Lieu_Archivage----------------------------------------------------------
                
                //------------------------------------------------------Type_de_Materiel----------------------------------------------------------
                String nomjList_Type_de_Materiel = Rse.getString("Type_de_Materiel");
                if("[".equals(nomjList_Type_de_Materiel.substring(0, 1))){
                    nomjList_Type_de_Materiel = nomjList_Type_de_Materiel.substring(1);
                    nomjList_Type_de_Materiel = nomjList_Type_de_Materiel.substring(0, nomjList_Type_de_Materiel.length() - 1);
                }
                String mots_Type_de_Materiel[] = nomjList_Type_de_Materiel.split(", ");
                for (String mot1_Type_de_Materiel : mots_Type_de_Materiel) {
                    mot_Type_de_Materiel = mot1_Type_de_Materiel;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Type_de_Materiel != 0) {
                    int incremjList_Type_de_Materiel = 0;
                    for (int i = 0; i < jListModel_Type_de_Materiel.size(); i++) {

                        String DocI_Type_de_Materiel = (String) jListModel_Type_de_Materiel.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Type_de_Materiel.equals(mot_Type_de_Materiel)){
                            incremjList_Type_de_Materiel++;
                        }
                    }
                    if(incremjList_Type_de_Materiel == 0){
                        if(nomjList_Type_de_Materiel != null) { 
                            jListModel_Type_de_Materiel.addElement(mot_Type_de_Materiel);  
                            jListModelle_Type_de_Materiel.add(mot_Type_de_Materiel);  
                        }
                    }
                }else {
                    jListModel_Type_de_Materiel.addElement(mot_Type_de_Materiel);
                    jListModelle_Type_de_Materiel.add(mot_Type_de_Materiel);
                }
                incemTest_Type_de_Materiel++;
                //------------------------------------------------------Type_de_Materiel----------------------------------------------------------
                
                //------------------------------------------------------Constructeur----------------------------------------------------------
                String nomjList_Constructeur = Rse.getString("Constructeur");
                if("[".equals(nomjList_Constructeur.substring(0, 1))){
                    nomjList_Constructeur = nomjList_Constructeur.substring(1);
                    nomjList_Constructeur = nomjList_Constructeur.substring(0, nomjList_Constructeur.length() - 1);
                }
                String mots_Constructeur[] = nomjList_Constructeur.split(", ");
                for (String mot1_Constructeur : mots_Constructeur) {
                    mot_Constructeur = mot1_Constructeur;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Constructeur != 0) {
                    int incremjList_Constructeur = 0;
                    for (int i = 0; i < jListModel_Constructeur.size(); i++) {

                        String DocI_Constructeur = (String) jListModel_Constructeur.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Constructeur.equals(mot_Constructeur)){
                            incremjList_Constructeur++;
                        }
                    }
                    if(incremjList_Constructeur == 0){
                        if(nomjList_Constructeur != null) {
                            jListModel_Constructeur.addElement(mot_Constructeur);   
                            jListModelle_Constructeur.add(mot_Constructeur); 
                        }
                    }
                }else {
                    jListModel_Constructeur.addElement(mot_Constructeur);
                    jListModelle_Constructeur.add(mot_Constructeur);
                }
                incemTest_Constructeur++;
                //------------------------------------------------------Constructeur----------------------------------------------------------
                
                //------------------------------------------------------Annees----------------------------------------------------------
                String nomjList_Annees = Rse.getString("Annees");
                if("[".equals(nomjList_Annees.substring(0, 1))){
                    nomjList_Annees = nomjList_Annees.substring(1);
                    nomjList_Annees = nomjList_Annees.substring(0, nomjList_Annees.length() - 1);
                }
                String mots_Annees[] = nomjList_Annees.split(", ");
                for (String mot1_Annees : mots_Annees) {
                    mot_Annees = mot1_Annees;
                    ////System.out.println(mots[i]);
                }
                
                if(incemTest_Annees != 0) {
                    int incremjList_Annees = 0;
                    for (int i = 0; i < jListModel_Annees.size(); i++) {

                        String DocI_Annees = (String) jListModel_Annees.get(i);
                        //////System.out.printlnDocI "+DocI+" - mot "+mot);
                        if(DocI_Annees.equals(mot_Annees)){
                            incremjList_Annees++;
                        }
                    }
                    if(incremjList_Annees == 0){
                        if(nomjList_Annees != null) {
                            if((!" ".equals(mot_Annees)) && (mot_Annees != null)) {
                                System.out.println(mot_Annees);
                                jListModel_Annees.addElement(mot_Annees);  
                                jListModelle_Annees.add(mot_Annees);   
                            }
                        }
                    }
                }else {
                    if((!"".equals(mot_Annees)) || (mot_Annees != null)) {
                        jListModel_Annees.addElement(mot_Annees);
                        jListModelle_Annees.add(mot_Annees);
                    }
                }
                incemTest_Annees++;
                //------------------------------------------------------Annees----------------------------------------------------------
            }
           
            //Collections.sort((List<String>) jListModel_service);
            if (Listj24.isEmpty() || 1 == reini || this.jList24.getSelectedIndex()==-1) {
                //jList24.setModel(jListModel_service);
                trierArrayList(jList24, jListModelle_service);
            }if (Listj14.isEmpty() || 1 == reini || this.jList14.getSelectedIndex()==-1) {
//                jList14.setModel(jListModel_Type_de_document_N1);
                trierArrayList(jList14, jListModelle_Type_de_document_N1);    
            }if (Listj19.isEmpty() || 1 == reini || this.jList19.getSelectedIndex()==-1) {
//                jList19.setModel(jListModel_Type_de_document_N2);
                trierArrayList(jList19, jListModelle_Type_de_document_N2); 
            }if (Listj20.isEmpty() || 1 == reini || this.jList20.getSelectedIndex()==-1) {
//                jList20.setModel(jListModel_Type_de_document_N3);
                trierArrayList(jList20, jListModelle_Type_de_document_N3);
            }
            
            if (Listj15.isEmpty() || 1 == reini || this.jList15.getSelectedIndex()==-1) {
//                jList15.setModel(jListModel_Atelier);
                trierArrayList(jList15, jListModelle_Atelier);
            }if (Listj21.isEmpty() || 1 == reini || this.jList21.getSelectedIndex()==-1) {
//                jList21.setModel(jListModel_GFH_Lignes);
                trierArrayList(jList21, jListModelle_GFH_Lignes);
            }if (Listj22.isEmpty() || 1 == reini || this.jList22.getSelectedIndex()==-1) {
//                jList22.setModel(jListModel_Machines);
                trierArrayList(jList22, jListModelle_Machines);
            }if (Listj23.isEmpty() || 1 == reini || this.jList23.getSelectedIndex()==-1) {
//                jList23.setModel(jListModel_Sous_ensemble);
                trierArrayList(jList23, jListModelle_Sous_ensemble);
            }
            
            if (Listj12.isEmpty() || 1 == reini || this.jList12.getSelectedIndex()==-1) {
//                jList12.setModel(jListModel_Type_de_Materiel);
                trierArrayList(jList12, jListModelle_Type_de_Materiel);
            }if (Listj17.isEmpty() || 1 == reini || this.jList17.getSelectedIndex()==-1) {
//                jList17.setModel(jListModel_Constructeur);
                trierArrayList(jList17, jListModelle_Constructeur);
            }if (Listj16.isEmpty() || 1 == reini || this.jList16.getSelectedIndex()==-1) {
//                jList16.setModel(jListModel_Materiel);
                trierArrayList(jList16, jListModelle_Materiel);
            }if (Listj11.isEmpty() || 1 == reini || this.jList11.getSelectedIndex()==-1) {
//                jList11.setModel(jListModel_Lieu_Archivage);
                trierArrayList(jList11, jListModelle_Lieu_Archivage);
            }if (Listj18.isEmpty() || 1 == reini || this.jList18.getSelectedIndex()==-1) {
//                jList18.setModel(jListModel_Annees);
                //UntrierArrayList(jList18, jListModelle_Annees);
                
                UntrierArrayList(jList18, jListModelle_Annees);
            }
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
        
        
    }
    
    public void trierArrayList(JList jList, List<String> ListeTrier){
        
        Collections.sort(ListeTrier);
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < ListeTrier.size(); i++)
        {
            listModel.addElement(ListeTrier.get(i));
        }
        jList.setModel(listModel);
        
    }
    public void UntrierArrayList(JList jList, List<String> ListeTrier){
        
        Collections.reverse(ListeTrier);
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < ListeTrier.size(); i++)
        {
            listModel.addElement(ListeTrier.get(i));
        }
        jList.setModel(listModel);
        
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
System.exit(0);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
this.setState(main.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jList24ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList24ValueChanged

        if (1 != reini){
        affichetable();
        affichjList();
        countIndex();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24ValueChanged

    private void jList14ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList14ValueChanged
        if (1 != reini){
        affichetable();
        affichjList();
        countIndex();
        }


// TODO add your handling code here:
    }//GEN-LAST:event_jList14ValueChanged

    private void jList19ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList19ValueChanged

        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jList19ValueChanged

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList15ValueChanged

    private void jList17ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList17ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList17ValueChanged

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged

        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList21ValueChanged

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
  
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        // TODO add your handling code here:
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

    @SuppressWarnings("empty-statement")
    private void tlbRechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbRechercheMouseClicked
         
        //this.jTextField1.setSize(180, 32);
        this.btnModifier.setEnabled(true);
        int selection =  this.tlbRecherche.getSelectedRow();
        String selecttable = (String) this.tlbRecherche.getValueAt(selection,0);
        selecttable = selecttable.replaceAll("\'","\\\\'");
        ////System.out.println(selecttable);
        
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rs=stm.executeQuery("SELECT `id` FROM `bddmaintenance` WHERE `fichier` LIKE '"+selecttable+"'");
            while(Rs.next()){
                idFichier = Rs.getString("id");
            }
            ////System.out.println(idFichier);
        }catch(SQLException e){System.err.println(e);}
        
        //SELECT `id` FROM `bddmaintenance` WHERE `fichier` LIKE "dsdvs"
        
        
         if (evt.getClickCount() == 2) {
      //code à exécuter
        int selectedRow = tlbRecherche.getSelectedRow();
       
       String nomdufichier = (tlbRecherche.getValueAt(selectedRow,0).toString());
         
        String chemindacces = (tlbRecherche.getValueAt(selectedRow,1).toString());
        String chemincomplet;
        chemincomplet = chemindacces + nomdufichier;
        chemincomplet = chemincomplet.replaceAll("\n", "");
             //////System.out.printlnnom du chemincomplet :"+chemincomplet);
             
      try {
        String nomFichier = chemincomplet;
        File pdfFile = new File(nomFichier);
        if (pdfFile.exists()) {

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(null, 
                              "Il semble que votre Système d'exploitation ne supporte pas ce type de fichier.", 
                              "Erreur de version.", 
                              JOptionPane.WARNING_MESSAGE);
                //////System.out.printlnAwt Desktop is not supported!");
            }

        } else {
         JOptionPane.showMessageDialog(null, 
                              "Le fichier " + "'" + nomdufichier + "'" + " n'est pas valide. Vérifiez son emplacement puis réessayez.", 
                              "Ouverture du fichier interrompue.", 
                              JOptionPane.WARNING_MESSAGE);
            //////System.out.printlnFile is not exists!");
        }

        //////System.out.printlnDone");

      } catch (HeadlessException | IOException ex) {
      }        // TODO add your handling code here:
       
 }
  
                                   
    }//GEN-LAST:event_tlbRechercheMouseClicked

    private void txtRechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRechercheKeyReleased
      
        if (1 != reini){
            BeforeSelectedList = true;
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_txtRechercheKeyReleased
    
    private String separerEspace(String motEspace) {
        
        final String SEPARATEUR = " ";
        
        String requeteSQL = null;
        
        String mots[] = motEspace.split(SEPARATEUR);
 
        //System.out.println("------------------------");
        for (int i = 0; i < mots.length; i++) {
            
            mots[i]=mots[i].replaceAll("\'","\\\\'");
            //System.out.println(mots[i]);
            requeteSQL = requeteSQL +"AND `fichier` LIKE ('%"+ mots[i]+"%') ";
        }
        requeteSQL = requeteSQL.substring(7);
        //System.out.println(requeteSQL);
        //affichRechercheMotClef(requeteSQL);
        
        
        
            //System.out.println("------------------------");
        //SELECT * FROM `bddmaintenance` WHERE `fichier` LIKE ("%r422%") AND `fichier` LIKE ("%recomm%")
        return requeteSQL;
    }
    
    private void filtreNom() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tlbRecherche.getModel());
        tlbRecherche.setRowSorter(rowSorter);
        final String filterValue = txtRecherche.getText().trim();
        if (filterValue.isEmpty()) {
            rowSorter.setRowFilter(null);
        }else {
            RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
                    String name = (String) entry.getValue(0); // colonne nom
                    return startsWithIgnoreCase(name, filterValue);
                }
                private boolean startsWithIgnoreCase(String string, String prefix) {
                    return string.toLowerCase().startsWith(prefix.toLowerCase());
                }
            };
            rowSorter.setRowFilter(filter);
        }
 
    }
    
  
    
    
    private void jList12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList12ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList12ValueChanged

    private void jList16ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList16ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList16ValueChanged

    private void jList11VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jList11VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jList11VetoableChange

    private void jList11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList11ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList11ValueChanged

    private void jList18ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList18ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList18ValueChanged

    private void jList23ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList23ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jList23ValueChanged

    private void jList20ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList20ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList20ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
        reini();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
 jPanel6.setBackground(new Color (0,136,198));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
 jPanel6.setBackground(new Color (0,86,172)); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        jPanel6.setBackground(new Color (0,86,172));
        jPanel6.setBackground(new Color (0,136,198));
        final JFileChooser fileDialog = new JFileChooser();
        String filenames = "";
        String fileName = "";
        String filepath = "";
        String cheminseul;
        //In response to a button click:
        fileDialog.setMultiSelectionEnabled(true);
        int option = fileDialog.showOpenDialog(null);
        //to select mulitple files
        tableauindex.getDataVector().clear();
        int COUNT_INDEXER = 0;
        int nb = 47;
        if(option == JFileChooser.APPROVE_OPTION) 
        {
            File file1 = fileDialog.getSelectedFile();
            fileName = file1.getName();
            fileName=fileName.replaceAll("\'", "\\\\'");
            ////System.out.printlnFile "+fileName);
            if(fileDialog.isMultiSelectionEnabled()){
              //  File[] files = getSelectedFiles(fileDialog);
                final File[] files = fileDialog.getSelectedFiles();
                
                if (files != null && files.length > 0){
                    
                    int nbColonne = tableauindex.getColumnCount();
                    ////System.out.println(nbColonne);
                    if (nbColonne>2){
                                        
                        //////System.out.printlnNumero >2");
                        tableauindex.setColumnCount(2);
                    }
                    
                    if (files.length !=1){
                        
                        for (File file : files) {
                            filenames = file.getName();
                            filepath = file.getPath();
                            try {
                                stm=conn.obtenirconnexion().createStatement();
                                ResultSet Rs = stm.executeQuery("SELECT COUNT(*) FROM `bddmaintenance` WHERE `fichier` = '"+filenames+"'");
                                while(Rs.next()) {
                                    nb = Rs.getInt(1);
                                }
                                if (nb==0) {
                                    COUNT_INDEXER++;
                                    ////////System.out.printlnFichiers pas encore indexer");
                                    String cheminse;
                                    cheminse = file.getPath().replace(file.getName(), "");
                                    //////System.out.println(cheminse);
                                    cheminse=cheminse.replaceAll("\\\\", "/");
                                    filenames = filenames.replaceAll("\'", "\\\\'");
                                    tableauindex.addRow(new Object []{filenames, cheminse});
                                    
                                } else {
                                    //////System.out.printlnFichiers déja indexer "+COUNT_INDEXER);
                                }
                            }catch (SQLException ex) {
                                ////System.out.println(ex.getMessage());
                            } 
                        }
                        indexation_multiple indm = new indexation_multiple();
                        indm.setVisible(true);
                        this.dispose();
                        if(0==COUNT_INDEXER){
                            //////System.out.printlnTout les fichiers séléctionner ont déja été indexer");
                            int messageType = 0;
                            JOptionPane.showMessageDialog(null, "Tout les fichiers séléctionner ont déja été indexer", "Indexer des fichiers", messageType);
                        }else {
                            //////System.out.printlnCertains des fichiers séléctionner ont déja été indexer");
                            int messageType = 0;
                            //JOptionPane.showMessageDialog(null, "Certains des fichiers séléctionner ont déja été indexer", "Indexer des fichiers", messageType);
                        }

                         
                    } else {

                        File selectedFile = fileDialog.getSelectedFile();
                        String testt = selectedFile.getName();
                        testt = testt.replaceAll("\'", "\\\\'");
                        //System.out.println(testt);
                        try {
                            stm=conn.obtenirconnexion().createStatement();
                            //////System.out.printlnSELECT COUNT(*) FROM `bddmaintenance` WHERE `fichier` = '"+testt+"'");
                            ResultSet Rs = stm.executeQuery("SELECT COUNT(*) FROM `bddmaintenance` WHERE `fichier` = '"+testt+"'");
                            while(Rs.next()) {nb = Rs.getInt(1);}
                            if (nb==0) {
                                String cheseul = selectedFile.getPath().replace(selectedFile.getName(), "");
                                //////System.out.printlnFichier NON indexer");
                                cheseul = cheseul.replaceAll("\\\\", "/");
                                //filenames = filenames.replaceAll("\'", "\\\\'");
                                //////System.out.println(cheseul);
                                test_txt.setText(testt);
                                cheminseul_txt.setText(cheseul);
                                indexation ind = new indexation();
                                ind.setVisible(true);
                                this.dispose();
                            }else {
                                //////System.out.printlnFichier déja indexer "+COUNT_INDEXER);
                                int messageType = 0;
                                JOptionPane.showMessageDialog(null, "Le fichier à déja été indexer", "Indexer un fichier", messageType);
                            }
                            
                            
                            
                            

                        } catch (SQLException ex) {
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                              
                   }
                
                
            }
         } else if (option == JFileChooser.CANCEL_OPTION){
             
                
   
    
    } 
        }
       
             // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        if (main.connect == false) {
            admin adm = new admin();
            adm.setVisible(true);
            main.page = "modification";
            this.dispose();
        } else {
            modification modif = new modification();
            modif.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifierMouseClicked
   
           
   
// TODO add your handling code here:
    }//GEN-LAST:event_btnModifierMouseClicked

    private void lblConnecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseClicked
        if (main.connect == false) {
            admin adm = new admin();
            adm.setVisible(true);
            main.page = "recherche";
            this.dispose();
        }
    }//GEN-LAST:event_lblConnecterMouseClicked

    private void jList14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList14MouseClicked

      // TODO add your handling code here:
    }//GEN-LAST:event_jList14MouseClicked

    private void jList24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList24MouseReleased
//        affichjList();
//        affichetable();
    }//GEN-LAST:event_jList24MouseReleased

    private void jList24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList24MouseClicked
        ////System.out.printlnMouse clicked");

        ////System.out.println(this.jList14.getSelectedIndex());
        
        //AnitBUG();
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24MouseClicked

    private void jList24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList24MousePressed
//////System.out.printlnMouse pressed");        // TODO add your handling code here:
    }//GEN-LAST:event_jList24MousePressed

    private void jList14ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jList14ComponentRemoved

        // TODO add your handling code here:
    }//GEN-LAST:event_jList14ComponentRemoved

    private void jList14ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList14ComponentResized
        //System.out.println("jList14 Component esized");

    }//GEN-LAST:event_jList14ComponentResized

    private void jList14ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList14ComponentShown
     // TODO add your handling code here:
    }//GEN-LAST:event_jList14ComponentShown

    private void jList14ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList14ComponentMoved
      // TODO add your handling code here:
    }//GEN-LAST:event_jList14ComponentMoved

    private void jList14AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jList14AncestorMoved
    // TODO add your handling code here:
    }//GEN-LAST:event_jList14AncestorMoved

    private void jList14AncestorMoved1(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jList14AncestorMoved1

    }//GEN-LAST:event_jList14AncestorMoved1

    private void jList14AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jList14AncestorRemoved

        // TODO add your handling code here:
    }//GEN-LAST:event_jList14AncestorRemoved

    private void jList14AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jList14AncestorResized
         // TODO add your handling code here:
    }//GEN-LAST:event_jList14AncestorResized

    private void jList14CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jList14CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList14CaretPositionChanged

    private void jList24ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList24ComponentResized

        //System.out.println("JList24 Component resized");        // TODO add your handling code here:
    }//GEN-LAST:event_jList24ComponentResized

    private void jList19ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList19ComponentResized

        ////System.out.println("JList19 Component resized");        // TODO add your handling code here:
    }//GEN-LAST:event_jList19ComponentResized

    private void jList20ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jList20ComponentResized

        ////System.out.println("JList20 Component resized");        // TODO add your handling code here:
    }//GEN-LAST:event_jList20ComponentResized

    private void jList24AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jList24AncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24AncestorResized

    private void jList24HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jList24HierarchyChanged
    //System.out.println("JList24 Hierarchy Changed");
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24HierarchyChanged

    private void txtRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRechercheActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtRechercheActionPerformed

    private void lblConnecterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseEntered
if (connect == false){
        jPanel12.setBackground(new Color (0,136,198)); 
        
}   // TODO add your handling code here:
    }//GEN-LAST:event_lblConnecterMouseEntered

    private void lblConnecterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseExited
 if (connect == false){
        jPanel12.setBackground(new Color (0,86,172));
  }
        // TODO add your handling code here:
    }//GEN-LAST:event_lblConnecterMouseExited

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

        option option = new option();
        option.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

        OpenFile("I:\\Maintenance\\DocFinder\\DocFinder JAVA\\DocFinder\\PRODUCTION\\DFprod_Recherche.jar")   ;
this.dispose();  
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered

        jPanel18.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jPanel18.setBackground(new Color (0,86,172));          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
        jPanel18.setBackground(new Color (0,136,198));
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited

        jPanel18.setBackground(new Color (0,86,172));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited
   
    private void AnitBUG() {
        if((this.jList24.getSelectedIndex()==-1)&&(this.jList14.getSelectedIndex()==-1)){
            reini();
        }       
    }
    
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
    
    private void reini(){
        
        DefaultListModel Renitialisation=new DefaultListModel();
        Renitialisation.addElement("");
        this.txtRecherche.setText("");
        filtreNom();
        
        this.btnModifier.setEnabled(false);
        affichetable();
        reini = 1;
            ListJList = "`service` LIKE '%%'";

            ListJList7 = "`Type_de_document_N1` LIKE '%%'";

            ListJList8 = "`Type_de_document_N2` LIKE '%%'";

            ListJList9 = "`Type_de_document_N3` LIKE '%%'";

            ListJList1 = "`Lieu_Archivage` LIKE '%%'";

            ListJList2 = "`Type_de_Materiel` LIKE '%%'";

            ListJList3 = "`Constructeur` LIKE '%%'";

            ListJList4 = "`Materiel` LIKE '%%'";

            ListJList10 = "`Atelier` LIKE '%%'";

            ListJList11 = "`GFH_Lignes` LIKE '%%'";

            ListJList12 = "`Machines` LIKE '%%'";

            ListJList13 = "`Sous_ensemble` LIKE '%%'";

            ListJList5 = "`Annees` LIKE '%%'";
            
            BeforeSelectedList = false;
            affichjList();
            affichetable();
            this.countIndex();
        reini = 0;
    }
    private void affichetable() {
         //Valeur JLIST ------------------------------------------------------------------------------------------------
         List<String> SQLJList = jList24.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList.isEmpty()) {
            ListJList = "`service` LIKE '%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList.size()) {
                case 1:
                    
                    ListJList = ListJList + SQLJList.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList = ListJList+" OR `service` LIKE '%"+ SQLJList.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList = ListJList+" OR `service` LIKE '%"+ SQLJList.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
        if( "".equals(ListJList)){
            ListJList = "`service` LIKE '%%'";
        }
            if(0==SupprElem){
                ListJList = ListJList.substring(20);
            }
        //////System.out.println(ListJList);
        //`service` LIKE '%Prod%' OR `service` LIKE '%Main%'
        }
        ////System.out.println(ListJList);
        ////////System.out.println"+ListJList);
        
        //Valeur JLIST7 ------------------------------------------------------------------------------------------------
        
        List<String> SQLJList7 = jList14.getSelectedValuesList();
        //String ListJList7 = "";
        if (!SQLJList7.isEmpty()) {
        int SupprElem = 0;
            ListJList7 = "`Type_de_document_N1` LIKE '%";
            for(int i=0; i<SQLJList7.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList7.size()) {
                case 1:
                    ListJList7 = ListJList7 + SQLJList7.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList7 = ListJList7+" OR `Type_de_document_N1` LIKE '%"+ SQLJList7.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList7 = ListJList7+" OR `Type_de_document_N1` LIKE '%"+ SQLJList7.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList7 = ListJList7.substring(33);
            }
        //////System.out.printlnService: "+ListJList);
        //////System.out.printlnN1: "+ListJList7);
        }
        ////////System.out.printlnType_de_document_N1 "+ListJList7);

        //Valeur JLIST8 ------------------------------------------------------------------------------------------------
        
        List<String> SQLJList8 = jList19.getSelectedValuesList();
        //String ListJList8 = "";
        if (!SQLJList8.isEmpty()) {
            int SupprElem = 0;
            ListJList8 = "`Type_de_document_N2` LIKE '%";
            for(int i=0; i<SQLJList8.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList8.size()) {
                case 1:
                    ListJList8 = ListJList8 + SQLJList8.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList8 = ListJList8+" OR `Type_de_document_N2` LIKE '%"+ SQLJList8.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList8 = ListJList8+" OR `Type_de_document_N2` LIKE '%"+ SQLJList8.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList8 = ListJList8.substring(33);
            }
        //////System.out.printlnN2: "+ListJList8);
        }
        ////////System.out.printlnType_de_document_N1 "+ListJList7);

        //Valeur JLIST9 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList9 = jList20.getSelectedValuesList();
        //String ListJList9 = "";
        if (!SQLJList9.isEmpty()) {
            int SupprElem = 0;
            ListJList9 = "`Type_de_document_N3` LIKE '%";
            for(int i=0; i<SQLJList9.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList9.size()) {
                case 1:
                    ListJList9 = ListJList9 + SQLJList9.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList9 = ListJList9+" OR `Type_de_document_N3` LIKE '%"+ SQLJList9.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList9 = ListJList9+" OR `Type_de_document_N3` LIKE '%"+ SQLJList9.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList9 = ListJList9.substring(33);
            }
        //////System.out.printlnN3: "+ListJList9);
        }
        ////////System.out.printlnType_de_document_N3 "+ListJList9);

        //Valeur JLIST10 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList10 = jList15.getSelectedValuesList();
        //String ListJList10 = "";
        if (!SQLJList10.isEmpty()) {
            int SupprElem = 0;
            ListJList10 = "`Atelier` LIKE '%";
            for(int i=0; i<SQLJList10.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList10.size()) {
                case 1:
                    ListJList10 = ListJList10 + SQLJList10.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList10 = ListJList10+" OR `Atelier` LIKE '%"+ SQLJList10.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList10 = ListJList10+" OR `Atelier` LIKE '%"+ SQLJList10.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList10 = ListJList10.substring(20);
            }
        //////System.out.printlnN3: "+ListJList10);
        }
        ////////System.out.printlnAtelier "+ListJList10);

        //Valeur JLIST11 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList11 = jList21.getSelectedValuesList();
        //String ListJList11 = "";
        if (!SQLJList11.isEmpty()) {
            int SupprElem = 0;
            ListJList11 = "`GFH_Lignes` LIKE '%";
            for(int i=0; i<SQLJList11.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList11.size()) {
                case 1:
                    ListJList11 = ListJList11 + SQLJList11.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList11 = ListJList11+" OR `GFH_Lignes` LIKE '%"+ SQLJList11.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList11 = ListJList11+" OR `GFH_Lignes` LIKE '%"+ SQLJList11.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList11 = ListJList11.substring(24);
            }
        //////System.out.printlnN3: "+ListJList11);
        }
        ////////System.out.printlnGFH_Lignes "+ListJList11);

        //Valeur JLIST12 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList12 = jList22.getSelectedValuesList();
        //String ListJList12 = "";
        if (!SQLJList12.isEmpty()) {
            int SupprElem = 0;
            ListJList12 = "`Machines` LIKE '%";
            for(int i=0; i<SQLJList12.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList12.size()) {
                case 1:
                    ListJList12 = ListJList12 + SQLJList12.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList12 = ListJList12+" OR `Machines` LIKE '%"+ SQLJList12.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList12 = ListJList12+" OR `Machines` LIKE '%"+ SQLJList12.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList12 = ListJList12.substring(22);
            }

        //////System.out.printlnN3: "+ListJList12);
        }
        ////////System.out.printlnMachines "+ListJList12);

        //Valeur JLIST13 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList13 = jList23.getSelectedValuesList();
        //String ListJList13 = "";
        if (!SQLJList13.isEmpty()) {
            int SupprElem = 0;
            ListJList13 = "`Sous_ensemble` LIKE '%";
            for(int i=0; i<SQLJList13.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList13.size()) {
                case 1:
                    ListJList13 = ListJList13 + SQLJList13.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList13 = ListJList13+" OR `Sous_ensemble` LIKE '%"+ SQLJList13.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList13 = ListJList13+" OR `Sous_ensemble` LIKE '%"+ SQLJList13.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList13 = ListJList13.substring(26);
            }
        //////System.out.printlnN3: "+ListJList13);
        }
        ////////System.out.printlnSous_ensemble "+ListJList13);

        //Valeur JLIST1 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList1 = jList11.getSelectedValuesList();
        //String ListJList1 = "";
        if (!SQLJList1.isEmpty()) {
            int SupprElem = 0;
            ListJList1 = "`Lieu_Archivage` LIKE '%";
            for(int i=0; i<SQLJList1.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList1.size()) {
                case 1:
                    ListJList1 = ListJList1 + SQLJList1.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList1 = ListJList1+" OR `Lieu_Archivage` LIKE '%"+ SQLJList1.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList1 = ListJList1+" OR `Lieu_Archivage` LIKE '%"+ SQLJList1.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList1 = ListJList1.substring(28);
            }
        //////System.out.printlnN3: "+ListJList1);
        }
        ////////System.out.printlnLieu_Archivage "+ListJList1);

        //Valeur JLIST2 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList2 = jList12.getSelectedValuesList();
        //String ListJList2 = "";
        if (!SQLJList2.isEmpty()) {
            int SupprElem = 0;
            ListJList2 = "`Type_de_Materiel` LIKE '%";
            for(int i=0; i<SQLJList2.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList2.size()) {
                case 1:
                    ListJList2 = ListJList2 + SQLJList2.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList2 = ListJList2+" OR `Type_de_Materiel` LIKE '%"+ SQLJList2.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList2 = ListJList2+" OR `Type_de_Materiel` LIKE '%"+ SQLJList2.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList2 = ListJList2.substring(30);
            }
        //////System.out.printlnN3: "+ListJList2);
        }
        ////////System.out.printlnType_de_Materiel "+ListJList2);

        //Valeur JLIST3 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList3 = jList17.getSelectedValuesList();
        //String ListJList3 = "";
        if (!SQLJList3.isEmpty()) {
            int SupprElem = 0;
            ListJList3 = "`Constructeur` LIKE '%";
            for(int i=0; i<SQLJList3.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList3.size()) {
                case 1:
                    ListJList3 = ListJList3 + SQLJList3.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList3 = ListJList3+" OR `Constructeur` LIKE '%"+ SQLJList3.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList3 = ListJList3+" OR `Constructeur` LIKE '%"+ SQLJList3.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList3 = ListJList3.substring(25);
            }
        //////System.out.printlnN3: "+ListJList3);
        }
        ////////System.out.printlnConstructeur "+ListJList3);

        //Valeur JLIST4 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList4 = jList16.getSelectedValuesList();
        //String ListJList4 = "";
        if (!SQLJList4.isEmpty()) {
            int SupprElem = 0;
            ListJList4 = "`Materiel` LIKE '%";
            for(int i=0; i<SQLJList4.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList4.size()) {
                case 1:
                    ListJList4 = ListJList4 + SQLJList4.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList4 = ListJList4+" OR `Materiel` LIKE '%"+ SQLJList4.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList4 = ListJList4+" OR `Materiel` LIKE '%"+ SQLJList4.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList4 = ListJList4.substring(22);
            }
        //////System.out.printlnN3: "+ListJList4);
        }
        ////////System.out.printlnMateriel "+ListJList4);

        //Valeur JLIST5 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList5 = jList18.getSelectedValuesList();
        //String ListJList5 = "";
        if (!SQLJList5.isEmpty()) {
            int SupprElem = 0;
            ListJList5 = "`Annees` LIKE '%";
            for(int i=0; i<SQLJList5.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList5.size()) {
                case 1:
                    ListJList5 = ListJList5 + SQLJList5.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList5 = ListJList5+" OR `Annees` LIKE '%"+ SQLJList5.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList5 = ListJList5+" OR `Annees` LIKE '%"+ SQLJList5.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList5 = ListJList5.substring(20);
            }
        //////System.out.printlnAnnees: "+ListJList5);
        }
        ////////System.out.printlnAnnees "+ListJList5);
        
        
        int nb = 0;

        try {
            if( "".equals(ListJList)){
            ListJList = "`service` LIKE '%%'";
            }if( "".equals(ListJList7)){
            ListJList7 = "`Type_de_document_N1` LIKE '%%'";
            }if( "".equals(ListJList8)){
            ListJList8 = "`Type_de_document_N2` LIKE '%%'";
            }if( "".equals(ListJList9)){
            ListJList9 = "`Type_de_document_N3` LIKE '%%'";
            }if( "".equals(ListJList1)){
            ListJList1 = "`Lieu_Archivage` LIKE '%%'";
            }if( "".equals(ListJList2)){
            ListJList2 = "`Type_de_Materiel` LIKE '%%'";
            }if( "".equals(ListJList3)){
            ListJList3 = "`Constructeur` LIKE '%%'";
            }if( "".equals(ListJList4)){
            ListJList4 = "`Materiel` LIKE '%%'";
            }if( "".equals(ListJList10)){
            ListJList10 = "`Atelier` LIKE '%%'";
            }if( "".equals(ListJList11)){
            ListJList11 = "`GFH_Lignes` LIKE '%%'";
            }if( "".equals(ListJList12)){
            ListJList12 = "`Machines` LIKE '%%'";
            }if( "".equals(ListJList13)){
            ListJList13 = "`Sous_ensemble` LIKE '%%'";
            }if( "".equals(ListJList5)){
            ListJList5 = "`Annees` LIKE '%%'";
            }
            
            RechercheMotClef = separerEspace(this.txtRecherche.getText());
            //System.out.println(Recherche);
            
            stm=conn.obtenirconnexion().createStatement();

            ResultSet Rs=stm.executeQuery("SELECT * FROM `bddmaintenance` WHERE ("+ListJList+") "
                      + "AND ("+ListJList7+") "
                      + "AND ("+ListJList8+") "
                      + "AND ("+ListJList9+") "
                      + "AND ("+ListJList1+") "
                      + "AND ("+ListJList2+") "
                      + "AND ("+ListJList3+") "
                      + "AND ("+ListJList4+") "
                      + "AND ("+ListJList10+") "
                      + "AND ("+ListJList11+") "
                      + "AND ("+ListJList12+") "
                      + "AND ("+ListJList13+") "
                      + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + "ORDER BY `fichier` ASC");
            
            model.setRowCount(0);

        while(Rs.next()){
            model.addRow(new Object[]{Rs.getString("fichier"),Rs.getString("chemin")});
        }

        tlbRecherche.setModel(model);
        
        
        

        }catch(SQLException e){
            System.err.println(e);
            System.out.println("TEST ANTI BUG");
        }
        
        
        
    }
    

    private void countIndex() {
        int nb = 0;
        nb = this.tlbRecherche.getRowCount();
        
        if (nb != 0){
            String nbFichier = "Nombre de fichier correspondant à votre recherche : "+nb;
            this.jLabel27.setText(nbFichier);
        
        }else {
            JOptionPane.showMessageDialog(null,"AUCNUN FICHIER ");
            
            reini();
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
            java.util.logging.Logger.getLogger(recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new recherche().setVisible(true);
               
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList11;
    private javax.swing.JList<String> jList12;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList16;
    private javax.swing.JList<String> jList17;
    private javax.swing.JList<String> jList18;
    private javax.swing.JList<String> jList19;
    private javax.swing.JList<String> jList20;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JList<String> jList24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblConnecter;
    private javax.swing.JTable tlbRecherche;
    private javax.swing.JTextField txtRecherche;
    // End of variables declaration//GEN-END:variables


}
