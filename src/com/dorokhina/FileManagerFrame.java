package com.dorokhina;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileManagerFrame extends JFrame {
	//JPanel panel = null;
	JPanel panel1 = null;
	JPanel lowPanel = null;
	//JPanel panel3 = null;
	File file;
	
	FileManagerFrame(File file) {
		this.file = file;			
		panel1 = getPanel1(file);
		add(panel1, BorderLayout.PAGE_START);
		lowPanel = new JPanel();
		lowPanel.setLayout(new GridLayout(1, 2, 1, 1));
		lowPanel.add(getPanel2(file, null), BorderLayout.EAST);
		lowPanel.add(getPanel3(file), BorderLayout.WEST);
		add(lowPanel);
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JPanel getPanel1(File file) {				
		JPanel panel1 = new JPanel();
		panel1.setSize(800, 200);
		JLabel path = new JLabel("Path: " + file.getPath());
		panel1.add(path);
		return panel1;
	}
	
	public JScrollPane getPanel2(File file, File selected) {				
		JPanel panel2 = new JPanel();
		panel2.setSize(400, 600);
		JScrollPane scrollPane = new JScrollPane(panel2);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JLabel back = new JLabel(" .. ");
		panel2.add(back);
		back.addMouseListener(new MouseAdapter() {  			
		    public void mouseClicked(MouseEvent e) {  
		    	if(file.getParentFile() != null) {
		    		repaint(file.getParentFile(), null);
		    	}
		    			       		  
		    }  
		}); 
		
		File[] files = file.listFiles();
		Comparator<File> fileComparator = ((a1, a2) -> (a1.isDirectory() && a2.isFile())? -1 : (a1.isFile() && a2.isDirectory())? 1 : a1.compareTo(a2));
		Arrays.sort(files,  fileComparator);
		panel2.setLayout(new GridLayout(files.length + 1, 1, 1, 1));
		for(File f: files) {
			JPanel p = new JPanel();
			p.add(new JLabel(f.getName()));
			p.addMouseListener(new MouseAdapter() {  			
			    public void mouseClicked(MouseEvent e) {
			    	if (e.getButton() == MouseEvent.BUTTON1) {
			    		if (f.isDirectory()) {
			    			repaint(f, null);
			    		} else if (f.isFile()){
			    			repaint(file, f);
			    		}
			    	}
			    	if (e.getButton() == MouseEvent.BUTTON3){
			    		
			    		
			    		Path path = Paths.get("/Users/irinadorokhina/Documents");
			    		JPopupMenu popup = new JPopupMenu();
			    		JMenuItem menuDelete = new JMenuItem("delete");
			    		JMenuItem menuCopy = new JMenuItem("copy");
			    		JMenuItem menuMove = new JMenuItem("move");
			    		menuDelete.addActionListener(event -> {
			    			FileManagerUtils.deleteFile(f);
			    			repaint(file, null);
			    		});
			    		menuMove.addActionListener(event -> {
			    			
//			    			p.addMouseListener(new MouseAdapter() {  			
//			    			    public void mouseClicked(MouseEvent e) {
//			    			    	
//			    			    		
//			    			    	}
//			    			});
			    			FileManagerUtils.moveFile(f, path);
			    			repaint(file, f.getParentFile());
			    		});
			    		menuCopy.addActionListener(event -> {
			    			FileManagerUtils.copyFile(f, path);
			    			repaint(file, f.getParentFile());
			    		});
			    		popup.add(menuDelete);
			    		popup.add(menuCopy);
			    		popup.add(menuMove);
			            popup.show(FileManagerFrame.this, e.getX(), e.getY());
			           
			    		
			    		//menuCopy.
			    		//***************************************//
//			    		JMenuItem menu = new JMenuItem();   
//			    		add(menu);
			    	
			    		
			    		
			    		
			    		//***************************************//
		           }
			    	
			    }  
			}); 
			panel2.add(p);
		}

		return scrollPane;
	}
	
	
	public void saveFile(File file, String arrayLines) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(file.getAbsolutePath()));
			pw.println(arrayLines);
		} catch (IOException e ) {
		    e.printStackTrace();
		} finally {
			pw.close();
		}
		
	}
	
	public String readFile(File file) {
		BufferedReader in = null;		
		String arrayLines = "";
		try {
			in = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String temp = in.readLine();
			while(temp != null) {
				//arrayLines = arrayLines.concat(temp);
				arrayLines = arrayLines + temp + "\n";
				//arrayLines = arrayLines + temp ;
				System.out.println(arrayLines);
				temp = in.readLine();
			}
		} catch (IOException e ) {
			 e.printStackTrace();		
		} finally {
			try {
				in.close();
			} catch (IOException e ){
				 e.printStackTrace();
			}
		}
		return arrayLines;
	}
	

	
	public JPanel getPanel3(File selected) {				
		JPanel panel3 = new JPanel();
		panel3.setSize(400, 600);
		
		 if(selected == null) {
			panel3.add(new JLabel("folder"));
			System.out.println("Folder1");
		 } else if(selected.isDirectory()) {
			panel3.add(new JLabel("folder"));
			System.out.println("Folder2");
		} else if (selected.isFile()) {
			panel3.add(new JLabel("file"));
			if(selected.getName().contains(".png") || selected.getName().contains(".jpeg") || selected.getName().contains(".jpg")) {
				System.out.println(selected.getAbsolutePath());
				System.out.println("image");
				//ImageIcon img = new ImageIcon(file.getAbsolutePath());
				panel3.add(new JLabel(new ImageIcon(selected.getAbsolutePath())));
			
			} else if(selected.getName().contains(".txt") || selected.getName().contains(".doc")) {			
				System.out.println("file");
				JTextArea textArea = new JTextArea();
				panel3.add(textArea);
				textArea.setText(readFile(selected));
				JButton save = new JButton("SAVE");
				save.addMouseListener(new MouseAdapter() {  			
				    public void mouseClicked(MouseEvent e) {
				    	saveFile(selected, textArea.getText());
				    	repaint(selected.getParentFile(), selected);
				    }  
				}); 
				panel3.add(save);
			}
		}
		return panel3;
	}
	
	public void repaint(File file, File selected) {
//		if(file == null) {
//			file = new File("/Users/irinadorokhina/");
//		}
		panel1.setVisible(false);
		lowPanel.setVisible(false);
		//panel3.setVisible(false);
		//panel.setVisible(false);						
		panel1 = getPanel1(file);
		add(panel1, BorderLayout.PAGE_START);
		lowPanel = new JPanel();
		lowPanel.setLayout(new GridLayout(1, 2, 1, 1));
		lowPanel.add(getPanel2(file, selected), BorderLayout.EAST);
		lowPanel.add(getPanel3(selected), BorderLayout.WEST);
		add(lowPanel);
		
		panel1.repaint();
		lowPanel.repaint();
		
		
	}

	

}
