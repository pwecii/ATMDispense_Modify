public class Peso100Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {

        if (cur.getAmount() >= 100) {

            int num = cur.getAmount() / 100;
            int remainder = cur.getAmount() % 100;

            System.out.println("Dispensing " + num + " 100 bills");

            if (remainder != 0 && chain != null) {
                chain.dispense(new Currency(remainder));
            }

        } else if (chain != null) {
            chain.dispense(cur);
        }
    }
}