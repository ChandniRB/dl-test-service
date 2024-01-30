package demo.dl;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import demo.model.ApiResponse;
import demo.util.CommonUtil;
import demo.util.Constants;

import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

@Service
public class DLTestServiceImpl implements DLTestService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(DLTestServiceImpl.class);

    @Autowired
    DLService dlService;

    private KafkaProducer kafkaProducer;

    public DLTestServiceImpl(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public ApiResponse checkSlot(Map<String, Object> requestBody)
            throws IOException, InterruptedException {
        logger.info(String.format("\n\n\nCalling DL Test Service API: /dl/slot/check\n\n\n"));
        ApiResponse response = CommonUtil.createResponse(Constants.API_SLOT_CHECK);
        
        // TO-DO: Logic to check slot availability

        logger.info(String.format("\n\n\nSlot available for selected Date and slot\n\n\n"));

        response.setResponseCode(HttpStatus.OK);

        return response;

    }

    @Override
    public ApiResponse submitResult(DLResultModel request)
            throws IOException, ParseException, InterruptedException, java.text.ParseException {

                logger.info(String.format("\n\n\nCalling DL Test Service API: /dl/result/submit\n\n\n"));
        
        ApiResponse response = CommonUtil.createResponse(Constants.API_SUBMIT_RESULT);

        String testStatus = request.getTest_status();

        if (testStatus.equalsIgnoreCase("Passed")) {
            String message = new ObjectMapper().writeValueAsString(request);

            kafkaProducer.sendMessage(message);
            response.setResponseCode(HttpStatus.OK);
            response.getParams().setMsgid(request.getApplicationid().toString());

        }
        return response;

    }

}
