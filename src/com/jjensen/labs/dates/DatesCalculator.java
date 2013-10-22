package com.jjensen.labs.dates;

import edu.neumont.jjensen.helpers.inputhelper.InputHelpers;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/18/13
 * Time: 8:41 AM
 */
public class DatesCalculator {
    private Calendar calendar;
    private boolean running;
    private Scanner input;

    private String[] options = {
            "1. Age Calculator",
            "2. Anniversary Calculator",
            "3. Age Diff Calculator",
            "0. Exit"
    };

    public DatesCalculator() {
        input = new Scanner(System.in);


    }

    private void displayMenu() {
        for(String option : options) {
            System.out.println(option);
        }

    }

    public void run() {
        running = true;

        do {
            displayMenu();
            InputHelpers.promptUser("Please make a selection:");
            processInput();

        } while(running);

    }


    private void processInput() {
        int choice = InputHelpers.extractInt(input.nextLine());

        switch (choice) {
            case 1:
                AgeCalculator calc = new AgeCalculator();
                calc.calculateAge();
                break;
            case 2:
                AnniversaryCalculator anniversaryCalc = new AnniversaryCalculator();
                anniversaryCalc.calculateAnniversary();
                break;
            case 3:
                AgeDifferenceCalculator ageDifferenceCalculator = new AgeDifferenceCalculator();
                ageDifferenceCalculator.calculateAgeDifference();
                break;
            case 0:
                running = false;
                break;

            default:
                System.out.println("\nIncorrect input.  Please try again.");

        }

    }



}
