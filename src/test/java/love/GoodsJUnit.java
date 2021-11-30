package love;

import com.alibaba.fastjson.JSONObject;
import goods.Goods;
import goods.GoodsMapper;
import goods.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsJUnit {


    @Test
    public void tt() {
        SqlSession session = MybatisUtils.getSqlSession();
        GoodsMapper mapper = session.getMapper(GoodsMapper.class);
/*        Goods goods1 = mapper.getGoods("啊哈");
        System.out.println(goods1.toString());*/
        Goods goods = new Goods();
        goods.setId("7");
        goods.setGname("行号");
        goods.setGfell("1qwe");
        goods.setGprice("33");
        goods.setGbuyDate("2021-03-01");
        goods.setCreateDate("2021-03-03");
        goods.setUpdateDate("2021-03-02");
        goods.setCreateBy("yc");
        goods.setUpdateBy("ycc");
        //mapper.setGoods(goods);
        List<Goods> goods1;
        goods1 = mapper.getGoods("");
        System.out.println(goods1.toString());
        MybatisUtils.commitAndClose(session);
    }
  /*  @Test
    public void  goodsTest(){
        Goods goods = new Goods();
        goods.setId("123");
        goods.setGname("行号");
        goods.setGfell("1qwe");
        goods.setGprice("33");
        goods.setGbuyDate("2021-03-01");
        goods.setCreateDate("2021-03-03");
        goods.setUpdateDate("2021-03-02");
        goods.setCreateBy("yc");
        goods.setUpdateBy("ycc");
        Map<String,Object> goodsMap = new HashMap<>();
        goodsMap.put("goods",goods);
        goodsMapper.addGoods(goods);
        goodsMapper.setGoods(goods);
        Goods goods1 = goodsMapper.getGoods("2");
        System.out.println(goods1);


    }*/
}
