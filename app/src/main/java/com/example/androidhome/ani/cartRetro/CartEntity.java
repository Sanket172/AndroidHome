package com.example.androidhome.ani.cartRetro;

public class CartEntity {
    private String id;
    private String userEmail;
    private Double grandTotal;
    private CartProductEntity cartProduct;

    public CartEntity() {
    }

    public CartEntity(String id, String userEmail, Double grandTotal, CartProductEntity cartProduct) {
        this.id = id;
        this.userEmail = userEmail;
        this.grandTotal = grandTotal;
        this.cartProduct = cartProduct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public CartProductEntity getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(CartProductEntity cartProduct) {
        this.cartProduct = cartProduct;
    }
}
