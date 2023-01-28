package cmu.edu.summarizemail.model;

import org.springframework.stereotype.Component;

@Component
public class Summary {
    private String text;
    private String summary;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
