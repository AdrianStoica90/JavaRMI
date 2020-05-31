package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import rmiPeripherals.RmiInterface;
import rmiPeripherals.Question;


public class QuestionImplementation extends UnicastRemoteObject implements RmiInterface{

	/**
	 * @author Adrian Stoica
	 * Student ID: 1708976
	 */
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listOfQuestions = new ArrayList<String>();
	private Question newQuestions = new Question();
	
	public String userIP;
	private Hashtable <Integer, Integer> answers = newQuestions.getqAndAList();
	public String result;
	
	/**
	 * instantiate the question class, get new questions and get IP to be used as USER.
	 * @throws RemoteException
	 */
	QuestionImplementation() throws RemoteException {
		super();
		listOfQuestions = newQuestions.getListOfQuestions();
		System.out.println("Questions are ready!");
		userIP = newQuestions.getCurrentUser();
		newQuestions.getqAndAList();
		this.result = "You must answer the questions first, then you can see the results.";
	}

	
	/**
	 * Implementation of remote interface method
	 * @return the list of questions as an ArrayList
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<String> GetQuestionsList() throws RemoteException {
		return listOfQuestions;
	}
	
	
	/**
	 * Implementation of remote interface method
	 * @return The question from a specific index from the questions list
	 * @parameter i The index of a specific question
	 * @throws RemoteException
	 */
	@Override
	
	public String ReturnQuestion(int i) throws RemoteException {
		return listOfQuestions.get(i);
		
	}
	
	/**
	 * Implementation of remote interface method
	 * Adding new answers to the Questions and Answers hashtable.
	 */
	
	@Override
	public void SaveAnswer(int questionIndex, int answer) throws RemoteException {
		answers.put(questionIndex, answer);
	}
	/**
	 * Implementation of remote interface method
	 * @return Hashtable with questions and answers
	 * @throws RemoteException
	 */
	
	@Override
	public Hashtable<Integer, Integer> getqueAndAnsList() throws RemoteException {
		return newQuestions.getqAndAList();
	}
}

