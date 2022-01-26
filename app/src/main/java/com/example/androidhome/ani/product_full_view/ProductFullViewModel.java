package com.example.androidhome.ani.product_full_view;

public class ProductFullViewModel {

        private String productID;
        private double grandTotal;


        public ProductFullViewModel(String productID, double grandTotal) {
            this.productID = productID;
            this.grandTotal = grandTotal;
        }

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }

        public double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(double grandTotal) {
            this.grandTotal = grandTotal;
        }
}

