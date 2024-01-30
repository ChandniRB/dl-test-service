package demo.dl;

import java.io.IOException;
import java.util.Map;
import org.json.simple.parser.ParseException;
import demo.model.ApiResponse;

public interface DLTestService {
    
    
    ApiResponse checkSlot(Map<String, Object> request) throws IOException, ParseException, InterruptedException;

    ApiResponse submitResult(DLResultModel request) throws  IOException, ParseException, InterruptedException, java.text.ParseException;

}
