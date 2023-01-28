package cmu.edu.summarizemail.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.stereotype.Service;
import com.theokanning.openai.completion.CompletionRequest;


@Service
public class SummarizerService {
    private static final String API_KEY = "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";
    public String summarize(String str) {

        OpenAiService service = new OpenAiService(API_KEY);
        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("summarize this text: " + str)
                .maxTokens(100)
                .build();

        try {
            CompletionResult response = service.createCompletion(request);
            return response.getChoices().get(0).getText().strip();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String interact(String query, String body) {

        OpenAiService service = new OpenAiService(API_KEY);
        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(query + " : "+ body)
                .maxTokens(100)
                .build();

        try {
            CompletionResult response = service.createCompletion(request);
            return response.getChoices().get(0).getText().strip();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}