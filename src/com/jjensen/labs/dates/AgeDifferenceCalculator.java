package com.jjensen.labs.dates;

import edu.neumont.jjensen.helpers.inputhelper.InputHelpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/22/13
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AgeDifferenceCalculator {
    private Calendar birthday1;
    private Calendar birthday2;

    private Scanner userInput;

    public AgeDifferenceCalculator() {
        userInput = new Scanner(System.in);

    }

    public void calculateAgeDifference() {

        InputHelpers.promptUser("First birthday");
        birthday1 = promptUserForBirthday();

        InputHelpers.promptUser("Second birthday");
        birthday2 = promptUserForBirthday();

        int yearDiff = birthday1.get(Calendar.YEAR) - birthday2.get(Calendar.YEAR);
        int monthDiff = birthday1.get(Calendar.MONTH) - birthday2.get(Calendar.MONTH);
        int dayDiff = birthday1.get(Calendar.DAY_OF_MONTH) - birthday2.get(Calendar.DAY_OF_MONTH);
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("There are " + yearDiff + " years, " + monthDiff + " months, " + dayDiff + " days between "
                + format.format(birthday1.getTime()) + " and " + format.format(birthday2.getTime()) + "\n");
    }

    private GregorianCalendar promptUserForBirthday() {
        InputHelpers.promptUser("Please enter year of birth:");
        int year = InputHelpers.extractInt(userInput.nextLine());

        InputHelpers.promptUser("Please enter month of birth:");
        int month = InputHelpers.extractInt(userInput.nextLine());

        InputHelpers.promptUser("Please enter day of birth:");
        int day = InputHelpers.extractInt(userInput.nextLine());

        return new GregorianCalendar(year, month -1, day);
    }


}
