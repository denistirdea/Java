package behaviours;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import LOG_FILE.LogWriter;


public class CheckForMessages extends Behaviour {

	private LogWriter logWriter;

	public void action() {
		while(true)
		{
			try {
				Thread.sleep(1500);
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					//received message
					String content = msg.getContent();
					String message  = " RECEIVE: "+ myAgent.getName() +" got the next message: " +content+ " from "+ msg.getSender().getName();
					logWriter = new LogWriter(message);
					//send confirmation message
					ACLMessage replyMessage = msg.createReply();
					replyMessage.setPerformative(ACLMessage.INFORM);
					replyMessage.setContent(myAgent.getLocalName() + " has received the message: "+"'"+msg.getContent()+"'"+" from "+msg.getSender().getName());
					myAgent.send(replyMessage);
				}
				else {
					block();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean done() {
		return false;
	}
}