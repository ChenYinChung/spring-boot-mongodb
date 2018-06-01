package com.sb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sammy
 * @Date: 2018/5/30 23:39
 * @Description:
 */
@Document(collection = "order")
public class Order implements Serializable {
    private static final long serialVersionUID = 7272304916414695630L;
    @Id
    private String id;

    /**
     * ssc, 11x5 ...
     */
    @Indexed
    private String game;

    /**
     * cqssc, cq11x5 ...
     */
    @Indexed
    private String kind;

    private String customerId;

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 期號
     */

    @Indexed
    private String numero;

    /**
     *
     */
    private String betting_slip;

    /**
     * 追中
     */
    private boolean chase;

    /**
     * 出號
     */
    private boolean aborting;

    private List<String> line0;
    private List<String> line1;
    private List<String> line2;
    private List<String> line3;
    private List<String> line4;

    public List<String> getLine1() {
        return line1;
    }

    public void setLine1(List<String> line1) {
        this.line1 = line1;
    }

    public List<String> getLine2() {
        return line2;
    }

    public void setLine2(List<String> line2) {
        this.line2 = line2;
    }

    public List<String> getLine3() {
        return line3;
    }

    public void setLine3(List<String> line3) {
        this.line3 = line3;
    }

    public List<String> getLine4() {
        return line4;
    }

    public void setLine4(List<String> line4) {
        this.line4 = line4;
    }

    public List<String> getLine0() {
        return line0;
    }

    public void setLine0(List<String> line0) {
        this.line0 = line0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBetting_slip() {
        return betting_slip;
    }

    public void setBetting_slip(String betting_slip) {
        this.betting_slip = betting_slip;
    }

    public boolean isChase() {
        return chase;
    }

    public void setChase(boolean chase) {
        this.chase = chase;
    }

    public boolean isAborting() {
        return aborting;
    }

    public void setAborting(boolean aborting) {
        this.aborting = aborting;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
