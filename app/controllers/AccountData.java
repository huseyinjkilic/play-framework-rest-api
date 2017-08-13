package controllers;

import play.data.validation.Constraints;

public class AccountData {

    @Constraints.Required
    private String account;


    @Constraints.Required
    @Constraints.Min(0)
    private long ammount;

    public AccountData() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getAmmount() {
        return ammount;
    }

    public void setAmmount(long ammount) {
        this.ammount = ammount;
    }
}
