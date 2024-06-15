package com.example.rectangledb.controllers;

import com.example.rectangledb.models.RectangleRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.rectangledb.models.Rectangle;

@Controller
public class RectanglesController {

    @Autowired
    private RectangleRepository rectangleRepo;

    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {
        System.out.println("Getting all rectangles");
        // get all rectangles from database
        List<Rectangle> rectangles = rectangleRepo.findAll();
        // end of database call
        model.addAttribute("rec", rectangles);
        return "showAll";
    }

    /**
     * Get specific rectangle by Iud
     * 
     * @param rectangleIud Iud of rectangle
     * @param response
     * @return redirects to showRectangle.html
     */
    @GetMapping("rectangles/get/{rectangleIud}")
    public String getRectangle(@PathVariable("rectangleIud") int rectangleIud, Model model,
            HttpServletResponse response) {
        Rectangle rectangle = rectangleRepo.getById(rectangleIud);
        if (rectangle != null) {
            model.addAttribute("rec1", rectangle);
        }
        response.setStatus(206);
        return "showRectangle";
    }

    /**
     * Add a rectangle to the database
     * 
     * @param newrec Data of new rectangle
     * @param response
     * @return redirects to add.html
     */
    @PostMapping("/rectangles/add")
    public String addRectangle(@Valid @ModelAttribute Rectangle rectangle, BindingResult result,
            HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.rectangle", result); // keep errors on this page
            redirectAttributes.addFlashAttribute("rectangle", rectangle);
            return "add"; 
        }
        System.out.println("ADD rectangle");
        rectangleRepo.save(rectangle);
        response.setStatus(201);
        return "redirect:/add.html";
    }

    /**
     * Method sends you to edit rectangle page along with Rectangle uid
     * @param rectangleIud
     * @param model
     * @param response
     * @return
     */
    @GetMapping("/rectangles/edit/{rectangleIud}")
    public String showEditRectangleForm(@PathVariable("rectangleIud") int rectangleIud, Model model, HttpServletResponse response) {
        Rectangle rectangle = rectangleRepo.getById(rectangleIud);
        if (rectangle != null) {
            model.addAttribute("rec1", rectangle);
            return "editRectangle"; // return the view for editing the rectangle
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "redirect:/rectangles/view";
        }
    }

    /**
     * This method edits the rectangle by uid
     * @param rectangle
     * @param result
     * @param response
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/rectangles/edit")
    public String editRectangle(@Valid @ModelAttribute Rectangle rectangle, BindingResult result, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            redirectAttributes.addFlashAttribute("errors", result); // keeps errors for this page
            redirectAttributes.addFlashAttribute("rec1", rectangle); // keep this object in this page
            return "redirect:/rectangles/edit/" + rectangle.getUid(); // return the view for editing the rectangle
        }
        System.out.println("EDIT rectangle");
        System.out.println(rectangle.getUid());
        rectangleRepo.save(rectangle); // edits the rectangle
        response.setStatus(HttpServletResponse.SC_OK);
        return "redirect:/rectangles/view";
    }

    /**
     * Delete rectangle by Iud
     * 
     * @param rectangleIud Iud of rectangle
     * @param response
     * @return redirects to showAll.html with updated table
     */
    @DeleteMapping("/rectangles/delete/{rectangleIud}")
    public String deleteRectangle(@PathVariable int rectangleIud, HttpServletResponse response) {
        System.out.println(rectangleIud);
        if (rectangleRepo.existsById(rectangleIud)) {
            rectangleRepo.deleteById(rectangleIud); // deletes the rectangle
        }
        response.setStatus(204);
        return "redirect:/rectangles/view";
    }
}
