package ch.hearc.ig.odi.customeraccount.business;

public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public Account(String number, String name, double rate, Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    /**
     *
     * @param amount
     */
    public void credit(double amount) {
        this.balance = this.balance + amount;
    }

    /**
     *
     * @param amount
     */
    public void debit(double amount) {
        if ((this.balance - amount) >= 0) {
            this.balance = this.balance - amount;
        } else {
            throw new IllegalStateException("Le solde du compte est insuffisant pour effectuer cette transaction");
        }
    }

    /**
     *
     * @param amount
     * @param source
     * @param target
     */
    public static void transfer(double amount, Account source, Account target) {
        source.debit(amount);
        target.credit(amount);
    }
    
    
    //Méthode toString()
    public String accToString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n");
        sb.append("Account N°");
        sb.append(this.number);
        sb.append("     ");
        sb.append("Name : ");
        sb.append(this.name);
        sb.append("    Solde: ");
        sb.append(this.balance);

        return sb.toString();
    }

}
