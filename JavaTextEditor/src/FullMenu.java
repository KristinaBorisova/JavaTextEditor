
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date; //Getting the date and time
import java.util.Scanner; //input text

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; //functions
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea; //text area
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.text.TextAction;
import javax.xml.soap.Text;
import javax.swing.event.ChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.EventQueue;
//import javax.swing.JTextArea;
import java.awt.SystemColor;
//import java.awt.ScrollPane; //to add scroll pane

public class FullMenu extends DateDemo {

	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private JMenuItem mntmNew;
	private static JMenuItem openMenuItem;
	private static JMenuItem saveMenuItem;
	private static JMenu saveAs;
	private static JMenuItem closeMenuItem;

	private static JMenuBar MenuBar2;
	private static JMenuItem CopyMenuItem;
	private static JMenuItem CutMenuItem;
	private static JMenuItem PasteMenuItem;
	private static JMenuItem DeleteMenuItem;
	private static JMenuItem FindMenuItem;
	private static JMenuItem FindnextMenuItem;
	private static JMenuItem ReplaceMenuItem;
	private static JMenuItem OutnumberLinesMenuItem;
	private static JMenuItem MostCommonWordMenuItem;

	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmTime;
	private JMenu mnFormat;
	private JCheckBox checkBox;

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullMenu window = new FullMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FullMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close funcion
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea(); // initialising text area
		textArea.setBounds(0, 0, 532, 245);
		frame.getContentPane().add(textArea);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// private void widgetsAdd() {
		// JScrollPane scrollPane = new JScrollPane(textArea);
		// getContentPane().add(scrollPane, BorderLayout.CENTER);
		// this.setJMenuBar(menuBar);
		// }
		// ----------------------------------------------------//
		JMenu mnFile = new JMenu("File");// File menu
		mnFile.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setBackground(SystemColor.control);
		mnFile.add(mntmNew);
		mntmNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmNew(evt);
				textArea.setText(""); // New file function
			}
		});
		// private void actionListeners(){
		// mntmNew.add.ActionListener(new Actionlistener() {
		// public void actionPerformed(ActionEvent actionEvent) {
		// TextAction.setText("");
		// }
		// }
		//
		JMenuItem mntmOpen = new JMenuItem("Open"); // Open
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		// ----------------------------------------------------//
		JMenu mnEdit = new JMenu("Edit"); // Edit menu
		mnEdit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menuBar.add(mnEdit);

		JMenuItem mntmCoppy = new JMenuItem("Coppy"); // Copy function
		mnEdit.add(mntmCoppy);
		mntmCoppy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmCoppy(evt);
				textArea.copy();
			}
		});

		JMenuItem mntmCut = new JMenuItem("Cut"); // Cut function
		mnEdit.add(mntmCut);
		mntmCut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textArea.cut();
			}
		});

		JMenuItem mntmPaste = new JMenuItem("Paste"); // Paste function
		mnEdit.add(mntmPaste);
		mntmPaste.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmPaste(evt);
				textArea.paste();
			}

			private void mntmPaste(ActionEvent evt) {
				// TODO Auto-generated method stub

			}
		});

		JMenuItem mntmDelete = new JMenuItem("Delete"); // Delete function
		mnEdit.add(mntmDelete);
		mntmPaste.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmDelete(evt);
				textArea.remove(textArea);
			}
		});

		JMenuItem mntmFind = new JMenuItem("Find...");
		mnEdit.add(mntmFind);

		JMenuItem mntmFindNext = new JMenuItem("Find next...");
		mnEdit.add(mntmFindNext);

		JMenuItem mntmReplace = new JMenuItem("Replace");
		mnEdit.add(mntmReplace);

		JMenuItem mntmOutnumberLines = new JMenuItem("Outnumber lines"); // Numbering
																			// the
																			// lines
		mnEdit.add(mntmOutnumberLines);

		JMenuItem mntmMostCommonWord = new JMenuItem("Most common word");
		mnEdit.add(mntmMostCommonWord);
		// ----------------------------------------------------//
		JMenu mnFormat = new JMenu("Front"); // Front menu
		mnFormat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menuBar.add(mnFormat);

		JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mnFormat.add(mntmWordWrap);
		mntmWordWrap.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed (java.awt.event.ActionEvent evt) {
				mntmWordWrap(evt);
				mnFormat.add(checkBox);
				if (checkBox != null) {
					setWrapStyleWord(textArea);
				}
			};
		});

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About..");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(mntmAbout, "Created by Kristina and Venetsia", "Java Text Editor",
						getDefaultCloseOperation()); // if "OK" ----> Close
			}

			private int getDefaultCloseOperation() { // Close operation int
														// method
				// TODO Auto-generated method stub
				return 0;
			}
		});

		JMenuItem mntmDate = new JMenuItem("Date");
		mntmTime = new JMenuItem("Date");
		mnHelp.add(mntmTime);
		// mntmTime.addActionListener(new ActionListener () {
		// public void actionPerformed(ActionEvent actionEvent) {
		//
		// Date dNow = new Date(0);// Instantiate a Date object
		// SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'Time:'
		// hh:mm:ss a zzz");// display time and date using toString()
		//// System.out.println("Current Date: " + ft.format(dNow));
		// JOptionPane.showMessageDialog(mntmDate, "Current Date: " +
		// ft.format(dNow));
		// }
		// }
	}

	protected void setWrapStyleWord(JTextArea textArea) {
		
		
	}

	protected void mntmWordWrap(ActionEvent evt) {
		
		
	}

	protected void mntmNew(ActionEvent evt) {
		

	}

	protected void mntmDelete(ActionEvent evt) {
		
	}

	protected void mntmCoppy(ActionEvent evt) {
		

	}
}





