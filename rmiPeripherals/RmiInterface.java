package rmiPeripherals;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * RMI interface to enable to retrieve questions from the server and to submit data
 * @author Adrian Stoica
 * Student ID: 1708976
 */

public interface RmiInterface extends Remote{

	public ArrayList<String> GetQuestionsList() throws RemoteException;
	/**
	 * @return a list of questions
	 * @throws RemoteException
	 */

	
	public String ReturnQuestion(int i) throws RemoteException;
	/**
	 * @return a question from index i
	 * @throws RemoteException
	 * @param i = the specific index from the list of questions
	 */
	

	public void SaveAnswer(int questionIndex, int answer) throws RemoteException;
	/**
	 * save answers into a hashtable
	 * @throws RemoteException
	 */
	
	public Hashtable<Integer, Integer> getqueAndAnsList() throws RemoteException;
	/**
	 * @return Hashtable with questions and answers
	 * @throws RemoteException
	 */
}
