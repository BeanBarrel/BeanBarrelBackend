package com.zeezaglobal.BeanBarrelBackend.Entities;




import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales", indexes = {
        @Index(columnList = "billNumber", unique = true)
})
public class Sale {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private Long billNumber;

        private int tokenNumber;

        private int status;

        private double totalAmount;

        private LocalDateTime dateTime;

        private String paymentMethod;

        // Customer details
        private String customerName;

        private String customerEmail;

        private String customerPhone;

        // Relationship with CartItem
        @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)

        private List<CartItem> items;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getBillNumber() {
                return billNumber;
        }

        public void setBillNumber(Long billNumber) {
                this.billNumber = billNumber;
        }

        public int getTokenNumber() {
                return tokenNumber;
        }

        public void setTokenNumber(int tokenNumber) {
                this.tokenNumber = tokenNumber;
        }

        public int getStatus() {
                return status;
        }

        public void setStatus(int status) {
                this.status = status;
        }

        public double getTotalAmount() {
                return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
        }

        public LocalDateTime getDateTime() {
                return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
                this.dateTime = dateTime;
        }

        public String getPaymentMethod() {
                return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public String getCustomerEmail() {
                return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
                this.customerEmail = customerEmail;
        }

        public String getCustomerPhone() {
                return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
                this.customerPhone = customerPhone;
        }

        public List<CartItem> getItems() {
                return items;
        }

        public void setItems(List<CartItem> items) {
                this.items = items;
        }
}

