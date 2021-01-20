/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docfinder;

import java.awt.Desktop;
import java.io.File;
//Cross platform solution to view a PDF file
public class OpenFile {

    public static void main(String[]args) {

      try {

        File pdfFile = new File("D:\\Documents\\Workspace NETBEANS\\DFtech\\dist\\DFtech.jar");
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
}
