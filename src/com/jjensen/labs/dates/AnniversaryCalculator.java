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
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnniversaryCalculator {
    private Scanner userInput;

    private Calendar currentDate;
    private Calendar anniversaryDate;

    public AnniversaryCalculator() {
        userInput = new Scanner(System.in);
        currentDate = Calendar.getInstance();
        anniversaryDate = new GregorianCalendar();
    }

    private GregorianCalendar promptUserForAnniversary() {
        InputHelpers.promptUser("Please enter year of anniversary:");
        int year = InputHelpers.extractInt(userInput.nextLine());

        InputHelpers.promptUser("Please enter month of anniversary:");
        int month = InputHelpers.extractInt(userInput.nextLine());

        InputHelpers.promptUser("Please enter day of anniversary:");
        int day = InputHelpers.extractInt(userInput.nextLine());

        return new GregorianCalendar(year, month -1, day);

    }

    public void calculateAnniversary() {
        anniversaryDate = promptUserForAnniversary();
        outputCurrentDate();
        int dayDiff = anniversaryDate.get(Calendar.DAY_OF_YEAR) - currentDate.get(Calendar.DAY_OF_YEAR);
        int hoursDiff = anniversaryDate.get(Calendar.HOUR_OF_DAY) - currentDate.get(Calendar.HOUR_OF_DAY);
        int minuteDiff = anniversaryDate.get(Calendar.MINUTE) - currentDate.get(Calendar.MINUTE);
        int secondDiff = anniversaryDate.get(Calendar.SECOND) - currentDate.get(Calendar.SECOND);

        System.out.println("There are " + dayDiff + " days, " + hoursDiff + " hours, " + minuteDiff + " minutes, and "
              + secondDiff + " seconds till the anniversary\n");

    }

    private void outputCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(currentDate.getTime()));
    }

}
