package behaviours;

import LOG_FILE.LogWriter;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class RegisterToDFAgent extends Behaviour{

	LogWriter logWriter;
	@Override
	public void action() {
		try {
			DFAgentDescription dfd = new DFAgentDescription();

			dfd.setName(myAgent.getAID()); 
			ServiceDescription sd  = new ServiceDescription();
			sd.setType( "Communication" );
			sd.setName(myAgent.getLocalName());
			dfd.addServices(sd);

			try {  
				DFService.register(myAgent, dfd);  
			}
			catch (FIPAException fe) { fe.printStackTrace();
			}
		}
		catch(Exception e){
			e.printStackTrace();}
	}

	@Override
	public boolean done() {
		String message = " REGISTER: "+myAgent.getAID() + " has been registered to DFAgent [Directory Facilitator]";
		logWriter = new LogWriter(message);
		return true;
	}
}