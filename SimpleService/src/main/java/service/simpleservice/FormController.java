package service.simpleservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


@Controller
public class FormController {

    private String path = System.getProperty("user.dir");

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @GetMapping("/")
    public String getIndex(Model model) throws IOException {
//        System.out.println(path);

        File dir = new File(path);
        model.getAttribute("path");

        File[] roots = dir.listFiles();
        Roots Roots = new Roots();
        model.addAttribute("path", path);
        model.addAttribute("roots", roots);
        model.addAttribute("Roots", Roots);
        return "index";
    }

    @PostMapping("/")
    public String postPath(@RequestParam String root) {
        if (root.equals("back")){
            if (Paths.get(path).getParent() != null) {
                path = String.valueOf(Paths.get(path).getParent());
            }
        }else{
            path = path + "\\" + root;
        }
        return "redirect:/";
    }

}
