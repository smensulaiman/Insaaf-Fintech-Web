package jp.insaaf.fintech.controller.view;

import jp.insaaf.fintech.data.entity.User;
import jp.insaaf.fintech.service.UserService;
import jp.insaaf.fintech.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@ApiIgnore
@Controller
@RequestMapping("/view/v1/user")
public class UserViewController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String viewAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/get-all-members")
    public String getAllUsers(Model model) {
        List<User> members = userService.getAllUsers();
        model.addAttribute("totalMembers", members.size());
        model.addAttribute("members", members);
        return "pages/members";
    }

    @GetMapping("/create-user")
    public String createMember(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "pages/add_member";
    }

    @PostMapping("/create-user")
    public String createMember(@ModelAttribute("user") User user, @RequestParam("image") MultipartFile multipartFile) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        user.setImageUrl(fileName);

        try {
            User savedUser = userService.createUser(user);
            String uploadDir = "user-photos/" + savedUser.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:get-all-members";
    }

}
