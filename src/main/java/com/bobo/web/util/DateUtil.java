package com.bobo.web.util;

import lombok.Data;

import java.util.Date;
import java.util.Vector;

@Data
public class DateUtil {

    public static Vector<Long> dateSubtraction(Date datePast, Date dateNow){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;

        // 获得两个时间的毫秒时间差异
        long time = dateNow.getTime() - datePast.getTime();

        // 计算差多少天
        long day = time / nd;
        // 计算差多少小时
        long hour = time % nd / nh;
        // 计算差多少分钟
        long min = time % nd % nh / nm;
        // 计算差多少秒
        long sec = time % nd % nh % nm / ns;

        Vector<Long> times = new Vector<>();
        times.add(day);
        times.add(hour);
        times.add(min);
        times.add(sec);

        return times;
    }
}
