package com.core.program.javaBean;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by sky on 2017/4/11.
 */
public class ImageViewerBean extends JLabel{
    private File file = null;
    private static final int XPREFSIZE = 200;
    private static final int YPREFSIZE = 200;

    public ImageViewerBean(){
        setBorder(BorderFactory.createEtchedBorder());
    }



}
