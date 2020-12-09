package com.jaxb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlToObject {
    private static Question question;

    @BeforeAll
    static void setUp() {
        try {
            File file = new File("src/main/resources/question.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            question = (Question) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testQuestionName() {
        System.out.println("testQuestionName");
        System.out.println(question.getId() + " " + question.getQuestionName());
        assertEquals(question.getQuestionName(), "What is java?");
    }

    @Test
    void testAnswersCount() {
        System.out.println("testAnswersCount");
        List<Answer> list = question.getAnswers();
        for (Answer ans : list)
            System.out.println(ans.getId() + " " + ans.getAnswerName() + "  " + ans.getPostedBy());
        System.out.println("Answers count:" + list.size());
        assertEquals(list.size(), 2);
    }

    @Test
    void testFirstAnswer() {
        System.out.println("testFirstAnswer");
        List<Answer> list = question.getAnswers();
        Answer answer = list.get(0);
        System.out.printf("Answer id: %d, name: %s, posted by: %s%n", answer.getId(), answer.getAnswerName(), answer.getPostedBy());
        assertEquals(answer.getAnswerName(), "java is a programming language");
        assertEquals(answer.getId(), 101);
        assertEquals(answer.getPostedBy(), "ravi");
    }
}
