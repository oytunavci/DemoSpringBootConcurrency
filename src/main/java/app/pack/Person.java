package app.pack;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {


    private List<SafeDeposit> safeDepositAccessList;
    private String name;
    private Double totalAssetInUSD;

    public List<SafeDeposit> getSafeDepositAccessList() {
        return safeDepositAccessList;
    }

    public void setSafeDepositAccessList(List<SafeDeposit> safeDepositAccessList) {
        this.safeDepositAccessList = safeDepositAccessList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalAssetInUSD() {
        return totalAssetInUSD;
    }

    public void setTotalAssetInUSD(Double totalAssetInUSD) {
        this.totalAssetInUSD = totalAssetInUSD;
    }


    public Person()
    {

    }
    public Person(String namex, List<SafeDeposit> safeDepositAccessList )
    {
        setName(namex);
        setSafeDepositAccessList(safeDepositAccessList);
        setTotalAssetInUSD(totalAssetInUSD);
    }

    @Override
    public String toString()
    {
        String s1= "person:"+name+" ";

        for(SafeDeposit x: this.getSafeDepositAccessList())
        {
            s1 = s1 +" "+ x.getId();
        }


        return s1;
    }


}
