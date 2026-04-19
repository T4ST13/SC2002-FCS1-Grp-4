package ui;

import domain.displayable.Displayable;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    Scanner scanner = new Scanner(System.in);
    int userInput;

    public void displayMessage(String message){
        if (message.isEmpty()){
            return;
        }
        System.out.println("---");
        System.out.println(message);
        System.out.println("Press ENTER to continue");
        System.out.println("---");
        scanner.nextLine();
    }

    public void displayMessage(List <String> messages){
        for (String message : messages){
            displayMessage(message);
        }
    }

    public <T> void displayOptions(List<T> list){
        while (true) {
            try {
                System.out.println("---");
                System.out.println("Choose Option:");
                for (int i = 1; i <= list.size(); i++) {
                    if (list.get(i-1) instanceof Displayable) {//classes that implement Displayable has the method getDisplayFormat()
                        System.out.print(i + ": " + ((Displayable)list.get(i - 1)).getDisplayFormat());
                        if (i != list.size()) {
                            System.out.print(" | ");
                        }
                    }
                }
                System.out.println("\n---");
                requestInput();

                if (userInput+1 < 1 || userInput+1 > list.size()) {
                    // manually throw an exception to jump to the catch block
                    System.out.println("Invalid option selected.");
                    continue;
                }
                return;

            } catch (NumberFormatException e) {
                System.out.println(">> Error: Please enter a valid number.");
            }
        }
    }

    public void requestInput(){
        while (true){
            try {
                System.out.print("Choice: ");
                userInput = Integer.parseInt(scanner.nextLine().trim()) - 1;//since all user input will be choosing from an array of choices, it has to be converted to index
                System.out.println();
                return;
            } catch(NumberFormatException e){
                System.out.println(">> Error: Please enter a valid number.");
            }
        }
    }

    public int getInput(){
        return this.userInput;
    }
}
