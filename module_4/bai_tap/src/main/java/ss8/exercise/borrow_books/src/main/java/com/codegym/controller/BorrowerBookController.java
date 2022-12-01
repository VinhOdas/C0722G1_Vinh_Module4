package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import com.codegym.service.IBorrowerBookService;
import com.codegym.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BorrowerBookController {
    @Autowired
    IBorrowerBookService borrowerBookService;
    @Autowired
    IOderService oderService;

    @GetMapping
    String showListBook(Model model) {
        List<Book> bookList = borrowerBookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/oder/{id}")
    String showOder(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model) {


        Optional<Book> book = borrowerBookService.findById(id);

        if (book.isPresent()) {

            Book bookATBC = book.get();
            bookATBC.setAmount(book.get().getAmount() - 1);
            if (!(book.get().getAmount() == -1)) {

            Oder oder = new Oder();
            int code = (int) (Math.random() * (99999 - 10000) + 10000);

            oder.setId(code);
            long millis = System.currentTimeMillis();

            oder.setBorrowedDate(new java.sql.Date(millis));
            String name = book.get().getNameBook();

            oder.setName(name);
//            oderService.save(oder);
                List<Oder> oderList = bookATBC.getList();
                oderList.add(oder);
                book.get().setList(oderList);
                borrowerBookService.save(bookATBC);
                redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công");
            }
            return "redirect:/";

        }
        return "book/list";


    }

    @GetMapping("/borrower")
    String showborrowerList(Model model) {
        List<Oder> oderList = oderService.findAllOder();
        model.addAttribute("oderList", oderList);
        return "book/borrower";
    }

}
