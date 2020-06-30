package jyameogo;

import javax.swing.JFileChooser;
import java.io.File;
import java.text.SimpleDateFormat;

public class Main {
    
    public static void main(String[] args) {
	JFileChooser chooser=new JFileChooser();
	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	int ret=chooser.showOpenDialog(null);
	if(ret == JFileChooser.APPROVE_OPTION) {
	   File selectedFile = chooser.getSelectedFile();
	   System.out.println(FileToString(selectedFile,"",true));
	}
    }
    
    public static String FileToString(File file, String space, boolean last) {
	SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	String ret;
	if(file.isDirectory())
	    ret=(last?"└──":"├──")+file.getName()+"/";
	else 
	    ret=(last?"└──":"├──")+file.getName()+" - "+sdf.format(file.lastModified())+" - "+file.length()+" Byte";
	File[] files=file.listFiles();
	if(files!=null)
	    for(int i=0;i<files.length;i++)
		ret+="\n    "+space+FileToString(files[i], space+(i==files.length-1?"    ":"│    "),i==files.length-1);
	return ret;
    }
}
