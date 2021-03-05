package mechanical_parts;

import java.util.Scanner;

public class Parts {

    public static void main(String[] args) {
        Tree<String> part = new Tree<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter to Add a new Item");

        String carPart = sc.nextLine();

        part.add("Exhaust");
        part.add("Seat");
        part.add("Steering Wheel");
        part.add("Fuel Filter");
        part.add("Windscreen");
        part.add("Gear Box");
        part.add(carPart);
        
        System.out.println("Available Car Parts are: \n");
        part.displayTree();
        System.out.println("You have searched for the " + carPart);
        part.find(carPart);
        System.out.println("You have searched for the car key");
        part.find("key \n");
        part.displayTree();
        
        System.out.println("Do you wanna Delete Gear Box Press 1");
        int key = sc.nextInt();
        if(key == 1){
            part.delete("Gear Box");
            System.out.println("Current List");
            part.displayTree();
        }else
        {
            System.out.println("Deletion didn't complete!");
          
            System.out.println("Current List");
            part.displayTree();
        }
        
    }
}

