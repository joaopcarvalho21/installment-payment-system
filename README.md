# installment-payment-system
---
# Sistema de Gerenciamento de Contratos

## Descrição
Sistema feito para estudos, Interfaces e tratamento de excessões: 
Este projeto implementa um sistema de gerenciamento de contratos que calcula os pagamentos de parcelas de um contrato usando serviços de pagamento online. Permite que os usuários criem contratos, especifiquem termos de pagamento e vejam as parcelas resultantes.

## Estrutura do Código

### Pacotes

- `application`: Contém a classe principal do programa, que inicia a aplicação e interage com o usuário.
- `entities`: Contém as classes que representam os objetos do domínio, como `Contract` e `Installment`.
- `services`: Contém as classes que realizam a lógica de negócios, incluindo `ContractService` e `PaypalService`.
- `exceptions`: (Se houver) Poderia conter classes personalizadas de exceção para tratamento de erros específicos.

### Classes e Métodos

1. **Program**
   - **Método main**: Este é o ponto de entrada do programa. Ele coleta informações do usuário, cria um contrato e processa as parcelas.
   - Exemplo de entrada do usuário:
     ```plaintext
     Entre os dados do contrato:
     Numero: 
     Data (dd/MM/yyyy): 
     Valor do contrato: 
     Entre com o numero de parcelas:
     ```

2. **Contract**
   - Representa um contrato, armazenando o número, a data e o valor total.
   - **Métodos principais**:
     - `getNumber()`, `getDate()`, `getTotalValue()`: Métodos de acesso para obter informações do contrato.
     - `getInstallments()`: Retorna a lista de parcelas associadas ao contrato.

3. **Installment**
   - Representa uma parcela de um contrato, incluindo a data de vencimento e o valor da parcela.
   - **Métodos principais**:
     - `getDueDate()`, `getAmount()`: Métodos de acesso para obter a data de vencimento e o valor da parcela.
     - `toString()`: Retorna uma representação em string da parcela, formatada como `dd/MM/yyyy - valor`.

4. **ContractService**
   - Realiza a lógica de processamento do contrato.
   - **Métodos principais**:
     - `processContract(Contract contract, int months)`: Calcula as parcelas do contrato com base na taxa e juros definidos pelo serviço de pagamento.
       - Divide o valor total do contrato pelo número de meses.
       - Para cada mês, calcula o valor da parcela incluindo taxas e juros e adiciona uma nova `Installment` à lista de parcelas.

5. **OnlinePaymentService**
   - Interface que define os métodos para serviços de pagamento.
   - **Métodos principais**:
     - `paymentFee(double amount)`: Calcula a taxa de pagamento.
     - `interest(double amount, int months)`: Calcula o interesse.

6. **PaypalService**
   - Implementa a interface `OnlinePaymentService` com cálculos específicos de taxas e juros.
   - **Constantes**:
     - `FEE_PERCENTAGE`: Representa a porcentagem da taxa.
     - `MONTHLY_INTEREST`: Representa a taxa de juros mensal.

## Funcionalidades

- Criar contratos com números, datas e valores totais especificados.
- Calcular pagamentos de parcelas, incluindo taxas e juros.
- Suporte para diferentes serviços de pagamento (por exemplo, PayPal).

## Requisitos

- Java 8 ou superior
- Um IDE ou editor de texto para executar o código (por exemplo, IntelliJ IDEA, Eclipse)

## Instalação

1. Clone este repositório:
   ```bash
   git clone https://github.com/seunome/contract-management-system.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd contract-management-system
   ```
3. Compile e execute o projeto no seu IDE ou linha de comando.

## Uso

### Exemplo

1. Execute o programa e insira os dados do contrato quando solicitado:
   ```plaintext
   Entre os dados do contrato:
   Numero: 123
   Data (dd/MM/yyyy): 15/10/2024
   Valor do contrato: 1200.00
   Entre com o numero de parcelas: 10
   ```
2. O programa calculará e exibirá as parcelas:
   ```plaintext
   Parcelas:
   15/11/2024 - 122.25
   15/12/2024 - 122.25
   ...
   ```


# Contract Management System

## Description
System made for studies, Interfaces and exception handling:
This project implements a contract management system that calculates installment payments for a contract using online payment services. The system allows users to create contracts, specify payment terms, and see the resulting installments.

## Code Structure

### Packages

- `application`: Contains the main class of the program, which starts the application and interacts with the user.
- `entities`: Contains classes representing domain objects, such as `Contract` and `Installment`.
- `services`: Contains classes that perform business logic, including `ContractService` and `PaypalService`.
- `exceptions`: (If any) Could contain custom exception classes for handling specific errors.

### Classes and Methods

1. **Program**
   - **main Method**: This is the entry point of the program. It collects user information, creates a contract, and processes the installments.
   - Example user input:
     ```plaintext
     Enter the contract data:
     Number: 
     Date (dd/MM/yyyy): 
     Contract Value: 
     Enter the number of installments:
     ```

2. **Contract**
   - Represents a contract, storing the number, date, and total value.
   - **Main Methods**:
     - `getNumber()`, `getDate()`, `getTotalValue()`: Accessor methods to retrieve contract information.
     - `getInstallments()`: Returns the list of installments associated with the contract.

3. **Installment**
   - Represents an installment of a contract, including the due date and the installment amount.
   - **Main Methods**:
     - `getDueDate()`, `getAmount()`: Accessor methods to retrieve the due date and the installment amount.
     - `toString()`: Returns a string representation of the installment, formatted as `dd/MM/yyyy - amount`.

4. **ContractService**
   - Performs the logic for processing the contract.
   - **Main Methods**:
     - `processContract(Contract contract, int months)`: Calculates the installments for the contract based on the fee and interest defined by the payment service.
       - Divides the total contract value by the number of months.
       - For each month, calculates the installment amount including fees and interest and adds a new `Installment` to the installments list.

5. **OnlinePaymentService**
   - Interface that defines methods for payment services.
   - **Main Methods**:
     - `paymentFee(double amount)`: Calculates the payment fee.
     - `interest(double amount, int months)`: Calculates the interest.

6. **PaypalService**
   - Implements the `OnlinePaymentService` interface with specific calculations for fees and interest.
   - **Constants**:
     - `FEE_PERCENTAGE`: Represents the fee percentage.
     - `MONTHLY_INTEREST`: Represents the monthly interest rate.

## Features

- Create contracts with specified numbers, dates, and total values.
- Calculate installment payments including fees and interests.
- Support for different payment services (e.g., PayPal).

## Requirements

- Java 8 or higher
- An IDE or text editor to run the code (e.g., IntelliJ IDEA, Eclipse)

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/contract-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd contract-management-system
   ```
3. Compile and run the project in your IDE or command line.

## Usage

### Example

1. Run the program, and input the contract data when prompted:
   ```plaintext
   Enter the contract data:
   Number: 123
   Date (dd/MM/yyyy): 15/10/2024
   Contract Value: 1200.00
   Enter the number of installments: 10
   ```
2. The program will calculate and display the installments:
   ```plaintext
   Installments:
   15/11/2024 - 122.25
   15/12/2024 - 122.25
   ...
   ```
