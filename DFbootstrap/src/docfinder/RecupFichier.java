/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docfinder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
/**
 *
 * @author Akwellan
 */
public class RecupFichier {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        create();
        
            
    }public static void create() throws IOException{
        
        createFolder();
        
        createProperties();
        
    }
    
    
    
    private static void createFolder() {
        String chems = null;
        chems = System.getenv("APPDATA")+"\\DocFinder";
        File file = new File(chems);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        } else {
            System.out.println("Deja existant directory!");
        }
        
    } private static void createProperties() throws IOException{
        File fichier = new File(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
        Path path = Paths.get(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
        
        if (fichier.createNewFile()){
            System.out.println("Le fichier a été créé");
            try {
            String str = "#####################CONFIG DocFinder CTL#####################\n\n" +
                         "CurrentSoftware = AUCUN\n" +
                         "Page = main\n" +
                         "#####################CONFIG DocFinder CTL#####################";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            //System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (IOException e) {}
        }else{
            System.out.println("Fichier déja crée");
        }
        
        
        
    } 
    
    public static String getCurrentSoftware(){
        String CurrentSoftware=null;
        final Properties prop = new Properties();
        InputStream input = null;
        try {
        input = new FileInputStream(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
        prop.load(input);
        CurrentSoftware = prop.getProperty("CurrentSoftware");
        //System.out.println(langue);
        } catch (final IOException ex) {
        }   finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException e) {
                    }
                }
            }
        return CurrentSoftware;
    } 
    
    public static String getPage(){
        String Page=null;
        final Properties prop = new Properties();
        InputStream input = null;
        try {
        input = new FileInputStream(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
        prop.load(input);
        Page = prop.getProperty("Page");
        //System.out.println(langue);
        } catch (final IOException ex) {
        }   finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException e) {
                    }
                }
            }
        return Page;
    } 
    
    
    
    public static void setCurrentSoftware(String CurrentSoftware){
        final Properties prop = new Properties();
        OutputStream output = null;
        
        try {
        output = new FileOutputStream(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
                        
        prop.setProperty("CurrentSoftware", CurrentSoftware);

        prop.store(output, null);
        
        } catch (final IOException ex) {
        }finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                }
            }
        }
    }}

