package payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTest {




    @Autowired
    PaymentController paymentController;

    @Test
    public void testIndex()
    {
        //assertEquals( paymentController.index(), "success");
    }

    @Test
    public void testPayment()
    {
        assertEquals( paymentController.payment("1","250"), "success");
    }

}