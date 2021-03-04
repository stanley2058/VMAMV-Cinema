/*
package cinemacatalog;

import com.google.common.collect.Ordering;
import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.logging.Logger;

@Repository
public class CustomTraceRepository extends InMemoryTraceRepository {
	
	private static Logger logger = Logger.getLogger(Ordering.class.getName());
	
    public CustomTraceRepository() {
        super.setCapacity(1000);
    }

    @Override
    public void add(Map<String, Object> map) {
        super.add(map);
        
        
        logger.info("traced object: " + map);
    }
}
*/
