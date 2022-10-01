package app.pack;

import org.springframework.stereotype.Component;

@Component
public class SafeDeposit {

    private Integer id;
    private Double USD;
    private Double EUR;
    private Double GBP;
    private Double GOLD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getEUR() {
        return EUR;
    }

    public void setEUR(Double EUR) {
        this.EUR = EUR;
    }

    public Double getGBP() {
        return GBP;
    }

    public void setGBP(Double GBP) {
        this.GBP = GBP;
    }

    public Double getGOLD() {
        return GOLD;
    }

    public void setGOLD(Double GOLD) {
        this.GOLD = GOLD;
    }

    public SafeDeposit()
    {

    }
    public SafeDeposit(Integer id, Double USD, Double EUR, Double GBP, Double GOLD)
    {
        this.id = id;
        this.USD = USD;
        this.EUR = EUR;
        this.GBP = GBP;
        this.GOLD = GOLD;

    }

    @Override
    public String toString()
    {
        return "safe:"+id+" "+USD+" "+EUR+" "+GBP+" "+GOLD;
    }

}
