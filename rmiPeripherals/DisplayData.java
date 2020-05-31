package rmiPeripherals;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JList;
import rmiPeripherals.IPClass;

public class DisplayData {
	
	public static void show(Hashtable <Integer, Integer> table, ArrayList<String> list) {
		
		ArrayList<String> result = new ArrayList<String>();

		for (String qString : list) {
			result.add(qString +" - " + table.get(list.indexOf(qString)));
		}
		
		
		String[] array = result.toArray(new String[result.size()+1]);
		
		JFrame frame = new JFrame("Results for user: " + IPClass.GetIP("http://ip-api.com/json/?fields=61439"));
		frame.setSize(450,250);
		
		
		JList<String> list1 = new JList<String>(array);
		list1.setFont(new Font("Arial",Font.BOLD,14));
		
		frame.add(list1);
		
		

		frame.getContentPane().add(list1, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
		
		
	}
	
	
	

}
