import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class musicPlayerGUI {

	private JFrame frmMusicplayerV;
	private JTextField textField;
	public JButton getData;
	private boolean proceed = false;
	
	private String userData;
	private JTextPane textPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JSplitPane splitPane_3;
	private JSplitPane splitPane_4;
	public JRadioButton basicRadioButton;
	public JRadioButton stackRadioButton;
	public JRadioButton queueRadioButton;
	private JSplitPane splitPane_5;
	private JLabel lblOutput;
	private JSplitPane splitPane_6;
	public JButton displayData;
	public JButton btnEND;
	
	/**
	 * Create the application.
	 * Constructor method
	 */
	public musicPlayerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicplayerV = new JFrame();
		frmMusicplayerV.setTitle("MusicPlayer v1.0");
		frmMusicplayerV.setBounds(100, 100, 450, 300);
		frmMusicplayerV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicplayerV.getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		frmMusicplayerV.getContentPane().add(splitPane);
		
		JLabel lblInputFileName = new JLabel("Input File Name");
		lblInputFileName.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblInputFileName);
		
		textField = new JTextField();
		splitPane.setRightComponent(textField);
		
		textField.setColumns(10);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.275);
		frmMusicplayerV.getContentPane().add(splitPane_1);
		
		getData = new JButton("Load File");
		splitPane_1.setLeftComponent(getData);
		
		splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_3);
		
		splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setRightComponent(splitPane_4);
		
		stackRadioButton = new JRadioButton("Stack Play List");
		splitPane_4.setLeftComponent(stackRadioButton);
		
		queueRadioButton = new JRadioButton("Queue Play List");
		splitPane_4.setRightComponent(queueRadioButton);
		
		basicRadioButton = new JRadioButton("Simple Play List");
		splitPane_3.setLeftComponent(basicRadioButton);
		
		splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frmMusicplayerV.getContentPane().add(splitPane_2);
		
		textPane = new JTextPane();
		textPane.setText("Instructions: Input filename. Select type of playlist. Hit Load file to run.");
		splitPane_2.setRightComponent(textPane);
		
		splitPane_5 = new JSplitPane();
		splitPane_5.setResizeWeight(0.4);
		splitPane_2.setLeftComponent(splitPane_5);
		
		lblOutput = new JLabel("OUTPUT");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_5.setLeftComponent(lblOutput);
		
		splitPane_6 = new JSplitPane();
		splitPane_6.setResizeWeight(0.5);
		splitPane_5.setRightComponent(splitPane_6);
		
		displayData = new JButton("PLAY");
		splitPane_6.setLeftComponent(displayData);
		
		btnEND = new JButton("END");
		splitPane_6.setRightComponent(btnEND);
	}
	
	public boolean loadDataProceed(){
		userData = textField.getText();
		
		textPane.setText("Data Read");
		textField.setText("");
		this.proceed = true;
		return this.proceed;
	}
	
//	public boolean loadOutput(){
//		
//	}
	
	public String getUserText(){
		return this.userData;
	}
	
	public void setTextExternal(String text){
		this.textPane.setText(text);
	}
	
	public void setFrameView(){
		this.frmMusicplayerV.setVisible(true);
	}
	
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					musicPlayerGUI window = new musicPlayerGUI();
//					window.frame.setVisible(true);
//					
//					window.setTextExternal("HAHAHA");
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
		
	}

	

//}
