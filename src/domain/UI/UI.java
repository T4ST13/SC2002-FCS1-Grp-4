package domain.UI;

import domain.displayable.Displayable;

import java.util.List;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    int userInput;

    public void displayMessage(String message){//change to get
        if (message.isEmpty()){
            return;
        }
        System.out.println("---");
        System.out.println(message);
        System.out.println("Press ENTER to continue");
        System.out.println("---");
        scanner.nextLine();
    }

    public void displayMessage(List <String> messages){//change to get
        for (String message : messages){
            displayMessage(message);
        }
    }

    public <T> void displayOptions(List<T> list){//change to get
        System.out.println("---");
        System.out.println("Choose Option:");
        for (int i = 1; i<=list.size(); i++){
            if (list.get(i-1) instanceof Displayable)
                System.out.print(i + ": " + ((Displayable)list.get(i-1)).getDisplayFormat());
            else
                System.out.print(i + ": " + list.get(i-1));
            if(i!=list.size()){
                System.out.print(" | ");
            }
        }
        System.out.println("\n---");
        System.out.print("Choice: ");
        requestInput();
    }

    public void requestInput(){
        userInput = scanner.nextInt()-1;
        scanner.nextLine();//need nextLine to remove the ENTER input that nextInt() leaves undetected
        System.out.println();
        //since all user input will be choosing from an array of choices, it has to be converted to index
    }

    public int getInput(){
        return this.userInput;
    }
}
