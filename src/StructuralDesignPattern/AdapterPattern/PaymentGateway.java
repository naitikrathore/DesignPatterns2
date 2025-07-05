package StructuralDesignPattern.AdapterPattern;

//Target of client
/**
 * Target Interface (what your system expects)
 * All payment providers must implement this interface.
 *
 * This ensures a unified way to process payments.
 */
public interface PaymentGateway {
    public void payAmount(double amount);
}
