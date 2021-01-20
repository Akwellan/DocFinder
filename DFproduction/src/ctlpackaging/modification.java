
package ctlpackaging;

import static ctlpackaging.main.cheminseul_txt;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class modification extends javax.swing.JFrame {
    private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;
    private static String id_Fichier = recherche.idFichier;
    
    Connecter conn=new Connecter();
    Statement stm;
    ResultSet Rs;
    DefaultTableModel model=new DefaultTableModel();
    private String modifFichier = null;
    private String modifchemin = null;
    private String modifservice = null;
    private String modifVersion = null;
    private String modifSous_ensemble = null;
    private String modifMachines = null;
    private String modifGFH_Lignes = null;
    private String modifAtelier = null;
    private String modifType_de_document_N1 = null;
    private int k;
    private String elementelement_int_list = null;
    private String ModifService = null;
    
    
    public modification() {
        initComponents();
        connecter();
        System.out.println("Recherche :"+recherche.idFichier);
        id_Fichier = recherche.idFichier;
        System.out.println("Modification :"+id_Fichier);
        
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icone/Logo_DocFinder.png")));
        this.setTitle("DocFinder - Modification de [Fichier]");
                                            
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
        afficher();
        elementelement_int_list = "";
        ModifService = "";
        affichetable();
  
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
           
            this.lblConnecter.setText("SE CONNECTER ?");
        }else {
            jPanel14.setBackground(new Color (0,136,198));
            this.lblConnecter.setText("Connecté : ADMIN");
        }
        
    }
    
    private void affichetable() {
        
        try {
            
            ////System.out.println(id_Fichier);
            stm=conn.obtenirconnexion().createStatement();
            ResultSet Rs=stm.executeQuery("SELECT * FROM `bddproduction` WHERE `id` LIKE "+id_Fichier);
            while(Rs.next()){
                modifFichier = Rs.getString("fichier");
                modifchemin = Rs.getString("chemin");
                modifVersion = Rs.getString("Version");
                
                modifservice = Rs.getString("service");
                modifType_de_document_N1 = Rs.getString("Type_de_document_N1");
                modifAtelier = Rs.getString("Atelier");
                modifGFH_Lignes = Rs.getString("GFH_Lignes");
                modifMachines = Rs.getString("Machines");
                modifSous_ensemble = Rs.getString("Sous_ensemble");
                modifVersion = Rs.getString("Version");
                
            }
            ////System.out.println(modifType_de_document_N1);
        }catch(SQLException e){System.err.println(e);}
        selectElem();
        
    }
    
    private void selectElem(){
        //Table lié ------------------------
        selectElemn_jList();
        selectElemn_jList14();
        //Table lié ------------------------
        
        //Table lié ------------------------
        selectElemn_jList15();
        selectElemn_jList21();
        selectElemn_jList22();
        selectElemn_jList23();
        //Table lié ------------------------
        
    }
    //Table lié ------------------------
    private void selectElemn_jList(){
        
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        fichier_show.setText(modifFichier);
        chemin_show.setText(modifchemin);
        jVersion.setText(modifVersion);
        int JLIST_MAX = jList24.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            String elementelement_int_list = jList24.getModel().getElementAt(i);
            String ModifService = modifservice;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        
        //chaine_test_sel_Jlist = chaine_test_sel_Jlist.substring(6);
        
        //List ListSelected = Arrays.asList(chaine_test_sel_Jlist);
        
        ////System.out.println(ListSelected);
        ////System.out.println(Arrays.toString(selecttbl));
        //System.out.println("siIe0 "+siIe0);
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        
        
        
        ////System.out.println(Arrays.toString(selecttbl));
        jList24.setSelectedIndices(selecttbl);
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        
        
    }
    
    private void selectElemn_jList14(){
        
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        int JLIST_MAX = jList14.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            elementelement_int_list = jList14.getModel().getElementAt(i);
            ModifService = modifType_de_document_N1;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        ////System.out.println(Arrays.toString(selecttbl));
        jList14.setSelectedIndices(selecttbl);
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        
        
    }
    
   //Table lié ------------------------
    
    //Table lié ------------------------
    private void selectElemn_jList15(){
        
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        int JLIST_MAX = jList15.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            String elementelement_int_list = jList15.getModel().getElementAt(i);
            String ModifService = modifAtelier;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        
        //chaine_test_sel_Jlist = chaine_test_sel_Jlist.substring(6);
        
        //List ListSelected = Arrays.asList(chaine_test_sel_Jlist);
        
        ////System.out.println(ListSelected);
        ////System.out.println(Arrays.toString(selecttbl));
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        ////System.out.println(Arrays.toString(selecttbl));
        jList15.setSelectedIndices(selecttbl);
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        
        
    }
    
    private void selectElemn_jList21(){
        
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        int JLIST_MAX = jList21.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            String elementelement_int_list = jList21.getModel().getElementAt(i);
            String ModifService = modifGFH_Lignes;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        ////System.out.println(Arrays.toString(selecttbl));
        jList21.setSelectedIndices(selecttbl);
        
        //Select jList SERVICE----------------------------------------------------------------------------------------------------------------
        
        
    }
    
    private void selectElemn_jList22(){
        
        
        //Select jList modifMachines----------------------------------------------------------------------------------------------------------------
        int JLIST_MAX = jList22.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            String elementelement_int_list = jList22.getModel().getElementAt(i);
            String ModifService = modifMachines;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        ////System.out.println(Arrays.toString(selecttbl));
        jList22.setSelectedIndices(selecttbl);
        
        //Select jList modifMachines----------------------------------------------------------------------------------------------------------------
        
        
    }
    
    private void selectElemn_jList23(){
        
        
        //Select jList modifType_de_document_N3----------------------------------------------------------------------------------------------------------------
        int JLIST_MAX = jList23.getModel().getSize();
        int siIe0 = 0;
        int selecttbl[] = new int[JLIST_MAX];
        
        //String chaine_test_sel_Jlist = null;
        k=0;
        for (int i = 0; i < JLIST_MAX; i++){
            
            //Element JList
            String elementelement_int_list = jList23.getModel().getElementAt(i);
            String ModifService = modifSous_ensemble;
            
            ////System.out.println(elementelement_int_list);
            boolean indexOf = ModifService.contains(elementelement_int_list);
            //System.out.println(elementelement_int_list+" "+ModifService+" "+indexOf);
             
            if (indexOf == true){
                if(i==0){
                    siIe0 = 1; //Premier dans le tableau et valide
                }
                //chaine_test_sel_Jlist = chaine_test_sel_Jlist + ", "+i;
                selecttbl[k] = i;
                k++;
            }
             
        }
        if(siIe0==0){
            for (int i = 0; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }else {
            for (int i = 1; i < JLIST_MAX; i++){
                if (selecttbl[i] ==0){
                    selecttbl[i] = JLIST_MAX+1;
                }
            }
        }
        ////System.out.println(Arrays.toString(selecttbl));
        jList23.setSelectedIndices(selecttbl);
        
        //Select jList modifType_de_document_N3----------------------------------------------------------------------------------------------------------------
        
        
    }
    //Table lié ------------------------
    
    
    //Table non lié ------------------------
         
 
    
    
    private modification(Runnable aThis) {
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
        jPanel14 = new javax.swing.JPanel();
        lblConnecter = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jList24 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jVersion = new javax.swing.JTextField();

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
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel14.setBackground(new java.awt.Color(0, 86, 172));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
        });

        lblConnecter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConnecter.setForeground(new java.awt.Color(255, 255, 255));
        lblConnecter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/loginnnnn_24px.png"))); // NOI18N
        lblConnecter.setText("  SE CONNECTER ?");
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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConnecter, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConnecter, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

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
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(98, 173, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/pin_50px.png"))); // NOI18N
        jLabel7.setText("MODIFIER UN INDEX");

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
        chemin_show.setMaximumSize(new java.awt.Dimension(14, 28));
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
        jScrollPane23.setViewportView(jList23);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Service : ");

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

        jScrollPane24.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jList24.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList24ValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(jList24);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("SUPPRIMER L'INDEX");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Retour RECHERCHE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Version :");

        jVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVersionActionPerformed(evt);
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
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel19))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(712, 712, 712)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fichier_show, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chemin_show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(3, 3, 3)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        recherche recherche = new recherche();
        recherche.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            stm=conn.obtenirconnexion().createStatement();
            ////System.out.println("ID du fichier a supprimer : "+id_Fichier);
            int retour = JOptionPane.showConfirmDialog(this,"Voulez-vous supprimer l'index ?","DocFinder - Suppression",JOptionPane.OK_CANCEL_OPTION);
            //System.out.println("Retour "+retour);
            if(retour == 0) {
                stm.executeUpdate("DELETE FROM `bddproduction` WHERE `bddproduction`.`id` = "+id_Fichier);
                this.dispose();
                recherche recherche = new recherche();
                recherche.setVisible(true);
                JOptionPane.showMessageDialog(null,"L'index à bien été supprimé.");
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fichier=fichier_show.getText();
        String chemin=chemin_show.getText();
        chemin = chemin.replaceAll("\\\\", "/");
            fichier=fichier.replaceAll("\'","\\\\'");

            List<String> service = jList24.getSelectedValuesList();
            String Version = this.jVersion.getText();

            List<String> Type_de_document_N1 = jList14.getSelectedValuesList();

            List<String> Atelier = jList15.getSelectedValuesList();
            List<String> GFH_Lignes = jList21.getSelectedValuesList();
            List<String> Machines = jList22.getSelectedValuesList();
            List<String> Sous_ensemble = jList23.getSelectedValuesList();

            ////System.out.println(service);
            // //System.out.println(fichier);
            //S!ystem.out.println(chemin);
            String requete ="UPDATE `bddproduction` SET `fichier` = '"+fichier+"', `chemin` = '"+chemin+"', `service` = '"+service+"', "
                    + "`Type_de_document_N1` = '"+Type_de_document_N1+"', `Atelier` = '"+Atelier+"', `"
            + "GFH_Lignes` = '"+GFH_Lignes+"', `Machines` = '"+Machines+"', `Sous_ensemble` = '"+Sous_ensemble+"', `Version` = '"+Version+"' WHERE `bddproduction`.`id` = "+id_Fichier+";";
            //        String requete="insert into bddproduction(id,fichier,chemin,service,Type_de_document_N1,Type_de_document_N2,Type_de_document_N3,Lieu_Archivage,Type_de_Materiel,Constructeur"
            //                + ",Materiel,Atelier,GFH_Lignes,Machines,Sous_ensemble,Version)VALUES"
            //                + "(NULL,'"+fichier+"','"+chemin+"','"+service+"','"+Type_de_document_N1+"','"+Ty'pe_de_document_N2+"','"+Type_de_document_N3+"','"+Lieu_archivage+"',"
            //                + "'"+Type_de_Materiel+"','"+Constructeur+"','"+Materiel+"','"+Atelier+"','"+GFH_Lignes+"','"+Machines+"','"+Sous_ensemble+"','"+Annee+"')";
            try{
                stm.executeUpdate(requete);
                this.dispose();
                main mn = new main();
                mn.setVisible(true);
                JOptionPane.showMessageDialog(null,"L'index du fichier "+fichier+" à bien été modifié.");
                fichier_show.setText("");
                chemin_show.setText("");
                //txtpr.setText("");txtbr.setSelectedItem(2);txtnot.setText("");
                afficher();

            }catch(HeadlessException | SQLException ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jList24ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList24ValueChanged
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            stm=conn.obtenirconnexion().createStatement();

            //-------------TABLE LIER DOC-N3----------------------------
            //String ServiceSQL = JList.getSelectedValuesList().toString();
            //ServiceSQL  = ServiceSQL.replaceAll("\\[|\\]", "");
            List<String> ServiceSQL = jList24.getSelectedValuesList();
            String ListService = "";
            for(int i=0; i<ServiceSQL.size(); i++) {
                ////System.out.println(ListeTEST.get(i));
                ListService = ListService + ", '"+ServiceSQL.get(i)+"'";

            }
            if(!"".equals(ListService)){
                ListService = ListService.substring(2);
                ////System.out.println(ListService);
            }
            ResultSet Rstd=stm.executeQuery("SELECT * "
                + "FROM `prod_type_document` "
                + "WHERE `Document`IN ("+ListService+")");

            ////System.out.println(a);

            DefaultListModel Type_de_Document_N1=new DefaultListModel();
            DefaultListModel Type_de_Document_N2=new DefaultListModel();
            DefaultListModel Type_de_Document_N3=new DefaultListModel();

            while(Rstd.next()) {
                String nomN1 = Rstd.getString("Type_de_Document_N1");
                String nomN2 = Rstd.getString("Type_de_Document_N2");
                String nomN3 = Rstd.getString("Type_de_Document_N3");
                int incremN1 = 0;
                int incremN2 = 0;
                int incremN3 = 0;

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

            jList14.setModel(Type_de_Document_N1);

        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jList24ValueChanged

    private void jList22ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList22ValueChanged
        try {
            stm=conn.obtenirconnexion().createStatement();

            //-------------TABLE LIER DOC-N3----------------------------
            List<String> ServiceSQL = jList22.getSelectedValuesList();
            String JListTrier = "";
            for(int i=0; i<ServiceSQL.size(); i++) {
                ////System.out.println(ListeTEST.get(i));
                JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";

            }
            if(!"".equals(JListTrier)){
                JListTrier = JListTrier.substring(2);
            }
            ResultSet Rstd=stm.executeQuery("SELECT * "
                + "FROM `prod_machines_sous_ensemble` "
                + "WHERE `Machines`IN ("+JListTrier+")");

            DefaultListModel Sous_ensemble=new DefaultListModel();
            //DefaultListModel Type_de_Document_N1=new DefaultListModel();
            //DefaultListModel Type_de_Document_N2=new DefaultListModel();

            while(Rstd.next())
            {
                String nomSous_ensemble = Rstd.getString("Sous_ensemble");
                int incremSous_ensemble = 0;

                //------------------------------------------------------------------------
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

                //                        if(Rstd.getString("Type_de_Document_N1") != null) {
                    //                            Type_de_Document_N1.addElement(Rstd.getString("Type_de_Document_N1"));
                    //                        }
                //
                //                        if(Rstd.getString("Type_de_Document_N2") != null) {
                    //                            Type_de_Document_N2.addElement(Rstd.getString("Type_de_Document_N2"));
                    //                        }

            }
            jList23.setModel(Sous_ensemble);
            //JList7.setModel(Type_de_Document_N1);
            //JList8.setModel(Type_de_Document_N2);

        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jList22ValueChanged

    private void jList21ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList21ValueChanged
        try {
            stm=conn.obtenirconnexion().createStatement();

            //-------------TABLE LIER DOC-N3----------------------------
            List<String> ServiceSQL = jList21.getSelectedValuesList();
            String JListTrier = "";
            for(int i=0; i<ServiceSQL.size(); i++) {
                ////System.out.println(ListeTEST.get(i));
                JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";

            }
            if(!"".equals(JListTrier)){
                JListTrier = JListTrier.substring(2);
            }
            ResultSet Rstd=stm.executeQuery("SELECT * "
                + "FROM `prod_gfh_ligne_machines` "
                + "WHERE `GFH_Ligne`IN ("+JListTrier+")");

            DefaultListModel Machines=new DefaultListModel();
            DefaultListModel Rien=new DefaultListModel();
            //DefaultListModel Type_de_Document_N1=new DefaultListModel();
            //DefaultListModel Type_de_Document_N2=new DefaultListModel();

            while(Rstd.next())
            {
                String nomMachines = Rstd.getString("Machines");
                int incremMachines = 0;

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
                }

            }
            jList22.setModel(Machines);
            jList23.setModel(Rien);
            //JList7.setModel(Type_de_Document_N1);
            //JList8.setModel(Type_de_Document_N2);

        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }        // TODO add your handling code here:  // TODO add your handling code here:
    }//GEN-LAST:event_jList21ValueChanged

    private void jList15ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList15ValueChanged
        try {
            stm=conn.obtenirconnexion().createStatement();

            //-------------TABLE LIER DOC-N3----------------------------
            List<String> ServiceSQL = jList15.getSelectedValuesList();
            String JListTrier = "";
            for(int i=0; i<ServiceSQL.size(); i++) {
                ////System.out.println(ListeTEST.get(i));
                JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";

            }
            if(!"".equals(JListTrier)){
                JListTrier = JListTrier.substring(2);
            }
            ResultSet Rstd=stm.executeQuery("SELECT * "
                + "FROM `prod_atelier_gfh_ligne` "
                + "WHERE `Ateliers`IN ("+JListTrier+")");

            DefaultListModel GFH_Ligne=new DefaultListModel();
            DefaultListModel Rien=new DefaultListModel();
            //DefaultListModel Type_de_Document_N2=new DefaultListModel();

            while(Rstd.next()) {
                String nomGFH_Ligne = Rstd.getString("GFH_Ligne");
                int incremGFH_Ligne = 0;

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

                //                        if(Rstd.getString("Type_de_Document_N1") != null) {
                    //                            Type_de_Document_N1.addElement(Rstd.getString("Type_de_Document_N1"));
                    //                        }
                //
                //                        if(Rstd.getString("Type_de_Document_N2") != null) {
                    //                            Type_de_Document_N2.addElement(Rstd.getString("Type_de_Document_N2"));
                    //                        }

            }
            jList21.setModel(GFH_Ligne);
            jList22.setModel(Rien);
            jList23.setModel(Rien);

        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jList15ValueChanged

    private void jList14ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList14ValueChanged
        try {
            stm=conn.obtenirconnexion().createStatement();

            //-------------TABLE LIER DOC-N3----------------------------
            //String TypeN1SQL = JList7.getSelectedValuesList().toString();
            //TypeN1SQL  = TypeN1SQL.replaceAll("\\[|\\]", "");

            List<String> ServiceSQL = jList14.getSelectedValuesList();
            String JListTrier = "";
            for(int i=0; i<ServiceSQL.size(); i++) {
                ////System.out.println(ListeTEST.get(i));
                JListTrier = JListTrier + ", '"+ServiceSQL.get(i)+"'";

            }
            if(!"".equals(JListTrier)){
                JListTrier = JListTrier.substring(2);
            }
            ResultSet Rstd=stm.executeQuery("SELECT * "
                + "FROM `prod_type_document` "
                + "WHERE `Type_de_Document_N1`IN ("+JListTrier+")");

            DefaultListModel Document=new DefaultListModel();
            DefaultListModel Type_de_Document_N2=new DefaultListModel();
            DefaultListModel Type_de_Document_N3=new DefaultListModel();

            while(Rstd.next()) {
                String nomDoc = Rstd.getString("Document");
                String nomN2 = Rstd.getString("Type_de_Document_N2");
                String nomN3 = Rstd.getString("Type_de_Document_N3");
                int incremDoc = 0;
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


        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jList14ValueChanged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(main.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void lblConnecterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseExited
        if (main.connect == false){
            jPanel14.setBackground(new Color (0,86,172));
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblConnecterMouseExited

    private void lblConnecterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseEntered

        if (main.connect == false){
            jPanel14.setBackground(new Color (0,136,198));
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblConnecterMouseEntered

    private void lblConnecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnecterMouseClicked
        // TODO add your handling code here:

        if (main.connect == false) {
            admin adm = new admin();
            adm.setVisible(true);
            main.page = "main";
            this.dispose();
        }
    }//GEN-LAST:event_lblConnecterMouseClicked

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
        jPanel8.setBackground(new Color (0,86,172)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jPanel8.setBackground(new Color (0,136,198)); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

        option option = new option();
        option.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jPanel7.setBackground(new Color (0,86,172));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jPanel7.setBackground(new Color (0,136,198));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.dispose();
        this.removeAll();
        modifFichier = null;
        modifchemin = null;
        modifservice = null;
        modifVersion = null;
        modifSous_ensemble = null;
        modifMachines = null;
        modifGFH_Lignes = null;
        modifAtelier = null;
        modifType_de_document_N1 = null;

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
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVersionActionPerformed

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
        this.dispose();        // TODO add your handling code here:
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
    private void afficher(){

try {
                    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    stm=conn.obtenirconnexion().createStatement();
                    //-------------TABLE NON LIER----------------------------
                    ResultSet Rse=stm.executeQuery("Select * from prod_critere");
                 
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


                        

                        
                    }
                    ////System.out.println(LieuArchi.get(1));
                    
                    //-------------TABLE LIER DOC-N3----------------------------
                    
                    ResultSet Rstd=stm.executeQuery("Select * from prod_type_document");
                 
                    ////System.out.println(a);
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
                    
                    
                    //-------------TABLE LIER ATELIERS-GFH-LIgne----------------------------
                    
                    ResultSet Rstj=stm.executeQuery("Select * from prod_atelier_gfh_ligne");
                 
                    ////System.out.println(a);
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
                    
                    ResultSet Rsms=stm.executeQuery("Select * from prod_machines_sous_ensemble");
                 
                    ////System.out.println(a);
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
                    //System.out.println(ex.getMessage());
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
            java.util.logging.Logger.getLogger(modification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new modification().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chemin_show;
    private javax.swing.JTextField fichier_show;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JList<String> jList24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JTextField jVersion;
    private javax.swing.JLabel lblConnecter;
    // End of variables declaration//GEN-END:variables
}
