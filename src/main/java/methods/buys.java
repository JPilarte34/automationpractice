package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class buys {
    private WebDriver driver;



    public buys(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDiverConnection(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jesus Pilarte\\Desktop\\proyecto inteliJ\\src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement finElement(By locator){
        return driver.findElement(locator);

    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void visit(String url){
        driver.get(url);
    }

    public void scroll(int down){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+down+")", "");
    }

    public void fluentwait(By obj, int timeLimit, int duration){

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(timeLimit, TimeUnit.SECONDS)
                .pollingEvery(duration,TimeUnit.SECONDS)
                .ignoring(NoSuchFieldException.class);
        WebElement imagen = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(obj);
            }
        });
        assertTrue(driver.findElement(obj).isDisplayed());
    }

    public  void hoverImage(By obj, int indexImage){
        List<WebElement> image = driver.findElements(obj);
        Actions action1 = new Actions(driver);
        action1.moveToElement(image.get(indexImage)).perform();
    }

    public void otherClick(By obj, int position) throws InterruptedException {
        List<WebElement> btn = driver.findElements(obj);
        for (int i=0; i < btn.size(); i++) {
            System.out.println(btn);
            if(i == position) {
                btn.get(i).click();
                Thread.sleep(5000);
            }

        }
    }

    public void confirmtext(By obj, int index){
        List<WebElement> lista = driver.findElements(obj);
        assertEquals("Product successfully added to your shopping cart", lista.get(index).getText());
    }

    public void darClick(By obj) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(obj).click();
    }


}
