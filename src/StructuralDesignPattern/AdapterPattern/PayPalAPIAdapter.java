package StructuralDesignPattern.AdapterPattern;

//Adapter for PayPalService
/**
 * 🔌 Adapter for PayPal
 *
 * Implements the `PaymentGateway` interface (Target)
 * Internally uses `PayPalAPI` (Adaptee)
 * Translates `payAmount()` → `pay()`
 */
public class PayPalAPIAdapter implements PaymentGateway{
    private final PayPalAPI payPal;

    public PayPalAPIAdapter(PayPalAPI payPal){
        this.payPal = payPal;
    }
    @Override
    public void payAmount(double amount) {
        // Adapting the call to match our expected interface
        payPal.pay(amount);
    }
}
