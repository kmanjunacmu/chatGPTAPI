package cmu.edu.summarizemail.model;

import org.springframework.stereotype.Component;

@Component
public class InteractResponse {
    String input;
    String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
