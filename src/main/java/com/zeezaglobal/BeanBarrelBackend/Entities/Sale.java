package com.zeezaglobal.BeanBarrelBackend.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Sale {

        @Id
        private int id;


        private Long billNumber;


        private int tokenNumber;

        private int status;


        private double totalAmount;


        private String dateTime;


        private String paymentMethod;




        private String customerName;


        private String customerEmail;


        private String customerPhone;
}