package com.globant.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Simple POJO that represents a Transaction.
 */
@Getter
@Setter
public class Transaction {

    private String time;
    private String timeOperation;
    private String amount;
    private User user;
    private String type;
    private String typeOperation;
    private String message;
    private String bank;
    private String account;
    private String reactionRejectCharge;
}
