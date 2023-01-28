package cmu.edu.summarizemail.controller;

import cmu.edu.summarizemail.model.InteractRequest;
import cmu.edu.summarizemail.model.InteractResponse;
import cmu.edu.summarizemail.model.Summary;
import cmu.edu.summarizemail.service.SummarizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    SummarizerService myService;

    @Autowired
    InteractResponse response;

    @Autowired
    Summary summary;
    @RequestMapping(value = "/summarize", method = RequestMethod.GET)
    public ResponseEntity<Summary> getString(@RequestParam(value="text") String str) {
        String summaryText = myService.summarize(str);
        summary.setText(str);
        summary.setSummary(summaryText);

        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @RequestMapping(value = "/interact", method = RequestMethod.POST)
    public ResponseEntity<InteractResponse> getResponse(@RequestParam(value="text") String str,
                                               @RequestBody InteractRequest requestBody) {
        String responseText = myService.interact(str, requestBody.getText());
        response.setInput(requestBody.getText());
        response.setOutput(responseText);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> getGreeting() {

        String jsonResponse = "{\nI'm Alive!\n}";

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
