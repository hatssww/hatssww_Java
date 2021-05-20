public class BankAccount {
    private int balance;
    private Person owner;

    public BankAccount(int pBalance) {
        if (pBalance < 0) {
            balance = 0;
        } else {
            balance = pBalance;
        }
    }

    public BankAccount(Person owner) {
        this.owner = owner;
        owner.setAccount(this);
        balance = 0;
    }

    public BankAccount(int pBalance, Person owner) {
        this.owner = owner;
        owner.setAccount(this);
        if (pBalance < 0) {
            balance = 0;
        } else {
            balance = pBalance;
        }
    }

    public void setBalance(int newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setOwner(Person newOwner) {
        owner = newOwner;
    }

    public Person getOwner() {
        return owner;
    }


    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    public boolean deposit(int amount) {
        if (amount < 0 || owner.getCashAmount() < amount) {
            System.out.println("입금 실패입니다. 잔고: " + getBalance() + "원, 현금: " + owner.getCashAmount() + "원");
            return false;
        }
        owner.setCashAmount(owner.getCashAmount() - amount);
        setBalance(getBalance() + amount);
        System.out.println(amount + "원 입금하였습니다. 잔고: " + getBalance() + "원, 현금: " + owner.getCashAmount() + "원");
        return true;
    }

    public boolean deposit(double amount, double exchangeRate) {
        return deposit((int) (amount * exchangeRate));
    }


    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    public boolean withdraw(int amount) {
        if (amount < 0 || getBalance() < amount) {
            System.out.println("출금 실패입니다. 잔고: " + getBalance() + "원, 현금: " + owner.getCashAmount() + "원");
            return false;
        }
        setBalance(getBalance() - amount);
        owner.setCashAmount(owner.getCashAmount() + amount);
        System.out.println(amount + "원 출금하였습니다. 잔고: " + getBalance() + "원, 현금: " + owner.getCashAmount() + "원");
        return true;
    }


    // 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(BankAccount to, int amount) {
        boolean success;

        if (amount < 0 || balance < amount) {
            success = false;
        } else {
            balance -= amount;
            to.balance += amount;
            success = true;
        }

        System.out.println(success + " - from: " + owner.getName()
                + ", to: " + to.owner.getName()
                + ", amount: " + amount
                + ", balance: " + balance);
        return success;
    }


    // 첫 번째 파라미터: 받는 사람 (Person)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(Person to, int amount) {
        return transfer(to.getAccount(), amount);
    }
}