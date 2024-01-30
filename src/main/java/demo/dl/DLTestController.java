package demo.dl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import demo.model.ApiResponse;
import demo.util.CommonUtil;
import demo.util.Constants;

@Controller
@RequestMapping("/dl")
public class DLTestController {

    @Autowired
    DLTestService dlTestService;

    @PostMapping(value = "/slot/check")
    public ResponseEntity<?> applyDL(@RequestBody Map<String, Object> request) throws Exception {

        ApiResponse response = CommonUtil.createResponse(Constants.API_SLOT_CHECK);
        response = dlTestService.checkSlot(request);
        return new ResponseEntity<>(response, response.getResponseCode());
    }

    @GetMapping(value = "/result/submit")
    public String resultSubmitForm(Model model) {
        model.addAttribute("dlResultModel", new DLResultModel());
        return "testResultForm";
    }

    
    // @PostMapping(value = "/result/submit")
    // public ResponseEntity<?> submitResult(@RequestBody Map<String, Object> request) throws Exception {

    //     ApiResponse response = CommonUtil.createResponse(Constants.API_SUBMIT_RESULT);
    //     response = dlTestService.submitResult(request);
    //     return new ResponseEntity<>(response, response.getResponseCode());
    // }

    @PostMapping(value = "/result/submit")
    public String submitResult(@ModelAttribute DLResultModel dlResultModel, Model model) throws Exception {

        ApiResponse response = CommonUtil.createResponse(Constants.API_SUBMIT_RESULT);
        response = dlTestService.submitResult(dlResultModel);
        model.addAttribute("applicationId", response.getParams().getMsgid());
    
        return "testResultSubmitted";
    }

}
