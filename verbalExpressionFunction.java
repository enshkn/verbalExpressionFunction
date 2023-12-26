import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeProcessor {

    public static void processData(String timeType, String timeExpression, Date dateStart, Date... optionalDateEnd, String... startSeason, String... endSeason, String... startDecade, String... endDecade, String... startYear, String... endYear, String... startMonth, String... endMonth, String... startDay, String... endDay, String... startMoment, String... endMoment) {
        String verbalExpression = "";

        // parse dateStart here with month day, year, hour, minute
        String momentStart = dateStart.getYear() + dateStart.getMonth() + dateStart.getDay() + dateStart.getHour() + dateStart.getMinute();
        String momentEnd = dateEnd.getYear() + dateEnd.getMonth() + dateEnd.getDay() + dateEnd.getHour() + dateEnd.getMinute();
        String dayStart = dateStart.getYear() + dateStart.getMonth() + dateStart.getDay();
        String dayEnd = dateEnd.getYear() + dateEnd.getMonth() + dateEnd.getDay();
        String year = dateStart.getYear();
        String yearEnd = dateEnd.getYear();
        String month = dateStart.getMonth();
        String monthEnd = dateEnd.getMonth();
        String day = dateStart.getDay();
        String hour = dateStart.getHour();
        String minute = dateStart.getMinute();
        String startSeason = "";
        String endSeason = "";
        String startDecade = "";
        String endDecade = "";


        SimpleDateFormat dateFormatDay = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormatMoment = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        switch (timeType) {
            case "timePoint":
                switch (timeExpression) {
                    case "moment":
                        verbalExpression = "At The moment " + momentStart + ".";
                        break;
                    case "day":
                        verbalExpression = "On The Day " + dayStart + ".";
                        break;
                    case "month":
                        verbalExpression = "On The Month " + month + "of the year " + year + ".";
                        break;
                    case "year":
                        verbalExpression = "On The Year of " + year + ".";
                        break;
                    case "decade":
                        verbalExpression = "In The Decade of " + decade + ".";
                        break;
                    case "season":
                        verbalExpression = "On The Season of " + startSeason " of the year " + year +;
                        break;
                    case "decade+season":
                        verbalExpression = "On The " + season + " of the decade " + decade + ".";
                        break;
                    default:
                        System.out.println("Invalid timeExpression value: " + timeExpression);
                        break;
                }
                break;
            case "timeInterval":
                switch (timeExpression) {
                    case "moment":
                        if (dateEnd != null) {
                            verbalExpression = "Between " + momentStart + " and " +
                                    momentEnd + ".";
                        break;
                    case "day":
                        if (dateEnd != null) {
                            verbalExpression = "Between " + dayStart + " and " +
                                    dayEnd+ ".";
                        break;
                    case "month":
                        verbalExpression = "Between the" + month  + " of " + year + " and " + monthEnd + " of " + yearEnd + ".";
                        break;
                    case "year":
                        verbalExpression = "Between the year of " + year + " and " + yearEnd + ".";
                        break;
                    case "decade":
                        verbalExpression = "Between " + startDecade + " and " + endDecade + ".";
                        break;
                    case "season":
                        verbalExpression = "Between " + startSeason + " of the year " + year + " and the " endSeason + "of the year " + yearEnd + ".";
                        break;
                    case "decade+season":
                        verbalExpression = "Between the "+ season + " of "+ startDecade + " and " + endSeason+ " of "+ endDecade  + ".";
                        break;
                    default:
                        System.out.println("Invalid timeExpression value: " + timeExpression);
                        break;
                }
                break;
            default:
                System.out.println("Invalid timeType value: " + timeType);
                break;
        }
        System.out.println(verbalExpression);
    }
}
