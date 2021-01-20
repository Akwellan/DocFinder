package ctlpackaging;

import static ctlpackaging.main.cheminseul_txt;
import static ctlpackaging.main.tableauindex;
import static ctlpackaging.main.test_txt;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class option extends javax.swing.JFrame {
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;

    Connecter conn=new Connecter();
    
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    private String tmp;
    
    
    public option() {
        initComponents();
        this.jPanelConnexion.setVisible(false);
        this.jPanelConnecter.setVisible(false);
        connecter();
        //this.jPanelContact.setLocation(100, 100);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Modification de [Fichier]");
        RecupFichier.setCurrentSoftware("Production", "option");
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
        getVersion();
        main.Ligne = ctlpackaging.RecupFichier.getPropertiesLigne();
        main.Version = ctlpackaging.RecupFichier.getPropertiesVersion();
        main.langue = ctlpackaging.RecupFichier.getPropertieslangue();
        String Vers = RecupFichier.getPropertiesVersion();
        //System.out.println("Vers " +Vers);
        jLabel14.setText("Version : "+Vers);
        ComboLigne();
        
        switch (main.langue) {
            case "FR_fr":
                this.jComboBox1.setSelectedItem("Français");
                break;
            case "EN_en":
                this.jComboBox1.setSelectedItem("English");                
                break;
            case "ES_es":
                this.jComboBox1.setSelectedItem("Spanish");                
                break;
            default:
                break;
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
  
    
    private void ComboLigne(){
        DefaultComboBoxModel comboLigne=new DefaultComboBoxModel();
        String GFHLigne=null;
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rs=stm.executeQuery("SELECT * FROM `options_gfh_lignes`");
            while(Rs.next()){
                GFHLigne = Rs.getString("GFH_Ligne");
                if(GFHLigne!=null){
                    comboLigne.addElement(GFHLigne);
                }
                System.out.println(GFHLigne);
            }
        }catch(SQLException e){System.err.println(e);} 
        jComboBoxLigne.setModel(comboLigne);
        main.Ligne = RecupFichier.getPropertiesLigne();
        jComboBoxLigne.setSelectedItem(main.Ligne);
        
    }
   
    private void getVersion(){
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rs=stm.executeQuery("SELECT * FROM `suiviversion`");
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString("Numero_Version")});
                String Vers = Rs.getString("Numero_Version");
                RecupFichier.setProperties(main.Ligne,Vers,main.langue);
            }
        }catch(SQLException e){System.err.println(e);}   
    }
    
    public void connecter() {
        
        if (main.connect == false) {
            System.out.println("Se connecter ?");
            this.jPanelConnexion.setVisible(true);
            this.jPanel6.setVisible(false);
            this.jLabel21.setVisible(false);
        }else {
            System.out.println("Connecter : ADMIN");
            this.jPanelConnecter.setVisible(true);
            this.jPanel6.setVisible(true);
            this.jLabel21.setVisible(true);
            ConnecterOn();
        }
        
    }
    
    private void connexion(){
        
        String username = null;
        String password = null;

        char[] pass = jPasswordField1.getPassword();
        String passconvert = new String(pass);
        
        String user = jTextField1.getText();
        
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rse=stm.executeQuery("SELECT * FROM `user` WHERE `id` = 2");
            while(Rse.next()){   
                username = Rse.getString("username");
                password = Rse.getString("password");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (username.equals(user) && (password.equals(passconvert))){
           
            main.connect = true;
            this.jPanelConnexion.setVisible(false);
            this.jPanelConnecter.setVisible(true);
            ConnecterOn();
            
        } else {
            JOptionPane.showMessageDialog(null,
                    "Le nom d'utilisateur ou le mot de passe est incorrecte. Veuillez rééssayer.",
                    "Echec de l'authentification.",
                    JOptionPane.WARNING_MESSAGE);
       }
        
    }
    
    private void ConnecterOn(){
        
        String username = null;
        String password = null;
        
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rse=stm.executeQuery("SELECT * FROM `user` WHERE `id` = 2");
            while(Rse.next()){   
                username = Rse.getString("username");
                password = Rse.getString("password");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        this.txtUser.setText(username);
        this.txtPassword.setText(password);

    }
    
    private void ChangeIdentifiant(){
        
        String username = null;
        String password = null;
        
        try {
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rse=stm.executeQuery("SELECT * FROM `user` WHERE `id` = 2");
            while(Rse.next()){   
                username = Rse.getString("username");
                password = Rse.getString("password");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        boolean ChangeUser = false;
        boolean ChangePassword = false;
        
        //Identifiant
        char[] pass = txtPassword.getPassword();
        String passconvert = new String(pass);    
        String user = txtUser.getText();
        
        //Identifiant retaper
        char[] passRetape = txtRetapPassword.getPassword();
        String passconvertRetape = new String(passRetape);
        String userRetape = txtRetapUser.getText();
                
        if(!userRetape.equals("")){//Change user
                ChangeUser = true;
                username = userRetape;
        }
        
        if(!passconvertRetape.equals("")){//Change mot de passe
                ChangePassword = true;
                password = passconvertRetape;
        }
         if((ChangePassword==true) || (ChangeUser==true)){
            if((ChangePassword==true) && (ChangeUser==false)){
                System.out.println("Mot de passe changé");
                JOptionPane.showMessageDialog(null,
                    "Le mot de passe est désormais "+password,
                    "Mot de passe changé avec succés.",
                    JOptionPane.INFORMATION_MESSAGE);
                this.txtRetapPassword.setText("");
                ChangeIdentifiant();
            }else if((ChangePassword==false) && (ChangeUser==true)){
                System.out.println("User changé");
                JOptionPane.showMessageDialog(null,
                    "L'User est désormais "+username,
                    "Utilisateur changé avec succés.",
                    JOptionPane.INFORMATION_MESSAGE);
                this.txtRetapUser.setText("");
                ChangeIdentifiant();
            }else if((ChangePassword==true) && (ChangeUser==true)){
                System.out.println("Identifiant changé");
                JOptionPane.showMessageDialog(null,
                    "L'User est désormais "+username+"\nLe mot de passe est désormais "+password,
                    "Identifiant du compte admin changé avec succés.",
                    JOptionPane.INFORMATION_MESSAGE);
                this.txtRetapPassword.setText("");
                this.txtRetapUser.setText("");
                ChangeIdentifiant();
            }
            
            String requete ="UPDATE `user` SET `username` = '"+username+"', `password` = '"+password+"' WHERE `user`.`id` = 2";
            System.out.println(requete);
            try{stm.executeUpdate(requete);} catch (SQLException ex) {JOptionPane.showMessageDialog(null,ex.getMessage());}
            ConnecterOn();
        }
        
        
    
    
    }
  
    private void SendContact() throws SQLException{
        stm=conn.obtenirconnexion().createStatement();
        
        String Name = this.txtNameContact.getText();
        String Desc = this.txtDescContact.getText();
        String Type = (String) this.ComboTypeContact.getSelectedItem();
        
        String requete ="INSERT INTO `supervision` (`id`, `nom`, `type`, `description`) VALUES (NULL, '"+Name+"', '"+Type+"', '"+Desc+"');";
        System.out.println(requete);
        try{
            stm.executeUpdate(requete);
            JOptionPane.showMessageDialog(null,"Le contact du type '"+Type+"' à été envoyer");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
        
        
    
    

  
    
    
    private option(Runnable aThis) {
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
        jLabel27 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanelConnexion = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSeConnecter = new java.awt.Button();
        jLabel8 = new javax.swing.JLabel();
        jPanelConnecter = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        txtRetapUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnValider = new java.awt.Button();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRetapPassword = new javax.swing.JPasswordField();
        jPanelContact = new javax.swing.JPanel();
        btnValider1 = new java.awt.Button();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNameContact = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ComboTypeContact = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescContact = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxLigne = new javax.swing.JComboBox<>();

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
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 136, 198));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/settings_24px.png"))); // NOI18N
        jLabel23.setText("OPTIONS");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
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
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
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
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
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

        jLabel27.setBackground(new java.awt.Color(0, 136, 198));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/processor_24px.png"))); // NOI18N
        jLabel27.setText("MODE PRODUCTION");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
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

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/full_tool_storage_box_24px.png"))); // NOI18N
        jLabel28.setText("MODE TECHNIQUE");
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

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(98, 173, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/pin_50px.png"))); // NOI18N
        jLabel7.setText("Option");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Français", "English", "Spanish" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jComboBox1HierarchyChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Langue séléctionné :");

        jPanelConnexion.setBackground(new java.awt.Color(98, 173, 255));
        jPanelConnexion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(6, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel5.setText("UTILISATEUR :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/password_14px.png"))); // NOI18N
        jLabel6.setText("MOT DE PASSE :");

        btnSeConnecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeConnecter.setLabel("Se connecter");
        btnSeConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeConnecterActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/lock_50px.png"))); // NOI18N
        jLabel8.setText("ADMIN");

        javax.swing.GroupLayout jPanelConnexionLayout = new javax.swing.GroupLayout(jPanelConnexion);
        jPanelConnexion.setLayout(jPanelConnexionLayout);
        jPanelConnexionLayout.setHorizontalGroup(
            jPanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConnexionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConnexionLayout.createSequentialGroup()
                        .addGroup(jPanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeConnecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelConnexionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConnexionLayout.setVerticalGroup(
            jPanelConnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConnexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeConnecter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanelConnecter.setBackground(new java.awt.Color(98, 173, 255));
        jPanelConnecter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtRetapUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtRetapUser.setMinimumSize(new java.awt.Dimension(6, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel9.setText("Veuillez retapper l'utilisateur si vous voulez le changer :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/password_14px.png"))); // NOI18N
        jLabel10.setText("MOT DE PASSE :");

        btnValider.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnValider.setLabel("Valider les changements");
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/lock_50px.png"))); // NOI18N
        jLabel11.setText("ADMIN");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel12.setText("UTILISATEUR :");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtUser.setMinimumSize(new java.awt.Dimension(6, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/password_14px.png"))); // NOI18N
        jLabel13.setText("Veuillez retapper le mot de passe si vous voulez le changer :");

        txtRetapPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetapPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConnecterLayout = new javax.swing.GroupLayout(jPanelConnecter);
        jPanelConnecter.setLayout(jPanelConnecterLayout);
        jPanelConnecterLayout.setHorizontalGroup(
            jPanelConnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConnecterLayout.createSequentialGroup()
                .addGroup(jPanelConnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConnecterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelConnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelConnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnValider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRetapPassword, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9)
                            .addComponent(txtRetapUser, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelConnecterLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConnecterLayout.setVerticalGroup(
            jPanelConnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConnecterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(9, 9, 9)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRetapUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRetapPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnValider, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanelContact.setBackground(new java.awt.Color(98, 173, 255));
        jPanelContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnValider1.setActionCommand("Envoyer");
        btnValider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnValider1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnValider1.setLabel("Envoyer");
        btnValider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValider1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/lock_50px.png"))); // NOI18N
        jLabel16.setText("CONTACT");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel17.setText("UTILISATEUR :");

        txtNameContact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNameContact.setMinimumSize(new java.awt.Dimension(6, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel19.setText("TYPE :");

        ComboTypeContact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComboTypeContact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BUG", "Recommandation" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/user_14px.png"))); // NOI18N
        jLabel15.setText("DESCRIPTION :");

        txtDescContact.setColumns(20);
        txtDescContact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescContact.setRows(5);
        jScrollPane1.setViewportView(txtDescContact);

        javax.swing.GroupLayout jPanelContactLayout = new javax.swing.GroupLayout(jPanelContact);
        jPanelContact.setLayout(jPanelContactLayout);
        jPanelContactLayout.setHorizontalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNameContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboTypeContact, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContactLayout.setVerticalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addComponent(txtNameContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboTypeContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnValider1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel14.setText("Version 1.1.0.0");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel18.setText("Par Benjamin Thierry et Bastien Sérange");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Ligne séléctionné :");

        jComboBoxLigne.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxLigne.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLigneItemStateChanged(evt);
            }
        });
        jComboBoxLigne.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jComboBoxLigneHierarchyChanged(evt);
            }
        });
        jComboBoxLigne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLigneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanelContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelConnecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGap(20, 20, 20))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxLigne, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65))))
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLigne, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelConnexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelConnecter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(main.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(new Color (0,86,172)); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(new Color (0,136,198));  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jPanel7.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jPanel7.setBackground(new Color (0,136,198));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.dispose();
        main mn = new main();
        mn.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jPanel9.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jPanel9.setBackground(new Color (0,136,198));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        this.dispose();
        recherche rchr = new recherche();
        rchr.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jPanel6.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jPanel6.setBackground(new Color (0,136,198));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void btnSeConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeConnecterActionPerformed
        this.connexion();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeConnecterActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        ChangeIdentifiant();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnValiderActionPerformed

    private void txtRetapPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRetapPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRetapPasswordActionPerformed

    private void btnValider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValider1ActionPerformed
        try {
            SendContact();
        } catch (SQLException ex) {
            Logger.getLogger(option.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtDescContact.setText("");
        this.txtNameContact.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnValider1ActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
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
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jComboBox1HierarchyChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1HierarchyChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        Object SelectLang = this.jComboBox1.getSelectedItem();
        main.langue = (String) SelectLang;

        switch (main.langue) {
            case "Français":
                RecupFichier.setProperties(main.Ligne,main.Version,"FR_fr");
                break;
            case "English":
                RecupFichier.setProperties(main.Ligne,main.Version,"EN_en");
                break;
            case "Spanish":
                RecupFichier.setProperties(main.Ligne,main.Version,"ES_es");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
    
        if (evt.getClickCount()==1){

        Runtime runtime = Runtime.getRuntime();
        try {//Ouverture
            runtime.exec(new String[] { "D:\\Doosier ALL\\DesktopGoose v0.3\\GooseDesktop.exe" } );//H:\\DOSSIERS PERSONNELS\\Bastien\\DesktopGoose v0.3\\GooseDesktop.exe
            Thread.sleep(30000);
            runtime.exec(new String[] { "D:\\Doosier ALL\\DesktopGoose v0.3\\Close Goose.bat" } );
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(option.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else {//Fermeture
    Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(new String[] { "D:\\Doosier ALL\\DesktopGoose v0.3\\Close Goose.bat" } );//H:\\DOSSIERS PERSONNELS\\Bastien\\DesktopGoose v0.3\\Close Goose.bat
        } catch (IOException ex) {
            Logger.getLogger(option.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jComboBoxLigneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLigneItemStateChanged
        Object SelectLigne = this.jComboBoxLigne.getSelectedItem();
        main.Ligne = (String) SelectLigne;
        System.out.println(main.Ligne);
        RecupFichier.setProperties(main.Ligne,main.Version,main.langue);

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLigneItemStateChanged

    private void jComboBoxLigneHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jComboBoxLigneHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLigneHierarchyChanged

    private void jComboBoxLigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLigneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLigneActionPerformed

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

        admin adm = new admin();
        adm.setVisible(true);
        main.page = "tech";
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jPanel19.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jPanel19.setBackground(new Color (0,86,172));          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

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
            java.util.logging.Logger.getLogger(option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new option().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTypeContact;
    private java.awt.Button btnSeConnecter;
    private java.awt.Button btnValider;
    private java.awt.Button btnValider1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxLigne;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanelConnecter;
    private javax.swing.JPanel jPanelConnexion;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtDescContact;
    private javax.swing.JTextField txtNameContact;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetapPassword;
    private javax.swing.JTextField txtRetapUser;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
