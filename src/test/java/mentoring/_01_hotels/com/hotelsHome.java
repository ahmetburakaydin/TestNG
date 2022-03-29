package mentoring._01_hotels.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class HomeCheck extends ParentClass {

    String url = "https://www.hotels.com/";
    By searchText = By.cssSelector("input[name='q-destination']");
    By checkInDateButton = By.cssSelector("button._1yFrqc._1ZtnNu");
    By firstCheckInMonth = By.xpath("(//h2[@class='_3LBdi8'])[1]");
    By daysOfCheckInMonth = By.xpath("(//table[@class='HZDuax']//tbody)[1]/tr//button");
    By checkOutDateButton = By.cssSelector("button._1yFrqc._1RdfF-");
    By submitButton = By.cssSelector("button[type='submit']");
    By uzaklıkButton = By.xpath("//button[@aria-label='Uzaklık']");
    By cadde5Button = By.cssSelector("button[value='DISTANCE_FROM_LANDMARK:1693296']");

    public String getCheckInDate(int daysInFromNow) {
        LocalDate localDate = LocalDate.now().plus(Period.ofDays(daysInFromNow));
        Locale tr = new Locale("tr", "TR");
        String date = localDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", tr));
        return date;
    }

    public String getCheckOutDate(int daysOutFromNow) {
        LocalDate localDate = LocalDate.now().plus(Period.ofDays(daysOutFromNow));
        Locale tr = new Locale("tr", "TR");
        String date = localDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", tr));
        return date;
    }
    

    public void checkInOutTime(int daysInFromNow, int daysOutFromNow) {
        String[] arrIn = getCheckInDate(daysInFromNow).split(" ");
        String day = arrIn[0];
        String month = arrIn[1];
        String year = arrIn[2];

        String[] arrOut = getCheckOutDate(daysOutFromNow).split(" ");
        String dayOut = arrOut[0];
        String monthOut = arrOut[1];
        String yearOut = arrOut[2];

        clickTo(checkInDateButton);

        for (int i = 1; i < 18; i++) {
            By monthYearCheckIn = By.xpath("(//h2[@class='_3LBdi8'])[" + i + "]");
            WebElement monthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearCheckIn));

            if (monthYear.getText().contains(month) && monthYear.getText().contains(year)) {
                By daysOfMonth = By.xpath("(//table[@class='HZDuax'])[" + i + "]//td/button");
                List<WebElement> monthDays = driver.findElements(daysOfMonth);
                for (WebElement dayElement : monthDays) {
                    if (dayElement.getText().contains(day)) {
                        clickTo(wait.until(ExpectedConditions.visibilityOf(dayElement)));
                    }
                }
            } else {
                By buttonRightArrowOut = By.xpath("//button[@aria-label='Sonraki']");
                wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRightArrowOut)).click();
            }

            By monthYearCheckInOut = By.xpath("(//h2[@class='_3LBdi8'])[" + i + "]");
            WebElement monthYearOut = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearCheckInOut));
            if (monthYearOut.getText().contains(monthOut) && monthYearOut.getText().contains(yearOut)) {
                By daysOfMonthOut = By.xpath("(//table[@class='HZDuax'])[" + i + "]//td/button");
                List<WebElement> monthDaysOut = driver.findElements(daysOfMonthOut);
                for (WebElement dayElement : monthDaysOut) {
                    if (dayElement.getText().contains(dayOut)) {
                        clickTo(wait.until(ExpectedConditions.visibilityOf(dayElement)));
                    }
                }
                break;
            } else {
                By buttonRightArrow = By.xpath("//button[@aria-label='Sonraki']");
                wait.until(ExpectedConditions.elementToBeClickable(buttonRightArrow)).click();
            }
        }
    }

    public void verifyLeastFiftyOtels() throws InterruptedException {

        for (int i = 1; i < 11; i++) {
            By hotel5x = By.xpath("(//ul[@class='_3f26d2']/li)[" + (i * 5) + "]");
            scrollIntoView(wait.until(ExpectedConditions.visibilityOfElementLocated(hotel5x)));
        }

        By hotelsList = By.cssSelector("ul._3f26d2 >li");
        List<WebElement> hotelList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(hotelsList));

        Assert.assertTrue(hotelList.size() > 50, "There are less than fifty hotels");

        System.out.println("There are more than fifty hotels !! ");
    }

    public void verifyHotelDistance (){

        By hotelDistance5Cadde=By.xpath("//li[contains(text(),'5. Cadde')]");
        List<WebElement> listDistanceTo5Cadde= driver.findElements(hotelDistance5Cadde);
        By hotelDistanceTimesSquare =By.xpath("//li[contains(text(),'Times Square')]");
        List<WebElement> listDistanceToTimeSquare= driver.findElements(hotelDistanceTimesSquare);
        for (int i = 0; i < 50; i++) {
            String[] arrCadde = listDistanceTo5Cadde.get(i).getText().split("-");
            String cadde = arrCadde[1].replaceAll("[^0-9,]","");
            double caddeDistance = Double.parseDouble(cadde.replace(",","."));

            String[] arrTimes = listDistanceToTimeSquare.get(i).getText().split("-");
            String times =arrTimes[1].replaceAll("[^0-9,]","");
            double timesDistance = Double.parseDouble(times.replace(",","."));

             Assert.assertTrue(caddeDistance<5 && timesDistance<5);



        }
        System.out.println("All Hotels distance to Times Square and 5.Street are less than 5 km");


    }


}
