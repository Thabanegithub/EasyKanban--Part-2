package accountcreation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class EasyKanbanMain{
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            //Prompt the user to create an account by entering username, password, first name,and last name
            System.out.println("To create an account, please enter the following");
            
            //First name
            System.out.println("Enter First Name (REQUIRED): ");
            String firstName = scanner.nextLine();
            
            //Check first name conditions and output messages based on the conditions
            if (firstName.isEmpty()) {
                System.out.println("First name is required, please enter first name");
            }
            else {
                System.out.println("First name is successfully captured");
            }
            
            //Last name
            System.out.println("Enter Last Name (REQUIRED): ");
            String lastName = scanner.nextLine();
            
            //Check last name conditions and output messages based on the conditions
            if (lastName.isEmpty()) {
                System.out.println("Last name is required, please enter last name");
            }
            else {
                System.out.println("Last name is successfully captured");
            }
            
            //Username
            System.out.println("Enter Username(MUST contain an underscore and be no more"
                    +" than 5 characters): ");
            String userName = scanner.nextLine();
            
            //Check username conditions,and output messages based on the conditions
            if (isUsernameValid(userName)){
                System.out.println("Username is successfully captured");
            }
            else {
                System.out.println("Username is not correctly formatted, please ensure"
                    + " that your username contains an underscore and is no more than"
                    + " 5 characters in length !");
            }
            
            //Password
            System.out.println("Enter Password(MUST be at least 8 characters, contain a"
                    +" capital letter, a number, and a special character): ");
            String passWord = scanner.nextLine();
            
            //Check password conditions,and output messages based on the conditions
            if (isPasswordValid(passWord)){
                System.out.println("Password is successfully captured");
            }
            else {
                System.out.println("Password is not correctly formatted, please ensure"
                    + " that your password contains at least 8 characters, a capital"
                    + " letter, a number and a special character !");
            }
            
            //Account Registration
            if (isUsernameValid(userName) && isPasswordValid(passWord)) {
               System.out.println("You have successfully created an account");
            }
            else {
                System.out.println("You have failed to create an account, Please enter valid information !!");
            }
            
            //Login User Feature
            System.out.print("Please enter the following to Login");
            
            String predefinedUsername = "Mpho_";
            String predefinedPassword = "Qu3st!on";
            String predefinedFirstName = "Mpho";
            String predefinedLastName = "Thabane";
            
            // Prompt user to input username and password
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine(); 
            
            // Compare input with predefined values
            if (enteredUsername.equals(predefinedUsername) && enteredPassword.equals(predefinedPassword)) {
               System.out.println("Welcome, " + predefinedFirstName + " " + predefinedLastName + ",it great"
                       + " to see you again.");
            } else {
               System.out.println("Username or password incorrect, Please try again.");
            }
            
            //Easy Kanban (Task Functionality features)
            if (enteredUsername.equals(predefinedUsername) && enteredPassword.equals(predefinedPassword)) {
               System.out.println("Welcome to Easy Kanban");
            } 
            
            //Menu options
            int option = scanner.nextInt();
            OUTER:
            while (true) {
                System.out.println("Option 1) Add tasks");
                System.out.println("Option 2) Show report (Coming Soon)");
                System.out.println("Option 3) Quit");
                switch (option) {
                    case 3 -> {
                        break OUTER;
                    }
                    case 1 -> {
                        System.out.print("Enter number of tasks: ");
                        int taskNumber = scanner.nextInt();
                        for (int i = 0; i < taskNumber; i++) {
                            System.out.print("Enter task name: ");
                            String taskName = scanner.nextLine();
                            
                            System.out.print("Enter task description: ");
                            String taskDescription = scanner.nextLine();
                            
                            System.out.print("Enter developer details: ");
                            String developerDetails = scanner.nextLine();
                            
                            System.out.print("Enter task duration in hours: ");
                            int taskDuration = scanner.nextInt();
                            
                            System.out.print("Enter task status (To Do, Doing, Done): ");
                            String taskStatus = scanner.nextLine();
                            
                            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                            if (task.checkTaskDescription()) {
                                System.out.println("Task successfully captured");
                            } else {
                                System.out.println("Please enter a task description of less than 50 characters");
                                i--; // to retry the current task
                                continue;
                            }
                            tasks.add(task);
                            JOptionPane.showMessageDialog(null, task.printTaskDetails());
                        } int totalHours = 0;
               
                        System.out.println("Total task duration: " + totalHours + " hours");
                    }

                    case 2 -> System.out.println("Coming Soon");
                    default -> {
                    }
                }
            }
        scanner.close();
    }

            
    }  
    
    // Call this method to check if the username meets conditions
    public static boolean isUsernameValid(String userName){
        return userName.length()<= 5 && userName.contains("_");
    }
    
    // Call this method to check if the password meets conditions
    public static boolean isPasswordValid(String passWord) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        return Pattern.compile(passwordPattern).matcher(passWord).matches();
    }

}
