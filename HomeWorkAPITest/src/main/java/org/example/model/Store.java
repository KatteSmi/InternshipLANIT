package org.example.model;

import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("id")
    private int id;

    @SerializedName("petId")
    private int petId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("shipDate")
    private  String shipDate;

    @SerializedName("status")
    private String status;

    @SerializedName("complete")
    private boolean complete;

    public Store() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "store {" +
                        "id = ='" + id + '\'' +
                        ",petId = '" + petId + '\'' +
                        ",quantity = '" + quantity + '\'' +
                        ",shipDate = '" + shipDate + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
