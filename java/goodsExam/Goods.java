package goodsExam;

class Goods {
    private String code;
    private String name;
    private int price;
    private String explain;

    Goods() {
    } //기본생성자

    Goods(String code, int price, String explain) {
        this.code = code;
        this.price = price;
        this.explain = explain;
    }

    Goods(String code, String name, int price, String explain) { // 생성자 오버로딩
        this(code, price, explain);
        this.name = name;
    }


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

    public int getPrice() {
        return price;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

}
