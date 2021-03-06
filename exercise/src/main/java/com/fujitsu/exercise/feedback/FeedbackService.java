package com.fujitsu.exercise.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getFeedback() {
        return feedbackRepository.findAll();
    }

    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

}
