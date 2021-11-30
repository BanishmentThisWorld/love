package goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {
    // 20211130
    // id 编号  | gname | gprice | gbuyDate | gfell | createBy | createDate | updateBy | updateDate
    private String id; //编号
    private String gname; // 物品名称
    private String gprice; // 物品价格
    private String gbuyDate; // 物品购买时间
    private String gfell; // 物品购买感受
    private String createBy;
    private String createDate;
    private String updateBy;
    private String updateDate;
    private String delFlag; // 删除标志位

/*

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    public String getGbuyDate() {
        return gbuyDate;
    }

    public void setGbuyDate(String gbuyDate) {
        this.gbuyDate = gbuyDate;
    }

    public String getGfell() {
        return gfell;
    }

    public void setGfell(String gfell) {
        this.gfell = gfell;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", gname='" + gname + '\'' +
                ", gprice='" + gprice + '\'' +
                ", gbuyDate='" + gbuyDate + '\'' +
                ", gfell='" + gfell + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }*/
}
