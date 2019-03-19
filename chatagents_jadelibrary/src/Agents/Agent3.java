package Agents;

import behaviours.RegisterToDFAgent;
import behaviours.CheckForMessages;
import jade.core.Agent;


public class Agent3 extends Agent{
	
	CheckForMessages checkForMessages = new CheckForMessages();
	RegisterToDFAgent registerToDF = new RegisterToDFAgent();
	
	public void setup()
	{
		addBehaviour(registerToDF);
		addBehaviour(checkForMessages);
	}
}