/******************************************************************************
 * File: xmlFilter.java                                                       *
 ******************************************************************************/
package weatherstation;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/*=====================================================================
 Class: xmlFilter

 Extends/Implements: FileFilter

 Description: 
    This class extends FileFilter and sets the type of file to display
in the FileChooser content pane as well as the string for the
"FileDescription:" combo box.
======================================================================*/
public class xmlFilter extends FileFilter {
    
    /*==========================================================================
        Function: public boolean accept()
    
        Description: 
            This function sets only directories or files with the .xml extension
        to display in the FileChooser dialog.
    
        Parameters: File file - File type (In this case .xml
    
        Returns: 
            Result of boolean statement - True if currently in a directory or 
        file ends with ".xml".
    ==========================================================================*/
    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with ".txt" extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".xml");
    }
    
    /*==========================================================================
    Function: public String getDescription()

    Description: 
        This function sets the string to display in the "File Description:" 
    combo box in the FileChooser dialog.

    Parameters: None
    
    Returns: String desc - Text to display in above mentioned combo box.
    ==========================================================================*/
    @Override
    public String getDescription() {
        //The string to display in File Description combo box
        String desc = "XML documents (*.xml)";
        return desc;
    }
}
