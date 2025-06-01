package com.softwares.service;

import com.softwares.models.Seller;
import com.softwares.models.SellerReport;

public interface SellerReportService {

    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);
}
