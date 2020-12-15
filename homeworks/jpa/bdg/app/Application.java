package com.bdg.app;

import com.bdg.jpaController.JpaController;
import com.bdg.model.Company;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        JpaController controller = new JpaController();
        Company company = new Company("David", LocalDate.parse("1990-09-09"));
        controller.save(company);
        controller.delete(5L);
        controller.getById(15);

    }
}