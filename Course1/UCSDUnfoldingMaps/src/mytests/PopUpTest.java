package mytests;

import static javax.swing.JOptionPane.*;

import processing.core.PApplet;
import processing.data.StringList;

public class PopUpTest extends PApplet{
	 
	final StringList ids = new StringList( new String[] {
	  "Eric", "Beth", "Katniss"
	} 
	);
	 
	public void draw() {
	  System.out.println(ids.toString());
	  showMessageDialog(null, "Teste", "Title", INFORMATION_MESSAGE);
	  final String id = showInputDialog("Please enter new ID");
	 
	  if (id == null)   exit();
	 
	  else if ("".equals(id))
	    showMessageDialog(null, "Empty ID Input!!!", 
	    "Alert", ERROR_MESSAGE);
	 
	  else if (ids.hasValue(id))
	    showMessageDialog(null, "ID \"" + id + "\" exists already!!!", 
	    "Alert", ERROR_MESSAGE);
	 
	  else {
	    showMessageDialog(null, "ID \"" + id + "\" successfully added!!!", 
	    "Info", INFORMATION_MESSAGE);
	 
	    ids.append(id);
	  }
	}
}
