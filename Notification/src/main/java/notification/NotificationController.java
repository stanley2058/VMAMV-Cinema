package notification;

import com.soselab.vmamvserviceclient.annotation.FeignRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import notification.feign.OrderingInterface;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@Api(value = "NotificationController", tags = "與通知相關的所有一切都在這裡")
@RestController
@Component
public class NotificationController {
	@Autowired
	OrderingInterface orderingInterface;
	
/*
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() 
    {
		return "success";
    }
*/
	
	@ApiOperation(value = "拿到通知", notes = "回傳所有通知")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getNotification", method = RequestMethod.GET)
    public String getNotification(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID)
    {
    	return Notification.getNotification(userID);
    }
	
	@ApiOperation(value = "新增通知", notes = "新增成功就回傳成功")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newNotification", method = RequestMethod.GET)
    public String newNotification(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID,@ApiParam(required = true, name = "content", value = "通知內容") @RequestParam("content") String content)
    {
    	
//    	return Notification.newNotification(userID, content);
		return "success";
    }
	
	@ApiOperation(value = "將通知標為已讀", notes = "標記成功就回傳成功")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "setNotificationRead", method = RequestMethod.GET)
    public String setNotificationRead(@ApiParam(required = true, name = "ID", value = "通知編號") @RequestParam("ID") String ID)
    {
    	Notification.setNotificationRead(ID);
    	return "success";
    }
	
	@ApiOperation(value = "刪除最後一則通知", notes = "刪除成功救回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "deleteNotification", method = RequestMethod.GET)
    public String deleteNotification(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String ID)
    {
		return Notification.deleteNotification(ID);
    }


/*	@FeignRequest(client = OrderingInterface.class, method = "getNotificationInformation", parameterTypes = String.class)
	@ApiOperation(value = "拿資訊", notes = "拿資訊")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getNotificationInformation", method = RequestMethod.GET)
	public String getNotificationInformation(@ApiParam(required = true, name = "userID", value = "使用者編號") @RequestParam("userID") String userID, @ApiParam(required = true, name = "probability", value = "出錯機率") @RequestParam("probability") double probability)
	{
		Random random = new Random();

		int num = random.nextInt(1000) + 1;

		if(num <= (int)(probability * 1000)){
			return orderingInterface.getNotificationInformation(userID);
		}else{
			return "success";
		}
	}*/
}



