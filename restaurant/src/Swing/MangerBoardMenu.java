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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTabbedPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import backend.entities.Check;
import backend.entities.Dish;
import backend.entities.Order;
import backend.entities.WaiterHelp;
import backend.servlet.CheckServlet;
import backend.servlet.DishServlet;
import backend.servlet.WaiterHelpServlet;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;

public class MangerBoardMenu {

	private  JFrame frame;//= new JFrame();
	private JTable tableMenu;
	private JTable tableWaiter;
	private JTable tableCheck;
	private static JLayeredPane layeredPane;
	public static JPanel[] allJPanels;
	  ArrayList<WaiterHelp> allWaiterHelp;
	 private  Button buttonHelp;//= new Button();
	  private ArrayList<Dish> allDishes;
		int selectRow;
		int selectCoulmn;
		ArrayList<Check> allChecks;
		JCheckBox chckbxAvailable ;
	 
	 
	 private static MangerBoardMenu mangerBoardMenu;//= new MangerBoardMenu();
	 private JTextField textFieldName;
	 private JTextField textFieldInfo;
	 private JTextField textFieldPrice;
	 private JTextField textFieldCategory;
	 private JTextField textFieldImagePath;

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
	
		 
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setEnabled(false);
		frame.getContentPane().add(verticalBox, BorderLayout.EAST);
		frame.setJMenuBar( new Menu().getJMenuBar());
		
		Button buttonMenu = new Button("Menu");

		verticalBox.add(buttonMenu);
 	    WaiterHelpServlet servlet= new WaiterHelpServlet();
 	  
	  allWaiterHelp= (ArrayList) servlet.getAllWaiterHelpData();
	  buttonHelp= new Button("help (+"+allWaiterHelp.size()+")");

	  
		verticalBox.add(buttonHelp);
		
		Button buttonChat = new Button("chat");

		verticalBox.add(buttonChat);
		
		Button buttonCheck = new Button("Checks +("+allChecks.size()+")");
		

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
		panel.setBounds(0, 0, 618, 55);
		layeredPane.add(panel);
		
		JLabel lblManagerboard = new JLabel("ManagerBoard");
		lblManagerboard.setFont(new Font("Verdana", Font.ITALIC, 23));
		lblManagerboard.setIcon(new ImageIcon(MangerBoardMenu.class.getResource("/com/sun/java/swing/plaf/motif/icons/image-failed.png")));
		panel.add(lblManagerboard);
		
		JPanel panelCheck = new JPanel();
		
		
		layeredPane.setLayer(panelCheck, 2);
		panelCheck.setBounds(0, 53, 618, 340);
		layeredPane.add(panelCheck);
		panelCheck.setLayout(null);
		
	
	
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 31, 618, 256);
		panelCheck.add(scrollPane_3);
		

		  
		  tableCheck = new JTable(createModelForTableCheck())
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
		              return String.class;//dishes string
		          case 4:
		              return Double.class;//price 
		          default:
		              return Boolean.class;
		      }
		  }
			};
		scrollPane_3.setViewportView(tableCheck);
		tableCheck.setBackground(Color.CYAN);
		layeredPane.setLayer(tableCheck, 0);
		setValueOfCellsInMiddle(tableCheck);
		JButton deleteCheckButton = new JButton("Delete check");
		deleteCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateObjectsCheck(allChecks,tableCheck,5  );
				tableCheck.setModel(createModelForTableCheck());
				
			}
		});
		deleteCheckButton.setBounds(260, 300, 125, 25);
		panelCheck.add(deleteCheckButton);
		
		JLabel lblNewLabel_1 = new JLabel("Checks");
		lblNewLabel_1.setIcon(new ImageIcon(MangerBoardMenu.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(280, 0, 105, 16);
		panelCheck.add(lblNewLabel_1);
//		tableCheck.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Check", "New column", "New column", "New column", "New column"
//			}
//		));
		
		JPanel panelMenu = new JPanel();
		
		layeredPane.setLayer(panelMenu, 0);
		panelMenu.setBounds(0, 53, 618, 340);
		layeredPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 34, 618, 254);
		panelMenu.add(scrollPane_2);
		
	    model.addColumn("Table Number");
        model.addColumn("time");
        model.addColumn("still vaild");

	    for(WaiterHelp waiterHelp: allWaiterHelp)
	    {
		   model.addRow(new Object[]{waiterHelp.getTableNumber(), waiterHelp.getTime(), false });   
	    }
		
	  
	

		tableMenu = new JTable( createModuleForTableMenu())
		{
		    private static final long serialVersionUID = 1L;

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class; //index
            case 1:
                return String.class;//name
            case 2:
                return String.class;//category
            case 3:
                return String.class;//info
            case 4:
                return Double.class;//price
            case 5:
                return String.class;//Image path
            default:
                return Boolean.class; //Available
        }
    }
    
		};
		setValueOfCellsInMiddle(tableMenu);
//		tableMenu.addPropertyChangeListener(new PropertyChangeListener() {
//			
//			
//			   @Override
//			    public void propertyChange(PropertyChangeEvent e)
//			    {
//			        //  A cell has started/stopped editing
//
//			        if ("tableCellEditor".equals(e.getPropertyName()))
//			        {
//			            if (tableMenu.isEditing())
//			            {
//			            	System.out.println(tableMenu.getEditingRow());
//			            
//			            }
//	
//			        }
//			
//		}});

		tableMenu.setDefaultEditor(String.class, new DefaultCellEditor(new JTextField()){
			
		     @Override
		     public Component getTableCellEditorComponent(JTable table,
		              Object value, boolean isSelected, int row, int column) {
		        // code on line below is redundant but would be needed if need to see
		        // other property of the value object than toString()
		        String valueStr = (value == null) ? "null" : value.toString();
		        System.out.printf("[%d, %d]: %s%n", row, column, valueStr);
		        selectRow=row;
		      
		        selectCoulmn=column;
		        return super.getTableCellEditorComponent(table, value, isSelected, selectRow, selectCoulmn);
		     }

		 

			@Override
		     public Object getCellEditorValue() {
		        System.out.printf("cell editor value: %s%n", super.getCellEditorValue());
		        updateDish(selectRow,selectCoulmn, super.getCellEditorValue().toString());
		        return super.getCellEditorValue();
		     }
		  });
		
	

			
	

		scrollPane_2.setViewportView(tableMenu);
		tableMenu.setForeground(Color.BLACK);
		tableMenu.setBackground(Color.WHITE);
		//tableMenu.setEnabled(false);
		layeredPane.setLayer(tableMenu, 0);
		
		JButton btnSaveMenu = new JButton("save menu");

		btnSaveMenu.setBounds(260, 301, 125, 25);
		panelMenu.add(btnSaveMenu);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setIcon(new ImageIcon(MangerBoardMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(271, 0, 114, 16);
		panelMenu.add(lblNewLabel_2);
		
		JPanel panelHelpWaiter = new JPanel();
		
		layeredPane.setLayer(panelHelpWaiter, 0);
		//panel_2.setBounds(0, 0, 373, 0);
		panelHelpWaiter.setBounds(0, 53, 618, 340);
		layeredPane.add(panelHelpWaiter);
		panelHelpWaiter.setLayout(null);
	
		JScrollPane scrollPaneTableWaiter = new JScrollPane();
		scrollPaneTableWaiter.setBounds(0, 31, 618, 256);
		scrollPaneTableWaiter.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
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
		
		JButton buttonSaveHelpStatus = new JButton("save");
		buttonSaveHelpStatus.setBounds(260, 300, 125, 25);
		panelHelpWaiter.add(buttonSaveHelpStatus);
		
		JLabel lblNewLabel = new JLabel("Customer help");
		lblNewLabel.setIcon(new ImageIcon(MangerBoardMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel.setBounds(280, 0, 225, 18);
		panelHelpWaiter.add(lblNewLabel);
		
		JPanel createdishpanel = new JPanel();
		layeredPane.setLayer(createdishpanel, 0);
		createdishpanel.setBounds(0, 53, 618, 353);
		layeredPane.add(createdishpanel);
		createdishpanel.setLayout(null);
		 chckbxAvailable = new JCheckBox("Available");
		chckbxAvailable.setBounds(315, 99, 113, 25);
		createdishpanel.add(chckbxAvailable);
		
		JButton btnSaveDish = new JButton("Save");
		btnSaveDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dish dish = new Dish();
				dish.setAvailable(chckbxAvailable.isSelected());
				dish.setCategory(textFieldCategory.getText());
				dish.setImagePath(textFieldImagePath.getText());
				dish.setName(textFieldName.getText());
				dish.setInfo(textFieldInfo.getText());
				dish.setPrice(Double.parseDouble(textFieldPrice.getText()));
				DishServlet.saveDish(dish);
			}
		});
		btnSaveDish.setBounds(260, 300, 125, 25);
		createdishpanel.add(btnSaveDish);
		
		JLabel lblAdsa = new JLabel("Create Dish");
		lblAdsa.setBounds(252, 13, 116, 16);
		createdishpanel.add(lblAdsa);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(149, 61, 116, 22);
		createdishpanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(49, 64, 56, 16);
		createdishpanel.add(lblName);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(49, 103, 56, 16);
		createdishpanel.add(lblInfo);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setColumns(10);
		textFieldInfo.setBounds(149, 100, 116, 22);
		createdishpanel.add(textFieldInfo);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(149, 137, 116, 22);
		createdishpanel.add(textFieldPrice);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(49, 140, 56, 16);
		createdishpanel.add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(49, 174, 56, 16);
		createdishpanel.add(lblCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(149, 172, 116, 22);
		createdishpanel.add(textFieldCategory);
		
		textFieldImagePath = new JTextField();
		textFieldImagePath.setColumns(10);
		textFieldImagePath.setBounds(417, 61, 116, 22);
		createdishpanel.add(textFieldImagePath);
		
		JLabel lblImagePath = new JLabel("Image path:");
		lblImagePath.setBounds(315, 64, 90, 16);
		createdishpanel.add(lblImagePath);
		

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
		
		btnSaveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateCheckBox();
				updatePrices();
				DishServlet.updateAllDishes(allDishes);
			}

			private void updateMenu(ArrayList<Dish> allDishes) {
//				JTable.getEditingRow();
//				JTable.getEditingColumn();
	
				
			//	System.out.println(tableMenu.getEditingRow());
		//		System.out.println(tableMenu.getEditingColumn());
//				for(Dish dish:allDishes)
//				{
//					
//				}
				
			}
		});
		
		/*
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tableWaiter.setDefaultRenderer(String.class, centerRenderer);
		*/
		
		allJPanels = new JPanel[] {panelCheck,panelMenu,panelHelpWaiter, createdishpanel };
			buttonCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPanel(allJPanels[0]);
					
				}
			});
			
			buttonChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("buttonChat was clicked");
				//	showPanel();
					
				}
			});
			
		
			buttonHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPanel(allJPanels[2]);
				}
			});
			buttonMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showPanel(allJPanels[1]);
					System.out.println("buttonMenu was clicked");
				}
			});
			
		
		
		
		
	//	setJTablesButtonActionListener();

		
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
	

	

	private DefaultTableModel createModelForTableCheck() {
		DefaultTableModel modelForTableCheck = new DefaultTableModel()
		  {
	  @Override
	  public boolean isCellEditable(int row, int col) {
		  return col==5;
		  }
		  };
		  modelForTableCheck.addColumn("index");
		  modelForTableCheck.addColumn("TableNumber");
		  modelForTableCheck.addColumn("Time of request check");
		  modelForTableCheck.addColumn("Dishes");
		  modelForTableCheck.addColumn("Price");
		  modelForTableCheck.addColumn("Served check");
		  
	     allChecks= (ArrayList)CheckServlet.getAllChecks();
		int count=1;
		for(Check check: allChecks)
		{
			
			Order order= DishServlet.getOrderById(check.getidorder());
			modelForTableCheck.addRow(new Object[]{count, order.getTableNumber(),check.getTime(), order.getOrderDishes(),
					  order.getPrice() , false });  
			count++;
		}
		
		return modelForTableCheck;
		
	}

	protected void updatePrices() {
		int count=0;
		for(Dish dish: allDishes)
		{
			System.out.println("tableMenu.getValueAt(4, count): "+tableMenu.getValueAt(count, 4));
			dish.setPrice(Double.valueOf(tableMenu.getValueAt(count,4 ).toString()));
			count++;
			
		}
		
	}

	protected void updateCheckBox( ) {
		int count=0;
		for(Dish dish:allDishes)
		{
			dish.setAvailable(checkIfValuesChanged(tableMenu, 6,count));
			count++;
		}
		
	}

	protected void updateDish(int row, int column, String newVaule) {
		System.out.println("inside update dish"+column+" row: "+row);
        switch (column) {

        case 1:
        	  allDishes.get(row).setName(newVaule);
        	  System.out.println(allDishes.get(row).getName());
            return ;//name
        case 2:
        	  allDishes.get(row).setCategory(newVaule);
        	  System.out.println(allDishes.get(row).getCategory());
        	  return ;//category
        case 3:
        	  allDishes.get(row).setInfo(newVaule);
          	  System.out.println(allDishes.get(row).getInfo());
        	  return;//info
        case 4:
        //	 allDishes.get(row).setPrice(Double.parseDouble(newVaule));
            return;//price
        case 5:
        	  allDishes.get(row).setImagePath(newVaule);
            return ;//Image path
        case 6:
        //	allDishes.get(row).setAvailable(Boolean.valueOf(newVaule));
            return; //Available
        }
		
	}

	private DefaultTableModel createModuleForTableMenu() {
		
		  DefaultTableModel modelForTableMenu = new DefaultTableModel()
		  {
	  @Override
	  public boolean isCellEditable(int row, int col) {
		  
		  if (col==0)
			  return false;
		  else
			  return true;
		
		  }
	  
//	  @Override
//	  public void newDataAvailable(TableModelEvent event)
//	  {
//		  System.out.println(event.getType());
//	  }
	  
//	  @Override
//	  public void fireTableRowsUpdated(int firstRow, int lastRow)
//	  {
//		  System.out.println("update. firstRow: "+firstRow+ " lastRow: "+lastRow );
//	  }
	 
		  };
		
		  modelForTableMenu.addColumn("index");
		  modelForTableMenu.addColumn("Name");
		  modelForTableMenu.addColumn("Category");
		  modelForTableMenu.addColumn("info");
		  modelForTableMenu.addColumn("Price");
		  
		  modelForTableMenu.addColumn("Image path");
		  modelForTableMenu.addColumn("Available");
		  
			allDishes= (ArrayList)DishServlet.getAllDishes();
		  int count=1;
		for(Dish dish: allDishes)
		{
			modelForTableMenu.addRow(new Object[]{count,dish.getName(), "category",dish.getInfo(),
						dish.getPrice(), dish.getImagePath(),dish.isAvailable() }); 
			count++;
		}
		
		
		
		return modelForTableMenu;
	}

	public static void showPanel( JPanel panel )
	{

		
		
		for (int i = 0; i < allJPanels.length; i++) {
			
			if(panel==allJPanels[i])
			{
				layeredPane.setLayer(allJPanels[i], 2);
				
			}
			else
			{
				layeredPane.setLayer(allJPanels[i], 0);
			}
		}
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
	
	private void updateObjects(List<WaiterHelp> allObjects) {

	//	if(allObjects instanceof WaiterHelp)
	//	{
		//	List<WaiterHelp> allWaiterHelp = (List<WaiterHelp>) ((List<?>)allObjects);
			int index=0;
			for (WaiterHelp waiterHelp: allWaiterHelp )
			{
				
				if(checkIfValuesChanged(tableWaiter, 2, index))
				{
					WaiterHelpServlet.deleteWaiterHelp(waiterHelp);
				}
					
				index++;
			}
	}
			private void updateObjectsCheck(List<Check> allObjects, JTable table, int coulmnToCheck)
			{

				//	if(allObjects instanceof WaiterHelp)
				//	{
					//	List<WaiterHelp> allWaiterHelp = (List<WaiterHelp>) ((List<?>)allObjects);
						int index=0;
						for (Check object: allObjects )
						{
							
							if(checkIfValuesChanged(table, coulmnToCheck, index))
							{
								CheckServlet.deleteCheck(object);
							}
							
								
							index++;
						}
	//	}
		
		
	}
	private boolean checkIfValuesChanged(JTable table, int coulmn, int indexOfOjbect)
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

	public static JPanel[] getAllJPanels() {
		return allJPanels;
	}
}
