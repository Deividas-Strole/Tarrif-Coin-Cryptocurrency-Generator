import java.security.*;
import java.util.ArrayList;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4; // Difficulty level
    public static KeyPairGenerator keyGen;

    public static void main(String[] args) {
        // Generate keys for Deividas and Wesley (RSA)
        try {
            keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);  // RSA key size of 2048 bits
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error initializing key generator: " + e.getMessage());
        }

        // Deividas's key pair
        KeyPair deividasKeyPair = keyGen.generateKeyPair();
        PublicKey deividasPublicKey = deividasKeyPair.getPublic();
        PrivateKey deividasPrivateKey = deividasKeyPair.getPrivate();

        // Wesley's key pair
        KeyPair wesleyKeyPair = keyGen.generateKeyPair();
        PublicKey wesleyPublicKey = wesleyKeyPair.getPublic();
        PrivateKey wesleyPrivateKey = wesleyKeyPair.getPrivate();

        // Create and mine the genesis block
        Block genesisBlock = new Block("0", "Genesis Block", "");
        System.out.println("Creating genesis block...");
        genesisBlock.mineBlock(difficulty);
        blockchain.add(genesisBlock);

        // Create a transaction from Deividas to Wesley (50 Tarrif-Coins)
        String transaction = "Deividas pays 50 coins to Wesley";
        String transactionId = applySha256(transaction);

        // Create the second block with the transaction
        Block secondBlock = new Block(genesisBlock.hash, transaction, transactionId);
        System.out.println("Creating next block with transaction from Deividas to Wesley...");
        secondBlock.mineBlock(difficulty);
        blockchain.add(secondBlock);

        // Print blockchain with transaction details
        System.out.println("\nBlockchain:");
        for (Block block : blockchain) {
            System.out.println(block);  // Using the toString() method for formatted output
        }
    }

    // Apply Sha256 to a string and return the result
    public static String applySha256(String input) {
        return StringUtil.applySha256(input);
    }
}
