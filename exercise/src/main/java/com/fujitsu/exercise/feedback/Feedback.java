package com.fujitsu.exercise.feedback;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table
public class Feedback {
    @Id
    @SequenceGenerator(
            name="feedback_sequence",
            sequenceName = "feedback_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feedback_sequence"
    )
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Text is mandatory")
    private String text;

    @ElementCollection
    @NotEmpty(message = "Category is mandatory")
    private List<String> category;

    public Feedback() {
    }

    public Feedback(long id, String name, String email, String text, List<String> category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
        this.category = category;
    }


    public Feedback(String name, String email, String text, List<String> category) {
        this.name = name;
        this.email = email;
        this.text = text;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    public List<String> getCategory() {
        return category;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                '}';
    }
}
