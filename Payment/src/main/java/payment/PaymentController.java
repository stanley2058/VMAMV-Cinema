package payment;

import com.soselab.vmamvserviceclient.annotation.FeignRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payment.feign.OrderingInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Api(value = "PaymentController", tags = "與付錢相關的所有一切都在這裡")
@RestController
public class PaymentController {

	@Autowired
	OrderingInterface orderingInterface;

//	@Autowired
//	private AmqpTemplate rabbitTemplate;
//	@Autowired
//	private FanoutExchange fanout; // configured in RabbitConfig


	
	@ApiOperation(value = "購買物品", notes = "成功購買就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "payment", method = RequestMethod.GET)
    public String payment(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID, @ApiParam(required = true, name = "price", value = "付款金額")@RequestParam("price") String price)
    {
/*	    int temp = Integer.parseInt(userID);
		return temp % 2 == 1 ? "success" : "fail";*/
    	return "success";
    }

/*	@FeignRequest(client = OrderingInterface.class, method = "getPaymentInformation", parameterTypes = String.class)
	@ApiOperation(value = "拿資訊", notes = "拿資訊")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getPaymentInformation", method = RequestMethod.GET)
	public String getPaymentInformation(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID, @ApiParam(required = true, name = "probability", value = "出錯機率") @RequestParam("probability") double probability)
	{
		Random random = new Random();

		int num = random.nextInt(1000) + 1;

		if(num <= (int)(probability * 1000)){
			return orderingInterface.getPaymentInformation(userID);
		}else{
			return "success";
		}


	}*/
	
	
}



