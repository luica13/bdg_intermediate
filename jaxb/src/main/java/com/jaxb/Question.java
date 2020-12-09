package com.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Question {
    private int id;
    private String questionName;
    private List<Answer> answers;

    public Question() {
    }

    public Question(int id, String questionName, List<Answer> answers) {
        super();
        this.id = id;
        this.questionName = questionName;
        this.answers = answers;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionname) {
        this.questionName = questionname;
    }

    @XmlElement
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}