/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctlpackaging;
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
        File fichier = new File(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");
        Path path = Paths.get(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");
        
        if (fichier.createNewFile()){
            System.out.println("Le fichier a été créé");
            try {
            String str = "#####################CONFIG DocFinder CTL#####################\n\n" +
                         "ligne.production=31\n" +
                         "version=1.0.0.2\n" +
                         "langue=FR_fr\n\n" +
                         "#####################CONFIG DocFinder CTL#####################";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            //System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (IOException e) {}
        }else{
            System.out.println("Fichier déja crée");
        }
        
        
        
    } public static String getPropertiesLigne(){
        final Properties prop = new Properties();
        InputStream input = null;
        String ChoixLigne=null;
        try {
        input = new FileInputStream(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");

	// load a properties file
        prop.load(input);

        ChoixLigne = prop.getProperty("ligne.production");

        //System.out.println(ChoixLigne);
        
        } catch (final IOException ex) {
        }   finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException e) {
                    }
                }
            }
        return ChoixLigne;
    }public static String getPropertiesVersion(){
        final Properties prop = new Properties();
        InputStream input = null;
        String Version=null;
        try {
        input = new FileInputStream(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");

	// load a properties file
        prop.load(input);
        Version = prop.getProperty("version");

        //System.out.println(Version);
        
        } catch (final IOException ex) {
        }   finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException e) {
                    }
                }
            }
        return Version;
    }public static String getPropertieslangue(){
        String langue=null;
        final Properties prop = new Properties();
        InputStream input = null;
        try {
        input = new FileInputStream(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");
        prop.load(input);
        langue = prop.getProperty("langue");
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
        return langue;
    } public static void setProperties(String Ligne,String Version,String Langue){
        final Properties prop = new Properties();
        OutputStream output = null;
        
        try {
        output = new FileOutputStream(System.getenv("APPDATA")+"\\DocFinder\\docfinder.properties");
                        
        prop.setProperty("ligne.production", Ligne);
        prop.setProperty("version", Version);
        prop.setProperty("langue", Langue);

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
    }    
    public static void setCurrentSoftware(String CurrentSoftware, String Page){
        final Properties prop = new Properties();
        OutputStream output = null;
        
        try {
        output = new FileOutputStream(System.getenv("APPDATA")+"\\DocFinder\\lunch.properties");
                        
        prop.setProperty("CurrentSoftware", CurrentSoftware);
        prop.setProperty("Page", Page);
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
    }
}

