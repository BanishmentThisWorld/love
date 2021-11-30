package goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/goods")
@ResponseBody
@Controller
//@EnableAspectJAutoProxy
public class GoodsControl extends HandlerInterceptorAdapter implements HandlerInterceptor {


    @RequestMapping("add")
    public String addGoods(@RequestBody String jsonstr) {

        Map<String, Object> requestMap = JSONObject.parseObject(jsonstr);
        Map<String, Object> responseMap = new HashMap<>();
        if (requestMap.isEmpty()) {
            responseMap.put("code", 20000);
            responseMap.put("sysCode", "1111");
            responseMap.put("message", "请输入数据");
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        try {
            Goods goods = JSON.parseObject(JSON.toJSONString(requestMap.get("goods")), Goods.class);
            SqlSession session = MybatisUtils.getSqlSession();
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            mapper.addGoods(goods);
            MybatisUtils.commitAndClose(session);
        } catch (Exception error) {
            responseMap.put("code", 20000);
            responseMap.put("sysCode", "9999");
            responseMap.put("message", "数据格式错误");
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        responseMap.put("code", 20000);
        responseMap.put("sysCode", "0000");
        responseMap.put("message", "success");
        responseMap.put("data", "");
        return JSONObject.toJSONString(responseMap);
    }

    @RequestMapping("setById")
    public String setGoods(@RequestBody String jsonstr) {

        Map<String, Object> requestMap = JSONObject.parseObject(jsonstr);
        Map<String, Object> responseMap = new HashMap<>();
        if (requestMap.isEmpty()) {
            responseMap.put("sysCode", "1111");
            responseMap.put("message", "请输入数据");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        try {
            SqlSession session = MybatisUtils.getSqlSession();
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods goods = JSON.parseObject(JSON.toJSONString(requestMap.get("goods")), Goods.class);
            mapper.setGoods(goods);
            MybatisUtils.commitAndClose(session);

        } catch (Exception error) {
            responseMap.put("sysCode", "9999");
            responseMap.put("message", "数据格式错误");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        responseMap.put("sysCode", "0000");
        responseMap.put("message", "success");
        responseMap.put("code", 20000);
        responseMap.put("data", "");
        return JSONObject.toJSONString(responseMap);
    }

    @RequestMapping(value = "getByGName")
    public String getGoods(@RequestBody String jsonstr) {
        Map<String, Object> requestMap = JSONObject.parseObject(jsonstr);
        Map<String, Object> responseMap = new HashMap<>();
        if (requestMap != null && requestMap.isEmpty()) {
            responseMap.put("sysCode", "9999");
            responseMap.put("message", "请输入数据");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        try {
            Goods goods = JSON.parseObject(JSON.toJSONString(requestMap.get("goods")), Goods.class);
            SqlSession session = MybatisUtils.getSqlSession();
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            List<Goods> resGoods;
            if (goods == null || StringUtils.isEmpty(goods.getGname())) {
                resGoods = mapper.getGoods("");
            } else {
                resGoods = mapper.getGoods(goods.getGname());
            }
            MybatisUtils.commitAndClose(session);
            responseMap.put("data", resGoods);
            responseMap.put("sysCode", "0000");
            responseMap.put("message", "success");
            responseMap.put("code", 20000);
            return JSONObject.toJSONString(responseMap);
        } catch (Exception error) {
            responseMap.put("sysCode", "9999");
            responseMap.put("message", "数据格式错误");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }

    }

    @RequestMapping("delByIds")
    public String delGoods(@RequestBody String jsonstr) {

        Map<String, Object> requestMap = JSONObject.parseObject(jsonstr);
        Map<String, Object> responseMap = new HashMap<>();
        if (requestMap.isEmpty()) {
            responseMap.put("sysCode", "1111");
            responseMap.put("message", "请输入数据");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        try {
            SqlSession session = MybatisUtils.getSqlSession();
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods goods = JSON.parseObject(JSON.toJSONString(requestMap.get("goods")), Goods.class);
            String[] ids = goods.getId().split(",");
            mapper.delGoods(ids);
            MybatisUtils.commitAndClose(session);

        } catch (Exception error) {
            responseMap.put("sysCode", "9999");
            responseMap.put("message", "数据格式错误");
            responseMap.put("code", 20000);
            responseMap.put("data", "");
            return JSONObject.toJSONString(responseMap);
        }
        responseMap.put("sysCode", "0000");
        responseMap.put("message", "success");
        responseMap.put("code", 20000);
        responseMap.put("data", "");
        return JSONObject.toJSONString(responseMap);
    }

}
