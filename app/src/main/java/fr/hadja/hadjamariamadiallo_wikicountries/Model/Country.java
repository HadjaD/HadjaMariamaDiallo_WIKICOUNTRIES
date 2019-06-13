package fr.hadja.hadjamariamadiallo_wikicountries.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Country{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes=null;
    @SerializedName("capital")
    @Expose
    private String capital;

    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("population")
    @Expose
    private Integer population;

    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("numericCode")
    @Expose
    private String numericCode;

    private String flag;

    public String getName(){
            return name;
            }

    public void setName(String name){
            this.name=name;
            }


    public String getAlpha2Code(){
            return alpha2Code;
            }

    public void setAlpha2Code(String alpha2Code){
            this.alpha2Code=alpha2Code;
            }


    public List<String> getCallingCodes(){
            return callingCodes;
            }

    public void setCallingCodes(List<String> callingCodes){
            this.callingCodes=callingCodes;
            }

    public String getCapital(){
            return capital;
            }

    public void setCapital(String capital){
            this.capital=capital;
            }

    public String getRegion(){
            return region;
            }

    public void setRegion(String region){
            this.region=region;
            }

    public String getSubregion(){
            return subregion;
            }

    public void setSubregion(String subregion){
            this.subregion=subregion;
            }

    public Integer getPopulation(){
            return population;
            }

    public void setPopulation(Integer population){
            this.population=population;
            }

    public String getDemonym(){
            return demonym;
            }

    public void setDemonym(String demonym){
            this.demonym=demonym;
            }

    public Double getArea(){
            return area;
            }

    public void setArea(Double area){
            this.area=area;
            }


    public String getNumericCode(){
            return numericCode;
            }

    public void setNumericCode(String numericCode){
            this.numericCode=numericCode;
            }


    public String getFlag(){
            return flag;
            }

    public void setFlag(String flag){
            this.flag=flag;
            }
}


