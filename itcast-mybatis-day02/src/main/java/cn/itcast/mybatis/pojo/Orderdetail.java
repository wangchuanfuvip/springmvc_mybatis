package cn.itcast.mybatis.pojo;

public class Orderdetail {
    
    private Integer id;
    
    private Integer itemId;
    
    private Item item;
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    
    

}
