# Payment Service

## Overview
This project implements a simple Payment Service Provider (PSP) system that handles payment requests and simulates interactions with two payment acquirers based on BIN card number routing rules.

### Key Features
1. **API for Payment Processing**: Accepts payment details and processes transactions.
2. **Acquirer Routing**: Routes transactions to different acquirers based on BIN card number.
3. **Mock Acquirer Communication**: Simulates transaction approval or denial.
4. **In-memory Data Storage**: Stores transaction records in memory.
5. **Comprehensive Error Handling**: Validates inputs and manages common errors.

## Prerequisites
- **Java 17.0.7**
- **Maven 3.8.1** or higher
- **Docker**

## Getting Started

### Clone the Repository
Clone the repository to your local machine and navigate to the project directory:
```bash
git clone https://github.com/javiergold112/Java_task45.git
cd payment-service
