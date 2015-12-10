package edu.csumb.sarm6485.otterlibrarysystem;

/**
 * Created by michaelsarmiento on 12/7/15.
 */
public class Date {
    String day;
    String month;
    String year;

    public Date(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(int month, String day, String year) {
        if(month==1){this.month ="January";}
        else if(month==2){this.month ="February";}
        else if(month==3){this.month ="March";}
        else if(month==4){this.month ="April";}
        else if(month==5){this.month ="May";}
        else if(month==6){this.month ="June";}
        else if(month==7){this.month ="July";}
        else if(month==8){this.month ="August";}
        else if(month==9){this.month ="September";}
        else if(month==10){this.month ="October";}
        else if(month==11){this.month ="November";}
        else if(month==12){this.month ="December";}


        this.day = day;
        this.year = year;
    }

    public int getDayNumber() {
        int dayNumber = 0;
        if (year.equals("2016")) {
            if (month.equals("February")) {
                dayNumber += 31;
            } else if (month.equals("March")) {
                dayNumber += 60;
            } else if (month.equals("April")) {
                dayNumber += 91;
            } else if (month.equals("May")) {
                dayNumber += 121;
            } else if (month.equals("June")) {
                dayNumber += 152;
            } else if (month.equals("July")) {
                dayNumber += 182;
            } else if (month.equals("August")) {
                dayNumber += 213;
            } else if (month.equals("September")) {
                dayNumber += 244;
            } else if (month.equals("October")) {
                dayNumber += 274;
            } else if (month.equals("November")) {
                dayNumber += 305;
            } else if (month.equals("December")) {
                dayNumber += 335;
            }
        } else {
            if (month.equals("February")) {
                dayNumber += 31;
            } else if (month.equals("March")) {
                dayNumber += 59;
            } else if (month.equals("April")) {
                dayNumber += 90;
            } else if (month.equals("May")) {
                dayNumber += 120;
            } else if (month.equals("June")) {
                dayNumber += 151;
            } else if (month.equals("July")) {
                dayNumber += 181;
            } else if (month.equals("August")) {
                dayNumber += 212;
            } else if (month.equals("September")) {
                dayNumber += 243;
            } else if (month.equals("October")) {
                dayNumber += 273;
            } else if (month.equals("November")) {
                dayNumber += 304;
            } else if (month.equals("December")) {
                dayNumber += 334;
            }

        }
        //add day
        dayNumber += Integer.valueOf(day);

        return dayNumber;
    }
}
