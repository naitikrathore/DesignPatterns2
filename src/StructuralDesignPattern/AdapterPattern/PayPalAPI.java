package StructuralDesignPattern.AdapterPattern;

//Third-Party Class (Adaptees)
/**
 * Third-party payment SDK (incompatible interface)
 * You cannot change this class; it's from a vendor like PayPal.
 *
 * It doesn't match our app's expected method (`payAmount()`).
 */
public class PayPalAPI {
    public void pay(double money){
        System.out.println("Paid using PayPal: ₹" + money);
    }
}
