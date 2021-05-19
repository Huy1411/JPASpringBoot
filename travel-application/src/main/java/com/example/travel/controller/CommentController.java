package com.example.travel.controller;


import com.example.travel.jpa.Comment;
import com.example.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getComments(Model model) {
        Comment comment = new Comment();
        return findPaginated(1, model, comment);
    }

    @RequestMapping("show")
    public String getBookShow(Model model) {
        Comment comment = new Comment();
        return findPagShow(1, model, comment);
    }

    @RequestMapping("hidden")
    public String getBookHidden(Model model) {
        Comment comment = new Comment();
        return findPagHidden(1, model, comment);
    }

    @RequestMapping(path = "/saveComment", method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("commentNew") @Valid Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return findPagShow(1, model, comment);
        }
        boolean checkCommentName = commentService.checkCommentName(comment.getCommentName(), comment.getLocation().getLocationId(), comment.getCustomer().getCustomerId());
        if (checkCommentName == false) {
            return "redirect:/admin/comment?errorcommentname=Comment Name is existed";
        }
        comment.setCommentDate(new Date());
        boolean bl = commentService.saveComment(comment);
        if (bl) {
            return "redirect:/admin/comment/";
        }
        return "redirect:/admin/comment?error=Add New Comment Error";
    }

    @RequestMapping(path = "/editComment")
    public String editComment(@RequestParam("commentId") Integer commentId, Model model) {
        Comment comment = commentService.getCommentById(commentId);
        model.addAttribute("editComment", comment);
        return "admin/comment/editComment";
    }

    @RequestMapping(path = "/updateComment", method = RequestMethod.POST)
    public String updateComment(@ModelAttribute("editComment") Comment comment) {
        boolean checkCommentName = checkCommentName(comment.getCommentName(), comment.getCommentId(), comment.getLocation().getLocationId(), comment.getCustomer().getCustomerId());
        if (checkCommentName == false) {
            return "redirect:/admin/comment/editComment?id=" + comment.getCommentId() + "&&errorcommentname=Comment Name is existed";
        }
        boolean bl = commentService.updateComment(comment);
        if (bl) {
            return "redirect:/admin/comment/";
        }
        return "redirect:/admin/comment?error=Update Comment Error";

    }

    @RequestMapping(path = "/deleteComment")
    public String deleteComment(@RequestParam("commentId") Integer commentId) {
        boolean bl = commentService.deleteComment(commentId);
        if (bl) {
            return "redirect:/admin/comment/";
        }
        return "redirect:admin/comment?error=Delete Comment Error";
    }


    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        Page<Comment> page = commentService.findPaginated(pageNo, pageSize);
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        return "admin/comment/listComments";
    }

    @RequestMapping("/pageShow/{pageNo}")
    public String findPagShow(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        Page<Comment> page = commentService.findPaginatedShow(pageNo, pageSize);
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        return "admin/comment/listComments";
    }

    @RequestMapping("/pageHidden/{pageNo}")
    public String findPagHidden(@PathVariable(value = "pageNo") int pageNo, Model model, Comment comment) {
        int pageSize = 10;
        Page<Comment> page = commentService.findPaginatedHidden(pageNo, pageSize);
        List<Comment> comments = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("commentNew", comment);
        model.addAttribute("comments", comments);
        return "admin/comment/listComments";
    }

    public boolean checkCommentName(String commentName, int commentId, int locationId, int customerId) {
        Comment comment = commentService.getCommentById(commentId);
        boolean checkCommentName = commentService.checkCommentName(commentName, locationId, customerId);
        if (checkCommentName == false) {
            if (commentName.equals(comment.getCommentName())) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

}
