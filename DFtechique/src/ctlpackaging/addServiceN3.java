package ctlpackaging;


import static ctlpackaging.indexation.PageIndex;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akwellan
 */
public class addServiceN3 extends javax.swing.JFrame {
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;
    
    static String chemin_string;
    private String ListJList24;
    private String ListJList14;
    private String ListJList19;
    private String ListJList20;
    private String Element =  "Document";//indexation.AddElement;//"Document";
    private boolean reini = false;
    /**
     * Creates new form main
     */

    Connecter conn=new Connecter();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    
    public addServiceN3() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Connextion");
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
        
        try {
            stm=conn.obtenirconnexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(addServiceN3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.TablLIer();
        rempList();
        

        MiseEnPlace();
    }
    
    
    private void MiseEnPlace(){
        switch (Element) {
            case "Document":
                //System.out.println("Document");
                this.jScrollPane15.setVisible(false);
                lbltxt15.setText("Veuillez écrire un nouveau `Document`.");
                this.txt21.setVisible(false);
                lbltxt21.setText("Veuillez sélèctionner un `Type_de_Document_N1`.");
                this.txt22.setVisible(false);
                lbltxt22.setText("Veuillez sélèctionner une `Type_de_Document_N2`.");
                this.txt23.setVisible(false);
                lbltxt23.setText("Veuillez sélèctionner un `Type_de_Document_N3`.");
                break;
            case "GFH":
                //System.out.println("Type_de_Document_N1");
                this.jScrollPane21.setVisible(false);
                lbltxt21.setText("Veuillez écrire un nouveau `Type_de_Document_N1`.");
                this.txt15.setVisible(false);
                lbltxt15.setText("Veuillez sélèctionner un `Document`.");
                this.txt22.setVisible(false);
                lbltxt22.setText("Veuillez sélèctionner un `Type_de_Document_N2`.");
                this.txt23.setVisible(false);
                lbltxt23.setText("Veuillez sélèctionner un `Type_de_Document_N3`.");
                break;
            case "Machine":
                //System.out.println("Type_de_Document_N2");
                this.jScrollPane22.setVisible(false);
                lbltxt22.setText("Veuillez écrire un nouveau `Document`.");
                this.txt15.setVisible(false);
                lbltxt15.setText("Veuillez sélèctionner un `Type_de_Document_N1`.");
                this.txt21.setVisible(false);
                lbltxt21.setText("Veuillez sélèctionner un `Type_de_Document_N2`.");
                this.txt23.setVisible(false);
                lbltxt23.setText("Veuillez sélèctionner un `Type_de_Document_N3`.");
                break;
            case "SE":
                //System.out.println("Type_de_Document_N3");
                this.jScrollPane23.setVisible(false);
                lbltxt23.setText("Veuillez écrire un nouveau `Type_de_Document_N3`.");
                this.txt15.setVisible(false);
                lbltxt15.setText("Veuillez sélèctionner un `Document`.");
                this.txt21.setVisible(false);
                lbltxt21.setText("Veuillez sélèctionner un `Type_de_Document_N1`.");
                this.txt22.setVisible(false);
                lbltxt22.setText("Veuillez sélèctionner un `Type_de_Document_N1`.");
                break;
            default:
                //System.out.println("default");
                break;
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

        jpaneltxt17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jScrollPane23 = new javax.swing.JScrollPane();
        jList23 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        btnAjout = new javax.swing.JButton();
        jpaneltxt15 = new javax.swing.JPanel();
        txt15 = new javax.swing.JTextField();
        jpaneltxt21 = new javax.swing.JPanel();
        txt21 = new javax.swing.JTextField();
        jpaneltxt22 = new javax.swing.JPanel();
        txt22 = new javax.swing.JTextField();
        jpaneltxt23 = new javax.swing.JPanel();
        txt23 = new javax.swing.JTextField();
        lbltxt15 = new javax.swing.JLabel();
        lbltxt21 = new javax.swing.JLabel();
        lbltxt22 = new javax.swing.JLabel();
        lbltxt23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jpaneltxt17Layout = new javax.swing.GroupLayout(jpaneltxt17);
        jpaneltxt17.setLayout(jpaneltxt17Layout);
        jpaneltxt17Layout.setHorizontalGroup(
            jpaneltxt17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jpaneltxt17Layout.setVerticalGroup(
            jpaneltxt17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(960, 450));
        setUndecorated(true);
        setSize(new java.awt.Dimension(350, 250));
        getContentPane().setLayout(null);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel8.setEnabled(false);
        jPanel8.setMaximumSize(new java.awt.Dimension(970, 440));
        jPanel8.setMinimumSize(new java.awt.Dimension(970, 440));
        jPanel8.setPreferredSize(new java.awt.Dimension(970, 440));

        jPanel1.setBackground(new java.awt.Color(98, 173, 255));
        jPanel1.setAlignmentX(1.0F);
        jPanel1.setAlignmentY(1.0F);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/lock_50px.png"))); // NOI18N
        jLabel7.setText("AJOUTER UN ELEMENT DE CRITERE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane15.setMinimumSize(new java.awt.Dimension(186, 186));

        jList15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList15.setAutoscrolls(false);
        jList15.setFocusable(false);
        jList15.setMinimumSize(new java.awt.Dimension(186, 186));
        jList15.setName(""); // NOI18N
        jList15.setPreferredSize(new java.awt.Dimension(186, 186));
        jList15.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList15ValueChanged(evt);
            }
        });
        jScrollPane15.setViewportView(jList15);

        jScrollPane21.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList21.setFocusable(false);
        jList21.setMinimumSize(new java.awt.Dimension(186, 186));
        jList21.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList21ValueChanged(evt);
            }
        });
        jScrollPane21.setViewportView(jList21);

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList22.setFocusable(false);
        jList22.setMinimumSize(new java.awt.Dimension(186, 186));
        jList22.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList22ValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(jList22);

        jScrollPane23.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList23.setFocusable(false);
        jList23.setMinimumSize(new java.awt.Dimension(186, 186));
        jList23.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList23ValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(jList23);

        jButton2.setText("Retourner à l'indexation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAjout.setText("Ajouter un critere");
        btnAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutActionPerformed(evt);
            }
        });

        jpaneltxt15.setBackground(new java.awt.Color(255, 255, 255));

        txt15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneltxt15Layout = new javax.swing.GroupLayout(jpaneltxt15);
        jpaneltxt15.setLayout(jpaneltxt15Layout);
        jpaneltxt15Layout.setHorizontalGroup(
            jpaneltxt15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpaneltxt15Layout.setVerticalGroup(
            jpaneltxt15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpaneltxt21.setBackground(new java.awt.Color(255, 255, 255));

        txt21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneltxt21Layout = new javax.swing.GroupLayout(jpaneltxt21);
        jpaneltxt21.setLayout(jpaneltxt21Layout);
        jpaneltxt21Layout.setHorizontalGroup(
            jpaneltxt21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt21)
        );
        jpaneltxt21Layout.setVerticalGroup(
            jpaneltxt21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpaneltxt22.setBackground(new java.awt.Color(255, 255, 255));

        txt22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneltxt22Layout = new javax.swing.GroupLayout(jpaneltxt22);
        jpaneltxt22.setLayout(jpaneltxt22Layout);
        jpaneltxt22Layout.setHorizontalGroup(
            jpaneltxt22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt22)
        );
        jpaneltxt22Layout.setVerticalGroup(
            jpaneltxt22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpaneltxt23.setBackground(new java.awt.Color(255, 255, 255));

        txt23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneltxt23Layout = new javax.swing.GroupLayout(jpaneltxt23);
        jpaneltxt23.setLayout(jpaneltxt23Layout);
        jpaneltxt23Layout.setHorizontalGroup(
            jpaneltxt23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneltxt23Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txt23, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpaneltxt23Layout.setVerticalGroup(
            jpaneltxt23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneltxt23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbltxt15.setText("jLabel1");

        lbltxt21.setText("jLabel1");

        lbltxt22.setText("jLabel1");

        lbltxt23.setText("jLabel1");

        jLabel1.setText("Ateliers :");

        jLabel3.setText("GFH - Ligne :");

        jLabel4.setText("Machines :");

        jLabel5.setText("Sous-Ensemble :");

        jButton1.setText("Reinitialiser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jpaneltxt15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbltxt15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(jpaneltxt21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbltxt21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbltxt22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                            .addComponent(jpaneltxt22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addComponent(jpaneltxt23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(lbltxt23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jScrollPane22)
                    .addComponent(jScrollPane23)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpaneltxt15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpaneltxt22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpaneltxt21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpaneltxt23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltxt15)
                    .addComponent(lbltxt21)
                    .addComponent(lbltxt22)
                    .addComponent(lbltxt23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(btnAjout))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 0, 960, 440);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt23ActionPerformed

    private void txt22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt22ActionPerformed

    private void txt21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt21ActionPerformed

    private void txt15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt15ActionPerformed

    private void btnAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutActionPerformed

        ////System.out.println("Add critere");
        
        String GFH = txt21.getText();
        String Document = txt15.getText();
        String Mach = txt22.getText();
        String SE = txt23.getText();
        
        setElementAtelierSousEnsemble(Document,GFH,Mach,SE);
        
        this.TablLIer();
        rempList();
        
        if (PageIndex.equals("Simple")){
            new indexation().setVisible(true);
            this.dispose(); 
        }else if (PageIndex.equals("Multi")){
            new indexation_multiple().setVisible(true);
            this.dispose(); 
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjoutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (PageIndex.equals("Simple")){
            new indexation().setVisible(true);
            this.dispose(); 
        }else if (PageIndex.equals("Multi")){
            new indexation_multiple().setVisible(true);
            this.dispose(); 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList23ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList23ValueChanged
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList23ValueChanged

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList22ValueChanged

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged
        this.TablLIer();
        rempList();
    }//GEN-LAST:event_jList21ValueChanged

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
        this.TablLIer();
        rempList();
        
    }//GEN-LAST:event_jList15ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reini = true;
        this.TablLIer();
        rempList();
        reini = false;      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rempList(){
        rempList24();
        rempList14();
        rempList19();
        rempList20();
    }
    
    private void TablLIer() {

        
            ListJList20 = "(`Type_de_Document_N3` LIKE('%%'))";
            ListJList19 = "(`Type_de_Document_N2` LIKE('%%'))";
            ListJList14 = "(`Type_de_Document_N1` LIKE('%%'))";
            ListJList24 = "(`Document` LIKE('%%'))";
        

        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`Document` LIKE("%%"))
        List<String> SQLJList24 = jList15.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList24.isEmpty()) {
            ListJList24 = "(`Document` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList24.size(); i++) {
            ////////System.out.println(ListeTEST.get(i));
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
            //System.out.println("-ListJList24- "+ListJList24);
        //System.out.println("Requette document " +ListJList24);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_atelier_gfh_ligne`.`Type_de_Document_N1` LIKE("%%"))
        List<String> SQLJList14 = jList21.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList14.isEmpty()) {
            ListJList14 = "(`Type_de_Document_N1` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList14.size(); i++) {
            ////////System.out.println(ListeTEST.get(i));
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
            //System.out.println("-ListJList14- "+ListJList14);
        //System.out.println("Requette n1 " +ListJList14);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_gfh_ligne_machines`.`Machines` LIKE("%Banc de tirage%"))
        List<String> SQLJList19 = jList22.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList19.isEmpty()) {
            ListJList19 = "(`Type_de_Document_N2` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList19.size(); i++) {
            ////////System.out.println(ListeTEST.get(i));
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
            //System.out.println("-ListJList19- "+ListJList19);
        ////System.out.println(ListJList19);
        }
        //======================================================================================================================================\\
        //(`docfinder`.`tech_machines_sous_ensemble`.`Sous_ensemble` LIKE("%Automatisme & électricité%"))
        List<String> SQLJList20 = jList23.getSelectedValuesList();
        //String ListJList = "";
        if (!SQLJList20.isEmpty()) {
            ListJList20 = "(`Type_de_Document_N3` LIKE('%";
            
        int SupprElem = 0;
        for(int i=0; i<SQLJList20.size(); i++) {
            ////////System.out.println(ListeTEST.get(i));
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
            //System.out.println("-ListJList20- "+ListJList20);
        ////System.out.println(ListJList20);
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
        //System.out.println("RempList24");
        if (reini == true){
            ListJList20 = "(`Type_de_Document_N3` LIKE('%%'))";
            ListJList19 = "(`Type_de_Document_N2` LIKE('%%'))";
            ListJList14 = "(`Type_de_Document_N1` LIKE('%%'))";
            ListJList24 = "(`Document` LIKE('%%'))";
        }
        List<String> Listj = jList15.getSelectedValuesList();
        if (Listj.isEmpty() || reini == true){
        try {
            stm=conn.obtenirconnexion().createStatement();
            //ResultSet Rse=stm.executeQuery("SELECT * FROM `bddproduction` WHERE ("+ListJList+") ORDER BY `service` ASC");
            String requete="SELECT * FROM `tech_type_document` WHERE" +
            "("+ListJList24+" ) " +
            "AND ("+ListJList14+" ) " +
            "AND ("+ListJList19+" ) " +
            "AND ("+ListJList20+" ) ORDER BY `tech_type_document`.`Document` ASC";
            
            //System.out.println("Document" + requete);
            
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
                    //////System.out.println(mots[i]);
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
            jList15.setModel(jListModel);
        
        } catch (SQLException ex) {
            ////System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList14(){
        //System.out.println("RempList14");
        List<String> Listj = jList21.getSelectedValuesList();
        if (Listj.isEmpty() || reini == true){
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
                    //////System.out.println(mots[i]);
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
            jList21.setModel(jListModel);
        
        } catch (SQLException ex) {
            ////System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList19(){
        //System.out.println("RempList19");
        List<String> Listj = jList22.getSelectedValuesList();
        if (Listj.isEmpty() || reini == true){
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
                    //////System.out.println(mots[i]);
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
            jList22.setModel(jListModel);
        
        } catch (SQLException ex) {
            ////System.out.println(ex.getMessage());
        }
    }
    }
      
    private void rempList20(){
        //System.out.println("RempList20");
        List<String> Listj = jList23.getSelectedValuesList();
        if (Listj.isEmpty() || reini == true){
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
                    //////System.out.println(mots[i]);
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
            jList23.setModel(jListModel);
        
        } catch (SQLException ex) {
            ////System.out.println(ex.getMessage());
        }
    }
    }
    
    private void setElementAtelierSousEnsemble(String newDocument, String newType_de_Document_N1, String newType_de_Document_N2, String newType_de_Document_N3) {
        String Document = null;
        String Type_de_Document_N1 = null;
        String Type_de_Document_N2 = null;
        String Type_de_Document_N3 = null;
        int nb = 0;
        List<String> Vide = Arrays.asList((String) "[]");
        List<String> SQLJList15 = new ArrayList<>();
        List<String> SQLJList21 = new ArrayList<>();
        List<String> SQLJList22 = new ArrayList<>();
        List<String> SQLJList23 = new ArrayList<>();
        
        List<String> newsDocument = new ArrayList<>();
        List<String> newsType_de_Document_N1 = new ArrayList<>();
        List<String> newsType_de_Document_N2 = new ArrayList<>();
        List<String> newsType_de_Document_N3 = new ArrayList<>();
        
        if(!newDocument.equals("")){
            newsDocument.add(0, newDocument);
        }if(!newType_de_Document_N1.equals("")){
            newsType_de_Document_N1.add(0, newType_de_Document_N1);
        }if(!newType_de_Document_N2.equals("")){
            newsType_de_Document_N2.add(0, newType_de_Document_N2);
        }if(!newType_de_Document_N3.equals("")){
            newsType_de_Document_N3.add(0, newType_de_Document_N3);
        }
        
        if (newsDocument.isEmpty()){
            SQLJList15 = jList15.getSelectedValuesList();
            if(SQLJList15.isEmpty()){
                SQLJList15 = Vide;
            }
            System.out.println("SQLJList15 "+SQLJList15);
        } else {
            SQLJList15 = newsDocument;
            System.out.println("New SQLJList15 "+SQLJList15);
        }
        
        if (newsType_de_Document_N1.isEmpty()){
            SQLJList21 = jList21.getSelectedValuesList();
            if(SQLJList21.isEmpty()){
                SQLJList21 = Vide;
            }
            System.out.println("SQLJList21 "+SQLJList21);
        } else {
            SQLJList21 = newsType_de_Document_N1;
            System.out.println("New SQLJList21 "+SQLJList21);
        }
        
        if (newsType_de_Document_N2.isEmpty()){
            SQLJList22 = jList22.getSelectedValuesList();
            if(SQLJList22.isEmpty()){
                SQLJList22 = Vide;
            }
            System.out.println("SQLJList22 "+SQLJList22);
        } else {
            SQLJList22 = newsType_de_Document_N2;
            System.out.println("New SQLJList22 "+SQLJList22);
        }
        
        if (newsType_de_Document_N3.isEmpty()){
            SQLJList23 = jList23.getSelectedValuesList();
            if(SQLJList23.isEmpty()){
                SQLJList23 = Vide;
            }
            System.out.println("SQLJList23 "+SQLJList23);
        } else {
            SQLJList23 = newsType_de_Document_N3;
            System.out.println("New SQLJList23 "+SQLJList23);
        }
        //String ListJList = "";
        //------------------------------------------tech_atelier_gfh_ligne-----------------------------------------
            for(int i=0; i<SQLJList15.size(); i++) {
                //System.out.println("i "+i+" "+SQLJList15.size());
                ////System.out.println(SQLJList15.get(i));
                Document = SQLJList15.get(i);
                System.out.println("Document "+Document);
                for(int j=0; j<SQLJList21.size(); j++) {
                    //System.out.println("j "+j+" "+SQLJList21.size());
                    Type_de_Document_N1 = SQLJList21.get(j);
                    System.out.println("Type_de_Document_N1 "+Type_de_Document_N1);
                    for(int k=0; k<SQLJList22.size(); k++) {
                        //System.out.println("k "+k+" "+SQLJList22.size());
                        Type_de_Document_N2 = SQLJList22.get(k);
                        System.out.println("Type_de_Document_N2 "+Type_de_Document_N2);
                        for(int l=0; l<SQLJList23.size(); l++) {
                            //System.out.println("l "+l+" "+SQLJList23.size());
                            Type_de_Document_N3 = SQLJList23.get(l);
                            System.out.println("Type_de_Document_N3 "+Type_de_Document_N3);
                            
                            //------------------------------------------Methode D'AJOUT-----------------------------------------
                            try {
                                ResultSet Rs = stm.executeQuery("SELECT COUNT(*) FROM `tech_type_document` WHERE `Document` LIKE ('%"+Document+"%') "
                                        + "AND `Type_de_Document_N1` LIKE ('%"+Type_de_Document_N1+"%') "
                                        + "AND `Type_de_Document_N2` LIKE ('%"+Type_de_Document_N2+"%') "
                                        + "AND `Type_de_Document_N3` LIKE ('%"+Type_de_Document_N3+"%')");
                                while(Rs.next()) {
                                    nb = Rs.getInt(1);
                                }
                                System.out.println("SELECT COUNT(*) FROM `tech_type_document` WHERE `Document` LIKE ('%"+Document+"%') "
                                        + "AND `Type_de_Document_N1` LIKE ('%"+Type_de_Document_N1+"%') "
                                        + "AND `Type_de_Document_N2` LIKE ('%"+Type_de_Document_N2+"%') "
                                        + "AND `Type_de_Document_N3` LIKE ('%"+Type_de_Document_N3+"%')");
                            } catch (SQLException ex) {
                                Logger.getLogger(addServiceN3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("nb "+nb);
                            if(nb == 0){
                                try {
                                    //INSERT INTO `tech_critere` (`id`, `Lieu_archivage`, `Type_de_Materiel`, `Constructeur`, `Materiel`, `Annee`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL)
                                    String requete="INSERT INTO `tech_type_document` (`id`, `Document`, `Type_de_Document_N1`, `Type_de_Document_N2`, `Type_de_Document_N3`) VALUES (NULL, '"+Document+"', '"+Type_de_Document_N1+"', '"+Type_de_Document_N2+"', '"+Type_de_Document_N3+"')";
                                    System.out.println("Requete "+requete);
                                    stm.executeUpdate(requete);
                                } catch (SQLException ex) {
                                }
                            }

                            //------------------------------------------Methode D'AJOUT-----------------------------------------
                        }
                    }
                }
             }
        
        //------------------------------------------tech_atelier_gfh_ligne-----------------------------------------
        
        
        
    }
  
  
    
    public static void main(String args[]) throws MalformedURLException {
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
            java.util.logging.Logger.getLogger(addServiceN3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            @Override
            public void run() {
                new addServiceN3().setVisible(true);
                //("/icone/Logo_DocFinder.png")

            }
            //main.setUndecorated(true);

            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JPanel jpaneltxt15;
    private javax.swing.JPanel jpaneltxt17;
    private javax.swing.JPanel jpaneltxt21;
    private javax.swing.JPanel jpaneltxt22;
    private javax.swing.JPanel jpaneltxt23;
    private javax.swing.JLabel lbltxt15;
    private javax.swing.JLabel lbltxt21;
    private javax.swing.JLabel lbltxt22;
    private javax.swing.JLabel lbltxt23;
    private javax.swing.JTextField txt15;
    private javax.swing.JTextField txt21;
    private javax.swing.JTextField txt22;
    private javax.swing.JTextField txt23;
    // End of variables declaration//GEN-END:variables
}
