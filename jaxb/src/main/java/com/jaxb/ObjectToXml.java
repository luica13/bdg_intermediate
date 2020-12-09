package com.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ObjectToXml {
    public static void main(String[] args) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(Question.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Answer ans1 = new Answer(101, "To be", "Poghos");
        Answer ans2 = new Answer(102, "Not to be", "Petros");

        ArrayList<Answer> list = new ArrayList<Answer>();
        list.add(ans1);
        list.add(ans2);

        Question que = new Question(1, "To be or not to be", list);
        //TODO change absolute path
        File file = new File("/home/aabrahamyan/Trainning projects/BdgTrainning/bdg_intermediate/jaxb/src/main/resources/test.xml");
        marshallerObj.marshal(que, new FileOutputStream(file));
    }
}
