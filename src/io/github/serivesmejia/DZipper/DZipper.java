package io.github.serivesmejia.DZipper;

import io.github.serivesmejia.DZipper.Frame.MainFrame;
import io.github.serivesmejia.DZipper.Frame.OLD_MainFrame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class DZipper {
   
    Logger logger;
    MainFrame mainf;
    
    public DZipper(String[] args, Logger logger1) {
        logger = logger1;
        
        String appdata = System.getenv("APPDATA");
        
        File tmp1 = new File(appdata + "\\DZipper\\tmp");
        
        if(tmp1.exists()){
            logger.info("Deleting old tmp files...");
            exploreDir4Delete(tmp1);
            
        }
        
        logger.info("Starting main frame...");
        mainf = new MainFrame("DZipper - No file opened", logger1, this);
        mainf.setVisible(true);     
        
    }
    
    public void exploreDir4Delete(File f){
        
        
        if(f.isDirectory()){
            for(File f1 : f.listFiles()){
                if(f1.isDirectory()){
                    exploreDir4Delete(f1);
                }else{
                    try {
                        Files.delete(f1.toPath());
                    } catch (IOException ex) {
                        Logger.getLogger(DZipper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            File f12 = new File(f + "_DEL");
            f.renameTo(f12);
        }else{
            return;
        }
    }
    
}
