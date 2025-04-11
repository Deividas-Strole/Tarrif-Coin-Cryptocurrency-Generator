import java.security.*;
import java.util.ArrayList;

public class Blockchain {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4; // Difficulty level
    public static KeyPairGenerator keyGen;

    public static void main(String[] args) {
        // Generate keys for Alice and Bob (RSA)
        try {
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);  // RSA key size of 2048 bits
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error initializing key generator: " + e.getMessage());
        }

        // Alice's key pair
        KeyPair aliceKeyPair = keyGen.generateKeyPair();
        PublicKey alicePublicKey = aliceKeyPair.getPublic();
        PrivateKey alicePrivateKey = aliceKeyPair.getPrivate();

        // Bob's key pair
        KeyPair bobKeyPair = keyGen.generateKeyPair();
        PublicKey bobPublicKey = bobKeyPair.getPublic();
        PrivateKey bobPrivateKey = bobKeyPair.getPrivate();

        // Create and mine the genesis block
        Block genesisBlock = new Block("0", "Genesis Block", "");
        System.out.println("Creating genesis block...");
        genesisBlock.mineBlock(difficulty);
        blockchain.add(genesisBlock);

        // Create a transaction from Alice to Bob
        String transaction = "Alice pays 50 coins to Bob";
        String transactionId = applySha256(transaction);

        // Create the second block with a transaction
        Block secondBlock = new Block(genesisBlock.hash, transaction, transactionId);
        System.out.println("Creating next block with transaction from Alice to Bob...");
        secondBlock.mineBlock(difficulty);
        blockchain.add(secondBlock);

        // Print blockchain
        System.out.println("\nBlockchain:");
        for (Block block : blockchain) {
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous: " + block.previousHash);
        }
    }

    // Apply Sha256 to a string and return the result
    public static String applySha256(String input) {
        return StringUtil.applySha256(input);
    }
}
