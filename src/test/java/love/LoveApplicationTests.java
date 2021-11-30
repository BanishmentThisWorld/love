package love;

import goods.Goods;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;


import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class LoveApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Goods goods = new Goods("1", "yc", "132", "2021-11-26", "还可以good", "yc", "2021-11-26", "yc", "2021-11-26", "0");
  /*      redisTemplate.opsForValue().set("goods",goods);
        redisTemplate.opsForValue().increment("num",-1);*/
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.openPipeline();
        connection.set("qw".getBytes(), "1".getBytes());
        connection.set("we".getBytes(), "2".getBytes());
        List<Object> resultList = connection.closePipeline();
        for (Object o : resultList) {
            System.out.println(o);
        }

      /*  Object goods1 = this.redisTemplate.opsForValue().get("goods");
        System.out.println(redisTemplate);
        if(goods1 instanceof Goods) {
            Goods g2 = (Goods)goods1;
            System.out.println(g2.getGfell());
        }*/

/*      Jedis封存
        Jedis jedis = new Jedis("192.168.1.114",6379);
        String auth = jedis.auth("123qwe!#@QWE");
        System.out.println(jedis.setex("idea",100,"从idea中增加值"));
        */

        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));

        //java采用类型擦除式泛型，下面两个编译时都不会报错
        //  泛型 ArrayList<String> 和 ArrayList<Integer> 是一种类型，所以上面的例子不报错
        ArrayList a = new ArrayList<String>(10);
        a.add(10);
        a.add("20");
        Object[] b = new String[10];
        b[0] = "30";
        // b[1] = 40 ; // 运行时报错 ArrayStoreException

    }

}
