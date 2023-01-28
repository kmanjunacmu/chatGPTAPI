package cmu.edu.summarizemail.model;

import org.springframework.stereotype.Component;

@Component
public class InteractRequest {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
