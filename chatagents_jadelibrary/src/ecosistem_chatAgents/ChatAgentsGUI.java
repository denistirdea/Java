package ecosistem_chatAgents;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
import Agents.MessageSender;
import LOG_FILE.LogReader;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Rectangle;


public class ChatAgentsGUI extends javax.swing.JFrame {

	public Image imgOFF;
	public Image imgON;
	public JButton Agent1;
	public JButton Agent2;
	public JButton Agent3;
	public JButton Agent4;
	public JButton Agent5;
	private JButton RefreshAgents;
	private JTextField textField_1;
	private MessageSender myAgent;
	private JTextField textField_2;
	public String[] agents;
	DFAgentDescription[] result;
	DFAgentDescription dfd = new DFAgentDescription();
	private boolean agent1, agent2, agent3, agent4, agent5 = false;


	/**
	 * @wbp.parser.constructor
	 */
	public ChatAgentsGUI(MessageSender messageSender) {
		setTitle("Tirdea Denis-Alexandru - Chat Agents");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatAgentsGUI.class.getResource("/jade/tools/rma/images/logosmall.jpg")));
		myAgent = messageSender;
		myAgent.AgentActivity();

		getContentPane().setBackground(new Color(0, 153, 153));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(900, 560));
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 303, 862, 169);
		getContentPane().add(scrollPane);

		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		DefaultCaret caret = (DefaultCaret)textArea_1.getCaret();



		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setBounds(10, 11, 440, 242);
		getContentPane().add(splitPane);

		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		splitPane.setLeftComponent(panel);

		JLabel lblTirdeaDenisalexandru = new JLabel("Tirdea Denis-Alexandru");
		lblTirdeaDenisalexandru.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTirdeaDenisalexandru.setBounds(719, 462, 153, 48);
		getContentPane().add(lblTirdeaDenisalexandru);

		JLabel lblCa = new JLabel("C,3141A");
		lblCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCa.setBounds(729, 493, 81, 28);
		getContentPane().add(lblCa);

		textField_2 = new JTextField();
		textField_2.setBounds(460, 44, 313, 109);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblDestinatari = new JLabel("Destinatari:");
		lblDestinatari.setBounds(460, 29, 81, 14);
		getContentPane().add(lblDestinatari);
		
				textField_1 = new JTextField();
				textField_1.setBounds(460, 189, 412, 29);
				getContentPane().add(textField_1);
				textField_1.setColumns(10);

		JLabel lblMesaj = new JLabel("Mesaj:");
		lblMesaj.setBounds(460, 164, 46, 14);
		getContentPane().add(lblMesaj);

		File imageCheckON = new File("data\\on.png");
		File imageCheckOFF = new File("data\\off.png");
		imgOFF = Toolkit.getDefaultToolkit().getImage("data\\off.png");
		imgON = Toolkit.getDefaultToolkit().getImage("data\\on.png");

		if(imageCheckON.exists() && imageCheckOFF.exists()) 
			System.out.println("Image files found!");
		else 
			System.out.println("Image files not found!");

		JEditorPane textArea = new JEditorPane();
		splitPane.setRightComponent(textArea);

		Agent1 = new JButton();		
		Agent1.setText("Agent 1");
		Agent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!agent1 && Agent1.getIconTextGap() == 4) {
					textField_2.setText(textField_2.getText() + "Agent1 ");
					textArea.setText(getINFO(myAgent, "Agent1"));
					agent1= true;
				}
				else 
					JOptionPane.showMessageDialog(null, "Agent1 is already selected or is OFFLINE");
			}
		});
		Agent2 = new JButton("Agent 2");
		Agent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!agent2 && Agent2.getIconTextGap() == 4) {
					textField_2.setText(textField_2.getText() + "Agent2 ");
					agent2= true;
					textArea.setText(getINFO(myAgent, "Agent2"));

				}
				else 
					JOptionPane.showMessageDialog(null, "Agent2 is already selected or is OFFLINE");
			}
		});
		Agent3 = new JButton("Agent 3");
		Agent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!agent3 && Agent3.getIconTextGap() == 4) {
					textField_2.setText(textField_2.getText() + "Agent3 ");
					textArea.setText(getINFO(myAgent, "Agent3"));
					agent3= true;
				}
				else 
					JOptionPane.showMessageDialog(null, "Agent3 is already selected or is OFFLINE");
			}
		});
		Agent4	= new JButton("Agent 4");
		Agent4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!agent4 && Agent4.getIconTextGap() == 4) {
					textArea.setText(getINFO(myAgent, "Agent4"));
					textField_2.setText(textField_2.getText() + "Agent4 ");
					agent4= true;
				}
				else 
					JOptionPane.showMessageDialog(null, "Agent4 is already selected or is OFFLINE");
			}
		});
		Agent5 = new JButton("Agent 5");
		Agent5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!agent5 && Agent5.getIconTextGap() == 4) {
					textArea.setText(getINFO(myAgent, "Agent5"));
					textField_2.setText(textField_2.getText() + "Agent5 ");
					agent5= true;
				}
				else 
					JOptionPane.showMessageDialog(null, "Agent5 is already selected or is OFFLINE");
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(Agent1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(Agent2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(Agent3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(Agent4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(Agent5, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(Agent1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Agent2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Agent3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Agent4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Agent5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(71)));
		panel.setLayout(gl_panel);

		Agent1.setIcon(new ImageIcon(imgOFF));Agent2.setIcon(new ImageIcon(imgOFF));Agent3.setIcon(new ImageIcon(imgOFF));Agent4.setIcon(new ImageIcon(imgOFF));Agent5.setIcon(new ImageIcon(imgOFF));
		Agent1.setIconTextGap(5);Agent2.setIconTextGap(5);Agent3.setIconTextGap(5);Agent4.setIconTextGap(5);Agent5.setIconTextGap(5);


		RefreshAgents = new JButton("Refresh Agents");
		RefreshAgents.setBounds(10, 264, 186, 22);
		getContentPane().add(RefreshAgents);
		RefreshAgents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent1.setIcon(new ImageIcon(imgOFF));
				Agent2.setIcon(new ImageIcon(imgOFF));
				Agent3.setIcon(new ImageIcon(imgOFF));
				Agent4.setIcon(new ImageIcon(imgOFF));
				Agent5.setIcon(new ImageIcon(imgOFF));
				String[] agents = new String[myAgent.ReturnAgents().length];
				agents = myAgent.ReturnAgents();
				for(int count = 0 ; count<agents.length; count++)
				{
					switch(agents[count])
					{
					case "Agent1":
						Agent1.setIcon(new ImageIcon(imgON));
						Agent1.setIconTextGap(4);
						break;
					case "Agent2":
						Agent2.setIcon(new ImageIcon(imgON));
						Agent2.setIconTextGap(4);
						break;
					case "Agent3":
						Agent3.setIcon(new ImageIcon(imgON));
						Agent3.setIconTextGap(4);
						break;
					case "Agent4":
						Agent4.setIcon(new ImageIcon(imgON));
						Agent4.setIconTextGap(4);
						break;
					case "Agent5":
						Agent5.setIcon(new ImageIcon(imgON));
						Agent5.setIconTextGap(4);
						break;
					default:break;
					}
				}
			}
		});
		JButton btnTrimite = new JButton("Trimite");
		btnTrimite.setBounds(783, 251, 89, 23);
		getContentPane().add(btnTrimite);
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		btnTrimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please introduce your message to be sent");
				}
				else {
					String[] agents = {"","","","",""};
					String message = textField_1.getText(); 
					if(agent1) {
						agents[0] = "Agent1";
					}
					if(agent2)
					{
						agents[1] = "Agent2";
					}
					if(agent3)
					{
						agents[2] = "Agent3";
					}
					if(agent4)
					{
						agents[3] = "Agent4";
					}
					if(agent5)
					{
						agents[4] = "Agent5";
					}
					myAgent.SetExecutable(agents, message);
				}
			}
		});
		JButton btnAfiseazaLog = new JButton("Afiseaza LOG");
		btnAfiseazaLog.setBounds(10, 485, 186, 28);
		getContentPane().add(btnAfiseazaLog);

		JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agent1 = false;
				agent2 = false;
				agent3 = false;
				agent4 = false;
				agent5 = false;
				textField_2.setText("");
				textField_1.setText("");
			}
		});
		btnClean.setBounds(783, 87, 89, 23);
		getContentPane().add(btnClean);
		btnAfiseazaLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogReader logReader = new LogReader();
				textArea_1.setText(logReader.ReturnReadedLines());
			}
		});
		this.pack();
		this.setVisible(true);

		System.out.println("GUI Initializat");
	}

	public String getINFO(MessageSender myAgent,String agentName) {
		String info = "";
		result = myAgent.Agents();
		for(int count= 0; count< result.length ; count++)
		{
			if(agentName.toString().equals(result[count].getName().getLocalName())) {
				info = "Agent name: "+result[count].getName().getLocalName() + System.lineSeparator() + "Agent Adress: " +System.lineSeparator() + result[count].getName();
			}
		}
		return info;
	}
}
