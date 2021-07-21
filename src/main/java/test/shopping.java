package test;


import methods.buys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class shopping {
    static String url = " http://automationpractice.com/index.php";
    static By imageProduct = By.xpath("//img[@src='http://automationpractice.com/img/p/1/1-home_default.jpg']");
    static By imageProduct2 = By.xpath("//img[@src= 'http://automationpractice.com/img/p/1/1-small_default.jpg']");
    static By addToCart = By.cssSelector("a[class='button ajax_add_to_cart_button btn btn-default']");
    static By confirmproduct = By.tagName("h2");
    static By keepbuying = By.cssSelector("i[class = 'icon-chevron-left left']");
    static By shoppingCart = By.cssSelector("a[title= 'View my shopping cart']");
    static By deleteProduct = By.cssSelector("a[title='Delete']");

    private static WebDriver driver;
    static buys compras;

    public static void main(String[] arg) throws InterruptedException {

        compras = new buys(driver);
        //open browser
        driver = compras.chromeDiverConnection();
        driver.manage().window().maximize();
        //URL
        compras.visit(url);
        //Scroll Dowm
        compras.scroll(600);
        //wait
        compras.fluentwait(imageProduct, 10,2);
        //hover Image
        compras.hoverImage(imageProduct,0);
        // List button
        compras.otherClick(addToCart,0);
        //confirmBuy
        compras.confirmtext(confirmproduct,0);
        //click keep buying
        compras.darClick(keepbuying);
        //Scroll up
        compras.scroll(-600);
        //shopping Cart
        compras.darClick(shoppingCart);
        //Scroll Dowm
        compras.scroll(200);
        //click delete product
        compras.darClick(deleteProduct);
        //close browser
        Thread.sleep(3000);
        driver.quit();




        
    }
    
    
    
    
}
