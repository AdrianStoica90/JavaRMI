package rmiPeripherals;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import rmiPeripherals.IPClass;

/**
 * This class creates a list of questions and Stores answers for each question.
 * 
 * @author Adrian Stoica
 * Student ID: 1708976
 */

public class Question implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Declaring/instantiating needed variables/lists
	 */
	
	ArrayList<String> listOfQuestions = new ArrayList<String>();
	private String currentUser;
	private String urlString = "http://ip-api.com/json/?fields=61439";
	private Hashtable<Integer,Integer> qAndAList = new Hashtable <Integer, Integer>();
	
	/**
	 * Adding questions to the above declared list of questions.
	 * 
	 */
	public Question() {
		super();
		
		this.listOfQuestions.add("How often do you excercise per week?");
		this.listOfQuestions.add("How often do you eat fruits and vegetables in a week?");
		this.listOfQuestions.add("How often do you drink alcohol per week?");
		this.listOfQuestions.add("How many packs of cigarettes do you smoke per week?");
		this.listOfQuestions.add("How often do you take multivitamins in a week?");
		this.listOfQuestions.add("How many times do you meditate per week?");
		this.listOfQuestions.add("How often do you feel energetic in a week?");
		this.currentUser = IPClass.GetIP(this.urlString);
		this.qAndAList.put(0,0);
		
		
		}
	
	/**
	 * @return the list of questions
	 */
	public ArrayList<String> getListOfQuestions() {
		return listOfQuestions;
	}

	/**
	 * @return list of questions indexes with the answers
	 */
	public Hashtable<Integer,Integer> getqAndAList(){
		return qAndAList;
	}

	/**
	 * @return currentUser (IP as a string)
	 */
	public String getCurrentUser() {
		System.out.println("Your IP is: " + currentUser);
		return currentUser;
	}
	
}



