package Swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
	//create dish
	//create category
	
	private static JMenuBar jMenuBar;
	private JMenu menuCreate;
	
	public Menu()
	{
		jMenuBar= new JMenuBar();
		menuCreate= new JMenu("Create");
		createJMenuITem(menuCreate, "Create dish", "Create Table number");
		handleActionLisener();
		
		
	}

	private void createJMenuITem(JMenu menu, String ... args) {
		
		for(String string:args )
		{
			JMenuItem  jMenuItem= new JMenuItem(string);
			menu.add(jMenuItem);
			
		}
		jMenuBar.add(menu);
	}
	private void handleActionLisener() {
		for(int  i=0; i<menuCreate.getItemCount(); i++)
		{
		menuCreate.getItem(i).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("Create dish"))
				{
				//	MangerBoardMenu.showPanel(MangerBoardMenu.allJPanels[3]);
					MangerBoardMenu.showPanel(MangerBoardMenu.getAllJPanels()[3]);
					System.out.println("createddish was presses");
				}
				else if(e.getActionCommand().equals("Create Table number"))
				{
					MangerBoardMenu.showPanel(MangerBoardMenu.getAllJPanels()[4]);
					System.out.println("Create Table number was presses");
				}
				
			}
		});
		}

		
	}
	public static JMenuBar getJMenuBar()
	{
		return jMenuBar;
	}

}
