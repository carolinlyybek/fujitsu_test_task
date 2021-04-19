package com.fujitsu.exercise;

import com.fujitsu.exercise.feedback.Feedback;
import com.fujitsu.exercise.feedback.FeedbackController;
import com.fujitsu.exercise.feedback.FeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    FeedbackController feedbackController;

    @MockBean
    FeedbackService feedbackService;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Source: https://www.baeldung.com/spring-boot-bean-validation
     */
    @Test
    public void whenPostRequestAndValid_thenCorrectResponse() throws Exception {
        String feedback = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\", \"text\": \"test\", \"category\": [\"test\"]}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/feedback")
                .content(feedback)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenPostRequestAndInValid_thenCorrectResponse() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Feedback test = new Feedback("", "", "", new ArrayList<>());
        Set<ConstraintViolation<Feedback>> violations = validator.validate(test);
        assertFalse(violations.isEmpty());
    }
}