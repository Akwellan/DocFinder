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
    private String ListJList15;
    private String ListJList21;
    private String ListJList22;
    private String ListJList23;
    private String ListJList24;
    private String ListJList14;
    private String ListJList19;
    private String ListJList20;
    DefaultTableModel model=new DefaultTableModel();
    private String tmp;
    public static String AddElement;
    public static String PageIndex = null;
    
    
    public indexation() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Indexation de fichier");
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
      
    String nom_string = main.test_txt.getText();
    String AntiApo = null;
    AntiApo = nom_string;
    AntiApo = AntiApo.replaceAll("\\\\'","\'");
    
    //nom_string = nom_string.replaceAll("\\\\'","\'");
    fichier_show.setText(AntiApo);
    
    String cheminseul_string = main.cheminseul_txt.getText(); 
    //cheminseul_string = cheminseul_string.replaceAll("\\\\'","\'");
    chemin_show.setText(cheminseul_string);
  
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
        fichier_show = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chemin_show = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAddN1 = new javax.swing.JTextField();
        btnAddN1 = new javax.swing.JButton();
        txtAddN2 = new javax.swing.JTextField();
        btnAddN2 = new javax.swing.JButton();
        txtAddN3 = new javax.swing.JTextField();
        btnAddN3 = new javax.swing.JButton();
        txtAddN4 = new javax.swing.JTextField();
        btnAddN4 = new javax.swing.JButton();
        txtAddN5 = new javax.swing.JTextField();
        btnAddN5 = new javax.swing.JButton();
        btnAddAtelier = new javax.swing.JButton();
        btnAddGFH = new javax.swing.JButton();
        btnAddMachine = new javax.swing.JButton();
        btnAddSE = new javax.swing.JButton();
        btnAddService = new javax.swing.JButton();
        btnAddDocN1 = new javax.swing.JButton();
        btnAddDocN2 = new javax.swing.JButton();
        btnAddDocN3 = new javax.swing.JButton();

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
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
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
                .addGap(135, 135, 135))
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

        fichier_show.setEditable(false);
        fichier_show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CHEMIN COMPLET :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NOM DU FICHIER :");

        chemin_show.setEditable(false);
        chemin_show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chemin_show.setPreferredSize(new java.awt.Dimension(579, 26));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane11.setViewportView(jList11);

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane12.setViewportView(jList12);

        jScrollPane16.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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
        jScrollPane18.setViewportView(jList18);

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList14.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList14ValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(jList14);

        jScrollPane19.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList19.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList19ValueChanged(evt);
            }
        });
        jScrollPane19.setViewportView(jList19);

        jScrollPane20.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList20.setMinimumSize(new java.awt.Dimension(35, 92));
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
        jList24.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList24ValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(jList24);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/add_24px.png"))); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Lieu d'archivage :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Constructeur :");

        txtAddN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN1MouseReleased(evt);
            }
        });

        btnAddN1.setText("+");
        btnAddN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN1ActionPerformed(evt);
            }
        });

        txtAddN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN2MouseReleased(evt);
            }
        });

        btnAddN2.setText("+");
        btnAddN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN2ActionPerformed(evt);
            }
        });

        txtAddN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN3MouseReleased(evt);
            }
        });

        btnAddN3.setText("+");
        btnAddN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN3ActionPerformed(evt);
            }
        });

        txtAddN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN4MouseReleased(evt);
            }
        });

        btnAddN4.setText("+");
        btnAddN4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN4ActionPerformed(evt);
            }
        });

        txtAddN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAddN5MouseReleased(evt);
            }
        });

        btnAddN5.setText("+");
        btnAddN5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddN5ActionPerformed(evt);
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

        btnAddService.setText("+");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        btnAddDocN1.setText("+");
        btnAddDocN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDocN1ActionPerformed(evt);
            }
        });

        btnAddDocN2.setText("+");
        btnAddDocN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDocN2ActionPerformed(evt);
            }
        });

        btnAddDocN3.setText("+");
        btnAddDocN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDocN3ActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fichier_show, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chemin_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAddMachine)
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(274, 274, 274)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddDocN3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddSE))
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddN1)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAddN2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddN2))
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(133, 133, 133)
                                                        .addComponent(btnAddN4))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAddN4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAddN5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAddN3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddN3)
                                        .addGap(323, 323, 323)
                                        .addComponent(btnAddN5))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddService))
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddAtelier))
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddDocN1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddGFH)))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddDocN2)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(btnAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDocN1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDocN2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDocN3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddMachine))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel19)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(btnAddSE))
                            .addComponent(btnAddAtelier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddGFH)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddN2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddN2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddN3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddN3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddN4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddN4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddN5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddN5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAddN1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fichier_show, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chemin_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
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

    private void afficher(){

        try {
                    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    stm=conn.obtenirconnexion().createStatement();
                    //-------------TABLE NON LIER----------------------------
                    ResultSet Rse=stm.executeQuery("Select * from tech_critere");
                 
                    DefaultListModel LieuArchi=new DefaultListModel();
                    DefaultListModel Type_de_Materiel=new DefaultListModel();
                    DefaultListModel Constructeur=new DefaultListModel();
                    DefaultListModel Materiel=new DefaultListModel();
                    DefaultListModel Annee=new DefaultListModel();
                    
                    while(Rse.next())
                    {   
                        String nomLieu_archivage = Rse.getString("Lieu_archivage");
                        String nomType_de_Materiel = Rse.getString("Type_de_Materiel");
                        String nomConstructeur = Rse.getString("Constructeur");
                        String nomMateriel = Rse.getString("Materiel");
                        String nomAnnee = Rse.getString("Annee");
                        int incremLieu_archivage = 0;
                        int incremType_de_Materiel = 0;
                        int incremConstructeur = 0;
                        int incremMateriel = 0;
                        int incremAnnee = 0;
                        
                        //------------------------------------------------------------------------
                        for (int i = 0; i < LieuArchi.size(); i++) {
                            
                            String DocI = (String) LieuArchi.get(i);
                            
                            if(DocI.equals(nomLieu_archivage)){
                                incremLieu_archivage++;
                            }
                        }
                        if(incremLieu_archivage == 0){
                            if(nomLieu_archivage != null) {
                                LieuArchi.addElement(Rse.getString("Lieu_archivage"));   
                            }
                        }
                        
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Type_de_Materiel.size(); i++) {
                            
                            String DocI = (String) Type_de_Materiel.get(i);
                            
                            if(DocI.equals(nomType_de_Materiel)){
                                incremType_de_Materiel++;
                            }
                        }
                        if(incremType_de_Materiel == 0){
                            if(nomType_de_Materiel != null) {
                                Type_de_Materiel.addElement(Rse.getString("Type_de_Materiel"));   
                            }
                        }
                        
                        //------------------------------Constructeur------------------------------------------
                        for (int i = 0; i < Constructeur.size(); i++) {
                            
                            String DocI = (String) Constructeur.get(i);
                            
                            if(DocI.equals(nomConstructeur)){
                                incremConstructeur++;
                            }
                        }
                        if(incremConstructeur == 0){
                            if(nomConstructeur != null) {
                                Constructeur.addElement(Rse.getString("Constructeur"));   
                            }
                        }
                        
                        //----------------------------Materiel--------------------------------------------
                        for (int i = 0; i < Materiel.size(); i++) {
                            
                            String DocI = (String) Materiel.get(i);
                            
                            if(DocI.equals(nomMateriel)){
                                incremMateriel++;
                            }
                        }
                        if(incremMateriel == 0){
                            if(nomMateriel != null) {
                                Materiel.addElement(Rse.getString("Materiel"));   
                            }
                        }
                        
                        //-------------------------Annee-----------------------------------------------
                        for (int i = 0; i < Annee.size(); i++) {
                            
                            String DocI = (String) Annee.get(i);
                            
                            if(DocI.equals(nomAnnee)){
                                incremAnnee++;
                            }
                        }
                        if(incremAnnee == 0){
                            if(nomAnnee != null) {
                                Annee.addElement(Rse.getString("Annee"));   
                            }
                        }
                        

                        
                    }
                    //System.out.println(LieuArchi.get(1));
                    jList11.setModel(LieuArchi);
                    jList12.setModel(Type_de_Materiel);
                    jList17.setModel(Constructeur);
                    jList16.setModel(Materiel);
                    jList18.setModel(Annee);
                    
                    //-------------TABLE LIER DOC-N3----------------------------
                    
                    ResultSet Rstd=stm.executeQuery("Select * from tech_type_document");
                 
                    //System.out.println(a);
                    DefaultListModel Document=new DefaultListModel();
                    DefaultListModel Type_de_Document_N1=new DefaultListModel();
                    DefaultListModel Type_de_Document_N2=new DefaultListModel();
                    DefaultListModel Type_de_Document_N3=new DefaultListModel();
                    
                    while(Rstd.next()) {
                        String nomDoc = Rstd.getString("Document");
                        String nomN1 = Rstd.getString("Type_de_Document_N1");
                        String nomN2 = Rstd.getString("Type_de_Document_N2");
                        String nomN3 = Rstd.getString("Type_de_Document_N3");
                        int incremDoc = 0;
                        int incremN1 = 0;
                        int incremN2 = 0;
                        int incremN3 = 0;
                        
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
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Type_de_Document_N1.size(); i++) {
                            
                            String DocI = (String) Type_de_Document_N1.get(i);
                            
                            if(DocI.equals(nomN1)){
                                incremN1++;
                            }
                        }
                        if(incremN1 == 0){
                            if(nomN1 != null) {
                                Type_de_Document_N1.addElement(nomN1);
                            }
                        }
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Type_de_Document_N2.size(); i++) {
                            
                            String DocI = (String) Type_de_Document_N2.get(i);
                            
                            if(DocI.equals(nomN2)){
                                incremN2++;
                            }
                        }
                        if(incremN2 == 0){
                            if(nomN2 != null) {
                                Type_de_Document_N2.addElement(nomN2);
                            }
                        }
                        //------------------------------------------------------------------------
                        for (int i = 0; i < Type_de_Document_N3.size(); i++) {
                            
                            String DocI = (String) Type_de_Document_N3.get(i);
                            
                            if(DocI.equals(nomN3)){
                                incremN3++;
                            }
                        }
                        if(incremN3 == 0){
                            if(nomN3 != null) {
                                Type_de_Document_N3.addElement(nomN3);
                            }
                        }
                        
                    }
                    
                    jList24.setModel(Document);
                    jList14.setModel(Type_de_Document_N1);
                    jList19.setModel(Type_de_Document_N2);
                    jList20.setModel(Type_de_Document_N3);
                    
                    
                    //-------------TABLE LIER ATELIERS-GFH-LIgne----------------------------
                    
                    ResultSet Rstj=stm.executeQuery("Select * from tech_atelier_gfh_ligne");
                 
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
                                Ateliers.addElement(nomAteliers);
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
                                GFH_Ligne.addElement(nomGFH_Ligne);
                            }
                        }
                        
                    }
                    jList15.setModel(Ateliers);
                    jList21.setModel(GFH_Ligne);
                    
                    
                    //-------------TABLE LIER Machines-Sous_ensemble----------------------------
                    
                    ResultSet Rsms=stm.executeQuery("Select * from tech_machines_sous_ensemble");
                 
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
                                Machines.addElement(nomMachines);
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
                                Sous_ensemble.addElement(nomSous_ensemble);
                            }
                        }
                        
                    }
                    jList22.setModel(Machines);
                    jList23.setModel(Sous_ensemble);
                    
                   
                     
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                

}

        private void rempList(){
        rempList15();
        rempList21();
        rempList22();
        rempList23();
    }
    private void rempLists(){
        rempList24();
        rempList14();
        rempList19();
        rempList20();
    }
    
    private void TablLIers() {

        
            ListJList20 = "(`Type_de_Document_N3` LIKE('%%'))";
            ListJList19 = "(`Type_de_Document_N2` LIKE('%%'))";
            ListJList14 = "(`Type_de_Document_N1` LIKE('%%'))";
            ListJList24 = "(`Document` LIKE('%%'))";
        

        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE("%%"))
        List<String> SQLJList24 = jList24.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList24.isEmpty()) {
            ListJList24 = "(`Document` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList24.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList24.size()) {
                case 1:
                    
                    ListJList24 = ListJList24 + SQLJList24.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList24 = ListJList24+" OR (`Document` LIKE('%"+ SQLJList24.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList24)){
            ListJList24 = "(`Document` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList24 = ListJList24.substring(23);
            }
            System.out.println("-ListJList24- "+ListJList24);
        System.out.println("Requette document " +ListJList24);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne` LIKE("%%"))
        List<String> SQLJList14 = jList14.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList14.isEmpty()) {
            ListJList14 = "(`Type_de_Document_N1` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList14.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList14.size()) {
                case 1:
                    
                    ListJList14 = ListJList14 + SQLJList14.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList14 = ListJList14+" OR (`Type_de_Document_N1` LIKE('%"+ SQLJList14.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList14)){
            ListJList14 = "(`Type_de_Document_N1` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList14 = ListJList14.substring(34);
            }
            System.out.println("-ListJList14- "+ListJList14);
        System.out.println("Requette n1 " +ListJList14);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%"))
        List<String> SQLJList19 = jList19.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList19.isEmpty()) {
            ListJList19 = "(`Type_de_Document_N2` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList19.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList19.size()) {
                case 1:
                    
                    ListJList19 = ListJList19 + SQLJList19.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList19 = ListJList19+" OR (`Type_de_Document_N2` LIKE('%"+ SQLJList19.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList19)){
            ListJList19 = "(`Type_de_Document_N2` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList19 = ListJList19.substring(34);
            }
            System.out.println("-ListJList19- "+ListJList19);
        //System.out.println(ListJList19);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%"))
        List<String> SQLJList20 = jList20.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList20.isEmpty()) {
            ListJList20 = "(`Type_de_Document_N3` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList20.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList20.size()) {
                case 1:
                    
                    ListJList20 = ListJList20 + SQLJList20.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList20 = ListJList20+" OR (`Type_de_Document_N3` LIKE('%"+ SQLJList20.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList20)){
            ListJList20 = "(`Type_de_Document_N3` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList20 = ListJList20.substring(34);
            }
            System.out.println("-ListJList20- "+ListJList20);
        //System.out.println(ListJList20);
        }
        //======================================================================================================================================\\
        
            if( "".equals(ListJList20)){
            ListJList20 = "(`Type_de_Document_N3` LIKE('%%'))";
            }if( "".equals(ListJList19)){
            ListJList19 = "(`Type_de_Document_N2` LIKE('%%'))";
            }if( "".equals(ListJList14)){
            ListJList14 = "(`Type_de_Document_N2` LIKE('%%'))";
            }if( "".equals(ListJList24)){
            ListJList24 = "(`Document` LIKE('%%'))";
            }
            
            
            
            
    }
    
    
    private void rempList24(){
        System.out.println("RempList24");
        List<String> Listj = jList24.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT * FROM `tech_type_document` WHERE" +
            "("+ListJList24+" ) " +
            "AND ("+ListJList14+" ) " +
            "AND ("+ListJList19+" ) " +
            "AND ("+ListJList20+" ) ORDER BY `tech_type_document`.`Document` ASC";
            
            System.out.println("Document" + requete);
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Document");
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
                            if(!"[]".equals(mot)){
                                jListModel.addElement(mot);   
                            }
                        }
                    }
                }else {
                    
                    if(!"[]".equals(mot)){
                        jListModel.addElement(mot);   
                    }
                }
                incemTest++;
            }
            jList24.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList14(){
        System.out.println("RempList14");
        List<String> Listj = jList14.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT * FROM `tech_type_document` WHERE" +
            "("+ListJList24+" ) " +
            "AND ("+ListJList14+" ) " +
            "AND ("+ListJList19+" ) " +
            "AND ("+ListJList20+" ) ORDER BY `tech_type_document`.`Type_de_Document_N1` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Type_de_Document_N1");
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
                            if(!"[]".equals(mot)){
                                jListModel.addElement(mot);   
                            }
                        }
                    }
                }else {
                    
                    if(!"[]".equals(mot)){
                        jListModel.addElement(mot);   
                    }
                }
                incemTest++;
            }
            jList14.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList19(){
        System.out.println("RempList19");
        List<String> Listj = jList19.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT * FROM `tech_type_document` WHERE" +
            "("+ListJList24+" ) " +
            "AND ("+ListJList14+" ) " +
            "AND ("+ListJList19+" ) " +
            "AND ("+ListJList20+" ) ORDER BY `tech_type_document`.`Type_de_Document_N2` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Type_de_Document_N2");
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
                            if(!"[]".equals(mot)){
                                jListModel.addElement(mot);   
                            }
                        }
                    }
                }else {
                    
                    if(!"[]".equals(mot)){
                        jListModel.addElement(mot);   
                    }
                }
                incemTest++;
            }
            jList19.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList20(){
        System.out.println("RempList20");
        List<String> Listj = jList20.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT * FROM `tech_type_document` WHERE" +
            "("+ListJList24+" ) " +
            "AND ("+ListJList14+" ) " +
            "AND ("+ListJList19+" ) " +
            "AND ("+ListJList20+" ) ORDER BY `tech_type_document`.`Type_de_Document_N3` ASC";
            
            ResultSet Rse=stm.executeQuery(requete);
            
            DefaultListModel jListModel=new DefaultListModel();
            int incemTest =0;
            String mot = null;
            while(Rse.next())
            {
                String nomjList = Rse.getString("Type_de_Document_N3");
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
                            if(!"[]".equals(mot)){
                                jListModel.addElement(mot);   
                            }
                        }
                    }
                }else {
                    
                    if(!"[]".equals(mot)){
                        jListModel.addElement(mot);   
                    }
                }
                incemTest++;
            }
            jList20.setModel(jListModel);
        
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    }
  
 
           
    private void TablLIer() {
        
        /*
            SELECT
                `docfinder`.`tech_atelier_gfh_ligne`.`Ateliers`,
                `docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne`,
                `docfinder`.`tech_gfh_ligne_machines`.`Machines`,
                `docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble`
            FROM
                `docfinder`.`tech_atelier_gfh_ligne`,
                `docfinder`.`tech_gfh_ligne_machines`,
                `docfinder`.`tech_machines_sous_ensemble`
            WHERE
                (`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE `docfinder`.`tech_machines_sous_ensemble`.`Machines`)
                AND (`docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne` LIKE `docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne`)
                AND ((`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%")) OR (`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Chenille%")))
                AND ((`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%")) )
                AND ((`docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne` LIKE("%%")) )
                AND ((`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE("%%")) )
        
        */
        
        /*
        SELECT
            `tech_atelier_gfh_ligne`.`id`,
            `tech_atelier_gfh_ligne`.`Ateliers`,
            `tech_gfh_ligne_machines`.`GFH_Ligne`,
            `tech_machines_sous_ensemble`.`Machines`,
            `tech_machines_sous_ensemble`.`Sous_ensemble`
        FROM
            `tech_atelier_gfh_ligne`
        INNER JOIN `tech_gfh_ligne_machines` ON `tech_atelier_gfh_ligne`.`GFH_Ligne` = `tech_gfh_ligne_machines`.`GFH_Ligne`
        INNER JOIN `tech_machines_sous_ensemble` ON `tech_gfh_ligne_machines`.`Machines` = `tech_machines_sous_ensemble`.`Machines` 

        AND ((`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%Bouchons%')) )
        AND ((`docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%')) )
        AND ((`docfinder`.`tech_machines_sous_ensemble`.`Machines` LIKE('%%')) )
        AND ((`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%')) )  
        ORDER BY `tech_atelier_gfh_ligne`.`id` ASC
      
        */
        
       
            ListJList23 = "(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
            ListJList22 = "(`docfinder`.`tech_machines_sous_ensemble`.`Machines` LIKE('%%'))";
            ListJList21 = "(`docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%'))";
            ListJList15 = "(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
        

        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE("%%"))
        List<String> SQLJList15 = jList15.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList15.isEmpty()) {
            ListJList15 = "(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList15.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList15.size()) {
                case 1:
                    
                    ListJList15 = ListJList15 + SQLJList15.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList15 = ListJList15+" OR (`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%"+ SQLJList15.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList15)){
            ListJList15 = "(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList15 = ListJList15.substring(55);
            }
            System.out.println("-ListJList15- "+ListJList15);
        System.out.println(ListJList15);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne` LIKE("%%"))
        List<String> SQLJList21 = jList21.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList21.isEmpty()) {
            ListJList21 = "(`docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList21.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList21.size()) {
                case 1:
                    
                    ListJList21 = ListJList21 + SQLJList21.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList21 = ListJList21+" OR (`docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne` LIKE('%"+ SQLJList21.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList21)){
            ListJList21 = "(`docfinder`.`tech_gfh_ligne_machines`.`GFH_Ligne` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList21 = ListJList21.substring(56);
            }
            System.out.println("-ListJList21- "+ListJList21);
        System.out.println(ListJList21);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%"))
        List<String> SQLJList22 = jList22.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList22.isEmpty()) {
            ListJList22 = "(`docfinder`.`tech_machines_sous_ensemble`.`Machines` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList22.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList22.size()) {
                case 1:
                    
                    ListJList22 = ListJList22 + SQLJList22.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList22 = ListJList22+" OR (`docfinder`.`tech_machines_sous_ensemble`.`Machines` LIKE('%"+ SQLJList22.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList22)){
            ListJList22 = "(`docfinder`.`tech_machines_sous_ensemble`.`Machines` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList22 = ListJList22.substring(56);
            }
            System.out.println("-ListJList22- "+ListJList22);
        System.out.println(ListJList22);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%"))
        List<String> SQLJList23 = jList23.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList23.isEmpty()) {
            ListJList23 = "(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList23.size(); i++) {
            //////System.out.println(ListeTEST.get(i));
            switch (SQLJList23.size()) {
                case 1:
                    
                    ListJList23 = ListJList23 + SQLJList23.get(i).replaceAll("\'","\\\\'")+"%'))";
                    SupprElem = 1;
                    break;
                default:
                    ListJList23 = ListJList23+" OR (`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%"+ SQLJList23.get(i).replaceAll("\'","\\\\'")+"%')) ";
                    break;
            }
                
         }
        if( "".equals(ListJList23)){
            ListJList23 = "(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
        }
            if(0==SupprElem){
                ListJList23 = ListJList23.substring(65);
            }
            System.out.println("-ListJList23- "+ListJList23);
        System.out.println(ListJList23);
        }
        //======================================================================================================================================\\
        
            if( "".equals(ListJList23)){
            ListJList23 = "(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE('%%'))";
            }if( "".equals(ListJList22)){
            ListJList22 = "(`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE('%%'))";
            }if( "".equals(ListJList21)){
            ListJList21 = "(`docfinder`.`tech_atelier_gfh_ligne`.`GFH_Ligne` LIKE('%%'))";
            }if( "".equals(ListJList15)){
            ListJList15 = "(`docfinder`.`tech_atelier_gfh_ligne`.`Ateliers` LIKE('%%'))";
            }
            
            
            
            
    }

    private void rempList15(){
        System.out.println("RempList15");
        List<String> Listj = jList15.getSelectedValuesList();
        if (Listj.isEmpty()){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT `tech_atelier_gfh_ligne`.`id`, `tech_atelier_gfh_ligne`.`Ateliers`, `tech_gfh_ligne_machines`.`GFH_Ligne`, `tech_machines_sous_ensemble`.`Machines`, `tech_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`tech_atelier_gfh_ligne`" +
            "INNER JOIN `tech_gfh_ligne_machines` ON `tech_atelier_gfh_ligne`.`GFH_Ligne` = `tech_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `tech_machines_sous_ensemble` ON `tech_gfh_ligne_machines`.`Machines` = `tech_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ORDER BY `tech_atelier_gfh_ligne`.`Ateliers` ASC";
            
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
            String requete="SELECT `tech_atelier_gfh_ligne`.`id`, `tech_atelier_gfh_ligne`.`Ateliers`, `tech_gfh_ligne_machines`.`GFH_Ligne`, `tech_machines_sous_ensemble`.`Machines`, `tech_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`tech_atelier_gfh_ligne`" +
            "INNER JOIN `tech_gfh_ligne_machines` ON `tech_atelier_gfh_ligne`.`GFH_Ligne` = `tech_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `tech_machines_sous_ensemble` ON `tech_gfh_ligne_machines`.`Machines` = `tech_machines_sous_ensemble`.`Machines`" +
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
            String requete="SELECT `tech_atelier_gfh_ligne`.`id`, `tech_atelier_gfh_ligne`.`Ateliers`, `tech_gfh_ligne_machines`.`GFH_Ligne`, `tech_machines_sous_ensemble`.`Machines`, `tech_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`tech_atelier_gfh_ligne`" +
            "INNER JOIN `tech_gfh_ligne_machines` ON `tech_atelier_gfh_ligne`.`GFH_Ligne` = `tech_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `tech_machines_sous_ensemble` ON `tech_gfh_ligne_machines`.`Machines` = `tech_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ORDER BY `tech_machines_sous_ensemble`.`Machines` ASC";
            
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
            String requete="SELECT `tech_atelier_gfh_ligne`.`id`, `tech_atelier_gfh_ligne`.`Ateliers`, `tech_gfh_ligne_machines`.`GFH_Ligne`, `tech_machines_sous_ensemble`.`Machines`, `tech_machines_sous_ensemble`.`Sous_ensemble`" +
            "FROM `docfinder`.`tech_atelier_gfh_ligne`" +
            "INNER JOIN `tech_gfh_ligne_machines` ON `tech_atelier_gfh_ligne`.`GFH_Ligne` = `tech_gfh_ligne_machines`.`GFH_Ligne` "+
            "INNER JOIN `tech_machines_sous_ensemble` ON `tech_gfh_ligne_machines`.`Machines` = `tech_machines_sous_ensemble`.`Machines`" +
            "AND ("+ListJList15+" ) " +
            "AND ("+ListJList21+" ) " +
            "AND ("+ListJList22+" ) " +
            "AND ("+ListJList23+" ) ";
            
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
        String fichier=fichier_show.getText();
        fichier = fichier.replaceAll("\'","\\\\'");
        String chemin=chemin_show.getText();

        
        List<String> service = jList24.getSelectedValuesList();
        List<String> Lieu_archivage = jList11.getSelectedValuesList();
        List<String> Type_de_Materiel = jList12.getSelectedValuesList();
        List<String> Constructeur = jList17.getSelectedValuesList();
        List<String> Materiel = jList16.getSelectedValuesList();
        List<String> Annee = jList18.getSelectedValuesList();
        
        List<String> Type_de_document_N1 = jList14.getSelectedValuesList();
        List<String> Type_de_document_N2 = jList19.getSelectedValuesList();
        List<String> Type_de_document_N3 = jList20.getSelectedValuesList();
        
        List<String> Atelier = jList15.getSelectedValuesList();
        List<String> GFH_Lignes = jList21.getSelectedValuesList();
        List<String> Machines = jList22.getSelectedValuesList();
        List<String> Sous_ensemble = jList23.getSelectedValuesList();
        
        
        System.out.println(service);
        System.out.println(fichier);
        System.out.println(chemin);

        String requete="insert into bddmaintenance(id,fichier,chemin,service,Type_de_document_N1,Type_de_document_N2,Type_de_document_N3,Lieu_Archivage,Type_de_Materiel,Constructeur"
                + ",Materiel,Atelier,GFH_Lignes,Machines,Sous_ensemble,Annees)VALUES"
                + "(NULL,'"+fichier+"','"+chemin+"','"+service+"','"+Type_de_document_N1+"','"+Type_de_document_N2+"','"+Type_de_document_N3+"','"+Lieu_archivage+"',"
                + "'"+Type_de_Materiel+"','"+Constructeur+"','"+Materiel+"','"+Atelier+"','"+GFH_Lignes+"','"+Machines+"','"+Sous_ensemble+"','"+Annee+"')";
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList24ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList24ValueChanged

        this.TablLIers();
        rempLists();
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24ValueChanged

    private void jList14ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList14ValueChanged
 
        this.TablLIers();
        rempLists();     // TODO add your handling code here:
    }//GEN-LAST:event_jList14ValueChanged

    private void jList19ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList19ValueChanged
 
        this.TablLIers();
        rempLists();    // TODO add your handling code here:
    }//GEN-LAST:event_jList19ValueChanged

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
 
        this.TablLIer();
        rempList();
                // TODO add your handling code here:
    }//GEN-LAST:event_jList15ValueChanged

    private void jList17ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList17ValueChanged
 
    }//GEN-LAST:event_jList17ValueChanged

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged
  
        this.TablLIer();
        rempList();     // TODO add your handling code here:  // TODO add your handling code here:
    }//GEN-LAST:event_jList21ValueChanged

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
 
        this.TablLIer();
        rempList();      // TODO add your handling code here:
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
 
        this.TablLIer();
        rempList();        // TODO add your handling code here:
    }//GEN-LAST:event_jList23ValueChanged

    private void jList20ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList20ValueChanged

        this.TablLIers();
        rempLists();        // TODO add your handling code here:
    }//GEN-LAST:event_jList20ValueChanged

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

        OpenFile("I:\\Maintenance\\DocFinder\\DocFinder JAVA\\DocFinder\\PRODUCTION\\DFprod.jar")   ;
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

    private void txtAddN1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN1MouseReleased
        this.btnAddN1.setVisible(true);
    }//GEN-LAST:event_txtAddN1MouseReleased

    private void btnAddN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN1ActionPerformed

        
        String AddN1 = this.txtAddN1.getText();
        PageIndex = "Simple";

        String requete="INSERT INTO `tech_type_document` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) "
                + "VALUES (NULL, '"+AddN1+"', NULL, NULL, NULL, NULL)";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere Lieu_archivage, "+AddN1+" à bien été ajoutée.");
            this.txtAddN1.setText("");
            this.btnAddN1.setVisible(false);
            afficher();
            this.TablLIer();
            rempList();
            jList12.setSelectedValue(AddN1, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddN1ActionPerformed

    private void txtAddN2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN2MouseReleased
        // TODO add your handling code here:        

    }//GEN-LAST:event_txtAddN2MouseReleased

    private void btnAddN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN2ActionPerformed
        // TODO add your handling code here:
        String AddN2 = this.txtAddN2.getText();
        PageIndex = "Simple";
        
        String requete="INSERT INTO `tech_type_document` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) "
                + "VALUES (NULL, NULL, '"+AddN2+"', NULL, NULL, NULL)";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere N1, "+AddN2+" à bien été ajoutée.");
            this.txtAddN2.setText("");
            this.btnAddN2.setVisible(false);
            afficher();
            this.TablLIer();
            rempList();
            jList17.setSelectedValue(AddN2, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_btnAddN2ActionPerformed

    private void txtAddN3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddN3MouseReleased

    private void btnAddN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN3ActionPerformed
        // TODO add your handling code here:
        String AddN3 = this.txtAddN3.getText();
        PageIndex = "Simple";

        String requete="INSERT INTO `tech_type_document` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) "
                + "VALUES (NULL, NULL, NULL, '"+AddN3+"', NULL, NULL)";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere N1, "+AddN3+" à bien été ajoutée.");
            this.txtAddN3.setText("");
            this.btnAddN3.setVisible(false);
            afficher();
            this.TablLIer();
            rempList();
            jList16.setSelectedValue(AddN3, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_btnAddN3ActionPerformed

    private void txtAddN4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddN4MouseReleased

    private void btnAddN4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN4ActionPerformed
        // TODO add your handling code here:                         
        // TODO add your handling code here:
        String AddN4 = this.txtAddN4.getText();
        PageIndex = "Simple";

        String requete="INSERT INTO `tech_type_document` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) "
                + "VALUES (NULL, NULL, NULL, NULL, '"+AddN4+"', NULL)";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere N1, "+AddN4+" à bien été ajoutée.");
            this.txtAddN4.setText("");
            this.btnAddN4.setVisible(false);
            afficher();
            this.TablLIer();
            rempList();
            jList11.setSelectedValue(AddN4, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_btnAddN4ActionPerformed

    private void txtAddN5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddN5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddN5MouseReleased

    private void btnAddN5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddN5ActionPerformed
        // TODO add your handling code here:                         
        // TODO add your handling code here:
        String AddN5 = this.txtAddN5.getText();
        PageIndex = "Simple";

        String requete="INSERT INTO `tech_type_document` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) "
                + "VALUES (NULL, NULL, NULL, NULL, NULL, '"+AddN5+"')";
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"L'element du crtitere N1, "+AddN5+" à bien été ajoutée.");
            this.txtAddN5.setText("");
            this.btnAddN5.setVisible(false);
            afficher();
            this.TablLIer();
            rempList();
            jList18.setSelectedValue(AddN5, true);

        }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_btnAddN5ActionPerformed

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

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        // TODO add your handling code here:
        AddElement = "Document";
        PageIndex = "Simple";
        new addServiceN3().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnAddDocN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDocN1ActionPerformed
        // TODO add your handling code here:
        AddElement = "Type_de_Document_N1";
        PageIndex = "Simple";
        new addServiceN3().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddDocN1ActionPerformed

    private void btnAddDocN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDocN2ActionPerformed
        // TODO add your handling code here:
        AddElement = "Type_de_Document_N2";
        PageIndex = "Simple";
        new addServiceN3().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddDocN2ActionPerformed

    private void btnAddDocN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDocN3ActionPerformed
        // TODO add your handling code here:
        AddElement = "Type_de_Document_N3";
        PageIndex = "Simple";
        new addServiceN3().setVisible(true);
        this.dispose();
        afficher();
    }//GEN-LAST:event_btnAddDocN3ActionPerformed
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
    private javax.swing.JButton btnAddDocN1;
    private javax.swing.JButton btnAddDocN2;
    private javax.swing.JButton btnAddDocN3;
    private javax.swing.JButton btnAddGFH;
    private javax.swing.JButton btnAddMachine;
    private javax.swing.JButton btnAddN1;
    private javax.swing.JButton btnAddN2;
    private javax.swing.JButton btnAddN3;
    private javax.swing.JButton btnAddN4;
    private javax.swing.JButton btnAddN5;
    private javax.swing.JButton btnAddSE;
    private javax.swing.JButton btnAddService;
    private javax.swing.JTextField chemin_show;
    private javax.swing.JTextField fichier_show;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTextField txtAddN1;
    private javax.swing.JTextField txtAddN2;
    private javax.swing.JTextField txtAddN3;
    private javax.swing.JTextField txtAddN4;
    private javax.swing.JTextField txtAddN5;
    // End of variables declaration//GEN-END:variables
}
