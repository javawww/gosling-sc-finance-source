package com.gosling.web.controller.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gosling.core.util.CommUtil;
import com.gosling.core.util.Constants;
import com.gosling.core.util.StringUtil;

/**
 * 生成校验验证码操作
 */
@Controller
public class VerifyController {

	/**
     * 验证码
     * @param request
     * @param response
     * @param name
     * @throws IOException
     */
    @RequestMapping(value = "verify.html",method = RequestMethod.GET)
    public void verify(HttpServletRequest request, HttpServletResponse response,
                       String name) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        HttpSession session = request.getSession(true);

        int width = 73;
        int height = 27;
        BufferedImage image = new BufferedImage(width, height, 1);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(100, 200));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Arial", 0, 24));

        g.setColor(getRandColor(200, 250));
        for (int i = 0; i < 188; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = CommUtil.randomInt(1).toUpperCase();
            sRand = sRand + rand;

            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110),
                20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 24);
        }
        if (StringUtil.isEmpty(name, true)) {
            session.setAttribute(Constants.VERIFY_NUMBER_NAME, sRand);
        } else {
            session.setAttribute(name, sRand);
        }
        g.dispose();
        ServletOutputStream responseOutputStream = response.getOutputStream();

        ImageIO.write(image, "JPEG", responseOutputStream);

        responseOutputStream.flush();
        responseOutputStream.close();
    }

    //给定范围获得随机颜色
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
