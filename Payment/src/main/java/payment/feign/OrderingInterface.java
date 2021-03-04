package payment.feign;

import com.soselab.vmamvserviceclient.annotation.TargetVersion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Assign service version to VMAMVS (unforce)
//@TargetVersion("service version")
@FeignClient("ordering")
@TargetVersion("0.0.1-SNAPSHOT")
public interface OrderingInterface {

/*    @RequestMapping(value = "/getPaymentInformation", method = RequestMethod.GET)
    String getPaymentInformation(@RequestParam("userID") String userID);*/

}
