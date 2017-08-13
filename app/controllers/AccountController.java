package controllers;

import models.Account;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import static play.libs.Scala.asScala;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class AccountController extends Controller {

    private final Form<AccountData> form;
    private final Form<AccountTransferData> moneyTransferForm;
    private final List<Account> accounts;
    private final Account moneyTransferInformation = null;

    @Inject
    public AccountController(FormFactory formFactory) {


        this.moneyTransferForm = formFactory.form(AccountTransferData.class);

        this.form = formFactory.form(AccountData.class);
        this.accounts = com.google.common.collect.Lists.newArrayList(
                new Account("user1", 1000),
                new Account("user2", 2000),
                new Account("user3", 3000)
        );
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result listAccounts() {
        List<Account> accounts = this.accounts;
        return ok(Json.toJson(accounts));
    }



    public Result transferMoneyRest(String fAccount, String tAccount, String amount) {
        Account fromAccount = new Account();

        for(Account account: this.accounts) {
            if(account.getAccountName().equalsIgnoreCase(fAccount)) {
                account.setAmmount(account.getAmmount() - Long.valueOf(amount));
            }
        }

        for(Account account: this.accounts) {
            if(account.getAccountName().equalsIgnoreCase(tAccount)) {
                account.setAmmount(account.getAmmount() + Long.valueOf(amount));
            }
        }
        return ok(Json.toJson(this.accounts));
    }


}
