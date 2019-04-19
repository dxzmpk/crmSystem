package sql;

import model.Contract;
import model.MyModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlExecuter {

    public static List<Contract> executeSelect(String condition){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/crm?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
                        "root", "dxzmpk");   // For MySQL only
                // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ) {
            // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
            System.out.println("The SQL statement is: " + condition + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(condition);
            List<Contract> contracts = new ArrayList<>();
            while (rset.next()){
                String contract_id = rset.getString("contract_id");

                String contract_name = rset.getString("contract_name");

                String customer_id_a = rset.getString("customer_id_a");

                String customer_id_b = rset.getString("customer_id_b");

                String contract_item_id = rset.getString("contract_item_id");

                String product_amount = rset.getString("product_amount");

                String activity_id = rset.getString("activity_id");

                contracts.add(new Contract(contract_id, contract_name,customer_id_a,
                        customer_id_b,contract_item_id,product_amount,activity_id));
            }
            return contracts;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean executeDelete(String condition){
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/crm?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
                        "root", "dxzmpk");   // For MySQL only
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("The SQL statement is: " + condition + "\n"); // Echo For debugging
            boolean result = stmt.execute(condition);
            return result;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public static List<Contract> executeGroup(String condition){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/crm?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8",
                        "root", "dxzmpk");   // For MySQL only
                // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ) {
            // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
            System.out.println("The SQL statement is: " + condition + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(condition);
            List<Contract> contracts = new ArrayList<>();
            while (rset.next()){
                String contract_id = rset.getString("contract_id");

                String contract_name = rset.getString("contract_name");

                String customer_id_a = rset.getString("customer_id_a");

                String customer_id_b = rset.getString("customer_id_b");

                contracts.add(new Contract(contract_id, contract_name,customer_id_a,
                        customer_id_b,null,null,null));
            }
            return contracts;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
