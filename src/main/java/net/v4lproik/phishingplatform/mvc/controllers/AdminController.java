package net.v4lproik.phishingplatform.mvc.controllers;

import net.v4lproik.phishingplatform.mvc.models.Status;
import net.v4lproik.phishingplatform.mvc.models.UserModel;
import net.v4lproik.phishingplatform.service.api.PhishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by v4lproik on 22/12/14.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Value("${phishingplatform.auth.cookie_name}")
    private String COOKIE_NAME;

    @Autowired
    private PhishingService phishingService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<UserModel> list() {
        final List<UserModel> result = phishingService.list();
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Status create(@RequestBody UserModel cmd) {
        try {
            final UserModel created = phishingService.create(cmd);
            return new Status(0, "User has been created " + cmd);
        } catch (Exception e) {
            return new Status(1, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public Status delete(@PathVariable(value = "id") Long id) {
        try {
            phishingService.delete(id);
            return new Status(0, "User with id=" + id.toString() + " has been deleted");
        } catch (Exception e) {
            return new Status(1, e.getMessage());
        }
    }
}
