package us.supercheng.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.supercheng.app.entity.Greeting;

import java.util.List;

@RequestMapping("/api")
public interface IAPIController {

    String ENDPOINT_LOGIN = "/login";
    String ENDPOINT_FINDUSER = "/finduser";
    String ENDPOINT_REGISTER = "/register";
    String ENDPOINT_LIST_POSTS = "/listposts";
    String ENDPOINT_CREATE_POST = "/post";
    String ENDPOINT_READ_POST = ENDPOINT_CREATE_POST;
    String ENDPOINT_SAVE_POST = ENDPOINT_CREATE_POST;
    String ENDPOINT_TEST = "/test";

    // Tested
    @RequestMapping(method= RequestMethod.POST, value=ENDPOINT_LOGIN)
    public @ResponseBody
    Boolean login(@RequestParam(value="username") String username, @RequestParam(value="password") String password);

    @RequestMapping(method= RequestMethod.GET, value=ENDPOINT_FINDUSER)
    public @ResponseBody
    String findUser(@RequestParam(value="username") String username);

    // Tested
    @RequestMapping(method= RequestMethod.POST, value=ENDPOINT_REGISTER)
    public @ResponseBody
    Boolean register(@RequestParam(value="username") String username, @RequestParam(value="password") String password);

    // Tested
    @RequestMapping(method= RequestMethod.GET, value=ENDPOINT_LIST_POSTS)
    public @ResponseBody
    List<String> listPosts(@RequestParam(value="username", required=true) String username);

    // Tested
    @RequestMapping(method= RequestMethod.POST, value=ENDPOINT_CREATE_POST)
    public @ResponseBody
    Boolean createPost(@RequestParam(value="username") String username, @RequestParam(value="postname") String postname);

    // Tested
    @RequestMapping(method= RequestMethod.GET, value=ENDPOINT_READ_POST)
    public @ResponseBody
    String readPost(@RequestParam(value="username") String username, @RequestParam(value="postname") String postname);

    // Tested
    @RequestMapping(method= RequestMethod.PUT, value=ENDPOINT_SAVE_POST)
    public @ResponseBody
    Boolean savePost(@RequestParam(value="username") String username, @RequestParam(value="postname") String postname, @RequestParam(value="postcontent") String postcontent);

    // Tested
    @RequestMapping(method= RequestMethod.GET, value = "/test")
    abstract public @ResponseBody
    Greeting test(@RequestParam(value="name", required=false) String name);
}