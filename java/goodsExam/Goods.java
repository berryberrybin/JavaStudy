package goodsExam;

class Goods {
    private String code;
    private String name;
    private int price;
    private String explain;

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
    public String getExplain() {
        return explain;
    }

}
