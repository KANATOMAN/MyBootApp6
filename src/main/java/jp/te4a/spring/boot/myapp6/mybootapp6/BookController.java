package jp.te4a.spring.boot.myapp6.mybootapp6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "index";  // templates/index.html を返す（Thymeleafなど使用時）
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView postForm(
        @RequestParam("id") String id,
        @RequestParam("title") String title,
        @RequestParam("writter") String writter,
        @RequestParam("publisher") String publisher,
        @RequestParam("price") String price
    ) {
        ModelAndView mv = new ModelAndView("index");

        // 入力データを保存
        bookService.save(new BookBean(Integer.valueOf(id), title, writter, publisher, Integer.valueOf(price)));

        // データ表示用HTMLを生成
        StringBuilder buff = new StringBuilder();
        buff.append("<HR>");
        for (BookBean bean : bookService.findAll()) {
            buff.append("ID: ").append(bean.getId()).append("<BR>")
                .append("タイトル: ").append(bean.getTitle()).append("<BR>")
                .append("著者: ").append(bean.getWritter()).append("<BR>")
                .append("出版社: ").append(bean.getPublisher()).append("<BR>")
                .append("価格: ").append(bean.getPrice()).append("<BR><HR>");
        }

        mv.addObject("msg", buff.toString());
        return mv;
    }
}


