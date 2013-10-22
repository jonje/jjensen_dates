package com.jjensen.labs.dates;

import edu.neumont.jjensen.helpers.inputhelper.InputHelpers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/21/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class AgeCalculator {

    private Calendar currentDate;
    private Calendar birthdate;
    private Scanner input;

    public AgeCalculator() {
        currentDate = new GregorianCalendar();
        birthdate = new GregorianCalendar();
        input = new Scanner(System.in);

    }

    public void calculateAge() {
        birthdate = promptUserForDate();
        int dayDiff;
        int monthDiff;

        if(currentDate.get(Calendar.DAY_OF_MONTH) > birthdate.get(Calendar.DAY_OF_MONTH)) {
            dayDiff = currentDate.get(Calendar.DAY_OF_MONTH) - birthdate.get(Calendar.DAY_OF_MONTH);

        } else {
            dayDiff = birthdate.get(Calendar.DAY_OF_MONTH) - currentDate.get(Calendar.DAY_OF_MONTH);

        }

        if(currentDate.get(Calendar.MONTH) > birthdate.get(Calendar.MONTH)) {

            monthDiff = currentDate.get(Calendar.MONTH) - birthdate.get(Calendar.MONTH);
        } else {
            monthDiff = birthdate.get(Calendar.MONTH) - currentDate.get(Calendar.MONTH) ;

        }

        int yearDiff = currentDate.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);

        System.out.println("You are " + yearDiff + " years, " + monthDiff + " months, and " + dayDiff + " days old." );


    }

    private GregorianCalendar promptUserForDate() {
        InputHelpers.promptUser("Please input birth year:");
        int birthYear = InputHelpers.extractInt(input.nextLine());

        InputHelpers.promptUser("Please input birth month:");
        int birthMonth = InputHelpers.extractInt(input.nextLine());

        InputHelpers.promptUser("Please input birth day:");
        int birthDay = InputHelpers.extractInt(input.nextLine());

        return new GregorianCalendar(birthYear, birthMonth, birthDay);

    }

}
