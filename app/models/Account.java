package models;

public class Account {

    public String accountName;
    public long ammount;

    public Account(String accountName, long ammount) {
        this.accountName = accountName;
        this.ammount = ammount;
    }

    public Account() {}

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAmmount() {
        return ammount;
    }

    public void setAmmount(long ammount) {
        this.ammount = ammount;
    }
}
