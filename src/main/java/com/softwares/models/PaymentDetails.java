package com.softwares.models;


import com.softwares.domain.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDetails {

    private String paymentId;

    private String psePaymentLinkId;

    private String psePaymentLinkReferenceId;

    private String psePaymentLinkStatus;

    private String psePaymentId;

    private PaymentStatus status;
}
