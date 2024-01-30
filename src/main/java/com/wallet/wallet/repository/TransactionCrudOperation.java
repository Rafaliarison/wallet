package com.wallet.wallet.repository;

import com.wallet.wallet.model.Account;
import com.wallet.wallet.model.Balance;
import com.wallet.wallet.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Data
@EqualsAndHashCode

public class TransactionCrudOperation implements CrudOperation<Transaction>{
    private final Connection connection;
    private Balance balance;
    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        return null;
    }

    @Override
    public Transaction save(Transaction toSave) {
        float amount = toSave.getTransactionAmount();
        float actualBalance = balance.getBalanceAmount();
        float newBalance;
        String sql = "INSERT INTO transaction (transaction_label, transaction_amount, transaction_type) VALUES(?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toSave.getTransactionLabel());
            statement.setFloat(2, toSave.getTransactionAmount());
            statement.setString(3, toSave.getTransactionType());
            if(toSave.getTransactionType() == "debit"){
                newBalance = actualBalance - amount;
                String update = "UPDATE balance SET balance_amount = ?";
                try(PreparedStatement statement1 = connection.prepareStatement(update)) {
                    statement.setFloat(1, newBalance);
                    statement.executeUpdate();
                }
            }else {
                newBalance = actualBalance + amount;
                String update = "UPDATE balance SET balance_amount = ?";
                try(PreparedStatement statement1 = connection.prepareStatement(update)) {
                    statement.setFloat(1, newBalance);
                    statement.executeUpdate();
                }
            }
            statement.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Transaction delete(Transaction toDelete) {
        return null;
    }
}
