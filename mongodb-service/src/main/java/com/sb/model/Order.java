package com.sb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

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
    private String game;

    /**
     * cqssc, cq11x5 ...
     */
    private String kind;

    private String customer_id;

    /**
     * 期號
     */
    private long numero_start;

    private long numero_end;


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

    private List<String> selected;

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public long getNumero_start() {
        return numero_start;
    }

    public void setNumero_start(long numero_start) {
        this.numero_start = numero_start;
    }

    public long getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(long numero_end) {
        this.numero_end = numero_end;
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


}
