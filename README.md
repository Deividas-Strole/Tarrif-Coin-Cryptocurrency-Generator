# Tarrif-Coin 💰 — A Simple Java-Based Cryptocurrency

Tarrif-Coin is a basic blockchain app written in Java to demonstrate how a cryptocurrency might work under the hood. Inspired by Bitcoin and educational blockchain projects, this codebase includes key components such as blocks, mining, hashing, and a simple wallet system using RSA cryptography. This project is great for learning about blockchain technology and cryptography fundamentals.

## 🚀 Features

- ⛓️ Basic Blockchain with Hash Linking  
- 🔒 RSA-based Wallets (2048-bit keys)  
- 🧾 Simple Transactions (e.g., “Deividas pays 50 coins to Wesley”)  
- ⛏️ Proof-of-Work Mining with Adjustable Difficulty  
- 🧠 SHA-256 Hashing  
- 🔧 Easily Extendable for More Complex Features  

## 🧱 How It Works

Each Block contains:

- Transaction data (e.g., sender, receiver, amount)
- Transaction hash (as a unique ID)
- A link to the previous block hash
- A hash of its own (after mining)
- A nonce (for mining difficulty)

Mining is based on Proof-of-Work: the miner must find a nonce such that the resulting block hash starts with a predefined number of zeros.

Example Block Output:

Transaction: Deividas pays 50 coins to Wesley Transaction ID: a8d88b02cd4cb4134dbe56b900ebf0606e5fc0a01b1cce2b3b7d4b44fbd7db77 Hash: 0000f4c49df9bc5a46ac3e74fa317fa20b0c1f10fc750af084779fc7c7b051a7 Previous Hash: 000019854b2388c1e442067de9063fdaca2660a5ffad4d5e9be7cf35d8b107eb


## 🛠️ Requirements

- Java 17 or later (tested on JDK 22)
- IDE or text editor (e.g., IntelliJ, Eclipse, VSCode)

## 📦 Project Structure

- src/
  - Block.java → Defines the structure and mining logic of a block
  - StringUtil.java → SHA-256 hashing utility
  - NoobChain.java → Main entry point that simulates the blockchain
  - Wallet.java → RSA KeyPair generation
- bin/ → Compiled class files

## 🧪 Running the Project

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/Tarrif-Coin.git
   cd Tarrif-Coin

2. Compile:
   javac -d bin src/*.java

3. Run:
  java -cp bin NoobChain

## 📄 License

This project is licensed under the MIT License.

## Built with ☕ by Deividas



   
