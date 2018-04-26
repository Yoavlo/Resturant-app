package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import backend.entities.Check;
import backend.entities.WaiterHelp;
import backend.servlet.CheckServlet;
import backend.servlet.WaiterHelpServlet;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;

public class MangerBoardMenu {

	private  JFrame frame;//= new JFrame();
	private JTable tableMenu;
	private JTable tableWaiter;
	private JTable tableCheck;
	JLayeredPane layeredPane;
	private JTable[] allTables;
	  ArrayList<WaiterHelp> allWaiterHelp;
	 private  Button buttonHelp;//= new Button();
	 
	 
	 private static MangerBoardMenu mangerBoardMenu;//= new MangerBoardMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangerBoardMenu window = new MangerBoardMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//public MangerBoardMenu() {
	private   MangerBoardMenu() {
		initialize();
	}
	
	public static MangerBoardMenu getInstance()
	{
		if(mangerBoardMenu==null)
		{
			mangerBoardMenu=new MangerBoardMenu();
		}
		return mangerBoardMenu;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		System.out.println("inside MangerBoardMenu intialize");
		// System.out.println("buttonHelp:"+buttonHelp.hashCode());
		 
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setEnabled(false);
		frame.getContentPane().add(verticalBox, BorderLayout.EAST);
		
		Button buttonMenu = new Button("Menu");

		verticalBox.add(buttonMenu);
 	    WaiterHelpServlet servlet= new WaiterHelpServlet();
 	  
	  allWaiterHelp= (ArrayList) servlet.getAllWaiterHelpData();
	  buttonHelp= new Button("help (+"+allWaiterHelp.size()+")");
	  System.out.println("buttonHelp:"+buttonHelp.hashCode());
	  System.out.println("buttonHelp getButtonHelp(): "+getButtonHelp().hashCode());
//	  setTextforButtonHelp("1");
//	  getButtonHelp();
	 // setTextforButtonHelp("2");
		//buttonHelp.setLabel("Help (+"+allWaiterHelp.size()+")"); //= new Button("Help (+"+allWaiterHelp.size()+")");
	  
		verticalBox.add(buttonHelp);
		
		Button buttonChat = new Button("chat");

		verticalBox.add(buttonChat);
		
		Button buttonCheck = new Button("Check");

		verticalBox.add(buttonCheck);
		
		 layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.YELLOW);
		layeredPane.setToolTipText("sfsd");
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		  DefaultTableModel model = new DefaultTableModel()
				  {
			  @Override
			  public boolean isCellEditable(int row, int col) {
				  return col==2;
				  }
				  };


		
		JPanel panel = new JPanel();
		layeredPane.setLayer(panel, 0);
		panel.setBounds(0, 0, 381, 55);
		layeredPane.add(panel);
		
		JLabel lblManagerboard = new JLabel("ManagerBoard");
		lblManagerboard.setFont(new Font("Verdana", Font.ITALIC, 23));
		lblManagerboard.setIcon(new ImageIcon(MangerBoardMenu.class.getResource("/com/sun/java/swing/plaf/motif/icons/image-failed.png")));
		panel.add(lblManagerboard);
		
		JPanel panelCheck = new JPanel();
		layeredPane.setLayer(panelCheck, 2);
		panelCheck.setBounds(0, 53, 367, 200);
		layeredPane.add(panelCheck);
		panelCheck.setLayout(null);
		
		JButton deleteCheck = new JButton("Delete check");
		deleteCheck.setBounds(123, 161, 126, 26);
		panelCheck.add(deleteCheck);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 39, 373, 148);
		panelCheck.add(scrollPane_3);
		
		//tableCheck = new JTable();
		  DefaultTableModel modelForTableCheck = new DefaultTableModel()
		  {
	  @Override
	  public boolean isCellEditable(int row, int col) {
		  return col==4;
		  }
		  };
		  modelForTableCheck.addColumn("TableNumber");
		  modelForTableCheck.addColumn("Order id");
		  modelForTableCheck.addColumn("Time of request check");
		  modelForTableCheck.addColumn("Price");
		  modelForTableCheck.addColumn("Served check");
		  
//		ArrayList<Check> allChecks= (ArrayList)CheckServlet.getAllChecks();
//		for(Check check: allChecks)
//		{
//			  model.addRow(new Object[]{check.getOrder().getTableNumber(), check.getOrder().getIdOrder(),
//					  check.getTime(), check.getOrder().getPrince() , false });   
//		}
		  
		  
		  tableCheck = new JTable(modelForTableCheck)
			{
		    private static final long serialVersionUID = 1L;

		  /*@Override
		  public Class getColumnClass(int column) {
		  return getValueAt(0, column).getClass();
		  }*/
		  @Override
		  public Class getColumnClass(int column) {
		      switch (column) {
		          case 0:
		              return Integer.class;//tablenumber
		          case 1:
		              return Integer.class;//order id
		          case 2:
		              return String.class;//time 
		          case 3:
		              return Float.class;//price
		          default:
		              return Boolean.class;
		      }
		  }
			};
		scrollPane_3.setViewportView(tableCheck);
		tableCheck.setBackground(Color.BLUE);
		layeredPane.setLayer(tableCheck, 0);
//		tableCheck.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Check", "New column", "New column", "New column", "New column"
//			}
//		));
		
		JPanel panelMenu = new JPanel();
		layeredPane.setLayer(panelMenu, 0);
		panelMenu.setBounds(0, 53, 367, 200);
		layeredPane.add(panelMenu);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelMenu.add(scrollPane_2);
		
	    model.addColumn("Table Number");
        model.addColumn("time");
        model.addColumn("still vaild");

	    for(WaiterHelp waiterHelp: allWaiterHelp)
	    {
		   model.addRow(new Object[]{waiterHelp.getTableNumber(), waiterHelp.getTime(), false });   
	    }
		
		tableMenu = new JTable();
		scrollPane_2.setViewportView(tableMenu);
		tableMenu.setForeground(Color.BLACK);
		tableMenu.setBackground(Color.WHITE);
		//tableMenu.setEnabled(false);
		tableMenu.setModel(new DefaultTableModel(
			new Object[][] {
				{"menu", null, null, null},
				{"menu", null, null, null},
				{"menu", null, null, null},
				{"menu", null, null, null},
				{"menu", null, "menu", null},
			},
			new String[] {
				"menu", "New column", "New column", "New column"
			}
		));
		layeredPane.setLayer(tableMenu, 0);
		
		JPanel panelHelpWaiter = new JPanel();
		layeredPane.setLayer(panelHelpWaiter, 0);
		//panel_2.setBounds(0, 0, 373, 0);
		panelHelpWaiter.setBounds(0, 53, 367, 200);
		layeredPane.add(panelHelpWaiter);
		
		JButton buttonSaveHelpStatus = new JButton("save help status");
		panelHelpWaiter.add(buttonSaveHelpStatus);
		
		JScrollPane scrollPaneTableWaiter = new JScrollPane();
	
		panelHelpWaiter.add(scrollPaneTableWaiter);
		layeredPane.setLayer(scrollPaneTableWaiter, 2);
		
		tableWaiter = new JTable(model)
				{
			    private static final long serialVersionUID = 1L;

        /*@Override
        public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
        }*/
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                default:
                    return Boolean.class;
            }
        }
        
    };
		scrollPaneTableWaiter.setViewportView(tableWaiter);
		tableWaiter.setBackground(Color.GREEN);
		layeredPane.setLayer(tableWaiter, 2);
		tableWaiter.setEnabled(true);
		setValueOfCellsInMiddle(tableWaiter);
		
		/*
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tableWaiter.setDefaultRenderer(String.class, centerRenderer);
		*/
		buttonSaveHelpStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//checkWhatValuesAreTrue(tableWaiter, 2);
				//List<Object> objects= new ArrayList<Object>(allWaiterHelp);
				//objects.addAll(allWaiterHelp);
				updateObjects(allWaiterHelp);
			//	updateObjects(allWaiterHelp);
				//saveObjectsInDB();
			}

	 


		});
		
	//	setJTablesButtonActionListener();
		buttonCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable(layeredPane,tableCheck);
				
			}
		});
		
		buttonChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	
		buttonHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	showTable(layeredPane,tableWaiter);
				buttonHelp.setLabel("bla");
			}
		});
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTable(layeredPane,tableMenu);
				System.out.println("buttonMenu was clicked");
			}
		});
		
//		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGap(0, 432, Short.MAX_VALUE)
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGap(0, 253, Short.MAX_VALUE)
//		);
//		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void showTable(JLayeredPane panel, JTable showTable )
	{
//		for (int i = 0; i < allTables.length; i++) {
//			
//			if(allTables[i]==showTable)
//			{
//				panel.setLayer(allTables[i], 2);
//				
//			}
//			else
//			{
//				panel.setLayer(allTables[i], 0);
//			}
//		}
	}
	
	
	private void setValueOfCellsInMiddle(JTable jtable)
	{
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		jtable.setDefaultRenderer(String.class, centerRenderer);
		
	}
	
//	private HashMap<Integer, Boolean>  checkWhatValuesAreTrue(JTable table, int coulmn) {
//		 HashMap<Integer, Boolean>cellsTrue= new HashMap<>();
//		for(int i=0; i<table.getModel().getRowCount();i++)
//		{
//			if(Boolean.TRUE.equals(tableWaiter.getModel().getValueAt(i, coulmn)))
//			{
//				cellsTrue.put(i, true);
//				System.out.println("i: "+i+" coulmn "+coulmn+" is true");
//			}
//		}
//		return cellsTrue;
//		
//	}
	
	private void updateObjects(List<WaiterHelp> allObjects ) {

	//	if(allObjects instanceof WaiterHelp)
	//	{
		//	List<WaiterHelp> allWaiterHelp = (List<WaiterHelp>) ((List<?>)allObjects);
			int index=0;
			for (WaiterHelp waiterHelp: allWaiterHelp )
			{
				
				if(checkIfValuesChanged(tableWaiter, 2, waiterHelp, index))
				{
					WaiterHelpServlet.deleteWaiterHelp(waiterHelp);
				}
					
				index++;
			}
	//	}
		
		
	}
	private boolean checkIfValuesChanged(JTable table, int coulmn,WaiterHelp waiterHelp, int indexOfOjbect)
	{
		if(Boolean.TRUE.equals(table.getModel().getValueAt(indexOfOjbect, coulmn)))
		{
			
		return true;
		}
		return false;
	}

	public  Button getButtonHelp() {
		return buttonHelp;
	}
//	
	public static void setTextforButtonHelp(String text)
	{
	//	 System.out.println("buttonHelp:"+buttonHelp.hashCode());
		////System.out.println("inside setTextforButtonHelp");
		
	//	System.out.println("buttonHelp before" +buttonHelp.getLabel());
		//buttonHelp.setLabel(text);
	//	System.out.println("buttonHelp after" +buttonHelp.getLabel());
//		frame.getContentPane().validate();
//		frame.getContentPane().repaint();
	
	}
	public JFrame getFrame()
	{
		return frame;
	}
}
