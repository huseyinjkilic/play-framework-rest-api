package controllers;

import play.data.validation.Constraints;

public class AccountTransferData {
    @Constraints.Required
    private String fromAccount;

    @Constraints.Required
    private String toAccount;

    @Constraints.Required
    @Constraints.Min(0)
    private long ammount;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public long getAmmount() {
        return ammount;
    }

    public void setAmmount(long ammount) {
        this.ammount = ammount;
    }

    public AccountTransferData() {

    }

}
