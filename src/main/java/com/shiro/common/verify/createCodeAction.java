package com.shiro.common.verify;

import com.shiro.common.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The Class
 *验证码显示
 * @author ChenCH
 *         on 2017-08-08
 */
@Controller
public class createCodeAction {

    @RequestMapping("/PictureCheckCode")
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        //指定生成的响应图片,一定不能缺少这句话,否则错误.
        response.setContentType("image/jpeg");
        PictureCheckCode util = PictureCheckCode.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();

        request.getSession().setAttribute("randCheckCode", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "JPEG", response.getOutputStream());
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(HttpServletRequest request, HttpSession session) {
        String checkCode = request.getParameter("checkCode");
        checkCode=checkCode.toLowerCase();//不区分大小写
        String codeSession = (String) session.getAttribute("randCheckCode");
        codeSession=codeSession.toLowerCase();//不区分大小写
         if(codeSession.equals(checkCode)){
            return "success";
        }else{
            return "error";
        }
    }
}
