package Task23;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Facebook {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Navigate to Facebook
	            driver.get("https://www.facebook.com/");
	            Thread.sleep(2000);
	            driver.manage().window().maximize();

	            // Step 2: Verify that the website has been redirected to the FB homepage
	            String pageTitle = driver.getTitle();
	            if (pageTitle.equals("Facebook – log in or sign up")) {
	                System.out.println("Navigated to Facebook homepage successfully.");
	            } else {
	                System.out.println("Failed to navigate to Facebook homepage.");
	                return;
	            }

	            // Step 3: Click on the "Create New Account" button
	            WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
	            createAccountButton.click();

	            // Step 4: Fill out the registration form
	            Thread.sleep(2000); // Wait for the sign-up form to load

	            // Enter First Name
	            driver.findElement(By.name("firstname")).sendKeys("Test");

	            // Enter Last Name
	            driver.findElement(By.name("lastname")).sendKeys("User");

	            // Step 5: Select Date of Birth
	            Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
	            daySelect.selectByValue("11"); // Day

	            Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
	            monthSelect.selectByVisibleText("May"); // Month

	            Select yearSelect = new Select(driver.findElement(By.name("birthday_year")));
	            yearSelect.selectByValue("1990"); // Year

	            // Step 6: Select Gender
	            driver.findElement(By.xpath("//label[contains(text(),'Male')]//input")).click(); // Select Male

	            // Enter Email Address
	            driver.findElement(By.name("reg_email__")).sendKeys("testpage@gmail.com");

	            // Enter Password
	            driver.findElement(By.name("reg_passwd__")).sendKeys("Test@12345678");
	            
	            // Step 7: Click on the Sign Up button
	            driver.findElement(By.name("websubmit")).click();

	            // Wait for some time to ensure the registration process completes
	            Thread.sleep(5000);

	            // Step 8: Verify successful registration
	            // Check if the user is redirected to the homepage after sign-up
	            if (driver.getCurrentUrl().contains("facebook.com")) {
	                System.out.println("User is successfully registered and redirected to the Facebook homepage.");
	            } else {
	                System.out.println("Registration failed or user is not redirected properly.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}

