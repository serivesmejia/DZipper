/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.serivesmejia.DZipper;

import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class Main {
    
    public static final Logger logger = Logger.getLogger("DZip");
    public static DZipper dZ;
    
    
    public static void main(String[] args) {       
        logger.info("Creating DZipper object...");
        dZ = new DZipper(args, logger);
    }
    
    
}
