public class Block {
    public String hash;
    public String previousHash;
    private String transactionData;
    private String transactionId;
    private long timeStamp; // Timestamp when the block was created
    private int nonce; // A value used to mine the block

    // Constructor for the block, taking the previous hash and the transaction details
    public Block(String previousHash, String transactionData, String transactionId) {
        this.previousHash = previousHash;
        this.transactionData = transactionData;
        this.transactionId = transactionId;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash(); // Calculate hash immediately
    }

    // Calculate the block hash based on the block's content
    public String calculateHash() {
        String calculatedhash = applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + transactionData);
        return calculatedhash;
    }

    // Mine the block by finding a hash that starts with a certain number of zeros (difficulty)
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }

    // Return a string representation of the block with the transaction details
    @Override
    public String toString() {
        return "Transaction: " + transactionData + "\nTransaction ID: " + transactionId + "\nHash: " + hash + "\nPrevious Hash: " + previousHash + "\n";
    }

    // Apply Sha256 to a string and return the result
    public static String applySha256(String input) {
        return StringUtil.applySha256(input);
    }
}
