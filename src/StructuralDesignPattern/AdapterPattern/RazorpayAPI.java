package StructuralDesignPattern.AdapterPattern;

//Third-Party Class (Adaptees)
/**
 * Another third-party payment SDK (Razorpay)
 * You cannot change this class; it's from a vendor like RazorPay.
 * This also has an incompatible method: `sendAmount()`
 */
public class RazorpayAPI {
    public void sendAmount(double rupees){
        System.out.println("Paid using Razorpay: ₹" + rupees);
    }
}
