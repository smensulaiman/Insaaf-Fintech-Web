package jp.insaaf.fintech.controller.view;

import jp.insaaf.fintech.data.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Random;

@ApiIgnore
@Controller
public class AuthenticationController {

    private String suraAyaatAr = " اَلَّذِیۡنَ یَاۡکُلُوۡنَ الرِّبٰوا لَا یَقُوۡمُوۡنَ اِلَّا کَمَا یَقُوۡمُ الَّذِیۡ یَتَخَبَّطُهُ الشَّیۡطٰنُ مِنَ الۡمَسِّ ؕ ذٰلِکَ بِاَنَّهُمۡ قَالُوۡۤا اِنَّمَا الۡبَیۡعُ مِثۡلُ الرِّبٰوا ۘ وَ اَحَلَّ اللّٰهُ الۡبَیۡعَ وَ حَرَّمَ الرِّبٰوا ؕ فَمَنۡ جَآءَهٗ مَوۡعِظَۃٌ مِّنۡ رَّبِّهٖ فَانۡتَهٰی فَلَهٗ مَا سَلَفَ ؕ وَ اَمۡرُهٗۤ اِلَی اللّٰهِ ؕ وَ مَنۡ عَادَ فَاُولٰٓئِکَ اَصۡحٰبُ النَّارِ ۚ هُمۡ فِیۡهَا خٰلِدُوۡنَ ﴿۲۷۵﴾";
    private String suraAyaatBn = "যারা সুদ খায়, তারা তার ন্যায় (কবর থেকে) উঠবে, যাকে শয়তান স্পর্শ করে পাগল বানিয়ে দেয়। এটা এ জন্য যে, তারা বলে, বেচা-কেনা সুদের মতই। অথচ আল্লাহ বেচা-কেনা হালাল করেছেন এবং সুদ হারাম করেছেন। অতএব, যার কাছে তার রবের পক্ষ থেকে উপদেশ আসার পর সে বিরত হল, যা গত হয়েছে তা তার জন্যই ইচ্ছাধীন। আর তার ব্যাপারটি আল্লাহর হাওলায়। আর যারা ফিরে গেল, তারা আগুনের অধিবাসী। তারা সেখানে স্থায়ী হবে। ";

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLogin(Model model){
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        model.addAttribute("suraAyaatAr", suraAyaatAr);
        model.addAttribute("suraAyaatBn", suraAyaatBn);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("user", new User());
        return "pages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession session, Model model){
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if (user.getEmail().equals("admin@insaaf.jp") && user.getPassword().equals("1234")) {
            session.setAttribute("loggedIn", true);
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "pages/login";
        }
    }

}
