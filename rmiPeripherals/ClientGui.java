package rmiPeripherals;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import client.ClientSide;
import rmiPeripherals.DisplayData;



/**
 * @author Adrian Stoica
 * Student ID: 1708976
 * 
 * Simple graphical user interface
 * Displays questions as a label
 * Displays answers - as a slider
 * Displays progress - as a progress bar
 * Able to answer question and go to next question
 * Able to generate another window with a summary of the questions and answers from the user
 */

public class ClientGui extends JFrame implements ChangeListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	static final int minValue = 0;
	static final int maxValue = 10;
	static final int incrementValue = 1;
	static final int startValue = 5;
	public int startingQuestion = 0;
	public ArrayList<String> newQuestions = new ArrayList<String>();
	
	
	private ClientSide questionnaire = new ClientSide(); 
	
	/**
	 * Change listener used to check the value o the slider and update the answer label
	 */

	public void stateChanged(ChangeEvent e) {
		if(e.getSource().equals(slider)) {
		int value = slider.getValue();
		answerLabel.setText(Integer.toString(value) + " times per week. . .");	
		}
	}
	
	/**
	 * Event listener for buttons
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(nextButton) && nextButton.getText() == "Assess yourself") {
			nextButton.setText("Next question");
			newQuestions = questionnaire.QuestionLists();
			label.setText("<HTML> " + questionnaire.QuestionString(startingQuestion)+ "</HTML>");
			slider.setVisible(true);
			answerLabel.setVisible(true);
			startingQuestion++;
			progress.setVisible(true);
			
		} else if(e.getSource().equals(nextButton) && nextButton.getText() == "Next question" && startingQuestion<=questionnaire.QuestionLists().size()-1)  {
			/**
			 * Save answer for previous question
			 * Display the next question
			 * Reset slider
			 */
			progress.setValue(startingQuestion);
			
			questionnaire.SetAnswer(startingQuestion - 1, slider.getValue());
			
			label.setText("<HTML> " + questionnaire.QuestionString(startingQuestion)+ "<HTML>");
			
			slider.setValue(startValue);
			startingQuestion++;
			
			
		} else if(e.getSource().equals(analyzeButton)) {
			/**
			 * Generate another  window and display the summary of the questionnaire
			 */
			DisplayData.show(questionnaire.qandAList(), questionnaire.QuestionLists());
			
			//System.out.println(questionnaire.qandAList()); - was used for testing
			
		} else {
			/**
			 * Update the progressbar
			 * Disable the Next Question button
			 * Save last answer
			 * Change question label
			 */
			
			progress.setValue(startingQuestion);
			nextButton.setEnabled(false);
			questionnaire.SetAnswer(startingQuestion - 1, slider.getValue());
			
			label.setText("<HTML> You have reach the end of the questionnaire.<HTML>");
			
		}
		
	}
	/**
	 * Declaring GUI components
	 */
	
	JButton nextButton = new JButton("Assess yourself");	
	JButton analyzeButton = new JButton("Get summary");
	JSlider slider = new JSlider(JSlider.HORIZONTAL,minValue,maxValue,startValue);
	JLabel label = new JLabel("<HTML> Click the 'Asses yourself' button to start the questionaire!<HTML>");
	JLabel answerLabel = new JLabel(Integer.toString(slider.getValue())+"  times per week . . .");
	JProgressBar progress = new JProgressBar();
	
	/** method for calling the GUI*/
	
	private ClientGui() {
		super();
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		
		/**
		 * Add components to the new panel
		 * Add action listeners and change listeners to components
		 */
		panel.add(nextButton); 
		nextButton.addActionListener(this); 
		
		panel.add(analyzeButton); 
		analyzeButton.addActionListener(this); 
		
		panel.add(label);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		
		panel.add(slider);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setVisible(false);
		slider.addChangeListener(this);
		
		panel.add(answerLabel);
		answerLabel.setVisible(false);
		
		panel.add(progress);
		progress.setValue(0);
		progress.setVisible(false);
		progress.setMaximum(7);
		
		getContentPane().add(panel);
		panel.repaint();
		
	}
	
	/**
	 * Main method that calls the ClientGui method and displays the GUI
	 * @param args
	 */
	public static void main(String [] args ) { 
		ClientGui myGUI = new ClientGui(); 
		myGUI.setVisible(true); 
	}
}

