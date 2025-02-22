package com.pluralsight.models.contracts;

import com.pluralsight.models.Vehicle;

public class SalesContract extends Contract {
    private final double SALES_TAX;
    private final double RECORDING_FEE;
    private final double PROCESSING_FEE; // 295 for under 10k
    private boolean finance;

    public SalesContract(String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(customerName, customerEmail, vehicleSold);
        this.SALES_TAX = 0.05 * totalPrice;
        this.RECORDING_FEE = 100;
        this.PROCESSING_FEE = vehicleSold.getPrice() > 10000 ? 495 : 295;
        this.finance = finance;

    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public double getMonthlyPayment() {
        /*if(finance) {
            final double BELOW_10K = 24;
            final double ABOVE_10K = 48;
            final double PRICE = super.totalPrice;
            return PRICE > 10000 ? this.getTotalPrice() / ABOVE_10K : this.getTotalPrice() / BELOW_10K ;
        } else return 0;*/
        final double BELOW_10K_RATE = 0.0525;
        final double ABOVE_10K_RATE = 0.0425;
        final double BELOW_10K = 24;
        final double ABOVE_10K = 48;
        final double PRICE = super.totalPrice;
        final double FEES = RECORDING_FEE + SALES_TAX + PROCESSING_FEE;

        return isFinance() ? (PRICE > 10000 ? emi_calculator(PRICE, ABOVE_10K_RATE, ABOVE_10K) : emi_calculator(PRICE, BELOW_10K_RATE, BELOW_10K)) : (PRICE + FEES);
    }
    @Override
    public double getTotalPrice() {
        final double BELOW_10K = 24;
        final double ABOVE_10K = 48;
        final double PRICE = super.totalPrice;
        final double FEES = RECORDING_FEE + SALES_TAX + PROCESSING_FEE;

        return isFinance() ? (PRICE > 10000 ? (this.getMonthlyPayment() * ABOVE_10K) + FEES : (this.getMonthlyPayment() * BELOW_10K) + FEES) : (PRICE + FEES);
    }
}
