package model;

import java.time.LocalDateTime;

public class Contract implements Model {

    String contract_id;

    String contract_name;

    String customer_id_a;

    String customer_id_b;

    String contract_item_id;

    String product_amount;

    String activity_id;

    public Contract(String contract_id, String contract_name, String customer_id_a, String customer_id_b, String contract_item_id, String product_amount, String activity_id) {
        this.contract_id = contract_id;
        this.contract_name = contract_name;
        this.customer_id_a = customer_id_a;
        this.customer_id_b = customer_id_b;
        this.contract_item_id = contract_item_id;
        this.product_amount = product_amount;
        this.activity_id = activity_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getCustomer_id_a() {
        return customer_id_a;
    }

    public void setCustomer_id_a(String customer_id_a) {
        this.customer_id_a = customer_id_a;
    }

    public String getCustomer_id_b() {
        return customer_id_b;
    }

    public void setCustomer_id_b(String customer_id_b) {
        this.customer_id_b = customer_id_b;
    }

    public String getContract_item_id() {
        return contract_item_id;
    }

    public void setContract_item_id(String contract_item_id) {
        this.contract_item_id = contract_item_id;
    }

    public String getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(String product_amount) {
        this.product_amount = product_amount;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id='" + contract_id + '\'' +
                ", contract_name='" + contract_name + '\'' +
                ", customer_id_a='" + customer_id_a + '\'' +
                ", customer_id_b='" + customer_id_b + '\'' +
                ", contract_item_id='" + contract_item_id + '\'' +
                ", product_amount='" + product_amount + '\'' +
                ", activity_id='" + activity_id + '\'' +
                '}';
    }
}
