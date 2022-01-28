package ex0128.MVC;

public class Electronics {
    private int modelNo;
    private String modelName;
    private int modelPrice;
    private String modelDetail;

    public Electronics(){

    }

    public Electronics(int modelNo, String modelDetail){
        this.modelNo = modelNo;
        this.modelDetail = modelDetail;
    }

    public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail){
        this(modelNo, modelDetail);
        this.modelPrice = modelPrice;
        this.modelName = modelName;
    }

    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public void setModelPrice(int modelPrice){
        this.modelPrice = modelPrice;
    }

    public void setModelDetail(String modelDetail){
        this.modelDetail = modelDetail;
    }

    public int getModelNo(){
        return modelNo;
    }

    public String getModelName(){
        return modelName;
    }

    public int getModelPrice(){
        return modelPrice;
    }

    public String getModelDetail(){
        return modelDetail;
    }
}
