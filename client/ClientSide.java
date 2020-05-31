package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

import rmiPeripherals.RmiInterface;


/**
 * @author Adrian Stoica
 * Student ID: 1708976
 *
 *This class gets all remote methods.
 *The GUI class will use this class to interact with the system.
 */
public class ClientSide {

	RmiInterface questionsList;

	
	public ClientSide() {
		super();
		try {
			questionsList = (RmiInterface) Naming.lookup("rmi://localhost:1890/questions");
			
			
		} catch (Exception e) {
			
			System.out.println("Something went wrong: "+e.toString());
			
			e.printStackTrace();
			
			System.out.println("Please check if your server is working.");
		}
	}
		/**
		 * @return a list of questions
		 */
	public ArrayList<String> QuestionLists(){
		
		try {
			ArrayList<String> listOfQuestions = questionsList.GetQuestionsList();
			// System.out.println(listOfQuestions); - was used for testing
			return listOfQuestions;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}
	
	/**
	 * 
	 * @param questionIndex = the position of a specific question in the list of questions
	 * @return a question string from the list using the index
	 */
	
	public String QuestionString(int questionIndex) {
		try {
			return questionsList.ReturnQuestion(questionIndex);
		} catch (RemoteException e) {
			return null;
		}
		
	}
	
	/**
	 * saves answers to questions into a hashtable
	 * @param questionIndex = position of a question in the list of questions
	 * @param answer  = the number from the GUI slider (from 1 to 7, whatever the client answers)
	 */
	
	public void SetAnswer(int questionIndex, int answer) {
		
		try {
			questionsList.getqueAndAnsList();
			questionsList.SaveAnswer(questionIndex, answer);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @return a hashtable with questions and answers.
	 */
	
	public Hashtable<Integer, Integer> qandAList(){
		try {
			return questionsList.getqueAndAnsList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
