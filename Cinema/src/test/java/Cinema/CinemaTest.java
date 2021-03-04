package Cinema;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CinemaTest {

	private WebDriver driver;
	private JavascriptExecutor js;

	@Before
	public void beforeTest()
	{
		//設定要用什麼瀏覽器來測試
		System.setProperty("webdriver.chrome.driver","src/lib/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		js = (JavascriptExecutor) driver;
	}

	/*//test index's title
	@Test
	public void test1_1_IndexTitle()
	{
		driver.get("http://140.121.197.128:4107/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Cinema - Home"));
	}

	//測試是否拿到所有電影資料
	@Test
	public void test1_2_GetMovieList()
	{
		//拿到變數 movieData 並確認電影資料
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.197.128:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		try {
			//拿到了
			JSONArray movieData = new JSONArray((String)js.executeScript("return JSON.stringify(movieData);"));

			//如果第3筆資料的電影名稱是 "妖貓傳" ，就通過
			Assert.assertTrue(movieData.getJSONObject(3).getString("MovieName").contains("妖貓傳"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//測試購買新電影
	@Test
	public void test1_3_OrderNewMovie() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://140.121.197.128:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();

		//這裡要購買第三部電影 妖貓傳 ID是 : 5c35ddefa3f01c41d8bb4174

		//按電影列表
		driver.findElement(By.xpath("//button[@data-target='#MovieListModal']")).click();
		System.out.println(driver.findElement(By.xpath("//button[@data-target='#MovieListModal']")).getText());

		//等個幾秒 讓電影列表跳出來
		Thread.sleep(3000);

		//按妖貓傳的選擇框框
		driver.findElement(By.xpath("//input[@value='5c35ddefa3f01c41d8bb4174']")).click();
		if(driver.findElement(By.xpath("//input[@name='orderMovie' and @value='5c35ddefa3f01c41d8bb4174']")).isSelected())
			System.out.println("已經選擇了！");
		else
			System.out.println("沒有選擇");
		//等個幾秒 讓按鈕點下去
		Thread.sleep(3000);

		//按下購買Button
		driver.findElement(By.xpath("//button[@id='orderBtn']")).click();;

		//等個幾秒 讓購買loading好
		Thread.sleep(3000);

		//拿到alert訊息
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert訊息 : "+alertText);
		Assert.assertTrue(!alertText.contains("error"));
	}

	//測試看看是否有拿到新訊息
	@Test
	public void test1_4_IndexGetNewNotification()
	{
		driver.get("http://140.121.197.128:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		//確定新訊息數目>0
		int notificationCount;
		try
		{
			notificationCount = Integer.parseInt(driver.findElement(By.xpath("//span[@id='unreadMessage']")).getText());
		}catch (Exception e)
		{
			notificationCount = 0;
		}
		System.out.println("拿到通知數了！ : "+notificationCount);
		//如果拿到的通知數>0 就通過啦
		Assert.assertTrue(notificationCount>0);
	}

	//測試是否可以將訊息設為已讀
	@Test
	public void test1_5_IndexSetNotificationRead() throws InterruptedException
	{
		driver.get("http://140.121.197.128:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		//點擊訊息按鈕
		driver.findElement(By.id("dropdown")).click();
		//等個幾秒 讓點擊工作完成
		Thread.sleep(3000);

		//重新整理並等待loading
		driver.navigate().refresh();
		//等個幾秒 畫面刷新
		Thread.sleep(3000);

		//確定新訊息數目==0
		int notificationCount;
		try
		{
			notificationCount = Integer.parseInt(driver.findElement(By.xpath("//span[@id='unreadMessage']")).getText());
		}catch (Exception e)
		{
			notificationCount = 0;
		}
		System.out.println("拿到通知數了！ : "+notificationCount);
		//如果確定所有訊息都被設定為已讀，就通過啦
		Assert.assertTrue(notificationCount==0);
	}

	//test shop's title
	@Test
	public void test2_1_ShopTitle()
	{
		driver.get("http://140.121.197.128:4107/shop.html");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Cinema - Shop"));
	}

	//測試是否拿到所有周邊資料
	@Test
	public void test2_2_GetGroceryList()
	{
		//拿到變數 movieData 並確認電影資料
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.197.128:4107/shop.html");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		try {
			//拿到了
			JSONArray groceryData = new JSONArray((String)js.executeScript("return JSON.stringify(groceryData);"));
			//如果第3筆資料的電影名稱包含 "高音質低重音" ，就通過
			Assert.assertTrue(groceryData.getJSONObject(3).getString("name").contains("高音質低重音"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//測試購買新周邊
	@Test
	public void test2_3_OrderNewGrocery() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://140.121.197.128:4107/shop.html");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();

		//這裡要購買第三個周邊 重低音耳機 input id是 : quantity3

		//按周邊列表
		driver.findElement(By.xpath("//button[@data-target='#GoodsListModal']")).click();
		//等個幾秒 讓列表跳出來
		Thread.sleep(3000);

		//將重低音耳機的數量設為1
		driver.findElement(By.xpath("//input[@id=\"quantity3\"]")).sendKeys("1");
		//等個幾秒 讓動作完成
		Thread.sleep(3000);

		//按下購買Button
		driver.findElement(By.xpath("//button[@id='orderBtn']")).click();;
		//等個幾秒 讓購買動作完成
		Thread.sleep(3000);

		//拿到alert訊息
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert訊息 : "+alertText);
		Assert.assertTrue(!alertText.contains("error"));
	}

	//測試看看是否有拿到新訊息
	@Test
	public void test2_4_ShopGetNewNotification()
	{
		driver.get("http://140.121.197.128:4107/shop.html");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		//確定新訊息數目>0
		int notificationCount;
		try
		{
			notificationCount = Integer.parseInt(driver.findElement(By.xpath("//span[@id='unreadMessage']")).getText());
		}catch (Exception e)
		{
			notificationCount = 0;
		}
		System.out.println("拿到通知數了！ : "+notificationCount);
		//如果拿到的通知數>0 就通過啦
		Assert.assertTrue(notificationCount>0);
	}

	//測試是否可以將訊息設為已讀
	@Test
	public void test2_5_ShopSetNotificationRead() throws InterruptedException
	{
		driver.get("http://140.121.197.128:4107/shop.html");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		//點擊訊息按鈕
		driver.findElement(By.id("dropdown")).click();
		//等個幾秒 讓點擊工作完成
		Thread.sleep(3000);

		//重新整理並等待loading
		driver.navigate().refresh();
		//等個幾秒 畫面刷新
		Thread.sleep(3000);

		//確定新訊息數目==0
		int notificationCount;
		try
		{
			notificationCount = Integer.parseInt(driver.findElement(By.xpath("//span[@id='unreadMessage']")).getText());
		}catch (Exception e)
		{
			notificationCount = 0;
		}
		System.out.println("拿到通知數了！ : "+notificationCount);
		//如果確定所有訊息都被設定為已讀，就通過啦
		Assert.assertTrue(notificationCount==0);
	}

	//測試是否拿到所有已購買電影資料
	@Test
	public void test1_6_GetMovieOrderedList()
	{
		//拿到變數 orderedListData 並確認電影資料
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.197.128:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		try {
			//拿到了
			JSONArray orderedListData = new JSONArray((String)js.executeScript("return JSON.stringify(orderedListData);"));
			System.out.println((String)js.executeScript("return JSON.stringify(orderedListData);"));
			//如果第3筆資料的電影名稱是 "妖貓傳" ，就通過
			Assert.assertTrue(orderedListData.getJSONObject(orderedListData.length()-1).getString("MovieName").contains("妖貓傳"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//測試是否拿到所有已購買周邊資料
	@Test
	public void test2_6_GetGroceryOrderedList()
	{
		//拿到變數 buyListData 並確認周邊資料
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.197.128:4107/shop.html");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		try {
			//拿到了
			JSONArray buyListData = new JSONArray((String)js.executeScript("return JSON.stringify(buyListData);"));
			System.out.println((String)js.executeScript("return JSON.stringify(buyListData);"));
			//如果第3筆資料的商品名稱包含 "貓耳耳機" ，就通過
			Assert.assertTrue(buyListData.getJSONObject(buyListData.length()-1).getString("name").contains("貓耳耳機"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


	@After
	public void afterTest()
	{
		//結束測試
		driver.quit();
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
					}
				};
		try {
			Thread.sleep(1500);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
}