package Step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Predicate;

public class Task_1 {
    private static int balance = 0;
    private static int withdrawable_amount;

    private static boolean canWithdraw() {

        return (withdrawable_amount <= balance) ? true : false;


    }

    private static int amountDispenser(int withdrawable_amount) {

        balance=balance - withdrawable_amount;
        return balance;
    }

    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_$_in_my_account(int amount) {
        balance=amount;
        Assert.assertEquals(balance, amount);

    }

    @When("I request ${int}")
    public static void i_request(int withdrawing_amount) {
        withdrawable_amount = withdrawing_amount;
        Assert.assertEquals(canWithdraw(), true,"you cannot withdraw as balance is low");



    }

    @Then("${int} should be dispensed")
    public static void Should_be_dispensed(int dispensed_amount) {
        if(withdrawable_amount==dispensed_amount){
        Assert.assertEquals(amountDispenser(dispensed_amount),balance);
        }
        else {
            Assert.assertFalse(true,"amount cannot be withdraw as it does not matches requested amount");
        }

    }
}
