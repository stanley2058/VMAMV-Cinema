package ordering.controller;

import com.soselab.vmamvserviceclient.annotation.FeignRequest;
import com.soselab.vmamvserviceclient.annotation.FeignRequests;
import com.soselab.vmamvserviceclient.service.ContractAnalyzer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ordering.Ordering;
import ordering.feign.NotificationInterface;
import ordering.feign.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;


@Api(value = "OrderingController", tags = "與購買相關的電影與雜物都在這裡")
@RestController
public class OrderingController {

	@Autowired
	PaymentInterface paymentInterface;

	@Autowired
	NotificationInterface notificationInterface;





	@Value("${server.port}")
	String port;
	/*@RequestMapping(value="/hi", method = RequestMethod.GET)
	public String home(@RequestParam("name") String name) throws IOException {
		return "hi " + name + ", I am from port: " + port;
	}*/

/*	@RequestMapping(value="/validate/prime-number", method = RequestMethod.GET)
	public String isNumberPrime(@RequestParam("number") Integer number) {
		return number % 2 == 0 ? "Even" : "Odd";
	}*/

/*	@RequestMapping(value="/simulateError", method = RequestMethod.GET)
	public String isNumberPrimeFromPayment(@RequestParam("number") Integer number) {
		return paymentInterface.checkOddAndEvenFromPayment(number);
	}*/

	
/*	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String index()
    {
		return "success";
    }*/

	@FeignRequests(value = {@FeignRequest(client = PaymentInterface.class, method = "payment", parameterTypes = {String.class, String.class}), @FeignRequest(client = NotificationInterface.class, method = "newNotification", parameterTypes = {String.class, String.class})})
	@ApiOperation(value = "將購買電影加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newMovieOrdering(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID, @ApiParam(required = true, name = "moviesID", value = "電影編號")@RequestParam("moviesID") String moviesID)
    {
		try {
			if ((Ordering.newMovieOrdering(moviesID)).equals("success"))
				if ((paymentInterface.payment(userID, "250")).equals("success"))
					if ((notificationInterface.newNotification(userID, URLEncoder.encode("ordering Movies Successfully", "UTF-8"))).equals("success"))
						return "success";
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}

		return "fail";
    }

    @FeignRequests(value = {@FeignRequest(client = PaymentInterface.class, method = "payment", parameterTypes = {String.class, String.class}), @FeignRequest(client = NotificationInterface.class, method = "newNotification", parameterTypes = {String.class, String.class})})
	@ApiOperation(value = "將購買的周邊商品加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newGroceryOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID, @ApiParam(required = true, name = "groceryID", value = "物品編號")@RequestParam("groceryID") String groceryID, @ApiParam(required = true, name = "quantity", value = "物品編號")@RequestParam("quantity") String quantity)
    {
		try {
			if ((Ordering.newGroceryOrdering(groceryID, quantity)).equals("success")) {
				if ((notificationInterface.newNotification(userID, URLEncoder.encode("ordering Grocery successfully", "UTF-8"))).equals("success")) {
					if ((paymentInterface.payment(userID, "250")).equals("success")) {
						return "success";
					} else {
						for(int i = 0;i < 2;i++){
							System.out.println("6 / " + i + " = " + 6/i);
						}
					}
				}
			}
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return "fail";
    }
	
	@ApiOperation(value = "透過userID得到已購買電影的ID", notes = "回傳已購買電影ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getMovieFromOrderList", method = RequestMethod.GET)
    public String getMovieFromOrderList(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID)
    {
    	return Ordering.getMovieFromOrderList(userID);
    }
	
	@ApiOperation(value = "透過userID得到已購買周邊的ID", notes = "回傳已購買周邊ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getGroceryFromOrderList", method = RequestMethod.GET)
    public String getGroceryFromOrderList(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID)
    {
    	return Ordering.getGroceryFromOrderList(userID);
    }


/*	@FeignRequest(client = NotificationInterface.class, method = "getOrderingInformation", parameterTypes = String.class)
	@ApiOperation(value = "拿資訊", notes = "拿資訊")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getOrderingInformation", method = RequestMethod.GET)
	public String getOrderingInformation(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID, @ApiParam(required = true, name = "probability", value = "出錯機率") @RequestParam("probability") double probability)
	{

		Random random = new Random();

		int num = random.nextInt(1000) + 1;

		if(num <= (int)(probability * 1000)){
			return notificationInterface.getOrderingInformation(userID);
		}else{
			return "success";
		}




	}*/
	
}
