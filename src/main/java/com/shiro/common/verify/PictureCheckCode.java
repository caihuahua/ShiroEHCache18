package com.shiro.common.verify;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The Class
 *验证码生成
 * @author ChenCH
 *         on 2017-08-08
 */
public class PictureCheckCode  {
    private static char code[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();

    private BufferedImage image;// 图像
    private String str;// 验证码
    private PictureCheckCode() {
        init();// 初始化属性
    }

//     * 取得PictureCheckCode实例

    public static PictureCheckCode Instance() {
        return new PictureCheckCode();
    }

//     * 取得验证码图片

    public BufferedImage getImage() {
        return this.image;
    }

//     * 取得图片的验证码

    public String getString() {
        return this.str;
    }

    /*该方法主要作用是获得随机生成的颜色*/
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public void init() {
        int width=80,height=20;     //指定生成验证码的宽度和高度
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); //创建BufferedImage对象,其作用相当于一图片
        Graphics g=image.getGraphics();     //创建Graphics对象,其作用相当于画笔  获取图形上下文
        Random random=new Random();
        Font mfont=new Font("Times New Roman", Font.PLAIN, 18); //定义字体样式
        g.setColor(getRandColor(200,250));
        g.fillRect(0, 0, width, height);    //绘制背景
        g.setFont(mfont);                   //设置字体
        g.setColor(getRandColor(160,200));

        //绘制100条颜色和位置全部为随机产生的线条,该线条为2f
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        //输出由英文，数字，验证文字，具体的组合方式根据生成随机数确定。
        String sRand="";
        //制定输出的验证码为四位
        for(int i=0;i<4;i++){
            String rand=String.valueOf(code[random.nextInt(code.length)]);
            sRand+=rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 13 * i + 6, 16);
        }

        // 赋值验证码
        this.str = sRand;
        // 图象生效
        g.dispose();
        this.image = image; /*赋值图像 */
    }
}
