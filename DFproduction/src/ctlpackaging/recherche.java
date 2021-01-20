package ctlpackaging;

import static ctlpackaging.main.cheminseul_txt;
import static ctlpackaging.main.connect;
import static ctlpackaging.main.tableauindex;
import static ctlpackaging.main.test_txt;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
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
    private String ListJList10 = "";
    private String ListJList11 = "";
    private String ListJList12 = "";
    private String ListJList13 = "";
    private String ListJList5 = "";
    private boolean BeforeSelectedList = false;
    private String RechercheMotClef;
    
    
    public recherche() {
        
        initComponents();
        connecter();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Recherche");
        RecupFichier.setCurrentSoftware("Production", "recherche");
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
        ResultSet Rs=stm.executeQuery("Select * from bddproduction ORDER BY `fichier` ASC");
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
       String ligne = RecupFichier.getPropertiesLigne();
       this.jList21.setSelectedValue(ligne, true);
       if (this.jList21.getSelectedIndex()!=-1) {
        this.jList15.setSelectedIndex(0);
       }
    }

    private String searchVersion(String fichier){
        final String SEPARATEUR = " ";
        String mots[] = fichier.split(SEPARATEUR);
 
        for (int i = 0; i < mots.length; i++) {
            String mot = mots[i];
            
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
        return "[]";
    }
    
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
  }
  
    
    public void connecter() {
        
        if (main.connect == false) {
            ////System.out.printlnSe connecter ?");
            this.lblConnecter.setText("SE CONNECTER ?");
            this.jPanel6.setVisible(false);
            this.jLabel21.setVisible(false);
        }else {jPanel12.setBackground(new Color (0,136,198)); 
            ////System.out.printlnConnecter : ADMIN");
            this.lblConnecter.setText("Connecté : ADMIN");
            this.jPanel6.setVisible(true);
            this.jLabel21.setVisible(true);
        }
        
    }
    
    
    
    private recherche(Runnable aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane24 = new javax.swing.JScrollPane();
        jList24 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
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
        jPanel19 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jList18 = new javax.swing.JList<>();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tlbRecherche = new javax.swing.JTable();
        txtRecherche = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Service : ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

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
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
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
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        lblConnecter.setText(" SE CONNECTER ?");
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

        jPanel19.setBackground(new java.awt.Color(0, 136, 198));
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

        jLabel29.setBackground(new java.awt.Color(0, 136, 198));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/processor_24px.png"))); // NOI18N
        jLabel29.setText("MODE PRODUCTION");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(0, 86, 172));
        jPanel20.setPreferredSize(new java.awt.Dimension(210, 45));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/full_tool_storage_box_24px.png"))); // NOI18N
        jLabel30.setText("MODE TECHNIQUE");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
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
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jList14AncestorRemoved(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jList14AncestorMoved(evt);
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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Version :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Type de document N1 :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Atelier :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Machine :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Sous-ensemble :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("GFH - Ligne : ");

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
        tlbRecherche.setTableHeader(null);
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
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel17)
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(170, 170, 170)
                                .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModifier)
                        .addComponent(jLabel16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane14))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void affichjList() {
            if( "".equals(ListJList)){
            ListJList = "`service` LIKE '%%'";
            }if( "".equals(ListJList7)){
            ListJList7 = "`Type_de_document_N1` LIKE '%%'";
            }if( "".equals(ListJList10)){
            ListJList10 = "`Atelier` LIKE '%%'";
            }if( "".equals(ListJList11)){
            ListJList11 = "`GFH_Lignes` LIKE '%%'";
            }if( "".equals(ListJList12)){
            ListJList12 = "`Machines` LIKE '%%'";
            }if( "".equals(ListJList13)){
            ListJList13 = "`Sous_ensemble` LIKE '%%'";
            }if( "".equals(ListJList5)){
            ListJList5 = "`Version` LIKE '%%'";
            }
        affichjList24();
        affichjList14();
        
        affichjList15();
        affichjList21();
        affichjList22();
        affichjList23();
        
        affichjList18();
        
        
    }
    
    private void affichjList24() /*service*/ {
        try {
            List<String> Listj24 = jList24.getSelectedValuesList();
            //System.out.println("Listj24 "+Listj24);
            ////System.out.println(this.jList24.getSelectedIndex());
            if (Listj24.isEmpty() || 1 == reini || this.jList24.getSelectedIndex()==-1) {
                //System.out.println("BeforeSelectedList "+BeforeSelectedList);
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
            ListJList = "`service` LIKE '%%'";
            
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` ORDER BY `service` ASC");
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `fichier` ASC");`service` LIKE '%%'
            ////System.out.println(ListJList+" + "+ListJList7);
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + "ORDER BY `service` ASC");
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            String mott;
            while(Rse.next())
            {   
                String nomjList = Rse.getString("service");
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
            jList24.setModel(jListModel);
        }
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
        
        
    }

    private void affichjList14() /*Type_de_document_N1*/ {
        List<String> Listj24 = jList14.getSelectedValuesList();
        //System.out.println("Listj14 "+Listj24);
            ////System.out.println(Listj24);
               
            if (Listj24.isEmpty() || 1 == reini || this.jList14.getSelectedIndex()==-1) {                                         
            if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
            }
        try {
            ListJList7 = "`Type_de_document_N1` LIKE '%%'";
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+")"
                      + "AND "+RechercheMotClef
                      + " ORDER BY `Type_de_document_N1` ASC");
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {   
                String nomjList = Rse.getString("Type_de_document_N1");
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
            jList14.setModel(jListModel);

        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
            }
        
    }
   
    private void affichjList15() /*Atelier*/ {
        List<String> Listj24 = jList15.getSelectedValuesList();
            ////System.out.println(Listj24);
            if (Listj24.isEmpty() || 1 == reini) {    
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
        try {
            stm=conn.obtenirconnexion().createStatement();
            ListJList10 = "`Atelier` LIKE '%%'";
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+")  "
                      + "AND "+RechercheMotClef
                      + "ORDER BY `Atelier` ASC");
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Atelier");
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

    private void affichjList21() /*GFH_Lignes*/ {
        List<String> Listj24 = jList21.getSelectedValuesList();
            ////System.out.println(Listj24);
            if (Listj24.isEmpty() || 1 == reini) {   
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
        try {
            stm=conn.obtenirconnexion().createStatement();
            ListJList11 = "`GFH_Lignes` LIKE '%%'";
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+")  "
                      + "AND "+RechercheMotClef
                      + "ORDER BY `GFH_Lignes` ASC");
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {   
                String nomjList = Rse.getString("GFH_Lignes");
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
        
            }
    }
    
    private void affichjList22() /*Machines*/ {
        List<String> Listj24 = jList22.getSelectedValuesList();
            ////System.out.println(Listj24);
            if (Listj24.isEmpty() || 1 == reini) {    
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
        try {
            stm=conn.obtenirconnexion().createStatement();
            ListJList12 = "`Machines` LIKE '%%'";
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + " ORDER BY `Machines` ASC");
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

    private void affichjList23() /*Sous_ensemble*/ {
        List<String> Listj24 = jList23.getSelectedValuesList();
        if (1 == reini || Listj24.isEmpty()) {      
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
            try {
                stm=conn.obtenirconnexion().createStatement();
                ListJList13 = "`Sous_ensemble` LIKE '%%'";
                //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
                ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                      + "AND ("+ListJList7+") "
                      + "AND ("+ListJList10+") "
                      + "AND ("+ListJList11+") "
                      + "AND ("+ListJList12+") "
                      + "AND ("+ListJList13+") "
                      + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + " ORDER BY `Sous_ensemble` ASC");
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

    private void affichjList18() /*Version*/{ 
        List<String> Listj24 = jList18.getSelectedValuesList();
            ////System.out.println(Listj24);
            if (Listj24.isEmpty() || 1 == reini) { 
                if (BeforeSelectedList == false){
                this.txtRecherche.setText("");
                filtreNom();
                }
        try {
            stm=conn.obtenirconnexion().createStatement();
            ListJList5 = "`Version` LIKE '%%'";
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                  + "AND ("+ListJList7+") "
                  + "AND ("+ListJList10+") "
                  + "AND ("+ListJList11+") "
                  + "AND ("+ListJList12+") "
                  + "AND ("+ListJList13+") "
                  + "AND ("+ListJList5+") "
                      + "AND "+RechercheMotClef
                      + " ORDER BY `Version` DESC");
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {   
                String nomjList = Rse.getString("Version");
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
            jList18.setModel(jListModel);

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

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
        if (1 != reini){
            affichetable();
            affichjList();
            countIndex();
        }
    }//GEN-LAST:event_jList15ValueChanged

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
            ResultSet Rs=stm.executeQuery("SELECT `id` FROM `bddproduction` WHERE `fichier` LIKE '"+selecttable+"'");
            while(Rs.next()){
                idFichier = Rs.getString("id");
            }
            ////System.out.println(idFichier);
        }catch(SQLException e){System.err.println(e);}
        
        //SELECT `id` FROM `bddproduction` WHERE `fichier` LIKE "dsdvs"
        
        
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
        //SELECT * FROM `bddproduction` WHERE `fichier` LIKE ("%r422%") AND `fichier` LIKE ("%recomm%")
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
            if(fileDialog.isMultiSelectionEnabled()){
              //  File[] files = getSelectedFiles(fileDialog);
                final File[] files = fileDialog.getSelectedFiles();
                
                if (files != null && files.length > 0){
                    
                    int nbColonne = tableauindex.getColumnCount();
                    System.out.println(nbColonne);
                    if (nbColonne>3){
                                        
                        ////System.out.printlnNumero >2");
                        tableauindex.setColumnCount(3);
                    }
                    System.out.println(nbColonne);
                    if (files.length !=1){
                        
                        for (File file : files) {
                            filenames = file.getName();
                            filepath = file.getPath();
                            try {
                                stm=conn.obtenirconnexion().createStatement();
                                ResultSet Rs = stm.executeQuery("SELECT COUNT(*) FROM `bddproduction` WHERE `fichier` = '"+filenames+"'");
                                while(Rs.next()) {
                                    nb = Rs.getInt(1);
                                }
                                if (nb==0) {
                                    COUNT_INDEXER++;
                                    //////System.out.printlnFichiers pas encore indexer");
                                    String cheminse;
                                    cheminse = file.getPath().replace(file.getName(), "");
                                    ////System.out.println(cheminse);
                                    cheminse=cheminse.replaceAll("\\\\", "/");
                                    
                                    String version = this.searchVersion(filenames);
                                    System.out.println("version "+version);
                                    tableauindex.addRow(new Object []{filenames, cheminse,version});
                                    
                                } else {
                                    ////System.out.printlnFichiers déja indexer "+COUNT_INDEXER);
                                }
                            }catch (SQLException ex) {
                                //System.out.println(ex.getMessage());
                            } 
                        }
                        indexation_multiple indm = new indexation_multiple();
                                    indm.setVisible(true);
                                    this.dispose();
                        if(0==COUNT_INDEXER){
                            ////System.out.printlnTout les fichiers séléctionner ont déja été indexer");
                            int messageType = 0;
                            JOptionPane.showMessageDialog(null, "Tout les fichiers séléctionner ont déja été indexer", "Indexer des fichiers", messageType);
                        }else {
                            ////System.out.printlnCertains des fichiers séléctionner ont déja été indexer");
                            int messageType = 0;
                            //JOptionPane.showMessageDialog(null, "Certains des fichiers séléctionner ont déja été indexer", "Indexer des fichiers", messageType);
                        }

                         
                    } else {

                        File selectedFile = fileDialog.getSelectedFile();
                        String test = selectedFile.getPath();
                        String testt = selectedFile.getName();
                        try {
                            stm=conn.obtenirconnexion().createStatement();
                            ResultSet Rs = stm.executeQuery("SELECT COUNT(*) FROM `bddproduction` WHERE `fichier` = '"+testt+"'");
                            while(Rs.next()) {
                                nb = Rs.getInt(1);
                            }
                            if (nb==0) {
                                String cheseul = selectedFile.getPath().replace(selectedFile.getName(), "");
                                ////System.out.printlnFichier NON indexer");
                                cheseul = cheseul.replaceAll("\\\\", "/");
                                ////System.out.println(cheseul);
                                test_txt.setText(testt);
                                cheminseul_txt.setText(cheseul);
                                indexation ind = new indexation();
                                ind.setVisible(true);
                                this.dispose();
                            }else {
                                ////System.out.printlnFichier déja indexer "+COUNT_INDEXER);
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

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseExited

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked

        admin adm = new admin();
        adm.setVisible(true);
        main.page = "tech";
        this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jPanel20.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jPanel20.setBackground(new Color (0,86,172));          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseExited

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        // TODO add your handling code here:
        jPanel19.setBackground(new Color (0,136,198));
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited

        jPanel19.setBackground(new Color (0,86,172));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseExited

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        // TODO add your handling code here:
        System.out.println(evt);
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
             System.out.println("ECHAP");
        //code to execute if backspace is pressed
    }
    }//GEN-LAST:event_formKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
        System.out.println(evt);
    }//GEN-LAST:event_jPanel1KeyReleased
   
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

            ListJList10 = "`Atelier` LIKE '%%'";

            ListJList11 = "`GFH_Lignes` LIKE '%%'";

            ListJList12 = "`Machines` LIKE '%%'";

            ListJList13 = "`Sous_ensemble` LIKE '%%'";

            ListJList5 = "`Version` LIKE '%%'";
            
            BeforeSelectedList = false;
            affichjList();
            affichetable();
            this.countIndex();
        reini = 0;
         String ligne = RecupFichier.getPropertiesLigne();
       this.jList21.setSelectedValue(ligne, true);
       if (this.jList21.getSelectedIndex()!=-1) {
        this.jList15.setSelectedIndex(0);
       }
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

        
        ////////System.out.printlnMateriel "+ListJList4);

        //Valeur JLIST5 ------------------------------------------------------------------------------------------------
      
        List<String> SQLJList5 = jList18.getSelectedValuesList();
        //String ListJList5 = "";
        if (!SQLJList5.isEmpty()) {
            int SupprElem = 0;
            ListJList5 = "`Version` LIKE '%";
            for(int i=0; i<SQLJList5.size(); i++) {
            //////System.out.println(ListeTEST.get(i).replaceAll("\'","\\\\'"));
            switch (SQLJList5.size()) {
                case 1:
                    ListJList5 = ListJList5 + SQLJList5.get(i).replaceAll("\'","\\\\'")+"%'";
                    SupprElem = 1;
                    break;
                case 2:
                    ListJList5 = ListJList5+" OR `Version` LIKE '%"+ SQLJList5.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
                default:
                    ListJList5 = ListJList5+" OR `Version` LIKE '%"+ SQLJList5.get(i).replaceAll("\'","\\\\'")+"%' ";
                    break;
            }
                
         }
            if(0==SupprElem){
                ListJList5 = ListJList5.substring(20);
            }
        //////System.out.printlnVersion: "+ListJList5);
        }
        ////////System.out.printlnVersion "+ListJList5);
        
        
        int nb = 0;

        try {
            if( "".equals(ListJList)){
            ListJList = "`service` LIKE '%%'";
            }if( "".equals(ListJList7)){
            ListJList7 = "`Type_de_document_N1` LIKE '%%'";
            }if( "".equals(ListJList10)){
            ListJList10 = "`Atelier` LIKE '%%'";
            }if( "".equals(ListJList11)){
            ListJList11 = "`GFH_Lignes` LIKE '%%'";
            }if( "".equals(ListJList12)){
            ListJList12 = "`Machines` LIKE '%%'";
            }if( "".equals(ListJList13)){
            ListJList13 = "`Sous_ensemble` LIKE '%%'";
            }if( "".equals(ListJList5)){
            ListJList5 = "`Version` LIKE '%%'";
            }
            
            RechercheMotClef = separerEspace(this.txtRecherche.getText());
            //System.out.println(Recherche);
            
            stm=conn.obtenirconnexion().createStatement();

            ResultSet Rs=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") "
                      + "AND ("+ListJList7+") "
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList18;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JList<String> jList24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane18;
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
