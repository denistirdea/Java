package Agents;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import behaviours.RegisterToDFAgent;
import LOG_FILE.LogWriter;
import ecosistem_chatAgents.ChatAgentsGUI;
import jade.core.AID;
import jade.core.behaviours.*;


public class MessageSender extends Agent{

	private ChatAgentsGUI a;
	RegisterToDFAgent registerToDF = new RegisterToDFAgent();
	boolean execute = false;
	private LogWriter logWriter;
	DFAgentDescription dfd = new DFAgentDescription();
	String[] agenti;
	DFAgentDescription[] result;

	public void setup()
	{
		a = new ChatAgentsGUI(this);
		addBehaviour(new TickerBehaviour(this, 1000) {
			public void onTick() {
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					String content = msg.getContent();
					String message = " CONFIRM: "+myAgent.getName() +" confirms that " + msg.getSender().getName()+ " received the following message: "+ content;
					logWriter = new LogWriter(message);
				}
			}
		});
	}

	public void SetExecutable(String[] agents, String messageToBeSend) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				for(int count= 0; count< agents.length; count++) {
					ACLMessage message = new ACLMessage(ACLMessage.INFORM);
					switch(agents[count]) {
					case "Agent1":
						message.addReceiver(new AID (agents[count], AID.ISLOCALNAME));
						message.setContent(messageToBeSend);
						myAgent.send(message);
						logWriter = new LogWriter(" SEND: "+message.toString());
						break;
					case "Agent2":
						message.addReceiver(new AID (agents[count], AID.ISLOCALNAME));
						message.setContent(messageToBeSend);
						myAgent.send(message);
						logWriter = new LogWriter(" SEND: "+message.toString());
						break;
					case "Agent3":
						message.addReceiver(new AID (agents[count], AID.ISLOCALNAME));
						message.setContent(messageToBeSend);
						myAgent.send(message);
						logWriter = new LogWriter(" SEND: "+message.toString());
						break;
					case "Agent4":
						message.addReceiver(new AID (agents[count], AID.ISLOCALNAME));
						message.setContent(messageToBeSend);
						myAgent.send(message);
						logWriter = new LogWriter(" SEND: "+message.toString());
						break;
					case "Agent5":
						message.addReceiver(new AID (agents[count], AID.ISLOCALNAME));
						message.setContent(messageToBeSend);
						myAgent.send(message);
						logWriter = new LogWriter(" SEND: "+message.toString());
						break;
					default :
						break;
					}
				}
			}
		});
	}

	public void AgentActivity()
	{
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				try {
					result = DFService.search(myAgent, dfd);
					agenti = new String[result.length];
					if(result.length>0) {
						for (int count=0; count< result.length; count++) {
							agenti[count]=result[count].getName().getLocalName();
						}
					}
				} catch (FIPAException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String[] ReturnAgents()
	{
		return agenti;
	}
	
	public DFAgentDescription[] Agents()
	{
		return result;
	}
}
