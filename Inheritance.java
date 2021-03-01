import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    Student(String fn, String ln, int id, int[] scores) {
        super(fn, ln, id);
        this.testScores = scores;
    }
    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    char calculate() {
        int tot = 0, av = 0;
        char grade = 'O';
        for (int i = 0; i < testScores.length; i++) {
            tot += testScores[i];
        }
        av = tot / testScores.length;
        if ((av >= 90) && (av < 100)) {
            grade = 'O';
        }
        else if ((av >= 80) && (av < 90)) {
            grade = 'E';
        }
        else if ((av >= 70) && (av < 90)) {
            grade = 'A';
        }
        else if ((av >= 55) && (av < 70)) {
            grade = 'P';
        }
        else if ((av >= 40) && (av < 55)) {
            grade = 'D';
        }
        else if (av < 40) {
            grade = 'T';
        }
        return(grade);
    }
}
public class Inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}