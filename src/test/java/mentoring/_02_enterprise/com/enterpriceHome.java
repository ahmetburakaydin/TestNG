package mentoring._02_enterprise.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class enterpriceHome extends ParentClass {

    String urlEnterPrice = "https://www.enterprise.com/en/home.html";

    By noStayHereButton = By.xpath("//button[text()='No, Stay Here']");
    By pickUpLocationArea = By.cssSelector("input#pickupLocationTextBox");
    By pickUpDate = By.cssSelector("button#pickupCalendarFocusable");
    By returnDate = By.cssSelector("button#dropoffCalendarFocusable");
    By vehicleClassButton = By.cssSelector("button[name='vehicle-filters-trigger']");
    By fullSizeCarRadioButton = By.xpath("//label[@for='Cars-105-select']");
    By applyFilterButton = By.xpath("//button[text()='Apply Filter']");
    By checkAvailabiltyButton = By.xpath("//button[text()='Check Availability']");
    By passengers7plusButton = By.cssSelector("[data-dtm-tracking='car_filters|7|unchecked']");
    By vehichlePassengerFeature = By.xpath("//ul[@class='vehicle-item__attributes']/li[contains(text(),'People')]");
    By vehicleSelectButton = By.xpath("//button[text()='Select']");
    public void goToUrl() {
        driver.get(urlEnterPrice);
        clickTo(wait.until(ExpectedConditions.visibilityOfElementLocated(noStayHereButton)));
    }

    public void sendKeysPickUpLocation(String text) {
        sendKeysTo(pickUpLocationArea, text);
        Actions builder = new Actions(driver);
        builder.pause(1000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public String getPickUpDate(int daysInFromNow) {
        LocalDate localDate = LocalDate.now().plus(Period.ofDays(daysInFromNow));
        Locale tr = new Locale("en", "EN");
        String date = localDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", tr));
        return date;
    }

    public String getDropOffDate(int daysInFromNow) {
        LocalDate localDate = LocalDate.now().plus(Period.ofDays(daysInFromNow));
        Locale tr = new Locale("en", "EN");
        String date = localDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy", tr));
        return date;
    }

    public String getDayFromDate(int daysOutFromNow) {  // gün içersinden sadece günü String olarak alma
        LocalDate localDate = LocalDate.now().plus(Period.ofDays(daysOutFromNow));
        Locale en = new Locale("en", "EN");
        String date = localDate.format(DateTimeFormatter.ofPattern("MM/d/yyyy", en));
        String[] dateArr = date.split("/");

        return dateArr[1];
    }


    public void choosePickUpDate(int pickUpDayFromNow, int returnDayFromNow) {
        for (int i = 1; i < 24; i++) {  // Her Biri 1 Ay için Muhtemel 24 kontrol, değiştirilebilir

            String[] arrIn = getPickUpDate(pickUpDayFromNow).split(" ");
            String day = arrIn[0];
            String month = arrIn[1];
            String year = arrIn[2];

            clickTo(pickUpDate);

            By monthYearPickUp = By.xpath("(//span[@class='calendar-control-header'])[1]");
            WebElement monthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearPickUp));

            if (monthYear.getText().contains(month) && monthYear.getText().contains(year)) {
                By daysOfMonth = By.xpath("(//table[@class='calendar-grid'])[1]/tbody//button");
                List<WebElement> monthDays = driver.findElements(daysOfMonth);
                for (WebElement dayElement : monthDays) {
                    if (dayElement.getText().contains(getDayFromDate(pickUpDayFromNow))) {
                        clickTo(wait.until(ExpectedConditions.visibilityOf(dayElement)));
                        break;
                    }
                }
            } else {
                By nextMonthButton = By.xpath("(//button[@aria-label='Next Month'])[2]");
                clickTo(nextMonthButton);
                System.out.println(i + " . döngü 1. else içi");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clickTo(returnDate);
            String[] arrOff = getDropOffDate(returnDayFromNow).split(" ");
            String dayOff = arrOff[0];
            String monthOff = arrOff[1];
            String yearOff = arrOff[2];

            By monthYearDropOff = By.xpath("(//span[@class='calendar-control-header'])[1]");
            WebElement monthYearReturnDate = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearDropOff));

            if (monthYearReturnDate.getText().contains(monthOff) && monthYearReturnDate.getText().contains(yearOff)) {
                By daysOfMonth = By.xpath("(//table[@class='calendar-grid'])[1]/tbody//button");
                List<WebElement> monthDays = driver.findElements(daysOfMonth);

                for (WebElement dayElement : monthDays) {
                    if (dayElement.getText().contains(getDayFromDate(returnDayFromNow))) {
                        clickTo(wait.until(ExpectedConditions.visibilityOf(dayElement)));

                        break;
                    }
                }
                break;
            } else {
                By nextMonthButton = By.xpath("(//button[@aria-label='Next Month'])[2]");
                clickTo(nextMonthButton);
            }
        }
    }

    public void chooseVehicleClass() {
        clickTo(vehicleClassButton);
        clickableTo(fullSizeCarRadioButton);
        clickTo(applyFilterButton);
        clickTo(checkAvailabiltyButton);
    }

    public void justifyNumberOfPassenger() {

        clickTo(passengers7plusButton);

        List<WebElement> listOfVehiclePassenger = driver.findElements(vehichlePassengerFeature);

        List<WebElement> listOfSelectButton=driver.findElements(vehicleSelectButton);

        for (int j = 0; j <listOfSelectButton.size() ; j++) {  // aktif select buttonu kadar işlem yapsın
            String num = listOfVehiclePassenger.get(j).getText().replaceAll("[^0-9]","");
            int intNum = Integer.parseInt(num);
            Assert.assertTrue(intNum>=7);
        }

    }

}
