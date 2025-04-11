import java.security.PrivateKey;
import java.security.PublicKey;

public class Transaction {

    private String transactionId; // Transaction ID
    private PublicKey sender; // Sender's public key
    private PublicKey recipient; // Recipient's public key
    private float amount; // Amount of coins to be transferred
    private byte[] signature; // Signature to verify the transaction

    // Constructor for the transaction
    public Transaction(PublicKey from, PublicKey to, float amount) {
        this.sender = from;
        this.recipient = to;
        this.amount = amount;
        this.transactionId = applySha256(from.toString() + to.toString() + Float.toString(amount));
    }

    // Generate the signature for the transaction (RSA)
    public void generateSignature(PrivateKey privateKey) {
        this.signature = StringUtil.applyRSASig(privateKey, this.transactionId);
    }

    // Verify the signature of the transaction (RSA)
    public boolean verifySignature(PublicKey publicKey) {
        return StringUtil.verifyRSASig(publicKey, this.transactionId, this.signature);
    }

    // Apply Sha256 to a string and return the result
    private static String applySha256(String input) {
        return StringUtil.applySha256(input);
    }
}
