package StructuralDesignPattern.AdapterPattern;

//Adapter for Razorpay
/**
 * 🔌 Adapter for Razorpay
 *
 * Implements the `PaymentGateway` interface
 * Wraps `RazorpayAPI`
 * Translates `payAmount()` → `sendAmount()`
 */
public class RazorpayAPIAdapter implements PaymentGateway {
    private final RazorpayAPI razorpay;

    public RazorpayAPIAdapter(RazorpayAPI razorpay){
        this.razorpay = razorpay;
    }
    @Override
    public void payAmount(double amount) {
        // Adapting the call from system format to Razorpay format
        razorpay.sendAmount(amount);
    }
}
