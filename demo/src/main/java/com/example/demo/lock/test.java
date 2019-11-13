package com.example.demo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.UUID;

public class test {
    @Autowired
    private StringRedisTemplate redisTemplate;
    //商品详情
    private static HashMap<String, Integer> product = new HashMap();
    //订单表
    private static HashMap<String, String> orders = new HashMap();
    //库存表
    private static HashMap<String, Integer> stock = new HashMap();

    static {
        product.put("123", 10000);
        stock.put("123", 10000);
    }
    public String select_info(String product_id) {
        return "限量抢购商品XXX共" + product.get(product_id) + ",现在成功下单" + orders.size()
                + ",剩余库存" + stock.get(product_id) + "件";
    }


    /**
     * 高并发没问题，效率还行
     *
     * @param product_id
     * @return
     */
    public String order3(String product_id) throws Exception {
        /**
         * redis加锁
         */
        String value = System.currentTimeMillis() + 10000 + "";
        if (!lock3(product_id, value)) {
            //系统繁忙，请稍后再试
            throw new Exception();
        }
        //##############################业务逻辑#################################//
        if (stock.get(product_id) == 0) {
            return "活动已经结束了";
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(UUID.randomUUID()+"", product_id);
            stock.put(product_id, stock.get(product_id) - 1);
        }
        //##############################业务逻辑#################################//
        /**
         * redis解锁
         */
        unlock(product_id, value);
        return select_info(product_id);
    }
    /**
     * 加锁
     */
    public boolean lock3(String key, String value) {
        //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
        //即：在判断这个key是不是第一次进入这个方法
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            //第一次，即：这个key还没有被赋值的时候
            return true;
        }
        String current_value = redisTemplate.opsForValue().get(key);
        if (!current_value.equals("")
                //超时了
                && Long.parseLong(current_value) < System.currentTimeMillis()) {//①
            String old_value = redisTemplate.opsForValue().getAndSet(key, value);//②
            if (!old_value.equals("")
                    && old_value.equals(current_value)) {
                return true;
            }
        }
        return false;
    }
        //解锁
        public void unlock(String key, String value) {
            try {
                if (redisTemplate.opsForValue().get(key).equals(value)) {
                    redisTemplate.opsForValue().getOperations().delete(key);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) throws Exception {
        test t = new test();
        t.order3("123");
    }
}


