package goods;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GoodsMapper {
    public List<Goods> getGoods(@Param("gname") String gname);

    public void addGoods(Goods goods);

    public void setGoods(Goods goods);

    public int delGoods(String[] ids);
}
