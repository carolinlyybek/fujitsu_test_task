package com.fujitsu.exercise.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/feedback")
public class FeedbackController {

    FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getFeedback() {
        return feedbackService.getFeedback();
    }

    @PostMapping()
    public void addNewFeedback(@RequestBody Feedback feedback) {
        feedbackService.addFeedback(feedback);
    }

}
