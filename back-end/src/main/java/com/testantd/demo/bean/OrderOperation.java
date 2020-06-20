package com.testantd.demo.bean;

public class OrderOperation {

    private Boolean cancel;

    private Boolean delete;

    private Boolean pay;

    private Boolean confirm;

    private Boolean cancel_refund;

    public OrderOperation(Boolean cancel, Boolean delete, Boolean pay, Boolean confirm, Boolean cancel_refund) {
        this.cancel = cancel;
        this.delete = delete;
        this.pay = pay;
        this.confirm = confirm;
        this.cancel_refund = cancel_refund;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
    }

    public Boolean getCancel_refund() {
        return cancel_refund;
    }

    public void setCancel_refund(Boolean cancel_refund) {
        this.cancel_refund = cancel_refund;
    }

    @Override
    public String toString() {
        return "OrderOperation{" +
                "cancel=" + cancel +
                ", delete=" + delete +
                ", pay=" + pay +
                ", confirm=" + confirm +
                ", cancel_refund=" + cancel_refund +
                '}';
    }
}
