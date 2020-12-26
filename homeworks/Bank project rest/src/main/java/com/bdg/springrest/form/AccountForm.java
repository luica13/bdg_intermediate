package com.bdg.springrest.form;

import com.bdg.springrest.models.Transaction;
import com.bdg.springrest.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountForm {
    private double balance;
    private String createDate;
    private Transaction transaction;
    private Long id;
}
