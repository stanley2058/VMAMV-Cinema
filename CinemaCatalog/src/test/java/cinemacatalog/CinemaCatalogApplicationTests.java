package cinemacatalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaCatalogApplicationTests {

	@Autowired
	CinemaCatalogController cinemaCatalogController;


	@Test
	public void testIndex()
	{
		//assertEquals( cinemaCatalogController.index(), "success");
	}
/*
	@Test
	public void contextLoads() {
	}
*/

/*
	public boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			// edited, to include @Arthur's comment
			// e.g. in case JSONArray is valid as well...
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}
*/
}

